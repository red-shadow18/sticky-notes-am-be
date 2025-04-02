package dev.redshadow.stickynotes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.redshadow.stickynotes.services.ScreenDimensionsService;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ScreenWidthController {


    @Autowired
    private ScreenDimensionsService screenDimensionsService;

    @RequestMapping(method = RequestMethod.POST,
            value = "/api/saveScreenDimensions")
    public ResponseEntity<?> saveScreenDimensions(@RequestBody Map<String,Integer> screenDimensions){

        Integer width =screenDimensions.get("width");
        Integer height=screenDimensions.get("height");
        if( height==null || width==null){
            Map<String, Object> response=new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());

            response.put("customMessage","Height or Width cant be null");


            return ResponseEntity.badRequest().body(response);

        }
        screenDimensionsService.saveScreenDimensions(width,height);
        return ResponseEntity.ok("Screen dimensions saved successfully!");
    }
}
