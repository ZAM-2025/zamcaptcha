package com.zam.captcha;

import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageNoise {
    public static void generate(BufferedImage image, int width, int height, float weight) {
        Random random = new Random();

        int noiseWeight = (int)(255 * weight);

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);

                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;

                int rr = random.nextInt(noiseWeight * 2) - noiseWeight;
                int rg = random.nextInt(noiseWeight * 2) - noiseWeight;
                int rb = random.nextInt(noiseWeight * 2) - noiseWeight;

                int nr = Clamp.clamp(r + rr, 0, 255);
                int ng = Clamp.clamp(g + rg, 0, 255);
                int nb = Clamp.clamp(b + rb, 0, 255);

                int nrgb = 0xff000000 | ((nr << 16) & 0xff0000) | ((ng << 8) & 0xff00) | (nb & 0xff);
                image.setRGB(x, y, nrgb);
            }
        }
    }
}
