package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.Organizer;
import com.SparkEvents.Bcrop.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer saveOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Optional<Organizer> getOrganizerById(Integer organizerId) {
        return organizerRepository.findById(organizerId);
    }

    public Organizer updateOrganizer(Integer organizerId, Organizer organizer) {
        if (organizerRepository.existsById(organizerId)) {
            organizer.setOrganizerId(organizerId);
            organizer.setTimestamp(new Timestamp(System.currentTimeMillis())); // Ensure timestamp is updated
            return organizerRepository.save(organizer);
        } else {
            throw new RuntimeException("Organizer not found with id " + organizerId);
        }
    }

    public boolean deleteOrganizer(Integer organizerId) {
        if (organizerRepository.existsById(organizerId)) {
            organizerRepository.deleteById(organizerId);
            return true;
        } else {
            return false;
        }
    }
}
