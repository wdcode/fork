/*
 * Copyright (C) 2014, 2017 XStream Committers.
 * All rights reserved.
 *
 * Created on 09. January 2014 by Joerg Schaible
 */
package com.thoughtworks.xstream.security;

import com.thoughtworks.xstream.core.util.Primitives;


/**
 * Permission for any primitive type and its boxed counterpart (excl. void).
 * 
 * @author J&ouml;rg Schaible
 * @since 1.4.7
 */
@SuppressWarnings({ "rawtypes" })
public class PrimitiveTypePermission implements TypePermission {
    /**
     * @since 1.4.7
     */
    public static final TypePermission PRIMITIVES = new PrimitiveTypePermission();

    public boolean allows(Class type) {
        return type != null && type != void.class && type != Void.class && type.isPrimitive()
            || Primitives.isBoxed(type);
    }

    public int hashCode() {
        return 7;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == PrimitiveTypePermission.class;
    }
}
