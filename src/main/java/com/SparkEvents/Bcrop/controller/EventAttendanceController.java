package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.EventAttendance;
import com.SparkEvents.Bcrop.service.EventAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events/{eventId}/attendance")
public class EventAttendanceController {

    @Autowired
    private EventAttendanceService eventAttendanceService;

    // Mark attendance for a participant
    @PostMapping
    public ResponseEntity<?> markAttendance(@PathVariable Integer eventId, @RequestBody EventAttendance eventAttendance) {
        eventAttendance.setEventId(eventId);
        EventAttendance savedAttendance = eventAttendanceService.saveEventAttendance(eventAttendance);
        return ResponseEntity.ok().body(new ApiResponse("Attendance marked successfully", savedAttendance));
    }

    // Get all attendance records for an event
    @GetMapping
    public ResponseEntity<List<EventAttendance>> getAllAttendance(@PathVariable Integer eventId) {
        List<EventAttendance> attendances = eventAttendanceService.getAllAttendanceByEventId(eventId);
        return ResponseEntity.ok().body(attendances);
    }

    // Get attendance record by eventId and participantId
    @GetMapping("/participants/{participantId}")
    public ResponseEntity<?> getAttendanceById(@PathVariable Integer eventId, @PathVariable Integer participantId) {
        Optional<EventAttendance> attendance = eventAttendanceService.getAttendanceById(eventId, participantId);
        return attendance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update attendance record
    @PutMapping("/participants/{participantId}")
    public ResponseEntity<?> updateAttendance(@PathVariable Integer eventId, @PathVariable Integer participantId, @RequestBody EventAttendance eventAttendance) {
        EventAttendance updatedAttendance = eventAttendanceService.updateAttendance(eventId, participantId, eventAttendance);
        return ResponseEntity.ok().body(new ApiResponse("Attendance updated successfully", updatedAttendance));
    }

    // Delete attendance record
    @DeleteMapping("/participants/{participantId}")
    public ResponseEntity<?> deleteAttendance(@PathVariable Integer eventId, @PathVariable Integer participantId) {
        boolean deleted = eventAttendanceService.deleteAttendance(eventId, participantId);
        if (deleted) {
            return ResponseEntity.ok().body(new ApiResponse("Attendance deleted successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
