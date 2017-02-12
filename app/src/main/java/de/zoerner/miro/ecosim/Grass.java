package de.zoerner.miro.ecosim;

import android.graphics.Color;

/**
 * Created by Miro on 19.01.2017.
 */

public class Grass {
    public static int light= Color.parseColor("#669D26");
    public static int dark=  Color.parseColor("#1D560C");

    public static int level(int color){
        int gl= Color.green(light);
        int gd= Color.green(dark);

        int green= Color.green(color);
        int d= gl - gd;
        float s= d / 8;

        return Math.round((green - gd) / s);
    }

    public static int green(int level){
        int gl= Color.green(light);
        int gd= Color.green(dark);
        int rl= Color.red(light);
        int rd= Color.red(dark);
        int bl= Color.blue(light);
        int bd= Color.blue(dark);

        int dg= gl - gd;
        int dr= rl - rd;
        int db= bl - bd;

        float sg= dg / 8;
        float sr= dr / 8;
        float sb= db / 8;

        return Color.rgb(
                Math.round(rd + sr * level),
                Math.round(gd + sg * level),
                Math.round(bd + sb * level)
        );
    }
}
