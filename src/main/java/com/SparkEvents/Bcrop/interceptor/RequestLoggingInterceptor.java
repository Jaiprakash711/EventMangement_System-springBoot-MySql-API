package com.SparkEvents.Bcrop.interceptor;

import com.SparkEvents.Bcrop.model.RequestLog;
import com.SparkEvents.Bcrop.service.RequestLogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    @Autowired
    private RequestLogService requestLogService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        RequestLog requestLog = new RequestLog();
        requestLog.setHttpMethod(request.getMethod());
        requestLog.setUri(request.getRequestURI());

        // Setting the plain message based on the operation
        String message = getPlainMessage(request);
        //requestLog.setMessage(message);

        requestLog.setStatusCode(response.getStatus());
        requestLogService.saveRequestLog(requestLog);
    }

    public RequestLogService getRequestLogService() {
        return requestLogService;
    }

    public void setRequestLogService(RequestLogService requestLogService) {
        this.requestLogService = requestLogService;
    }

    private String getPlainMessage(HttpServletRequest request) {
        String method = request.getMethod();
        String uri = request.getRequestURI();

        if (method.equals("POST")) {
            if (uri.contains("/api/organizers")) {
                return "Organizer has been created.";
            } else if (uri.contains("/api/events")) {
                return "Event has been created.";
            } else if (uri.contains("/api/participants")) {
                return "Participant has been created.";
            }
        } else if (method.equals("PUT")) {
            if (uri.contains("/api/organizers")) {
                return "Organizer has been updated.";
            } else if (uri.contains("/api/events")) {
                return "Event has been updated.";
            } else if (uri.contains("/api/participants")) {
                return "Participant has been updated.";
            }
        } else if (method.equals("DELETE")) {
            if (uri.contains("/api/organizers")) {
                return "Organizer has been deleted.";
            } else if (uri.contains("/api/events")) {
                return "Event has been deleted.";
            } else if (uri.contains("/api/participants")) {
                return "Participant has been deleted.";
            }
        } else if (method.equals("GET")) {
            if (uri.contains("/api/organizers")) {
                return "Fetched organizer information.";
            } else if (uri.contains("/api/events")) {
                return "Fetched event information.";
            } else if (uri.contains("/api/participants")) {
                return "Fetched participant information.";
            }
        }

        return "Operation performed.";
    }
}
