package com.sinar12.barbershop.dto;

import com.sinar12.barbershop.model.User;

public class UserResponse {

    private boolean success;
    private String message;
    private User data;

    // Constructors, getters, setters
    public UserResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
