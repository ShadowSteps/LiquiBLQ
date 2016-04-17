/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets.base;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author John
 */
public abstract class BaseSet<TEntity, TDTO> {
    protected SessionFactory factory; 
    public BaseSet() {
        factory = new Configuration().configure().buildSessionFactory(null);
    }
    protected abstract TDTO ConvertEntityToDTO(TEntity entity);
    protected List<TDTO> ConvertEntityArrayToDTOArray(List<TEntity> list){
        List<TDTO> DTOs = new ArrayList<>();
        for (TEntity entity : list) {
            DTOs.add(ConvertEntityToDTO(entity));
        }
        return DTOs;
    }
}
