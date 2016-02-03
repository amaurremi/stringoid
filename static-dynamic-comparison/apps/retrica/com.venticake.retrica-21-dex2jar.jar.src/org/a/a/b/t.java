package org.a.a.b;

import java.util.HashMap;
import java.util.Map;
import org.a.a.c;
import org.a.a.c.f;
import org.a.a.c.o;
import org.a.a.d;
import org.a.a.i;

public final class t
  extends a
{
  private static final t a;
  private static final t[] b;
  private static final Map<i, t> c = new HashMap();
  
  static
  {
    b = new t[64];
    a = new t(s.Z());
    c.put(i.a, a);
  }
  
  private t(org.a.a.a parama)
  {
    super(parama, null);
  }
  
  public static t N()
  {
    return a;
  }
  
  public static t O()
  {
    return b(i.a());
  }
  
  public static t b(i parami)
  {
    i locali = parami;
    if (parami == null) {
      locali = i.a();
    }
    int i = System.identityHashCode(locali) & 0x3F;
    parami = b[i];
    if ((parami != null) && (parami.a() == locali)) {
      return parami;
    }
    synchronized (c)
    {
      t localt = (t)c.get(locali);
      parami = localt;
      if (localt == null)
      {
        parami = new t(v.a(a, locali));
        c.put(locali, parami);
      }
      b[i] = parami;
      return parami;
    }
  }
  
  public org.a.a.a a(i parami)
  {
    i locali = parami;
    if (parami == null) {
      locali = i.a();
    }
    if (locali == a()) {
      return this;
    }
    return b(locali);
  }
  
  protected void a(b paramb)
  {
    if (L().a() == i.a)
    {
      paramb.H = new f(u.a, d.v(), 100);
      paramb.G = new o((f)paramb.H, d.u());
      paramb.C = new o((f)paramb.H, d.q());
      paramb.k = paramb.H.d();
    }
  }
  
  public org.a.a.a b()
  {
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return "ISO".hashCode() * 11 + a().hashCode();
  }
  
  public String toString()
  {
    String str = "ISOChronology";
    i locali = a();
    if (locali != null) {
      str = "ISOChronology" + '[' + locali.c() + ']';
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */