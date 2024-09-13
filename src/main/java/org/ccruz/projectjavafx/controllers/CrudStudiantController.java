package org.ccruz.projectjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ccruz.projectjavafx.models.School;
import org.ccruz.projectjavafx.models.Studiant;

public class CrudStudiantController {
    private School school = new School("new school");

//    public void setSchool(School school) {
//        this.school = school;
//    }

    @FXML
    private TableView<Studiant> tblStudiants;

    @FXML
    private TableColumn<Studiant, Integer> colID;

    @FXML
    private TableColumn<Studiant, String> colName;

    @FXML
    private TableColumn<Studiant, String> colEmail;

    @FXML
    private TableColumn<Studiant, String> colEnrollment;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEnrollment;

    @FXML
    void initialize() {
        defineColumns();

        Studiant studiant1 = new Studiant("Julian", "juli@mail.com", "4589-7555");
        studiant1.setId(536);
        Studiant studiant2 = new Studiant("Roman", "roman@mail.com", "4589-7556");
        studiant2.setId(589);
        Studiant studiant3 = new Studiant("Claudia", "clau@mail.com", "4589-7557");
        studiant3.setId(657);

        school.addStudiant(studiant1);
        school.addStudiant(studiant2);
        school.addStudiant(studiant3);

        refreshTable();

        tblStudiants.setOnMouseClicked(mouseEvent -> {
            Studiant studiant = tblStudiants.getSelectionModel().getSelectedItem();
            if (studiant != null) {
                setFields(studiant);
                blockField(txtID);
            }
        });
    }

    private void defineColumns() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEnrollment.setCellValueFactory(new PropertyValueFactory<>("enrollment"));
    }

    @FXML
    void save(ActionEvent event) {
        Studiant studiant = new Studiant();
        studiant.setId(Integer.parseInt(txtID.getText()));
        studiant.setName(txtName.getText());
        studiant.setEmail(txtEmail.getText());
        studiant.setEnrollment(txtEnrollment.getText());

        school.addStudiant(studiant);
        refreshTable();
        cleanFields();
    }

    @FXML
    void update(ActionEvent event) {
        Studiant studiant = new Studiant();
        studiant.setId(Integer.parseInt(txtID.getText()));
        studiant.setName(txtName.getText());
        studiant.setEmail(txtEmail.getText());
        studiant.setEnrollment(txtEnrollment.getText());

        school.updateStudiant(studiant);
        refreshTable();
        cleanFields();
    }

    @FXML
    void delete(ActionEvent event) {
        Studiant studiant = tblStudiants.getSelectionModel().getSelectedItem();
        school.deleteStudiant(studiant);
        refreshTable();
        cleanFields();
    }

    private void refreshTable() {
        tblStudiants.getItems().clear();
        tblStudiants.getItems().addAll(school.getStudiants());
        tblStudiants.refresh();
    }

    private void cleanFields() {
        txtID.clear();
        txtName.clear();
        txtEmail.clear();
        txtEnrollment.clear();
        unblockField(txtID);
    }

    private void setFields(Studiant studiant) {
        txtID.setText(Integer.toString(studiant.getId()));
        txtName.setText(studiant.getName());
        txtEmail.setText(studiant.getEmail());
        txtEnrollment.setText(studiant.getEnrollment());
    }

    private void blockField(TextField field) {
        field.setEditable(false);
    }

    private void unblockField(TextField field) {
        field.setEditable(true);
    }
}
