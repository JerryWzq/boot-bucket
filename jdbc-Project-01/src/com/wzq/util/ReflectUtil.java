package com.wzq.util;

import java.lang.reflect.Field;

public class ReflectUtil {

    public static void invoke(Object object, String fieldName, Object value) {
        try {
            Field declaredField = object.getClass().getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            declaredField.set(object, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param object
     * @param fieldName
     * @param value
     * @param mapUnderscoreToCamelCase 下划线转为驼峰命名
     */
    public static void invoke(Object object, String fieldName, Object value, boolean mapUnderscoreToCamelCase){
        try {
            String newFiled;
            if(mapUnderscoreToCamelCase){
                newFiled =  mapUnderscoreToCamelCase(fieldName);
            }else {
                newFiled = fieldName;
            }
            Field declaredField = object.getClass().getDeclaredField(newFiled);
            declaredField.setAccessible(true);
            declaredField.set(object, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String mapUnderscoreToCamelCase(String field){
        StringBuilder builder = new StringBuilder();
        String[] s = field.split("_");
        for(int i=0; i<s.length; i++){
            if (i == 0) {
                builder.append(s[i]);
            }else{
                String da = (new StringBuilder()).append(Character.toUpperCase(s[i].charAt(0))).append(s[i].substring(1)).toString();
                builder.append(da);
            }
        }
        return builder.toString();
    }

}
