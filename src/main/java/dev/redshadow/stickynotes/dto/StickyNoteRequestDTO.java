package dev.redshadow.stickynotes.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StickyNoteRequestDTO {

    @NotNull(message = "Can't save note without any content")
private String stickyNoteContent;

    @Positive
private int posX;
    @Positive
private int posY;

public StickyNoteRequestDTO(){

}

public StickyNoteRequestDTO(String stickyNoteContent, int posX, int posY){
    this.stickyNoteContent=stickyNoteContent;
    this.posX=posX;
    this.posY=posY;
    }

    public String getstickyNoteContent() {
        return stickyNoteContent;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
