package com.SparkEvents.Bcrop.repository;

import com.SparkEvents.Bcrop.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
