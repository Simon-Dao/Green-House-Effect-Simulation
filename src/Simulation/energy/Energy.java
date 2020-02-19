package Simulation.energy;

import javafx.scene.canvas.GraphicsContext;

public abstract class Energy {

    public abstract void tick(GraphicsContext graphicsContext);

    public abstract void reflect();

    public abstract void convert();
}
