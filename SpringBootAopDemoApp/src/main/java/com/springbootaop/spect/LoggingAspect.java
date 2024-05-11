package com.springbootaop.spect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	
	 public Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	 @Before("execution(* com.springbootaop..*(..))") // Example pointcut expression
	    public void logBefore() {
	        log.info("Before executing method...");
	    }

	    @AfterReturning(pointcut = "execution(* com.springbootaop..*(..))", returning = "result")
	    public void logAfterReturning(Object result) {
	        log.info("After executing method. Returned value: {}", result);
	    }
	    
    

}
