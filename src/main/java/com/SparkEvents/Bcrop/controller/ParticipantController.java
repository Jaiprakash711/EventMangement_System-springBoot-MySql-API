package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.Participant;
import com.SparkEvents.Bcrop.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    // Create a new participant
    @PostMapping
    public ResponseEntity<?> createParticipant(@RequestBody Participant participant) {
        Participant savedParticipant = participantService.saveParticipant(participant);
        return ResponseEntity.ok().body(new ApiResponse("Participant created successfully", savedParticipant));
    }

    // Get all participants
    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants() {
        List<Participant> participants = participantService.getAllParticipants();
        return ResponseEntity.ok().body(participants);
    }

    // Get a participant by ID
    @GetMapping("/{participant_id}")
    public ResponseEntity<?> getParticipantById(@PathVariable("participant_id") Integer participantId) {
        Optional<Participant> participant = participantService.getParticipantById(participantId);
        return participant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a participant
    @PutMapping("/{participant_id}")
    public ResponseEntity<?> updateParticipant(@PathVariable("participant_id") Integer participantId, @RequestBody Participant participant) {
        Participant updatedParticipant = participantService.updateParticipant(participantId, participant);
        return ResponseEntity.ok().body(new ApiResponse("Participant updated successfully", updatedParticipant));
    }

    // Delete a participant
    @DeleteMapping("/{participant_id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable("participant_id") Integer participantId) {
        boolean deleted = participantService.deleteParticipant(participantId);
        if (deleted) {
            return ResponseEntity.ok().body(new ApiResponse("Participant deleted successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
