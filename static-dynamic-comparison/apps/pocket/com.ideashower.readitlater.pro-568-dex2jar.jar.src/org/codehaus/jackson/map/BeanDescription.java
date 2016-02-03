package org.codehaus.jackson.map;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public abstract class BeanDescription
{
  protected final JavaType _type;
  
  protected BeanDescription(JavaType paramJavaType)
  {
    this._type = paramJavaType;
  }
  
  public abstract TypeBindings bindingsForBeanType();
  
  public abstract AnnotatedMethod findAnyGetter();
  
  public abstract AnnotatedMethod findAnySetter();
  
  public abstract AnnotatedConstructor findDefaultConstructor();
  
  @Deprecated
  public abstract LinkedHashMap findDeserializableFields(VisibilityChecker paramVisibilityChecker, Collection paramCollection);
  
  @Deprecated
  public abstract LinkedHashMap findGetters(VisibilityChecker paramVisibilityChecker, Collection paramCollection);
  
  public abstract Map findInjectables();
  
  public abstract AnnotatedMethod findJsonValueMethod();
  
  public abstract List findProperties();
  
  @Deprecated
  public abstract Map findSerializableFields(VisibilityChecker paramVisibilityChecker, Collection paramCollection);
  
  @Deprecated
  public abstract LinkedHashMap findSetters(VisibilityChecker paramVisibilityChecker);
  
  public Class getBeanClass()
  {
    return this._type.getRawClass();
  }
  
  public abstract Annotations getClassAnnotations();
  
  public abstract AnnotatedClass getClassInfo();
  
  public abstract Set getIgnoredPropertyNames();
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public abstract boolean hasKnownClassAnnotations();
  
  public abstract JavaType resolveType(Type paramType);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/BeanDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */