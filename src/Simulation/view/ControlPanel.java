package Simulation.view;

import javafx.scene.layout.Pane;

import javafx.scene.control.*;

public class ControlPanel {

    private Pane root;

    public static int CO2_COUNT;
    public static int CH4_COUNT;
    public static int FRAME_COUNT;

    private double CO2_DOUBLE;
    private double CH4_DOUBLE;
    private double FRAME_DOUBLE;

    private Slider CO2_SLIDER;
    private Slider CH4_SLIDER;
    private Slider FRAME_SLIDER;

    public ControlPanel(Pane root) {
        this.root = root;

        createPanel(root);
    }

    public void createPanel(Pane root) {

        Label CO2_LABEL = new Label("CO2 ppm");
        CO2_LABEL.setLayoutX(510);
        CO2_LABEL.setLayoutY(210);
        root.getChildren().add(CO2_LABEL);

        CO2_SLIDER = new Slider(0, 400, 10);
        CO2_SLIDER.setPrefSize(170, 30);
        CO2_SLIDER.setLayoutX(510);
        CO2_SLIDER.setLayoutY(230);
        CO2_SLIDER.setShowTickMarks(true);
        CO2_SLIDER.setShowTickLabels(true);
        root.getChildren().add(CO2_SLIDER);

        Label CH4_LABEL = new Label("CH4 ppm");
        CH4_LABEL.setLayoutX(510);
        CH4_LABEL.setLayoutY(270);
        root.getChildren().add(CH4_LABEL);

        CH4_SLIDER = new Slider(0, 400, 10);
        CH4_SLIDER.setPrefSize(170, 30);
        CH4_SLIDER.setLayoutX(510);
        CH4_SLIDER.setLayoutY(290);
        CH4_SLIDER.setShowTickMarks(true);
        CH4_SLIDER.setShowTickLabels(true);
        root.getChildren().add(CH4_SLIDER);

        Label SLO_MO_LABEL = new Label("SPEED");
        SLO_MO_LABEL.setLayoutX(510);
        SLO_MO_LABEL.setLayoutY(330);
        root.getChildren().add(SLO_MO_LABEL);

        FRAME_SLIDER = new Slider(0,200,60);
        FRAME_SLIDER.setPrefSize(170,30);
        FRAME_SLIDER.setLayoutX(510);
        FRAME_SLIDER.setLayoutY(350);
        FRAME_SLIDER.setShowTickMarks(true);
        FRAME_SLIDER.setShowTickLabels(true);
        root.getChildren().add(FRAME_SLIDER);
    }

    public void setUserInput() {

        CO2_DOUBLE = CO2_SLIDER.getValue();
        CH4_DOUBLE = CH4_SLIDER.getValue();
        FRAME_DOUBLE = FRAME_SLIDER.getValue();

        //ROUND THE SLIDER INPUTS
        if (CO2_COUNT - .5 > (int)CO2_COUNT) { CO2_DOUBLE += 1; }
        if (CH4_COUNT - .5 > (int)CH4_COUNT) { CH4_DOUBLE += 1; }
        if (FRAME_COUNT - .5 > (int)FRAME_COUNT) { FRAME_DOUBLE += 1; }

        //PARSING DOUBLES INTO INT
        CO2_COUNT = ( (int)CO2_DOUBLE);
        CH4_COUNT = ( (int)CH4_DOUBLE);
        FRAME_COUNT = ( (int)FRAME_DOUBLE);
    }
}
