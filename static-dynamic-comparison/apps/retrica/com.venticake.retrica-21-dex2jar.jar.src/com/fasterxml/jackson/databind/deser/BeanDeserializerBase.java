package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BeanDeserializerBase
  extends StdDeserializer<Object>
  implements ContextualDeserializer, ResolvableDeserializer, Serializable
{
  protected SettableAnyProperty _anySetter;
  protected final Map<String, SettableBeanProperty> _backRefs;
  protected final BeanPropertyMap _beanProperties;
  protected final JavaType _beanType;
  private final transient Annotations _classAnnotations;
  protected JsonDeserializer<Object> _delegateDeserializer;
  protected ExternalTypeHandler _externalTypeIdHandler;
  protected final HashSet<String> _ignorableProps;
  protected final boolean _ignoreAllUnknown;
  protected final ValueInjector[] _injectables;
  protected final boolean _needViewProcesing;
  protected boolean _nonStandardCreation;
  protected final ObjectIdReader _objectIdReader;
  protected PropertyBasedCreator _propertyBasedCreator;
  protected final JsonFormat.Shape _serializationShape;
  protected transient HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;
  protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
  protected final ValueInstantiator _valueInstantiator;
  protected boolean _vanillaProcessing;
  
  protected BeanDeserializerBase(BeanDeserializerBase paramBeanDeserializerBase)
  {
    this(paramBeanDeserializerBase, paramBeanDeserializerBase._ignoreAllUnknown);
  }
  
  public BeanDeserializerBase(BeanDeserializerBase paramBeanDeserializerBase, ObjectIdReader paramObjectIdReader)
  {
    super(paramBeanDeserializerBase._beanType);
    this._classAnnotations = paramBeanDeserializerBase._classAnnotations;
    this._beanType = paramBeanDeserializerBase._beanType;
    this._valueInstantiator = paramBeanDeserializerBase._valueInstantiator;
    this._delegateDeserializer = paramBeanDeserializerBase._delegateDeserializer;
    this._propertyBasedCreator = paramBeanDeserializerBase._propertyBasedCreator;
    this._backRefs = paramBeanDeserializerBase._backRefs;
    this._ignorableProps = paramBeanDeserializerBase._ignorableProps;
    this._ignoreAllUnknown = paramBeanDeserializerBase._ignoreAllUnknown;
    this._anySetter = paramBeanDeserializerBase._anySetter;
    this._injectables = paramBeanDeserializerBase._injectables;
    this._nonStandardCreation = paramBeanDeserializerBase._nonStandardCreation;
    this._unwrappedPropertyHandler = paramBeanDeserializerBase._unwrappedPropertyHandler;
    this._needViewProcesing = paramBeanDeserializerBase._needViewProcesing;
    this._serializationShape = paramBeanDeserializerBase._serializationShape;
    this._vanillaProcessing = paramBeanDeserializerBase._vanillaProcessing;
    this._objectIdReader = paramObjectIdReader;
    if (paramObjectIdReader == null)
    {
      this._beanProperties = paramBeanDeserializerBase._beanProperties;
      return;
    }
    this._beanProperties = paramBeanDeserializerBase._beanProperties.withProperty(new ObjectIdValueProperty(paramObjectIdReader));
  }
  
  protected BeanDeserializerBase(BeanDeserializerBase paramBeanDeserializerBase, NameTransformer paramNameTransformer)
  {
    super(paramBeanDeserializerBase._beanType);
    this._classAnnotations = paramBeanDeserializerBase._classAnnotations;
    this._beanType = paramBeanDeserializerBase._beanType;
    this._valueInstantiator = paramBeanDeserializerBase._valueInstantiator;
    this._delegateDeserializer = paramBeanDeserializerBase._delegateDeserializer;
    this._propertyBasedCreator = paramBeanDeserializerBase._propertyBasedCreator;
    this._backRefs = paramBeanDeserializerBase._backRefs;
    this._ignorableProps = paramBeanDeserializerBase._ignorableProps;
    boolean bool;
    if ((paramNameTransformer != null) || (paramBeanDeserializerBase._ignoreAllUnknown))
    {
      bool = true;
      this._ignoreAllUnknown = bool;
      this._anySetter = paramBeanDeserializerBase._anySetter;
      this._injectables = paramBeanDeserializerBase._injectables;
      this._objectIdReader = paramBeanDeserializerBase._objectIdReader;
      this._nonStandardCreation = paramBeanDeserializerBase._nonStandardCreation;
      this._unwrappedPropertyHandler = paramBeanDeserializerBase._unwrappedPropertyHandler;
      if (paramNameTransformer == null) {
        break label180;
      }
      if (this._unwrappedPropertyHandler != null) {
        this._unwrappedPropertyHandler.renameAll(paramNameTransformer);
      }
    }
    label180:
    for (this._beanProperties = paramBeanDeserializerBase._beanProperties.renameAll(paramNameTransformer);; this._beanProperties = paramBeanDeserializerBase._beanProperties)
    {
      this._needViewProcesing = paramBeanDeserializerBase._needViewProcesing;
      this._serializationShape = paramBeanDeserializerBase._serializationShape;
      this._vanillaProcessing = false;
      return;
      bool = false;
      break;
    }
  }
  
  public BeanDeserializerBase(BeanDeserializerBase paramBeanDeserializerBase, HashSet<String> paramHashSet)
  {
    super(paramBeanDeserializerBase._beanType);
    this._classAnnotations = paramBeanDeserializerBase._classAnnotations;
    this._beanType = paramBeanDeserializerBase._beanType;
    this._valueInstantiator = paramBeanDeserializerBase._valueInstantiator;
    this._delegateDeserializer = paramBeanDeserializerBase._delegateDeserializer;
    this._propertyBasedCreator = paramBeanDeserializerBase._propertyBasedCreator;
    this._backRefs = paramBeanDeserializerBase._backRefs;
    this._ignorableProps = paramHashSet;
    this._ignoreAllUnknown = paramBeanDeserializerBase._ignoreAllUnknown;
    this._anySetter = paramBeanDeserializerBase._anySetter;
    this._injectables = paramBeanDeserializerBase._injectables;
    this._nonStandardCreation = paramBeanDeserializerBase._nonStandardCreation;
    this._unwrappedPropertyHandler = paramBeanDeserializerBase._unwrappedPropertyHandler;
    this._needViewProcesing = paramBeanDeserializerBase._needViewProcesing;
    this._serializationShape = paramBeanDeserializerBase._serializationShape;
    this._vanillaProcessing = paramBeanDeserializerBase._vanillaProcessing;
    this._objectIdReader = paramBeanDeserializerBase._objectIdReader;
    this._beanProperties = paramBeanDeserializerBase._beanProperties;
  }
  
  protected BeanDeserializerBase(BeanDeserializerBase paramBeanDeserializerBase, boolean paramBoolean)
  {
    super(paramBeanDeserializerBase._beanType);
    this._classAnnotations = paramBeanDeserializerBase._classAnnotations;
    this._beanType = paramBeanDeserializerBase._beanType;
    this._valueInstantiator = paramBeanDeserializerBase._valueInstantiator;
    this._delegateDeserializer = paramBeanDeserializerBase._delegateDeserializer;
    this._propertyBasedCreator = paramBeanDeserializerBase._propertyBasedCreator;
    this._beanProperties = paramBeanDeserializerBase._beanProperties;
    this._backRefs = paramBeanDeserializerBase._backRefs;
    this._ignorableProps = paramBeanDeserializerBase._ignorableProps;
    this._ignoreAllUnknown = paramBoolean;
    this._anySetter = paramBeanDeserializerBase._anySetter;
    this._injectables = paramBeanDeserializerBase._injectables;
    this._objectIdReader = paramBeanDeserializerBase._objectIdReader;
    this._nonStandardCreation = paramBeanDeserializerBase._nonStandardCreation;
    this._unwrappedPropertyHandler = paramBeanDeserializerBase._unwrappedPropertyHandler;
    this._needViewProcesing = paramBeanDeserializerBase._needViewProcesing;
    this._serializationShape = paramBeanDeserializerBase._serializationShape;
    this._vanillaProcessing = paramBeanDeserializerBase._vanillaProcessing;
  }
  
  protected BeanDeserializerBase(BeanDeserializerBuilder paramBeanDeserializerBuilder, BeanDescription paramBeanDescription, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBeanDescription.getType());
    this._classAnnotations = paramBeanDescription.getClassInfo().getAnnotations();
    this._beanType = paramBeanDescription.getType();
    this._valueInstantiator = paramBeanDeserializerBuilder.getValueInstantiator();
    this._beanProperties = paramBeanPropertyMap;
    this._backRefs = paramMap;
    this._ignorableProps = paramHashSet;
    this._ignoreAllUnknown = paramBoolean1;
    this._anySetter = paramBeanDeserializerBuilder.getAnySetter();
    paramBeanPropertyMap = paramBeanDeserializerBuilder.getInjectables();
    if ((paramBeanPropertyMap == null) || (paramBeanPropertyMap.isEmpty()))
    {
      paramBeanPropertyMap = null;
      this._injectables = paramBeanPropertyMap;
      this._objectIdReader = paramBeanDeserializerBuilder.getObjectIdReader();
      if ((this._unwrappedPropertyHandler == null) && (!this._valueInstantiator.canCreateUsingDelegate()) && (!this._valueInstantiator.canCreateFromObjectWith()) && (this._valueInstantiator.canCreateUsingDefault())) {
        break label236;
      }
      paramBoolean1 = true;
      label145:
      this._nonStandardCreation = paramBoolean1;
      paramBeanDeserializerBuilder = paramBeanDescription.findExpectedFormat(null);
      if (paramBeanDeserializerBuilder != null) {
        break label242;
      }
      paramBeanDeserializerBuilder = (BeanDeserializerBuilder)localObject;
      label164:
      this._serializationShape = paramBeanDeserializerBuilder;
      this._needViewProcesing = paramBoolean2;
      if ((this._nonStandardCreation) || (this._injectables != null) || (this._needViewProcesing) || (this._objectIdReader == null)) {
        break label250;
      }
    }
    label236:
    label242:
    label250:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      this._vanillaProcessing = paramBoolean1;
      return;
      paramBeanPropertyMap = (ValueInjector[])paramBeanPropertyMap.toArray(new ValueInjector[paramBeanPropertyMap.size()]);
      break;
      paramBoolean1 = false;
      break label145;
      paramBeanDeserializerBuilder = paramBeanDeserializerBuilder.getShape();
      break label164;
    }
  }
  
  protected JsonDeserializer<Object> _findSubclassDeserializer(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
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
      paramDeserializationContext = paramDeserializationContext.findRootValueDeserializer(paramDeserializationContext.constructType(paramObject.getClass()));
    }
    finally {}
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
    return paramDeserializationContext;
  }
  
  protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext paramDeserializationContext, SettableBeanProperty paramSettableBeanProperty)
  {
    Object localObject2 = paramSettableBeanProperty.getValueDeserializer();
    Object localObject1 = paramSettableBeanProperty;
    Object localObject3;
    int j;
    int i;
    if ((localObject2 instanceof BeanDeserializerBase))
    {
      localObject1 = paramSettableBeanProperty;
      if (!((BeanDeserializerBase)localObject2).getValueInstantiator().canCreateUsingDefault())
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
          if (paramDeserializationContext.getConfig().canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess((Member)localObject1);
          }
          localObject1 = new InnerClassProperty(paramSettableBeanProperty, (Constructor)localObject1);
        }
      }
      else
      {
        return (SettableBeanProperty)localObject1;
      }
      i += 1;
    }
  }
  
  protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext paramDeserializationContext, SettableBeanProperty paramSettableBeanProperty)
  {
    String str = paramSettableBeanProperty.getManagedReferenceName();
    if (str == null) {
      return paramSettableBeanProperty;
    }
    paramDeserializationContext = paramSettableBeanProperty.getValueDeserializer();
    boolean bool = false;
    if ((paramDeserializationContext instanceof BeanDeserializerBase)) {
      paramDeserializationContext = ((BeanDeserializerBase)paramDeserializationContext).findBackReference(str);
    }
    while (paramDeserializationContext == null)
    {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': no back reference property found from type " + paramSettableBeanProperty.getType());
      if ((paramDeserializationContext instanceof ContainerDeserializerBase))
      {
        paramDeserializationContext = ((ContainerDeserializerBase)paramDeserializationContext).getContentDeserializer();
        if (!(paramDeserializationContext instanceof BeanDeserializerBase))
        {
          if (paramDeserializationContext == null) {}
          for (paramDeserializationContext = "NULL";; paramDeserializationContext = paramDeserializationContext.getClass().getName()) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + paramDeserializationContext + ")");
          }
        }
        paramDeserializationContext = ((BeanDeserializerBase)paramDeserializationContext).findBackReference(str);
        bool = true;
      }
      else if ((paramDeserializationContext instanceof AbstractDeserializer))
      {
        paramDeserializationContext = ((AbstractDeserializer)paramDeserializationContext).findBackReference(str);
      }
      else
      {
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + paramDeserializationContext.getClass().getName());
      }
    }
    JavaType localJavaType1 = this._beanType;
    JavaType localJavaType2 = paramDeserializationContext.getType();
    if (!localJavaType2.getRawClass().isAssignableFrom(localJavaType1.getRawClass())) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': back reference type (" + localJavaType2.getRawClass().getName() + ") not compatible with managed type (" + localJavaType1.getRawClass().getName() + ")");
    }
    return new ManagedReferenceProperty(paramSettableBeanProperty, str, paramDeserializationContext, this._classAnnotations, bool);
  }
  
  protected SettableBeanProperty _resolveUnwrappedProperty(DeserializationContext paramDeserializationContext, SettableBeanProperty paramSettableBeanProperty)
  {
    Object localObject = paramSettableBeanProperty.getMember();
    if (localObject != null)
    {
      localObject = paramDeserializationContext.getAnnotationIntrospector().findUnwrappingNameTransformer((AnnotatedMember)localObject);
      if (localObject != null)
      {
        paramDeserializationContext = paramSettableBeanProperty.getValueDeserializer();
        localObject = paramDeserializationContext.unwrappingDeserializer((NameTransformer)localObject);
        if ((localObject != paramDeserializationContext) && (localObject != null)) {
          return paramSettableBeanProperty.withValueDeserializer((JsonDeserializer)localObject);
        }
      }
    }
    return null;
  }
  
  protected abstract BeanDeserializerBase asArrayDeserializer();
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
  {
    Object localObject2 = this._objectIdReader;
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationContext.getAnnotationIntrospector();
    Object localObject1;
    if ((paramBeanProperty == null) || (localAnnotationIntrospector == null)) {
      localObject1 = null;
    }
    Object localObject3;
    ObjectIdInfo localObjectIdInfo;
    SettableBeanProperty localSettableBeanProperty;
    for (;;)
    {
      if ((paramBeanProperty != null) && (localAnnotationIntrospector != null))
      {
        paramBeanProperty = localAnnotationIntrospector.findPropertiesToIgnore((Annotated)localObject1);
        localObject3 = localAnnotationIntrospector.findObjectIdInfo((Annotated)localObject1);
        if (localObject3 != null)
        {
          localObjectIdInfo = localAnnotationIntrospector.findObjectReferenceInfo((Annotated)localObject1, (ObjectIdInfo)localObject3);
          localObject2 = localObjectIdInfo.getGeneratorType();
          if (localObject2 == ObjectIdGenerators.PropertyGenerator.class)
          {
            localObject2 = localObjectIdInfo.getPropertyName();
            localSettableBeanProperty = findProperty((String)localObject2);
            if (localSettableBeanProperty == null)
            {
              throw new IllegalArgumentException("Invalid Object Id definition for " + getBeanClass().getName() + ": can not find property with name '" + (String)localObject2 + "'");
              localObject1 = paramBeanProperty.getMember();
              continue;
            }
            localObject3 = localSettableBeanProperty.getType();
            localObject2 = new PropertyBasedObjectIdGenerator(localObjectIdInfo.getScope());
            paramDeserializationContext = paramDeserializationContext.findRootValueDeserializer((JavaType)localObject3);
            localObject2 = ObjectIdReader.construct((JavaType)localObject3, localObjectIdInfo.getPropertyName(), (ObjectIdGenerator)localObject2, paramDeserializationContext, localSettableBeanProperty);
            paramDeserializationContext = paramBeanProperty;
            paramBeanProperty = (BeanProperty)localObject2;
          }
        }
      }
    }
    for (;;)
    {
      if ((paramBeanProperty != null) && (paramBeanProperty != this._objectIdReader)) {}
      for (paramBeanProperty = withObjectIdReader(paramBeanProperty);; paramBeanProperty = this)
      {
        localObject2 = paramBeanProperty;
        if (paramDeserializationContext != null)
        {
          localObject2 = paramBeanProperty;
          if (paramDeserializationContext.length != 0) {
            localObject2 = paramBeanProperty.withIgnorableProperties(ArrayBuilders.setAndArray(paramBeanProperty._ignorableProps, paramDeserializationContext));
          }
        }
        if (localObject1 != null)
        {
          paramDeserializationContext = localAnnotationIntrospector.findFormat((Annotated)localObject1);
          if (paramDeserializationContext == null) {}
        }
        for (paramDeserializationContext = paramDeserializationContext.getShape();; paramDeserializationContext = null)
        {
          paramBeanProperty = paramDeserializationContext;
          if (paramDeserializationContext == null) {
            paramBeanProperty = this._serializationShape;
          }
          if (paramBeanProperty == JsonFormat.Shape.ARRAY)
          {
            return ((BeanDeserializerBase)localObject2).asArrayDeserializer();
            localObject2 = paramDeserializationContext.constructType((Class)localObject2);
            localObject3 = paramDeserializationContext.getTypeFactory().findTypeParameters(localObject2, ObjectIdGenerator.class)[0];
            localObject2 = paramDeserializationContext.objectIdGeneratorInstance((Annotated)localObject1, localObjectIdInfo);
            localSettableBeanProperty = null;
            break;
          }
          return (JsonDeserializer<?>)localObject2;
        }
      }
      paramDeserializationContext = paramBeanProperty;
      paramBeanProperty = (BeanProperty)localObject2;
      continue;
      paramBeanProperty = (BeanProperty)localObject2;
      paramDeserializationContext = null;
    }
  }
  
  protected Object deserializeFromObjectId(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = this._objectIdReader.deserializer.deserialize(paramJsonParser, paramDeserializationContext);
    paramDeserializationContext = paramDeserializationContext.findObjectId(paramJsonParser, this._objectIdReader.generator).item;
    if (paramDeserializationContext == null) {
      throw new IllegalStateException("Could not resolve Object Id [" + paramJsonParser + "] -- unresolved forward-reference?");
    }
    return paramDeserializationContext;
  }
  
  public final Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    if (this._objectIdReader != null)
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if ((localJsonToken != null) && (localJsonToken.isScalarValue())) {
        return deserializeFromObjectId(paramJsonParser, paramDeserializationContext);
      }
    }
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public SettableBeanProperty findBackReference(String paramString)
  {
    if (this._backRefs == null) {
      return null;
    }
    return (SettableBeanProperty)this._backRefs.get(paramString);
  }
  
  public SettableBeanProperty findProperty(String paramString)
  {
    if (this._beanProperties == null) {}
    for (SettableBeanProperty localSettableBeanProperty1 = null;; localSettableBeanProperty1 = this._beanProperties.find(paramString))
    {
      SettableBeanProperty localSettableBeanProperty2 = localSettableBeanProperty1;
      if (localSettableBeanProperty1 == null)
      {
        localSettableBeanProperty2 = localSettableBeanProperty1;
        if (this._propertyBasedCreator != null) {
          localSettableBeanProperty2 = this._propertyBasedCreator.findCreatorProperty(paramString);
        }
      }
      return localSettableBeanProperty2;
    }
  }
  
  public final Class<?> getBeanClass()
  {
    return this._beanType.getRawClass();
  }
  
  public Collection<Object> getKnownPropertyNames()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._beanProperties.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((SettableBeanProperty)localIterator.next()).getName());
    }
    return localArrayList;
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return this._valueInstantiator;
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
  
  public boolean isCachable()
  {
    return true;
  }
  
  public void resolve(DeserializationContext paramDeserializationContext)
  {
    Object localObject4;
    if (this._valueInstantiator.canCreateFromObjectWith())
    {
      localObject1 = this._valueInstantiator.getFromObjectArguments(paramDeserializationContext.getConfig());
      this._propertyBasedCreator = PropertyBasedCreator.construct(paramDeserializationContext, this._valueInstantiator, (SettableBeanProperty[])localObject1);
      localObject3 = this._propertyBasedCreator.properties().iterator();
      localObject1 = null;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (SettableBeanProperty)((Iterator)localObject3).next();
        if (((SettableBeanProperty)localObject4).hasValueTypeDeserializer())
        {
          localObject5 = ((SettableBeanProperty)localObject4).getValueTypeDeserializer();
          if (((TypeDeserializer)localObject5).getTypeInclusion() == JsonTypeInfo.As.EXTERNAL_PROPERTY)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ExternalTypeHandler.Builder();
            }
            ((ExternalTypeHandler.Builder)localObject2).addExternal((SettableBeanProperty)localObject4, (TypeDeserializer)localObject5);
            localObject1 = localObject2;
          }
        }
      }
    }
    Object localObject2 = null;
    Object localObject5 = this._beanProperties.iterator();
    Object localObject3 = null;
    Object localObject1 = localObject2;
    localObject2 = localObject3;
    if (((Iterator)localObject5).hasNext())
    {
      localObject4 = (SettableBeanProperty)((Iterator)localObject5).next();
      if (!((SettableBeanProperty)localObject4).hasValueDeserializer()) {
        localObject3 = ((SettableBeanProperty)localObject4).withValueDeserializer(findDeserializer(paramDeserializationContext, ((SettableBeanProperty)localObject4).getType(), (BeanProperty)localObject4));
      }
    }
    for (;;)
    {
      label204:
      Object localObject6 = _resolveManagedReferenceProperty(paramDeserializationContext, (SettableBeanProperty)localObject3);
      localObject3 = _resolveUnwrappedProperty(paramDeserializationContext, (SettableBeanProperty)localObject6);
      if (localObject3 != null)
      {
        if (localObject2 != null) {
          break label613;
        }
        localObject2 = new UnwrappedPropertyHandler();
      }
      label613:
      for (;;)
      {
        ((UnwrappedPropertyHandler)localObject2).addProperty((SettableBeanProperty)localObject3);
        break;
        localObject3 = ((SettableBeanProperty)localObject4).getValueDeserializer();
        if (!(localObject3 instanceof ContextualDeserializer)) {
          break label616;
        }
        localObject6 = ((ContextualDeserializer)localObject3).createContextual(paramDeserializationContext, (BeanProperty)localObject4);
        if (localObject6 == localObject3) {
          break label616;
        }
        localObject3 = ((SettableBeanProperty)localObject4).withValueDeserializer((JsonDeserializer)localObject6);
        break label204;
        localObject3 = _resolveInnerClassValuedProperty(paramDeserializationContext, (SettableBeanProperty)localObject6);
        if (localObject3 != localObject4) {
          this._beanProperties.replace((SettableBeanProperty)localObject3);
        }
        if (!((SettableBeanProperty)localObject3).hasValueTypeDeserializer()) {
          break;
        }
        localObject4 = ((SettableBeanProperty)localObject3).getValueTypeDeserializer();
        if (((TypeDeserializer)localObject4).getTypeInclusion() != JsonTypeInfo.As.EXTERNAL_PROPERTY) {
          break;
        }
        if (localObject1 == null) {
          localObject1 = new ExternalTypeHandler.Builder();
        }
        for (;;)
        {
          ((ExternalTypeHandler.Builder)localObject1).addExternal((SettableBeanProperty)localObject3, (TypeDeserializer)localObject4);
          this._beanProperties.remove((SettableBeanProperty)localObject3);
          break;
          if ((this._anySetter != null) && (!this._anySetter.hasValueDeserializer())) {
            this._anySetter = this._anySetter.withValueDeserializer(findDeserializer(paramDeserializationContext, this._anySetter.getType(), this._anySetter.getProperty()));
          }
          if (this._valueInstantiator.canCreateUsingDelegate())
          {
            localObject3 = this._valueInstantiator.getDelegateType(paramDeserializationContext.getConfig());
            if (localObject3 == null) {
              throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._beanType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            localObject4 = this._valueInstantiator.getDelegateCreator();
            this._delegateDeserializer = findDeserializer(paramDeserializationContext, (JavaType)localObject3, new BeanProperty.Std(null, (JavaType)localObject3, this._classAnnotations, (AnnotatedMember)localObject4));
          }
          if (localObject1 != null)
          {
            this._externalTypeIdHandler = ((ExternalTypeHandler.Builder)localObject1).build();
            this._nonStandardCreation = true;
          }
          this._unwrappedPropertyHandler = ((UnwrappedPropertyHandler)localObject2);
          if (localObject2 != null) {
            this._nonStandardCreation = true;
          }
          if ((this._vanillaProcessing) && (!this._nonStandardCreation)) {}
          for (boolean bool = true;; bool = false)
          {
            this._vanillaProcessing = bool;
            return;
          }
        }
      }
      label616:
      localObject3 = localObject4;
    }
  }
  
  public abstract JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer);
  
  public abstract BeanDeserializerBase withIgnorableProperties(HashSet<String> paramHashSet);
  
  public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader paramObjectIdReader);
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString, DeserializationContext paramDeserializationContext)
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS))) {}
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
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0) {
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    throw paramDeserializationContext.instantiationException(this._beanType.getRawClass(), paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/BeanDeserializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */