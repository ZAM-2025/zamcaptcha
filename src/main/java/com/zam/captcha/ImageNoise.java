package com.zam.captcha;

import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageNoise {
    public static void generate(BufferedImage image, int width, int height, float weight) {
        Random random = new Random();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);

                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;

                float rr = random.nextFloat(weight);
                float rg = random.nextFloat(weight);
                float rb = random.nextFloat(weight);

                float nr = (float)r * rr;
                float ng = (float)g * rg;
                float nb = (float)b * rb;

                int nrgb = 0xff000000 | (((int)nr << 16) & 0xff0000) | (((int)ng << 8) & 0xff00) | ((int)nb & 0xff);
                image.setRGB(x, y, nrgb);
            }
        }
    }
}
