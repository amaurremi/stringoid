package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.Serializable;
import java.util.Map;

public class AbstractDeserializer
  extends JsonDeserializer<Object>
  implements Serializable
{
  protected final boolean _acceptBoolean;
  protected final boolean _acceptDouble;
  protected final boolean _acceptInt;
  protected final boolean _acceptString;
  protected final Map<String, SettableBeanProperty> _backRefProperties;
  protected final JavaType _baseType;
  protected final ObjectIdReader _objectIdReader;
  
  public AbstractDeserializer(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, Map<String, SettableBeanProperty> paramMap)
  {
    this._baseType = paramBeanDescription.getType();
    this._objectIdReader = paramBeanDeserializerBuilder.getObjectIdReader();
    this._backRefProperties = paramMap;
    paramBeanDeserializerBuilder = this._baseType.getRawClass();
    this._acceptString = paramBeanDeserializerBuilder.isAssignableFrom(String.class);
    if ((paramBeanDeserializerBuilder == Boolean.TYPE) || (paramBeanDeserializerBuilder.isAssignableFrom(Boolean.class)))
    {
      bool1 = true;
      this._acceptBoolean = bool1;
      if ((paramBeanDeserializerBuilder != Integer.TYPE) && (!paramBeanDeserializerBuilder.isAssignableFrom(Integer.class))) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = true;; bool1 = false)
    {
      this._acceptInt = bool1;
      if (paramBeanDeserializerBuilder != Double.TYPE)
      {
        bool1 = bool2;
        if (!paramBeanDeserializerBuilder.isAssignableFrom(Double.class)) {}
      }
      else
      {
        bool1 = true;
      }
      this._acceptDouble = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected Object _deserializeFromObjectId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = this._objectIdReader.deserializer.deserialize(paramJsonParser, paramDeserializationContext);
    paramDeserializationContext = paramDeserializationContext.findObjectId(paramJsonParser, this._objectIdReader.generator).item;
    if (paramDeserializationContext == null) {
      throw new IllegalStateException("Could not resolve Object Id [" + paramJsonParser + "] -- unresolved forward-reference?");
    }
    return paramDeserializationContext;
  }
  
  protected Object _deserializeIfNatural(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
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
            } while (!this._acceptString);
            return paramJsonParser.getText();
          } while (!this._acceptInt);
          return Integer.valueOf(paramJsonParser.getIntValue());
        } while (!this._acceptDouble);
        return Double.valueOf(paramJsonParser.getDoubleValue());
      } while (!this._acceptBoolean);
      return Boolean.TRUE;
    } while (!this._acceptBoolean);
    return Boolean.FALSE;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    throw paramDeserializationContext.instantiationException(this._baseType.getRawClass(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    Object localObject1;
    if (this._objectIdReader != null)
    {
      localObject1 = paramJsonParser.getCurrentToken();
      if ((localObject1 != null) && (((JsonToken)localObject1).isScalarValue())) {
        localObject1 = _deserializeFromObjectId(paramJsonParser, paramDeserializationContext);
      }
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = _deserializeIfNatural(paramJsonParser, paramDeserializationContext);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public SettableBeanProperty findBackReference(String paramString)
  {
    if (this._backRefProperties == null) {
      return null;
    }
    return (SettableBeanProperty)this._backRefProperties.get(paramString);
  }
  
  public boolean isCachable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/AbstractDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */