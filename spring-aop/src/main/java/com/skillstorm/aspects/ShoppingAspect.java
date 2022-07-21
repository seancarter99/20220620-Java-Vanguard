package com.skillstorm.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// An Aspect exists in AOP to deal with "cross-cutting-concerns"
// An Aspect cuts across multiple places in your app to intercept things when certain criteria is met
// (ex. someone tries to shop())
@Component // So Spring knows about it
@Aspect // I also need AspectJ to know about this
public class ShoppingAspect {

	/*
	 * 
	 * joinpoint - The point in the application where the Aspect will cut in (shop())
	 * pointcut - A monitor listening for those events, and when it occurs, it will cut in
	 */
	
	// @Before runs before the method is executed
//	@Before("pointcut()")
	public void greet() {
		System.out.println("Hello! Welcome to the store!");
	}
	
//	@Before("pointcut()")
	public void checkMembership(boolean hasMembership) {
		System.out.println("Checking id");
		if (hasMembership) {
			System.out.println("Your membership is valid.");
		} else {
			throw new IllegalArgumentException("You may not shop here without a membership");
		}
		
	}
	
//	@After("pointcut()") // advice
	public void checkReceipt() {
		System.out.println("Checking receipt!");
	}
	
	// Runs ONLY if the joinpoint SUCCESSFULLY returns (NO EXCEPTION/ERROR)
	@AfterReturning(pointcut = "pointcut()", returning = "returnedValue") 
	public Object emailReceipt(Object returnedValue) {
		// In JDBC, conn.commit()
		// Only email the receipt on a successful sale
		System.out.println("Thank you for shopping with us! Your grand total was $" + returnedValue + "!");
		return 0; // This does NOT change the value. Returned value is ignored
	}
	
	// Runs ONLY if the joinpoin threw an exception
	@AfterThrowing(pointcut = "pointcut()", throwing = "e")
	public void invalidMembership(Throwable e) {
		// In JDBC, conn.rollabck()
		System.err.println(e.getMessage());
	}
	
	// All in one annotation that runs a bunch of advice methods
	@Around("pointcut()") // @Around runs at various points of this function call
	// @Around MUST return some value
	public Object shopProcedure(ProceedingJoinPoint joinPoint) {
		// @Before
		greet();
		checkMembership((boolean) joinPoint.getArgs()[1]); // use the shop arguments to check membership
		
		// Yield back control to the method shop()
		Object returnedValue = null;
		try {
			returnedValue = joinPoint.proceed();
			System.out.println(returnedValue);
		} catch (Throwable e) { // This Aspect doesn't know if or what Exception/Error will be thrown
			e.printStackTrace();
		} // Tells the shop method to execute
		// Once finished, I will come back here
		
		// @After
		checkReceipt();
//		return 0.0; // This changes the return value to 0
		return returnedValue; // Give that value back to Spring
	}
	
	// Basically a dummy method that holds onto our execution so that we can reuse it
	// Uses Reflection API to invoke this method
	@Pointcut("execution(public double shop(com.skillstorm.beans.Item[], boolean))")
	public void pointcut() {
		System.out.println("PointCut Method");
	}
	
}
