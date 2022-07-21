package com.skillstorm;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Allows this to function in a web environment
// WebApplicationInitializer is a way to do this in Java Annotations as opposed to the web.xml
public class SpringMvcConfig implements WebApplicationInitializer, WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// Minor, but moves everything in static to be accessed on the root level of the folder
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		// This is quality of life
		// If a string is returned, Spring MVC will interpret that as a file to resolve for the view
		// "static/index.html" -> ViewResolver will send that HTML page by default
		
		// The returned string will automatically have /static/ added to the front
		// "index.html"
		resolver.setPrefix("/static/");
		// "index"
		resolver.setSuffix(".html");
		
		return resolver;
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// I need to add to the servletContext everything that TomCat needs to be aware of
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan("com.skillstorm"); // This is the Web version of ComponentScan
		
		servletContext.addListener(new ContextLoaderListener(context)); // This will listen for the requests
		// and direct them to right controller
		
		// Create and register the DispatcherServlet in the context
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", 
				new DispatcherServlet(new GenericWebApplicationContext()));
		
		// Now I configure the dispatcher
		dispatcher.addMapping("/"); // This has it handle every request
		// Tell the dispatcher servlet to load immediately
		dispatcher.setLoadOnStartup(1); // The number is the priority. This is important so it gets 1
	}

	
}
