package de.zoerner.miro.ecosim;

import android.os.Handler;

/**
 * Created by Miro on 18.01.2017.
 */

public abstract class Repeater implements Runnable {
    private Handler handler;
    private int spawnDelay= 500;

    public Repeater(int spawnDelay){
        this.spawnDelay= spawnDelay;
        handler= new Handler();

        handler.postDelayed(this, spawnDelay);
    }

    protected abstract void work();

    @Override
    public void run() {
        work();
        handler.postDelayed(this, spawnDelay);
    }
}
