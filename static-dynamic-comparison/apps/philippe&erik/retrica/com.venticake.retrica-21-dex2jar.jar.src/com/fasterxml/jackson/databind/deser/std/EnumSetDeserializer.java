package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.EnumSet;

public class EnumSetDeserializer
  extends StdDeserializer<EnumSet<?>>
  implements ContextualDeserializer
{
  protected final Class<Enum> _enumClass;
  protected JsonDeserializer<Enum<?>> _enumDeserializer;
  protected final JavaType _enumType;
  
  public EnumSetDeserializer(JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(EnumSet.class);
    this._enumType = paramJavaType;
    this._enumClass = paramJavaType.getRawClass();
    this._enumDeserializer = paramJsonDeserializer;
  }
  
  private EnumSet constructSet()
  {
    return EnumSet.noneOf(this._enumClass);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
  {
    JsonDeserializer localJsonDeserializer2 = this._enumDeserializer;
    JsonDeserializer localJsonDeserializer1;
    if (localJsonDeserializer2 == null) {
      localJsonDeserializer1 = paramDeserializationContext.findContextualValueDeserializer(this._enumType, paramBeanProperty);
    }
    for (;;)
    {
      return withDeserializer(localJsonDeserializer1);
      localJsonDeserializer1 = localJsonDeserializer2;
      if ((localJsonDeserializer2 instanceof ContextualDeserializer)) {
        localJsonDeserializer1 = ((ContextualDeserializer)localJsonDeserializer2).createContextual(paramDeserializationContext, paramBeanProperty);
      }
    }
  }
  
  public EnumSet<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      throw paramDeserializationContext.mappingException(EnumSet.class);
    }
    EnumSet localEnumSet = constructSet();
    for (;;)
    {
      Object localObject = paramJsonParser.nextToken();
      if (localObject == JsonToken.END_ARRAY) {
        break;
      }
      if (localObject == JsonToken.VALUE_NULL) {
        throw paramDeserializationContext.mappingException(this._enumClass);
      }
      localObject = (Enum)this._enumDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      if (localObject != null) {
        localEnumSet.add(localObject);
      }
    }
    return localEnumSet;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public EnumSetDeserializer withDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    if (this._enumDeserializer == paramJsonDeserializer) {
      return this;
    }
    return new EnumSetDeserializer(this._enumType, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/EnumSetDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */