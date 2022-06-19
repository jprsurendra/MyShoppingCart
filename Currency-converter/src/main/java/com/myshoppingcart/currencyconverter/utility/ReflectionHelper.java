package com.myshoppingcart.currencyconverter.utility;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

public class ReflectionHelper {
    public static boolean isIterable(Type type) {
        if ( type instanceof Class && isIterableClass( ( Class ) type ) ) {
            return true;
        }
        if ( type instanceof ParameterizedType ) {
            return isIterable( ( ( ParameterizedType ) type ).getRawType() );
        }
        if ( type instanceof WildcardType ) {
            Type[] upperBounds = ( ( WildcardType ) type ).getUpperBounds();
            return upperBounds.length != 0 && isIterable( upperBounds[0] );
        }
        return false;
    }

    public static boolean isIterableClass(Class<?> clazz) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        computeClassHierarchy( clazz, classes );
        return classes.contains( Iterable.class );
    }

    public static void computeClassHierarchy(Class<?> clazz, List<Class<?>> classes) {
        for ( Class current = clazz; current != null; current = current.getSuperclass() ) {
            if ( classes.contains( current ) ) {
                return;
            }
            classes.add( current );
            for ( Class currentInterface : current.getInterfaces() ) {
                computeClassHierarchy( currentInterface, classes );
            }
        }
    }
}
