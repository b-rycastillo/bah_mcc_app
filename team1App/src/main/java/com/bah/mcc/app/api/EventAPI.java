package com.bah.mcc.app.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.app.domain.Event;
import com.bah.mcc.app.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventAPI {
	@Autowired
	EventRepository repo;

	@GetMapping
	public Iterable<Event> getAll() {
		//  Workshop:  Implement a method to retrieve all events
		return null;
	}

	@GetMapping("/{eventId}")
	public Optional<Event> getEventById(@PathVariable("eventId") long id) {
		//  Workshop:  Implement a method to retrieve a single event by it's ID
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		//  Workshop:  Implement a method to create a new event in response to a POST message.
		//  Think about how you ensure that the event is properly formed.
		return null;
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(
			@RequestBody Event newEvent,
			@PathVariable("eventId") long eventId) 
	{
		//  Workshop:  Implement a method to update an entitye in response to a PUT message.
		return null;
	}	
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteEventById(@PathVariable("eventId") long id) {
		//  Workshop:  Implement a method to delete an entity. 
		return null;
	}	
	
}
