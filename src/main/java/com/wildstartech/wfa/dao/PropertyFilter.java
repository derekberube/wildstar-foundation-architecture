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

import java.util.logging.Logger;

public class PropertyFilter<T> implements Filter {
   private static final String _CLASS=PropertyFilter.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   public static enum FilterOperator {
      LESS, 
      LESS_OR_EQUAL, 
      EQUAL, 
      GREATER_OR_EQUAL, 
      GREATER 
      };
      
   private FilterOperator filterOperator=null;
   private String propertyName="";
   private T propertyValue=null;
      
   /**
    * The {@code FilterOperator} that should be used when filtering the
    * specified property.
    * 
    * @return The {@code FilterOperator} that should be used when applying
    * the {@code Filter} that looks for the {@code propertyValue} in the
    * specified {@code propertyName}.
    */
   public FilterOperator getFilterOperator() {
      logger.entering(_CLASS, "getFilterOperator()");
      logger.exiting(_CLASS, "getFilterOperator()",this.filterOperator);
      return this.filterOperator;
   }
   /**
    * Stores the {@code FilterOperator} that should be used when applying
    * the {@code Filter} against the query.
    * @param operator The {@code FilterOperator} that should be used when 
    * processing the results of the query.
    */
   public void setFilterOperator(FilterOperator filterOperator) {
      logger.entering(_CLASS, "setFilterOperator(FilterOperator)",
            filterOperator);
      this.filterOperator=filterOperator;
      logger.exiting(_CLASS, "setFilterOperator(FilterOperator)");
   }
   
   /**
    * Returns the name of the property.
    * @return
    */
   public String getPropertyName() {
      logger.entering(_CLASS, "getPropertyName()");
      logger.exiting(_CLASS, "getPropertyName()",this.propertyName);
      return this.propertyName;
   }
   /**
    * Stores the name of the property to which the filter should be applied
    * when executing the query.
    * 
    * @param propertyName The name of the property against which the specified
    * filter should be applied.
    */
   public void setPropertyName(String propertyName) {
      logger.entering(_CLASS, "setPropertyName(String)",propertyName);
      if (propertyName == null) {
         this.propertyName="";
      } else {
         this.propertyName=propertyName;
      } // END if (propertyName == null)
      logger.exiting(_CLASS, "setPropertyName(String)");
   }
   
   //*****
   /**
    * Returns the value of the property which should be used in filtering. 
    * 
    * @return The value for the property that should be filtered.
    */
   public T getPropertyValue() {
      logger.entering(_CLASS, "getPropertyValue()");
      logger.exiting(_CLASS, "getPropertyValue()",this.propertyValue);
      return this.propertyValue;
   }
   /**
    * Stores the value that should be used when filtering query results.
    * 
    * @param propertyValue The value that should be used when filtering 
    * query results.
    */
   public void setPropertyValue(T propertyValue) {
      logger.entering(_CLASS, "setPropertyValue(T)",propertyValue);
      this.propertyValue=propertyValue;
      logger.exiting(_CLASS, "setPropertyValue(T)");
   }
}