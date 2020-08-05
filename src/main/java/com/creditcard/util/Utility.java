package com.creditcard.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {

    public static Object modelAndEntityConverter(Object firstObject) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        StringBuilder className = new StringBuilder("model");
        className.append(firstObject.getClass().getName().substring(firstObject.getClass().getName().indexOf(".")));
        className.append("Model");
        Object personModel = Class.forName(className.toString()).newInstance();

        exchangeInComeObjectToOutPutObject(firstObject, personModel);
        return personModel;
    }

    public static Object modelAndEntityConverter(Object firstObject,String fullClassName) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        Object secondObject = null;

        if (fullClassName!=null && !fullClassName.trim().equals("")) {
            secondObject= Class.forName(fullClassName).newInstance();
            exchangeInComeObjectToOutPutObject(firstObject, secondObject);
        }
        return secondObject;
    }

    public static void exchangeInComeObjectToOutPutObject(Object baseObject, Object filledObject) throws IllegalAccessException {
        Class<?> aClass = baseObject.getClass();
        List<Field> allFields =new ArrayList<Field>();
        while(aClass.getSuperclass()!=null ){
            allFields.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass();
        }
        for (Field field : allFields) {
            field.setAccessible(true);
            set(filledObject,field.getName(),field.get(baseObject));
        }
        return;
    }

    private static boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

}


