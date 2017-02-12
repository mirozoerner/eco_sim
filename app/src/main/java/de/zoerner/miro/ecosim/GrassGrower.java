package de.zoerner.miro.ecosim;

import android.view.View;

import java.util.Random;

/**
 * Created by Miro on 18.01.2017.
 */

public class GrassGrower extends Repeater {
    private Ground ground;
    private View view;
    private Random r= new Random();


    public GrassGrower(Ground ground, View view) {
        super(100);

        this.ground= ground;
        this.view= view;
    }

    @Override
    protected void work() {
        for(int i= 0; i < 2000; i++) {
            int x = r.nextInt(ground.getWidth());
            int y = r.nextInt(ground.getHeight());

            if (ground.isGrass(x, y)){
                ground.growGrass(x, y);
                view.postInvalidate();
            }
        }
    }
}
