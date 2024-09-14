package com.SparkEvents.Bcrop.repository;

import com.SparkEvents.Bcrop.model.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Integer> {
}
