package de.zoerner.miro.ecosim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Miro on 18.01.2017.
 */

public class Ground {
    private Bitmap ground;
    private Canvas canvas;
    private Rect orgArea;
    private int w, h;
    private int background;
    private MapView mapView;

    public Ground(MapView view, int w, int h) {
        this.mapView= view;
        background= Color.rgb(240, 240, 240);
        orgArea= new Rect(0, 0, w, h);
        this.w= w/3;
        this.h= h/3;
        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        ground= Bitmap.createBitmap(this.w, this.h, conf); // this creates a MUTABLE bitmap
        ground.eraseColor(background);
        canvas = new Canvas(ground);
    }

    public int getWidth(){
        return w;
    }

    public int getHeight() {
        return  h;
    }

    public void setGrass(int x, int y){
        Paint p= new Paint();
        p.setColor(Grass.light);
        canvas.drawPoint(x, y, p);
    }

    public void growGrass(int x, int y){
        int l= Grass.level(ground.getPixel(x, y));
        if(l >= 0){
            ground.setPixel(x, y, Grass.green(l - 1));
        }
    }

    public void eatGrass(int x, int y){
        int l= Grass.level(ground.getPixel(x, y));
        if(l < 7){
            ground.setPixel(x, y, Grass.green(l + 1));
        }else{
            ground.setPixel(x, y, background);
        }
    }

    public final boolean isGrass(int x, int y){
        if (x < 0 || y < 0 || x >= w || y >= h){
            return false;
        }
        return ground.getPixel(x, y) != background;
    }

    public Point grassNeighbor(int x, int y, int distance){
        for(int i= 0; i < 20; i++){
            int px= x + (Randomer.rnd.nextInt(1+(2*distance)) - distance);
            int py= y + (Randomer.rnd.nextInt(1+(2*distance)) - distance);
            if(px == x && py == y){
                continue;
            }

            if(isGrass(px, py)){
                return new Point(px, py);
            }
        }

        return null;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(ground, null, orgArea, null);
    }

    public MapView getMapView() {
        return mapView;
    }
}
