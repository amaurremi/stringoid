package org.codehaus.jackson.map.deser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public final class SettableBeanProperty$MethodProperty
  extends SettableBeanProperty
{
  protected final AnnotatedMethod _annotated;
  protected final Method _setter;
  
  public SettableBeanProperty$MethodProperty(String paramString, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedMethod paramAnnotatedMethod)
  {
    super(paramString, paramJavaType, paramTypeDeserializer, paramAnnotations);
    this._annotated = paramAnnotatedMethod;
    this._setter = paramAnnotatedMethod.getAnnotated();
  }
  
  protected SettableBeanProperty$MethodProperty(MethodProperty paramMethodProperty, JsonDeserializer paramJsonDeserializer)
  {
    super(paramMethodProperty, paramJsonDeserializer);
    this._annotated = paramMethodProperty._annotated;
    this._setter = paramMethodProperty._setter;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    set(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public Annotation getAnnotation(Class paramClass)
  {
    return this._annotated.getAnnotation(paramClass);
  }
  
  public AnnotatedMember getMember()
  {
    return this._annotated;
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    try
    {
      this._setter.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      _throwAsIOE((Exception)paramObject1, paramObject2);
    }
  }
  
  public MethodProperty withValueDeserializer(JsonDeserializer paramJsonDeserializer)
  {
    return new MethodProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/SettableBeanProperty$MethodProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */