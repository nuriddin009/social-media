package com.social.socialmedia.payload.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@JsonPropertyOrder({
        "message",
        "localDateTime",
        "responseData",
        "responseDataList"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    @JsonIgnore
    private Boolean success;
    private String message;
    private LocalDateTime timeStamp;
    private T responseData;
    private Collection<T> responseDataList;

    public BaseResponse() {
        this.success = true;
        this.message = "Success";
        this.timeStamp = LocalDateTime.now();
    }

    public BaseResponse(Boolean success, T responseData) {
        this.success = success;
        this.responseData = responseData;
    }

    public BaseResponse(Boolean success, String message, T responseData, Collection<T> responseDataList) {
        this.success = success;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.responseData = responseData;
        this.responseDataList = responseDataList;
    }

    public BaseResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static <T> BaseResponse<T> successResponse(T data) {
        return new BaseResponse<>(true, data);
    }

    public static <T> BaseResponse<T> errorResponse(String message) {
        return new BaseResponse<>(false, message);
    }


}