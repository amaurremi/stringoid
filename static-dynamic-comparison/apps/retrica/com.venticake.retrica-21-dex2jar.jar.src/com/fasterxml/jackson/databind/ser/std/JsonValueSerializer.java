package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@JacksonStdImpl
public class JsonValueSerializer
  extends StdSerializer<Object>
  implements ContextualSerializer
{
  protected final Method _accessorMethod;
  protected final boolean _forceTypeInformation;
  protected final BeanProperty _property;
  protected final JsonSerializer<Object> _valueSerializer;
  
  public JsonValueSerializer(JsonValueSerializer paramJsonValueSerializer, BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer, boolean paramBoolean)
  {
    super(Object.class);
    this._accessorMethod = paramJsonValueSerializer._accessorMethod;
    this._valueSerializer = paramJsonSerializer;
    this._property = paramBeanProperty;
    this._forceTypeInformation = paramBoolean;
  }
  
  public JsonValueSerializer(Method paramMethod, JsonSerializer<Object> paramJsonSerializer)
  {
    super(Object.class);
    this._accessorMethod = paramMethod;
    this._valueSerializer = paramJsonSerializer;
    this._property = null;
    this._forceTypeInformation = true;
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer = this._valueSerializer;
    Object localObject;
    if (localJsonSerializer == null) {
      if (!paramSerializerProvider.isEnabled(MapperFeature.USE_STATIC_TYPING))
      {
        localObject = this;
        if (!Modifier.isFinal(this._accessorMethod.getReturnType().getModifiers())) {}
      }
      else
      {
        localObject = paramSerializerProvider.constructType(this._accessorMethod.getGenericReturnType());
        paramSerializerProvider = paramSerializerProvider.findTypedValueSerializer((JavaType)localObject, false, this._property);
        localObject = withResolved(paramBeanProperty, paramSerializerProvider, isNaturalTypeWithStdHandling(((JavaType)localObject).getRawClass(), paramSerializerProvider));
      }
    }
    do
    {
      return (JsonSerializer<?>)localObject;
      localObject = this;
    } while (!(localJsonSerializer instanceof ContextualSerializer));
    return withResolved(paramBeanProperty, ((ContextualSerializer)localJsonSerializer).createContextual(paramSerializerProvider, paramBeanProperty), this._forceTypeInformation);
  }
  
  protected boolean isNaturalTypeWithStdHandling(Class<?> paramClass, JsonSerializer<?> paramJsonSerializer)
  {
    if (paramClass.isPrimitive())
    {
      if ((paramClass == Integer.TYPE) || (paramClass == Boolean.TYPE) || (paramClass == Double.TYPE)) {}
    }
    else {
      while ((paramClass != String.class) && (paramClass != Integer.class) && (paramClass != Boolean.class) && (paramClass != Double.class)) {
        return false;
      }
    }
    return isDefaultSerializer(paramJsonSerializer);
  }
  
  public String toString()
  {
    return "(@JsonValue serializer for method " + this._accessorMethod.getDeclaringClass() + "#" + this._accessorMethod.getName() + ")";
  }
  
  public JsonValueSerializer withResolved(BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer, boolean paramBoolean)
  {
    if ((this._property == paramBeanProperty) && (this._valueSerializer == paramJsonSerializer) && (paramBoolean == this._forceTypeInformation)) {
      return this;
    }
    return new JsonValueSerializer(this, paramBeanProperty, paramJsonSerializer, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/JsonValueSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */