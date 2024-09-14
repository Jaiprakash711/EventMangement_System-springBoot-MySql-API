package com.SparkEvents.Bcrop.repository;

import com.SparkEvents.Bcrop.model.EventSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventSummaryRepository extends JpaRepository<EventSummary, Integer> {
}
