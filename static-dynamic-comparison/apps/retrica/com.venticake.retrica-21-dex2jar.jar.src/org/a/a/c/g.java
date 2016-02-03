package org.a.a.c;

import org.a.a.c;
import org.a.a.m;

public class g
{
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    if (((paramInt1 ^ i) < 0) && ((paramInt1 ^ paramInt2) >= 0)) {
      throw new ArithmeticException("The calculation caused an overflow: " + paramInt1 + " + " + paramInt2);
    }
    return i;
  }
  
  public static int a(long paramLong)
  {
    if ((-2147483648L <= paramLong) && (paramLong <= 2147483647L)) {
      return (int)paramLong;
    }
    throw new ArithmeticException("Value cannot fit in an int: " + paramLong);
  }
  
  public static long a(long paramLong, int paramInt)
  {
    long l = paramLong;
    switch (paramInt)
    {
    default: 
      l = paramInt * paramLong;
      if (l / paramInt != paramLong) {
        throw new ArithmeticException("Multiplication overflows a long: " + paramLong + " * " + paramInt);
      }
      break;
    case -1: 
      if (paramLong == Long.MIN_VALUE) {
        throw new ArithmeticException("Multiplication overflows a long: " + paramLong + " * " + paramInt);
      }
      l = -paramLong;
    case 1: 
      return l;
    case 0: 
      return 0L;
    }
    return l;
  }
  
  public static long a(long paramLong1, long paramLong2)
  {
    long l = paramLong1 + paramLong2;
    if (((paramLong1 ^ l) < 0L) && ((paramLong1 ^ paramLong2) >= 0L)) {
      throw new ArithmeticException("The calculation caused an overflow: " + paramLong1 + " + " + paramLong2);
    }
    return l;
  }
  
  public static void a(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
      throw new m(paramc.a(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    }
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return false;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static long b(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 1L) {
      return paramLong1;
    }
    if (paramLong1 == 1L) {
      return paramLong2;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      return 0L;
    }
    long l = paramLong1 * paramLong2;
    if ((l / paramLong2 != paramLong1) || ((paramLong1 == Long.MIN_VALUE) && (paramLong2 == -1L)) || ((paramLong2 == Long.MIN_VALUE) && (paramLong1 == -1L))) {
      throw new ArithmeticException("Multiplication overflows a long: " + paramLong1 + " * " + paramLong2);
    }
    return l;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */