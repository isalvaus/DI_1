package com.example.di_1;

import javafx.beans.property.*;

public class Alumno {

    SimpleStringProperty nombreProperty = new SimpleStringProperty();
    SimpleStringProperty apellidosProperty = new SimpleStringProperty();
    SimpleIntegerProperty edadProperty = new SimpleIntegerProperty();
    SimpleIntegerProperty notaProperty = new SimpleIntegerProperty();

    public Alumno(String nombre, String apellidos, Integer edad, Integer nota) {
        this.nombreProperty.set(nombre);
        this.apellidosProperty.set(apellidos);
        this.edadProperty.set(edad);
        this.notaProperty.set(nota);
    }

    public void setNombre(String nombre) {
        this.nombreProperty.set(nombre);
    }

    public void setApellidos(String apellidos) {
        this.apellidosProperty.set(apellidos);
    }

    public void setEdad(int edad) {
        this.edadProperty.set(edad);
    }

    public void setNota(int nota) {
        this.notaProperty.set(nota);
    }

    public String getNombre() {
        return nombreProperty.get();
    }

    public String getApellidos() {
        return apellidosProperty.get();
    }

    public Integer getEdad() {
        return edadProperty.get();
    }

    public Integer getNota() {
        return notaProperty.get();
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Apellidos: %s", getNombre(), getApellidos());
    }
}
