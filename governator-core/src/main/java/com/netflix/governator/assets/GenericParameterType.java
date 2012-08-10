package com.netflix.governator.assets;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericParameterType<T>
{
    private final Type type;

    protected GenericParameterType()
    {
        this.type = getSuperclassTypeParameter(getClass());
    }

    public T getValue() // exists only to keep this generic
    {
        return null;
    }

    public Type getType()
    {
        return type;
    }

    // copied from javax.ws.rs.core.GenericEntity
    private static Type getSuperclassTypeParameter(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();
        if ( !(superclass instanceof ParameterizedType) )
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType)superclass;
        return parameterized.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        GenericParameterType that = (GenericParameterType)o;

        //noinspection RedundantIfStatement
        if ( !type.equals(that.type) )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return type.hashCode();
    }
}