package com.pocket.m.b;

import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.f.b;
import com.ideashower.readitlater.f.d;
import com.pocket.m.a.k;
import com.pocket.p.q;
import java.util.concurrent.atomic.AtomicBoolean;

public class l
  extends f
{
  private String C;
  private int D;
  private com.pocket.m.a.a E;
  
  public l(int paramInt1, int paramInt2, k paramk, o paramo, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramk, paramo, paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public void a(boolean paramBoolean1, b paramb, String paramString, boolean paramBoolean2)
  {
    if (!t()) {
      return;
    }
    if ((!paramBoolean1) || (paramb == null))
    {
      if (paramBoolean2) {}
      for (int i = -2;; i = -3)
      {
        b(i);
        return;
      }
    }
    this.y = paramb.e();
    this.s = paramb.d();
    this.r = paramb.b();
    if ((paramb.g()) && (paramb.h()))
    {
      this.E = com.pocket.m.a.a.a(this.C, 1, com.pocket.m.a.l.c());
      this.p = this.E.c();
      this.D = 1;
      this.q = null;
      return;
    }
    this.E = null;
    this.p = com.pocket.m.a.l.c().b(this.f.f());
    this.D = 0;
    this.q = paramb.a();
    this.A.a(new com.pocket.m.d.c(this, this.q, paramString));
  }
  
  /* Error */
  protected void c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/pocket/m/b/l:r	[B
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 72	com/pocket/m/b/l:E	Lcom/pocket/m/a/a;
    //   13: aload_0
    //   14: invokevirtual 112	com/pocket/m/b/l:s	()Lcom/pocket/m/a/d;
    //   17: invokestatic 117	com/pocket/m/a/e:a	(Lcom/pocket/m/a/a;Lcom/pocket/m/a/d;)V
    //   20: aload_0
    //   21: getfield 120	com/pocket/m/b/l:B	Lcom/ideashower/readitlater/g/a;
    //   24: new 122	com/pocket/m/d/d
    //   27: dup
    //   28: aload_0
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 51	com/pocket/m/b/l:r	[B
    //   34: aload_0
    //   35: getfield 77	com/pocket/m/b/l:p	Ljava/lang/String;
    //   38: aconst_null
    //   39: invokespecial 125	com/pocket/m/d/d:<init>	(Lcom/pocket/m/b/f;I[BLjava/lang/String;Lcom/pocket/m/a/a;)V
    //   42: invokevirtual 109	com/ideashower/readitlater/g/a:a	(Lcom/ideashower/readitlater/g/k;)Ljava/util/concurrent/FutureTask;
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: iconst_m1
    //   51: invokevirtual 29	com/pocket/m/b/l:b	(I)V
    //   54: goto -8 -> 46
    //   57: astore_2
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	l
    //   0	62	1	paramInt	int
    //   57	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	57	finally
    //   49	54	57	finally
  }
  
  public int l()
  {
    return 2;
  }
  
  protected void n()
  {
    super.n();
    if (i()) {}
    while (this.f != null) {
      return;
    }
    G();
  }
  
  protected void o()
  {
    if (i()) {
      return;
    }
    if ((as.m()) && (!this.h)) {}
    for (this.C = q.a(this.f);; this.C = o.i(this.f.i()))
    {
      this.A.a(new com.ideashower.readitlater.f.a(new d(this.C, 0), this, false, false));
      return;
    }
  }
  
  protected void p()
  {
    if (i()) {}
    do
    {
      return;
      this.A.b();
    } while ((i()) || (this.c.get()) || (this.b.get()));
    this.b.set(true);
    if (this.D == 0) {
      r();
    }
    for (;;)
    {
      this.B.b();
      return;
      c(this.D);
    }
  }
  
  protected void q()
  {
    com.pocket.m.a.a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */