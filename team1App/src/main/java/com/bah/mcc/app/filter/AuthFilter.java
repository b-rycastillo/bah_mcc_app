package com.bah.mcc.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bah.mcc.app.jwt.JWTHelper;
import com.bah.mcc.app.logging.ApiLogger;



@Component
@Order(1)
public class AuthFilter implements Filter{

	//public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private String auth_scope = "com.webage.auth.apis";
	private String api_scope = "com.webage.data.apis";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// get authorization header
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		
		// for development purposes
		// allow turning off auth checking with header tokencheck:false
		String tokenheader = req.getHeader("tokencheck");
		if( tokenheader != null && !tokenheader.equalsIgnoreCase("true") ) {
			chain.doFilter(request, response);
			return;		
		}
		
		// auth checking will not apply to these cases
		// token endpoint
		// user register endpoint
		// healthcheck endpoint on '/api/'
		if(   !uri.startsWith("/api/events") 
	       && !uri.startsWith("/api/registrations")
	       && !uri.equals("/api/customers")
	       ) {
			chain.doFilter(request, response);
			return;			
		}else{
			// check JWT token
			String authheader = req.getHeader("authorization");
			if(authheader != null && authheader.length() > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				if(JWTHelper.verifyToken(jwt_token)) {
					String request_scopes = JWTHelper.getScopes(jwt_token);
					if(request_scopes.contains(api_scope) || request_scopes.contains(auth_scope)) {
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}		
		// continue
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ApiLogger.log("AuthFilter.init");
		
	}

	@Override
	public void destroy() {
		ApiLogger.log("AuthFilter.destroy");	
	}

	/*
	 * public boolean verifyToken(String token) { try {
	 * Jwts.parser().setSigningKey(key).parseClaimsJws(token); return true; } catch
	 * (JwtException e) { return false; } }
	 * 
	 * public String getScopes(String token) { try { Claims claims =
	 * Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody(); String
	 * scopes = claims.get("scopes", String.class); return scopes; } catch
	 * (JwtException e) { return null; } }
	 */	
	
}
