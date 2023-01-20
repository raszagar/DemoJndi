package es.jose;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoJndiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJndiApplication.class, args);
	}
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
	    return new TomcatServletWebServerFactory() {
	        @Override
	        protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
	            tomcat.enableNaming(); 
	            return super.getTomcatWebServer(tomcat);
	        }

	        @Override 
	        protected void postProcessContext(Context context) {

	        	//Jndi en tomcat embebido
	            ContextResource resource = new ContextResource();
	            resource.setName("jdbc/mibbdd");
	            resource.setType(DataSource.class.getName());
	            resource.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
	            resource.setProperty("url", "jdbc:mysql://localhost:3306/bdlocal?autoreconnect=true");
	            resource.setProperty("username", "root");
	            resource.setProperty("password", "joselete");
	            context.getNamingResources().addResource(resource);
	            
	        }
	    };
	}

}
