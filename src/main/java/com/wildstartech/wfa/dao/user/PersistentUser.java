/*
 * Copyright (c) 2001 - 2016 Wildstar Technologies, LLC.
 *
 * This file is part of Wildstar Foundation Architecture.
 *
 * Wildstar Foundation Architecture is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * Wildstar Foundation Architecture is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Wildstar Foundation Architecture.  If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * Linking this library statically or dynamically with other modules is making a
 * combined work based on this library. Thus, the terms and conditions of the 
 * GNU General Public License cover the whole combination.
 * 
 * As a special exception, the copyright holders of this library give you 
 * permission to link this library with independent modules to produce an 
 * executable, regardless of the license terms of these independent modules, 
 * and to copy and distribute the resulting executable under terms of your 
 * choice, provided that you also meet, for each linked independent module, the
 * terms and conditions of the license of that module. An independent module is
 * a module which is not derived from or based on this library. If you modify 
 * this library, you may extend this exception to your version of the library, 
 * but you are not obliged to do so. If you do not wish to do so, delete this 
 * exception statement from your version.
 * 
 * If you need additional information or have any questions, please contact:
 *
 *      Wildstar Technologies, LLC.
 *      63 The Greenway Loop
 *      Panama City Beach, FL 32413
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
package com.wildstartech.wfa.dao.user;

import java.util.List;

import com.wildstartech.wfa.dao.WildObject;
import com.wildstartech.wfa.dao.group.PersistentGroup;
import com.wildstartech.wfa.group.Group;
import com.wildstartech.wfa.user.PasswordTooLongException;
import com.wildstartech.wfa.user.User;
import com.wildstartech.wfa.user.UserNameTooLongException;

public interface PersistentUser 
extends WildObject, User {
	/**
	 * Identifies the ResourceBundle prefix that should be used for this object.
	 */
	public static final String RESOURCE_BUNDLE_KEY=
		"com.wildstartech.wfa.dao.resources.User";
	
	/**
	 * Update this persistent class using information from the specified,
	 * non-persistent object.
	 * 
	 * @param source The reference object whose data should be used to 
	 * update the current object.
	 * 
	 * @see CRM00176 
    * @author Derek Berube, Wildstar Technologies, LLC.
	 */
	public void updateFromObject(User source);
	
	//********** federatedId
	/**
	 * Returns an indicator as to whether the account is federated.
	 * 
	 * <p>Indicates whether or not the user account is federated with some
	 * external authentication framework.</p>
	 */
	public boolean isFederated();
	/**
	 * Used to specify whether or not the user account is a federated account.
	 */
	public void setFederated(boolean federated);
	//********** groups
	/**
	 * Add the user as a member of the specified group.
	 */
	public void addGroup(PersistentGroup group);
	/**
	 * Removes the user as a member of the specified group.
	 */
	public void removeGroup(PersistentGroup group);
	/**
	 * Returns a list of groups the user is associated with.
	 */
	public List<Group> getGroups();
	//********** name
	/**
	 * Returns the current value of <code>name</code> property.
	 * @return java.lang.String The name presently assigned to the user.
	 */
	public String getName();
	/**
	 * Sets the value for the <code>name</code> property of the User object.
	 * @param name
	 * @throws UserNameTooLongException
	 */
	public void setName(String name) throws UserNameTooLongException;
	//********** password
	/**
	 * Returns the password.
	 */
	public abstract String getPassword();
	/**
	 * Sets the value for the <code>password</code> property of the User object.
	 */
	public abstract void setPassword(String name)
            throws PasswordTooLongException;	
}