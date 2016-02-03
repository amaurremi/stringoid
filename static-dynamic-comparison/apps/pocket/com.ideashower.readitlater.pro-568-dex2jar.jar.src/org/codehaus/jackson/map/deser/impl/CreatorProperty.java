package org.codehaus.jackson.map.deser.impl;

import java.lang.annotation.Annotation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public class CreatorProperty
  extends SettableBeanProperty
{
  protected final AnnotatedParameter _annotated;
  protected final Object _injectableValueId;
  
  public CreatorProperty(String paramString, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedParameter paramAnnotatedParameter, int paramInt, Object paramObject)
  {
    super(paramString, paramJavaType, paramTypeDeserializer, paramAnnotations);
    this._annotated = paramAnnotatedParameter;
    this._propertyIndex = paramInt;
    this._injectableValueId = paramObject;
  }
  
  protected CreatorProperty(CreatorProperty paramCreatorProperty, JsonDeserializer paramJsonDeserializer)
  {
    super(paramCreatorProperty, paramJsonDeserializer);
    this._annotated = paramCreatorProperty._annotated;
    this._injectableValueId = paramCreatorProperty._injectableValueId;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    set(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public Object findInjectableValue(DeserializationContext paramDeserializationContext, Object paramObject)
  {
    if (this._injectableValueId == null) {
      throw new IllegalStateException("Property '" + getName() + "' (type " + getClass().getName() + ") has no injectable value id configured");
    }
    return paramDeserializationContext.findInjectableValue(this._injectableValueId, this, paramObject);
  }
  
  public Annotation getAnnotation(Class paramClass)
  {
    if (this._annotated == null) {
      return null;
    }
    return this._annotated.getAnnotation(paramClass);
  }
  
  public Object getInjectableValueId()
  {
    return this._injectableValueId;
  }
  
  public AnnotatedMember getMember()
  {
    return this._annotated;
  }
  
  public void inject(DeserializationContext paramDeserializationContext, Object paramObject)
  {
    set(paramObject, findInjectableValue(paramDeserializationContext, paramObject));
  }
  
  public void set(Object paramObject1, Object paramObject2) {}
  
  public CreatorProperty withValueDeserializer(JsonDeserializer paramJsonDeserializer)
  {
    return new CreatorProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/CreatorProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */