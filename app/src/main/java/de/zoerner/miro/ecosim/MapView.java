package de.zoerner.miro.ecosim;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Miro on 18.01.2017.
 */

public class MapView extends View implements View.OnTouchListener {
    private Ground ground= null;
    private GrassSeeder grassSeeder;
    private GrassGrower grassGrower;
    private GrassSpawner grassSpawner;
    private  AnimalAnimator animalAnimator;
    private PopulationGraph graph;

    private Set<Animal> animals= new HashSet<>();

    {
        setOnTouchListener(this);
    }

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if(ground == null){
            //init
            int w= getWidth();
            int h= getHeight();

            ground= new Ground(this, w, h);
            grassSeeder= new GrassSeeder(ground, this);
            grassGrower= new GrassGrower(ground, this);
            grassSpawner= new GrassSpawner(ground, this);
            animalAnimator= new AnimalAnimator(this);
        }
        ground.draw(canvas);
        for(Animal animal: animals){
            animal.draw(canvas);
        }
        graph.addValue(animals.size());
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGraph(PopulationGraph graph) {
        this.graph = graph;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        animals.add(new Bunny((int)event.getX(), (int)event.getY(), Randomer.rnd.nextInt(4) + 2));

        return false;
    }
}
