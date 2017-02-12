package de.zoerner.miro.ecosim;

/**
 * Created by Miro on 25.01.2017.
 */

public class GraphUpdater extends Repeater {
    private PopulationGraph graph;

    public GraphUpdater(PopulationGraph graph){
        super(400);
        this.graph= graph;
    }

    @Override
    protected void work() {
        graph.update();
    }
}
