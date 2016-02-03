package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.EnumMap;

public class EnumMapDeserializer
  extends StdDeserializer<EnumMap<?, ?>>
  implements ContextualDeserializer
{
  protected final Class<?> _enumClass;
  protected JsonDeserializer<Enum<?>> _keyDeserializer;
  protected final JavaType _mapType;
  protected JsonDeserializer<Object> _valueDeserializer;
  
  public EnumMapDeserializer(JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer1, JsonDeserializer<?> paramJsonDeserializer2)
  {
    super(EnumMap.class);
    this._mapType = paramJavaType;
    this._enumClass = paramJavaType.getKeyType().getRawClass();
    this._keyDeserializer = paramJsonDeserializer1;
    this._valueDeserializer = paramJsonDeserializer2;
  }
  
  private EnumMap<?, ?> constructMap()
  {
    return new EnumMap(this._enumClass);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
  {
    JsonDeserializer localJsonDeserializer2 = this._keyDeserializer;
    if (localJsonDeserializer2 == null) {
      localJsonDeserializer2 = paramDeserializationContext.findContextualValueDeserializer(this._mapType.getKeyType(), paramBeanProperty);
    }
    for (;;)
    {
      JsonDeserializer localJsonDeserializer3 = this._valueDeserializer;
      JsonDeserializer localJsonDeserializer1;
      if (localJsonDeserializer3 == null) {
        localJsonDeserializer1 = paramDeserializationContext.findContextualValueDeserializer(this._mapType.getContentType(), paramBeanProperty);
      }
      for (;;)
      {
        return withResolved(localJsonDeserializer2, localJsonDeserializer1);
        localJsonDeserializer1 = localJsonDeserializer3;
        if ((localJsonDeserializer3 instanceof ContextualDeserializer)) {
          localJsonDeserializer1 = ((ContextualDeserializer)localJsonDeserializer3).createContextual(paramDeserializationContext, paramBeanProperty);
        }
      }
    }
  }
  
  public EnumMap<?, ?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      throw paramDeserializationContext.mappingException(EnumMap.class);
    }
    EnumMap localEnumMap = constructMap();
    Enum localEnum;
    if (paramJsonParser.nextToken() != JsonToken.END_OBJECT)
    {
      localEnum = (Enum)this._keyDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      if (localEnum == null) {
        if (paramDeserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {}
      }
    }
    for (;;)
    {
      try
      {
        if (!paramJsonParser.hasCurrentToken()) {
          break label145;
        }
        paramJsonParser = paramJsonParser.getText();
        throw paramDeserializationContext.weirdStringException(paramJsonParser, this._enumClass, "value not one of declared Enum instance names");
      }
      catch (Exception paramJsonParser)
      {
        paramJsonParser = null;
        continue;
      }
      paramJsonParser.nextToken();
      paramJsonParser.skipChildren();
      break;
      if (paramJsonParser.nextToken() == JsonToken.VALUE_NULL) {}
      for (Object localObject = null;; localObject = this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext))
      {
        localEnumMap.put(localEnum, localObject);
        break;
      }
      return localEnumMap;
      label145:
      paramJsonParser = null;
    }
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public EnumMapDeserializer withResolved(JsonDeserializer<?> paramJsonDeserializer1, JsonDeserializer<?> paramJsonDeserializer2)
  {
    if ((paramJsonDeserializer1 == this._keyDeserializer) && (paramJsonDeserializer2 == this._valueDeserializer)) {
      return this;
    }
    return new EnumMapDeserializer(this._mapType, paramJsonDeserializer1, paramJsonDeserializer2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/EnumMapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */