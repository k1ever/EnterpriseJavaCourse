package com.mvc.library.aspects;

import com.mvc.library.report.BookReport;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Klever on 07.12.15.
 */

@Aspect
@Component
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class);

    @Before("execution(* com.mvc.library..*Service.*(..)) || execution(* com.mvc.library..*Repository.*(..))")
    public void enteredServiceOrRepository(JoinPoint joinPoint){
        logger.info("Entered: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
    }

    @After("within(com.mvc.library.service.*) || within(com.mvc.library.repository.*)")
    public void exitedServiceOrRepository(JoinPoint joinPoint){
        logger.info("Exited: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.mvc.library.service.StatisticService.getBookReport(..))",
            returning = "books")
    public void logBookReport(List<BookReport> books){
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("User Name   Taken Date   Returned Date\n");
        for (BookReport book : books){
            stringBuilder.append(book.toString());
            stringBuilder.append("\n");
        }

        logger.info(stringBuilder.toString());

    }

}
