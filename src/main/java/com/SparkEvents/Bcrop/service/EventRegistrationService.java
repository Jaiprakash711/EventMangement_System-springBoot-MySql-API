package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.EventRegistration;
import com.SparkEvents.Bcrop.repository.EventRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventRegistrationService {

    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    // Save a new event registration
    public EventRegistration saveEventRegistration(EventRegistration eventRegistration) {
        return eventRegistrationRepository.save(eventRegistration);
    }

    // Get all event registrations
    public List<EventRegistration> getAllEventRegistrations() {
        return eventRegistrationRepository.findAll();
    }

    // Get an event registration by ID
    public Optional<EventRegistration> getEventRegistrationById(Integer registrationId) {
        return eventRegistrationRepository.findById(registrationId);
    }

    // Update an event registration
    public EventRegistration updateEventRegistration(Integer registrationId, EventRegistration eventRegistration) {
        if (eventRegistrationRepository.existsById(registrationId)) {
            eventRegistration.setRegistrationId(registrationId);
            return eventRegistrationRepository.save(eventRegistration);
        } else {
            throw new RuntimeException("Event registration not found with id " + registrationId);
        }
    }

    // Delete an event registration
    public boolean deleteEventRegistration(Integer registrationId) {
        if (eventRegistrationRepository.existsById(registrationId)) {
            eventRegistrationRepository.deleteById(registrationId);
            return true;
        } else {
            return false;
        }
    }
}
