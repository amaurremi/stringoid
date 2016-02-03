package com.millennialmedia.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types
{
  static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
  
  public static GenericArrayType arrayOf(Type paramType)
  {
    return new GenericArrayTypeImpl(paramType);
  }
  
  public static Type canonicalize(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray()) {
        paramType = new GenericArrayTypeImpl(canonicalize(paramType.getComponentType()));
      }
      for (;;)
      {
        return (Type)paramType;
      }
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new ParameterizedTypeImpl(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new GenericArrayTypeImpl(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new WildcardTypeImpl(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  private static void checkNotPrimitive(Type paramType)
  {
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive())) {}
    for (boolean bool = true;; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      return;
    }
  }
  
  private static Class<?> declaringClassOf(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean equals(Type paramType1, Type paramType2)
  {
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    if (paramType1 == paramType2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((paramType1 instanceof Class)) {
                return paramType1.equals(paramType2);
              }
              if (!(paramType1 instanceof ParameterizedType)) {
                break;
              }
              bool1 = bool3;
            } while (!(paramType2 instanceof ParameterizedType));
            paramType1 = (ParameterizedType)paramType1;
            paramType2 = (ParameterizedType)paramType2;
            if ((equal(paramType1.getOwnerType(), paramType2.getOwnerType())) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()))) {}
            for (bool1 = bool2;; bool1 = false) {
              return bool1;
            }
            if (!(paramType1 instanceof GenericArrayType)) {
              break;
            }
            bool1 = bool3;
          } while (!(paramType2 instanceof GenericArrayType));
          paramType1 = (GenericArrayType)paramType1;
          paramType2 = (GenericArrayType)paramType2;
          return equals(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
          if (!(paramType1 instanceof WildcardType)) {
            break;
          }
          bool1 = bool3;
        } while (!(paramType2 instanceof WildcardType));
        paramType1 = (WildcardType)paramType1;
        paramType2 = (WildcardType)paramType2;
        if ((Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()))) {}
        for (bool1 = bool4;; bool1 = false) {
          return bool1;
        }
        bool1 = bool3;
      } while (!(paramType1 instanceof TypeVariable));
      bool1 = bool3;
    } while (!(paramType2 instanceof TypeVariable));
    paramType1 = (TypeVariable)paramType1;
    paramType2 = (TypeVariable)paramType2;
    if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {}
    for (boolean bool1 = bool5;; bool1 = false) {
      return bool1;
    }
  }
  
  public static Type getArrayComponentType(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
  
  public static Type getCollectionElementType(Type paramType, Class<?> paramClass)
  {
    paramClass = getSupertype(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments()[0];
    }
    return Object.class;
  }
  
  static Type getGenericSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      paramType = paramClass1.getInterfaces();
      int i = 0;
      int j = paramType.length;
      while (i < j)
      {
        if (paramType[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(paramType[i])) {
          return getGenericSupertype(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
        }
        i += 1;
      }
    }
    if (!paramClass1.isInterface()) {
      while (paramClass1 != Object.class)
      {
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2) {
          return paramClass1.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramType)) {
          return getGenericSupertype(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  public static Type[] getMapKeyAndValueTypes(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class) {
      return new Type[] { String.class, String.class };
    }
    paramType = getSupertype(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments();
    }
    return new Type[] { Object.class, Object.class };
  }
  
  public static Class<?> getRawType(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      .Gson.Preconditions.checkArgument(paramType instanceof Class);
      return (Class)paramType;
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(getRawType(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return getRawType(((WildcardType)paramType).getUpperBounds()[0]);
    }
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName()) {
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
    }
  }
  
  static Type getSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    .Gson.Preconditions.checkArgument(paramClass2.isAssignableFrom(paramClass1));
    return resolve(paramType, paramClass1, getGenericSupertype(paramType, paramClass1, paramClass2));
  }
  
  private static int hashCodeOrZero(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  private static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    throw new NoSuchElementException();
  }
  
  public static ParameterizedType newParameterizedTypeWithOwner(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new ParameterizedTypeImpl(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject2;
    Object localObject1;
    while ((paramType2 instanceof TypeVariable))
    {
      localObject2 = (TypeVariable)paramType2;
      localObject1 = resolveTypeVariable(paramType1, paramClass, (TypeVariable)localObject2);
      paramType2 = (Type)localObject1;
      if (localObject1 == localObject2) {
        paramType2 = (Type)localObject1;
      }
    }
    Object localObject3;
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              return paramType2;
              if (((paramType2 instanceof Class)) && (((Class)paramType2).isArray()))
              {
                paramType2 = (Class)paramType2;
                localObject1 = paramType2.getComponentType();
                paramType1 = resolve(paramType1, paramClass, (Type)localObject1);
                if (localObject1 == paramType1) {}
                for (paramType1 = paramType2;; paramType1 = arrayOf(paramType1)) {
                  return paramType1;
                }
              }
              if (!(paramType2 instanceof GenericArrayType)) {
                break;
              }
              paramType2 = (GenericArrayType)paramType2;
              localObject1 = paramType2.getGenericComponentType();
              paramType1 = resolve(paramType1, paramClass, (Type)localObject1);
            } while (localObject1 == paramType1);
            return arrayOf(paramType1);
            if (!(paramType2 instanceof ParameterizedType)) {
              break;
            }
            localObject2 = (ParameterizedType)paramType2;
            paramType2 = ((ParameterizedType)localObject2).getOwnerType();
            localObject3 = resolve(paramType1, paramClass, paramType2);
            if (localObject3 != paramType2) {}
            for (i = 1;; i = 0)
            {
              localObject1 = ((ParameterizedType)localObject2).getActualTypeArguments();
              int k = 0;
              int m = localObject1.length;
              while (k < m)
              {
                Type localType = resolve(paramType1, paramClass, localObject1[k]);
                paramType2 = (Type)localObject1;
                int j = i;
                if (localType != localObject1[k])
                {
                  paramType2 = (Type)localObject1;
                  j = i;
                  if (i == 0)
                  {
                    paramType2 = (Type[])((Type[])localObject1).clone();
                    j = 1;
                  }
                  paramType2[k] = localType;
                }
                k += 1;
                localObject1 = paramType2;
                i = j;
              }
            }
            paramType2 = (Type)localObject2;
          } while (i == 0);
          return newParameterizedTypeWithOwner((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), (Type[])localObject1);
          if (!(paramType2 instanceof WildcardType)) {
            return paramType2;
          }
          localObject1 = (WildcardType)paramType2;
          localObject2 = ((WildcardType)localObject1).getLowerBounds();
          localObject3 = ((WildcardType)localObject1).getUpperBounds();
          if (localObject2.length != 1) {
            break;
          }
          paramType1 = resolve(paramType1, paramClass, localObject2[0]);
          paramType2 = (Type)localObject1;
        } while (paramType1 == localObject2[0]);
        return supertypeOf(paramType1);
        paramType2 = (Type)localObject1;
      } while (localObject3.length != 1);
      paramType1 = resolve(paramType1, paramClass, localObject3[0]);
      paramType2 = (Type)localObject1;
    } while (paramType1 == localObject3[0]);
    return subtypeOf(paramType1);
    return paramType2;
  }
  
  static Type resolveTypeVariable(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = declaringClassOf(paramTypeVariable);
    if (localClass == null) {}
    do
    {
      return paramTypeVariable;
      paramType = getGenericSupertype(paramType, paramClass, localClass);
    } while (!(paramType instanceof ParameterizedType));
    int i = indexOf(localClass.getTypeParameters(), paramTypeVariable);
    return ((ParameterizedType)paramType).getActualTypeArguments()[i];
  }
  
  public static WildcardType subtypeOf(Type paramType)
  {
    Type[] arrayOfType = EMPTY_TYPE_ARRAY;
    return new WildcardTypeImpl(new Type[] { paramType }, arrayOfType);
  }
  
  public static WildcardType supertypeOf(Type paramType)
  {
    return new WildcardTypeImpl(new Type[] { Object.class }, new Type[] { paramType });
  }
  
  public static String typeToString(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  private static final class GenericArrayTypeImpl
    implements GenericArrayType, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Type componentType;
    
    public GenericArrayTypeImpl(Type paramType)
    {
      this.componentType = .Gson.Types.canonicalize(paramType);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (.Gson.Types.equals(this, (GenericArrayType)paramObject));
    }
    
    public Type getGenericComponentType()
    {
      return this.componentType;
    }
    
    public int hashCode()
    {
      return this.componentType.hashCode();
    }
    
    public String toString()
    {
      return .Gson.Types.typeToString(this.componentType) + "[]";
    }
  }
  
  private static final class ParameterizedTypeImpl
    implements ParameterizedType, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;
    
    public ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      boolean bool1;
      if ((paramType2 instanceof Class))
      {
        Class localClass = (Class)paramType2;
        if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
        {
          bool1 = true;
          .Gson.Preconditions.checkArgument(bool1);
          if (paramType1 != null)
          {
            bool1 = bool2;
            if (localClass.getEnclosingClass() == null) {}
          }
          else
          {
            bool1 = true;
          }
          .Gson.Preconditions.checkArgument(bool1);
        }
      }
      else
      {
        if (paramType1 != null) {
          break label160;
        }
      }
      label160:
      for (paramType1 = null;; paramType1 = .Gson.Types.canonicalize(paramType1))
      {
        this.ownerType = paramType1;
        this.rawType = .Gson.Types.canonicalize(paramType2);
        this.typeArguments = ((Type[])paramVarArgs.clone());
        int i = 0;
        while (i < this.typeArguments.length)
        {
          .Gson.Preconditions.checkNotNull(this.typeArguments[i]);
          .Gson.Types.checkNotPrimitive(this.typeArguments[i]);
          this.typeArguments[i] = .Gson.Types.canonicalize(this.typeArguments[i]);
          i += 1;
        }
        bool1 = false;
        break;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType)paramObject));
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.typeArguments.clone();
    }
    
    public Type getOwnerType()
    {
      return this.ownerType;
    }
    
    public Type getRawType()
    {
      return this.rawType;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ .Gson.Types.hashCodeOrZero(this.ownerType);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
      localStringBuilder.append(.Gson.Types.typeToString(this.rawType));
      if (this.typeArguments.length == 0) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append("<").append(.Gson.Types.typeToString(this.typeArguments[0]));
      int i = 1;
      while (i < this.typeArguments.length)
      {
        localStringBuilder.append(", ").append(.Gson.Types.typeToString(this.typeArguments[i]));
        i += 1;
      }
      return ">";
    }
  }
  
  private static final class WildcardTypeImpl
    implements WildcardType, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Type lowerBound;
    private final Type upperBound;
    
    public WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length <= 1)
      {
        bool1 = true;
        .Gson.Preconditions.checkArgument(bool1);
        if (paramArrayOfType1.length != 1) {
          break label87;
        }
        bool1 = true;
        label27:
        .Gson.Preconditions.checkArgument(bool1);
        if (paramArrayOfType2.length != 1) {
          break label97;
        }
        .Gson.Preconditions.checkNotNull(paramArrayOfType2[0]);
        .Gson.Types.checkNotPrimitive(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class) {
          break label92;
        }
      }
      label87:
      label92:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        .Gson.Preconditions.checkArgument(bool1);
        this.lowerBound = .Gson.Types.canonicalize(paramArrayOfType2[0]);
        this.upperBound = Object.class;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label27;
      }
      label97:
      .Gson.Preconditions.checkNotNull(paramArrayOfType1[0]);
      .Gson.Types.checkNotPrimitive(paramArrayOfType1[0]);
      this.lowerBound = null;
      this.upperBound = .Gson.Types.canonicalize(paramArrayOfType1[0]);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (.Gson.Types.equals(this, (WildcardType)paramObject));
    }
    
    public Type[] getLowerBounds()
    {
      if (this.lowerBound != null) {
        return new Type[] { this.lowerBound };
      }
      return .Gson.Types.EMPTY_TYPE_ARRAY;
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { this.upperBound };
    }
    
    public int hashCode()
    {
      if (this.lowerBound != null) {}
      for (int i = this.lowerBound.hashCode() + 31;; i = 1) {
        return i ^ this.upperBound.hashCode() + 31;
      }
    }
    
    public String toString()
    {
      if (this.lowerBound != null) {
        return "? super " + .Gson.Types.typeToString(this.lowerBound);
      }
      if (this.upperBound == Object.class) {
        return "?";
      }
      return "? extends " + .Gson.Types.typeToString(this.upperBound);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/google/gson/internal/$Gson$Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */