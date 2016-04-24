/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets.base;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.PostgresUUIDType;

/**
 *
 * @author John
 * @param <TEntity>
 * @param <TDTO>
 */
public abstract class BaseSet<TEntity, TDTO> {
    protected SessionFactory factory; 
    public BaseSet() {
        Configuration configuration = new Configuration().configure();
        configuration.registerTypeOverride(new PostgresUUIDType());
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        factory = configuration.configure().buildSessionFactory(serviceRegistry);
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
