package com.example.springmvcdemo;

import jakarta.servlet.ServletRegistration;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class EmbeddedTomcatApplication {
    public static void main(String[] args)  throws Exception  {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);

        // Set the base directory for the Tomcat instance
        tomcat.setBaseDir(".");

        // Define a web application context
        Context ctx = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        // Create and register DispatcherServlet
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.example.springmvcdemo.config");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // Alternative way to add the servlet mapping
         ServletRegistration.Dynamic registration = ctx.getServletContext().addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        // Start the Tomcat server
        tomcat.start();
        tomcat.getServer().await();

    }

}
