package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

public final class AnnotatedParameter
  extends AnnotatedMember
{
  protected final int _index;
  protected final AnnotatedWithParams _owner;
  protected final Type _type;
  
  public AnnotatedParameter(AnnotatedWithParams paramAnnotatedWithParams, Type paramType, AnnotationMap paramAnnotationMap, int paramInt)
  {
    super(paramAnnotationMap);
    this._owner = paramAnnotatedWithParams;
    this._type = paramType;
    this._index = paramInt;
  }
  
  public void addOrOverride(Annotation paramAnnotation)
  {
    this._annotations.add(paramAnnotation);
  }
  
  public AnnotatedElement getAnnotated()
  {
    return null;
  }
  
  public Annotation getAnnotation(Class paramClass)
  {
    return this._annotations.get(paramClass);
  }
  
  public Class getDeclaringClass()
  {
    return this._owner.getDeclaringClass();
  }
  
  public Type getGenericType()
  {
    return this._type;
  }
  
  public int getIndex()
  {
    return this._index;
  }
  
  public Member getMember()
  {
    return this._owner.getMember();
  }
  
  public int getModifiers()
  {
    return this._owner.getModifiers();
  }
  
  public String getName()
  {
    return "";
  }
  
  public AnnotatedWithParams getOwner()
  {
    return this._owner;
  }
  
  public Type getParameterType()
  {
    return this._type;
  }
  
  public Class getRawType()
  {
    if ((this._type instanceof Class)) {
      return (Class)this._type;
    }
    return TypeFactory.defaultInstance().constructType(this._type).getRawClass();
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + getDeclaringClass().getName());
  }
  
  public String toString()
  {
    return "[parameter #" + getIndex() + ", annotations: " + this._annotations + "]";
  }
  
  public AnnotatedParameter withAnnotations(AnnotationMap paramAnnotationMap)
  {
    if (paramAnnotationMap == this._annotations) {
      return this;
    }
    return this._owner.replaceParameterAnnotations(this._index, paramAnnotationMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/AnnotatedParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */