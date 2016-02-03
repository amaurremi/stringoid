package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonMappingException.Reference;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.ser.AnyGetterWriter;
import org.codehaus.jackson.map.ser.BeanPropertyFilter;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public abstract class BeanSerializerBase
  extends SerializerBase
  implements ResolvableSerializer, SchemaAware
{
  protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
  protected final AnyGetterWriter _anyGetterWriter;
  protected final BeanPropertyWriter[] _filteredProps;
  protected final Object _propertyFilterId;
  protected final BeanPropertyWriter[] _props;
  
  public BeanSerializerBase(Class paramClass, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2, AnyGetterWriter paramAnyGetterWriter, Object paramObject)
  {
    super(paramClass);
    this._props = paramArrayOfBeanPropertyWriter1;
    this._filteredProps = paramArrayOfBeanPropertyWriter2;
    this._anyGetterWriter = paramAnyGetterWriter;
    this._propertyFilterId = paramObject;
  }
  
  protected BeanSerializerBase(BeanSerializerBase paramBeanSerializerBase)
  {
    this(paramBeanSerializerBase._handledType, paramBeanSerializerBase._props, paramBeanSerializerBase._filteredProps, paramBeanSerializerBase._anyGetterWriter, paramBeanSerializerBase._propertyFilterId);
  }
  
  protected BeanSerializerBase(JavaType paramJavaType, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2, AnyGetterWriter paramAnyGetterWriter, Object paramObject)
  {
    super(paramJavaType);
    this._props = paramArrayOfBeanPropertyWriter1;
    this._filteredProps = paramArrayOfBeanPropertyWriter2;
    this._anyGetterWriter = paramAnyGetterWriter;
    this._propertyFilterId = paramObject;
  }
  
  protected BeanPropertyFilter findFilter(SerializerProvider paramSerializerProvider)
  {
    Object localObject = this._propertyFilterId;
    paramSerializerProvider = paramSerializerProvider.getFilterProvider();
    if (paramSerializerProvider == null) {
      throw new JsonMappingException("Can not resolve BeanPropertyFilter with id '" + localObject + "'; no FilterProvider configured");
    }
    return paramSerializerProvider.findFilter(localObject);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    ObjectNode localObjectNode1 = createSchemaNode("object", true);
    ObjectNode localObjectNode2 = localObjectNode1.objectNode();
    int i = 0;
    if (i < this._props.length)
    {
      BeanPropertyWriter localBeanPropertyWriter = this._props[i];
      paramType = localBeanPropertyWriter.getSerializationType();
      label51:
      Object localObject1;
      if (paramType == null)
      {
        paramType = localBeanPropertyWriter.getGenericPropertyType();
        Object localObject2 = localBeanPropertyWriter.getSerializer();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = localBeanPropertyWriter.getRawSerializationType();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = localBeanPropertyWriter.getPropertyType();
          }
          localObject1 = paramSerializerProvider.findValueSerializer((Class)localObject1, localBeanPropertyWriter);
        }
        if (!(localObject1 instanceof SchemaAware)) {
          break label148;
        }
      }
      label148:
      for (paramType = ((SchemaAware)localObject1).getSchema(paramSerializerProvider, paramType);; paramType = JsonSchema.getDefaultSchemaNode())
      {
        localObjectNode2.put(localBeanPropertyWriter.getName(), paramType);
        i += 1;
        break;
        paramType = paramType.getRawClass();
        break label51;
      }
    }
    localObjectNode1.put("properties", localObjectNode2);
    return localObjectNode1;
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    int i;
    int j;
    label18:
    BeanPropertyWriter localBeanPropertyWriter;
    if (this._filteredProps == null)
    {
      i = 0;
      int k = this._props.length;
      j = 0;
      if (j >= k) {
        break label240;
      }
      localBeanPropertyWriter = this._props[j];
      if (!localBeanPropertyWriter.hasSerializer()) {
        break label56;
      }
    }
    for (;;)
    {
      j += 1;
      break label18;
      i = this._filteredProps.length;
      break;
      label56:
      Object localObject1 = localBeanPropertyWriter.getSerializationType();
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramSerializerProvider.constructType(localBeanPropertyWriter.getGenericPropertyType());
        localObject2 = localObject1;
        if (!((JavaType)localObject1).isFinal())
        {
          if ((!((JavaType)localObject1).isContainerType()) && (((JavaType)localObject1).containedTypeCount() <= 0)) {
            continue;
          }
          localBeanPropertyWriter.setNonTrivialBaseType((JavaType)localObject1);
          continue;
        }
      }
      JsonSerializer localJsonSerializer = paramSerializerProvider.findValueSerializer((JavaType)localObject2, localBeanPropertyWriter);
      localObject1 = localJsonSerializer;
      if (((JavaType)localObject2).isContainerType())
      {
        localObject2 = (TypeSerializer)((JavaType)localObject2).getContentType().getTypeHandler();
        localObject1 = localJsonSerializer;
        if (localObject2 != null)
        {
          localObject1 = localJsonSerializer;
          if ((localJsonSerializer instanceof ContainerSerializerBase)) {
            localObject1 = ((ContainerSerializerBase)localJsonSerializer).withValueTypeSerializer((TypeSerializer)localObject2);
          }
        }
      }
      localObject2 = localBeanPropertyWriter.withSerializer((JsonSerializer)localObject1);
      this._props[j] = localObject2;
      if (j < i)
      {
        localObject2 = this._filteredProps[j];
        if (localObject2 != null) {
          this._filteredProps[j] = ((BeanPropertyWriter)localObject2).withSerializer((JsonSerializer)localObject1);
        }
      }
    }
    label240:
    if (this._anyGetterWriter != null) {
      this._anyGetterWriter.resolve(paramSerializerProvider);
    }
  }
  
  public abstract void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider);
  
  protected void serializeFields(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    if ((this._filteredProps != null) && (paramSerializerProvider.getSerializationView() != null)) {
      arrayOfBeanPropertyWriter = this._filteredProps;
    }
    int k;
    for (;;)
    {
      int j = 0;
      k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        for (;;)
        {
          if (i < m)
          {
            BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
            if (localBeanPropertyWriter != null)
            {
              j = i;
              k = i;
              localBeanPropertyWriter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
            }
            i += 1;
            continue;
            arrayOfBeanPropertyWriter = this._props;
            break;
          }
        }
        j = i;
        k = i;
        if (this._anyGetterWriter != null)
        {
          j = i;
          k = i;
          this._anyGetterWriter.getAndSerialize(paramObject, paramJsonGenerator, paramSerializerProvider);
        }
        return;
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          return;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)");
        if (k != arrayOfBeanPropertyWriter.length) {}
      }
    }
    for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName())
    {
      paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
      throw paramSerializerProvider;
    }
  }
  
  protected void serializeFieldsFiltered(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    BeanPropertyFilter localBeanPropertyFilter;
    if ((this._filteredProps != null) && (paramSerializerProvider.getSerializationView() != null))
    {
      arrayOfBeanPropertyWriter = this._filteredProps;
      localBeanPropertyFilter = findFilter(paramSerializerProvider);
      if (localBeanPropertyFilter != null) {
        break label49;
      }
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      return;
      arrayOfBeanPropertyWriter = this._props;
      break;
      label49:
      int j = 0;
      int k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        if (i < m)
        {
          BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
          if (localBeanPropertyWriter != null)
          {
            j = i;
            k = i;
            localBeanPropertyFilter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider, localBeanPropertyWriter);
          }
        }
        else
        {
          j = i;
          k = i;
          if (this._anyGetterWriter == null) {
            continue;
          }
          j = i;
          k = i;
          this._anyGetterWriter.getAndSerialize(paramObject, paramJsonGenerator, paramSerializerProvider);
          return;
        }
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          return;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        for (;;)
        {
          paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)");
          if (k == arrayOfBeanPropertyWriter.length) {}
          for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName())
          {
            paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
            throw paramSerializerProvider;
          }
          i += 1;
        }
      }
    }
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForObject(paramObject, paramJsonGenerator);
    if (this._propertyFilterId != null) {
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      paramTypeSerializer.writeTypeSuffixForObject(paramObject, paramJsonGenerator);
      return;
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/BeanSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */