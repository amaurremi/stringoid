package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public abstract class AsArraySerializerBase
  extends ContainerSerializerBase
  implements ResolvableSerializer
{
  protected PropertySerializerMap _dynamicSerializers;
  protected JsonSerializer _elementSerializer;
  protected final JavaType _elementType;
  protected final BeanProperty _property;
  protected final boolean _staticTyping;
  protected final TypeSerializer _valueTypeSerializer;
  
  @Deprecated
  protected AsArraySerializerBase(Class paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    this(paramClass, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null);
  }
  
  protected AsArraySerializerBase(Class paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer paramJsonSerializer)
  {
    super(paramClass, false);
    this._elementType = paramJavaType;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (paramJavaType != null)
      {
        paramBoolean = bool;
        if (!paramJavaType.isFinal()) {}
      }
    }
    else
    {
      paramBoolean = true;
    }
    this._staticTyping = paramBoolean;
    this._valueTypeSerializer = paramTypeSerializer;
    this._property = paramBeanProperty;
    this._elementSerializer = paramJsonSerializer;
    this._dynamicSerializers = PropertySerializerMap.emptyMap();
  }
  
  protected final JsonSerializer _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class paramClass, SerializerProvider paramSerializerProvider)
  {
    paramClass = paramPropertySerializerMap.findAndAddSerializer(paramClass, paramSerializerProvider, this._property);
    if (paramPropertySerializerMap != paramClass.map) {
      this._dynamicSerializers = paramClass.map;
    }
    return paramClass.serializer;
  }
  
  protected final JsonSerializer _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, JavaType paramJavaType, SerializerProvider paramSerializerProvider)
  {
    paramJavaType = paramPropertySerializerMap.findAndAddSerializer(paramJavaType, paramSerializerProvider, this._property);
    if (paramPropertySerializerMap != paramJavaType.map) {
      this._dynamicSerializers = paramJavaType.map;
    }
    return paramJavaType.serializer;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    ObjectNode localObjectNode = createSchemaNode("array", true);
    if (paramType != null)
    {
      JavaType localJavaType2 = paramSerializerProvider.constructType(paramType).getContentType();
      localJavaType1 = localJavaType2;
      if (localJavaType2 == null)
      {
        localJavaType1 = localJavaType2;
        if ((paramType instanceof ParameterizedType))
        {
          paramType = ((ParameterizedType)paramType).getActualTypeArguments();
          localJavaType1 = localJavaType2;
          if (paramType.length != 1) {}
        }
      }
    }
    for (JavaType localJavaType1 = paramSerializerProvider.constructType(paramType[0]);; localJavaType1 = null)
    {
      paramType = localJavaType1;
      if (localJavaType1 == null)
      {
        paramType = localJavaType1;
        if (this._elementType != null) {
          paramType = this._elementType;
        }
      }
      if (paramType != null)
      {
        if (paramType.getRawClass() == Object.class) {
          break label152;
        }
        paramType = paramSerializerProvider.findValueSerializer(paramType, this._property);
        if (!(paramType instanceof SchemaAware)) {
          break label152;
        }
      }
      label152:
      for (paramSerializerProvider = ((SchemaAware)paramType).getSchema(paramSerializerProvider, null);; paramSerializerProvider = null)
      {
        paramType = paramSerializerProvider;
        if (paramSerializerProvider == null) {
          paramType = JsonSchema.getDefaultSchemaNode();
        }
        localObjectNode.put("items", paramType);
        return localObjectNode;
      }
    }
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    if ((this._staticTyping) && (this._elementType != null) && (this._elementSerializer == null)) {
      this._elementSerializer = paramSerializerProvider.findValueSerializer(this._elementType, this._property);
    }
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeStartArray();
    serializeContents(paramObject, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  protected abstract void serializeContents(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider);
  
  public final void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForArray(paramObject, paramJsonGenerator);
    serializeContents(paramObject, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForArray(paramObject, paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/AsArraySerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */