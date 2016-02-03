package com.flurry.org.codehaus.jackson.map.jsontype;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import com.flurry.org.codehaus.jackson.type.JavaType;

public abstract interface TypeIdResolver
{
  public abstract JsonTypeInfo.Id getMechanism();
  
  public abstract String idFromValue(Object paramObject);
  
  public abstract String idFromValueAndType(Object paramObject, Class<?> paramClass);
  
  public abstract void init(JavaType paramJavaType);
  
  public abstract JavaType typeFromId(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/jsontype/TypeIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */