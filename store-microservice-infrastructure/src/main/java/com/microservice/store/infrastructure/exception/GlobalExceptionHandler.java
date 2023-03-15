package com.microservice.store.infrastructure.exception;

import com.microservice.store.infrastructure.response.HttpResponseStatus;
import com.microservice.store.infrastructure.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//  @InitBinder
//  public void handleInitBinder(WebDataBinder dataBinder) {
//    dataBinder.registerCustomEditor(Date.class,
//        new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
//  }

  @ResponseBody
  @ExceptionHandler(Exception.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseResult<Exception> processException(Exception exception) {
    log.error(exception.getLocalizedMessage(), exception);
    return ResponseResult.fail(null, HttpResponseStatus.HTTP_STATUS_500.getDescription());
  }

  @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseResult<ExceptionData> handleParameterVerificationException(Exception e) {
    ExceptionData.ExceptionDataBuilder exceptionDataBuilder = ExceptionData.builder();
    log.error("Exception: ", e);
    if (e instanceof BindException) {
      BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
      bindingResult.getAllErrors()
          .forEach(a -> exceptionDataBuilder.error(((FieldError) a).getField() + ": " + a.getDefaultMessage()));
    } else if (e instanceof ConstraintViolationException) {
      if (e.getMessage() != null) {
        exceptionDataBuilder.error(e.getMessage());
      }
    } else {
      exceptionDataBuilder.error("invalid parameter");
    }
    return ResponseResult.fail(exceptionDataBuilder.build(), HttpResponseStatus.HTTP_STATUS_400);
  }
}
