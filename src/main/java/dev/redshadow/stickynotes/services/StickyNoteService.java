package dev.redshadow.stickynotes.services;

import dev.redshadow.stickynotes.entities.Stickynote;
import dev.redshadow.stickynotes.interfaces.StickyNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StickyNoteService {


    @Autowired
    private final StickyNoteRepository stickyNoteRepository;

    @Autowired
    private final ScreenDimensionsService screenDimensionsService;

    public StickyNoteService(StickyNoteRepository stickyNoteRepository, ScreenDimensionsService screenDimensionsService) {
        this.stickyNoteRepository = stickyNoteRepository;
        this.screenDimensionsService = screenDimensionsService;
    }

    public int randomNumberGenerator(int maxLimit){
        Random random=new Random();
        return random.nextInt(maxLimit);
    }


    public List<Stickynote> createStickyNote(String stickyNoteContent, int posX, int posY){
        Stickynote newStickyNote=new Stickynote(posX,posY,stickyNoteContent);
        stickyNoteRepository.save(newStickyNote);

        return stickyNoteRepository.findAll();
    }


    public List<Stickynote> returnAllStickyNotes(){
            return stickyNoteRepository.findAll();
    }

    public Stickynote returnstickyNote(String id){
      return stickyNoteRepository.findById(id).orElse(null);
    }

    public List<Stickynote> deleteStickyNote(String id){
        stickyNoteRepository.deleteById(id);
        return stickyNoteRepository.findAll();

    }

    public List<Stickynote> updateStickynote( Stickynote updatedNote){
        stickyNoteRepository.save(updatedNote);
        return stickyNoteRepository.findAll();
    }
}


