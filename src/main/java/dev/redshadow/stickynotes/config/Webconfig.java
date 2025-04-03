package dev.redshadow.stickynotes.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://sticky-notes-am.netlify.app","http://localhost:5173")
               // .allowedOrigins("http://localhost:5173","http://localhost:8081")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
