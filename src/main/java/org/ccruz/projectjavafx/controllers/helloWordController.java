package org.ccruz.projectjavafx.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class helloWordController {
    @FXML
    private Button btnButton;

    @FXML
    private Label lblText;

    private int num = 0;

    @FXML
    public void click(ActionEvent event) {
        num++;
        lblText.setText("hello " + num);
        btnButton.setText("cx " + num);
    }
}
