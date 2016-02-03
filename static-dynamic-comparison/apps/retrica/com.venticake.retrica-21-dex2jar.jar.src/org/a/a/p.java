package org.a.a;

import java.io.Serializable;
import org.a.a.d.b;
import org.a.a.d.u;
import org.joda.convert.ToString;

public class p
  extends org.a.a.a.c
  implements Serializable, Cloneable, r
{
  private c a;
  private int b;
  
  public p() {}
  
  public p(long paramLong, i parami)
  {
    super(paramLong, parami);
  }
  
  public q a(d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    c localc = paramd.a(b());
    if (!localc.c()) {
      throw new IllegalArgumentException("Field '" + paramd + "' is not supported");
    }
    return new q(this, localc);
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    switch (this.b)
    {
    default: 
      l = paramLong;
    }
    for (;;)
    {
      super.a(l);
      return;
      l = this.a.d(paramLong);
      continue;
      l = this.a.e(paramLong);
      continue;
      l = this.a.f(paramLong);
      continue;
      l = this.a.g(paramLong);
      continue;
      l = this.a.h(paramLong);
    }
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError("Clone error");
    }
  }
  
  @ToString
  public String toString()
  {
    return u.d().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */