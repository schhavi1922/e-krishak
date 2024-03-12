package com.ekrishak.userservice.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse {
    private Integer status;

    private String message;

    private Object response;

    @JsonIgnore
    private String handlerUrl;

    public BaseResponse set(Integer status,String message,Object response) {
        this.status = status;
        this.message = message;
        this.response = response;
        return this;
    }

    public BaseResponse set(Integer status,String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    public BaseResponse setInternalServerError() {
        this.status = 500;
        this.message = "Internal Server Error";
        this.response = null;
        return this;
    }

    public BaseResponse setSomethingWentWrong() {
        this.status = 302;
        this.message = "Something went wrong. Please try later";
        this.response = null;
        return this;
    }

    public BaseResponse setUnauthorized() {
        this.status = 403;
        this.message = "Unauthorised Access";
        this.response = null;
        return this;
    }

    public BaseResponse setTemporaryDown() {
        this.status = 302;
        this.message = "We are unable to process your request currently. Kindly check after sometime.";
        this.response = null;
        return this;
    }
}
