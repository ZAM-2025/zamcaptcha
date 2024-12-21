package com.zam.captcha;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
    public static void genCaptcha() {
        Captcha captcha = new Captcha();

        System.out.println(captcha.getId());

        Raster raster = captcha.getAsRaster();
        BufferedImage image = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_INT_ARGB);
        //raster.getDataBuffer().getOffset();
        image.setData(raster);

        try {
            File outputFile = new File(String.format("captcha-%s.png", captcha.getId())); // Specify your file name and format (e.g., PNG, JPEG)
            ImageIO.write(image, "PNG", outputFile); // "PNG" can be replaced with "JPEG", "GIF", etc.
            System.out.println("Image saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            genCaptcha();
        }
    }
}