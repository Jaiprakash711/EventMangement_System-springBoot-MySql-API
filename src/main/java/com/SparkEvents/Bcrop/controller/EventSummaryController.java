package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.EventSummary;
import com.SparkEvents.Bcrop.service.EventSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventSummaryController {

    @Autowired
    private EventSummaryService eventSummaryService;

    @GetMapping("/{eventId}/summary")
    public ResponseEntity<EventSummary> getEventSummary(@PathVariable Integer eventId) {
        EventSummary eventSummary = eventSummaryService.getEventSummary(eventId);
        return ResponseEntity.ok(eventSummary);
    }
}
