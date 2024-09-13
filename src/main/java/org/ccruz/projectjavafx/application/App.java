package org.ccruz.projectjavafx.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.ccruz.projectjavafx.controllers.CrudStudiantController;
import org.ccruz.projectjavafx.models.School;
import org.ccruz.projectjavafx.util.Paths;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.CRUD_STUDIANT));
        AnchorPane pane = loader.load();
        //CrudStudiantController studiantController = loader.getController();

        //studiantController.setSchool(new School("new school"));
        Scene crudStudiant = new Scene(pane);
        stage.setScene(crudStudiant);
        stage.show();
    }
}
