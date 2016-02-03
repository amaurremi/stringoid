package org.codehaus.jackson.map.deser.std;

import java.util.Collection;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.introspect.AnnotatedWithParams;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public final class StringCollectionDeserializer
  extends ContainerDeserializerBase
  implements ResolvableDeserializer
{
  protected final JavaType _collectionType;
  protected JsonDeserializer _delegateDeserializer;
  protected final boolean _isDefaultDeserializer;
  protected final JsonDeserializer _valueDeserializer;
  protected final ValueInstantiator _valueInstantiator;
  
  protected StringCollectionDeserializer(StringCollectionDeserializer paramStringCollectionDeserializer)
  {
    super(paramStringCollectionDeserializer._valueClass);
    this._collectionType = paramStringCollectionDeserializer._collectionType;
    this._valueDeserializer = paramStringCollectionDeserializer._valueDeserializer;
    this._valueInstantiator = paramStringCollectionDeserializer._valueInstantiator;
    this._isDefaultDeserializer = paramStringCollectionDeserializer._isDefaultDeserializer;
  }
  
  public StringCollectionDeserializer(JavaType paramJavaType, JsonDeserializer paramJsonDeserializer, ValueInstantiator paramValueInstantiator)
  {
    super(paramJavaType.getRawClass());
    this._collectionType = paramJavaType;
    this._valueDeserializer = paramJsonDeserializer;
    this._valueInstantiator = paramValueInstantiator;
    this._isDefaultDeserializer = isDefaultSerializer(paramJsonDeserializer);
  }
  
  private Collection deserializeUsingCustom(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection paramCollection)
  {
    JsonDeserializer localJsonDeserializer = this._valueDeserializer;
    Object localObject = paramJsonParser.nextToken();
    if (localObject != JsonToken.END_ARRAY)
    {
      if (localObject == JsonToken.VALUE_NULL) {}
      for (localObject = null;; localObject = (String)localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext))
      {
        paramCollection.add(localObject);
        break;
      }
    }
    return paramCollection;
  }
  
  private final Collection handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection paramCollection)
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
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
        paramJsonParser = paramJsonParser.getText();
      } else {
        paramJsonParser = (String)localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      }
    }
  }
  
  public Collection deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      return (Collection)this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    return deserialize(paramJsonParser, paramDeserializationContext, (Collection)this._valueInstantiator.createUsingDefault());
  }
  
  public Collection deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Collection paramCollection)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      paramDeserializationContext = handleNonArray(paramJsonParser, paramDeserializationContext, paramCollection);
    }
    JsonToken localJsonToken;
    do
    {
      return paramDeserializationContext;
      if (!this._isDefaultDeserializer) {
        return deserializeUsingCustom(paramJsonParser, paramDeserializationContext, paramCollection);
      }
      localJsonToken = paramJsonParser.nextToken();
      paramDeserializationContext = paramCollection;
    } while (localJsonToken == JsonToken.END_ARRAY);
    if (localJsonToken == JsonToken.VALUE_NULL) {}
    for (paramDeserializationContext = null;; paramDeserializationContext = paramJsonParser.getText())
    {
      paramCollection.add(paramDeserializationContext);
      break;
    }
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer getContentDeserializer()
  {
    return this._valueDeserializer;
  }
  
  public JavaType getContentType()
  {
    return this._collectionType.getContentType();
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
  {
    AnnotatedWithParams localAnnotatedWithParams = this._valueInstantiator.getDelegateCreator();
    if (localAnnotatedWithParams != null)
    {
      JavaType localJavaType = this._valueInstantiator.getDelegateType();
      this._delegateDeserializer = findDeserializer(paramDeserializationConfig, paramDeserializerProvider, localJavaType, new BeanProperty.Std(null, localJavaType, null, localAnnotatedWithParams));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StringCollectionDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */