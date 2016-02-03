package org.a.a;

import java.io.Serializable;
import org.a.a.a.c;

public final class b
  extends c
  implements Serializable, t
{
  public b() {}
  
  public b(long paramLong, a parama)
  {
    super(paramLong, parama);
  }
  
  public b a(a parama)
  {
    parama = f.a(parama);
    if (parama == b()) {
      return this;
    }
    return new b(a(), parama);
  }
  
  public b a(i parami)
  {
    return a(b().a(parami));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */