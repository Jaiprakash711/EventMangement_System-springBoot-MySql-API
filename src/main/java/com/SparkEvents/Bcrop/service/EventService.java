package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.Event;
import com.SparkEvents.Bcrop.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Save a new event
    public Event saveEvent(Event event) {
        if (event.getTimestamp() == null) {
            event.setTimestamp(LocalDateTime.now());
        }
        return eventRepository.save(event);
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get an event by ID
    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    // Update an event
    public Event updateEvent(Integer eventId, Event event) {
        if (eventRepository.existsById(eventId)) {
            event.setEventId(eventId);
            event.setTimestamp(LocalDateTime.now()); // Update timestamp
            return eventRepository.save(event);
        } else {
            throw new RuntimeException("Event not found with id " + eventId);
        }
    }

    // Delete an event
    public boolean deleteEvent(Integer eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
            return true;
        } else {
            return false;
        }
    }
}
