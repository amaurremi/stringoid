package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;

public final class ObjectIdWriter
{
  public final boolean alwaysAsId;
  public final ObjectIdGenerator<?> generator;
  public final JavaType idType;
  public final SerializedString propertyName;
  public final JsonSerializer<Object> serializer;
  
  protected ObjectIdWriter(JavaType paramJavaType, SerializedString paramSerializedString, ObjectIdGenerator<?> paramObjectIdGenerator, JsonSerializer<?> paramJsonSerializer, boolean paramBoolean)
  {
    this.idType = paramJavaType;
    this.propertyName = paramSerializedString;
    this.generator = paramObjectIdGenerator;
    this.serializer = paramJsonSerializer;
    this.alwaysAsId = paramBoolean;
  }
  
  public static ObjectIdWriter construct(JavaType paramJavaType, String paramString, ObjectIdGenerator<?> paramObjectIdGenerator, boolean paramBoolean)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = new SerializedString(paramString)) {
      return new ObjectIdWriter(paramJavaType, paramString, paramObjectIdGenerator, null, paramBoolean);
    }
  }
  
  public ObjectIdWriter withAlwaysAsId(boolean paramBoolean)
  {
    if (paramBoolean == this.alwaysAsId) {
      return this;
    }
    return new ObjectIdWriter(this.idType, this.propertyName, this.generator, this.serializer, paramBoolean);
  }
  
  public ObjectIdWriter withSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    return new ObjectIdWriter(this.idType, this.propertyName, this.generator, paramJsonSerializer, this.alwaysAsId);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/ObjectIdWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */