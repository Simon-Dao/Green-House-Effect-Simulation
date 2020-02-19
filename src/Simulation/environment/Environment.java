package Simulation.environment;

import Simulation.energy.Infrared;
import Simulation.energy.Sunlight;
import Simulation.main.Loop;
import Simulation.main.Main;
import Simulation.main.RandomDigit;
import Simulation.matter.CarbonDioxide;
import Simulation.view.ControlPanel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import java.util.ArrayList;
import java.util.Random;

public class Environment {

    private GraphicsContext gc;
    private RandomDigit random = new RandomDigit();
    private Thermometer temperature;

    private int VISIBLE_COUNT = 15;
    private int INFRARED_COUNT = 45;
    private static int CO2_COUNT = 30;

    private int ESCAPED_HEAT = 0;

    private Sunlight[] visible_photons = new Sunlight[VISIBLE_COUNT];
    private Infrared[] infrared_photons = new Infrared[INFRARED_COUNT];

    public  static ArrayList<CarbonDioxide> co2_molecules = new ArrayList<>();

    public Environment(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;
        temperature = new Thermometer(gc);
        spawnPhotons();
        spawnMolecules();
    }

    public void drawEnvironment() {

        //space
        Stop[] spaceStops = {new Stop(0, Color.BLUE), new Stop(1, Color.BLACK)};
        LinearGradient space = new LinearGradient(0, 1.6, 0, 0, true, CycleMethod.NO_CYCLE, spaceStops);
        gc.setFill(space);
        gc.fillRect(0, 0, 500, 600);

        //border with space
        Stop[] atmoStops = {new Stop(0, Color.WHITE), new Stop(5, Color.BLUE)};
        LinearGradient atmo = new LinearGradient(0, .03, 0, 0, true, CycleMethod.NO_CYCLE, atmoStops);
        gc.setFill(atmo);
        gc.fillOval(-700, 340, 1800, 400);

        //sky
        Color SKY_BLUE = Color.rgb(68, 189, 251);
        Stop[] skyStops = {new Stop(0, SKY_BLUE), new Stop(1, Color.BLUE)};
        LinearGradient sky = new LinearGradient(0, .4, 0, 0, true, CycleMethod.NO_CYCLE, skyStops);
        gc.setFill(sky);
        gc.fillOval(-700, 350, 1800, 400);

        gc.setFill(Color.GREEN);
        gc.fillOval(-700, 570, 1800, 400);

        movePhotons();
        moveMolecules();

        temperature.draw();
    }

    private void spawnPhotons() {

        for (int i = 0; i < VISIBLE_COUNT; i++) {
            Sunlight light = new Sunlight(
                    random.nextInt(0, Main.GAME_WIDTH),
                    random.nextInt(-400, -10),
                    random.nextInt(-1, 1));

            visible_photons[i] = light;
        }

        for (int i = 0; i < INFRARED_COUNT; i++) {
            Infrared light = new Infrared(
                    random.nextInt(0, Main.GAME_WIDTH),
                    random.nextInt(Main.GAME_HEIGHT, Main.GAME_HEIGHT + 1000),
                    random.nextInt(-1, 1));

            infrared_photons[i] = light;
        }
    }

    private void spawnMolecules() {

        for (int i = 0; i < CO2_COUNT; i++) {
            CarbonDioxide co2 = new CarbonDioxide(
                random.nextInt(1, 500),
                random.nextInt(360,480)
            );

            co2_molecules.add(co2);
        }
    }

    private void movePhotons() {

        for (int i = 0; i < VISIBLE_COUNT; i++) {
            visible_photons[i].tick(gc);
        }

        for (int i = 0; i < INFRARED_COUNT; i++) {
            infrared_photons[i].tick(gc);
        }
    }

    private void moveMolecules() {

        for (int i = 0; i < CO2_COUNT; i++) {
            co2_molecules.get(i).tick(gc);
        }
    }
}
