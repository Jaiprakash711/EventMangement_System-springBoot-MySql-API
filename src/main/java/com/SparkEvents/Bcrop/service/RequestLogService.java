package com.SparkEvents.Bcrop.service;

import com.SparkEvents.Bcrop.model.RequestLog;
import com.SparkEvents.Bcrop.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestLogService {

    @Autowired
    private RequestLogRepository requestLogRepository;

    public RequestLog saveRequestLog(RequestLog requestLog) {
        return requestLogRepository.save(requestLog);
    }

    public List<RequestLog> getAllLogs() {
        return requestLogRepository.findAll();
    }

    public RequestLogRepository getRequestLogRepository() {
        return requestLogRepository;
    }

    public void setRequestLogRepository(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }
// Other methods if needed
}
