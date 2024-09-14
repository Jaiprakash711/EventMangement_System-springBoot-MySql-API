package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.Participant;
import com.SparkEvents.Bcrop.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    // Save a new participant
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    // Get all participants
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Get a participant by ID
    public Optional<Participant> getParticipantById(Integer participantId) {
        return participantRepository.findById(participantId);
    }

    // Update a participant
    public Participant updateParticipant(Integer participantId, Participant participant) {
        if (participantRepository.existsById(participantId)) {
            participant.setParticipantId(participantId);
            return participantRepository.save(participant);
        } else {
            throw new RuntimeException("Participant not found with id " + participantId);
        }
    }

    // Delete a participant
    public boolean deleteParticipant(Integer participantId) {
        if (participantRepository.existsById(participantId)) {
            participantRepository.deleteById(participantId);
            return true;
        } else {
            return false;
        }
    }
}
