package com.pfe.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
public class ApiResponse {
    private String message;
    private boolean status;
    public ApiResponse(String string, boolean b) {
        // TODO Auto-generated constructor stub
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}