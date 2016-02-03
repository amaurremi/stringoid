package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Named;
import org.codehaus.jackson.type.JavaType;

public abstract interface BeanProperty
  extends Named
{
  public abstract Annotation getAnnotation(Class paramClass);
  
  public abstract Annotation getContextAnnotation(Class paramClass);
  
  public abstract AnnotatedMember getMember();
  
  public abstract String getName();
  
  public abstract JavaType getType();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/BeanProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */