/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets.base;

import java.util.List;

/**
 *
 * @author John
 */
public interface IViewableSet<TKey,TClass> {
    public List<TClass> GetAll() throws Exception;
    public TClass GetById(TKey Id) throws Exception;
}
