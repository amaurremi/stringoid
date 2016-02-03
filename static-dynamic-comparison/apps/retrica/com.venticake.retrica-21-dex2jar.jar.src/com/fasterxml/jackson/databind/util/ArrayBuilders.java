package com.fasterxml.jackson.databind.util;

import java.util.HashSet;
import java.util.Set;

public final class ArrayBuilders
{
  ArrayBuilders.BooleanBuilder _booleanBuilder = null;
  ArrayBuilders.ByteBuilder _byteBuilder = null;
  ArrayBuilders.DoubleBuilder _doubleBuilder = null;
  ArrayBuilders.FloatBuilder _floatBuilder = null;
  ArrayBuilders.IntBuilder _intBuilder = null;
  ArrayBuilders.LongBuilder _longBuilder = null;
  ArrayBuilders.ShortBuilder _shortBuilder = null;
  
  public static <T> Iterable<T> arrayAsIterable(T[] paramArrayOfT)
  {
    return new ArrayBuilders.ArrayIterator(paramArrayOfT);
  }
  
  public static <T> HashSet<T> arrayToSet(T[] paramArrayOfT)
  {
    HashSet localHashSet = new HashSet();
    if (paramArrayOfT != null)
    {
      int j = paramArrayOfT.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramArrayOfT[i]);
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public static <T> HashSet<T> setAndArray(Set<T> paramSet, T[] paramArrayOfT)
  {
    HashSet localHashSet = new HashSet();
    if (paramSet != null) {
      localHashSet.addAll(paramSet);
    }
    if (paramArrayOfT != null)
    {
      int j = paramArrayOfT.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramArrayOfT[i]);
        i += 1;
      }
    }
    return localHashSet;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ArrayBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */