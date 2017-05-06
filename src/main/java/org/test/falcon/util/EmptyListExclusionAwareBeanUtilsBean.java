package org.test.falcon.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.test.falcon.model.filter.FieldsMapLoader;

/**
 * Also ignore empty list
 * 
 */
public class EmptyListExclusionAwareBeanUtilsBean extends ExclusionAwareBeanUtilsBean {
    @Override
    public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException,
            InvocationTargetException {
        Field field = FieldsMapLoader.getField(dest.getClass(), name);

        if (field != null && field.getType().equals(List.class) && CollectionUtils.isEmpty((List) value)) {
            return;
        }
        else {
            super.copyProperty(dest, name, value);
        }
    }
}
