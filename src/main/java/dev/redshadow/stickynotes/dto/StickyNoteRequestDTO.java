package dev.redshadow.stickynotes.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StickyNoteRequestDTO {

    @NotNull(message = "Can't save note without any content")
private String content;

    @Positive
private int posX;
    @Positive
private int posY;

public StickyNoteRequestDTO(){

}

public StickyNoteRequestDTO(String content, int posX, int posY){
    this.content=content;
    this.posX=posX;
    this.posY=posY;
    }

    public String getContent() {
        return content;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
