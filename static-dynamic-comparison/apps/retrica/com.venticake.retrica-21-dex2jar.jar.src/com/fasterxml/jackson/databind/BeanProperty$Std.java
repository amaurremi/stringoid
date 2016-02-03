package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;

public class BeanProperty$Std
  implements BeanProperty
{
  protected final Annotations _contextAnnotations;
  protected final AnnotatedMember _member;
  protected final String _name;
  protected final JavaType _type;
  
  public BeanProperty$Std(String paramString, JavaType paramJavaType, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember)
  {
    this._name = paramString;
    this._type = paramJavaType;
    this._member = paramAnnotatedMember;
    this._contextAnnotations = paramAnnotations;
  }
  
  public AnnotatedMember getMember()
  {
    return this._member;
  }
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public Std withType(JavaType paramJavaType)
  {
    return new Std(this._name, paramJavaType, this._contextAnnotations, this._member);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/BeanProperty$Std.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */