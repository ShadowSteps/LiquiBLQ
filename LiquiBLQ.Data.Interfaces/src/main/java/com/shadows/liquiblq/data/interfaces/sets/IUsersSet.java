/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets;

import com.shadows.liquiblq.data.interfaces.dto.User;
import com.shadows.liquiblq.data.interfaces.dto.data.UserData;
import com.shadows.liquiblq.data.interfaces.sets.base.IManagableSet;
import com.shadows.liquiblq.data.interfaces.sets.base.IViewableSet;

/**
 *
 * @author John
 */
public interface IUsersSet extends IViewableSet<Integer, User>,
        IManagableSet<Integer, UserData>{
    public User GetByEmail(String Email) throws Exception;
    public User GetByEmailAndPassword(String Email,String Password) throws Exception;
}
