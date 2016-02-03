package org.a.a.b;

import java.util.HashMap;
import org.a.a.c;
import org.a.a.i;
import org.a.a.j;

public final class v
  extends a
{
  private v(org.a.a.a parama, i parami)
  {
    super(parama, parami);
  }
  
  public static v a(org.a.a.a parama, i parami)
  {
    if (parama == null) {
      throw new IllegalArgumentException("Must supply a chronology");
    }
    parama = parama.b();
    if (parama == null) {
      throw new IllegalArgumentException("UTC chronology must not be null");
    }
    if (parami == null) {
      throw new IllegalArgumentException("DateTimeZone must not be null");
    }
    return new v(parama, parami);
  }
  
  private c a(c paramc, HashMap<Object, Object> paramHashMap)
  {
    if ((paramc == null) || (!paramc.c())) {
      return paramc;
    }
    if (paramHashMap.containsKey(paramc)) {
      return (c)paramHashMap.get(paramc);
    }
    w localw = new w(paramc, a(), a(paramc.d(), paramHashMap), a(paramc.e(), paramHashMap), a(paramc.f(), paramHashMap));
    paramHashMap.put(paramc, localw);
    return localw;
  }
  
  private j a(j paramj, HashMap<Object, Object> paramHashMap)
  {
    if ((paramj == null) || (!paramj.b())) {
      return paramj;
    }
    if (paramHashMap.containsKey(paramj)) {
      return (j)paramHashMap.get(paramj);
    }
    x localx = new x(paramj, a());
    paramHashMap.put(paramj, localx);
    return localx;
  }
  
  static boolean a(j paramj)
  {
    return (paramj != null) && (paramj.d() < 43200000L);
  }
  
  public org.a.a.a a(i parami)
  {
    i locali = parami;
    if (parami == null) {
      locali = i.a();
    }
    if (locali == M()) {
      return this;
    }
    if (locali == i.a) {
      return L();
    }
    return new v(L(), locali);
  }
  
  public i a()
  {
    return (i)M();
  }
  
  protected void a(b paramb)
  {
    HashMap localHashMap = new HashMap();
    paramb.l = a(paramb.l, localHashMap);
    paramb.k = a(paramb.k, localHashMap);
    paramb.j = a(paramb.j, localHashMap);
    paramb.i = a(paramb.i, localHashMap);
    paramb.h = a(paramb.h, localHashMap);
    paramb.g = a(paramb.g, localHashMap);
    paramb.f = a(paramb.f, localHashMap);
    paramb.e = a(paramb.e, localHashMap);
    paramb.d = a(paramb.d, localHashMap);
    paramb.c = a(paramb.c, localHashMap);
    paramb.b = a(paramb.b, localHashMap);
    paramb.a = a(paramb.a, localHashMap);
    paramb.E = a(paramb.E, localHashMap);
    paramb.F = a(paramb.F, localHashMap);
    paramb.G = a(paramb.G, localHashMap);
    paramb.H = a(paramb.H, localHashMap);
    paramb.I = a(paramb.I, localHashMap);
    paramb.x = a(paramb.x, localHashMap);
    paramb.y = a(paramb.y, localHashMap);
    paramb.z = a(paramb.z, localHashMap);
    paramb.D = a(paramb.D, localHashMap);
    paramb.A = a(paramb.A, localHashMap);
    paramb.B = a(paramb.B, localHashMap);
    paramb.C = a(paramb.C, localHashMap);
    paramb.m = a(paramb.m, localHashMap);
    paramb.n = a(paramb.n, localHashMap);
    paramb.o = a(paramb.o, localHashMap);
    paramb.p = a(paramb.p, localHashMap);
    paramb.q = a(paramb.q, localHashMap);
    paramb.r = a(paramb.r, localHashMap);
    paramb.s = a(paramb.s, localHashMap);
    paramb.u = a(paramb.u, localHashMap);
    paramb.t = a(paramb.t, localHashMap);
    paramb.v = a(paramb.v, localHashMap);
    paramb.w = a(paramb.w, localHashMap);
  }
  
  public org.a.a.a b()
  {
    return L();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof v)) {
        return false;
      }
      paramObject = (v)paramObject;
    } while ((L().equals(((v)paramObject).L())) && (a().equals(((v)paramObject).a())));
    return false;
  }
  
  public int hashCode()
  {
    return 326565 + a().hashCode() * 11 + L().hashCode() * 7;
  }
  
  public String toString()
  {
    return "ZonedChronology[" + L() + ", " + a().c() + ']';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */