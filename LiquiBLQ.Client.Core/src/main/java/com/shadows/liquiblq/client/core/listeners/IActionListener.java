/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.listeners;

import com.shadows.liquiblq.client.core.events.IActionEvent;

/**
 *
 * @author John
 */
public interface IActionListener {
    public void trigger(IActionEvent event);
}
