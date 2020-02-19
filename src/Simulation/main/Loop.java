package Simulation.main;

import Simulation.energy.Sunlight;
import Simulation.environment.Environment;
import Simulation.view.ControlPanel;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Loop {

    private boolean RUNNING = true;

    private GraphicsContext gc;

    private Main main;

    private int FRAME_RATE = ControlPanel.FRAME_COUNT + 1;

    public static int FRAMES;

    Loop(Main main, GraphicsContext graphicsContext) {
        this.gc = graphicsContext;
        this.main = main;
    }

    public void startGameLoop() {

        new AnimationTimer() {

            long lastTick = 0;

            @Override
            public void handle(long now) {
                if (RUNNING) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }
                    if (now - lastTick > 1_000_000_000 / FRAME_RATE) {
                        lastTick = now;
                        tick(gc);
                    }
                }
            }
        }.start();
    }

    private void tick(GraphicsContext gc) {

        if(FRAMES == FRAME_RATE) {
            FRAMES = 0;
        } else {
            FRAMES++;
        }

        main.environment.drawEnvironment();
        main.panel.setUserInput();

        if(ControlPanel.FRAME_COUNT != 0) {
            RUNNING = true;

            FRAME_RATE = ControlPanel.FRAME_COUNT;
        } else {
            FRAME_RATE = 1;
        }
    }
}
