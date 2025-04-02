package dev.redshadow.stickynotes.dto;

public class StickyNoteRequestDTO {

private String content;

public StickyNoteRequestDTO(){

}

public StickyNoteRequestDTO(String content){
    this.content=content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
