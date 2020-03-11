/*
 * Copyright (C) 2003, 2004 Joe Walnes.
 * Copyright (C) 2006, 2007, 2018 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 26. September 2003 by Joe Walnes
 */
package com.thoughtworks.xstream.converters.basic;

/**
 * Converts a float primitive or java.lang.Float wrapper to
 * a String.
 *
 * @author Joe Walnes
 */
public class FloatConverter extends AbstractSingleValueConverter {

    @SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
        return type == float.class || type == Float.class;
    }

    public Object fromString(String str) {
        return Float.valueOf(str);
    }

}
