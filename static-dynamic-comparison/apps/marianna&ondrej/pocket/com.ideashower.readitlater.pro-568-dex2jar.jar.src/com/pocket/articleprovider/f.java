package com.pocket.articleprovider;

import android.content.Context;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.db.operation.action.m;
import com.ideashower.readitlater.db.operation.action.w;
import com.ideashower.readitlater.db.operation.action.x;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.i.c;
import com.pocket.c.am;
import java.util.ArrayList;
import java.util.Iterator;

public class f
{
  private static ArrayList a;
  private final a b;
  private final b c;
  private final Context d;
  private com.pocket.tts.i e;
  private com.pocket.tts.h f;
  private com.pocket.f.a g;
  private final h h;
  private final com.ideashower.readitlater.i.e i;
  private final i j;
  private j k;
  
  private f(Context paramContext, a parama, j paramj)
  {
    if (parama == null) {
      throw new NullPointerException("consumer may not be null");
    }
    this.d = paramContext;
    this.b = parama;
    this.k = paramj;
    this.c = new b(parama);
    this.e = new g(this, null);
    this.h = new h(this, null);
    this.j = new i(this, null);
    this.i = new com.ideashower.readitlater.i.e()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        f.a(f.this).a(paramAnonymousBoolean);
      }
    };
    com.pocket.tts.h.a(paramContext, this.e);
    c.a(this.j);
    c.a(this.i);
  }
  
  public static com.pocket.f.a a(o paramo)
  {
    Object localObject = paramo.ab();
    String str1 = paramo.i();
    int m = paramo.f();
    long l = paramo.u();
    String str2 = paramo.q();
    String str3 = paramo.o();
    int n = paramo.H();
    boolean bool2;
    boolean bool3;
    if (localObject != null)
    {
      localObject = ((com.pocket.m.a.a)localObject).e();
      bool2 = paramo.ae();
      bool3 = paramo.R();
      if (paramo.al() != 0) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = true;; bool1 = false)
    {
      return new com.pocket.f.a(str1, m, l, str2, str3, n, (String)localObject, bool2, bool3, bool1);
      localObject = null;
      break;
    }
  }
  
  public static ArrayList a(com.ideashower.readitlater.objects.h paramh)
  {
    ArrayList localArrayList = new ArrayList(paramh.size());
    paramh = paramh.iterator();
    while (paramh.hasNext()) {
      localArrayList.add(a((o)paramh.next()));
    }
    return localArrayList;
  }
  
  public static void a(final Context paramContext, final a parama, j paramj)
  {
    if (!as.l())
    {
      paramj.a(-4);
      return;
    }
    if (!com.pocket.c.e.c(true))
    {
      paramj.a();
      paramContext = new am()
      {
        public void a() {}
        
        public void a(float paramAnonymousFloat) {}
        
        public void b() {}
        
        public void c()
        {
          f.h().remove(this);
          com.pocket.c.e.b(this);
          f.this.b();
        }
        
        public void d()
        {
          f.h().remove(this);
          f.a(paramContext, parama, f.this);
        }
      };
      if (a == null) {
        a = new ArrayList();
      }
      a.add(paramContext);
      com.pocket.c.e.a(paramContext);
      return;
    }
    new f(paramContext, parama, paramj);
  }
  
  private void i()
  {
    if (this.e == null) {
      throw new RuntimeException("Provider has been shutdown");
    }
    if (!com.ideashower.readitlater.a.g.q()) {
      throw new RuntimeException("May only be invoked from the main/UI thread");
    }
  }
  
  public void a()
  {
    i();
    com.pocket.tts.h.b(this.d, this.e);
    c.b(this.j);
    c.b(this.i);
    this.e = null;
  }
  
  public void a(int paramInt)
  {
    i();
    this.f.b(-1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    i();
    this.c.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    i();
    this.c.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString)
  {
    i();
    if ((this.g == null) || (!org.apache.a.c.k.a(this.g.a(), paramString))) {
      this.f.a(paramString);
    }
    this.f.f();
    new w(x.a, paramString, this.b.d()).j();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    i();
    Object localObject;
    if (paramInt1 == 0)
    {
      localObject = new com.pocket.k.e(true, paramInt2);
      if (paramInt3 <= 0) {
        break label113;
      }
    }
    label113:
    for (com.pocket.m.a.d locald = com.pocket.m.a.d.a(paramInt3);; locald = com.pocket.m.a.d.a())
    {
      paramString = com.ideashower.readitlater.f.f.a(paramString, (com.pocket.k.a)localObject, locald).a(paramInt3).a("quality", paramInt4).a(true, com.pocket.m.a.k.a).a(this.h, true, false);
      this.h.b(paramString.a());
      return;
      if (paramInt2 == 0)
      {
        localObject = new com.pocket.k.f(true, paramInt1);
        break;
      }
      localObject = new com.pocket.k.d(paramInt1, paramInt2);
      break;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    i();
    new m(paramBoolean, paramString, this.b.d()).j();
  }
  
  public com.pocket.f.a b()
  {
    i();
    if ((this.f != null) && ((this.f.i()) || (this.f.j()))) {
      return this.g;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    i();
    new com.ideashower.readitlater.db.operation.action.i(paramString, this.b.d()).j();
  }
  
  public boolean c()
  {
    if ((this.f != null) && ((this.f.i()) || (this.f.j()))) {
      return com.pocket.tts.h.a();
    }
    return false;
  }
  
  public float d()
  {
    i();
    return this.f.k();
  }
  
  public boolean e()
  {
    return com.ideashower.readitlater.a.g.k();
  }
  
  public void f()
  {
    i();
    this.f.h();
    if (this.g != null) {
      new w(x.b, this.g.a(), this.b.d()).j();
    }
  }
  
  public void g()
  {
    a(-1);
    if (this.g != null) {
      new w(x.c, this.g.a(), this.b.d()).j();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */