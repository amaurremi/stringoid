package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.util.Annotations;
import com.flurry.org.codehaus.jackson.map.util.Named;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.annotation.Annotation;

public abstract interface BeanProperty
  extends Named
{
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public abstract <A extends Annotation> A getContextAnnotation(Class<A> paramClass);
  
  public abstract AnnotatedMember getMember();
  
  public abstract String getName();
  
  public abstract JavaType getType();
  
  public static class Std
    implements BeanProperty
  {
    protected final Annotations _contextAnnotations;
    protected final AnnotatedMember _member;
    protected final String _name;
    protected final JavaType _type;
    
    public Std(String paramString, JavaType paramJavaType, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember)
    {
      this._name = paramString;
      this._type = paramJavaType;
      this._member = paramAnnotatedMember;
      this._contextAnnotations = paramAnnotations;
    }
    
    public <A extends Annotation> A getAnnotation(Class<A> paramClass)
    {
      return this._member.getAnnotation(paramClass);
    }
    
    public <A extends Annotation> A getContextAnnotation(Class<A> paramClass)
    {
      if (this._contextAnnotations == null) {
        return null;
      }
      return this._contextAnnotations.get(paramClass);
    }
    
    public AnnotatedMember getMember()
    {
      return this._member;
    }
    
    public String getName()
    {
      return this._name;
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/BeanProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */