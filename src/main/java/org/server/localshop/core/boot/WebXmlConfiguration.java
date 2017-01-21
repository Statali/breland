package org.server.localshop.core.boot;

import javax.servlet.Servlet;

import org.glassfish.jersey.servlet.ServletContainer;
import org.server.localshop.core.filters.ResponseCorsFilter;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This Configuration replaces what formerly was in web.xml.
 *
 * @see <a
 *      href="http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-convert-an-existing-application-to-spring-boot">#howto-convert-an-existing-application-to-spring-boot</a>
 */
//@Configuration
public class WebXmlConfiguration {
    

  //  @Bean
    public ServletRegistrationBean jersey() {
        Servlet jerseyServlet = new ServletContainer();
        ServletRegistrationBean jerseyServletRegistration = new ServletRegistrationBean();
        jerseyServletRegistration.setServlet(jerseyServlet);
        jerseyServletRegistration.addUrlMappings("/*");
        jerseyServletRegistration.setName("jersey-servlet");
        jerseyServletRegistration.setLoadOnStartup(1);
        /*
         * Ligne de code qui suit ma donne un casse tete chinois
         */
        jerseyServletRegistration.addInitParameter("jersey.config.server.provider.packages", "org.server.localshop.api");
       jerseyServletRegistration.addInitParameter("org.eclipse.persistence.jaxb.rs.MOXyJsonProvider", "true");
        jerseyServletRegistration.addInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters",
                ResponseCorsFilter.class.getName());
        /* jerseyServletRegistration.addInitParameter("jersey.config.server.wadl.disableWadl", "true");*/
        // debugging for development:
        // jerseyServletRegistration.addInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters",
        // LoggingFilter.class.getName());
        return jerseyServletRegistration;
    }

   

}