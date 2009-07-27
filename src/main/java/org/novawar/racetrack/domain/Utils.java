package org.novawar.racetrack.domain;

import java.lang.reflect.Field;

/**
 *
 * @author ywang29
 */
public class Utils {
    public static Object getPropertyValue(Object obj, String property) {
        Class<?> clazz = obj.getClass();
        try {
            Field field = clazz.getDeclaredField(property);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
