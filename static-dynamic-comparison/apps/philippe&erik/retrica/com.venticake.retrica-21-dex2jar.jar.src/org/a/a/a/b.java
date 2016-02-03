package org.a.a.a;

import org.a.a.c.g;
import org.joda.convert.ToString;

public abstract class b
  implements org.a.a.u
{
  public int a(org.a.a.u paramu)
  {
    if (this == paramu) {}
    long l1;
    long l2;
    do
    {
      return 0;
      l1 = paramu.a();
      l2 = a();
    } while (l2 == l1);
    if (l2 < l1) {
      return -1;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof org.a.a.u)) {
        return false;
      }
      paramObject = (org.a.a.u)paramObject;
    } while ((a() == ((org.a.a.u)paramObject).a()) && (g.a(b(), ((org.a.a.u)paramObject).b())));
    return false;
  }
  
  public int hashCode()
  {
    return (int)(a() ^ a() >>> 32) + b().hashCode();
  }
  
  @ToString
  public String toString()
  {
    return org.a.a.d.u.d().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */