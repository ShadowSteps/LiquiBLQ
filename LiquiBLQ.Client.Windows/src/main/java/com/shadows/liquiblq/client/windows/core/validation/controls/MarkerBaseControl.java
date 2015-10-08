/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.controls;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author John
 */
public class MarkerBaseControl {
    private final Circle BackgroundCircle;
    private final Label Sign;

    public Circle getBackgroundCircle() {
        return BackgroundCircle;
    }

    public Label getSign() {
        return Sign;
    }
    public MarkerBaseControl(Circle Background,Label Text){
        this.BackgroundCircle = Background;
        this.Sign = Text;
    }
   
}
