package dev.redshadow.stickynotes.services;


import org.springframework.stereotype.Service;



@Service
public class ScreenDimensionsService {

    private int screenWidth;
    private int screenHeight;

    public void saveScreenDimensions(int width, int height){
        this.screenWidth=width;
        this.screenHeight=height;

        System.out.printf("Dimensions updated successfully as - Height: %d and Width: %d",getScreenHeight(),getScreenWidth());

    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
