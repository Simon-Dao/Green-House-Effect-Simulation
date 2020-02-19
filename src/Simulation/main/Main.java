package Simulation.main;

import Simulation.environment.Environment;
import Simulation.view.ControlPanel;
import Simulation.view.WindowControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    public static int STAGE_HEIGHT = 600;
    public static int STAGE_WIDTH = 700;
    public static int GAME_WIDTH = 500;
    public static int GAME_HEIGHT = 600;

    private String TITLE = "Green House Simulation";

    private Stage stage;
    private Pane root;
    private Scene scene;
    private Canvas c;
    private GraphicsContext gc;

    public WindowControl window;
    public ControlPanel panel;
    public Environment environment;

    private Loop gameLoop;

    /*
        creates a window for the simulation to run in
        and runs the simulation loop
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        root = new Pane();
        c = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        gc = c.getGraphicsContext2D();
        gameLoop = new Loop(this, gc);
        root.getChildren().add(c);

        scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);

        window = new WindowControl(stage, scene);
        panel = new ControlPanel(root);
        environment = new Environment(gc);

        gameLoop.startGameLoop();

        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
