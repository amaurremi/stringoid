package org.a.a.b;

import java.util.HashMap;
import java.util.Map;
import org.a.a.a;

public final class s
  extends i
{
  private static final s a = b(org.a.a.i.a);
  private static final Map<org.a.a.i, s[]> b = new HashMap();
  
  private s(a parama, Object paramObject, int paramInt)
  {
    super(parama, paramObject, paramInt);
  }
  
  public static s Z()
  {
    return a;
  }
  
  public static s a(org.a.a.i parami, int paramInt)
  {
    org.a.a.i locali = parami;
    if (parami == null) {
      locali = org.a.a.i.a();
    }
    for (;;)
    {
      Object localObject1;
      synchronized (b)
      {
        parami = (s[])b.get(locali);
        localObject1 = parami;
        if (parami == null)
        {
          localObject1 = new s[7];
          b.put(locali, localObject1);
        }
        Object localObject2 = localObject1[(paramInt - 1)];
        parami = (org.a.a.i)localObject2;
        if (localObject2 == null)
        {
          if (locali == org.a.a.i.a)
          {
            parami = new s(null, null, paramInt);
            break label122;
          }
        }
        else {
          return parami;
        }
      }
      parami = new s(v.a(a(org.a.a.i.a, paramInt), locali), null, paramInt);
      label122:
      localObject1[(paramInt - 1)] = parami;
    }
  }
  
  public static s b(org.a.a.i parami)
  {
    return a(parami, 4);
  }
  
  int Q()
  {
    return -292275054;
  }
  
  int R()
  {
    return 292278993;
  }
  
  long T()
  {
    return 31556952000L;
  }
  
  long U()
  {
    return 15778476000L;
  }
  
  long V()
  {
    return 2629746000L;
  }
  
  long W()
  {
    return 31083597720000L;
  }
  
  public a a(org.a.a.i parami)
  {
    org.a.a.i locali = parami;
    if (parami == null) {
      locali = org.a.a.i.a();
    }
    if (locali == a()) {
      return this;
    }
    return b(locali);
  }
  
  protected void a(b paramb)
  {
    if (L() == null) {
      super.a(paramb);
    }
  }
  
  public a b()
  {
    return a;
  }
  
  boolean e(int paramInt)
  {
    return ((paramInt & 0x3) == 0) && ((paramInt % 100 != 0) || (paramInt % 400 == 0));
  }
  
  long f(int paramInt)
  {
    int i = paramInt / 100;
    if (paramInt < 0) {
      i = (i + 3 >> 2) + ((paramInt + 3 >> 2) - i) - 1;
    }
    for (;;)
    {
      return (paramInt * 365L + (i - 719527)) * 86400000L;
      int j = (i >> 2) + ((paramInt >> 2) - i);
      i = j;
      if (e(paramInt)) {
        i = j - 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */