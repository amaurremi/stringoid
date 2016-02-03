package com.ideashower.readitlater.reader;

import android.util.SparseArray;
import com.ideashower.readitlater.activity.aw;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.node.ObjectNode;

public class f
{
  private String a;
  private o b;
  private String c;
  private String d;
  private SparseArray e;
  private int f = -5;
  private boolean g;
  private String h;
  private long i = -1L;
  private boolean j;
  private aw k;
  private String l;
  private ObjectNode m;
  private boolean n = false;
  private boolean o = false;
  private final UiContext p;
  private boolean q;
  
  public f(o paramo, String paramString, UiContext paramUiContext)
  {
    this.b = paramo;
    if (this.b == null) {}
    for (;;)
    {
      this.a = paramString;
      this.p = paramUiContext;
      return;
      paramString = this.b.i();
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void a(SparseArray paramSparseArray)
  {
    this.e = paramSparseArray;
  }
  
  public void a(aw paramaw)
  {
    this.k = paramaw;
  }
  
  public void a(o paramo)
  {
    this.b = paramo;
  }
  
  public void a(o paramo, String paramString)
  {
    this.b = paramo;
    this.a = paramString;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(String paramString, ObjectNode paramObjectNode)
  {
    this.l = paramString;
    this.m = paramObjectNode;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public o b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
    this.n = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
    if (paramString != null) {
      a(-1);
    }
    while (this.f != -1) {
      return;
    }
    a(-2);
  }
  
  public int e(String paramString)
  {
    if (this.m == null) {
      return 0;
    }
    return l.a(this.m, paramString, 0);
  }
  
  public aw e()
  {
    return this.k;
  }
  
  public boolean f()
  {
    return this.k != null;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public SparseArray h()
  {
    return this.e;
  }
  
  public boolean i()
  {
    return this.f == -1;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public long k()
  {
    return this.i;
  }
  
  public boolean l()
  {
    return this.f == 5;
  }
  
  public boolean m()
  {
    return this.f >= 3;
  }
  
  public String n()
  {
    return this.l;
  }
  
  public void o()
  {
    if (this.f < 0) {
      return;
    }
    this.n = true;
  }
  
  public boolean p()
  {
    return this.n;
  }
  
  public UiContext q()
  {
    return this.p;
  }
  
  public void r()
  {
    this.q = true;
  }
  
  public boolean s()
  {
    return this.q;
  }
  
  public boolean t()
  {
    return this.o;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */