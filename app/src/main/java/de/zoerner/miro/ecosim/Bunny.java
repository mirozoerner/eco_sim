package de.zoerner.miro.ecosim;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.Random;

/**
 * Created by Miro on 19.01.2017.
 */

public class Bunny extends Animal{
    public static Paint paint= new Paint();
    static {
        paint.setColor(Color.parseColor("#b09030"));
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public Bunny(int x, int y, float level) {
        super(x, y, level);
    }

    @Override
    void draw(Canvas canvas) {
        canvas.drawOval(x, y, x + level + 3, y + level + 3, paint);
    }

    @Override
    void animate(Ground ground) {
        if(level >= 10){
            level= 5;
            int newCount= Randomer.rnd.nextInt(5) + 1;
            for(int i=0; i < newCount; i++){
                ground.getMapView().getAnimals().add(new Bunny(x, y, 1.8f + 7f*Randomer.rnd.nextFloat() / newCount));
            }
        }

        if(ground.isGrass(x/3, y/3)){
            ground.eatGrass(x/3, y/3);
            if(Randomer.rnd.nextInt(10) == 0) {
                level+= 0.5f;
            }
            return;
        }

        Point p= ground.grassNeighbor(x/3, y/3, 2);
        if(p != null){
            //jump to grass and eat
            x= p.x * 3;
            y= p.y * 3;
            ground.eatGrass(p.x, p.y);
            if(Randomer.rnd.nextInt(10) == 0) {
                level+= 0.4f;
            }
        }else{
            //jump without target
            x+= Randomer.rnd.nextInt(7) - 3;
            y+= Randomer.rnd.nextInt(7) - 3;

            if(x < 0){
                x= 0;
            }
            if(y < 0){
                y= 0;
            }
            if(x >= ground.getWidth()*3){
                x= ground.getWidth()*3-1;
            }
            if(y >= ground.getHeight()*3){
                y= ground.getHeight()*3-1;
            }
            if(Randomer.rnd.nextInt(4) == 0) {
                level-= 0.09f;
                if(level < 0.99){
                    ground.getMapView().getAnimals().remove(this);
                }
            }
        }
    }
}
