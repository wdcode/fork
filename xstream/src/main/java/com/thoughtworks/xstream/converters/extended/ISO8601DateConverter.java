/*
 * Copyright (C) 2004, 2005 Joe Walnes.
 * Copyright (C) 2006, 2007, 2017, 2018 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 22. November 2004 by Mauro Talevi
 */
package com.thoughtworks.xstream.converters.extended;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;


/**
 * A DateConverter conforming to the ISO8601 standard.
 * http://www.iso.ch/iso/en/CatalogueDetailPage.CatalogueDetail?CSNUMBER=26780
 * 
 * @author Mauro Talevi
 * @author J&ouml;rg Schaible
 */
@SuppressWarnings({"rawtypes"})
public class ISO8601DateConverter extends AbstractSingleValueConverter {
    private final ISO8601GregorianCalendarConverter converter = new ISO8601GregorianCalendarConverter();

    public boolean canConvert(Class type) {
        return type == Date.class && converter.canConvert(GregorianCalendar.class);
    }

    public Object fromString(String str) {
        return ((Calendar)converter.fromString(str)).getTime();
    }

    public String toString(Object obj) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date)obj);
        return converter.toString(calendar);
    }
}