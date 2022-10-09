package com.stdev.AgileWay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdev.AgileWay.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
