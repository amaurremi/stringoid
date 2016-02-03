package org.codehaus.jackson.map.jsontype.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;

public class StdSubtypeResolver
  extends SubtypeResolver
{
  protected LinkedHashSet _registeredSubtypes;
  
  protected void _collectAndResolve(AnnotatedClass paramAnnotatedClass, NamedType paramNamedType, MapperConfig paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector, HashMap paramHashMap)
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
  
  public Collection collectAndResolveSubtypes(AnnotatedClass paramAnnotatedClass, MapperConfig paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector)
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
  
  public Collection collectAndResolveSubtypes(AnnotatedMember paramAnnotatedMember, MapperConfig paramMapperConfig, AnnotationIntrospector paramAnnotationIntrospector)
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
  
  public void registerSubtypes(Class... paramVarArgs)
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/impl/StdSubtypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */