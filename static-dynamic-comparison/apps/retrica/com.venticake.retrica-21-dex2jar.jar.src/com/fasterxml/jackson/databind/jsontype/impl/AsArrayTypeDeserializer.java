package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;

public class AsArrayTypeDeserializer
  extends TypeDeserializerBase
  implements Serializable
{
  public AsArrayTypeDeserializer(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, String paramString, boolean paramBoolean, Class<?> paramClass)
  {
    super(paramJavaType, paramTypeIdResolver, paramString, paramBoolean, paramClass);
  }
  
  public AsArrayTypeDeserializer(AsArrayTypeDeserializer paramAsArrayTypeDeserializer, BeanProperty paramBeanProperty)
  {
    super(paramAsArrayTypeDeserializer, paramBeanProperty);
  }
  
  private final Object _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    boolean bool = paramJsonParser.isExpectedStartArrayToken();
    String str = _locateTypeId(paramJsonParser, paramDeserializationContext);
    JsonDeserializer localJsonDeserializer = _findDeserializer(paramDeserializationContext, str);
    Object localObject = paramJsonParser;
    if (this._typeIdVisible)
    {
      localObject = paramJsonParser;
      if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
      {
        localObject = new TokenBuffer(null);
        ((TokenBuffer)localObject).writeStartObject();
        ((TokenBuffer)localObject).writeFieldName(this._typePropertyName);
        ((TokenBuffer)localObject).writeString(str);
        localObject = JsonParserSequence.createFlattened(((TokenBuffer)localObject).asParser(paramJsonParser), paramJsonParser);
        ((JsonParser)localObject).nextToken();
      }
    }
    paramJsonParser = localJsonDeserializer.deserialize((JsonParser)localObject, paramDeserializationContext);
    if ((bool) && (((JsonParser)localObject).nextToken() != JsonToken.END_ARRAY)) {
      throw paramDeserializationContext.wrongTokenException((JsonParser)localObject, JsonToken.END_ARRAY, "expected closing END_ARRAY after type information and deserialized value");
    }
    return paramJsonParser;
  }
  
  protected final String _locateTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken())
    {
      if (this._defaultImpl != null) {
        return this._idResolver.idFromBaseType();
      }
      throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + baseTypeName());
    }
    if (paramJsonParser.nextToken() == JsonToken.VALUE_STRING)
    {
      paramDeserializationContext = paramJsonParser.getText();
      paramJsonParser.nextToken();
      return paramDeserializationContext;
    }
    if (this._defaultImpl != null) {
      return this._idResolver.idFromBaseType();
    }
    throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.VALUE_STRING, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")");
  }
  
  public Object deserializeTypedFromAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return _deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserializeTypedFromArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return _deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserializeTypedFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return _deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserializeTypedFromScalar(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return _deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public TypeDeserializer forProperty(BeanProperty paramBeanProperty)
  {
    if (paramBeanProperty == this._property) {
      return this;
    }
    return new AsArrayTypeDeserializer(this, paramBeanProperty);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.WRAPPER_ARRAY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/impl/AsArrayTypeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */