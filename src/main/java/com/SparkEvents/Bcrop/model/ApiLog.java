//package com.SparkEvents.Bcrop.model;
//import jakarta.persistence.*;
//
//import java.sql.Timestamp;
//
//@Entity
//@Table(name = "api_logs")
//public class ApiLog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer log_id;
//    private Timestamp timestamp;
//    private String http_method;
//    private String endpoint;
//    private String request_payload;
//    private Integer response_status;
//    private String response_payload;
//    private Float duration;
//    private String ip_address;
//
//    public Integer getLog_id() {
//        return log_id;
//    }
//
//    public void setLog_id(Integer log_id) {
//        this.log_id = log_id;
//    }
//
//    public Timestamp getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Timestamp timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getHttp_method() {
//        return http_method;
//    }
//
//    public void setHttp_method(String http_method) {
//        this.http_method = http_method;
//    }
//
//    public String getEndpoint() {
//        return endpoint;
//    }
//
//    public void setEndpoint(String endpoint) {
//        this.endpoint = endpoint;
//    }
//
//    public String getRequest_payload() {
//        return request_payload;
//    }
//
//    public void setRequest_payload(String request_payload) {
//        this.request_payload = request_payload;
//    }
//
//    public Integer getResponse_status() {
//        return response_status;
//    }
//
//    public void setResponse_status(Integer response_status) {
//        this.response_status = response_status;
//    }
//
//    public String getResponse_payload() {
//        return response_payload;
//    }
//
//    public void setResponse_payload(String response_payload) {
//        this.response_payload = response_payload;
//    }
//
//    public Float getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Float duration) {
//        this.duration = duration;
//    }
//
//    public String getIp_address() {
//        return ip_address;
//    }
//
//    public void setIp_address(String ip_address) {
//        this.ip_address = ip_address;
//    }
//// Getters and Setters
//}
