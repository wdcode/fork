package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;

import java.lang.reflect.Type;

/**
 * Created by wenshao on 15/07/2017.
 */
public class PropertyProcessableDeserializer implements ObjectDeserializer {
    public final Class<PropertyProcessable> type;

    public PropertyProcessableDeserializer(Class<PropertyProcessable> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
	public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        PropertyProcessable processable;
        try {
            processable = this.type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new JSONException("craete instance error");
        }

        Object object =parser.parse(processable, fieldName);

        return (T) object;
    }

    public int getFastMatchToken() {
        return JSONToken.LBRACE;
    }
}
