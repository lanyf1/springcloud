package com.microservice.store.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseResult<T> {
  private String status;
  private String message;
  private T data;
  private long timestamp;

  public static <T> ResponseResult<T> success() {
    return success(null);
  }

  public static <T> ResponseResult<T> success(String message, T data) {
    return ResponseResult.<T>builder().data(data).message(message)
        .status(HttpResponseStatus.SUCCESS.getResponseCode()).timestamp(System.currentTimeMillis())
        .build();
  }

  public static <T> ResponseResult<T> success(T data) {
    return ResponseResult.<T>builder().data(data)
        .message(HttpResponseStatus.SUCCESS.getDescription())
        .status(HttpResponseStatus.SUCCESS.getResponseCode()).timestamp(System.currentTimeMillis())
        .build();
  }

  public static <T extends Serializable> ResponseResult<T> fail(String message) {
    return fail(null, message);
  }

  public static <T> ResponseResult<T> fail(T data, String message) {
    return ResponseResult.<T>builder().data(data).message(message)
        .status(HttpResponseStatus.FAIL.getResponseCode()).timestamp(System.currentTimeMillis())
        .build();
  }

  public static <T> ResponseResult<T> fail(T data, HttpResponseStatus responseStatus) {
    return ResponseResult.<T>builder().data(data).message(responseStatus.getDescription())
        .status(responseStatus.getResponseCode()).timestamp(System.currentTimeMillis()).build();
  }
}
