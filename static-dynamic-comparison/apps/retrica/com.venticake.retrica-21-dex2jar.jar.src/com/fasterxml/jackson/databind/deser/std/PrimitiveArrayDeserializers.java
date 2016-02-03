package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.HashMap;

public class PrimitiveArrayDeserializers
{
  static final PrimitiveArrayDeserializers instance = new PrimitiveArrayDeserializers();
  HashMap<JavaType, JsonDeserializer<Object>> _allDeserializers = new HashMap();
  
  protected PrimitiveArrayDeserializers()
  {
    add(Boolean.TYPE, new PrimitiveArrayDeserializers.BooleanDeser());
    add(Byte.TYPE, new PrimitiveArrayDeserializers.ByteDeser());
    add(Short.TYPE, new PrimitiveArrayDeserializers.ShortDeser());
    add(Integer.TYPE, new PrimitiveArrayDeserializers.IntDeser());
    add(Long.TYPE, new PrimitiveArrayDeserializers.LongDeser());
    add(Float.TYPE, new PrimitiveArrayDeserializers.FloatDeser());
    add(Double.TYPE, new PrimitiveArrayDeserializers.DoubleDeser());
    add(String.class, new PrimitiveArrayDeserializers.StringDeser());
    add(Character.TYPE, new PrimitiveArrayDeserializers.CharDeser());
  }
  
  private void add(Class<?> paramClass, JsonDeserializer<?> paramJsonDeserializer)
  {
    this._allDeserializers.put(TypeFactory.defaultInstance().constructType(paramClass), paramJsonDeserializer);
  }
  
  public static HashMap<JavaType, JsonDeserializer<Object>> getAll()
  {
    return instance._allDeserializers;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */