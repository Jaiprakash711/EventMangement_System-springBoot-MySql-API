package com.SparkEvents.Bcrop.controller;

import com.SparkEvents.Bcrop.model.RequestLog;
import com.SparkEvents.Bcrop.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class RequestLogController {

    @Autowired
    private RequestLogService requestLogService;

    @GetMapping
    public ResponseEntity<List<RequestLog>> getAllLogs() {
        List<RequestLog> logs = requestLogService.getAllLogs();
        return ResponseEntity.ok().body(logs);
    }

    public RequestLogService getRequestLogService() {
        return requestLogService;
    }

    public void setRequestLogService(RequestLogService requestLogService) {
        this.requestLogService = requestLogService;
    }
// Other methods to filter logs by criteria can be added
}
