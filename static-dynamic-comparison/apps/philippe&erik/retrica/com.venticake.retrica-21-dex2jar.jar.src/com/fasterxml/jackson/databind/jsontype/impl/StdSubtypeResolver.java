package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class StdSubtypeResolver
  extends SubtypeResolver
  implements Serializable
{
  protected LinkedHashSet<NamedType> _registeredSubtypes;
  
  protected void _collectAndResolve(AnnotatedClass paramAnnotatedClass, NamedType paramNamedType, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector, HashMap<NamedType, NamedType> paramHashMap)
  {
    Object localObject = paramNamedType;
    if (!paramNamedType.hasName())
    {
      String str = paramAnnotationIntrospector.findTypeName(paramAnnotatedClass);
      localObject = paramNamedType;
      if (str != null) {
        localObject = new NamedType(paramNamedType.getType(), str);
      }
    }
    if (paramHashMap.containsKey(localObject)) {
      if ((((NamedType)localObject).hasName()) && (!((NamedType)paramHashMap.get(localObject)).hasName())) {
        paramHashMap.put(localObject, localObject);
      }
    }
    do
    {
      return;
      paramHashMap.put(localObject, localObject);
      paramAnnotatedClass = paramAnnotationIntrospector.findSubtypes(paramAnnotatedClass);
    } while ((paramAnnotatedClass == null) || (paramAnnotatedClass.isEmpty()));
    paramNamedType = paramAnnotatedClass.iterator();
    label123:
    if (paramNamedType.hasNext())
    {
      paramAnnotatedClass = (NamedType)paramNamedType.next();
      localObject = AnnotatedClass.constructWithoutSuperTypes(paramAnnotatedClass.getType(), paramAnnotationIntrospector, paramMapperConfig);
      if (paramAnnotatedClass.hasName()) {
        break label195;
      }
      paramAnnotatedClass = new NamedType(paramAnnotatedClass.getType(), paramAnnotationIntrospector.findTypeName((AnnotatedClass)localObject));
    }
    label195:
    for (;;)
    {
      _collectAndResolve((AnnotatedClass)localObject, paramAnnotatedClass, paramMapperConfig, paramAnnotationIntrospector, paramHashMap);
      break label123;
      break;
    }
  }
  
  public Collection<NamedType> collectAndResolveSubtypes(AnnotatedClass paramAnnotatedClass, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector)
  {
    HashMap localHashMap = new HashMap();
    if (this._registeredSubtypes != null)
    {
      Class localClass = paramAnnotatedClass.getRawType();
      Iterator localIterator = this._registeredSubtypes.iterator();
      while (localIterator.hasNext())
      {
        NamedType localNamedType = (NamedType)localIterator.next();
        if (localClass.isAssignableFrom(localNamedType.getType())) {
          _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(localNamedType.getType(), paramAnnotationIntrospector, paramMapperConfig), localNamedType, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
        }
      }
    }
    _collectAndResolve(paramAnnotatedClass, new NamedType(paramAnnotatedClass.getRawType(), null), paramMapperConfig, paramAnnotationIntrospector, localHashMap);
    return new ArrayList(localHashMap.values());
  }
  
  public Collection<NamedType> collectAndResolveSubtypes(AnnotatedMember paramAnnotatedMember, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector, JavaType paramJavaType)
  {
    if (paramJavaType == null) {}
    HashMap localHashMap;
    Object localObject;
    for (paramJavaType = paramAnnotatedMember.getRawType();; paramJavaType = paramJavaType.getRawClass())
    {
      localHashMap = new HashMap();
      if (this._registeredSubtypes == null) {
        break;
      }
      localObject = this._registeredSubtypes.iterator();
      while (((Iterator)localObject).hasNext())
      {
        NamedType localNamedType = (NamedType)((Iterator)localObject).next();
        if (paramJavaType.isAssignableFrom(localNamedType.getType())) {
          _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(localNamedType.getType(), paramAnnotationIntrospector, paramMapperConfig), localNamedType, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
        }
      }
    }
    paramAnnotatedMember = paramAnnotationIntrospector.findSubtypes(paramAnnotatedMember);
    if (paramAnnotatedMember != null)
    {
      paramAnnotatedMember = paramAnnotatedMember.iterator();
      while (paramAnnotatedMember.hasNext())
      {
        localObject = (NamedType)paramAnnotatedMember.next();
        _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(((NamedType)localObject).getType(), paramAnnotationIntrospector, paramMapperConfig), (NamedType)localObject, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
      }
    }
    paramAnnotatedMember = new NamedType(paramJavaType, null);
    _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(paramJavaType, paramAnnotationIntrospector, paramMapperConfig), paramAnnotatedMember, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
    return new ArrayList(localHashMap.values());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/impl/StdSubtypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */