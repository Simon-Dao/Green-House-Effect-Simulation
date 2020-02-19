package Simulation.energy;

import Simulation.environment.Environment;
import Simulation.main.Loop;
import Simulation.main.Main;
import Simulation.main.RandomDigit;
import Simulation.matter.CarbonDioxide;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Sunlight extends Energy {

    public int x;
    public int y;
    public int vX;

    private int vY = 3;

    private RandomDigit random = new RandomDigit();

    private GraphicsContext gc;

    public Sunlight(int x, int y, int xVelocity) {
        this.x = x;
        this.y = y;
        this.vX = xVelocity;
    }

    private void checkCollision() {
        x += vX;
        y += vY;

        if (y >= Main.GAME_HEIGHT - 20) {
            y = random.nextInt(-1000, 0);
        }

        if (x >= Main.GAME_WIDTH) {
            x = random.nextInt(0,500);
        } else if (x <= 0) {
            x = random.nextInt(0,500);
        }

    }

    @Override
    public void tick(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;

        checkCollision();

        gc.setFill(Color.YELLOW);
        gc.fillOval(x, y, 5, 5);

    }

    @Override
    public void reflect() {
    }

    @Override
    public void convert() {
    }
}
