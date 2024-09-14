package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.EventRegistration;
import com.SparkEvents.Bcrop.service.EventRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event-registrations")
public class EventRegistrationController {

    @Autowired
    private EventRegistrationService eventRegistrationService;

    // Register a participant for an event
    @PostMapping
    public ResponseEntity<?> registerParticipantForEvent(@RequestBody EventRegistration eventRegistration) {
        EventRegistration savedRegistration = eventRegistrationService.saveEventRegistration(eventRegistration);
        return ResponseEntity.ok().body(new ApiResponse("Participant registered for event successfully", savedRegistration));
    }

    // Get all event registrations
    @GetMapping
    public ResponseEntity<List<EventRegistration>> getAllEventRegistrations() {
        List<EventRegistration> registrations = eventRegistrationService.getAllEventRegistrations();
        return ResponseEntity.ok().body(registrations);
    }

    // Get an event registration by ID
    @GetMapping("/{registration_id}")
    public ResponseEntity<?> getEventRegistrationById(@PathVariable("registration_id") Integer registrationId) {
        Optional<EventRegistration> registration = eventRegistrationService.getEventRegistrationById(registrationId);
        return registration.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an event registration
    @PutMapping("/{registration_id}")
    public ResponseEntity<?> updateEventRegistration(@PathVariable("registration_id") Integer registrationId, @RequestBody EventRegistration eventRegistration) {
        EventRegistration updatedRegistration = eventRegistrationService.updateEventRegistration(registrationId, eventRegistration);
        return ResponseEntity.ok().body(new ApiResponse("Event registration updated successfully", updatedRegistration));
    }

    // Delete an event registration
    @DeleteMapping("/{registration_id}")
    public ResponseEntity<?> deleteEventRegistration(@PathVariable("registration_id") Integer registrationId) {
        boolean deleted = eventRegistrationService.deleteEventRegistration(registrationId);
        if (deleted) {
            return ResponseEntity.ok().body(new ApiResponse("Event registration deleted successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
