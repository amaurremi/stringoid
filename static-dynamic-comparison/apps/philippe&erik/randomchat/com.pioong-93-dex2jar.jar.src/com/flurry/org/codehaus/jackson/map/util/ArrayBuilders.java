package com.flurry.org.codehaus.jackson.map.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class ArrayBuilders
{
  BooleanBuilder _booleanBuilder = null;
  ByteBuilder _byteBuilder = null;
  DoubleBuilder _doubleBuilder = null;
  FloatBuilder _floatBuilder = null;
  IntBuilder _intBuilder = null;
  LongBuilder _longBuilder = null;
  ShortBuilder _shortBuilder = null;
  
  public static <T> List<T> addToList(List<T> paramList, T paramT)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramT);
    return (List<T>)localObject;
  }
  
  public static <T> Iterable<T> arrayAsIterable(T[] paramArrayOfT)
  {
    return new ArrayIterator(paramArrayOfT);
  }
  
  public static <T> Iterator<T> arrayAsIterator(T[] paramArrayOfT)
  {
    return new ArrayIterator(paramArrayOfT);
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
  
  public static <T> T[] insertInList(T[] paramArrayOfT, T paramT)
  {
    int i = paramArrayOfT.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i + 1);
    if (i > 0) {
      System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, i);
    }
    arrayOfObject[0] = paramT;
    return arrayOfObject;
  }
  
  public static <T> T[] insertInListNoDup(T[] paramArrayOfT, T paramT)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfT[i] == paramT)
      {
        if (i == 0) {
          return paramArrayOfT;
        }
        arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
        System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, i);
        paramArrayOfT[0] = paramT;
        return arrayOfObject;
      }
      i += 1;
    }
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j + 1);
    if (j > 0) {
      System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, j);
    }
    arrayOfObject[0] = paramT;
    return arrayOfObject;
  }
  
  public BooleanBuilder getBooleanBuilder()
  {
    if (this._booleanBuilder == null) {
      this._booleanBuilder = new BooleanBuilder();
    }
    return this._booleanBuilder;
  }
  
  public ByteBuilder getByteBuilder()
  {
    if (this._byteBuilder == null) {
      this._byteBuilder = new ByteBuilder();
    }
    return this._byteBuilder;
  }
  
  public DoubleBuilder getDoubleBuilder()
  {
    if (this._doubleBuilder == null) {
      this._doubleBuilder = new DoubleBuilder();
    }
    return this._doubleBuilder;
  }
  
  public FloatBuilder getFloatBuilder()
  {
    if (this._floatBuilder == null) {
      this._floatBuilder = new FloatBuilder();
    }
    return this._floatBuilder;
  }
  
  public IntBuilder getIntBuilder()
  {
    if (this._intBuilder == null) {
      this._intBuilder = new IntBuilder();
    }
    return this._intBuilder;
  }
  
  public LongBuilder getLongBuilder()
  {
    if (this._longBuilder == null) {
      this._longBuilder = new LongBuilder();
    }
    return this._longBuilder;
  }
  
  public ShortBuilder getShortBuilder()
  {
    if (this._shortBuilder == null) {
      this._shortBuilder = new ShortBuilder();
    }
    return this._shortBuilder;
  }
  
  private static final class ArrayIterator<T>
    implements Iterator<T>, Iterable<T>
  {
    private final T[] _array;
    private int _index;
    
    public ArrayIterator(T[] paramArrayOfT)
    {
      this._array = paramArrayOfT;
      this._index = 0;
    }
    
    public boolean hasNext()
    {
      return this._index < this._array.length;
    }
    
    public Iterator<T> iterator()
    {
      return this;
    }
    
    public T next()
    {
      if (this._index >= this._array.length) {
        throw new NoSuchElementException();
      }
      Object[] arrayOfObject = this._array;
      int i = this._index;
      this._index = (i + 1);
      return (T)arrayOfObject[i];
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public static final class BooleanBuilder
    extends PrimitiveArrayBuilder<boolean[]>
  {
    public final boolean[] _constructArray(int paramInt)
    {
      return new boolean[paramInt];
    }
  }
  
  public static final class ByteBuilder
    extends PrimitiveArrayBuilder<byte[]>
  {
    public final byte[] _constructArray(int paramInt)
    {
      return new byte[paramInt];
    }
  }
  
  public static final class DoubleBuilder
    extends PrimitiveArrayBuilder<double[]>
  {
    public final double[] _constructArray(int paramInt)
    {
      return new double[paramInt];
    }
  }
  
  public static final class FloatBuilder
    extends PrimitiveArrayBuilder<float[]>
  {
    public final float[] _constructArray(int paramInt)
    {
      return new float[paramInt];
    }
  }
  
  public static final class IntBuilder
    extends PrimitiveArrayBuilder<int[]>
  {
    public final int[] _constructArray(int paramInt)
    {
      return new int[paramInt];
    }
  }
  
  public static final class LongBuilder
    extends PrimitiveArrayBuilder<long[]>
  {
    public final long[] _constructArray(int paramInt)
    {
      return new long[paramInt];
    }
  }
  
  public static final class ShortBuilder
    extends PrimitiveArrayBuilder<short[]>
  {
    public final short[] _constructArray(int paramInt)
    {
      return new short[paramInt];
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/ArrayBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */