package org.apache.a.c;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.a.c.a.b;

public class a
{
  public static final Object[] a = new Object[0];
  public static final Class[] b = new Class[0];
  public static final String[] c = new String[0];
  public static final long[] d = new long[0];
  public static final Long[] e = new Long[0];
  public static final int[] f = new int[0];
  public static final Integer[] g = new Integer[0];
  public static final short[] h = new short[0];
  public static final Short[] i = new Short[0];
  public static final byte[] j = new byte[0];
  public static final Byte[] k = new Byte[0];
  public static final double[] l = new double[0];
  public static final Double[] m = new Double[0];
  public static final float[] n = new float[0];
  public static final Float[] o = new Float[0];
  public static final boolean[] p = new boolean[0];
  public static final Boolean[] q = new Boolean[0];
  public static final char[] r = new char[0];
  public static final Character[] s = new Character[0];
  
  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt, 0);
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
    {
      paramInt2 = -1;
      return paramInt2;
    }
    int i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= paramArrayOfInt.length) {
        break label38;
      }
      paramInt2 = i1;
      if (paramInt1 == paramArrayOfInt[i1]) {
        break;
      }
      i1 += 1;
    }
    label38:
    return -1;
  }
  
  private static Object a(Object paramObject, int... paramVarArgs)
  {
    int i3 = b(paramObject);
    int i2;
    int i4;
    int i1;
    if (c(paramVarArgs))
    {
      Arrays.sort(paramVarArgs);
      i2 = paramVarArgs.length;
      i4 = i3;
      i1 = 0;
      for (;;)
      {
        i2 -= 1;
        i5 = i1;
        if (i2 < 0) {
          break;
        }
        i5 = paramVarArgs[i2];
        if ((i5 < 0) || (i5 >= i3)) {
          throw new IndexOutOfBoundsException("Index: " + i5 + ", Length: " + i3);
        }
        if (i5 < i4)
        {
          i1 += 1;
          i4 = i5;
        }
      }
    }
    int i5 = 0;
    Object localObject = Array.newInstance(paramObject.getClass().getComponentType(), i3 - i5);
    if (i5 < i3)
    {
      i1 = paramVarArgs.length;
      i2 = i3 - i5;
      i1 -= 1;
      while (i1 >= 0)
      {
        i5 = paramVarArgs[i1];
        i4 = i2;
        if (i3 - i5 > 1)
        {
          i3 = i3 - i5 - 1;
          i4 = i2 - i3;
          System.arraycopy(paramObject, i5 + 1, localObject, i4, i3);
        }
        i1 -= 1;
        i3 = i5;
        i2 = i4;
      }
      if (i3 > 0) {
        System.arraycopy(paramObject, 0, localObject, 0, i3);
      }
    }
    return localObject;
  }
  
  public static String a(Object paramObject)
  {
    return a(paramObject, "{}");
  }
  
  public static String a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return new org.apache.a.c.a.a(paramObject, b.e).a(paramObject).toString();
  }
  
  public static boolean a(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
  }
  
  private static int[] a(HashSet paramHashSet)
  {
    int[] arrayOfInt = new int[paramHashSet.size()];
    paramHashSet = paramHashSet.iterator();
    int i1 = 0;
    while (paramHashSet.hasNext())
    {
      arrayOfInt[i1] = ((Integer)paramHashSet.next()).intValue();
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    return (int[])paramArrayOfInt.clone();
  }
  
  public static int[] a(int[] paramArrayOfInt1, int... paramVarArgs)
  {
    return (int[])a(paramArrayOfInt1, a(paramVarArgs));
  }
  
  public static Object[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    return (Object[])paramArrayOfObject.clone();
  }
  
  public static Object[] a(Object[] paramArrayOfObject1, Object... paramVarArgs)
  {
    if (paramArrayOfObject1 == null) {
      return a(paramVarArgs);
    }
    if (paramVarArgs == null) {
      return a(paramArrayOfObject1);
    }
    Class localClass = paramArrayOfObject1.getClass().getComponentType();
    Object[] arrayOfObject = (Object[])Array.newInstance(localClass, paramArrayOfObject1.length + paramVarArgs.length);
    System.arraycopy(paramArrayOfObject1, 0, arrayOfObject, 0, paramArrayOfObject1.length);
    try
    {
      System.arraycopy(paramVarArgs, 0, arrayOfObject, paramArrayOfObject1.length, paramVarArgs.length);
      return arrayOfObject;
    }
    catch (ArrayStoreException paramArrayOfObject1)
    {
      paramVarArgs = paramVarArgs.getClass().getComponentType();
      if (!localClass.isAssignableFrom(paramVarArgs)) {
        throw new IllegalArgumentException("Cannot store " + paramVarArgs.getName() + " in an array of " + localClass.getName(), paramArrayOfObject1);
      }
      throw paramArrayOfObject1;
    }
  }
  
  public static int b(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return Array.getLength(paramObject);
  }
  
  public static boolean b(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static boolean b(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt) != -1;
  }
  
  public static int[] b(int[] paramArrayOfInt1, int... paramVarArgs)
  {
    if ((b(paramArrayOfInt1)) || (b(paramVarArgs))) {
      return a(paramArrayOfInt1);
    }
    Object localObject1 = new HashMap(paramVarArgs.length);
    int i2 = paramVarArgs.length;
    int i1 = 0;
    Object localObject2;
    Object localObject3;
    if (i1 < i2)
    {
      localObject2 = Integer.valueOf(paramVarArgs[i1]);
      localObject3 = (org.apache.a.c.e.a)((HashMap)localObject1).get(localObject2);
      if (localObject3 == null) {
        ((HashMap)localObject1).put(localObject2, new org.apache.a.c.e.a(1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((org.apache.a.c.e.a)localObject3).a();
      }
    }
    paramVarArgs = new HashSet();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    label212:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Integer)((Map.Entry)localObject2).getKey();
      int i3 = ((org.apache.a.c.e.a)((Map.Entry)localObject2).getValue()).intValue();
      i1 = 0;
      i2 = 0;
      for (;;)
      {
        if (i1 >= i3) {
          break label212;
        }
        int i4 = a(paramArrayOfInt1, ((Integer)localObject3).intValue(), i2);
        if (i4 < 0) {
          break;
        }
        i2 = i4 + 1;
        paramVarArgs.add(Integer.valueOf(i4));
        i1 += 1;
      }
    }
    return a(paramArrayOfInt1, a(paramVarArgs));
  }
  
  public static boolean c(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length != 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */