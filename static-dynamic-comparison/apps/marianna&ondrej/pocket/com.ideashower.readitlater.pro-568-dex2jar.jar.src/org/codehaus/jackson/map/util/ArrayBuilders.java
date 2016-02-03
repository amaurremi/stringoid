package org.codehaus.jackson.map.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class ArrayBuilders
{
  ArrayBuilders.BooleanBuilder _booleanBuilder = null;
  ArrayBuilders.ByteBuilder _byteBuilder = null;
  ArrayBuilders.DoubleBuilder _doubleBuilder = null;
  ArrayBuilders.FloatBuilder _floatBuilder = null;
  ArrayBuilders.IntBuilder _intBuilder = null;
  ArrayBuilders.LongBuilder _longBuilder = null;
  ArrayBuilders.ShortBuilder _shortBuilder = null;
  
  public static List addToList(List paramList, Object paramObject)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramObject);
    return (List)localObject;
  }
  
  public static Iterable arrayAsIterable(Object[] paramArrayOfObject)
  {
    return new ArrayBuilders.ArrayIterator(paramArrayOfObject);
  }
  
  public static Iterator arrayAsIterator(Object[] paramArrayOfObject)
  {
    return new ArrayBuilders.ArrayIterator(paramArrayOfObject);
  }
  
  public static HashSet arrayToSet(Object[] paramArrayOfObject)
  {
    HashSet localHashSet = new HashSet();
    if (paramArrayOfObject != null)
    {
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramArrayOfObject[i]);
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public static Object[] insertInList(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = paramArrayOfObject.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i + 1);
    if (i > 0) {
      System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 1, i);
    }
    arrayOfObject[0] = paramObject;
    return arrayOfObject;
  }
  
  public static Object[] insertInListNoDup(Object[] paramArrayOfObject, Object paramObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfObject[i] == paramObject)
      {
        if (i == 0) {
          return paramArrayOfObject;
        }
        arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
        System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 1, i);
        paramArrayOfObject[0] = paramObject;
        return arrayOfObject;
      }
      i += 1;
    }
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j + 1);
    if (j > 0) {
      System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 1, j);
    }
    arrayOfObject[0] = paramObject;
    return arrayOfObject;
  }
  
  public ArrayBuilders.BooleanBuilder getBooleanBuilder()
  {
    if (this._booleanBuilder == null) {
      this._booleanBuilder = new ArrayBuilders.BooleanBuilder();
    }
    return this._booleanBuilder;
  }
  
  public ArrayBuilders.ByteBuilder getByteBuilder()
  {
    if (this._byteBuilder == null) {
      this._byteBuilder = new ArrayBuilders.ByteBuilder();
    }
    return this._byteBuilder;
  }
  
  public ArrayBuilders.DoubleBuilder getDoubleBuilder()
  {
    if (this._doubleBuilder == null) {
      this._doubleBuilder = new ArrayBuilders.DoubleBuilder();
    }
    return this._doubleBuilder;
  }
  
  public ArrayBuilders.FloatBuilder getFloatBuilder()
  {
    if (this._floatBuilder == null) {
      this._floatBuilder = new ArrayBuilders.FloatBuilder();
    }
    return this._floatBuilder;
  }
  
  public ArrayBuilders.IntBuilder getIntBuilder()
  {
    if (this._intBuilder == null) {
      this._intBuilder = new ArrayBuilders.IntBuilder();
    }
    return this._intBuilder;
  }
  
  public ArrayBuilders.LongBuilder getLongBuilder()
  {
    if (this._longBuilder == null) {
      this._longBuilder = new ArrayBuilders.LongBuilder();
    }
    return this._longBuilder;
  }
  
  public ArrayBuilders.ShortBuilder getShortBuilder()
  {
    if (this._shortBuilder == null) {
      this._shortBuilder = new ArrayBuilders.ShortBuilder();
    }
    return this._shortBuilder;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/ArrayBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */