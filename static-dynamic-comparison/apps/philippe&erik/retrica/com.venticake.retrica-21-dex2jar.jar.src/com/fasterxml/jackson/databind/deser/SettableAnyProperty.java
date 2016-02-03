package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.io.IOException;
import java.lang.reflect.Method;

public final class SettableAnyProperty
{
  protected final BeanProperty _property;
  protected final Method _setter;
  protected final JavaType _type;
  protected JsonDeserializer<Object> _valueDeserializer;
  
  public SettableAnyProperty(BeanProperty paramBeanProperty, AnnotatedMethod paramAnnotatedMethod, JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer)
  {
    this(paramBeanProperty, paramAnnotatedMethod.getAnnotated(), paramJavaType, paramJsonDeserializer);
  }
  
  public SettableAnyProperty(BeanProperty paramBeanProperty, Method paramMethod, JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer)
  {
    this._property = paramBeanProperty;
    this._type = paramJavaType;
    this._setter = paramMethod;
    this._valueDeserializer = paramJsonDeserializer;
  }
  
  private String getClassName()
  {
    return this._setter.getDeclaringClass().getName();
  }
  
  protected void _throwAsIOE(Exception paramException, String paramString, Object paramObject)
  {
    if ((paramException instanceof IllegalArgumentException))
    {
      if (paramObject == null)
      {
        paramObject = "[NULL]";
        paramString = new StringBuilder("Problem deserializing \"any\" property '").append(paramString);
        paramString.append("' of class " + getClassName() + " (expected type: ").append(this._type);
        paramString.append("; actual type: ").append((String)paramObject).append(")");
        paramObject = paramException.getMessage();
        if (paramObject == null) {
          break label128;
        }
        paramString.append(", problem: ").append((String)paramObject);
      }
      for (;;)
      {
        throw new JsonMappingException(paramString.toString(), null, paramException);
        paramObject = paramObject.getClass().getName();
        break;
        label128:
        paramString.append(" (no error message provided)");
      }
    }
    if ((paramException instanceof IOException)) {
      throw ((IOException)paramException);
    }
    paramString = paramException;
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    while (paramString.getCause() != null) {
      paramString = paramString.getCause();
    }
    throw new JsonMappingException(paramString.getMessage(), null, paramString);
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
      return null;
    }
    return this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public final void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
  {
    set(paramObject, paramString, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public BeanProperty getProperty()
  {
    return this._property;
  }
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public boolean hasValueDeserializer()
  {
    return this._valueDeserializer != null;
  }
  
  public final void set(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      this._setter.invoke(paramObject1, new Object[] { paramString, paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      _throwAsIOE((Exception)paramObject1, paramString, paramObject2);
    }
  }
  
  public String toString()
  {
    return "[any property on class " + getClassName() + "]";
  }
  
  public SettableAnyProperty withValueDeserializer(JsonDeserializer<Object> paramJsonDeserializer)
  {
    return new SettableAnyProperty(this._property, this._setter, this._type, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/SettableAnyProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */