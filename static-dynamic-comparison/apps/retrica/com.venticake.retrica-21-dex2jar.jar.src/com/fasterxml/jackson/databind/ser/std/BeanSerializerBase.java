package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class BeanSerializerBase
  extends StdSerializer<Object>
  implements ContextualSerializer, ResolvableSerializer
{
  protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
  protected final AnyGetterWriter _anyGetterWriter;
  protected final BeanPropertyWriter[] _filteredProps;
  protected final ObjectIdWriter _objectIdWriter;
  protected final Object _propertyFilterId;
  protected final BeanPropertyWriter[] _props;
  protected final JsonFormat.Shape _serializationShape;
  protected final AnnotatedMember _typeId;
  
  protected BeanSerializerBase(JavaType paramJavaType, BeanSerializerBuilder paramBeanSerializerBuilder, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2)
  {
    super(paramJavaType);
    this._props = paramArrayOfBeanPropertyWriter1;
    this._filteredProps = paramArrayOfBeanPropertyWriter2;
    if (paramBeanSerializerBuilder == null)
    {
      this._typeId = null;
      this._anyGetterWriter = null;
      this._propertyFilterId = null;
      this._objectIdWriter = null;
      this._serializationShape = null;
      return;
    }
    this._typeId = paramBeanSerializerBuilder.getTypeId();
    this._anyGetterWriter = paramBeanSerializerBuilder.getAnyGetter();
    this._propertyFilterId = paramBeanSerializerBuilder.getFilterId();
    this._objectIdWriter = paramBeanSerializerBuilder.getObjectIdWriter();
    paramJavaType = paramBeanSerializerBuilder.getBeanDescription().findExpectedFormat(null);
    if (paramJavaType == null) {}
    for (paramJavaType = (JavaType)localObject;; paramJavaType = paramJavaType.getShape())
    {
      this._serializationShape = paramJavaType;
      return;
    }
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter)
  {
    super(paramBeanSerializerBase._handledType);
    this._props = paramBeanSerializerBase._props;
    this._filteredProps = paramBeanSerializerBase._filteredProps;
    this._typeId = paramBeanSerializerBase._typeId;
    this._anyGetterWriter = paramBeanSerializerBase._anyGetterWriter;
    this._objectIdWriter = paramObjectIdWriter;
    this._propertyFilterId = paramBeanSerializerBase._propertyFilterId;
    this._serializationShape = paramBeanSerializerBase._serializationShape;
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, NameTransformer paramNameTransformer)
  {
    this(paramBeanSerializerBase, rename(paramBeanSerializerBase._props, paramNameTransformer), rename(paramBeanSerializerBase._filteredProps, paramNameTransformer));
  }
  
  public BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2)
  {
    super(paramBeanSerializerBase._handledType);
    this._props = paramArrayOfBeanPropertyWriter1;
    this._filteredProps = paramArrayOfBeanPropertyWriter2;
    this._typeId = paramBeanSerializerBase._typeId;
    this._anyGetterWriter = paramBeanSerializerBase._anyGetterWriter;
    this._objectIdWriter = paramBeanSerializerBase._objectIdWriter;
    this._propertyFilterId = paramBeanSerializerBase._propertyFilterId;
    this._serializationShape = paramBeanSerializerBase._serializationShape;
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase, String[] paramArrayOfString)
  {
    super(paramBeanSerializerBase._handledType);
    HashSet localHashSet = ArrayBuilders.arrayToSet(paramArrayOfString);
    BeanPropertyWriter[] arrayOfBeanPropertyWriter1 = paramBeanSerializerBase._props;
    BeanPropertyWriter[] arrayOfBeanPropertyWriter2 = paramBeanSerializerBase._filteredProps;
    int j = arrayOfBeanPropertyWriter1.length;
    ArrayList localArrayList = new ArrayList(j);
    int i;
    label54:
    BeanPropertyWriter localBeanPropertyWriter;
    if (arrayOfBeanPropertyWriter2 == null)
    {
      paramArrayOfString = null;
      i = 0;
      if (i >= j) {
        break label124;
      }
      localBeanPropertyWriter = arrayOfBeanPropertyWriter1[i];
      if (!localHashSet.contains(localBeanPropertyWriter.getName())) {
        break label99;
      }
    }
    for (;;)
    {
      i += 1;
      break label54;
      paramArrayOfString = new ArrayList(j);
      break;
      label99:
      localArrayList.add(localBeanPropertyWriter);
      if (arrayOfBeanPropertyWriter2 != null) {
        paramArrayOfString.add(arrayOfBeanPropertyWriter2[i]);
      }
    }
    label124:
    this._props = ((BeanPropertyWriter[])localArrayList.toArray(new BeanPropertyWriter[localArrayList.size()]));
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = (String[])localObject;; paramArrayOfString = (BeanPropertyWriter[])paramArrayOfString.toArray(new BeanPropertyWriter[paramArrayOfString.size()]))
    {
      this._filteredProps = paramArrayOfString;
      this._typeId = paramBeanSerializerBase._typeId;
      this._anyGetterWriter = paramBeanSerializerBase._anyGetterWriter;
      this._objectIdWriter = paramBeanSerializerBase._objectIdWriter;
      this._propertyFilterId = paramBeanSerializerBase._propertyFilterId;
      this._serializationShape = paramBeanSerializerBase._serializationShape;
      return;
    }
  }
  
  private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] paramArrayOfBeanPropertyWriter, NameTransformer paramNameTransformer)
  {
    if ((paramArrayOfBeanPropertyWriter == null) || (paramArrayOfBeanPropertyWriter.length == 0) || (paramNameTransformer == null) || (paramNameTransformer == NameTransformer.NOP)) {
      return paramArrayOfBeanPropertyWriter;
    }
    int j = paramArrayOfBeanPropertyWriter.length;
    BeanPropertyWriter[] arrayOfBeanPropertyWriter = new BeanPropertyWriter[j];
    int i = 0;
    while (i < j)
    {
      BeanPropertyWriter localBeanPropertyWriter = paramArrayOfBeanPropertyWriter[i];
      if (localBeanPropertyWriter != null) {
        arrayOfBeanPropertyWriter[i] = localBeanPropertyWriter.rename(paramNameTransformer);
      }
      i += 1;
    }
    return arrayOfBeanPropertyWriter;
  }
  
  protected abstract BeanSerializerBase asArraySerializer();
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    Object localObject4 = null;
    Object localObject2 = this._objectIdWriter;
    AnnotationIntrospector localAnnotationIntrospector = paramSerializerProvider.getAnnotationIntrospector();
    Object localObject3;
    Object localObject1;
    Object localObject5;
    if ((paramBeanProperty == null) || (localAnnotationIntrospector == null))
    {
      localObject3 = null;
      if (localObject3 == null) {
        break label502;
      }
      localObject1 = localAnnotationIntrospector.findPropertiesToIgnore((Annotated)localObject3);
      localObject5 = localAnnotationIntrospector.findObjectIdInfo((Annotated)localObject3);
      if (localObject5 != null) {
        break label219;
      }
      if (localObject2 == null) {
        break label499;
      }
      localObject2 = localAnnotationIntrospector.findObjectReferenceInfo((Annotated)localObject3, new ObjectIdInfo("", null, null));
      localObject2 = this._objectIdWriter.withAlwaysAsId(((ObjectIdInfo)localObject2).getAlwaysAsId());
    }
    for (;;)
    {
      label94:
      if (localObject2 != null)
      {
        paramSerializerProvider = ((ObjectIdWriter)localObject2).withSerializer(paramSerializerProvider.findValueSerializer(((ObjectIdWriter)localObject2).idType, paramBeanProperty));
        if (paramSerializerProvider == this._objectIdWriter) {}
      }
      for (paramSerializerProvider = withObjectIdWriter(paramSerializerProvider);; paramSerializerProvider = this)
      {
        paramBeanProperty = paramSerializerProvider;
        if (localObject1 != null)
        {
          paramBeanProperty = paramSerializerProvider;
          if (localObject1.length != 0) {
            paramBeanProperty = paramSerializerProvider.withIgnorals((String[])localObject1);
          }
        }
        paramSerializerProvider = (SerializerProvider)localObject4;
        if (localObject3 != null)
        {
          localObject1 = localAnnotationIntrospector.findFormat((Annotated)localObject3);
          paramSerializerProvider = (SerializerProvider)localObject4;
          if (localObject1 != null) {
            paramSerializerProvider = ((JsonFormat.Value)localObject1).getShape();
          }
        }
        localObject1 = paramSerializerProvider;
        if (paramSerializerProvider == null) {
          localObject1 = this._serializationShape;
        }
        if (localObject1 == JsonFormat.Shape.ARRAY)
        {
          return paramBeanProperty.asArraySerializer();
          localObject3 = paramBeanProperty.getMember();
          break;
          label219:
          localObject2 = localAnnotationIntrospector.findObjectReferenceInfo((Annotated)localObject3, (ObjectIdInfo)localObject5);
          localObject5 = ((ObjectIdInfo)localObject2).getGeneratorType();
          Object localObject6 = paramSerializerProvider.constructType((Type)localObject5);
          localObject6 = paramSerializerProvider.getTypeFactory().findTypeParameters(localObject6, ObjectIdGenerator.class)[0];
          if (localObject5 == ObjectIdGenerators.PropertyGenerator.class)
          {
            localObject6 = ((ObjectIdInfo)localObject2).getPropertyName();
            int j = this._props.length;
            int i = 0;
            for (;;)
            {
              if (i == j) {
                throw new IllegalArgumentException("Invalid Object Id definition for " + this._handledType.getName() + ": can not find property with name '" + (String)localObject6 + "'");
              }
              localObject5 = this._props[i];
              if (((String)localObject6).equals(((BeanPropertyWriter)localObject5).getName()))
              {
                if (i > 0)
                {
                  System.arraycopy(this._props, 0, this._props, 1, i);
                  this._props[0] = localObject5;
                  if (this._filteredProps != null)
                  {
                    localObject6 = this._filteredProps[i];
                    System.arraycopy(this._filteredProps, 0, this._filteredProps, 1, i);
                    this._filteredProps[0] = localObject6;
                  }
                }
                localObject2 = ObjectIdWriter.construct(((BeanPropertyWriter)localObject5).getType(), null, new PropertyBasedObjectIdGenerator((ObjectIdInfo)localObject2, (BeanPropertyWriter)localObject5), ((ObjectIdInfo)localObject2).getAlwaysAsId());
                break;
              }
              i += 1;
            }
          }
          localObject5 = paramSerializerProvider.objectIdGeneratorInstance((Annotated)localObject3, (ObjectIdInfo)localObject2);
          localObject2 = ObjectIdWriter.construct((JavaType)localObject6, ((ObjectIdInfo)localObject2).getPropertyName(), (ObjectIdGenerator)localObject5, ((ObjectIdInfo)localObject2).getAlwaysAsId());
          break label94;
        }
        return paramBeanProperty;
      }
      label499:
      continue;
      label502:
      localObject1 = null;
    }
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    int i;
    int j;
    label18:
    BeanPropertyWriter localBeanPropertyWriter;
    Object localObject1;
    Object localObject2;
    if (this._filteredProps == null)
    {
      i = 0;
      int k = this._props.length;
      j = 0;
      if (j >= k) {
        break label285;
      }
      localBeanPropertyWriter = this._props[j];
      if ((!localBeanPropertyWriter.willSuppressNulls()) && (!localBeanPropertyWriter.hasNullSerializer()))
      {
        localObject1 = paramSerializerProvider.findNullValueSerializer(localBeanPropertyWriter);
        if (localObject1 != null)
        {
          localBeanPropertyWriter.assignNullSerializer((JsonSerializer)localObject1);
          if (j < i)
          {
            localObject2 = this._filteredProps[j];
            if (localObject2 != null) {
              ((BeanPropertyWriter)localObject2).assignNullSerializer((JsonSerializer)localObject1);
            }
          }
        }
      }
      if (!localBeanPropertyWriter.hasSerializer()) {
        break label117;
      }
    }
    for (;;)
    {
      j += 1;
      break label18;
      i = this._filteredProps.length;
      break;
      label117:
      localObject2 = localBeanPropertyWriter.getSerializationType();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = paramSerializerProvider.constructType(localBeanPropertyWriter.getGenericPropertyType());
        localObject1 = localObject2;
        if (!((JavaType)localObject2).isFinal())
        {
          if ((!((JavaType)localObject2).isContainerType()) && (((JavaType)localObject2).containedTypeCount() <= 0)) {
            continue;
          }
          localBeanPropertyWriter.setNonTrivialBaseType((JavaType)localObject2);
          continue;
        }
      }
      JsonSerializer localJsonSerializer = paramSerializerProvider.findValueSerializer((JavaType)localObject1, localBeanPropertyWriter);
      localObject2 = localJsonSerializer;
      if (((JavaType)localObject1).isContainerType())
      {
        localObject1 = (TypeSerializer)((JavaType)localObject1).getContentType().getTypeHandler();
        localObject2 = localJsonSerializer;
        if (localObject1 != null)
        {
          localObject2 = localJsonSerializer;
          if ((localJsonSerializer instanceof ContainerSerializer)) {
            localObject2 = ((ContainerSerializer)localJsonSerializer).withValueTypeSerializer((TypeSerializer)localObject1);
          }
        }
      }
      localBeanPropertyWriter.assignSerializer((JsonSerializer)localObject2);
      if (j < i)
      {
        localObject1 = this._filteredProps[j];
        if (localObject1 != null) {
          ((BeanPropertyWriter)localObject1).assignSerializer((JsonSerializer)localObject2);
        }
      }
    }
    label285:
    if (this._anyGetterWriter != null) {
      this._anyGetterWriter.resolve(paramSerializerProvider);
    }
  }
  
  protected abstract BeanSerializerBase withIgnorals(String[] paramArrayOfString);
  
  public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter paramObjectIdWriter);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/BeanSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */