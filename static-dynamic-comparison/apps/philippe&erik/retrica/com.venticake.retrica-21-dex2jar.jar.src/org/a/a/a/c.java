package org.a.a.a;

import java.io.Serializable;
import org.a.a.f;
import org.a.a.i;

public abstract class c
  extends a
  implements Serializable, org.a.a.t
{
  private volatile long a;
  private volatile org.a.a.a b = b(parama);
  
  public c()
  {
    this(f.a(), org.a.a.b.t.O());
  }
  
  public c(long paramLong, org.a.a.a parama)
  {
    this.a = a(paramLong, this.b);
  }
  
  public c(long paramLong, i parami)
  {
    this(paramLong, org.a.a.b.t.b(parami));
  }
  
  public long a()
  {
    return this.a;
  }
  
  protected long a(long paramLong, org.a.a.a parama)
  {
    return paramLong;
  }
  
  protected void a(long paramLong)
  {
    this.a = a(paramLong, this.b);
  }
  
  public org.a.a.a b()
  {
    return this.b;
  }
  
  protected org.a.a.a b(org.a.a.a parama)
  {
    return f.a(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */