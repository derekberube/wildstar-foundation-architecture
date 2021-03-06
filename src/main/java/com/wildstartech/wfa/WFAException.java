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
package com.wildstartech.wfa;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public abstract class WFAException extends java.lang.Exception {
	// Static reference to the class name for use in logging.
	private static final String _CLASS=WFAException.class.getName();
	// Static reference to a logger object used in logging.
	private static final Logger logger=Logger.getLogger(_CLASS);
	// Used in object serialization.
	private static final long serialVersionUID = 7829090612086299448L;
	// String used to store the text of the message.
    private String message = null;
    // The resource bundle used to obtain the message text.
    private ResourceBundle resourceBundle = null;
    /**
     * Default, no-argument constructor.
     */
    public WFAException() {
        super();
        logger.entering(_CLASS,"WFAException()");
    	logger.exiting(_CLASS,"WFAException()");
    }
    /**
     * Constructor taking a resource bundle identifier as a parameter.
     * @param resourceBundleKey
     */
    public WFAException(String resourceBundleKey) {
    	logger.entering(_CLASS,"WFAException(String)");
    	// Load the specified resource bundle using the default locale.
        this.resourceBundle = ResourceBundle.getBundle(resourceBundleKey);
        logger.exiting(_CLASS,"WFAException(String)");    	
    }

    /**
     * Constructor with arguments identifying the resource bundle and locale.
     * @param resourceBundleKey
     * @param locale
     */
    public WFAException(String resourceBundleKey, Locale locale) {
    	logger.entering(_CLASS,"WFAException(String, Locale)");
    	this.resourceBundle = ResourceBundle.getBundle(resourceBundleKey, locale);
        logger.exiting(_CLASS,"WFAException(String, Locale)");    	
    }
    /**
     * Returns the message text for the exception.
     * @return java.lang.String The message text.
     */
    public String getMessage() {
    	logger.entering(_CLASS,"getMessage()");
    	logger.exiting(_CLASS,"getMessage()",this.message);
    	return this.message;
    }

    /**
     * Sets the value to be used as the text of the message.
     * @param java.lang.String msg The text to be used for the exception.
     */
    protected void setMessage(String message) {
    	logger.entering(_CLASS,"setMessage(String)",message);
    	this.message = message;
        logger.exiting(_CLASS,"setMessage(String)");    	
    }

    /**
     * Obtains the localized message based upon the given key.
     * 
     * @param java.lang.String msgKey The key to be used when obtaining a 
     * message from the <code>ResourceBundle</code> associated with this 
     * <code>Object</code>.
     */
    protected void localizeMessage(String key) {
    	logger.entering(_CLASS,"localizeMessage(String)",key);
    	setMessage((String) resourceBundle.getObject(key));
        logger.exiting(_CLASS,"localizeMessage(String)");    	
    }

    /**
     * Obtains the localized message and formats it using the elements passed in 
     * the <code>Object<code> array containing parameter.
     * 
     * @param java.lang.String key The key used to obtain the message pattern 
     * from the resource bundle which will be formatted using the objects
     * passed in the <code>Object</code> array.
     * 
     * @param java.lang.Object[] params An array of objects to be used as 
     * parameters when formatting the message.
     */
    protected void localizeMessage(String key, Object[] params) {
    	logger.entering(_CLASS,"localizeMessage(String,Object[])",
    		new Object[] {key, params});
    	String pattern=null;
        String formattedMessage=null;
        
        pattern=(String) resourceBundle.getObject(key);
        formattedMessage=MessageFormat.format(pattern, params);
        setMessage(formattedMessage);
        
        logger.exiting(_CLASS,"localizeMessage(String,Object[])");
    }
}