package com.pocket.m.b;

import android.util.SparseArray;
import com.ideashower.readitlater.e.o;
import com.pocket.m.a.k;
import com.pocket.m.e.c;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class f
  extends e
  implements com.ideashower.readitlater.d.b
{
  protected com.ideashower.readitlater.g.a A;
  protected com.ideashower.readitlater.g.a B;
  private int C;
  private int D;
  protected final o f;
  protected final String g;
  protected final boolean h;
  protected String p = null;
  protected String q = null;
  protected byte[] r = null;
  protected String s = null;
  protected String t = null;
  protected boolean u = false;
  protected SparseArray v;
  protected SparseArray w;
  protected int x;
  protected String y;
  protected c z;
  
  public f(int paramInt1, int paramInt2, k paramk, o paramo, boolean paramBoolean)
  {
    super(paramInt2, paramk);
    this.f = paramo;
    this.g = paramo.i();
    this.e = paramInt1;
    this.h = paramBoolean;
    m();
  }
  
  public f(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, k paramk)
  {
    super(paramInt2, paramk);
    this.f = null;
    this.g = paramString;
    this.e = paramInt1;
    this.h = paramBoolean;
    m();
  }
  
  private void B()
  {
    if (this.z != null) {
      this.z.b();
    }
    this.z = null;
    this.A = null;
    this.B = null;
  }
  
  public SparseArray A()
  {
    return this.w;
  }
  
  public void D()
  {
    super.D();
    B();
    if (this.f != null) {
      this.f.f(false);
    }
  }
  
  protected void a()
  {
    n();
    o();
    p();
    q();
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(com.pocket.m.d.f paramf)
  {
    if (!t()) {
      return;
    }
    paramf = new com.pocket.m.d.d(this, 0, paramf.e(), paramf.f().c(), paramf.f().i(), paramf.f());
    this.B.a(paramf);
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, com.ideashower.readitlater.f.b paramb, com.pocket.m.a.a parama)
  {
    if (!t()) {}
    do
    {
      return;
      paramb = paramb.b();
    } while ((!paramBoolean) || (paramb == null));
    paramb = new com.pocket.m.d.d(this, 0, paramb, parama.c(), parama);
    this.B.a(paramb);
  }
  
  public void a(boolean paramBoolean, com.ideashower.readitlater.f.b paramb, String paramString, com.pocket.m.a.a parama)
  {
    if (!t()) {}
    do
    {
      return;
      paramb = paramb.a();
    } while ((!paramBoolean) || (paramb == null) || (parama == null) || (paramb.length() <= 0));
    paramb = new com.pocket.m.d.f(this, paramb, paramString, parama);
    this.A.a(paramb);
  }
  
  public void a(boolean paramBoolean1, com.ideashower.readitlater.f.b paramb, String paramString, boolean paramBoolean2) {}
  
  public boolean a(com.pocket.m.a.a parama, int paramInt, com.pocket.m.a.d paramd)
  {
    if (!t()) {}
    do
    {
      return false;
      if (paramd == null) {
        break;
      }
      if (((paramInt != 1) || (this.C >= 150)) && ((paramInt != 2) || (this.D >= 20))) {
        break label109;
      }
      parama = com.pocket.m.a.e.a(parama, this.h, this, paramd);
    } while (parama == null);
    this.A.a(parama);
    if (paramInt == 1) {
      this.C += 1;
    }
    for (;;)
    {
      return true;
      paramd = s();
      break;
      if (paramInt == 2) {
        this.D += 1;
      }
    }
    label109:
    com.pocket.m.a.e.a(parama, paramd);
    return false;
  }
  
  protected void b(int paramInt)
  {
    if (this.c.get()) {
      return;
    }
    this.b.set(true);
    this.c.set(true);
    switch (paramInt)
    {
    case -1: 
    case 0: 
    default: 
      this.x = -1;
      return;
    case 1: 
      this.x = 1;
      this.d = true;
      return;
    }
    this.x = -2;
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    B();
    this.q = null;
    this.r = null;
    this.v = null;
    this.w = null;
    this.a = false;
  }
  
  public abstract int l();
  
  protected void m() {}
  
  protected void n()
  {
    this.z = com.pocket.m.a.a(this.e, this);
    if (this.z != null)
    {
      this.A = this.z.c();
      this.B = this.z.d();
      this.a = true;
      if (this.f != null) {
        this.f.f(true);
      }
      return;
    }
    G();
  }
  
  protected abstract void o();
  
  protected abstract void p();
  
  protected abstract void q();
  
  protected void r()
  {
    if (this.q != null)
    {
      com.pocket.m.a.e.a(this.p, s());
      com.pocket.m.d.d locald = new com.pocket.m.d.d(this, 1, this.q, this.p, this.s, null);
      this.B.a(locald);
      return;
    }
    b(-1);
  }
  
  protected com.pocket.m.a.d s()
  {
    if (this.f != null) {}
    for (int i = this.f.e(); i > 0; i = 0) {
      return com.pocket.m.a.d.a(i);
    }
    return com.pocket.m.a.d.a();
  }
  
  protected boolean t()
  {
    return (!a_()) && (!H()) && ((!this.b.get()) || (this.u));
  }
  
  public String u()
  {
    return this.g;
  }
  
  public o v()
  {
    return this.f;
  }
  
  public int w()
  {
    return this.x;
  }
  
  public String x()
  {
    return this.y;
  }
  
  public String y()
  {
    return this.s;
  }
  
  public SparseArray z()
  {
    return this.v;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */