package com.zam.captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Random;

public class Captcha {
    // Risoluzione di default del Captcha = 400x200px
    private static final int DEF_WIDTH = 400;
    private static final int DEF_HEIGHT = 200;

    private static final int NUM_LINES = 10;

    private int width;
    private int height;
    private String id;
    private String match;
    private BufferedImage image;

    public Captcha() {
        this.width = DEF_WIDTH;
        this.height = DEF_HEIGHT;
        
        this.id = RandomString.generate(RandomStringType.ALPHANUMERIC);
        this.match = RandomString.generate(RandomStringType.LETTERS, 8);

        // Genero l'immagine del Captcha
        image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);

        // Catturo un contesto di grafica 2D per disegnare il captcha
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.GRAY);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));

        // Ottengo le dimensioni del testo da disegnare
        FontMetrics metrics = graphics.getFontMetrics();
        int fontWidth = metrics.stringWidth(match);
        int fontHeight = metrics.getAscent();

        System.out.println(fontWidth);
        System.out.println(width - fontWidth);

        // Creo coordinate random per il testo
        int endX = width - fontWidth;
        int endY = height - fontHeight;

        Random random = new Random();
        int textX = random.ints(0, endX).findFirst().getAsInt();
        int textY = random.ints(height / 2, endY).findFirst().getAsInt();

        // Disegno il testo
        graphics.drawString(match, textX, textY);

        // TODO: Disegnare linee, rettangoli e altre forme casuali che non coprano il testo
        // TODO: Potenzialmente aggiungere del rumore all'immagine
        for(int i = 0; i < NUM_LINES; i++) {
            RandomLine line = new RandomLine(width, height);

            graphics.setColor(RandomColor.getColor());
            graphics.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }

        graphics.dispose();

        ImageNoise.generate(image, width, height, 1.2f);
    }

    public Raster getAsRaster() {
        return image.getData();
    }

    public BufferedImage getAsBufferedImage() {
        return this.image;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public String getMatch() {
        return this.match;
    }
}
