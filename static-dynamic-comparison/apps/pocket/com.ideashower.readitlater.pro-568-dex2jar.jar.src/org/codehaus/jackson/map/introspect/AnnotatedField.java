package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedField
  extends AnnotatedMember
{
  protected final Field _field;
  
  public AnnotatedField(Field paramField, AnnotationMap paramAnnotationMap)
  {
    super(paramAnnotationMap);
    this._field = paramField;
  }
  
  public void addOrOverride(Annotation paramAnnotation)
  {
    this._annotations.add(paramAnnotation);
  }
  
  public Field getAnnotated()
  {
    return this._field;
  }
  
  public Annotation getAnnotation(Class paramClass)
  {
    return this._annotations.get(paramClass);
  }
  
  public int getAnnotationCount()
  {
    return this._annotations.size();
  }
  
  public Class getDeclaringClass()
  {
    return this._field.getDeclaringClass();
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName();
  }
  
  public Type getGenericType()
  {
    return this._field.getGenericType();
  }
  
  public Member getMember()
  {
    return this._field;
  }
  
  public int getModifiers()
  {
    return this._field.getModifiers();
  }
  
  public String getName()
  {
    return this._field.getName();
  }
  
  public Class getRawType()
  {
    return this._field.getType();
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    try
    {
      this._field.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new IllegalArgumentException("Failed to setValue() for field " + getFullName() + ": " + ((IllegalAccessException)paramObject1).getMessage(), (Throwable)paramObject1);
    }
  }
  
  public String toString()
  {
    return "[field " + getName() + ", annotations: " + this._annotations + "]";
  }
  
  public AnnotatedField withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedField(this._field, paramAnnotationMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/AnnotatedField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */