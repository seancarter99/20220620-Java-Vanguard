package com.skillstorm.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = {"/artists/*", "/albums/*"})
//public class LoggingFilter implements Filter {
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// Do NOT call super.init
//	}
//	
//	@Override
//	public void destroy() {
//		
//	}
//	
//	// Filters must override the ability to filter a request
//	// request + response are the HTTP req and resp
//	// FilterChain is so that we can continue to the next item in the chain
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
////		System.out.println("Commencing LoggingFilter logs");
////		System.out.println(request.getLocalAddr());
////		if (request.getLocale().equals("es_US")) {
////			HttpServletResponse res = (HttpServletResponse) response;
////			res.setStatus(400);
////		} 
////		else {
//			System.out.println(request.getLocale());
//			System.out.println("Filter complete. Commencing chain");
//			chain.doFilter(request, response); // send the two to the next filter/servlet
////		}
//
//	}
//}
