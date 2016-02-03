package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.ResolvableSerializer;
import com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.schema.JsonSchema;
import com.flurry.org.codehaus.jackson.schema.SchemaAware;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

@JacksonStdImpl
public class JsonValueSerializer
  extends SerializerBase<Object>
  implements ResolvableSerializer, SchemaAware
{
  protected final Method _accessorMethod;
  protected boolean _forceTypeInformation;
  protected final BeanProperty _property;
  protected JsonSerializer<Object> _valueSerializer;
  
  public JsonValueSerializer(Method paramMethod, JsonSerializer<Object> paramJsonSerializer, BeanProperty paramBeanProperty)
  {
    super(Object.class);
    this._accessorMethod = paramMethod;
    this._valueSerializer = paramJsonSerializer;
    this._property = paramBeanProperty;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    if ((this._valueSerializer instanceof SchemaAware)) {
      return ((SchemaAware)this._valueSerializer).getSchema(paramSerializerProvider, null);
    }
    return JsonSchema.getDefaultSchemaNode();
  }
  
  protected boolean isNaturalTypeWithStdHandling(JavaType paramJavaType, JsonSerializer<?> paramJsonSerializer)
  {
    Class localClass = paramJavaType.getRawClass();
    if (paramJavaType.isPrimitive()) {
      if ((localClass == Integer.TYPE) || (localClass == Boolean.TYPE) || (localClass == Double.TYPE)) {
        break label59;
      }
    }
    label59:
    while (paramJsonSerializer.getClass().getAnnotation(JacksonStdImpl.class) == null) {
      do
      {
        return false;
      } while ((localClass != String.class) && (localClass != Integer.class) && (localClass != Boolean.class) && (localClass != Double.class));
    }
    return true;
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    if ((this._valueSerializer == null) && ((paramSerializerProvider.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING)) || (Modifier.isFinal(this._accessorMethod.getReturnType().getModifiers()))))
    {
      JavaType localJavaType = paramSerializerProvider.constructType(this._accessorMethod.getGenericReturnType());
      this._valueSerializer = paramSerializerProvider.findTypedValueSerializer(localJavaType, false, this._property);
      this._forceTypeInformation = isNaturalTypeWithStdHandling(localJavaType, this._valueSerializer);
    }
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    try
    {
      Object localObject = this._accessorMethod.invoke(paramObject, new Object[0]);
      if (localObject == null)
      {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        return;
      }
      JsonSerializer localJsonSerializer2 = this._valueSerializer;
      JsonSerializer localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null) {
        localJsonSerializer1 = paramSerializerProvider.findTypedValueSerializer(localObject.getClass(), true, this._property);
      }
      localJsonSerializer1.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    catch (IOException paramObject)
    {
      throw ((Throwable)paramObject);
    }
    catch (Exception paramJsonGenerator)
    {
      while (((paramJsonGenerator instanceof InvocationTargetException)) && (paramJsonGenerator.getCause() != null)) {
        paramJsonGenerator = paramJsonGenerator.getCause();
      }
      if ((paramJsonGenerator instanceof Error)) {
        throw ((Error)paramJsonGenerator);
      }
      throw JsonMappingException.wrapWithPath(paramJsonGenerator, paramObject, this._accessorMethod.getName() + "()");
    }
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    try
    {
      localObject = this._accessorMethod.invoke(paramObject, new Object[0]);
      if (localObject == null)
      {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        return;
      }
      JsonSerializer localJsonSerializer = this._valueSerializer;
      if (localJsonSerializer != null)
      {
        if (this._forceTypeInformation) {
          paramTypeSerializer.writeTypePrefixForScalar(paramObject, paramJsonGenerator);
        }
        localJsonSerializer.serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
        if (!this._forceTypeInformation) {
          return;
        }
        paramTypeSerializer.writeTypeSuffixForScalar(paramObject, paramJsonGenerator);
      }
    }
    catch (IOException paramObject)
    {
      Object localObject;
      throw ((Throwable)paramObject);
      paramSerializerProvider.findTypedValueSerializer(localObject.getClass(), true, this._property).serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    catch (Exception paramJsonGenerator)
    {
      while (((paramJsonGenerator instanceof InvocationTargetException)) && (paramJsonGenerator.getCause() != null)) {
        paramJsonGenerator = paramJsonGenerator.getCause();
      }
      if ((paramJsonGenerator instanceof Error)) {
        throw ((Error)paramJsonGenerator);
      }
      throw JsonMappingException.wrapWithPath(paramJsonGenerator, paramObject, this._accessorMethod.getName() + "()");
    }
  }
  
  public String toString()
  {
    return "(@JsonValue serializer for method " + this._accessorMethod.getDeclaringClass() + "#" + this._accessorMethod.getName() + ")";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/std/JsonValueSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */