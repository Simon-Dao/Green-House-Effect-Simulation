package Simulation.matter;

import Simulation.environment.Environment;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class CarbonDioxide extends Matter {

    public int x;
    public int y;

    public final int height = 4;
    public final int width = 12;

    private GraphicsContext gc;

    public CarbonDioxide(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void tick(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;

        gc.setFill(Color.WHITE);
        gc.fillOval(x, y, 3, height);

        gc.setFill(Color.RED);
        gc.fillOval(x - 4, y + 2, 4, height);
        gc.fillOval(x + 4, y + 2, 4, height);
    }
}
