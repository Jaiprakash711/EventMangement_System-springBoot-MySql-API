package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.Event;
import com.SparkEvents.Bcrop.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok().body(new ApiResponse("Event created successfully", savedEvent));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<?> getEventById(@PathVariable("event_id") Integer eventId) {
        Optional<Event> event = eventService.getEventById(eventId);
        return event.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{event_id}")
    public ResponseEntity<?> updateEvent(@PathVariable("event_id") Integer eventId, @RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return ResponseEntity.ok().body(new ApiResponse("Event updated successfully", updatedEvent));
    }

    @DeleteMapping("/{event_id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("event_id") Integer eventId) {
        boolean deleted = eventService.deleteEvent(eventId);
        if (deleted) {
            return ResponseEntity.ok().body(new ApiResponse("Event deleted successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
