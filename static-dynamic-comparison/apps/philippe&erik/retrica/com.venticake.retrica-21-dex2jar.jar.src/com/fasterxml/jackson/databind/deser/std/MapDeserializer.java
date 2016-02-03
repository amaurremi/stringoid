package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@JacksonStdImpl
public class MapDeserializer
  extends ContainerDeserializerBase<Map<Object, Object>>
  implements ContextualDeserializer, ResolvableDeserializer
{
  protected JsonDeserializer<Object> _delegateDeserializer;
  protected final boolean _hasDefaultCreator;
  protected HashSet<String> _ignorableProperties;
  protected final KeyDeserializer _keyDeserializer;
  protected final JavaType _mapType;
  protected PropertyBasedCreator _propertyBasedCreator;
  protected boolean _standardStringKey;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final ValueInstantiator _valueInstantiator;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public MapDeserializer(JavaType paramJavaType, ValueInstantiator paramValueInstantiator, KeyDeserializer paramKeyDeserializer, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    super(Map.class);
    this._mapType = paramJavaType;
    this._keyDeserializer = paramKeyDeserializer;
    this._valueDeserializer = paramJsonDeserializer;
    this._valueTypeDeserializer = paramTypeDeserializer;
    this._valueInstantiator = paramValueInstantiator;
    this._hasDefaultCreator = paramValueInstantiator.canCreateUsingDefault();
    this._delegateDeserializer = null;
    this._propertyBasedCreator = null;
    this._standardStringKey = _isStdKeyDeser(paramJavaType, paramKeyDeserializer);
  }
  
  protected MapDeserializer(MapDeserializer paramMapDeserializer, KeyDeserializer paramKeyDeserializer, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer, HashSet<String> paramHashSet)
  {
    super(paramMapDeserializer._valueClass);
    this._mapType = paramMapDeserializer._mapType;
    this._keyDeserializer = paramKeyDeserializer;
    this._valueDeserializer = paramJsonDeserializer;
    this._valueTypeDeserializer = paramTypeDeserializer;
    this._valueInstantiator = paramMapDeserializer._valueInstantiator;
    this._propertyBasedCreator = paramMapDeserializer._propertyBasedCreator;
    this._delegateDeserializer = paramMapDeserializer._delegateDeserializer;
    this._hasDefaultCreator = paramMapDeserializer._hasDefaultCreator;
    this._ignorableProperties = paramHashSet;
    this._standardStringKey = _isStdKeyDeser(this._mapType, paramKeyDeserializer);
  }
  
  public Map<Object, Object> _deserializeUsingCreator(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, null);
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    localObject2 = this._valueDeserializer;
    TypeDeserializer localTypeDeserializer = this._valueTypeDeserializer;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      Object localObject3 = paramJsonParser.getCurrentName();
      localObject1 = paramJsonParser.nextToken();
      if ((this._ignorableProperties != null) && (this._ignorableProperties.contains(localObject3))) {
        paramJsonParser.skipChildren();
      }
      do
      {
        localObject1 = paramJsonParser.nextToken();
        break;
        localObject3 = localPropertyBasedCreator.findCreatorProperty((String)localObject3);
        if (localObject3 == null) {
          break label177;
        }
        localObject1 = ((SettableBeanProperty)localObject3).deserialize(paramJsonParser, paramDeserializationContext);
      } while (!localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject3).getCreatorIndex(), localObject1));
      paramJsonParser.nextToken();
      try
      {
        localObject1 = (Map)localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
        _readAndBind(paramJsonParser, paramDeserializationContext, (Map)localObject1);
        return (Map<Object, Object>)localObject1;
      }
      catch (Exception paramJsonParser)
      {
        wrapAndThrow(paramJsonParser, this._mapType.getRawClass());
        return null;
      }
      label177:
      localObject3 = paramJsonParser.getCurrentName();
      localObject3 = this._keyDeserializer.deserializeKey((String)localObject3, paramDeserializationContext);
      if (localObject1 == JsonToken.VALUE_NULL) {
        localObject1 = null;
      }
      for (;;)
      {
        localPropertyValueBuffer.bufferMapProperty(localObject3, localObject1);
        break;
        if (localTypeDeserializer == null) {
          localObject1 = ((JsonDeserializer)localObject2).deserialize(paramJsonParser, paramDeserializationContext);
        } else {
          localObject1 = ((JsonDeserializer)localObject2).deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
        }
      }
    }
    try
    {
      paramJsonParser = (Map)localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      wrapAndThrow(paramJsonParser, this._mapType.getRawClass());
    }
    return null;
  }
  
  protected final boolean _isStdKeyDeser(JavaType paramJavaType, KeyDeserializer paramKeyDeserializer)
  {
    if (paramKeyDeserializer == null) {}
    do
    {
      do
      {
        return true;
        paramJavaType = paramJavaType.getKeyType();
      } while (paramJavaType == null);
      paramJavaType = paramJavaType.getRawClass();
    } while (((paramJavaType == String.class) || (paramJavaType == Object.class)) && (isDefaultKeyDeserializer(paramKeyDeserializer)));
    return false;
  }
  
  protected final void _readAndBind(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Map<Object, Object> paramMap)
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    localObject2 = this._keyDeserializer;
    JsonDeserializer localJsonDeserializer = this._valueDeserializer;
    TypeDeserializer localTypeDeserializer = this._valueTypeDeserializer;
    while (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      Object localObject3 = ((KeyDeserializer)localObject2).deserializeKey((String)localObject1, paramDeserializationContext);
      JsonToken localJsonToken = paramJsonParser.nextToken();
      if ((this._ignorableProperties != null) && (this._ignorableProperties.contains(localObject1)))
      {
        paramJsonParser.skipChildren();
        localObject1 = paramJsonParser.nextToken();
      }
      else
      {
        if (localJsonToken == JsonToken.VALUE_NULL) {
          localObject1 = null;
        }
        for (;;)
        {
          paramMap.put(localObject3, localObject1);
          break;
          if (localTypeDeserializer == null) {
            localObject1 = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
          } else {
            localObject1 = localJsonDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
          }
        }
      }
    }
  }
  
  protected final void _readAndBindStringMap(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Map<Object, Object> paramMap)
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    localObject2 = this._valueDeserializer;
    TypeDeserializer localTypeDeserializer = this._valueTypeDeserializer;
    while (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      localObject1 = paramJsonParser.nextToken();
      if ((this._ignorableProperties != null) && (this._ignorableProperties.contains(str)))
      {
        paramJsonParser.skipChildren();
        localObject1 = paramJsonParser.nextToken();
      }
      else
      {
        if (localObject1 == JsonToken.VALUE_NULL) {
          localObject1 = null;
        }
        for (;;)
        {
          paramMap.put(str, localObject1);
          break;
          if (localTypeDeserializer == null) {
            localObject1 = ((JsonDeserializer)localObject2).deserialize(paramJsonParser, paramDeserializationContext);
          } else {
            localObject1 = ((JsonDeserializer)localObject2).deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
          }
        }
      }
    }
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
  {
    KeyDeserializer localKeyDeserializer = this._keyDeserializer;
    if (localKeyDeserializer == null) {
      localKeyDeserializer = paramDeserializationContext.findKeyDeserializer(this._mapType.getKeyType(), paramBeanProperty);
    }
    label50:
    label207:
    label220:
    label235:
    for (;;)
    {
      Object localObject2 = this._valueDeserializer;
      Object localObject1;
      Object localObject3;
      String[] arrayOfString;
      if (localObject2 == null)
      {
        localObject1 = paramDeserializationContext.findContextualValueDeserializer(this._mapType.getContentType(), paramBeanProperty);
        localObject3 = this._valueTypeDeserializer;
        localObject2 = localObject3;
        if (localObject3 != null) {
          localObject2 = ((TypeDeserializer)localObject3).forProperty(paramBeanProperty);
        }
        localObject3 = this._ignorableProperties;
        paramDeserializationContext = paramDeserializationContext.getAnnotationIntrospector();
        if ((paramDeserializationContext == null) || (paramBeanProperty == null)) {
          break label220;
        }
        arrayOfString = paramDeserializationContext.findPropertiesToIgnore(paramBeanProperty.getMember());
        if (arrayOfString == null) {
          break label220;
        }
        if (localObject3 != null) {
          break label207;
        }
      }
      for (paramDeserializationContext = new HashSet();; paramDeserializationContext = new HashSet((Collection)localObject3))
      {
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          paramBeanProperty = paramDeserializationContext;
          if (i >= j) {
            break;
          }
          paramDeserializationContext.add(arrayOfString[i]);
          i += 1;
        }
        if (!(localKeyDeserializer instanceof ContextualKeyDeserializer)) {
          break label235;
        }
        localKeyDeserializer = ((ContextualKeyDeserializer)localKeyDeserializer).createContextual(paramDeserializationContext, paramBeanProperty);
        break;
        localObject1 = localObject2;
        if (!(localObject2 instanceof ContextualDeserializer)) {
          break label50;
        }
        localObject1 = ((ContextualDeserializer)localObject2).createContextual(paramDeserializationContext, paramBeanProperty);
        break label50;
      }
      paramBeanProperty = (BeanProperty)localObject3;
      return withResolved(localKeyDeserializer, (TypeDeserializer)localObject2, (JsonDeserializer)localObject1, paramBeanProperty);
    }
  }
  
  public Map<Object, Object> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._propertyBasedCreator != null) {
      return _deserializeUsingCreator(paramJsonParser, paramDeserializationContext);
    }
    if (this._delegateDeserializer != null) {
      return (Map)this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (!this._hasDefaultCreator) {
      throw paramDeserializationContext.instantiationException(getMapClass(), "No default constructor found");
    }
    Object localObject = paramJsonParser.getCurrentToken();
    if ((localObject != JsonToken.START_OBJECT) && (localObject != JsonToken.FIELD_NAME) && (localObject != JsonToken.END_OBJECT))
    {
      if (localObject == JsonToken.VALUE_STRING) {
        return (Map)this._valueInstantiator.createFromString(paramDeserializationContext, paramJsonParser.getText());
      }
      throw paramDeserializationContext.mappingException(getMapClass());
    }
    localObject = (Map)this._valueInstantiator.createUsingDefault(paramDeserializationContext);
    if (this._standardStringKey)
    {
      _readAndBindStringMap(paramJsonParser, paramDeserializationContext, (Map)localObject);
      return (Map<Object, Object>)localObject;
    }
    _readAndBind(paramJsonParser, paramDeserializationContext, (Map)localObject);
    return (Map<Object, Object>)localObject;
  }
  
  public Map<Object, Object> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Map<Object, Object> paramMap)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken != JsonToken.START_OBJECT) && (localJsonToken != JsonToken.FIELD_NAME)) {
      throw paramDeserializationContext.mappingException(getMapClass());
    }
    if (this._standardStringKey)
    {
      _readAndBindStringMap(paramJsonParser, paramDeserializationContext, paramMap);
      return paramMap;
    }
    _readAndBind(paramJsonParser, paramDeserializationContext, paramMap);
    return paramMap;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return this._valueDeserializer;
  }
  
  public final Class<?> getMapClass()
  {
    return this._mapType.getRawClass();
  }
  
  public void resolve(DeserializationContext paramDeserializationContext)
  {
    Object localObject;
    if (this._valueInstantiator.canCreateUsingDelegate())
    {
      localObject = this._valueInstantiator.getDelegateType(paramDeserializationContext.getConfig());
      if (localObject == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._mapType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      this._delegateDeserializer = findDeserializer(paramDeserializationContext, (JavaType)localObject, null);
    }
    if (this._valueInstantiator.canCreateFromObjectWith())
    {
      localObject = this._valueInstantiator.getFromObjectArguments(paramDeserializationContext.getConfig());
      this._propertyBasedCreator = PropertyBasedCreator.construct(paramDeserializationContext, this._valueInstantiator, (SettableBeanProperty[])localObject);
    }
    this._standardStringKey = _isStdKeyDeser(this._mapType, this._keyDeserializer);
  }
  
  public void setIgnorableProperties(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (paramArrayOfString = null;; paramArrayOfString = ArrayBuilders.arrayToSet(paramArrayOfString))
    {
      this._ignorableProperties = paramArrayOfString;
      return;
    }
  }
  
  protected MapDeserializer withResolved(KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer, HashSet<String> paramHashSet)
  {
    if ((this._keyDeserializer == paramKeyDeserializer) && (this._valueDeserializer == paramJsonDeserializer) && (this._valueTypeDeserializer == paramTypeDeserializer) && (this._ignorableProperties == paramHashSet)) {
      return this;
    }
    return new MapDeserializer(this, paramKeyDeserializer, paramJsonDeserializer, paramTypeDeserializer, paramHashSet);
  }
  
  protected void wrapAndThrow(Throwable paramThrowable, Object paramObject)
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if (((paramThrowable instanceof IOException)) && (!(paramThrowable instanceof JsonMappingException))) {
      throw ((IOException)paramThrowable);
    }
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/MapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */