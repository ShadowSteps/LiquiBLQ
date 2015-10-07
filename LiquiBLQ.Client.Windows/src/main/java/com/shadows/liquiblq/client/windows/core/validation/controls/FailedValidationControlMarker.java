/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.controls;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;

/**
 *
 * @author John
 */
public class FailedValidationControlMarker extends ValidationResultMarker {

    @Override
    public MarkerBaseControl ApplyMarker(Control Field,String Message) {
        Circle ConfirmationCircle = new Circle(8);
        ConfirmationCircle.setFill(new Color(1, 0, 0, 0.7));
        ConfirmationCircle.setLayoutX(Field.getLayoutX() + Field.getWidth() - 3);
        ConfirmationCircle.setLayoutY(Field.getLayoutY() + 3);
        ConfirmationCircle.setStroke(new Color(0.5, 0, 0, 1));
        ConfirmationCircle.setVisible(true);   
        ConfirmationCircle.setStrokeType(StrokeType.INSIDE);
        ConfirmationCircle.toFront();
        
        Label Text = new Label();
        Text.setText("!");
        Text.setTextFill(new Color(1, 1, 1, 1));
        Text.setFont(new Font("System Bold",12));
        Text.setLayoutX(Field.getLayoutX() + Field.getWidth() - 5);
        Text.setLayoutY(Field.getLayoutY() - 6);
        Text.setVisible(true);
        Text.setPrefSize(5, 17);
        Text.toFront();
           
        Tooltip tp = new Tooltip(Message);
        Text.setTooltip(tp);        
        
        MarkerBaseControl Marker = new MarkerBaseControl(ConfirmationCircle, Text);
        ((AnchorPane)Field.getParent()).getChildren().add(ConfirmationCircle);
        ((AnchorPane)Field.getParent()).getChildren().add(Text);
        return Marker;
    }
    
}
