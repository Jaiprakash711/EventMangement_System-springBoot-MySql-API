package com.SparkEvents.Bcrop.model;

import java.io.Serializable;
import java.util.Objects;

public class EventAttendanceId implements Serializable {
    private Integer eventId;
    private Integer participantId;

    public EventAttendanceId() {
    }

    public EventAttendanceId(Integer eventId, Integer participantId) {
        this.eventId = eventId;
        this.participantId = participantId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventAttendanceId that = (EventAttendanceId) o;
        return Objects.equals(eventId, that.eventId) &&
                Objects.equals(participantId, that.participantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, participantId);
    }
}
