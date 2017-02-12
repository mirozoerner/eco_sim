package de.zoerner.miro.ecosim;

import android.view.View;

import java.util.Random;

/**
 * Created by Miro on 18.01.2017.
 */

public class GrassSeeder extends Repeater {
    private Ground ground;
    private View view;

    public GrassSeeder(Ground ground, View view) {
        super(4000);

        this.ground= ground;
        this.view= view;
    }

    @Override
    protected void work() {
        Random r= new Random();


        int x = r.nextInt(ground.getWidth());
        int y = r.nextInt(ground.getHeight());

        if(!ground.isGrass(x, y)) {
            ground.setGrass(x, y);
            view.postInvalidate();
        }
    }
}
