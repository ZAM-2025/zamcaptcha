package com.zam.captcha;

import java.awt.Color;
import java.util.Random;

public class RandomColor {
    private static final Color[] colors = {
        Color.RED,
        Color.ORANGE,
        Color.YELLOW,
        Color.GREEN,
        Color.CYAN,
        Color.BLUE,
        Color.MAGENTA,
        Color.BLACK,
        Color.DARK_GRAY,
        Color.LIGHT_GRAY,
        Color.PINK
    };

    public static Color getColor() {
        Random random = new Random();
        int colorIndex = random.ints(0, colors.length).findFirst().getAsInt();

        return colors[colorIndex];
    }
}
