package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.std.ObjectArrayDeserializer;
import org.codehaus.jackson.map.type.ArrayType;

@Deprecated
public class ArrayDeserializer
  extends ObjectArrayDeserializer
{
  @Deprecated
  public ArrayDeserializer(ArrayType paramArrayType, JsonDeserializer paramJsonDeserializer)
  {
    this(paramArrayType, paramJsonDeserializer, null);
  }
  
  public ArrayDeserializer(ArrayType paramArrayType, JsonDeserializer paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    super(paramArrayType, paramJsonDeserializer, paramTypeDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/ArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */