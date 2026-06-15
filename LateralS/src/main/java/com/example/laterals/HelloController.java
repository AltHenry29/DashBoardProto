package com.example.laterals;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Label welcomeText;
    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cmbRol;

    @FXML
    public void initialize() {

        cmbRol.getItems().addAll("Administrador", "Cajero");
    }

    @FXML
    private void ingresar(ActionEvent actionEvent) throws IOException {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String rol = cmbRol.getValue();

        if (usuario.isEmpty() || password.isEmpty() || rol == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Complete todos los campos");
            alert.show();
            return;
        }

        FXMLLoader loader;

        //Cambiar credenciales despues
        if (usuario.equals("admin") && password.equals("admin") && rol.equals("Administrador") || usuario.equals("cajero") && password.equals("cajero")&& rol.equals("Cajero")) {
            loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Datos Invalidos");
            alert.show();
            return;
        }

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }
    @FXML
    private void salir(){
        Platform.exit();

    }

}