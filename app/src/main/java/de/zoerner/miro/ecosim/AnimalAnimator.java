package de.zoerner.miro.ecosim;

/**
 * Created by Miro on 19.01.2017.
 */

public class AnimalAnimator extends Repeater{
    private  MapView mapView;
    public AnimalAnimator(MapView view) {
        super(200);

        mapView= view;
    }

    @Override
    protected void work() {
        for (Animal animal: mapView.getAnimals().toArray(new Animal[mapView.getAnimals().size()])){
            animal.animate(mapView.getGround());
        }
        mapView.postInvalidate();
    }
}
