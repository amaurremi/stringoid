package org.a.a.c;

import org.a.a.j;
import org.a.a.k;

public class p
  extends e
{
  private final int a;
  
  public p(j paramj, k paramk, int paramInt)
  {
    super(paramj, paramk);
    if ((paramInt == 0) || (paramInt == 1)) {
      throw new IllegalArgumentException("The scalar must not be 0 or 1");
    }
    this.a = paramInt;
  }
  
  public long a(long paramLong, int paramInt)
  {
    long l1 = paramInt;
    long l2 = this.a;
    return f().a(paramLong, l1 * l2);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    paramLong2 = g.a(paramLong2, this.a);
    return f().a(paramLong1, paramLong2);
  }
  
  public long d()
  {
    return f().d() * this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof p)) {
        break;
      }
      paramObject = (p)paramObject;
    } while ((f().equals(((p)paramObject).f())) && (a() == ((p)paramObject).a()) && (this.a == ((p)paramObject).a));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    return (int)(l ^ l >>> 32) + a().hashCode() + f().hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */