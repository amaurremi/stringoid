package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.reflect.Method;

public final class SetterlessProperty
  extends SettableBeanProperty
{
  protected final AnnotatedMethod _annotated;
  protected final Method _getter;
  
  protected SetterlessProperty(SetterlessProperty paramSetterlessProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramSetterlessProperty, paramJsonDeserializer);
    this._annotated = paramSetterlessProperty._annotated;
    this._getter = paramSetterlessProperty._getter;
  }
  
  protected SetterlessProperty(SetterlessProperty paramSetterlessProperty, String paramString)
  {
    super(paramSetterlessProperty, paramString);
    this._annotated = paramSetterlessProperty._annotated;
    this._getter = paramSetterlessProperty._getter;
  }
  
  public SetterlessProperty(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedMethod paramAnnotatedMethod)
  {
    super(paramBeanPropertyDefinition, paramJavaType, paramTypeDeserializer, paramAnnotations);
    this._annotated = paramAnnotatedMethod;
    this._getter = paramAnnotatedMethod.getAnnotated();
  }
  
  public final void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
      return;
    }
    try
    {
      paramObject = this._getter.invoke(paramObject, new Object[0]);
      if (paramObject == null) {
        throw new JsonMappingException("Problem deserializing 'setterless' property '" + getName() + "': get method returned null");
      }
    }
    catch (Exception paramJsonParser)
    {
      _throwAsIOE(paramJsonParser);
      return;
    }
    this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
    return paramObject;
  }
  
  public AnnotatedMember getMember()
  {
    return this._annotated;
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Should never call 'set' on setterless property");
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
  {
    set(paramObject1, paramObject2);
    return null;
  }
  
  public SetterlessProperty withName(String paramString)
  {
    return new SetterlessProperty(this, paramString);
  }
  
  public SetterlessProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new SetterlessProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/SetterlessProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */