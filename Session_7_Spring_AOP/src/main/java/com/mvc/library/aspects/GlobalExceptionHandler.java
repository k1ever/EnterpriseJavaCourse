package com.mvc.library.aspects;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Klever on 07.12.15.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, WebRequest request){
        Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

        StringBuilder sb = new StringBuilder();
        sb.append(e.getMessage()).append(" - ");
        StackTraceElement element = e.getStackTrace()[0];
        if (element != null){
            sb.append(element.getClassName()).append(":").append(element.getLineNumber());
        }

        logger.error(sb);

        request.setAttribute("exception", "An error has occured: " + e.getMessage(), RequestAttributes.SCOPE_REQUEST);
        return "errorPage";

    }

}
