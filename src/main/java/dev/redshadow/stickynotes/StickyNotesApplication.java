package dev.redshadow.stickynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StickyNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StickyNotesApplication.class, args);
        System.out.println("System started");
    }



}
