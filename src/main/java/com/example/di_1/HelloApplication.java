package com.example.di_1;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Propiedas que se enlazan a la interfaz
        DoubleProperty propiedadAncho=new SimpleDoubleProperty();
        DoubleProperty propiedadAlto=new SimpleDoubleProperty();
        //Parte interfaz
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);

/*        Label texto=new Label();

        List<Pair<Integer,String>> listaSeleccion=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            listaSeleccion.add(new Pair<>(i,"a"));
        }


        ChoiceBox<Pair<Integer,String>>seleccion=new ChoiceBox<>();
        seleccion.getItems().addAll(listaSeleccion);

        seleccion.setValue(new Pair<>(0,""));
        seleccion.setConverter(new StringConverter<Pair<Integer, String>>() {
            @Override
            public String toString(Pair<Integer, String> integerStringPair) {
                return integerStringPair.getValue();
            }

            @Override
            public Pair<Integer, String> fromString(String s) {
                return null;
            }
        });
        seleccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                texto.setText(seleccion.getValue().getValue()+" "+ seleccion.getValue().getKey());
            }
        });

        Scene scene = new Scene(new VBox(
                seleccion,
                texto

                )
                , 320, 240);*/
        //Ventana que abre
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}