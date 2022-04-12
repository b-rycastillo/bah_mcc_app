package com.bah.mcc.app.Registrations;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationsAPI {
	ArrayList<Registrations> registrationsList = new ArrayList<Registrations>();
	public RegistrationsAPI() {
		Registrations r1 = new Registrations(1, 1, 1, "2019-01-01", "looking forward to the event");
		Registrations r2 = new Registrations(2, 2, 2, "2019-01-01", "looking forward to the event");
		Registrations r3 = new Registrations(3, 3, 3, "2019-01-01", "looking forward to the event");
		Registrations r4 = new Registrations(4, 4, 4, "2019-01-01", "looking forward to the event");
		Registrations r5 = new Registrations(5, 5, 5, "2019-01-01", "looking forward to the event");
		Registrations r6 = new Registrations(6, 6, 6, "2019-01-01", "looking forward to the event");
		Registrations r7 = new Registrations(7, 7, 7, "2019-01-01", "looking forward to the event");
		Registrations r8 = new Registrations(8, 8, 8, "2019-01-01", "looking forward to the event");
		
		registrationsList.add(r1);
		registrationsList.add(r2);
		registrationsList.add(r3);
		registrationsList.add(r4);
		registrationsList.add(r5);
		registrationsList.add(r6);
		registrationsList.add(r7);
		registrationsList.add(r8);
		
		
		
	}
	@GetMapping
	public Collection<Registrations> getAll(){
		return this.registrationsList;
	}
	@GetMapping("/id/{registrationsId}")
	public Registrations getRegistrationsById(@PathVariable("registrationsId") long id){
		Registrations registrations = null;
		for(int i =0;i<registrationsList.size();i++) {
			if(registrationsList.get(i).getId()==id) {
				registrations=registrationsList.get(i);
			}
		}
		return registrations;
	}
}
