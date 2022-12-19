package com.example.di_1;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class AlumnosCell extends ListCell<Alumno> {


    @Override
    protected void updateItem(Alumno alumno, boolean empty) {
        super.updateItem(alumno, empty);

        if(alumno == null || empty){
            setGraphic(null);
        }else{
            setGraphic(
                    new HBox(
                            new Label(){{
                                textProperty().bind(alumno.nombreProperty);
                                setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY )));
                            }},

                            new Label(){{
                                textProperty().bind(alumno.apellidosProperty);
                                setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY )));
                                setTextFill(Color.WHITE);
                            }},

                            new Label(){{
                                Bindings.bindBidirectional(textProperty(), alumno.notaProperty, new NumberStringConverter());

                                if(alumno.getNota() < 5)
                                    setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY )));
                                else
                                    setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY )));

                                setTextFill(Color.WHITE);
                            }},

                            new Label(){{
                                Bindings.bindBidirectional(textProperty(), alumno.edadProperty, new NumberStringConverter());
                                setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY )));
                            }}
                    ){{ setSpacing(100);}}
            );
        }



    }
}
