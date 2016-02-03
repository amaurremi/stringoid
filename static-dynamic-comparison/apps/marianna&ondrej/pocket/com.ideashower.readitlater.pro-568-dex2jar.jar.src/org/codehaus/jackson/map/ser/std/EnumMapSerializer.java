package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.EnumValues;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class EnumMapSerializer
  extends ContainerSerializerBase
  implements ResolvableSerializer
{
  protected final EnumValues _keyEnums;
  protected final BeanProperty _property;
  protected final boolean _staticTyping;
  protected JsonSerializer _valueSerializer;
  protected final JavaType _valueType;
  protected final TypeSerializer _valueTypeSerializer;
  
  @Deprecated
  public EnumMapSerializer(JavaType paramJavaType, boolean paramBoolean, EnumValues paramEnumValues, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    this(paramJavaType, paramBoolean, paramEnumValues, paramTypeSerializer, paramBeanProperty, null);
  }
  
  public EnumMapSerializer(JavaType paramJavaType, boolean paramBoolean, EnumValues paramEnumValues, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer paramJsonSerializer)
  {
    super(EnumMap.class, false);
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
    this._valueType = paramJavaType;
    this._keyEnums = paramEnumValues;
    this._valueTypeSerializer = paramTypeSerializer;
    this._property = paramBeanProperty;
    this._valueSerializer = paramJsonSerializer;
  }
  
  public ContainerSerializerBase _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new EnumMapSerializer(this._valueType, this._staticTyping, this._keyEnums, paramTypeSerializer, this._property, this._valueSerializer);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    ObjectNode localObjectNode1 = createSchemaNode("object", true);
    if ((paramType instanceof ParameterizedType))
    {
      Object localObject = ((ParameterizedType)paramType).getActualTypeArguments();
      if (localObject.length == 2)
      {
        paramType = paramSerializerProvider.constructType(localObject[0]);
        localObject = paramSerializerProvider.constructType(localObject[1]);
        ObjectNode localObjectNode2 = JsonNodeFactory.instance.objectNode();
        Enum[] arrayOfEnum = (Enum[])paramType.getRawClass().getEnumConstants();
        int j = arrayOfEnum.length;
        int i = 0;
        if (i < j)
        {
          Enum localEnum = arrayOfEnum[i];
          paramType = paramSerializerProvider.findValueSerializer(((JavaType)localObject).getRawClass(), this._property);
          if ((paramType instanceof SchemaAware)) {}
          for (paramType = ((SchemaAware)paramType).getSchema(paramSerializerProvider, null);; paramType = JsonSchema.getDefaultSchemaNode())
          {
            localObjectNode2.put(paramSerializerProvider.getConfig().getAnnotationIntrospector().findEnumValue(localEnum), paramType);
            i += 1;
            break;
          }
        }
        localObjectNode1.put("properties", localObjectNode2);
      }
    }
    return localObjectNode1;
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    if ((this._staticTyping) && (this._valueSerializer == null)) {
      this._valueSerializer = paramSerializerProvider.findValueSerializer(this._valueType, this._property);
    }
  }
  
  public void serialize(EnumMap paramEnumMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeStartObject();
    if (!paramEnumMap.isEmpty()) {
      serializeContents(paramEnumMap, paramJsonGenerator, paramSerializerProvider);
    }
    paramJsonGenerator.writeEndObject();
  }
  
  protected void serializeContents(EnumMap paramEnumMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    Object localObject2 = null;
    if (this._valueSerializer != null)
    {
      serializeContentsUsing(paramEnumMap, paramJsonGenerator, paramSerializerProvider, this._valueSerializer);
      return;
    }
    EnumValues localEnumValues = this._keyEnums;
    Iterator localIterator = paramEnumMap.entrySet().iterator();
    Object localObject1 = null;
    label42:
    Map.Entry localEntry;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localObject3 = (Enum)localEntry.getKey();
      if (localEnumValues != null) {
        break label273;
      }
      localEnumValues = ((EnumSerializer)paramSerializerProvider.findValueSerializer(((Enum)localObject3).getDeclaringClass(), this._property)).getEnumValues();
    }
    label273:
    for (;;)
    {
      paramJsonGenerator.writeFieldName(localEnumValues.serializedValueFor((Enum)localObject3));
      Object localObject6 = localEntry.getValue();
      if (localObject6 == null)
      {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label42;
        break;
        Object localObject5 = localObject6.getClass();
        if (localObject5 == localObject2)
        {
          localObject5 = localObject1;
          localObject3 = localObject1;
          localObject1 = localObject5;
        }
        for (;;)
        {
          try
          {
            ((JsonSerializer)localObject3).serialize(localObject6, paramJsonGenerator, paramSerializerProvider);
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
          catch (Exception localException)
          {
            wrapAndThrow(paramSerializerProvider, localException, paramEnumMap, ((Enum)localEntry.getKey()).name());
            Object localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
          }
          localObject3 = paramSerializerProvider.findValueSerializer((Class)localObject5, this._property);
          localObject1 = localObject3;
          localObject2 = localObject5;
        }
      }
    }
  }
  
  protected void serializeContentsUsing(EnumMap paramEnumMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer paramJsonSerializer)
  {
    Object localObject2 = this._keyEnums;
    Iterator localIterator = paramEnumMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Enum localEnum = (Enum)localEntry.getKey();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((EnumSerializer)paramSerializerProvider.findValueSerializer(localEnum.getDeclaringClass(), this._property)).getEnumValues();
      }
      paramJsonGenerator.writeFieldName(((EnumValues)localObject1).serializedValueFor(localEnum));
      localObject2 = localEntry.getValue();
      if (localObject2 == null)
      {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        localObject2 = localObject1;
      }
      else
      {
        try
        {
          paramJsonSerializer.serialize(localObject2, paramJsonGenerator, paramSerializerProvider);
          localObject2 = localObject1;
        }
        catch (Exception localException)
        {
          wrapAndThrow(paramSerializerProvider, localException, paramEnumMap, ((Enum)localEntry.getKey()).name());
          Object localObject3 = localObject1;
        }
      }
    }
  }
  
  public void serializeWithType(EnumMap paramEnumMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForObject(paramEnumMap, paramJsonGenerator);
    if (!paramEnumMap.isEmpty()) {
      serializeContents(paramEnumMap, paramJsonGenerator, paramSerializerProvider);
    }
    paramTypeSerializer.writeTypeSuffixForObject(paramEnumMap, paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/EnumMapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */