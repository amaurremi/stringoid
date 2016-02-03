package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.Serializable;

public final class ObjectIdReader
  implements Serializable
{
  public final JsonDeserializer<Object> deserializer;
  public final ObjectIdGenerator<?> generator;
  public final SettableBeanProperty idProperty;
  public final JavaType idType;
  public final String propertyName;
  
  protected ObjectIdReader(JavaType paramJavaType, String paramString, ObjectIdGenerator<?> paramObjectIdGenerator, JsonDeserializer<?> paramJsonDeserializer, SettableBeanProperty paramSettableBeanProperty)
  {
    this.idType = paramJavaType;
    this.propertyName = paramString;
    this.generator = paramObjectIdGenerator;
    this.deserializer = paramJsonDeserializer;
    this.idProperty = paramSettableBeanProperty;
  }
  
  public static ObjectIdReader construct(JavaType paramJavaType, String paramString, ObjectIdGenerator<?> paramObjectIdGenerator, JsonDeserializer<?> paramJsonDeserializer, SettableBeanProperty paramSettableBeanProperty)
  {
    return new ObjectIdReader(paramJavaType, paramString, paramObjectIdGenerator, paramJsonDeserializer, paramSettableBeanProperty);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/ObjectIdReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */