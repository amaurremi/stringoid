package org.codehaus.jackson.map.jsontype.impl;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.JsonParserSequence;
import org.codehaus.jackson.util.TokenBuffer;

public class AsPropertyTypeDeserializer
  extends AsArrayTypeDeserializer
{
  protected final String _typePropertyName;
  
  public AsPropertyTypeDeserializer(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty, Class paramClass, String paramString)
  {
    super(paramJavaType, paramTypeIdResolver, paramBeanProperty, paramClass);
    this._typePropertyName = paramString;
  }
  
  @Deprecated
  public AsPropertyTypeDeserializer(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty, String paramString)
  {
    this(paramJavaType, paramTypeIdResolver, paramBeanProperty, null, paramString);
  }
  
  protected Object _deserializeIfNatural(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (!this._baseType.getRawClass().isAssignableFrom(String.class));
            return paramJsonParser.getText();
          } while (!this._baseType.getRawClass().isAssignableFrom(Integer.class));
          return Integer.valueOf(paramJsonParser.getIntValue());
        } while (!this._baseType.getRawClass().isAssignableFrom(Double.class));
        return Double.valueOf(paramJsonParser.getDoubleValue());
      } while (!this._baseType.getRawClass().isAssignableFrom(Boolean.class));
      return Boolean.TRUE;
    } while (!this._baseType.getRawClass().isAssignableFrom(Boolean.class));
    return Boolean.FALSE;
  }
  
  protected Object _deserializeTypedUsingDefaultImpl(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TokenBuffer paramTokenBuffer)
  {
    Object localObject;
    if (this._defaultImpl != null)
    {
      JsonDeserializer localJsonDeserializer = _findDefaultImplDeserializer(paramDeserializationContext);
      localObject = paramJsonParser;
      if (paramTokenBuffer != null)
      {
        paramTokenBuffer.writeEndObject();
        localObject = paramTokenBuffer.asParser(paramJsonParser);
        ((JsonParser)localObject).nextToken();
      }
      paramTokenBuffer = localJsonDeserializer.deserialize((JsonParser)localObject, paramDeserializationContext);
    }
    do
    {
      return paramTokenBuffer;
      localObject = _deserializeIfNatural(paramJsonParser, paramDeserializationContext);
      paramTokenBuffer = (TokenBuffer)localObject;
    } while (localObject != null);
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      return super.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    }
    throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.FIELD_NAME, "missing property '" + this._typePropertyName + "' that is to contain type id  (for class " + baseTypeName() + ")");
  }
  
  public Object deserializeTypedFromAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      return super.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
    }
    return deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserializeTypedFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1;
    Object localObject3;
    if (localObject2 == JsonToken.START_OBJECT)
    {
      localObject1 = paramJsonParser.nextToken();
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      if (localObject2 != JsonToken.FIELD_NAME) {
        break label184;
      }
      localObject3 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      if (this._typePropertyName.equals(localObject3))
      {
        localObject3 = _findDeserializer(paramDeserializationContext, paramJsonParser.getText());
        localObject2 = paramJsonParser;
        if (localObject1 != null) {
          localObject2 = JsonParserSequence.createFlattened(((TokenBuffer)localObject1).asParser(paramJsonParser), paramJsonParser);
        }
        ((JsonParser)localObject2).nextToken();
        return ((JsonDeserializer)localObject3).deserialize((JsonParser)localObject2, paramDeserializationContext);
        if (localObject2 == JsonToken.START_ARRAY) {
          return _deserializeTypedUsingDefaultImpl(paramJsonParser, paramDeserializationContext, null);
        }
        localObject1 = localObject2;
        if (localObject2 == JsonToken.FIELD_NAME) {
          break;
        }
        return _deserializeTypedUsingDefaultImpl(paramJsonParser, paramDeserializationContext, null);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new TokenBuffer(null);
      }
      ((TokenBuffer)localObject2).writeFieldName((String)localObject3);
      ((TokenBuffer)localObject2).copyCurrentStructure(paramJsonParser);
      localObject3 = paramJsonParser.nextToken();
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    label184:
    return _deserializeTypedUsingDefaultImpl(paramJsonParser, paramDeserializationContext, (TokenBuffer)localObject1);
  }
  
  public String getPropertyName()
  {
    return this._typePropertyName;
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.PROPERTY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/impl/AsPropertyTypeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */