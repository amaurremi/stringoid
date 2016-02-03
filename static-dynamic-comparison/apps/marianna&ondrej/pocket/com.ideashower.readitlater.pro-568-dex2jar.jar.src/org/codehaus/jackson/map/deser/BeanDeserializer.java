package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JsonCachable;
import org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import org.codehaus.jackson.map.deser.impl.CreatorCollector;
import org.codehaus.jackson.map.deser.impl.ExternalTypeHandler;
import org.codehaus.jackson.map.deser.impl.ExternalTypeHandler.Builder;
import org.codehaus.jackson.map.deser.impl.PropertyBasedCreator;
import org.codehaus.jackson.map.deser.impl.PropertyValueBuffer;
import org.codehaus.jackson.map.deser.impl.UnwrappedPropertyHandler;
import org.codehaus.jackson.map.deser.impl.ValueInjector;
import org.codehaus.jackson.map.deser.std.ContainerDeserializerBase;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

@JsonCachable
public class BeanDeserializer
  extends StdDeserializer
  implements ResolvableDeserializer
{
  protected SettableAnyProperty _anySetter;
  protected final Map _backRefs;
  protected final BeanPropertyMap _beanProperties;
  protected final JavaType _beanType;
  protected JsonDeserializer _delegateDeserializer;
  protected ExternalTypeHandler _externalTypeIdHandler;
  protected final AnnotatedClass _forClass;
  protected final HashSet _ignorableProps;
  protected final boolean _ignoreAllUnknown;
  protected final ValueInjector[] _injectables;
  protected boolean _nonStandardCreation;
  protected final BeanProperty _property;
  protected final PropertyBasedCreator _propertyBasedCreator;
  protected HashMap _subDeserializers;
  protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
  protected final ValueInstantiator _valueInstantiator;
  
  public BeanDeserializer(BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, ValueInstantiator paramValueInstantiator, BeanPropertyMap paramBeanPropertyMap, Map paramMap, HashSet paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty, List paramList)
  {
    this(paramBeanDescription.getClassInfo(), paramBeanDescription.getType(), paramBeanProperty, paramValueInstantiator, paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean, paramSettableAnyProperty, paramList);
  }
  
  protected BeanDeserializer(BeanDeserializer paramBeanDeserializer)
  {
    this(paramBeanDeserializer, paramBeanDeserializer._ignoreAllUnknown);
  }
  
  protected BeanDeserializer(BeanDeserializer paramBeanDeserializer, boolean paramBoolean)
  {
    super(paramBeanDeserializer._beanType);
    this._forClass = paramBeanDeserializer._forClass;
    this._beanType = paramBeanDeserializer._beanType;
    this._property = paramBeanDeserializer._property;
    this._valueInstantiator = paramBeanDeserializer._valueInstantiator;
    this._delegateDeserializer = paramBeanDeserializer._delegateDeserializer;
    this._propertyBasedCreator = paramBeanDeserializer._propertyBasedCreator;
    this._beanProperties = paramBeanDeserializer._beanProperties;
    this._backRefs = paramBeanDeserializer._backRefs;
    this._ignorableProps = paramBeanDeserializer._ignorableProps;
    this._ignoreAllUnknown = paramBoolean;
    this._anySetter = paramBeanDeserializer._anySetter;
    this._injectables = paramBeanDeserializer._injectables;
    this._nonStandardCreation = paramBeanDeserializer._nonStandardCreation;
    this._unwrappedPropertyHandler = paramBeanDeserializer._unwrappedPropertyHandler;
  }
  
  protected BeanDeserializer(AnnotatedClass paramAnnotatedClass, JavaType paramJavaType, BeanProperty paramBeanProperty, ValueInstantiator paramValueInstantiator, BeanPropertyMap paramBeanPropertyMap, Map paramMap, HashSet paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty, List paramList)
  {
    super(paramJavaType);
    this._forClass = paramAnnotatedClass;
    this._beanType = paramJavaType;
    this._property = paramBeanProperty;
    this._valueInstantiator = paramValueInstantiator;
    if (paramValueInstantiator.canCreateFromObjectWith())
    {
      this._propertyBasedCreator = new PropertyBasedCreator(paramValueInstantiator);
      this._beanProperties = paramBeanPropertyMap;
      this._backRefs = paramMap;
      this._ignorableProps = paramHashSet;
      this._ignoreAllUnknown = paramBoolean;
      this._anySetter = paramSettableAnyProperty;
      paramAnnotatedClass = (AnnotatedClass)localObject;
      if (paramList != null)
      {
        if (!paramList.isEmpty()) {
          break label154;
        }
        paramAnnotatedClass = (AnnotatedClass)localObject;
      }
      label101:
      this._injectables = paramAnnotatedClass;
      if ((!paramValueInstantiator.canCreateUsingDelegate()) && (this._propertyBasedCreator == null) && (paramValueInstantiator.canCreateUsingDefault()) && (this._unwrappedPropertyHandler == null)) {
        break label178;
      }
    }
    label154:
    label178:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this._nonStandardCreation = paramBoolean;
      return;
      this._propertyBasedCreator = null;
      break;
      paramAnnotatedClass = (ValueInjector[])paramList.toArray(new ValueInjector[paramList.size()]);
      break label101;
    }
  }
  
  @Deprecated
  public BeanDeserializer(AnnotatedClass paramAnnotatedClass, JavaType paramJavaType, BeanProperty paramBeanProperty, CreatorCollector paramCreatorCollector, BeanPropertyMap paramBeanPropertyMap, Map paramMap, HashSet paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty)
  {
    this(paramAnnotatedClass, paramJavaType, paramBeanProperty, paramCreatorCollector.constructValueInstantiator(null), paramBeanPropertyMap, paramMap, paramHashSet, paramBoolean, paramSettableAnyProperty, null);
  }
  
  private final void _handleUnknown(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
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
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext);
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
          if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty.getPropertyIndex(), localObject5))
          {
            paramJsonParser.nextToken();
            try
            {
              localObject2 = localPropertyBasedCreator.build(localPropertyValueBuffer);
              if (localObject2.getClass() == this._beanType.getRawClass()) {
                break label159;
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
          label159:
          if (localObject1 == null) {
            break label369;
          }
        }
      }
    }
    label367:
    label369:
    for (localObject1 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);; localObject1 = localObject3)
    {
      return deserialize(paramJsonParser, paramDeserializationContext, localObject1);
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
        paramJsonParser = localPropertyBasedCreator.build(localPropertyValueBuffer);
        if (localObject1 == null) {
          break label367;
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
  
  protected JsonDeserializer _findSubclassDeserializer(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
  {
    try
    {
      if (this._subDeserializers == null) {}
      for (paramTokenBuffer = null;; paramTokenBuffer = (JsonDeserializer)this._subDeserializers.get(new ClassKey(paramObject.getClass())))
      {
        if (paramTokenBuffer == null) {
          break;
        }
        return paramTokenBuffer;
      }
      localDeserializerProvider = paramDeserializationContext.getDeserializerProvider();
    }
    finally {}
    DeserializerProvider localDeserializerProvider;
    if (localDeserializerProvider != null)
    {
      paramTokenBuffer = paramDeserializationContext.constructType(paramObject.getClass());
      paramDeserializationContext = localDeserializerProvider.findValueDeserializer(paramDeserializationContext.getConfig(), paramTokenBuffer, this._property);
      paramTokenBuffer = paramDeserializationContext;
      if (paramDeserializationContext != null) {
        try
        {
          if (this._subDeserializers == null) {
            this._subDeserializers = new HashMap();
          }
          this._subDeserializers.put(new ClassKey(paramObject.getClass()), paramDeserializationContext);
          return paramDeserializationContext;
        }
        finally {}
      }
    }
    return paramTokenBuffer;
  }
  
  protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationConfig paramDeserializationConfig, SettableBeanProperty paramSettableBeanProperty)
  {
    Object localObject2 = paramSettableBeanProperty.getValueDeserializer();
    Object localObject1 = paramSettableBeanProperty;
    Object localObject3;
    int j;
    int i;
    if ((localObject2 instanceof BeanDeserializer))
    {
      localObject1 = paramSettableBeanProperty;
      if (!((BeanDeserializer)localObject2).getValueInstantiator().canCreateUsingDefault())
      {
        localObject3 = paramSettableBeanProperty.getType().getRawClass();
        localObject2 = ClassUtil.getOuterClass((Class)localObject3);
        localObject1 = paramSettableBeanProperty;
        if (localObject2 != null)
        {
          localObject1 = paramSettableBeanProperty;
          if (localObject2 == this._beanType.getRawClass())
          {
            localObject3 = ((Class)localObject3).getConstructors();
            j = localObject3.length;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramSettableBeanProperty;
      if (i < j)
      {
        localObject1 = localObject3[i];
        Class[] arrayOfClass = ((Constructor)localObject1).getParameterTypes();
        if ((arrayOfClass.length == 1) && (arrayOfClass[0] == localObject2))
        {
          if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            ClassUtil.checkAndFixAccess((Member)localObject1);
          }
          localObject1 = new SettableBeanProperty.InnerClassProperty(paramSettableBeanProperty, (Constructor)localObject1);
        }
      }
      else
      {
        return (SettableBeanProperty)localObject1;
      }
      i += 1;
    }
  }
  
  protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationConfig paramDeserializationConfig, SettableBeanProperty paramSettableBeanProperty)
  {
    String str = paramSettableBeanProperty.getManagedReferenceName();
    if (str == null) {
      return paramSettableBeanProperty;
    }
    paramDeserializationConfig = paramSettableBeanProperty.getValueDeserializer();
    boolean bool = false;
    if ((paramDeserializationConfig instanceof BeanDeserializer)) {
      paramDeserializationConfig = ((BeanDeserializer)paramDeserializationConfig).findBackReference(str);
    }
    while (paramDeserializationConfig == null)
    {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': no back reference property found from type " + paramSettableBeanProperty.getType());
      if ((paramDeserializationConfig instanceof ContainerDeserializerBase))
      {
        paramDeserializationConfig = ((ContainerDeserializerBase)paramDeserializationConfig).getContentDeserializer();
        if (!(paramDeserializationConfig instanceof BeanDeserializer)) {
          throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + paramDeserializationConfig.getClass().getName() + ")");
        }
        paramDeserializationConfig = ((BeanDeserializer)paramDeserializationConfig).findBackReference(str);
        bool = true;
      }
      else
      {
        if ((paramDeserializationConfig instanceof AbstractDeserializer)) {
          throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this._beanType.getRawClass().getName() + "." + paramSettableBeanProperty.getName() + ")");
        }
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + paramDeserializationConfig.getClass().getName());
      }
    }
    JavaType localJavaType1 = this._beanType;
    JavaType localJavaType2 = paramDeserializationConfig.getType();
    if (!localJavaType2.getRawClass().isAssignableFrom(localJavaType1.getRawClass())) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': back reference type (" + localJavaType2.getRawClass().getName() + ") not compatible with managed type (" + localJavaType1.getRawClass().getName() + ")");
    }
    return new SettableBeanProperty.ManagedReferenceProperty(str, paramSettableBeanProperty, paramDeserializationConfig, this._forClass.getAnnotations(), bool);
  }
  
  protected SettableBeanProperty _resolveUnwrappedProperty(DeserializationConfig paramDeserializationConfig, SettableBeanProperty paramSettableBeanProperty)
  {
    Object localObject = paramSettableBeanProperty.getMember();
    if ((localObject != null) && (paramDeserializationConfig.getAnnotationIntrospector().shouldUnwrapProperty((AnnotatedMember)localObject) == Boolean.TRUE))
    {
      paramDeserializationConfig = paramSettableBeanProperty.getValueDeserializer();
      localObject = paramDeserializationConfig.unwrappingDeserializer();
      if ((localObject != paramDeserializationConfig) && (localObject != null)) {
        return paramSettableBeanProperty.withValueDeserializer((JsonDeserializer)localObject);
      }
    }
    return null;
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      paramJsonParser.nextToken();
      return deserializeFromObject(paramJsonParser, paramDeserializationContext);
    }
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[localJsonToken.ordinal()])
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
    return deserializeFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    if (this._injectables != null) {
      injectValues(paramDeserializationContext, paramObject);
    }
    if (this._unwrappedPropertyHandler != null) {
      localObject2 = deserializeWithUnwrapped(paramJsonParser, paramDeserializationContext, paramObject);
    }
    do
    {
      return localObject2;
      if (this._externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, paramObject);
      }
      localObject2 = paramJsonParser.getCurrentToken();
      localObject1 = localObject2;
      if (localObject2 == JsonToken.START_OBJECT) {
        localObject1 = paramJsonParser.nextToken();
      }
      localObject2 = paramObject;
    } while (localObject1 != JsonToken.FIELD_NAME);
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    Object localObject2 = this._beanProperties.find((String)localObject1);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        ((SettableBeanProperty)localObject2).deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
        localObject1 = paramJsonParser.nextToken();
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
        paramJsonParser = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
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
      paramJsonParser = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      if (this._injectables != null) {
        injectValues(paramDeserializationContext, paramJsonParser);
      }
      return paramJsonParser;
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_TRUE) {}
    for (boolean bool = true;; bool = false) {
      return this._valueInstantiator.createFromBoolean(bool);
    }
  }
  
  public Object deserializeFromDouble(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
    {
    default: 
      if (this._delegateDeserializer != null) {
        paramJsonParser = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
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
        localObject = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        paramJsonParser = (JsonParser)localObject;
      } while (this._injectables == null);
      injectValues(paramDeserializationContext, localObject);
      return localObject;
      return this._valueInstantiator.createFromDouble(paramJsonParser.getDoubleValue());
    }
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON floating-point number");
  }
  
  public Object deserializeFromNumber(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject;
    switch (1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
    {
    default: 
      if (this._delegateDeserializer == null) {
        break label201;
      }
      localObject = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      paramJsonParser = (JsonParser)localObject;
      if (this._injectables != null)
      {
        injectValues(paramDeserializationContext, localObject);
        paramJsonParser = (JsonParser)localObject;
      }
      break;
    }
    do
    {
      do
      {
        return paramJsonParser;
        if ((this._delegateDeserializer == null) || (this._valueInstantiator.canCreateFromInt())) {
          break;
        }
        localObject = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
        paramJsonParser = (JsonParser)localObject;
      } while (this._injectables == null);
      injectValues(paramDeserializationContext, localObject);
      return localObject;
      return this._valueInstantiator.createFromInt(paramJsonParser.getIntValue());
      if ((this._delegateDeserializer == null) || (this._valueInstantiator.canCreateFromInt())) {
        break;
      }
      localObject = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      paramJsonParser = (JsonParser)localObject;
    } while (this._injectables == null);
    injectValues(paramDeserializationContext, localObject);
    return localObject;
    return this._valueInstantiator.createFromLong(paramJsonParser.getLongValue());
    label201:
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
      localObject2 = this._valueInstantiator.createUsingDefault();
      if (this._injectables != null) {
        injectValues(paramDeserializationContext, localObject2);
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
      catch (Exception localException)
      {
        wrapAndThrow(localException, localObject2, (String)localObject1, paramDeserializationContext);
        continue;
      }
      _handleUnknown(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
    }
  }
  
  protected Object deserializeFromObjectUsingNonDefault(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      return this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
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
    if ((this._delegateDeserializer != null) && (!this._valueInstantiator.canCreateFromString()))
    {
      paramJsonParser = this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      if (this._injectables != null) {
        injectValues(paramDeserializationContext, paramJsonParser);
      }
      return paramJsonParser;
    }
    return this._valueInstantiator.createFromString(paramJsonParser.getText());
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    ExternalTypeHandler localExternalTypeHandler = this._externalTypeIdHandler.start();
    PropertyBasedCreator localPropertyBasedCreator = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext);
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
        if (localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject1).getPropertyIndex(), localObject3))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(localPropertyValueBuffer);
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
        if (localObject3.getClass() != this._beanType.getRawClass()) {
          throw paramDeserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
        }
        return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localObject3);
        localObject2 = this._beanProperties.find(str);
        if (localObject2 != null) {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject2, ((SettableBeanProperty)localObject2).deserialize(paramJsonParser, paramDeserializationContext));
        } else if (!localExternalTypeHandler.handleToken(paramJsonParser, paramDeserializationContext, str, null)) {
          if ((this._ignorableProps != null) && (this._ignorableProps.contains(str))) {
            paramJsonParser.skipChildren();
          } else if (this._anySetter != null) {
            localPropertyValueBuffer.bufferAnyProperty(this._anySetter, str, this._anySetter.deserialize(paramJsonParser, paramDeserializationContext));
          }
        }
      }
    }
    try
    {
      localObject2 = localPropertyBasedCreator.build(localPropertyValueBuffer);
      return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, localObject2);
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
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBasedCreator.startBuilding(paramJsonParser, paramDeserializationContext);
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
        if (localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject1).getPropertyIndex(), localObject3))
        {
          localObject1 = paramJsonParser.nextToken();
          try
          {
            localObject3 = localPropertyBasedCreator.build(localPropertyValueBuffer);
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
    try
    {
      localObject2 = localPropertyBasedCreator.build(localPropertyValueBuffer);
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
    return deserializeWithExternalTypeId(paramJsonParser, paramDeserializationContext, this._valueInstantiator.createUsingDefault());
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    ExternalTypeHandler localExternalTypeHandler = this._externalTypeIdHandler.start();
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
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
          paramJsonParser.nextToken();
        }
        catch (Exception localException1)
        {
          wrapAndThrow(localException1, paramObject, str, paramDeserializationContext);
          continue;
        }
        if ((this._ignorableProps != null) && (this._ignorableProps.contains(str))) {
          paramJsonParser.skipChildren();
        } else if (!localExternalTypeHandler.handleToken(paramJsonParser, paramDeserializationContext, str, paramObject)) {
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
    }
    return localExternalTypeHandler.complete(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  protected Object deserializeWithUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._delegateDeserializer != null) {
      return this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    if (this._propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(paramJsonParser, paramDeserializationContext);
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartObject();
    Object localObject = this._valueInstantiator.createUsingDefault();
    if (this._injectables != null) {
      injectValues(paramDeserializationContext, localObject);
    }
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
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject);
          paramJsonParser.nextToken();
        }
        catch (Exception localException1)
        {
          wrapAndThrow(localException1, localObject, str, paramDeserializationContext);
          continue;
        }
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
    }
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
    localObject2 = new TokenBuffer(paramJsonParser.getCodec());
    ((TokenBuffer)localObject2).writeStartObject();
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      SettableBeanProperty localSettableBeanProperty = this._beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localSettableBeanProperty != null) {}
      for (;;)
      {
        try
        {
          localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
          localObject1 = paramJsonParser.nextToken();
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
          continue;
        }
        if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1)))
        {
          paramJsonParser.skipChildren();
        }
        else
        {
          ((TokenBuffer)localObject2).writeFieldName((String)localObject1);
          ((TokenBuffer)localObject2).copyCurrentStructure(paramJsonParser);
          if (this._anySetter != null) {
            this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
          }
        }
      }
    }
    ((TokenBuffer)localObject2).writeEndObject();
    this._unwrappedPropertyHandler.processUnwrapped(paramJsonParser, paramDeserializationContext, paramObject, (TokenBuffer)localObject2);
    return paramObject;
  }
  
  public SettableBeanProperty findBackReference(String paramString)
  {
    if (this._backRefs == null) {
      return null;
    }
    return (SettableBeanProperty)this._backRefs.get(paramString);
  }
  
  public final Class getBeanClass()
  {
    return this._beanType.getRawClass();
  }
  
  public int getPropertyCount()
  {
    return this._beanProperties.size();
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return this._valueInstantiator;
  }
  
  public JavaType getValueType()
  {
    return this._beanType;
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
  
  protected Object handleUnknownProperties(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
  {
    paramTokenBuffer.writeEndObject();
    paramTokenBuffer = paramTokenBuffer.asParser();
    while (paramTokenBuffer.nextToken() != JsonToken.END_OBJECT)
    {
      String str = paramTokenBuffer.getCurrentName();
      paramTokenBuffer.nextToken();
      handleUnknownProperty(paramTokenBuffer, paramDeserializationContext, paramObject, str);
    }
    return paramObject;
  }
  
  protected void handleUnknownProperty(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
  {
    if ((this._ignoreAllUnknown) || ((this._ignorableProps != null) && (this._ignorableProps.contains(paramString))))
    {
      paramJsonParser.skipChildren();
      return;
    }
    super.handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, paramString);
  }
  
  public boolean hasProperty(String paramString)
  {
    return this._beanProperties.find(paramString) != null;
  }
  
  protected void injectValues(DeserializationContext paramDeserializationContext, Object paramObject)
  {
    ValueInjector[] arrayOfValueInjector = this._injectables;
    int j = arrayOfValueInjector.length;
    int i = 0;
    while (i < j)
    {
      arrayOfValueInjector[i].inject(paramDeserializationContext, paramObject);
      i += 1;
    }
  }
  
  public Iterator properties()
  {
    if (this._beanProperties == null) {
      throw new IllegalStateException("Can only call before BeanDeserializer has been resolved");
    }
    return this._beanProperties.allProperties();
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
  {
    Iterator localIterator = this._beanProperties.allProperties();
    ExternalTypeHandler.Builder localBuilder = null;
    Object localObject1 = null;
    Object localObject4;
    if (localIterator.hasNext())
    {
      localObject4 = (SettableBeanProperty)localIterator.next();
      if (((SettableBeanProperty)localObject4).hasValueDeserializer()) {
        break label510;
      }
    }
    label510:
    for (Object localObject2 = ((SettableBeanProperty)localObject4).withValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, ((SettableBeanProperty)localObject4).getType(), (BeanProperty)localObject4));; localObject2 = localObject4)
    {
      localObject2 = _resolveManagedReferenceProperty(paramDeserializationConfig, (SettableBeanProperty)localObject2);
      Object localObject3 = _resolveUnwrappedProperty(paramDeserializationConfig, (SettableBeanProperty)localObject2);
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new UnwrappedPropertyHandler();
        }
        ((UnwrappedPropertyHandler)localObject2).addProperty((SettableBeanProperty)localObject3);
      }
      for (localObject1 = localObject3;; localObject1 = localObject3)
      {
        localObject3 = _resolveInnerClassValuedProperty(paramDeserializationConfig, (SettableBeanProperty)localObject1);
        if (localObject3 != localObject4) {
          this._beanProperties.replace((SettableBeanProperty)localObject3);
        }
        localObject1 = localObject2;
        if (!((SettableBeanProperty)localObject3).hasValueTypeDeserializer()) {
          break;
        }
        localObject4 = ((SettableBeanProperty)localObject3).getValueTypeDeserializer();
        localObject1 = localObject2;
        if (((TypeDeserializer)localObject4).getTypeInclusion() != JsonTypeInfo.As.EXTERNAL_PROPERTY) {
          break;
        }
        if (localBuilder == null) {
          localBuilder = new ExternalTypeHandler.Builder();
        }
        for (;;)
        {
          localBuilder.addExternal((SettableBeanProperty)localObject3, ((TypeDeserializer)localObject4).getPropertyName());
          this._beanProperties.remove((SettableBeanProperty)localObject3);
          localObject1 = localObject2;
          break;
          if ((this._anySetter != null) && (!this._anySetter.hasValueDeserializer())) {
            this._anySetter = this._anySetter.withValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, this._anySetter.getType(), this._anySetter.getProperty()));
          }
          if (this._valueInstantiator.canCreateUsingDelegate())
          {
            localObject2 = this._valueInstantiator.getDelegateType();
            if (localObject2 == null) {
              throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._beanType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            localObject3 = this._valueInstantiator.getDelegateCreator();
            this._delegateDeserializer = findDeserializer(paramDeserializationConfig, paramDeserializerProvider, (JavaType)localObject2, new BeanProperty.Std(null, (JavaType)localObject2, this._forClass.getAnnotations(), (AnnotatedMember)localObject3));
          }
          if (this._propertyBasedCreator != null)
          {
            localObject2 = this._propertyBasedCreator.getCreatorProperties().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (SettableBeanProperty)((Iterator)localObject2).next();
              if (!((SettableBeanProperty)localObject3).hasValueDeserializer()) {
                this._propertyBasedCreator.assignDeserializer((SettableBeanProperty)localObject3, findDeserializer(paramDeserializationConfig, paramDeserializerProvider, ((SettableBeanProperty)localObject3).getType(), (BeanProperty)localObject3));
              }
            }
          }
          if (localBuilder != null)
          {
            this._externalTypeIdHandler = localBuilder.build();
            this._nonStandardCreation = true;
          }
          this._unwrappedPropertyHandler = ((UnwrappedPropertyHandler)localObject1);
          if (localObject1 != null) {
            this._nonStandardCreation = true;
          }
          return;
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
    }
  }
  
  public JsonDeserializer unwrappingDeserializer()
  {
    if (getClass() != BeanDeserializer.class) {
      return this;
    }
    return new BeanDeserializer(this, true);
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, int paramInt)
  {
    wrapAndThrow(paramThrowable, paramObject, paramInt, null);
  }
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, int paramInt, DeserializationContext paramDeserializationContext)
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonMappingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramInt);
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString)
  {
    wrapAndThrow(paramThrowable, paramObject, paramString, null);
  }
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString, DeserializationContext paramDeserializationContext)
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonMappingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramString);
  }
  
  protected void wrapInstantiationProblem(Throwable paramThrowable, DeserializationContext paramDeserializationContext)
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0) {
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    throw paramDeserializationContext.instantiationException(this._beanType.getRawClass(), paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/BeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */