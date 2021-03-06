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
package com.wildstartech.wfa.dao;

import java.util.Date;

import com.wildstartech.wfa.identifiable.Identifiable;

public interface WildObject extends Identifiable<String> {
   public String RESOURCE_BUNDLE="com.wildstartech.wfa.dao.WildObjectResources";
   
   /**
    * Returns the name of the <code>User</code> who initially created the object.
    */
   public String getCreatedBy();
   
   /**
	 * Returns the date/time the <code>WildObject</code> was created.
	 * @return
	 */
	public Date getDateCreated();
	/**
	 * Returns the date/time the <code>WildObject</code> was modified.
	 * @return
	 */
   public Date getDateModified(); 
	
   /**
    * Returns the unique identifier for the <code>WildObject</code>.
    */
   public String getIdentifier();
   
   /**
    * Returns a localized message formatted with the values passed to the
    * method in the {@code Object} array passed as a parameter.
    * 
    * <p>Implementations of this message should try to resolve the message
    * with the specified {@code resourceId}.  If they cannot, then they 
    * should delegate to their super class.</p>
    * 
    * @param resourceId An identifier which is used to identify the 
    * appropriate message template in the {@code ResourceBundle}.
    * 
    * @param params An array of {@code Object} instances that should be 
    * substituted into variables in the specified message template.
    * @return
    */
   public String getLocalizedMessage(String resourceId, Object[] params);
   
   /**
	 * Returns the name of the <code>User</code> who last modified the object.
	 */
	public String getModifiedBy();
	
	/**
	 * Returns the {@code baseName} for the {@code ResourceBundle} that should
	 * be used when localizing messages. 
	 * @return A string value that will be used by the 
	 * {@code getLocalizedMessage} method to return the requested localized
	 * resource.
	 */
	public String getResourceBundleBaseName();
}