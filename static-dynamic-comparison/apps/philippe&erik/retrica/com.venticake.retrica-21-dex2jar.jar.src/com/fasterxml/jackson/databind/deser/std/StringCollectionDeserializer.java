package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.Collection;

@JacksonStdImpl
public final class StringCollectionDeserializer
  extends ContainerDeserializerBase<Collection<String>>
  implements ContextualDeserializer
{
  protected final JavaType _collectionType;
  protected final JsonDeserializer<Object> _delegateDeserializer;
  protected final JsonDeserializer<String> _valueDeserializer;
  protected final ValueInstantiator _valueInstantiator;
  
  public StringCollectionDeserializer(JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer, ValueInstantiator paramValueInstantiator)
  {
    this(paramJavaType, paramValueInstantiator, null, paramJsonDeserializer);
  }
  
  protected StringCollectionDeserializer(JavaType paramJavaType, ValueInstantiator paramValueInstantiator, JsonDeserializer<?> paramJsonDeserializer1, JsonDeserializer<?> paramJsonDeserializer2)
  {
    super(paramJavaType.getRawClass());
    this._collectionType = paramJavaType;
    this._valueDeserializer = paramJsonDeserializer2;
    this._valueInstantiator = paramValueInstantiator;
    this._delegateDeserializer = paramJsonDeserializer1;
  }
  
  private Collection<String> deserializeUsingCustom(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection<String> paramCollection, JsonDeserializer<String> paramJsonDeserializer)
  {
    Object localObject = paramJsonParser.nextToken();
    if (localObject != JsonToken.END_ARRAY)
    {
      if (localObject == JsonToken.VALUE_NULL) {}
      for (localObject = null;; localObject = (String)paramJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext))
      {
        paramCollection.add(localObject);
        break;
      }
    }
    return paramCollection;
  }
  
  private final Collection<String> handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection<String> paramCollection)
  {
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._collectionType.getRawClass());
    }
    JsonDeserializer localJsonDeserializer = this._valueDeserializer;
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
      paramJsonParser = null;
    }
    for (;;)
    {
      paramCollection.add(paramJsonParser);
      return paramCollection;
      if (localJsonDeserializer == null) {
        paramJsonParser = _parseString(paramJsonParser, paramDeserializationContext);
      } else {
        paramJsonParser = (String)localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      }
    }
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
  {
    Object localObject = null;
    if ((this._valueInstantiator != null) && (this._valueInstantiator.getDelegateCreator() != null)) {}
    for (JsonDeserializer localJsonDeserializer2 = findDeserializer(paramDeserializationContext, this._valueInstantiator.getDelegateType(paramDeserializationContext.getConfig()), paramBeanProperty);; localJsonDeserializer2 = null)
    {
      JsonDeserializer localJsonDeserializer3 = this._valueDeserializer;
      JsonDeserializer localJsonDeserializer1;
      if (localJsonDeserializer3 == null)
      {
        localJsonDeserializer1 = paramDeserializationContext.findContextualValueDeserializer(this._collectionType.getContentType(), paramBeanProperty);
        if (!isDefaultDeserializer(localJsonDeserializer1)) {
          break label109;
        }
      }
      label109:
      for (paramDeserializationContext = (DeserializationContext)localObject;; paramDeserializationContext = localJsonDeserializer1)
      {
        return withResolved(localJsonDeserializer2, paramDeserializationContext);
        localJsonDeserializer1 = localJsonDeserializer3;
        if (!(localJsonDeserializer3 instanceof ContextualDeserializer)) {
          break;
        }
        localJsonDeserializer1 = ((ContextualDeserializer)localJsonDeserializer3).createContextual(paramDeserializationContext, paramBeanProperty);
        break;
      }
    }
  }
  
  public Collection<String> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      return (Collection)this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    return deserialize(paramJsonParser, paramDeserializationContext, (Collection)this._valueInstantiator.createUsingDefault(paramDeserializationContext));
  }
  
  public Collection<String> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection<String> paramCollection)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      localObject = handleNonArray(paramJsonParser, paramDeserializationContext, paramCollection);
    }
    JsonToken localJsonToken;
    do
    {
      return (Collection<String>)localObject;
      if (this._valueDeserializer != null) {
        return deserializeUsingCustom(paramJsonParser, paramDeserializationContext, paramCollection, this._valueDeserializer);
      }
      localJsonToken = paramJsonParser.nextToken();
      localObject = paramCollection;
    } while (localJsonToken == JsonToken.END_ARRAY);
    if (localJsonToken == JsonToken.VALUE_NULL) {}
    for (Object localObject = null;; localObject = _parseString(paramJsonParser, paramDeserializationContext))
    {
      paramCollection.add(localObject);
      break;
    }
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return this._valueDeserializer;
  }
  
  protected StringCollectionDeserializer withResolved(JsonDeserializer<?> paramJsonDeserializer1, JsonDeserializer<?> paramJsonDeserializer2)
  {
    if ((this._valueDeserializer == paramJsonDeserializer2) && (this._delegateDeserializer == paramJsonDeserializer1)) {
      return this;
    }
    return new StringCollectionDeserializer(this._collectionType, this._valueInstantiator, paramJsonDeserializer1, paramJsonDeserializer2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StringCollectionDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */