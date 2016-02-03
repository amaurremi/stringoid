package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.reflect.Field;

public final class FieldProperty
  extends SettableBeanProperty
{
  protected final AnnotatedField _annotated;
  protected final transient Field _field;
  
  protected FieldProperty(FieldProperty paramFieldProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramFieldProperty, paramJsonDeserializer);
    this._annotated = paramFieldProperty._annotated;
    this._field = paramFieldProperty._field;
  }
  
  protected FieldProperty(FieldProperty paramFieldProperty, String paramString)
  {
    super(paramFieldProperty, paramString);
    this._annotated = paramFieldProperty._annotated;
    this._field = paramFieldProperty._field;
  }
  
  public FieldProperty(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedField paramAnnotatedField)
  {
    super(paramBeanPropertyDefinition, paramJavaType, paramTypeDeserializer, paramAnnotations);
    this._annotated = paramAnnotatedField;
    this._field = paramAnnotatedField.getAnnotated();
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    set(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    return setAndReturn(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public AnnotatedMember getMember()
  {
    return this._annotated;
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    try
    {
      this._field.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      _throwAsIOE((Exception)paramObject1, paramObject2);
    }
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
  {
    try
    {
      this._field.set(paramObject1, paramObject2);
      return paramObject1;
    }
    catch (Exception localException)
    {
      _throwAsIOE(localException, paramObject2);
    }
    return paramObject1;
  }
  
  public FieldProperty withName(String paramString)
  {
    return new FieldProperty(this, paramString);
  }
  
  public FieldProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new FieldProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/FieldProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */