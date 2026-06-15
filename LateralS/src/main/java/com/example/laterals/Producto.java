package com.example.laterals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private String estado;

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto(
            String codigo,
            String nombre,
            String categoria,
            double precio,
            int stock,
            String estado) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

}

