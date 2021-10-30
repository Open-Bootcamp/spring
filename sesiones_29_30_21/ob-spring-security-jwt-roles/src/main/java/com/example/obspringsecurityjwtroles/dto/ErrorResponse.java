package com.example.obspringsecurityjwtroles.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime date;

    public ErrorResponse(){}

    public ErrorResponse(Integer status, String message, LocalDateTime date) {
        this.status = status;
        this.message = message;
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public ErrorResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ErrorResponse setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
