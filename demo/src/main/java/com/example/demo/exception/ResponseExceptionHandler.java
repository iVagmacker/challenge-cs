package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handlerSystemException(final Exception e) {
        final boolean isServiceException = e instanceof ServiceException;
        final String msg = e instanceof ServiceException ? messageSource.getMessage(e.getMessage(), null, LocaleContextHolder.getLocale()) : e.getMessage();
        final Erro erro = new Erro(e.getMessage(), StringUtils.isEmpty(msg) ? e.toString() : msg);

        return ResponseEntity.status(isServiceException ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}