package org.a.a.c;

import java.io.Serializable;
import org.a.a.k;

public final class j
  extends org.a.a.j
  implements Serializable
{
  public static final org.a.a.j a = new j();
  
  public int a(org.a.a.j paramj)
  {
    long l1 = paramj.d();
    long l2 = d();
    if (l2 == l1) {
      return 0;
    }
    if (l2 < l1) {
      return -1;
    }
    return 1;
  }
  
  public long a(long paramLong, int paramInt)
  {
    return g.a(paramLong, paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return g.a(paramLong1, paramLong2);
  }
  
  public k a()
  {
    return k.a();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final long d()
  {
    return 1L;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof j))
    {
      bool1 = bool2;
      if (d() == ((j)paramObject).d()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (int)d();
  }
  
  public String toString()
  {
    return "DurationField[millis]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */