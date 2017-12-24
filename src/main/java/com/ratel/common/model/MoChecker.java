package com.ratel.common.model;

import com.ratel.common.model.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MoChecker {

    public static String checkInsert(Object o) throws IllegalAccessException {
        return check(o, true);
    }

    public static String checkUpdate(Object o) throws IllegalAccessException {
        return check(o, false);
    }

    public static String check(Object o, boolean insert) throws IllegalAccessException {
        if (o != null) {
            Class<?> classz = o.getClass();
            Field[] fields = classz.getDeclaredFields();

            List<String> emptyValues = new ArrayList<String>();
            if (fields != null && fields.length > 0) {
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    Annotation annotation = null;
                    if (insert) {
                        annotation = field.getAnnotation(InsertRequiredAnno.class);
                    } else {
                        annotation = field.getAnnotation(UpdateRequiredAnno.class);
                    }
                    if (annotation != null) {
                        Object value = field.get(o);
                        if (isNullOrEmpty(value)) {
                            emptyValues.add(field.getName());
                        }
                    }
                }
            }
            return String.join(",", emptyValues);
        }
        return "对象不能为空！";
    }

    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return obj.toString().trim().length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

}
