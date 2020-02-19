package Simulation.view;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class WindowControl {

    private Scene scene;
    private Stage stage;

    public WindowControl(Stage stage, Scene scene) {

        this.scene = scene;

        scene.addEventFilter(KeyEvent.KEY_PRESSED, keys -> {
            KeyCode INPUT_KEY = keys.getCode();

            switch (keys.getCode()) {
                case ESCAPE:
                    stage.close();
                    System.exit(0);
                    break;
            }

        });
    }
}
