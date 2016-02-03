package org.codehaus.jackson.map.deser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public final class SettableBeanProperty$SetterlessProperty
  extends SettableBeanProperty
{
  protected final AnnotatedMethod _annotated;
  protected final Method _getter;
  
  public SettableBeanProperty$SetterlessProperty(String paramString, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, AnnotatedMethod paramAnnotatedMethod)
  {
    super(paramString, paramJavaType, paramTypeDeserializer, paramAnnotations);
    this._annotated = paramAnnotatedMethod;
    this._getter = paramAnnotatedMethod.getAnnotated();
  }
  
  protected SettableBeanProperty$SetterlessProperty(SetterlessProperty paramSetterlessProperty, JsonDeserializer paramJsonDeserializer)
  {
    super(paramSetterlessProperty, paramJsonDeserializer);
    this._annotated = paramSetterlessProperty._annotated;
    this._getter = paramSetterlessProperty._getter;
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
    throw new UnsupportedOperationException("Should never call 'set' on setterless property");
  }
  
  public SetterlessProperty withValueDeserializer(JsonDeserializer paramJsonDeserializer)
  {
    return new SetterlessProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/SettableBeanProperty$SetterlessProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */