package com.fasterxml.jackson.databind.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HierarchicType
{
  protected final Type _actualType;
  protected final ParameterizedType _genericType;
  protected final Class<?> _rawClass;
  protected HierarchicType _subType;
  protected HierarchicType _superType;
  
  public HierarchicType(Type paramType)
  {
    this._actualType = paramType;
    if ((paramType instanceof Class))
    {
      this._rawClass = ((Class)paramType);
      this._genericType = null;
      return;
    }
    if ((paramType instanceof ParameterizedType))
    {
      this._genericType = ((ParameterizedType)paramType);
      this._rawClass = ((Class)this._genericType.getRawType());
      return;
    }
    throw new IllegalArgumentException("Type " + paramType.getClass().getName() + " can not be used to construct HierarchicType");
  }
  
  private HierarchicType(Type paramType, Class<?> paramClass, ParameterizedType paramParameterizedType, HierarchicType paramHierarchicType1, HierarchicType paramHierarchicType2)
  {
    this._actualType = paramType;
    this._rawClass = paramClass;
    this._genericType = paramParameterizedType;
    this._superType = paramHierarchicType1;
    this._subType = paramHierarchicType2;
  }
  
  public final ParameterizedType asGeneric()
  {
    return this._genericType;
  }
  
  public HierarchicType deepCloneWithoutSubtype()
  {
    if (this._superType == null) {}
    for (HierarchicType localHierarchicType1 = null;; localHierarchicType1 = this._superType.deepCloneWithoutSubtype())
    {
      HierarchicType localHierarchicType2 = new HierarchicType(this._actualType, this._rawClass, this._genericType, localHierarchicType1, null);
      if (localHierarchicType1 != null) {
        localHierarchicType1.setSubType(localHierarchicType2);
      }
      return localHierarchicType2;
    }
  }
  
  public final Class<?> getRawClass()
  {
    return this._rawClass;
  }
  
  public final HierarchicType getSuperType()
  {
    return this._superType;
  }
  
  public final boolean isGeneric()
  {
    return this._genericType != null;
  }
  
  public void setSubType(HierarchicType paramHierarchicType)
  {
    this._subType = paramHierarchicType;
  }
  
  public void setSuperType(HierarchicType paramHierarchicType)
  {
    this._superType = paramHierarchicType;
  }
  
  public String toString()
  {
    if (this._genericType != null) {
      return this._genericType.toString();
    }
    return this._rawClass.getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/type/HierarchicType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */