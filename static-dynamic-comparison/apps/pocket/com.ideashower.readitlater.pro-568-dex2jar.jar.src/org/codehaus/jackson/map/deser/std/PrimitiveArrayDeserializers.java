package org.codehaus.jackson.map.deser.std;

import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.type.TypeFactory;

public class PrimitiveArrayDeserializers
{
  static final PrimitiveArrayDeserializers instance = new PrimitiveArrayDeserializers();
  HashMap _allDeserializers = new HashMap();
  
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
  
  private void add(Class paramClass, JsonDeserializer paramJsonDeserializer)
  {
    this._allDeserializers.put(TypeFactory.defaultInstance().constructType(paramClass), paramJsonDeserializer);
  }
  
  public static HashMap getAll()
  {
    return instance._allDeserializers;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/PrimitiveArrayDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */