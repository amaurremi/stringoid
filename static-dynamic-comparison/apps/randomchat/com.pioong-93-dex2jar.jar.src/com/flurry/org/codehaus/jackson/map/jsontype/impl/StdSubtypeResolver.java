package com.flurry.org.codehaus.jackson.map.jsontype.impl;

import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.MapperConfig;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedClass;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.jsontype.NamedType;
import com.flurry.org.codehaus.jackson.map.jsontype.SubtypeResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class StdSubtypeResolver
  extends SubtypeResolver
{
  protected LinkedHashSet<NamedType> _registeredSubtypes;
  
  protected void _collectAndResolve(AnnotatedClass paramAnnotatedClass, NamedType paramNamedType, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector, HashMap<NamedType, NamedType> paramHashMap)
  {
    Object localObject1 = paramNamedType;
    Object localObject2;
    if (!paramNamedType.hasName())
    {
      localObject2 = paramAnnotationIntrospector.findTypeName(paramAnnotatedClass);
      localObject1 = paramNamedType;
      if (localObject2 != null) {
        localObject1 = new NamedType(paramNamedType.getType(), (String)localObject2);
      }
    }
    if (paramHashMap.containsKey(localObject1)) {
      if ((((NamedType)localObject1).hasName()) && (!((NamedType)paramHashMap.get(localObject1)).hasName())) {
        paramHashMap.put(localObject1, localObject1);
      }
    }
    for (;;)
    {
      return;
      paramHashMap.put(localObject1, localObject1);
      paramAnnotatedClass = paramAnnotationIntrospector.findSubtypes(paramAnnotatedClass);
      if ((paramAnnotatedClass != null) && (!paramAnnotatedClass.isEmpty()))
      {
        localObject1 = paramAnnotatedClass.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramNamedType = (NamedType)((Iterator)localObject1).next();
          localObject2 = AnnotatedClass.constructWithoutSuperTypes(paramNamedType.getType(), paramAnnotationIntrospector, paramMapperConfig);
          paramAnnotatedClass = paramNamedType;
          if (!paramNamedType.hasName()) {
            paramAnnotatedClass = new NamedType(paramNamedType.getType(), paramAnnotationIntrospector.findTypeName((AnnotatedClass)localObject2));
          }
          _collectAndResolve((AnnotatedClass)localObject2, paramAnnotatedClass, paramMapperConfig, paramAnnotationIntrospector, paramHashMap);
        }
      }
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
  
  public Collection<NamedType> collectAndResolveSubtypes(AnnotatedMember paramAnnotatedMember, MapperConfig<?> paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (this._registeredSubtypes != null)
    {
      localObject1 = paramAnnotatedMember.getRawType();
      localObject2 = this._registeredSubtypes.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        NamedType localNamedType = (NamedType)((Iterator)localObject2).next();
        if (((Class)localObject1).isAssignableFrom(localNamedType.getType())) {
          _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(localNamedType.getType(), paramAnnotationIntrospector, paramMapperConfig), localNamedType, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
        }
      }
    }
    Object localObject1 = paramAnnotationIntrospector.findSubtypes(paramAnnotatedMember);
    if (localObject1 != null)
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NamedType)((Iterator)localObject1).next();
        _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(((NamedType)localObject2).getType(), paramAnnotationIntrospector, paramMapperConfig), (NamedType)localObject2, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
      }
    }
    localObject1 = new NamedType(paramAnnotatedMember.getRawType(), null);
    _collectAndResolve(AnnotatedClass.constructWithoutSuperTypes(paramAnnotatedMember.getRawType(), paramAnnotationIntrospector, paramMapperConfig), (NamedType)localObject1, paramMapperConfig, paramAnnotationIntrospector, localHashMap);
    return new ArrayList(localHashMap.values());
  }
  
  public void registerSubtypes(NamedType... paramVarArgs)
  {
    if (this._registeredSubtypes == null) {
      this._registeredSubtypes = new LinkedHashSet();
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      NamedType localNamedType = paramVarArgs[i];
      this._registeredSubtypes.add(localNamedType);
      i += 1;
    }
  }
  
  public void registerSubtypes(Class<?>... paramVarArgs)
  {
    NamedType[] arrayOfNamedType = new NamedType[paramVarArgs.length];
    int i = 0;
    int j = paramVarArgs.length;
    while (i < j)
    {
      arrayOfNamedType[i] = new NamedType(paramVarArgs[i]);
      i += 1;
    }
    registerSubtypes(arrayOfNamedType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/jsontype/impl/StdSubtypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */