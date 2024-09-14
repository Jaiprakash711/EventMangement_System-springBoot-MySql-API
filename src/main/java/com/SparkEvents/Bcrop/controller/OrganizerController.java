package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.Organizer;
import com.SparkEvents.Bcrop.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @PostMapping
    public ResponseEntity<?> createOrganizer(@RequestBody Organizer organizer) {
        Organizer savedOrganizer = organizerService.saveOrganizer(organizer);
        return ResponseEntity.ok().body(new ApiResponse("Organizer created successfully", savedOrganizer));
    }

    @GetMapping
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        List<Organizer> organizers = organizerService.getAllOrganizers();
        return ResponseEntity.ok().body(organizers);
    }

    @GetMapping("/{organizer_id}")
    public ResponseEntity<?> getOrganizerById(@PathVariable("organizer_id") Integer organizerId) {
        Optional<Organizer> organizer = organizerService.getOrganizerById(organizerId);
        return organizer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{organizer_id}")
    public ResponseEntity<?> updateOrganizer(@PathVariable("organizer_id") Integer organizerId, @RequestBody Organizer organizer) {
        Organizer updatedOrganizer = organizerService.updateOrganizer(organizerId, organizer);
        return ResponseEntity.ok().body(new ApiResponse("Organizer updated successfully", updatedOrganizer));
    }

    @DeleteMapping("/{organizer_id}")
    public ResponseEntity<?> deleteOrganizer(@PathVariable("organizer_id") Integer organizerId) {
        boolean deleted = organizerService.deleteOrganizer(organizerId);
        if (deleted) {
            return ResponseEntity.ok().body(new ApiResponse("Organizer deleted successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
