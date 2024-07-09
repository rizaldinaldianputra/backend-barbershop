package com.sinar12.barbershop.dto;

import com.sinar12.barbershop.model.Store;

public class StoreResponse {

    private boolean success;
    private String message;
    private Store data;

    // Constructors, getters, setters
    public StoreResponse() {
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

    public Store getData() {
        return data;
    }

    public void setData(Store data) {
        this.data = data;
    }
}
