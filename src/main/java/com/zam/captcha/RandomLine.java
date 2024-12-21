package com.zam.captcha;

import java.util.Random;

public class RandomLine {
    private int x1, x2;
    private int y1, y2;

    public RandomLine(int limx, int limy) {
        Random random = new Random();

        x1 = random.ints(0, limx).findFirst().getAsInt();
        x2 = random.ints(0, limx).findFirst().getAsInt();
        y1 = random.ints(0, limy).findFirst().getAsInt();
        y2 = random.ints(0, limy).findFirst().getAsInt();
    }

    public int getX1() {
        return this.x1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY1() {
        return this.y1;
    }

    public int getY2() {
        return this.y2;
    }
}
