package com.example.laterals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private ComboBox<String> cbCategoria;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colCodigo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    @FXML
    private TableColumn<Producto, String> colEstado;


    @FXML
    public void initialize() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        cbCategoria.getItems().addAll("Decorativo", "Consumo");
        cbEstado.getItems().addAll("Disponible", "Sin Stock");

        tablaProductos.setItems(productos);

        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {

            if(seleccionado != null){

                txtCodigo.setText(seleccionado.getCodigo());

                txtNombre.setText(seleccionado.getNombre());

                txtPrecio.setText(String.valueOf(seleccionado.getPrecio()));

                txtStock.setText(String.valueOf(seleccionado.getStock()));

                cbCategoria.setValue(seleccionado.getCategoria());

                cbEstado.setValue(seleccionado.getEstado());
            }

        });

        limpiarProducto();

    }

    @FXML
    private void guardarProducto() {

        Producto producto = new Producto(
                txtCodigo.getText(),
                txtNombre.getText(),
                cbCategoria.getValue(),
                Double.parseDouble(txtPrecio.getText()),
                Integer.parseInt(txtStock.getText()),
                cbEstado.getValue()
        );

        limpiarProducto();

        productos.add(producto);

    }

    @FXML
    private void actualizarProducto() {

        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        limpiarProducto();

        tablaProductos.refresh();

        if(seleccionado != null){
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setCategoria(cbCategoria.getValue());
            seleccionado.setPrecio(Double.parseDouble(txtPrecio.getText()));
            seleccionado.setStock(Integer.parseInt(txtStock.getText()));
            seleccionado.setEstado(cbEstado.getValue());

            tablaProductos.refresh();
        }
    }

    @FXML
    private void eliminarProducto() {

        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

        limpiarProducto();

        if(seleccionado != null){

            productos.remove(seleccionado);
        }
    }

    @FXML
    private void limpiarProducto() {

        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtPrecio.setText(null);
        txtStock.setText(null);

        tablaProductos.refresh();
    }



    @FXML
    private void volverLogin(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.show();

        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }

}