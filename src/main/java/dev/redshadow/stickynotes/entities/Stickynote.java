package dev.redshadow.stickynotes.entities;


import jakarta.persistence.*;


import java.util.UUID;

@Entity
public class Stickynote {



    @Id
    private String id;

    @PrePersist
    protected void onCreate() {
        if(this.id==null){
            this.id = UUID.randomUUID().toString();
        }

    }



    private String stickyNoteContent;
    private int posX;
    private int posY;


    public Stickynote (){

    }

    public Stickynote ( int posX, int posY, String content ){
        this.posX=posX;
        this.posY=posY;
        this.stickyNoteContent=content;
    }

    public String getId() {
        return id;
    }

    public String getStickyNoteContent() {
        return stickyNoteContent;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
