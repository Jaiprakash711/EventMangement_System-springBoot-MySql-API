package com.SparkEvents.Bcrop.repository;

import com.SparkEvents.Bcrop.model.EventAttendance;
import com.SparkEvents.Bcrop.model.EventAttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventAttendanceRepository extends JpaRepository<EventAttendance, EventAttendanceId> {

    List<EventAttendance> findByEventId(Integer eventId);

    @Query("SELECT COUNT(e) FROM EventAttendance e WHERE e.eventId = :eventId AND e.status = :status")
    Integer countByEventIdAndStatus(@Param("eventId") Integer eventId, @Param("status") Integer status);

    @Query("SELECT COUNT(e) FROM EventAttendance e WHERE e.eventId = :eventId")
    Integer countByEventId(@Param("eventId") Integer eventId);
}
