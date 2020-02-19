package Simulation.energy;

import Simulation.environment.Environment;
import Simulation.main.Loop;
import Simulation.main.Main;
import Simulation.main.RandomDigit;
import Simulation.matter.CarbonDioxide;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Infrared extends Energy {

    public int x;
    public int y;
    public int vX;

    private int vY = -2;

    private RandomDigit random = new RandomDigit();
    private GraphicsContext gc;

    public Infrared(int x, int y, int vX) {
        this.x = x;
        this.y = y;
        this.vX = vX;
    }

    public void checkCollision() {
        x += vX;
        y += vY;

        if (y < 20) {

            vX =random.nextInt(-1, 1);
            vY = -2;
            y = random.nextInt(Main.GAME_HEIGHT, Main.GAME_HEIGHT + 500);

        } else if (y > Main.GAME_HEIGHT + 500) {

            vX =random.nextInt(-1, 1);
            vY = -2;
            y = random.nextInt(Main.GAME_HEIGHT, Main.GAME_HEIGHT + 500);
        }

        if (x >= Main.GAME_WIDTH) {
            x = random.nextInt(0, 500);
            reflect();
        } else if (x <= 0) {
            x = random.nextInt(0, 500);
            reflect();
        }

        if (Loop.FRAMES % 2 == 0) {
            for (CarbonDioxide c : Environment.co2_molecules) {
                if (new Rectangle2D(x, y, 5, 5).intersects(new Rectangle2D(c.x, c.y, 5, 10))) {
                    reflect();
                }
            }
        }
    }

    @Override
    public void tick(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;

        checkCollision();

        gc.setFill(Color.RED);
        gc.fillOval(x, y, 5, 5);
    }

    @Override
    public void reflect() {
        vY = random.nextInt(0, 1);
    }

    @Override
    public void convert() {

    }
}
