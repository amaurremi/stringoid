package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;

public class CreatorProperty
  extends SettableBeanProperty
{
  protected final AnnotatedParameter _annotated;
  protected final int _creatorIndex;
  protected final Object _injectableValueId;
  
  protected CreatorProperty(CreatorProperty paramCreatorProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramCreatorProperty, paramJsonDeserializer);
    this._annotated = paramCreatorProperty._annotated;
    this._creatorIndex = paramCreatorProperty._creatorIndex;
    this._injectableValueId = paramCreatorProperty._injectableValueId;
  }
  
  protected CreatorProperty(CreatorProperty paramCreatorProperty, String paramString)
  {
    super(paramCreatorProperty, paramString);
    this._annotated = paramCreatorProperty._annotated;
    this._creatorIndex = paramCreatorProperty._creatorIndex;
    this._injectableValueId = paramCreatorProperty._injectableValueId;
  }
  
  public CreatorProperty(String paramString, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedParameter paramAnnotatedParameter, int paramInt, Object paramObject)
  {
    super(paramString, paramJavaType, paramTypeDeserializer, paramAnnotations);
    this._annotated = paramAnnotatedParameter;
    this._creatorIndex = paramInt;
    this._injectableValueId = paramObject;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    set(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    return setAndReturn(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public int getCreatorIndex()
  {
    return this._creatorIndex;
  }
  
  public Object getInjectableValueId()
  {
    return this._injectableValueId;
  }
  
  public AnnotatedMember getMember()
  {
    return this._annotated;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    throw new IllegalStateException("Method should never be called on a " + getClass().getName());
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
  {
    return paramObject1;
  }
  
  public String toString()
  {
    return "[creator property, name '" + getName() + "'; inject id '" + this._injectableValueId + "']";
  }
  
  public CreatorProperty withName(String paramString)
  {
    return new CreatorProperty(this, paramString);
  }
  
  public CreatorProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new CreatorProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/CreatorProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */