package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.EventAttendance;
import com.SparkEvents.Bcrop.model.EventAttendanceId;
import com.SparkEvents.Bcrop.repository.EventAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventAttendanceService {

    @Autowired
    private EventAttendanceRepository eventAttendanceRepository;

    // Save a new event attendance
    public EventAttendance saveEventAttendance(EventAttendance eventAttendance) {
        return eventAttendanceRepository.save(eventAttendance);
    }

    // Get all attendance records for an event
    public List<EventAttendance> getAllAttendanceByEventId(Integer eventId) {
        return eventAttendanceRepository.findByEventId(eventId);
    }

    // Get an attendance record by eventId and participantId
    public Optional<EventAttendance> getAttendanceById(Integer eventId, Integer participantId) {
        return eventAttendanceRepository.findById(new EventAttendanceId(eventId, participantId));
    }

    // Update an attendance record
    public EventAttendance updateAttendance(Integer eventId, Integer participantId, EventAttendance eventAttendance) {
        if (eventAttendanceRepository.existsById(new EventAttendanceId(eventId, participantId))) {
            eventAttendance.setEventId(eventId);
            eventAttendance.setParticipantId(participantId);
            return eventAttendanceRepository.save(eventAttendance);
        } else {
            throw new RuntimeException("Attendance record not found with eventId " + eventId + " and participantId " + participantId);
        }
    }

    // Delete an attendance record
    public boolean deleteAttendance(Integer eventId, Integer participantId) {
        EventAttendanceId id = new EventAttendanceId(eventId, participantId);
        if (eventAttendanceRepository.existsById(id)) {
            eventAttendanceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public EventAttendanceRepository getEventAttendanceRepository() {
        return eventAttendanceRepository;
    }

    public void setEventAttendanceRepository(EventAttendanceRepository eventAttendanceRepository) {
        this.eventAttendanceRepository = eventAttendanceRepository;
    }
}
