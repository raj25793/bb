/**
 * 
 */
package org.test.falcon.model.filter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.core.annotation.AnnotationUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mandeep
 * 
 */
public class FieldsMapLoader {
    static private ConcurrentMap<Class<?>, ConcurrentMap<String, Field>> fieldsMap = new ConcurrentHashMap<>();

    public static Map<String, Field> getFieldMap(Class<?> clazz) {
        if (!fieldsMap.containsKey(clazz)) {
            loadClassFields(clazz);
        }

        return fieldsMap.get(clazz);
    }

    public static Object getFieldValueFromFieldName(Class<?> clazz, String name, Object object)
            throws IllegalArgumentException, IllegalAccessException {
        if (!fieldsMap.containsKey(clazz)) {
            loadClassFields(clazz);
        }
        Field field = fieldsMap.get(clazz).get(name);
        if (field != null) {
            field.setAccessible(true);
            return field.get(object);
        }

        return null;
    }

    /**
     * to get all the fields with annotation passed
     * 
     * @param clazz
     * @param annotation
     * @return the set of fields
     */
    public static Set<Field> findFieldsWithAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
        Set<Field> set = new LinkedHashSet<>();
        Class<?> c = clazz;
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(annotation)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }

    public static Field getField(Class<?> clazz, String name) {
        if (!fieldsMap.containsKey(clazz)) {
            loadClassFields(clazz);
        }

        return fieldsMap.get(clazz).get(name);
    }

    /**
     * This method check if the field in the given class. If not found, it will
     * recursively check in the parent classes
     * 
     * @author Saif Khan
     * @param clazz
     * @param name
     * @return Field
     */
    public static Field getFieldWhileCheckingRecursively(Class<?> clazz, String name) {
        Class<?> superClass = clazz;
        while (superClass.getName() != java.lang.Object.class.getName()) {
            Field field = getField(superClass, name);
            if (field != null) {
                return field;
            }
            superClass = superClass.getSuperclass();
        }
        return null;
    }

    private static void loadClassFields(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            Annotation annotation = field.getAnnotation(JsonProperty.class);
            fieldsMap.putIfAbsent(clazz, new ConcurrentHashMap<String, Field>());

            if (annotation != null) {
                fieldsMap.get(clazz)
                        .putIfAbsent((String) AnnotationUtils.getAnnotationAttributes(annotation).get("value"), field);
            }
            else {
                fieldsMap.get(clazz).putIfAbsent(field.getName(), field);
            }
        }
    }

    /**
     * Contains fields meta info like 1. if field is direct field 2. if field is
     * transient 3. if field present in model class
     * 
     * @author Rajeev Pandey
     *
     */
    public static class FieldMetaInfo {
        private boolean isTransientField;
        /*
         * this signifies if a field is direct column in corresponding table
         * associated with this model
         */
        private boolean isDirectFieldInModel;
        private boolean isFieldInModel;

        public boolean isTransientField() {
            return isTransientField;
        }

        public void setTransientField(boolean isTransientField) {
            this.isTransientField = isTransientField;
        }

        public boolean isDirectFieldInModel() {
            return isDirectFieldInModel;
        }

        public void setDirectFieldInModel(boolean isDirectFieldInModel) {
            this.isDirectFieldInModel = isDirectFieldInModel;
        }

        public boolean isFieldInModel() {
            return isFieldInModel;
        }

        public void setFieldInModel(boolean isFieldInModel) {
            this.isFieldInModel = isFieldInModel;
        }

    }
}
