package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TypeFactory
  implements Serializable
{
  protected static final SimpleType CORE_TYPE_BOOL = new SimpleType(Boolean.TYPE);
  protected static final SimpleType CORE_TYPE_INT = new SimpleType(Integer.TYPE);
  protected static final SimpleType CORE_TYPE_LONG = new SimpleType(Long.TYPE);
  protected static final SimpleType CORE_TYPE_STRING;
  private static final JavaType[] NO_TYPES = new JavaType[0];
  protected static final TypeFactory instance = new TypeFactory();
  protected transient HierarchicType _cachedArrayListType;
  protected transient HierarchicType _cachedHashMapType;
  protected final TypeModifier[] _modifiers = null;
  protected final TypeParser _parser = new TypeParser(this);
  protected final LRUMap<ClassKey, JavaType> _typeCache = new LRUMap(16, 100);
  
  static
  {
    CORE_TYPE_STRING = new SimpleType(String.class);
  }
  
  private JavaType _collectionType(Class<?> paramClass)
  {
    JavaType[] arrayOfJavaType = findTypeParameters(paramClass, Collection.class);
    if (arrayOfJavaType == null) {
      return CollectionType.construct(paramClass, _unknownType());
    }
    if (arrayOfJavaType.length != 1) {
      throw new IllegalArgumentException("Strange Collection type " + paramClass.getName() + ": can not determine type parameters");
    }
    return CollectionType.construct(paramClass, arrayOfJavaType[0]);
  }
  
  private JavaType _mapType(Class<?> paramClass)
  {
    JavaType[] arrayOfJavaType = findTypeParameters(paramClass, Map.class);
    if (arrayOfJavaType == null) {
      return MapType.construct(paramClass, _unknownType(), _unknownType());
    }
    if (arrayOfJavaType.length != 2) {
      throw new IllegalArgumentException("Strange Map type " + paramClass.getName() + ": can not determine type parameters");
    }
    return MapType.construct(paramClass, arrayOfJavaType[0], arrayOfJavaType[1]);
  }
  
  public static TypeFactory defaultInstance()
  {
    return instance;
  }
  
  public static JavaType unknownType()
  {
    return defaultInstance()._unknownType();
  }
  
  protected HierarchicType _arrayListSuperInterfaceChain(HierarchicType paramHierarchicType)
  {
    try
    {
      if (this._cachedArrayListType == null)
      {
        localHierarchicType = paramHierarchicType.deepCloneWithoutSubtype();
        _doFindSuperInterfaceChain(localHierarchicType, List.class);
        this._cachedArrayListType = localHierarchicType.getSuperType();
      }
      HierarchicType localHierarchicType = this._cachedArrayListType.deepCloneWithoutSubtype();
      paramHierarchicType.setSuperType(localHierarchicType);
      localHierarchicType.setSubType(paramHierarchicType);
      return paramHierarchicType;
    }
    finally {}
  }
  
  public JavaType _constructType(Type paramType, TypeBindings paramTypeBindings)
  {
    JavaType localJavaType1;
    if ((paramType instanceof Class)) {
      localJavaType1 = _fromClass((Class)paramType, paramTypeBindings);
    }
    JavaType localJavaType2;
    for (;;)
    {
      localJavaType2 = localJavaType1;
      if (this._modifiers == null) {
        break label213;
      }
      localJavaType2 = localJavaType1;
      if (localJavaType1.isContainerType()) {
        break label213;
      }
      TypeModifier[] arrayOfTypeModifier = this._modifiers;
      int j = arrayOfTypeModifier.length;
      int i = 0;
      for (;;)
      {
        localJavaType2 = localJavaType1;
        if (i >= j) {
          break;
        }
        localJavaType1 = arrayOfTypeModifier[i].modifyType(localJavaType1, paramType, paramTypeBindings, this);
        i += 1;
      }
      if ((paramType instanceof ParameterizedType))
      {
        localJavaType1 = _fromParamType((ParameterizedType)paramType, paramTypeBindings);
      }
      else if ((paramType instanceof GenericArrayType))
      {
        localJavaType1 = _fromArrayType((GenericArrayType)paramType, paramTypeBindings);
      }
      else if ((paramType instanceof TypeVariable))
      {
        localJavaType1 = _fromVariable((TypeVariable)paramType, paramTypeBindings);
      }
      else
      {
        if (!(paramType instanceof WildcardType)) {
          break;
        }
        localJavaType1 = _fromWildcard((WildcardType)paramType, paramTypeBindings);
      }
    }
    paramTypeBindings = new StringBuilder().append("Unrecognized Type: ");
    if (paramType == null) {}
    for (paramType = "[null]";; paramType = paramType.toString()) {
      throw new IllegalArgumentException(paramType);
    }
    label213:
    return localJavaType2;
  }
  
  protected HierarchicType _doFindSuperInterfaceChain(HierarchicType paramHierarchicType, Class<?> paramClass)
  {
    Object localObject = paramHierarchicType.getRawClass();
    Type[] arrayOfType = ((Class)localObject).getGenericInterfaces();
    if (arrayOfType != null)
    {
      int j = arrayOfType.length;
      int i = 0;
      while (i < j)
      {
        HierarchicType localHierarchicType = _findSuperInterfaceChain(arrayOfType[i], paramClass);
        if (localHierarchicType != null)
        {
          localHierarchicType.setSubType(paramHierarchicType);
          paramHierarchicType.setSuperType(localHierarchicType);
          return paramHierarchicType;
        }
        i += 1;
      }
    }
    localObject = ((Class)localObject).getGenericSuperclass();
    if (localObject != null)
    {
      paramClass = _findSuperInterfaceChain((Type)localObject, paramClass);
      if (paramClass != null)
      {
        paramClass.setSubType(paramHierarchicType);
        paramHierarchicType.setSuperType(paramClass);
        return paramHierarchicType;
      }
    }
    return null;
  }
  
  protected HierarchicType _findSuperClassChain(Type paramType, Class<?> paramClass)
  {
    paramType = new HierarchicType(paramType);
    Object localObject = paramType.getRawClass();
    if (localObject == paramClass) {
      return paramType;
    }
    localObject = ((Class)localObject).getGenericSuperclass();
    if (localObject != null)
    {
      paramClass = _findSuperClassChain((Type)localObject, paramClass);
      if (paramClass != null)
      {
        paramClass.setSubType(paramType);
        paramType.setSuperType(paramClass);
        return paramType;
      }
    }
    return null;
  }
  
  protected HierarchicType _findSuperInterfaceChain(Type paramType, Class<?> paramClass)
  {
    HierarchicType localHierarchicType = new HierarchicType(paramType);
    Class localClass = localHierarchicType.getRawClass();
    if (localClass == paramClass) {
      return new HierarchicType(paramType);
    }
    if ((localClass == HashMap.class) && (paramClass == Map.class)) {
      return _hashMapSuperInterfaceChain(localHierarchicType);
    }
    if ((localClass == ArrayList.class) && (paramClass == List.class)) {
      return _arrayListSuperInterfaceChain(localHierarchicType);
    }
    return _doFindSuperInterfaceChain(localHierarchicType, paramClass);
  }
  
  protected HierarchicType _findSuperTypeChain(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isInterface()) {
      return _findSuperInterfaceChain(paramClass1, paramClass2);
    }
    return _findSuperClassChain(paramClass1, paramClass2);
  }
  
  protected JavaType _fromArrayType(GenericArrayType paramGenericArrayType, TypeBindings paramTypeBindings)
  {
    return ArrayType.construct(_constructType(paramGenericArrayType.getGenericComponentType(), paramTypeBindings), null, null);
  }
  
  protected JavaType _fromClass(Class<?> paramClass, TypeBindings arg2)
  {
    if (paramClass == String.class)
    {
      ??? = CORE_TYPE_STRING;
      return (JavaType)???;
    }
    if (paramClass == Boolean.TYPE) {
      return CORE_TYPE_BOOL;
    }
    if (paramClass == Integer.TYPE) {
      return CORE_TYPE_INT;
    }
    if (paramClass == Long.TYPE) {
      return CORE_TYPE_LONG;
    }
    ClassKey localClassKey = new ClassKey(paramClass);
    for (;;)
    {
      synchronized (this._typeCache)
      {
        JavaType localJavaType = (JavaType)this._typeCache.get(localClassKey);
        ??? = localJavaType;
        if (localJavaType != null) {
          break;
        }
        if (paramClass.isArray())
        {
          paramClass = ArrayType.construct(_constructType(paramClass.getComponentType(), null), null, null);
          synchronized (this._typeCache)
          {
            this._typeCache.put(localClassKey, paramClass);
            return paramClass;
          }
        }
      }
      if (paramClass.isEnum()) {
        paramClass = new SimpleType(paramClass);
      } else if (Map.class.isAssignableFrom(paramClass)) {
        paramClass = _mapType(paramClass);
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        paramClass = _collectionType(paramClass);
      } else {
        paramClass = new SimpleType(paramClass);
      }
    }
  }
  
  protected JavaType _fromParamType(ParameterizedType paramParameterizedType, TypeBindings paramTypeBindings)
  {
    Class localClass = (Class)paramParameterizedType.getRawType();
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if (arrayOfType == null) {}
    for (int i = 0; i == 0; i = arrayOfType.length)
    {
      paramParameterizedType = NO_TYPES;
      if (!Map.class.isAssignableFrom(localClass)) {
        break label174;
      }
      paramParameterizedType = findTypeParameters(constructSimpleType(localClass, paramParameterizedType), Map.class);
      if (paramParameterizedType.length == 2) {
        break label162;
      }
      throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
    }
    JavaType[] arrayOfJavaType = new JavaType[i];
    int j = 0;
    for (;;)
    {
      paramParameterizedType = arrayOfJavaType;
      if (j >= i) {
        break;
      }
      arrayOfJavaType[j] = _constructType(arrayOfType[j], paramTypeBindings);
      j += 1;
    }
    label162:
    return MapType.construct(localClass, paramParameterizedType[0], paramParameterizedType[1]);
    label174:
    if (Collection.class.isAssignableFrom(localClass))
    {
      paramParameterizedType = findTypeParameters(constructSimpleType(localClass, paramParameterizedType), Collection.class);
      if (paramParameterizedType.length != 1) {
        throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
      }
      return CollectionType.construct(localClass, paramParameterizedType[0]);
    }
    if (i == 0) {
      return new SimpleType(localClass);
    }
    return constructSimpleType(localClass, paramParameterizedType);
  }
  
  protected JavaType _fromParameterizedClass(Class<?> paramClass, List<JavaType> paramList)
  {
    if (paramClass.isArray()) {
      return ArrayType.construct(_constructType(paramClass.getComponentType(), null), null, null);
    }
    if (paramClass.isEnum()) {
      return new SimpleType(paramClass);
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (paramList.size() > 0)
      {
        JavaType localJavaType = (JavaType)paramList.get(0);
        if (paramList.size() >= 2) {}
        for (paramList = (JavaType)paramList.get(1);; paramList = _unknownType()) {
          return MapType.construct(paramClass, localJavaType, paramList);
        }
      }
      return _mapType(paramClass);
    }
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (paramList.size() >= 1) {
        return CollectionType.construct(paramClass, (JavaType)paramList.get(0));
      }
      return _collectionType(paramClass);
    }
    if (paramList.size() == 0) {
      return new SimpleType(paramClass);
    }
    return constructSimpleType(paramClass, (JavaType[])paramList.toArray(new JavaType[paramList.size()]));
  }
  
  protected JavaType _fromVariable(TypeVariable<?> paramTypeVariable, TypeBindings paramTypeBindings)
  {
    Object localObject;
    if (paramTypeBindings == null) {
      localObject = _unknownType();
    }
    String str;
    JavaType localJavaType;
    do
    {
      return (JavaType)localObject;
      str = paramTypeVariable.getName();
      localJavaType = paramTypeBindings.findType(str);
      localObject = localJavaType;
    } while (localJavaType != null);
    paramTypeVariable = paramTypeVariable.getBounds();
    paramTypeBindings._addPlaceholder(str);
    return _constructType(paramTypeVariable[0], paramTypeBindings);
  }
  
  protected JavaType _fromWildcard(WildcardType paramWildcardType, TypeBindings paramTypeBindings)
  {
    return _constructType(paramWildcardType.getUpperBounds()[0], paramTypeBindings);
  }
  
  protected HierarchicType _hashMapSuperInterfaceChain(HierarchicType paramHierarchicType)
  {
    try
    {
      if (this._cachedHashMapType == null)
      {
        localHierarchicType = paramHierarchicType.deepCloneWithoutSubtype();
        _doFindSuperInterfaceChain(localHierarchicType, Map.class);
        this._cachedHashMapType = localHierarchicType.getSuperType();
      }
      HierarchicType localHierarchicType = this._cachedHashMapType.deepCloneWithoutSubtype();
      paramHierarchicType.setSuperType(localHierarchicType);
      localHierarchicType.setSubType(paramHierarchicType);
      return paramHierarchicType;
    }
    finally {}
  }
  
  protected JavaType _unknownType()
  {
    return new SimpleType(Object.class);
  }
  
  public CollectionType constructCollectionType(Class<? extends Collection> paramClass, Class<?> paramClass1)
  {
    return CollectionType.construct(paramClass, constructType(paramClass1));
  }
  
  public JavaType constructFromCanonical(String paramString)
  {
    return this._parser.parse(paramString);
  }
  
  public MapType constructMapType(Class<? extends Map> paramClass, Class<?> paramClass1, Class<?> paramClass2)
  {
    return MapType.construct(paramClass, constructType(paramClass1), constructType(paramClass2));
  }
  
  public JavaType constructSimpleType(Class<?> paramClass, JavaType[] paramArrayOfJavaType)
  {
    TypeVariable[] arrayOfTypeVariable = paramClass.getTypeParameters();
    if (arrayOfTypeVariable.length != paramArrayOfJavaType.length) {
      throw new IllegalArgumentException("Parameter type mismatch for " + paramClass.getName() + ": expected " + arrayOfTypeVariable.length + " parameters, was given " + paramArrayOfJavaType.length);
    }
    String[] arrayOfString = new String[arrayOfTypeVariable.length];
    int i = 0;
    int j = arrayOfTypeVariable.length;
    while (i < j)
    {
      arrayOfString[i] = arrayOfTypeVariable[i].getName();
      i += 1;
    }
    return new SimpleType(paramClass, arrayOfString, paramArrayOfJavaType, null, null);
  }
  
  public JavaType constructSpecializedType(JavaType paramJavaType, Class<?> paramClass)
  {
    if (((paramJavaType instanceof SimpleType)) && ((paramClass.isArray()) || (Map.class.isAssignableFrom(paramClass)) || (Collection.class.isAssignableFrom(paramClass))))
    {
      if (!paramJavaType.getRawClass().isAssignableFrom(paramClass)) {
        throw new IllegalArgumentException("Class " + paramClass.getClass().getName() + " not subtype of " + paramJavaType);
      }
      Object localObject1 = _fromClass(paramClass, new TypeBindings(this, paramJavaType.getRawClass()));
      Object localObject2 = paramJavaType.getValueHandler();
      paramClass = (Class<?>)localObject1;
      if (localObject2 != null) {
        paramClass = ((JavaType)localObject1).withValueHandler(localObject2);
      }
      localObject1 = paramJavaType.getTypeHandler();
      paramJavaType = paramClass;
      if (localObject1 != null) {
        paramJavaType = paramClass.withTypeHandler(localObject1);
      }
      return paramJavaType;
    }
    return paramJavaType.narrowBy(paramClass);
  }
  
  public JavaType constructType(Type paramType)
  {
    return _constructType(paramType, null);
  }
  
  public JavaType constructType(Type paramType, TypeBindings paramTypeBindings)
  {
    return _constructType(paramType, paramTypeBindings);
  }
  
  public JavaType[] findTypeParameters(JavaType paramJavaType, Class<?> paramClass)
  {
    Object localObject = paramJavaType.getRawClass();
    if (localObject == paramClass)
    {
      int j = paramJavaType.containedTypeCount();
      if (j == 0)
      {
        paramClass = null;
        return paramClass;
      }
      localObject = new JavaType[j];
      int i = 0;
      for (;;)
      {
        paramClass = (Class<?>)localObject;
        if (i >= j) {
          break;
        }
        localObject[i] = paramJavaType.containedType(i);
        i += 1;
      }
    }
    return findTypeParameters((Class)localObject, paramClass, new TypeBindings(this, paramJavaType));
  }
  
  public JavaType[] findTypeParameters(Class<?> paramClass1, Class<?> paramClass2)
  {
    return findTypeParameters(paramClass1, paramClass2, new TypeBindings(this, paramClass1));
  }
  
  public JavaType[] findTypeParameters(Class<?> paramClass1, Class<?> paramClass2, TypeBindings paramTypeBindings)
  {
    Object localObject2 = _findSuperTypeChain(paramClass1, paramClass2);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not a subtype of " + paramClass2.getName());
    }
    for (;;)
    {
      paramTypeBindings = paramClass1;
      if (((HierarchicType)localObject1).getSuperType() == null) {
        break;
      }
      localObject1 = ((HierarchicType)localObject1).getSuperType();
      localObject2 = ((HierarchicType)localObject1).getRawClass();
      paramClass1 = new TypeBindings(this, (Class)localObject2);
      if (((HierarchicType)localObject1).isGeneric())
      {
        paramClass2 = ((HierarchicType)localObject1).asGeneric().getActualTypeArguments();
        localObject2 = ((Class)localObject2).getTypeParameters();
        int j = paramClass2.length;
        int i = 0;
        while (i < j)
        {
          paramClass1.addBinding(localObject2[i].getName(), _constructType(paramClass2[i], paramTypeBindings));
          i += 1;
        }
      }
    }
    if (!((HierarchicType)localObject1).isGeneric()) {
      return null;
    }
    return paramTypeBindings.typesAsArray();
  }
  
  public JavaType uncheckedSimpleType(Class<?> paramClass)
  {
    return new SimpleType(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/type/TypeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */