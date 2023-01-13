package com.lmmiranda.alticciapi.exceptionhandler;

import com.lmmiranda.alticciapi.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<HandleError> handleBusinessException(BusinessException ex, HttpServletRequest request) {
        HandleError handleError = new HandleError();

        handleError.setTimestamp(OffsetDateTime.now());
        handleError.setMessage(messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale()));
        handleError.setStatus(HttpStatus.BAD_REQUEST.value());
        handleError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(handleError);
    }
}
