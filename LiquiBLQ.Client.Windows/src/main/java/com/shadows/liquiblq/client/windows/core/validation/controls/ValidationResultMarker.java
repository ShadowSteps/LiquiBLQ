/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.controls;

import javafx.scene.control.Control;

/**
 *
 * @author John
 */
public abstract class ValidationResultMarker {
    public abstract MarkerBaseControl ApplyMarker(Control Field,String Message);
}
