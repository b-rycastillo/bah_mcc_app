package com.bah.mcc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.app.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
