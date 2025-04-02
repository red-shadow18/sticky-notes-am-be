package dev.redshadow.stickynotes.controllers;


import dev.redshadow.stickynotes.dto.StickyNoteRequestDTO;
import dev.redshadow.stickynotes.entities.Stickynote;
import dev.redshadow.stickynotes.services.StickyNoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StickyNoteController {

    @Autowired
    private StickyNoteService stickyNoteService;

    @RequestMapping(method = RequestMethod.GET,
            value = "/api/getAllStickyNotes")
    public ResponseEntity<?> returnAllStickyNotes(){
        List<Stickynote> allStickyNotes=stickyNoteService.returnAllStickyNotes();
        Map<String,Object> response=new HashMap<>();
        response.put("allStickyNotes",allStickyNotes);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/api/getAllStickyNote/{id}")
    public Stickynote returnStickyNote(@PathVariable String id){
        return stickyNoteService.returnstickyNote(id);
    }

    @RequestMapping(method = RequestMethod.POST,
                    value = "/api/saveNewStickyNote")
    public ResponseEntity<?> addNewStickyNote(@Valid @RequestBody StickyNoteRequestDTO stickyNoteRequest){
        List<Stickynote> updatedStickyNotes= stickyNoteService.createStickyNote(stickyNoteRequest.getstickyNoteContent(), stickyNoteRequest.getPosX(),stickyNoteRequest.getPosY());
        Map<String,Object> response=new HashMap<>();
        response.put("updatedStickyNotes", updatedStickyNotes);
        response.put("customMessage","New sticky note added successfully");
        return ResponseEntity.ok(response);
    }


    @RequestMapping(method = RequestMethod.DELETE,
    value = "/api/delete/{id}")
    public ResponseEntity<?> deleteStickyNote(@PathVariable("id") String id){
        List<Stickynote> updatedstickyNotes= stickyNoteService.deleteStickyNote(id);
        Map<String,Object> response=new HashMap<>();
        response.put("updatedStickyNotes", updatedstickyNotes);
        response.put("customMessage","Sticky note deleted successfully!");
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.PUT,
    value = "/api/updateStickyNote")
    public ResponseEntity<?> updateStickyNote(@RequestBody Stickynote updatedStickyNote){
       List<Stickynote> updatedStickyNotes= stickyNoteService.updateStickynote( updatedStickyNote);
       Map<String,Object> response=new HashMap<>();
       response.put("customMessage","Sticky note updated successfully");
       response.put("updatedStickyNotes",updatedStickyNotes);
        return ResponseEntity.ok(response);

    }


}
