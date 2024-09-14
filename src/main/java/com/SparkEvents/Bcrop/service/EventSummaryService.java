package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.EventSummary;
import com.SparkEvents.Bcrop.repository.EventAttendanceRepository;
import com.SparkEvents.Bcrop.repository.EventRegistrationRepository;
import com.SparkEvents.Bcrop.repository.EventRepository;
import com.SparkEvents.Bcrop.repository.EventSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventSummaryService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventAttendanceRepository eventAttendanceRepository;

    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    @Autowired
    private EventSummaryRepository eventSummaryRepository;

    public EventSummary getEventSummary(Integer eventId) {
        // Fetch event details
        var event = eventRepository.findById(eventId).orElse(null);
        if (event == null) {
            return null;
        }

        // Calculate total participants
        int totalParticipantsCount = eventRegistrationRepository.countByEventId(eventId);

        // Calculate participants present
        int participantsPresentCount = eventAttendanceRepository.countByEventIdAndStatus(eventId, 1);

        // Calculate participants absent
        int participantsAbsentCount = totalParticipantsCount - participantsPresentCount;

        // Calculate total revenue
        double totalRevenue = totalParticipantsCount * event.getTicketPrice();

        // Create EventSummary object
        EventSummary eventSummary = new EventSummary();
        eventSummary.setEventId(eventId);
        eventSummary.setName(event.getName());
        eventSummary.setTotalParticipantsCount(totalParticipantsCount);
        eventSummary.setParticipantsPresentCount(participantsPresentCount);
        eventSummary.setParticipantsAbsentCount(participantsAbsentCount);
        eventSummary.setTotalRevenue(totalRevenue);

        // Save the summary to the EventSummary table
        eventSummaryRepository.save(eventSummary);

        return eventSummary;
    }
}
