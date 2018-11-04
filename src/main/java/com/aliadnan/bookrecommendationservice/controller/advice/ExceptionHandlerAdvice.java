package com.aliadnan.bookrecommendationservice.controller.advice;

import com.aliadnan.bookrecommendationservice.util.PropsUtils;
import com.aliadnan.bookrecommendationservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

/**
 * @author Ali
 * @createdOn 2018/10/28
 * <pre>>Aspect for handling almost all exceptions, all the keys for exception messages
 * are defined in application properties file</pre
 */
@ControllerAdvice
@Configuration
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private final static Logger logger = Logger.getLogger(ExceptionHandlerAdvice.class.getName());

    @Autowired
    PropsUtils propsUtils;

    /**
     * For handling all runtime exception and sending our standard
     * response to the client
     * @param ex thrown exception object
     * @return Response
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response<String>> handleRuntimeExceptions(RuntimeException ex) {
        String message = ex.getMessage();
        Response<String> response = new Response<>(message,Response.Status.FAILURE);
        logger.severe(message);
        return ResponseEntity.badRequest().body(response);
    }

    /**
     * overridden method handles the missing parameter in controllers and sends
     * a custom response to the client
     * @param ex thrown exception object
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String messageKey = ex.getBindingResult().getFieldError().getDefaultMessage();
        String fieldName = ex.getBindingResult().getFieldError().getField();
        Response<String> response = new Response<>(fieldName + " "+ propsUtils.getValue(messageKey),Response.Status.FAILURE);
        logger.severe(response.toString());
        return ResponseEntity.badRequest().body(response);
    }

}
