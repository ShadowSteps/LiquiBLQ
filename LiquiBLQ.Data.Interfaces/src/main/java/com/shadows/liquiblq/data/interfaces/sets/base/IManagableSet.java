/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets.base;

/**
 *
 * @author John
 */
public interface IManagableSet<TKey,TDataClass> {
    public TKey Add(TDataClass Data) throws Exception;
    public void Edit(TKey Key,TDataClass Data) throws Exception;
    public void Delete(TKey Key) throws Exception;
}
