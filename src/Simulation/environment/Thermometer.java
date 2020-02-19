package Simulation.environment;

import Simulation.main.Loop;
import Simulation.main.RandomDigit;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Thermometer {

    private GraphicsContext gc;

    private int temp;

    private RandomDigit random;

    public void setTemperature(int temperature) {
        this.temp = temperature;
    }

    public Thermometer(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;
    }

    public void draw() {

        //thermometer
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(30, 380, 20, 110, 20, 20);

        gc.setFill(Color.RED);
        gc.fillOval(20, 480, 40, 40);

        gc.setFill(Color.RED);
        gc.fillRoundRect(30, 380 + 90, 20, 110 - 90, 20, 20);

        setTemp();
    }

    private void setTemp() {
       // if (Loop.FRAMES % random.nextInt(5, 7) == 0) {
            // gc.setFill(Color.BLACK);
            // gc.fillText(String.valueOf(temp) + " F", 30, 500);
       // }
        System.out.println(Loop.FRAMES);
    }
}

