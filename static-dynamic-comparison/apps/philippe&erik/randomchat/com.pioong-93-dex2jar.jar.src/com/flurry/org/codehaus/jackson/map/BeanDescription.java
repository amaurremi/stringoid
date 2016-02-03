package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedClass;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedField;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.introspect.VisibilityChecker;
import com.flurry.org.codehaus.jackson.map.type.TypeBindings;
import com.flurry.org.codehaus.jackson.map.util.Annotations;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
  public abstract LinkedHashMap<String, AnnotatedField> findDeserializableFields(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection);
  
  @Deprecated
  public abstract LinkedHashMap<String, AnnotatedMethod> findGetters(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection);
  
  public abstract Map<Object, AnnotatedMember> findInjectables();
  
  public abstract AnnotatedMethod findJsonValueMethod();
  
  public abstract List<BeanPropertyDefinition> findProperties();
  
  @Deprecated
  public abstract Map<String, AnnotatedField> findSerializableFields(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection);
  
  @Deprecated
  public abstract LinkedHashMap<String, AnnotatedMethod> findSetters(VisibilityChecker<?> paramVisibilityChecker);
  
  public Class<?> getBeanClass()
  {
    return this._type.getRawClass();
  }
  
  public abstract Annotations getClassAnnotations();
  
  public abstract AnnotatedClass getClassInfo();
  
  public abstract Set<String> getIgnoredPropertyNames();
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public abstract boolean hasKnownClassAnnotations();
  
  public abstract JavaType resolveType(Type paramType);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/BeanDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */