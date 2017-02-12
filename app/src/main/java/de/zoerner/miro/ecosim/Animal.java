package de.zoerner.miro.ecosim;

import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by Miro on 19.01.2017.
 */

public abstract class Animal extends Point {
    protected float level;
    private int hashCode= Randomer.rnd.nextInt(Integer.MAX_VALUE);

    public Animal(int x, int y, float level) {
        super(x, y);
        this.level= level;
    }

    abstract void draw(Canvas canvas);
    abstract void animate(Ground ground);

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }
}
