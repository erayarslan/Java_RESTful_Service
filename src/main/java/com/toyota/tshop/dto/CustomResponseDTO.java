package com.toyota.tshop.dto;

@SuppressWarnings("unused")
public class CustomResponseDTO {
    private String message;

    public CustomResponseDTO() {
    }

    public CustomResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
