package de.zoerner.miro.ecosim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Miro on 25.01.2017.
 */

public class PopulationGraph extends View {
    private Vector<Integer> bunnies= new Vector<>();
    private int currentValue= 0;
    private GraphUpdater updater= new GraphUpdater(this);

    public PopulationGraph(Context context) {
        super(context);
    }

    public PopulationGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopulationGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PopulationGraph(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addValue (int value) {
        currentValue = value;
    }
    public void update(){
        bunnies.add(currentValue);
        if(bunnies.size() > getWidth()){
            bunnies.remove(0);
        }
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        Path p= new Path();
        p.moveTo(0, 0);
        int i= 0;
        for(int v: bunnies){
            p.lineTo(i, getHeight() - v * getHeight() / 6000);

            i++;
        }
        canvas.drawPath(p, Bunny.paint);
    }
}
