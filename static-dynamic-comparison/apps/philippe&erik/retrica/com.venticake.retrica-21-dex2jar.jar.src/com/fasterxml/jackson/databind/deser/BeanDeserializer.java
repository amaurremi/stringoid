package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

public class BeanDeserializer
  extends BeanDeserializerBase
  implements Serializable
{
  protected BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase)
  {
    super(paramBeanDeserializerBase, paramBeanDeserializerBase._ignoreAllUnknown);
  }
  
  public BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, ObjectIdReader paramObjectIdReader)
  {
    super(paramBeanDeserializerBase, paramObjectIdReader);
  }
  
  protected BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, NameTransformer paramNameTransformer)
  {
    super(paramBeanDeserializerBase, paramNameTransformer);
  }
  
  public BeanDeserializer(BeanDeserializerBase paramBeanDeserializerBase, HashSet<String> paramHashSet)
  {
    super(paramBeanDeserializerBase, paramHashSet);
  }
  
  public BeanDeserializer(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBeanDeserializerBuilder, paramBeanDescription, paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean1, paramBoolean2);
  }
  
  private Object _missingToken(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    throw paramDeserializationContext.endOfInputException(getBeanClass());
  }
  
  private final void _vanillaDeserializeHandleUnknown(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
  {
    if ((this._ignorableProps != null) && (this._ignorableProps.contains(paramString)))
    {
      paramJsonParser.skipChildren();
      return;
    }
    if (this._anySetter != null) {
      try
      {
        this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, paramString);
        return;
      }
      catch (Exception paramJsonParser)
      {
        wrapAndThrow(paramJsonParser, paramObject, paramString, paramDeserializationContext);
        return;
      }
    }
    handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, paramString);
  }
  
  private final Object vanillaDeserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonToken paramJsonToken)
  {
    paramJsonToken = this._valueInstantiator.createUsingDefault(paramDeserializationContext);
    if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = this._beanProperties.find(str);
      if (localSettableBeanProperty != null) {}
      for (;;)
      {
        try
        {
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramJsonToken);
          paramJsonParser.nextToken();
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramJsonToken, str, paramDeserializationContext);
          continue;
        }
        _vanillaDeserializeHandleUnknown(paramJsonParser, paramDeserializationContext, paramJsonToken, str);
      }
    }
    return paramJsonToken;
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject4 = null;
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, this._objectIdReader);
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = null;
    if (localObject2 == JsonToken.FIELD_NAME)
    {
      Object localObject5 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = localPropertyBasedCreator.findCreatorProperty((String)localObject5);
      Object localObject3;
      if (localSettableBeanProperty != null)
      {
        Object localObject6 = localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext);
        localObject2 = localObject1;
        if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty.getCreatorIndex(), localObject6))
        {
          paramJsonParser.nextToken();
          try
          {
            localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
            if (localObject2.getClass() != this._beanType.getRawClass()) {
              return handlePolymorphic(paramJsonParser, paramDeserializationContext, localObject2, (TokenBuffer)localObject1);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              wrapAndThrow(localException, this._beanType.getRawClass(), (String)localObject5, paramDeserializationContext);
              localObject3 = localObject4;
            }
            localObject4 = localObject3;
            if (localObject1 != null) {
              localObject4 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
            }
            return deserialize(paramJsonParser, paramDeserializationContext, localObject4);
          }
        }
      }
      else
      {
        if (!localPropertyValueBuffer.readIdProperty((String)localObject5)) {
          break label211;
        }
        localObject3 = localObject1;
      }
      for (;;)
      {
        localObject5 = paramJsonParser.nextToken();
        localObject1 = localObject3;
        localObject3 = localObject5;
        break;
        label211:
        localObject3 = this._beanProperties.find((String)localObject5);
        if (localObject3 != null)
        {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, ((SettableBeanProperty)localObject3).deserialize(paramJsonParser, paramDeserializationContext));
          localObject3 = localObject1;
        }
        else if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject5)))
        {
          paramJsonParser.skipChildren();
          localObject3 = localObject1;
        }
        else if (this._anySetter != null)
        {
          localPropertyValueBuffer.bufferAnyProperty(this._anySetter, (String)localObject5, this._anySetter.deserialize(paramJsonParser, paramDeserializationContext));
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new TokenBuffer(paramJsonParser.getCodec());
          }
          ((TokenBuffer)localObject3).writeFieldName((String)localObject5);
          ((TokenBuffer)localObject3).copyCurrentStructure(paramJsonParser);
        }
      }
    }
    try
    {
      paramJsonParser = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
      if (localObject1 == null) {
        return paramJsonParser;
      }
      if (paramJsonParser.getClass() != this._beanType.getRawClass()) {
        return handlePolymorphic(null, paramDeserializationContext, paramJsonParser, (TokenBuffer)localObject1);
      }
    }
    catch (Exception paramJsonParser)
    {
      for (;;)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
        paramJsonParser = null;
      }
    }
    return handleUnknownProperties(paramDeserializationContext, paramJsonParser, (TokenBuffer)localObject1);
    return paramJsonParser;
  }
  
  protected BeanDeserializerBase asArrayDeserializer()
  {
    return new BeanAsArrayDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder());
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      localJsonToken = paramJsonParser.nextToken();
      if (this._vanillaProcessing) {
        return vanillaDeserialize(paramJsonParser, paramDeserializationContext, localJsonToken);
      }
      if (this._objectIdReader != null) {
        return deserializeWithObjectId(paramJsonParser, paramDeserializationContext);
      }
      return deserializeFromObject(paramJsonParser, paramDeserializationContext);
    }
    if (localJsonToken == null) {
      return _missingToken(paramJsonParser, paramDeserializationContext);
    }
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localJsonToken.ordinal()])
    {
    default: 
      throw paramDeserializationContext.mappingException(getBeanClass());
    case 1: 
      return deserializeFromString(paramJsonParser, paramDeserializationContext);
    case 2: 
      return deserializeFromNumber(paramJsonParser, paramDeserializationContext);
    case 3: 
      return deserializeFromDouble(paramJsonParser, paramDeserializationContext);
    case 4: 
      return paramJsonParser.getEmbeddedObject();
    case 5: 
    case 6: 
      return deserializeFromBoolean(paramJsonParser, paramDeserializationContext);
    case 7: 
      return deserializeFromArray(paramJsonParser, paramDeserializationContext);
    }
    if (this._vanillaProcessing) {
      return vanillaDeserialize(paramJsonParser, paramDeserializationContext, localJsonToken);
    }
    if (this._objectIdReader != null) {
      return deserializeWithObjectId(paramJsonParser, paramDeserializationContext);
    }
    return deserializeFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    if (this._injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    if (this._unwrappedPropertyHandler != null) {
      localObject1 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext, paramObject);
    }
    do
    {
      return localObject1;
      if (this._externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, paramObject);
      }
      localObject2 = paramJsonParser.getCurrentToken();
      localObject1 = localObject2;
      if (localObject2 == JsonToken.START_OBJECT) {
        localObject1 = paramJsonParser.nextToken();
      }
      localObject2 = localObject1;
      if (this._needViewProcesing)
      {
        Class localClass = paramDeserializationContext.getActiveView();
        localObject2 = localObject1;
        if (localClass != null) {
          return deserializeWithView(paramJsonParser, paramDeserializationContext, paramObject, localClass);
        }
      }
      localObject1 = paramObject;
    } while (localObject2 != JsonToken.FIELD_NAME);
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    Object localObject2 = this._beanProperties.find((String)localObject1);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        ((SettableBeanProperty)localObject2).deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
        localObject2 = paramJsonParser.nextToken();
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
        continue;
      }
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1))) {
        paramJsonParser.skipChildren();
      } else if (this._anySetter != null) {
        this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
      } else {
        handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
      }
    }
  }
  
  public Object deserializeFromArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      try
      {
        paramJsonParser = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        if (this._injectables != null) {
          injectValues(paramDeserializationContext, paramJsonParser);
        }
        return paramJsonParser;
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
      }
    }
    throw paramDeserializationContext.mappingException(getBeanClass());
  }
  
  public Object deserializeFromBoolean(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((this._delegateDeserializer != null) && (!this._valueInstantiator.canCreateFromBoolean()))
    {
      paramJsonParser = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      if (this._injectables != null) {
        injectValues(paramDeserializationContext, paramJsonParser);
      }
      return paramJsonParser;
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_TRUE) {}
    for (boolean bool = true;; bool = false) {
      return this._valueInstantiator.createFromBoolean(paramDeserializationContext, bool);
    }
  }
  
  public Object deserializeFromDouble(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
    {
    default: 
      if (this._delegateDeserializer != null) {
        paramJsonParser = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      }
      break;
    case 3: 
    case 4: 
      Object localObject;
      do
      {
        return paramJsonParser;
        if ((this._delegateDeserializer == null) || (this._valueInstantiator.canCreateFromDouble())) {
          break;
        }
        localObject = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        paramJsonParser = (JsonParser)localObject;
      } while (this._injectables == null);
      injectValues(paramDeserializationContext, localObject);
      return localObject;
      return this._valueInstantiator.createFromDouble(paramDeserializationContext, paramJsonParser.getDoubleValue());
    }
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON floating-point number");
  }
  
  public Object deserializeFromNumber(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._objectIdReader != null) {
      paramJsonParser = deserializeFromObjectId(paramJsonParser, paramDeserializationContext);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return paramJsonParser;
          switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
          {
          default: 
            if (this._delegateDeserializer == null) {
              break label220;
            }
            localObject = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
            paramJsonParser = (JsonParser)localObject;
          }
        } while (this._injectables == null);
        injectValues(paramDeserializationContext, localObject);
        return localObject;
        if ((this._delegateDeserializer == null) || (this._valueInstantiator.canCreateFromInt())) {
          break;
        }
        localObject = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        paramJsonParser = (JsonParser)localObject;
      } while (this._injectables == null);
      injectValues(paramDeserializationContext, localObject);
      return localObject;
      return this._valueInstantiator.createFromInt(paramDeserializationContext, paramJsonParser.getIntValue());
      if ((this._delegateDeserializer == null) || (this._valueInstantiator.canCreateFromInt())) {
        break;
      }
      localObject = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      paramJsonParser = (JsonParser)localObject;
    } while (this._injectables == null);
    injectValues(paramDeserializationContext, localObject);
    return localObject;
    return this._valueInstantiator.createFromLong(paramDeserializationContext, paramJsonParser.getLongValue());
    label220:
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON integer number");
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._nonStandardCreation) {
      if (this._unwrappedPropertyHandler != null) {
        localObject1 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext);
      }
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this._externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext);
      }
      return deserializeFromObjectUsingNonDefault(paramJsonParser, paramDeserializationContext);
      localObject2 = this._valueInstantiator.createUsingDefault(paramDeserializationContext);
      if (this._injectables != null) {
        injectValues(paramDeserializationContext, localObject2);
      }
      if (this._needViewProcesing)
      {
        localObject1 = paramDeserializationContext.getActiveView();
        if (localObject1 != null) {
          return deserializeWithView(paramJsonParser, paramDeserializationContext, localObject2, (Class)localObject1);
        }
      }
      localObject1 = localObject2;
    } while (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT);
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    SettableBeanProperty localSettableBeanProperty = this._beanProperties.find((String)localObject1);
    if (localSettableBeanProperty != null) {}
    for (;;)
    {
      try
      {
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
        paramJsonParser.nextToken();
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, localObject2, (String)localObject1, paramDeserializationContext);
        continue;
      }
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1))) {
        paramJsonParser.skipChildren();
      } else if (this._anySetter != null) {
        try
        {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
        }
        catch (Exception localException2)
        {
          wrapAndThrow(localException2, localObject2, (String)localObject1, paramDeserializationContext);
        }
      } else {
        handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
      }
    }
  }
  
  protected Object deserializeFromObjectUsingNonDefault(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      return this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (this._propertyBasedCreator != null) {
      return _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    if (this._beanType.isAbstract()) {
      throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
    }
    throw JsonMappingException.from(paramJsonParser, "No suitable constructor found for type " + this._beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
  }
  
  public Object deserializeFromString(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._objectIdReader != null) {
      paramJsonParser = deserializeFromObjectId(paramJsonParser, paramDeserializationContext);
    }
    Object localObject;
    do
    {
      return paramJsonParser;
      if ((this._delegateDeserializer == null) || (this._valueInstantiator.canCreateFromString())) {
        break;
      }
      localObject = this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      paramJsonParser = (JsonParser)localObject;
    } while (this._injectables == null);
    injectValues(paramDeserializationContext, localObject);
    return localObject;
    return this._valueInstantiator.createFromString(paramDeserializationContext, paramJsonParser.getText());
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    ExternalTypeHandler localExternalTypeHandler = this._externalTypeIdHandler.start();
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, this._objectIdReader);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = localPropertyBasedCreator.findCreatorProperty(str);
      if (localObject1 != null) {
        if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, localPropertyValueBuffer)) {}
      }
      for (;;)
      {
        localObject1 = paramJsonParser.nextToken();
        break;
        Object localObject2 = ((SettableBeanProperty)localObject1).deserialize(paramJsonParser, paramDeserializationContext);
        if (localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject1).getCreatorIndex(), localObject2))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, this._beanType.getRawClass(), str, paramDeserializationContext);
          }
          if (localObject2.getClass() != this._beanType.getRawClass()) {
            throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
          }
          return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localObject2);
          if (!localPropertyValueBuffer.readIdProperty(str))
          {
            SettableBeanProperty localSettableBeanProperty = this._beanProperties.find(str);
            if (localSettableBeanProperty != null) {
              localPropertyValueBuffer.bufferProperty(localSettableBeanProperty, localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext));
            } else if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, null)) {
              if ((this._ignorableProps != null) && (this._ignorableProps.contains(str))) {
                paramJsonParser.skipChildren();
              } else if (this._anySetter != null) {
                localPropertyValueBuffer.bufferAnyProperty(this._anySetter, str, this._anySetter.deserialize(paramJsonParser, paramDeserializationContext));
              }
            }
          }
        }
      }
    }
    try
    {
      paramJsonParser = localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localPropertyValueBuffer, localPropertyBasedCreator);
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, this._objectIdReader);
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject1 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = localPropertyBasedCreator.findCreatorProperty(str);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((SettableBeanProperty)localObject1).deserialize(paramJsonParser, paramDeserializationContext);
        if (localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject1).getCreatorIndex(), localObject3))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
            while (localObject1 == JsonToken.FIELD_NAME)
            {
              paramJsonParser.nextToken();
              localTokenBuffer.copyCurrentStructure(paramJsonParser);
              localObject1 = paramJsonParser.nextToken();
              continue;
              localObject2 = paramJsonParser.nextToken();
            }
          }
          catch (Exception localException)
          {
            wrapAndThrow(localException, this._beanType.getRawClass(), str, paramDeserializationContext);
          }
        }
      }
      for (;;)
      {
        break;
        localTokenBuffer.writeEndObject();
        if (localObject3.getClass() != this._beanType.getRawClass())
        {
          localTokenBuffer.close();
          throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
        }
        return this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject3, localTokenBuffer);
        if (!localPropertyValueBuffer.readIdProperty(str))
        {
          localObject2 = this._beanProperties.find(str);
          if (localObject2 != null)
          {
            localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject2, ((SettableBeanProperty)localObject2).deserialize(paramJsonParser, paramDeserializationContext));
          }
          else if ((this._ignorableProps != null) && (this._ignorableProps.contains(str)))
          {
            paramJsonParser.skipChildren();
          }
          else
          {
            localTokenBuffer.writeFieldName(str);
            localTokenBuffer.copyCurrentStructure(paramJsonParser);
            if (this._anySetter != null) {
              localPropertyValueBuffer.bufferAnyProperty(this._anySetter, str, this._anySetter.deserialize(paramJsonParser, paramDeserializationContext));
            }
          }
        }
      }
    }
    try
    {
      localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
      return this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject2, localTokenBuffer);
    }
    catch (Exception paramJsonParser)
    {
      wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
    }
    return null;
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithExternalTypeId(paramJsonParser, paramDeserializationContext);
    }
    return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, this._valueInstantiator.createUsingDefault(paramDeserializationContext));
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    Class localClass;
    ExternalTypeHandler localExternalTypeHandler;
    label22:
    String str;
    SettableBeanProperty localSettableBeanProperty;
    if (this._needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      localExternalTypeHandler = this._externalTypeIdHandler.start();
      if (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
        break label229;
      }
      str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localSettableBeanProperty = this._beanProperties.find(str);
      if (localSettableBeanProperty == null) {
        break label140;
      }
      if (paramJsonParser.getCurrentToken().isScalarValue()) {
        localExternalTypeHandler.handleTypePropertyValue(paramJsonParser, paramDeserializationContext, str, paramObject);
      }
      if ((localClass == null) || (localSettableBeanProperty.visibleInView(localClass))) {
        break label114;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      break label22;
      localClass = null;
      break;
      try
      {
        label114:
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, paramObject, str, paramDeserializationContext);
      }
      continue;
      label140:
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(str))) {
        paramJsonParser.skipChildren();
      } else if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, paramObject)) {
        if (this._anySetter != null) {
          try
          {
            this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, str);
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, paramObject, str, paramDeserializationContext);
          }
        } else {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, str);
        }
      }
    }
    label229:
    return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  protected Object deserializeWithObjectId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    String str1 = this._objectIdReader.propertyName;
    if (str1.equals(paramJsonParser.getCurrentName())) {
      return deserializeFromObject(paramJsonParser, paramDeserializationContext);
    }
    Object localObject = new TokenBuffer(paramJsonParser.getCodec());
    TokenBuffer localTokenBuffer = null;
    if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
    {
      String str2 = paramJsonParser.getCurrentName();
      if (localTokenBuffer == null) {
        if (str1.equals(str2))
        {
          localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
          localTokenBuffer.writeFieldName(str2);
          paramJsonParser.nextToken();
          localTokenBuffer.copyCurrentStructure(paramJsonParser);
          localTokenBuffer.append((TokenBuffer)localObject);
          localObject = null;
        }
      }
      for (;;)
      {
        paramJsonParser.nextToken();
        break;
        ((TokenBuffer)localObject).writeFieldName(str2);
        paramJsonParser.nextToken();
        ((TokenBuffer)localObject).copyCurrentStructure(paramJsonParser);
        continue;
        localTokenBuffer.writeFieldName(str2);
        paramJsonParser.nextToken();
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
      }
    }
    if (localTokenBuffer == null) {}
    for (;;)
    {
      ((TokenBuffer)localObject).writeEndObject();
      paramJsonParser = ((TokenBuffer)localObject).asParser();
      paramJsonParser.nextToken();
      return deserializeFromObject(paramJsonParser, paramDeserializationContext);
      localObject = localTokenBuffer;
    }
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      return this._valueInstantiator.createUsingDelegate(paramDeserializationContext, this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (this._propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(paramJsonParser, paramDeserializationContext);
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject = this._valueInstantiator.createUsingDefault(paramDeserializationContext);
    if (this._injectables != null) {
      injectValues(paramDeserializationContext, localObject);
    }
    Class localClass;
    String str;
    SettableBeanProperty localSettableBeanProperty;
    if (this._needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      if (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
        break label268;
      }
      str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localSettableBeanProperty = this._beanProperties.find(str);
      if (localSettableBeanProperty == null) {
        break label189;
      }
      if ((localClass == null) || (localSettableBeanProperty.visibleInView(localClass))) {
        break label161;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      break;
      localClass = null;
      break;
      try
      {
        label161:
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, localObject, str, paramDeserializationContext);
      }
      continue;
      label189:
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(str)))
      {
        paramJsonParser.skipChildren();
      }
      else
      {
        localTokenBuffer.writeFieldName(str);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        if (this._anySetter != null) {
          try
          {
            this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject, str);
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, localObject, str, paramDeserializationContext);
          }
        }
      }
    }
    label268:
    localTokenBuffer.writeEndObject();
    this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject, localTokenBuffer);
    return localObject;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    SettableBeanProperty localSettableBeanProperty;
    if (this._needViewProcesing)
    {
      localObject2 = paramDeserializationContext.getActiveView();
      if (localObject1 != JsonToken.FIELD_NAME) {
        break label213;
      }
      localObject1 = paramJsonParser.getCurrentName();
      localSettableBeanProperty = this._beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localSettableBeanProperty == null) {
        break label151;
      }
      if ((localObject2 == null) || (localSettableBeanProperty.visibleInView((Class)localObject2))) {
        break label125;
      }
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      localObject1 = paramJsonParser.nextToken();
      break;
      localObject2 = null;
      break;
      try
      {
        label125:
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
      }
      continue;
      label151:
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1)))
      {
        paramJsonParser.skipChildren();
      }
      else
      {
        localTokenBuffer.writeFieldName((String)localObject1);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        if (this._anySetter != null) {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
        }
      }
    }
    label213:
    localTokenBuffer.writeEndObject();
    this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, paramObject, localTokenBuffer);
    return paramObject;
  }
  
  protected final Object deserializeWithView(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, Class<?> paramClass)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.FIELD_NAME)
    {
      localObject = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = this._beanProperties.find((String)localObject);
      if (localSettableBeanProperty != null) {
        if (!localSettableBeanProperty.visibleInView(paramClass)) {
          paramJsonParser.skipChildren();
        }
      }
      for (;;)
      {
        localObject = paramJsonParser.nextToken();
        break;
        try
        {
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramObject, (String)localObject, paramDeserializationContext);
        }
        continue;
        if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject))) {
          paramJsonParser.skipChildren();
        } else if (this._anySetter != null) {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject);
        } else {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject);
        }
      }
    }
    return paramObject;
  }
  
  protected Object handlePolymorphic(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
  {
    JsonDeserializer localJsonDeserializer = _findSubclassDeserializer(paramDeserializationContext, paramObject, paramTokenBuffer);
    if (localJsonDeserializer != null)
    {
      if (paramTokenBuffer == null) {
        break label105;
      }
      paramTokenBuffer.writeEndObject();
      paramTokenBuffer = paramTokenBuffer.asParser();
      paramTokenBuffer.nextToken();
    }
    label105:
    for (paramTokenBuffer = localJsonDeserializer.deserialize(paramTokenBuffer, paramDeserializationContext, paramObject);; paramTokenBuffer = (TokenBuffer)paramObject)
    {
      paramObject = paramTokenBuffer;
      if (paramJsonParser != null) {
        paramObject = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext, paramTokenBuffer);
      }
      return paramObject;
      if (paramTokenBuffer != null) {}
      for (paramTokenBuffer = handleUnknownProperties(paramDeserializationContext, paramObject, paramTokenBuffer);; paramTokenBuffer = (TokenBuffer)paramObject)
      {
        paramObject = paramTokenBuffer;
        if (paramJsonParser == null) {
          break;
        }
        return deserialize(paramJsonParser, paramDeserializationContext, paramTokenBuffer);
      }
    }
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer)
  {
    if (getClass() != BeanDeserializer.class) {
      return this;
    }
    return new BeanDeserializer(this, paramNameTransformer);
  }
  
  public BeanDeserializer withIgnorableProperties(HashSet<String> paramHashSet)
  {
    return new BeanDeserializer(this, paramHashSet);
  }
  
  public BeanDeserializer withObjectIdReader(ObjectIdReader paramObjectIdReader)
  {
    return new BeanDeserializer(this, paramObjectIdReader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/BeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */