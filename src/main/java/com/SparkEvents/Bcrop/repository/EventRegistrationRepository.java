package com.SparkEvents.Bcrop.repository;

import com.SparkEvents.Bcrop.model.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Integer> {

    @Query("SELECT COUNT(e) FROM EventRegistration e WHERE e.eventId = :eventId")
    Integer countByEventId(@Param("eventId") Integer eventId);
}
