package com.appbrain.e;

import com.appbrain.b.ac;
import com.appbrain.b.d;
import com.appbrain.b.g;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.o;
import com.appbrain.b.p;
import com.appbrain.b.q;
import com.appbrain.b.w;
import java.io.IOException;
import java.util.List;

public final class aj
  extends k
  implements al
{
  public static w a = new bb();
  private static final aj b;
  private int c;
  private Object d;
  private long e;
  private q f;
  private byte g = -1;
  private int h = -1;
  
  static
  {
    aj localaj = new aj((byte)0);
    b = localaj;
    localaj.k();
  }
  
  private aj()
  {
    super((byte)0);
  }
  
  private aj(byte paramByte) {}
  
  private aj(g paramg)
  {
    k();
    for (int k = 0;; k = 1)
    {
      label23:
      int m;
      int n;
      int i1;
      if (k == 0)
      {
        m = i;
        n = i;
        i1 = i;
      }
      for (;;)
      {
        try
        {
          j = paramg.a();
          switch (j)
          {
          case 10: 
            m = i;
            n = i;
            i1 = i;
            if (paramg.b(j)) {
              break label23;
            }
            k = 1;
            break label23;
            m = i;
            n = i;
            i1 = i;
            this.c |= 0x1;
            m = i;
            n = i;
            i1 = i;
            this.d = paramg.e();
            break label23;
          }
        }
        catch (o paramg)
        {
          i = m;
          try
          {
            throw paramg.a(this);
          }
          finally {}
          if ((i & 0x4) == 4) {
            this.f = new ac(this.f);
          }
          throw paramg;
          m = i;
          n = i;
          i1 = i;
          this.c |= 0x2;
          m = i;
          n = i;
          i1 = i;
          this.e = paramg.b();
          break;
        }
        catch (IOException paramg)
        {
          i = n;
          throw new o(paramg.getMessage()).a(this);
          j = i;
          if ((i & 0x4) != 4)
          {
            m = i;
            n = i;
            i1 = i;
            this.f = new p();
            j = i | 0x4;
          }
          m = j;
          n = j;
          i1 = j;
          this.f.a(paramg.e());
        }
        finally
        {
          int j;
          i = i1;
          continue;
        }
        if ((i & 0x4) == 4) {
          this.f = new ac(this.f);
        }
        return;
      }
    }
  }
  
  public static aj f()
  {
    return b;
  }
  
  private d j()
  {
    Object localObject = this.d;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.d = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  private void k()
  {
    this.d = "";
    this.e = 0L;
    this.f = p.a;
  }
  
  public final void a(h paramh)
  {
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, j());
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(2, this.e);
    }
    int i = 0;
    while (i < this.f.size())
    {
      paramh.a(3, this.f.a(i));
      i += 1;
    }
  }
  
  public final int c()
  {
    int m = 0;
    int i = this.h;
    if (i != -1) {
      return i;
    }
    if ((this.c & 0x1) == 1) {}
    for (i = h.b(1, j()) + 0;; i = 0)
    {
      int j = i;
      if ((this.c & 0x2) == 2) {
        j = i + h.b(2, this.e);
      }
      int k = 0;
      i = m;
      while (i < this.f.size())
      {
        k += h.a(this.f.a(i));
        i += 1;
      }
      i = j + k + this.f.size() * 1;
      this.h = i;
      return i;
    }
  }
  
  public final boolean e()
  {
    int i = this.g;
    if (i != -1) {
      return i == 1;
    }
    this.g = 1;
    return true;
  }
  
  public final boolean g()
  {
    return (this.c & 0x1) == 1;
  }
  
  public final boolean h()
  {
    return (this.c & 0x2) == 2;
  }
  
  public final long i()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */