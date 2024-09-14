package com.SparkEvents.Bcrop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "eventsummary")
public class EventSummary {
    @Id
    private Integer eventId;
    private String name;
    private Integer totalParticipantsCount;
    private Integer participantsPresentCount;
    private Integer participantsAbsentCount;
    private Double totalRevenue;

    // Getters and Setters

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalParticipantsCount() {
        return totalParticipantsCount;
    }

    public void setTotalParticipantsCount(Integer totalParticipantsCount) {
        this.totalParticipantsCount = totalParticipantsCount;
    }

    public Integer getParticipantsPresentCount() {
        return participantsPresentCount;
    }

    public void setParticipantsPresentCount(Integer participantsPresentCount) {
        this.participantsPresentCount = participantsPresentCount;
    }

    public Integer getParticipantsAbsentCount() {
        return participantsAbsentCount;
    }

    public void setParticipantsAbsentCount(Integer participantsAbsentCount) {
        this.participantsAbsentCount = participantsAbsentCount;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
