package com.example.di_1;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;
import java.util.List;



public class HelloController {
    @FXML
    public Label opcion;
    public ChoiceBox decision;
    public ListView lista;
    public HBox edadBox;
    public HBox notaBox;
    public TextField edadField;
    public TextArea notaField;
    public TableView tablaAlumnos;
    public TableColumn nombre;
    public TableColumn apellidos;
    public TableColumn edad;
    public TableColumn nota;
    SimpleObjectProperty<ObservableList<Alumno>> alumnosProperty = new SimpleObjectProperty<>(FXCollections.observableArrayList());
    SimpleObjectProperty<FilteredList<Alumno>> alumnosFiltradosProperty = new SimpleObjectProperty<>(new FilteredList<>(alumnosProperty.get()));


    ChangeListener<Number> filtro = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
            if (edadProperty.get() !=0 && notaMediaProperty.get()!=0){
                alumnosFiltradosProperty.get().predicateProperty().set(alumno -> alumno.getEdad() == edadProperty.get() && alumno.getNota() == notaMediaProperty.get());
            } else if (edadProperty.get() != 0) {
                alumnosFiltradosProperty.get().predicateProperty().set(alumno -> alumno.getEdad() == edadProperty.get());
            } else if (notaMediaProperty.get() != 0) {
                alumnosFiltradosProperty.get().predicateProperty().set(alumno -> alumno.getNota() == notaMediaProperty.get());
            }else {
                alumnosFiltradosProperty.get().predicateProperty().set(alumno -> true);
            }
        }
    };
    SimpleIntegerProperty edadProperty = new SimpleIntegerProperty() {{
        addListener(filtro);
    }};
    SimpleIntegerProperty notaMediaProperty = new SimpleIntegerProperty(){{
        addListener(filtro);
    }};

    List<Alumno> alumnos = new ArrayList<Alumno>(){{
        add(new Alumno("Rodrigo", "Alvarez", 20, 6 ));
        add(new Alumno("Aaron", "Blanco", 19, 7 ));
        add(new Alumno("Alfonso","Caballero",20,5 ));
        add(new Alumno("Alvaro","Gonzalo",19,6));
        add(new Alumno("Ismael","Dominguez",21,5));
        add(new Alumno("Juan Fernando","Falla",20,4));
        add(new Alumno("Claudia","Fernandez",21, 8 ));
    }};



        @FXML
        void initialize() {
            decision.getItems().addAll(alumnos);
            decision.setValue(alumnos.stream().findFirst().get());


            edadField.textProperty().bindBidirectional(edadProperty, new NumberStringConverter());
            notaField.textProperty().bindBidirectional(notaMediaProperty, new NumberStringConverter());

            alumnosProperty.get().addAll(alumnos);
            lista.itemsProperty().bind(alumnosFiltradosProperty);
            lista.setCellFactory(new Callback<ListView, ListCell>() {
                @Override
                public ListCell call(ListView listView) {
                    return new AlumnosCell();
                }
            });


            tablaAlumnos.itemsProperty().bind(alumnosFiltradosProperty);
            nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
            nota.setCellValueFactory(new PropertyValueFactory<>("nota"));

        }

        public void onCambioSeleccion(ActionEvent actionEvent) {
            opcion.setText(decision.getValue().toString());
        }

    }


