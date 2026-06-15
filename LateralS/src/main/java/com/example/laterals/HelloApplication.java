package com.example.laterals;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Tienda Henry Tonato");
        stage.setScene(scene);
        stage.show();
    }

    public static class Launcher {
        public static void main(String[] args) {
            Application.launch(HelloApplication.class, args);
        }
    }


}
