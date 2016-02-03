package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.databind.JavaType;

public abstract interface TypeIdResolver
{
  public abstract String idFromBaseType();
  
  public abstract String idFromValueAndType(Object paramObject, Class<?> paramClass);
  
  public abstract void init(JavaType paramJavaType);
  
  public abstract JavaType typeFromId(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/TypeIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */