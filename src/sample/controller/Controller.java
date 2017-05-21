package sample.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.model.PipeDiams;
import sample.model.Utils;

public class Controller {

    ObservableList<String> diamsList = FXCollections.
            observableArrayList("Dy15", "Dy20", "Dy25", "Dy32", "Dy40", "Dy50", "Dy65");

    @FXML
    private ChoiceBox diameterBox;

    @FXML
    private ToggleGroup pipeTypeGroup = new ToggleGroup();

    @FXML
    private TextField powerTxt;

    @FXML
    private TextField rateTxt;

    @FXML
    private TextField deltaTxt;

    @FXML
    private TextField koefTxt;

    @FXML
    private TextField outerDiamTxt;

    @FXML
    private TextField speedTxt;

    @FXML
    private TextField dropTxt;

    @FXML
    private void initialize() {
        diameterBox.setValue("Dy15");
        diameterBox.setItems(diamsList);
        diameterBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setOuterDiamTxt(newValue);
            }
        });
    }

    public void calculate() {
        speedTxt.setText(Utils.calcSpeed(rateTxt.getText(), outerDiamTxt.getText()));
        dropTxt.setText(Utils.calcDrop(rateTxt.getText(), koefTxt.getText(), outerDiamTxt.getText()));

    }

    public void onPipeTypeRadioClick(){
        setKoefTxt();
        String innerDiam = diameterBox.getSelectionModel().getSelectedItem().toString();
        setOuterDiamTxt(innerDiam);
    }

    public void setKoefTxt() {
        switch (pipeTypeGroup.getSelectedToggle().getUserData().toString()) {
            case "steel":
                koefTxt.setText("0.2");
                break;
            case "cuprum":
                koefTxt.setText("0.016");
                break;
            case "ppr":
                koefTxt.setText("0.007");
                break;
        }
    }

    public void setRateTxt(KeyEvent keyEvent) {
        int rate = Utils.calcRate(Integer.parseInt(powerTxt.getText()), Integer.parseInt(deltaTxt.getText()));
        rateTxt.setText(String.valueOf(rate));
    }

    public void setOuterDiamTxt(String innerDiam) {
        String pipeType = pipeTypeGroup.getSelectedToggle().getUserData().toString();
        outerDiamTxt.setText(PipeDiams.getDiam(innerDiam, pipeType));
    }

}
