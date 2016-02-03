package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.map.BeanProperty.Std;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.util.Annotations;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

public class ValueInjector
  extends BeanProperty.Std
{
  protected final Object _valueId;
  
  public ValueInjector(String paramString, JavaType paramJavaType, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember, Object paramObject)
  {
    super(paramString, paramJavaType, paramAnnotations, paramAnnotatedMember);
    this._valueId = paramObject;
  }
  
  public Object findValue(DeserializationContext paramDeserializationContext, Object paramObject)
  {
    return paramDeserializationContext.findInjectableValue(this._valueId, this, paramObject);
  }
  
  public void inject(DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    this._member.setValue(paramObject, findValue(paramDeserializationContext, paramObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/impl/ValueInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */