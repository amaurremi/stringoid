package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;

public class BuilderBasedDeserializer
  extends BeanDeserializerBase
{
  protected final AnnotatedMethod _buildMethod;
  
  public BuilderBasedDeserializer(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBeanDeserializerBuilder, paramBeanDescription, paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean1, paramBoolean2);
    this._buildMethod = paramBeanDeserializerBuilder.getBuildMethod();
    if (this._objectIdReader != null) {
      throw new IllegalArgumentException("Can not use Object Id with Builder-based deserialization (type " + paramBeanDescription.getType() + ")");
    }
  }
  
  public BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, ObjectIdReader paramObjectIdReader)
  {
    super(paramBuilderBasedDeserializer, paramObjectIdReader);
    this._buildMethod = paramBuilderBasedDeserializer._buildMethod;
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, NameTransformer paramNameTransformer)
  {
    super(paramBuilderBasedDeserializer, paramNameTransformer);
    this._buildMethod = paramBuilderBasedDeserializer._buildMethod;
  }
  
  public BuilderBasedDeserializer(BuilderBasedDeserializer paramBuilderBasedDeserializer, HashSet<String> paramHashSet)
  {
    super(paramBuilderBasedDeserializer, paramHashSet);
    this._buildMethod = paramBuilderBasedDeserializer._buildMethod;
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
      Object localObject = this._beanProperties.find(str);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = ((SettableBeanProperty)localObject).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramJsonToken);
          paramJsonToken = (JsonToken)localObject;
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramJsonToken, str, paramDeserializationContext);
          continue;
        }
        paramJsonParser.nextToken();
        break;
        _vanillaDeserializeHandleUnknown(paramJsonParser, paramDeserializationContext, paramJsonToken, str);
      }
    }
    return paramJsonToken;
  }
  
  protected final Object _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    if (this._injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    if (this._unwrappedPropertyHandler != null) {
      paramObject = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext, paramObject);
    }
    Object localObject1;
    do
    {
      return paramObject;
      if (this._externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, paramObject);
      }
      if (this._needViewProcesing)
      {
        localObject1 = paramDeserializationContext.getActiveView();
        if (localObject1 != null) {
          return deserializeWithView(paramJsonParser, paramDeserializationContext, paramObject, (Class)localObject1);
        }
      }
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      localObject2 = localJsonToken;
      localObject1 = paramObject;
      if (localJsonToken == JsonToken.START_OBJECT)
      {
        localObject2 = paramJsonParser.nextToken();
        localObject1 = paramObject;
      }
      paramObject = localObject1;
    } while (localObject2 != JsonToken.FIELD_NAME);
    Object localObject2 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    paramObject = this._beanProperties.find((String)localObject2);
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramObject = ((SettableBeanProperty)paramObject).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, localObject1);
        localObject1 = paramObject;
      }
      catch (Exception paramObject)
      {
        wrapAndThrow((Throwable)paramObject, localObject1, (String)localObject2, paramDeserializationContext);
        continue;
      }
      localObject2 = paramJsonParser.nextToken();
      break;
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject2))) {
        paramJsonParser.skipChildren();
      } else if (this._anySetter != null) {
        this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject1, (String)localObject2);
      } else {
        handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject1, (String)localObject2);
      }
    }
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext, this._objectIdReader);
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = null;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (localObject2 == JsonToken.FIELD_NAME)
      {
        localObject4 = paramJsonParser.getCurrentName();
        paramJsonParser.nextToken();
        SettableBeanProperty localSettableBeanProperty = localPropertyBasedCreator.findCreatorProperty((String)localObject4);
        if (localSettableBeanProperty != null)
        {
          Object localObject5 = localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext);
          localObject2 = localObject1;
          if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty.getCreatorIndex(), localObject5))
          {
            paramJsonParser.nextToken();
            try
            {
              localObject2 = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
              if (localObject2.getClass() == this._beanType.getRawClass()) {
                break label164;
              }
              return handlePolymorphic(paramJsonParser, paramDeserializationContext, localObject2, (TokenBuffer)localObject1);
            }
            catch (Exception localException)
            {
              wrapAndThrow(localException, this._beanType.getRawClass(), (String)localObject4, paramDeserializationContext);
              localObject3 = localObject1;
            }
          }
          else
          {
            localObject4 = paramJsonParser.nextToken();
            localObject1 = localObject3;
            localObject3 = localObject4;
            continue;
          }
          label164:
          if (localObject1 == null) {
            break label388;
          }
        }
      }
    }
    label386:
    label388:
    for (localObject1 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);; localObject1 = localObject3)
    {
      return _deserialize(paramJsonParser, paramDeserializationContext, localObject1);
      localObject3 = localObject1;
      if (localPropertyValueBuffer.readIdProperty((String)localObject4)) {
        break;
      }
      localObject3 = this._beanProperties.find((String)localObject4);
      if (localObject3 != null)
      {
        localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, ((SettableBeanProperty)localObject3).deserialize(paramJsonParser, paramDeserializationContext));
        localObject3 = localObject1;
        break;
      }
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject4)))
      {
        paramJsonParser.skipChildren();
        localObject3 = localObject1;
        break;
      }
      if (this._anySetter != null)
      {
        localPropertyValueBuffer.bufferAnyProperty(this._anySetter, (String)localObject4, this._anySetter.deserialize(paramJsonParser, paramDeserializationContext));
        localObject3 = localObject1;
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new TokenBuffer(paramJsonParser.getCodec());
      }
      ((TokenBuffer)localObject3).writeFieldName((String)localObject4);
      ((TokenBuffer)localObject3).copyCurrentStructure(paramJsonParser);
      break;
      try
      {
        paramJsonParser = localPropertyBasedCreator.build(paramDeserializationContext, localPropertyValueBuffer);
        if (localObject1 == null) {
          break label386;
        }
        if (paramJsonParser.getClass() != this._beanType.getRawClass()) {
          return handlePolymorphic(null, paramDeserializationContext, paramJsonParser, (TokenBuffer)localObject1);
        }
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
        return null;
      }
      return handleUnknownProperties(paramDeserializationContext, paramJsonParser, (TokenBuffer)localObject1);
      return paramJsonParser;
    }
  }
  
  protected BeanAsArrayBuilderDeserializer asArrayDeserializer()
  {
    return new BeanAsArrayBuilderDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder(), this._buildMethod);
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      localJsonToken = paramJsonParser.nextToken();
      if (this._vanillaProcessing) {
        return finishBuild(paramDeserializationContext, vanillaDeserialize(paramJsonParser, paramDeserializationContext, localJsonToken));
      }
      return finishBuild(paramDeserializationContext, deserializeFromObject(paramJsonParser, paramDeserializationContext));
    }
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localJsonToken.ordinal()])
    {
    default: 
      throw paramDeserializationContext.mappingException(getBeanClass());
    case 1: 
      return finishBuild(paramDeserializationContext, deserializeFromString(paramJsonParser, paramDeserializationContext));
    case 2: 
      return finishBuild(paramDeserializationContext, deserializeFromNumber(paramJsonParser, paramDeserializationContext));
    case 3: 
      return finishBuild(paramDeserializationContext, deserializeFromDouble(paramJsonParser, paramDeserializationContext));
    case 4: 
      return paramJsonParser.getEmbeddedObject();
    case 5: 
    case 6: 
      return finishBuild(paramDeserializationContext, deserializeFromBoolean(paramJsonParser, paramDeserializationContext));
    case 7: 
      return finishBuild(paramDeserializationContext, deserializeFromArray(paramJsonParser, paramDeserializationContext));
    }
    return finishBuild(paramDeserializationContext, deserializeFromObject(paramJsonParser, paramDeserializationContext));
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    return finishBuild(paramDeserializationContext, _deserialize(paramJsonParser, paramDeserializationContext, paramObject));
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
  
  /* Error */
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 418	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_nonStandardCreation	Z
    //   4: ifeq +42 -> 46
    //   7: aload_0
    //   8: getfield 166	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_unwrappedPropertyHandler	Lcom/fasterxml/jackson/databind/deser/impl/UnwrappedPropertyHandler;
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 420	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:deserializeWithUnwrapped	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    //   20: astore 4
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: getfield 173	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_externalTypeIdHandler	Lcom/fasterxml/jackson/databind/deser/impl/ExternalTypeHandler;
    //   29: ifnull +10 -> 39
    //   32: aload_0
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 422	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:deserializeWithExternalTypeId	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    //   38: areturn
    //   39: aload_0
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 425	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:deserializeFromObjectUsingNonDefault	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    //   45: areturn
    //   46: aload_0
    //   47: getfield 113	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_valueInstantiator	Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    //   50: aload_2
    //   51: invokevirtual 119	com/fasterxml/jackson/databind/deser/ValueInstantiator:createUsingDefault	(Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    //   54: astore 4
    //   56: aload_0
    //   57: getfield 158	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_injectables	[Lcom/fasterxml/jackson/databind/deser/impl/ValueInjector;
    //   60: ifnull +10 -> 70
    //   63: aload_0
    //   64: aload_2
    //   65: aload 4
    //   67: invokevirtual 162	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:injectValues	(Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)V
    //   70: aload 4
    //   72: astore_3
    //   73: aload_0
    //   74: getfield 180	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_needViewProcesing	Z
    //   77: ifeq +45 -> 122
    //   80: aload_2
    //   81: invokevirtual 186	com/fasterxml/jackson/databind/DeserializationContext:getActiveView	()Ljava/lang/Class;
    //   84: astore 5
    //   86: aload 4
    //   88: astore_3
    //   89: aload 5
    //   91: ifnull +31 -> 122
    //   94: aload_0
    //   95: aload_1
    //   96: aload_2
    //   97: aload 4
    //   99: aload 5
    //   101: invokevirtual 190	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:deserializeWithView	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   104: areturn
    //   105: astore 4
    //   107: aload_0
    //   108: aload 4
    //   110: aload_3
    //   111: aload 5
    //   113: aload_2
    //   114: invokevirtual 104	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:wrapAndThrow	(Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)V
    //   117: aload_1
    //   118: invokevirtual 135	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   121: pop
    //   122: aload_3
    //   123: astore 4
    //   125: aload_1
    //   126: invokevirtual 123	com/fasterxml/jackson/core/JsonParser:getCurrentToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   129: getstatic 129	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   132: if_acmpeq -110 -> 22
    //   135: aload_1
    //   136: invokevirtual 132	com/fasterxml/jackson/core/JsonParser:getCurrentName	()Ljava/lang/String;
    //   139: astore 5
    //   141: aload_1
    //   142: invokevirtual 135	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   145: pop
    //   146: aload_0
    //   147: getfield 139	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_beanProperties	Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    //   150: aload 5
    //   152: invokevirtual 145	com/fasterxml/jackson/databind/deser/impl/BeanPropertyMap:find	(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    //   155: astore 4
    //   157: aload 4
    //   159: ifnull +19 -> 178
    //   162: aload 4
    //   164: aload_1
    //   165: aload_2
    //   166: aload_3
    //   167: invokevirtual 151	com/fasterxml/jackson/databind/deser/SettableBeanProperty:deserializeSetAndReturn	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: astore 4
    //   172: aload 4
    //   174: astore_3
    //   175: goto -58 -> 117
    //   178: aload_0
    //   179: getfield 79	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_ignorableProps	Ljava/util/HashSet;
    //   182: ifnull +23 -> 205
    //   185: aload_0
    //   186: getfield 79	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_ignorableProps	Ljava/util/HashSet;
    //   189: aload 5
    //   191: invokevirtual 85	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   194: ifeq +11 -> 205
    //   197: aload_1
    //   198: invokevirtual 91	com/fasterxml/jackson/core/JsonParser:skipChildren	()Lcom/fasterxml/jackson/core/JsonParser;
    //   201: pop
    //   202: goto -85 -> 117
    //   205: aload_0
    //   206: getfield 95	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_anySetter	Lcom/fasterxml/jackson/databind/deser/SettableAnyProperty;
    //   209: ifnull +33 -> 242
    //   212: aload_0
    //   213: getfield 95	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:_anySetter	Lcom/fasterxml/jackson/databind/deser/SettableAnyProperty;
    //   216: aload_1
    //   217: aload_2
    //   218: aload_3
    //   219: aload 5
    //   221: invokevirtual 100	com/fasterxml/jackson/databind/deser/SettableAnyProperty:deserializeAndSet	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;Ljava/lang/String;)V
    //   224: goto -107 -> 117
    //   227: astore 4
    //   229: aload_0
    //   230: aload 4
    //   232: aload_3
    //   233: aload 5
    //   235: aload_2
    //   236: invokevirtual 104	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:wrapAndThrow	(Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)V
    //   239: goto -122 -> 117
    //   242: aload_0
    //   243: aload_1
    //   244: aload_2
    //   245: aload_3
    //   246: aload 5
    //   248: invokevirtual 107	com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer:handleUnknownProperty	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;Ljava/lang/String;)V
    //   251: goto -134 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	BuilderBasedDeserializer
    //   0	254	1	paramJsonParser	JsonParser
    //   0	254	2	paramDeserializationContext	DeserializationContext
    //   72	174	3	localObject1	Object
    //   20	78	4	localObject2	Object
    //   105	4	4	localException1	Exception
    //   123	50	4	localObject3	Object
    //   227	4	4	localException2	Exception
    //   84	163	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   162	172	105	java/lang/Exception
    //   212	224	227	java/lang/Exception
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
    throw new IllegalStateException("Deserialization with Builder, External type id, @JsonCreator not yet implemented");
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
        if (localObject3.getClass() != this._beanType.getRawClass()) {
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
    Object localObject1;
    if (this._needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      localExternalTypeHandler = this._externalTypeIdHandler.start();
      if (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
        break label234;
      }
      str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject1 = this._beanProperties.find(str);
      if (localObject1 == null) {
        break label130;
      }
      if ((localClass == null) || (((SettableBeanProperty)localObject1).visibleInView(localClass))) {
        break label99;
      }
      paramJsonParser.skipChildren();
      localObject1 = paramObject;
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      paramObject = localObject1;
      break label22;
      localClass = null;
      break;
      label99:
      Object localObject2;
      try
      {
        localObject1 = ((SettableBeanProperty)localObject1).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, paramObject, str, paramDeserializationContext);
        localObject2 = paramObject;
      }
      continue;
      label130:
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(str)))
      {
        paramJsonParser.skipChildren();
        localObject2 = paramObject;
      }
      else
      {
        localObject2 = paramObject;
        if (!localExternalTypeHandler.handlePropertyValue(paramJsonParser, paramDeserializationContext, str, paramObject))
        {
          Object localObject3;
          if (this._anySetter != null)
          {
            try
            {
              this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, str);
              localObject2 = paramObject;
            }
            catch (Exception localException2)
            {
              wrapAndThrow(localException2, paramObject, str, paramDeserializationContext);
              localObject3 = paramObject;
            }
          }
          else
          {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, str);
            localObject3 = paramObject;
          }
        }
      }
    }
    label234:
    return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, paramObject);
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
    Object localObject1 = this._valueInstantiator.createUsingDefault(paramDeserializationContext);
    if (this._injectables != null) {
      injectValues(paramDeserializationContext, localObject1);
    }
    Class localClass;
    String str;
    Object localObject2;
    if (this._needViewProcesing)
    {
      localClass = paramDeserializationContext.getActiveView();
      if (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT) {
        break label298;
      }
      str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject2 = this._beanProperties.find(str);
      if (localObject2 == null) {
        break label203;
      }
      if ((localClass == null) || (((SettableBeanProperty)localObject2).visibleInView(localClass))) {
        break label169;
      }
      paramJsonParser.skipChildren();
      localObject2 = localObject1;
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      localObject1 = localObject2;
      break;
      localClass = null;
      break;
      label169:
      Object localObject3;
      try
      {
        localObject2 = ((SettableBeanProperty)localObject2).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, localObject1);
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, localObject1, str, paramDeserializationContext);
        localObject3 = localObject1;
      }
      continue;
      label203:
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(str)))
      {
        paramJsonParser.skipChildren();
        localObject3 = localObject1;
      }
      else
      {
        localTokenBuffer.writeFieldName(str);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        localObject3 = localObject1;
        if (this._anySetter != null) {
          try
          {
            this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject1, str);
            localObject3 = localObject1;
          }
          catch (Exception localException2)
          {
            wrapAndThrow(localException2, localObject1, str, paramDeserializationContext);
            Object localObject4 = localObject1;
          }
        }
      }
    }
    label298:
    localTokenBuffer.writeEndObject();
    this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, localObject1, localTokenBuffer);
    return localObject1;
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
    Object localObject3;
    if (this._needViewProcesing)
    {
      localObject2 = paramDeserializationContext.getActiveView();
      if (localObject1 != JsonToken.FIELD_NAME) {
        break label233;
      }
      localObject1 = paramJsonParser.getCurrentName();
      localObject3 = this._beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localObject3 == null) {
        break label162;
      }
      if ((localObject2 == null) || (((SettableBeanProperty)localObject3).visibleInView((Class)localObject2))) {
        break label131;
      }
      paramJsonParser.skipChildren();
      localObject3 = paramObject;
    }
    for (;;)
    {
      localObject1 = paramJsonParser.nextToken();
      paramObject = localObject3;
      break;
      localObject2 = null;
      break;
      label131:
      Object localObject4;
      try
      {
        localObject3 = ((SettableBeanProperty)localObject3).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
        localObject4 = paramObject;
      }
      continue;
      label162:
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1)))
      {
        paramJsonParser.skipChildren();
        localObject4 = paramObject;
      }
      else
      {
        localTokenBuffer.writeFieldName((String)localObject1);
        localTokenBuffer.copyCurrentStructure(paramJsonParser);
        localObject4 = paramObject;
        if (this._anySetter != null)
        {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
          localObject4 = paramObject;
        }
      }
    }
    label233:
    localTokenBuffer.writeEndObject();
    this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, paramObject, localTokenBuffer);
    return paramObject;
  }
  
  protected final Object deserializeWithView(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, Class<?> paramClass)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.FIELD_NAME)
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject = this._beanProperties.find(str);
      if (localObject != null) {
        if (!((SettableBeanProperty)localObject).visibleInView(paramClass)) {
          paramJsonParser.skipChildren();
        }
      }
      for (;;)
      {
        localObject = paramJsonParser.nextToken();
        break;
        try
        {
          localObject = ((SettableBeanProperty)localObject).deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
          paramObject = localObject;
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramObject, str, paramDeserializationContext);
        }
        continue;
        if ((this._ignorableProps != null) && (this._ignorableProps.contains(str))) {
          paramJsonParser.skipChildren();
        } else if (this._anySetter != null) {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, str);
        } else {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, str);
        }
      }
    }
    return paramObject;
  }
  
  protected final Object finishBuild(DeserializationContext paramDeserializationContext, Object paramObject)
  {
    try
    {
      paramObject = this._buildMethod.getMember().invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      wrapInstantiationProblem((Throwable)paramObject, paramDeserializationContext);
    }
    return null;
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
    return new BuilderBasedDeserializer(this, paramNameTransformer);
  }
  
  public BuilderBasedDeserializer withIgnorableProperties(HashSet<String> paramHashSet)
  {
    return new BuilderBasedDeserializer(this, paramHashSet);
  }
  
  public BuilderBasedDeserializer withObjectIdReader(ObjectIdReader paramObjectIdReader)
  {
    return new BuilderBasedDeserializer(this, paramObjectIdReader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/BuilderBasedDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */