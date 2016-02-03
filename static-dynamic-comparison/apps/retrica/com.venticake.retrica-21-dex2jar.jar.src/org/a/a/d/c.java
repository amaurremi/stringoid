package org.a.a.d;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

public class c
{
  private ArrayList<Object> a = new ArrayList();
  private Object b;
  
  private c a(Object paramObject)
  {
    this.b = null;
    this.a.add(paramObject);
    this.a.add(paramObject);
    return this;
  }
  
  private c a(s params, p paramp)
  {
    this.b = null;
    this.a.add(params);
    this.a.add(paramp);
    return this;
  }
  
  static void a(Writer paramWriter, int paramInt)
  {
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      paramWriter.write(65533);
    }
  }
  
  static void a(StringBuffer paramStringBuffer, int paramInt)
  {
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      paramStringBuffer.append(65533);
    }
  }
  
  private boolean b(Object paramObject)
  {
    if ((paramObject instanceof s))
    {
      if ((paramObject instanceof e)) {
        return ((e)paramObject).c();
      }
      return true;
    }
    return false;
  }
  
  private boolean c(Object paramObject)
  {
    if ((paramObject instanceof p))
    {
      if ((paramObject instanceof e)) {
        return ((e)paramObject).d();
      }
      return true;
    }
    return false;
  }
  
  private Object j()
  {
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.a.size() == 2)
      {
        localObject3 = this.a.get(0);
        localObject4 = this.a.get(1);
        if (localObject3 == null) {
          break label89;
        }
        if (localObject3 != localObject4)
        {
          localObject1 = localObject2;
          if (localObject4 != null) {
            break label62;
          }
        }
      }
    }
    label62:
    label89:
    for (localObject1 = localObject3;; localObject1 = localObject4)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new e(this.a);
      }
      this.b = localObject2;
      localObject1 = localObject2;
      return localObject1;
    }
  }
  
  public b a()
  {
    Object localObject = j();
    if (b(localObject)) {}
    for (s locals = (s)localObject;; locals = null)
    {
      if (c(localObject)) {}
      for (localObject = (p)localObject;; localObject = null)
      {
        if ((locals != null) || (localObject != null)) {
          return new b(locals, (p)localObject);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
      }
    }
  }
  
  public c a(char paramChar)
  {
    return a(new d(paramChar));
  }
  
  public c a(int paramInt)
  {
    return a(org.a.a.d.c(), paramInt, 2);
  }
  
  public c a(int paramInt1, int paramInt2)
  {
    return c(org.a.a.d.d(), paramInt1, paramInt2);
  }
  
  public c a(int paramInt, boolean paramBoolean)
  {
    return a(new n(org.a.a.d.s(), paramInt, paramBoolean));
  }
  
  public c a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Literal must not be null");
    }
    c localc = this;
    switch (paramString.length())
    {
    default: 
      localc = a(new i(paramString));
    case 0: 
      return localc;
    }
    return a(new d(paramString.charAt(0)));
  }
  
  public c a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return a(new m(paramString1, paramString2, paramBoolean, paramInt1, paramInt2));
  }
  
  public c a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return a(new m(paramString, paramString, paramBoolean, paramInt1, paramInt2));
  }
  
  public c a(Map<String, org.a.a.i> paramMap)
  {
    paramMap = new l(1, paramMap);
    return a(paramMap, paramMap);
  }
  
  public c a(b paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("No formatter supplied");
    }
    return a(paramb.a(), paramb.b());
  }
  
  public c a(org.a.a.d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    return a(new j(paramd, false));
  }
  
  public c a(org.a.a.d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    int i = paramInt2;
    if (paramInt2 < paramInt1) {
      i = paramInt1;
    }
    if ((paramInt1 < 0) || (i <= 0)) {
      throw new IllegalArgumentException();
    }
    if (paramInt1 <= 1) {
      return a(new o(paramd, i, false));
    }
    return a(new h(paramd, i, false, paramInt1));
  }
  
  public c b()
  {
    return a(org.a.a.d.k());
  }
  
  public c b(int paramInt)
  {
    return a(org.a.a.d.e(), paramInt, 2);
  }
  
  public c b(int paramInt1, int paramInt2)
  {
    return b(org.a.a.d.p(), paramInt1, paramInt2);
  }
  
  public c b(int paramInt, boolean paramBoolean)
  {
    return a(new n(org.a.a.d.p(), paramInt, paramBoolean));
  }
  
  public c b(org.a.a.d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    return a(new j(paramd, true));
  }
  
  public c b(org.a.a.d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    int i = paramInt2;
    if (paramInt2 < paramInt1) {
      i = paramInt1;
    }
    if ((paramInt1 < 0) || (i <= 0)) {
      throw new IllegalArgumentException();
    }
    if (paramInt1 <= 1) {
      return a(new o(paramd, i, true));
    }
    return a(new h(paramd, i, true, paramInt1));
  }
  
  public c c()
  {
    return a(org.a.a.d.l());
  }
  
  public c c(int paramInt)
  {
    return a(org.a.a.d.g(), paramInt, 2);
  }
  
  public c c(int paramInt1, int paramInt2)
  {
    return b(org.a.a.d.s(), paramInt1, paramInt2);
  }
  
  public c c(org.a.a.d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    int i = paramInt2;
    if (paramInt2 < paramInt1) {
      i = paramInt1;
    }
    if ((paramInt1 < 0) || (i <= 0)) {
      throw new IllegalArgumentException();
    }
    return a(new f(paramd, paramInt1, i));
  }
  
  public c d()
  {
    return b(org.a.a.d.l());
  }
  
  public c d(int paramInt)
  {
    return a(org.a.a.d.h(), paramInt, 2);
  }
  
  public c d(int paramInt1, int paramInt2)
  {
    return a(org.a.a.d.t(), paramInt1, paramInt2);
  }
  
  public c e()
  {
    return a(org.a.a.d.r());
  }
  
  public c e(int paramInt)
  {
    return a(org.a.a.d.i(), paramInt, 2);
  }
  
  public c e(int paramInt1, int paramInt2)
  {
    return b(org.a.a.d.v(), paramInt1, paramInt2);
  }
  
  public c f()
  {
    return b(org.a.a.d.r());
  }
  
  public c f(int paramInt)
  {
    return a(org.a.a.d.j(), paramInt, 2);
  }
  
  public c g()
  {
    return a(org.a.a.d.w());
  }
  
  public c g(int paramInt)
  {
    return a(org.a.a.d.l(), paramInt, 1);
  }
  
  public c h()
  {
    return a(new l(0, null), null);
  }
  
  public c h(int paramInt)
  {
    return a(org.a.a.d.m(), paramInt, 2);
  }
  
  public c i()
  {
    return a(k.a, k.a);
  }
  
  public c i(int paramInt)
  {
    return a(org.a.a.d.n(), paramInt, 3);
  }
  
  public c j(int paramInt)
  {
    return a(org.a.a.d.o(), paramInt, 2);
  }
  
  public c k(int paramInt)
  {
    return a(org.a.a.d.r(), paramInt, 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */