package com.example.myproject.models;

import java.util.Date;

public class TaskExecution {
    private String executionId;
    private String status;
    private Date timestamp;

    public TaskExecution(String executionId, String status, Date timestamp) {
        this.executionId = executionId;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getExecutionId() { return executionId; }
    public String getStatus() { return status; }
    public Date getTimestamp() { return timestamp; }
}
