package org.a.a.c;

import java.io.Serializable;
import org.a.a.j;
import org.a.a.k;

public abstract class c
  extends j
  implements Serializable
{
  private final k a;
  
  protected c(k paramk)
  {
    if (paramk == null) {
      throw new IllegalArgumentException("The type must not be null");
    }
    this.a = paramk;
  }
  
  public int a(j paramj)
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
  
  public final k a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final String e()
  {
    return this.a.m();
  }
  
  public String toString()
  {
    return "DurationField[" + e() + ']';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */