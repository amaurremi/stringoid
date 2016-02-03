package com.appbrain.g;

import com.appbrain.b.g;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.o;
import com.appbrain.b.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b
  extends k
  implements d
{
  public static w a = new f();
  private static final b b;
  private int c;
  private Object d;
  private com.appbrain.b.d e;
  private com.appbrain.b.d f;
  private long g;
  private e h;
  private boolean i;
  private Object j;
  private boolean k;
  private boolean l;
  private Object m;
  private Object n;
  private Object o;
  private Object p;
  private Object q;
  private int r;
  private Object s;
  private List t;
  private List u;
  private byte v = -1;
  private int w = -1;
  
  static
  {
    b localb = new b((byte)0);
    b = localb;
    localb.R();
  }
  
  private b()
  {
    super((byte)0);
  }
  
  private b(byte paramByte) {}
  
  private b(g paramg)
  {
    R();
    int i3 = 0;
    for (;;)
    {
      int i4;
      int i5;
      int i6;
      if (i3 == 0)
      {
        i4 = i1;
        i5 = i1;
        i6 = i1;
      }
      try
      {
        i2 = paramg.a();
        switch (i2)
        {
        case 10: 
          i4 = i1;
          i5 = i1;
          i6 = i1;
          if (paramg.b(i2)) {
            continue;
          }
          i3 = 1;
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x200;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.m = paramg.e();
        }
      }
      catch (o paramg)
      {
        i2 = i4;
        try
        {
          throw paramg.a(this);
        }
        finally {}
        if ((i2 & 0x10000) == 65536) {
          this.t = Collections.unmodifiableList(this.t);
        }
        if ((i2 & 0x20000) == 131072) {
          this.u = Collections.unmodifiableList(this.u);
        }
        throw paramg;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x400;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.n = paramg.e();
      }
      catch (IOException paramg)
      {
        i2 = i5;
        throw new o(paramg.getMessage()).a(this);
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x800;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.o = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x1000;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.p = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x2000;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.q = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x4000;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.r = paramg.c();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x8000;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.s = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x1;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.d = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x2;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.e = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x8;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.g = paramg.b();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        e locale = e.a(paramg.f());
        if (locale == null) {
          continue;
        }
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x10;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.h = locale;
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x20;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.i = paramg.d();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x40;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.j = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x80;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.k = paramg.d();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x4;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.f = paramg.e();
        continue;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.c |= 0x100;
        i4 = i1;
        i5 = i1;
        i6 = i1;
        this.l = paramg.d();
        continue;
        if ((i1 & 0x10000) != 65536)
        {
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.t = new ArrayList();
          i1 |= 0x10000;
          i2 = i1;
          i4 = i1;
          i5 = i1;
        }
      }
      finally
      {
        for (;;)
        {
          try
          {
            this.t.add(Integer.valueOf(paramg.c()));
            break;
            i4 = i1;
            i5 = i1;
            i6 = i1;
            int i7 = paramg.c(paramg.g());
            if ((i1 & 0x10000) != 65536)
            {
              i4 = i1;
              i5 = i1;
              i6 = i1;
              if (paramg.h() > 0)
              {
                i4 = i1;
                i5 = i1;
                i6 = i1;
                this.t = new ArrayList();
                i1 |= 0x10000;
                i2 = i1;
                i4 = i1;
                i5 = i1;
                if (paramg.h() > 0)
                {
                  i2 = i1;
                  i4 = i1;
                  i5 = i1;
                  this.t.add(Integer.valueOf(paramg.c()));
                  continue;
                }
                i2 = i1;
                i4 = i1;
                i5 = i1;
                paramg.d(i7);
                break;
                i2 = i1;
                if ((i1 & 0x20000) != 131072)
                {
                  i4 = i1;
                  i5 = i1;
                  i6 = i1;
                  this.u = new ArrayList();
                  i2 = i1 | 0x20000;
                }
                i4 = i2;
                i5 = i2;
                i6 = i2;
                this.u.add(paramg.e());
                i1 = i2;
                break;
                if ((i1 & 0x10000) == 65536) {
                  this.t = Collections.unmodifiableList(this.t);
                }
                if ((i1 & 0x20000) == 131072) {
                  this.u = Collections.unmodifiableList(this.u);
                }
                return;
              }
            }
          }
          catch (IOException paramg)
          {
            i2 = i4;
            continue;
            continue;
            continue;
            continue;
            i3 = 1;
            break;
            paramg = finally;
            i2 = i6;
          }
          catch (o paramg)
          {
            int i2 = i5;
          }
        }
      }
    }
  }
  
  public static c H()
  {
    return c.i();
  }
  
  private com.appbrain.b.d J()
  {
    Object localObject = this.d;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.d = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  private com.appbrain.b.d K()
  {
    Object localObject = this.j;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.j = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  @Deprecated
  private com.appbrain.b.d L()
  {
    Object localObject = this.m;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.m = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  @Deprecated
  private com.appbrain.b.d M()
  {
    Object localObject = this.n;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.n = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  @Deprecated
  private com.appbrain.b.d N()
  {
    Object localObject = this.o;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.o = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  @Deprecated
  private com.appbrain.b.d O()
  {
    Object localObject = this.p;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.p = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  @Deprecated
  private com.appbrain.b.d P()
  {
    Object localObject = this.q;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.q = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  @Deprecated
  private com.appbrain.b.d Q()
  {
    Object localObject = this.s;
    if ((localObject instanceof String))
    {
      localObject = com.appbrain.b.d.a((String)localObject);
      this.s = localObject;
      return (com.appbrain.b.d)localObject;
    }
    return (com.appbrain.b.d)localObject;
  }
  
  private void R()
  {
    this.d = "";
    this.e = com.appbrain.b.d.a;
    this.f = com.appbrain.b.d.a;
    this.g = 0L;
    this.h = e.a;
    this.i = false;
    this.j = "";
    this.k = false;
    this.l = false;
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = 0;
    this.s = "";
    this.t = Collections.emptyList();
    this.u = Collections.emptyList();
  }
  
  public static b a(byte[] paramArrayOfByte)
  {
    return (b)a.a(paramArrayOfByte);
  }
  
  public static b f()
  {
    return b;
  }
  
  @Deprecated
  public final boolean A()
  {
    return (this.c & 0x1000) == 4096;
  }
  
  @Deprecated
  public final boolean B()
  {
    return (this.c & 0x2000) == 8192;
  }
  
  public final boolean C()
  {
    return (this.c & 0x4000) == 16384;
  }
  
  public final int D()
  {
    return this.r;
  }
  
  @Deprecated
  public final boolean E()
  {
    return (this.c & 0x8000) == 32768;
  }
  
  public final int F()
  {
    return this.t.size();
  }
  
  public final int G()
  {
    return this.u.size();
  }
  
  public final c I()
  {
    return c.i().a(this);
  }
  
  public final int a(int paramInt)
  {
    return ((Integer)this.t.get(paramInt)).intValue();
  }
  
  public final void a(h paramh)
  {
    int i3 = 0;
    c();
    if ((this.c & 0x200) == 512) {
      paramh.a(1, L());
    }
    if ((this.c & 0x400) == 1024) {
      paramh.a(2, M());
    }
    if ((this.c & 0x800) == 2048) {
      paramh.a(3, N());
    }
    if ((this.c & 0x1000) == 4096) {
      paramh.a(4, O());
    }
    if ((this.c & 0x2000) == 8192) {
      paramh.a(5, P());
    }
    if ((this.c & 0x4000) == 16384) {
      paramh.a(6, this.r);
    }
    if ((this.c & 0x8000) == 32768) {
      paramh.a(7, Q());
    }
    if ((this.c & 0x1) == 1) {
      paramh.a(9, J());
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(10, this.e);
    }
    if ((this.c & 0x8) == 8) {
      paramh.a(11, this.g);
    }
    if ((this.c & 0x10) == 16) {
      paramh.b(12, this.h.a());
    }
    if ((this.c & 0x20) == 32) {
      paramh.a(13, this.i);
    }
    if ((this.c & 0x40) == 64) {
      paramh.a(14, K());
    }
    if ((this.c & 0x80) == 128) {
      paramh.a(15, this.k);
    }
    if ((this.c & 0x4) == 4) {
      paramh.a(16, this.f);
    }
    if ((this.c & 0x100) == 256) {
      paramh.a(17, this.l);
    }
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.t.size()) {
        break;
      }
      paramh.a(19, ((Integer)this.t.get(i1)).intValue());
      i1 += 1;
    }
    while (i2 < this.u.size())
    {
      paramh.a(20, (com.appbrain.b.d)this.u.get(i2));
      i2 += 1;
    }
  }
  
  public final com.appbrain.b.d b(int paramInt)
  {
    return (com.appbrain.b.d)this.u.get(paramInt);
  }
  
  public final int c()
  {
    int i4 = 0;
    int i1 = this.w;
    if (i1 != -1) {
      return i1;
    }
    if ((this.c & 0x200) == 512) {}
    for (int i2 = h.b(1, L()) + 0;; i2 = 0)
    {
      i1 = i2;
      if ((this.c & 0x400) == 1024) {
        i1 = i2 + h.b(2, M());
      }
      i2 = i1;
      if ((this.c & 0x800) == 2048) {
        i2 = i1 + h.b(3, N());
      }
      i1 = i2;
      if ((this.c & 0x1000) == 4096) {
        i1 = i2 + h.b(4, O());
      }
      i2 = i1;
      if ((this.c & 0x2000) == 8192) {
        i2 = i1 + h.b(5, P());
      }
      i1 = i2;
      if ((this.c & 0x4000) == 16384) {
        i1 = i2 + h.c(6, this.r);
      }
      i2 = i1;
      if ((this.c & 0x8000) == 32768) {
        i2 = i1 + h.b(7, Q());
      }
      i1 = i2;
      if ((this.c & 0x1) == 1) {
        i1 = i2 + h.b(9, J());
      }
      i2 = i1;
      if ((this.c & 0x2) == 2) {
        i2 = i1 + h.b(10, this.e);
      }
      i1 = i2;
      if ((this.c & 0x8) == 8) {
        i1 = i2 + h.b(11, this.g);
      }
      i2 = i1;
      if ((this.c & 0x10) == 16) {
        i2 = i1 + h.d(12, this.h.a());
      }
      i1 = i2;
      boolean bool;
      if ((this.c & 0x20) == 32)
      {
        bool = this.i;
        i1 = i2 + h.a(13);
      }
      i2 = i1;
      if ((this.c & 0x40) == 64) {
        i2 = i1 + h.b(14, K());
      }
      i1 = i2;
      if ((this.c & 0x80) == 128)
      {
        bool = this.k;
        i1 = i2 + h.a(15);
      }
      i2 = i1;
      if ((this.c & 0x4) == 4) {
        i2 = i1 + h.b(16, this.f);
      }
      if ((this.c & 0x100) == 256) {
        bool = this.l;
      }
      for (i1 = i2 + h.a(17);; i1 = i2)
      {
        int i3 = 0;
        i2 = 0;
        while (i3 < this.t.size())
        {
          i2 += h.b(((Integer)this.t.get(i3)).intValue());
          i3 += 1;
        }
        int i5 = this.t.size();
        int i6;
        for (i3 = 0; i4 < this.u.size(); i3 = i6 + i3)
        {
          i6 = h.a((com.appbrain.b.d)this.u.get(i4));
          i4 += 1;
        }
        i1 = i1 + i2 + i5 * 2 + i3 + this.u.size() * 2;
        this.w = i1;
        return i1;
      }
    }
  }
  
  public final boolean e()
  {
    int i1 = this.v;
    if (i1 != -1) {
      return i1 == 1;
    }
    this.v = 1;
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
  
  public final com.appbrain.b.d i()
  {
    return this.e;
  }
  
  public final boolean j()
  {
    return (this.c & 0x4) == 4;
  }
  
  public final com.appbrain.b.d k()
  {
    return this.f;
  }
  
  public final boolean l()
  {
    return (this.c & 0x8) == 8;
  }
  
  public final long m()
  {
    return this.g;
  }
  
  public final boolean n()
  {
    return (this.c & 0x10) == 16;
  }
  
  public final e o()
  {
    return this.h;
  }
  
  public final boolean p()
  {
    return (this.c & 0x20) == 32;
  }
  
  public final boolean q()
  {
    return this.i;
  }
  
  public final boolean r()
  {
    return (this.c & 0x40) == 64;
  }
  
  public final String s()
  {
    Object localObject = this.j;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (com.appbrain.b.d)localObject;
    String str = ((com.appbrain.b.d)localObject).e();
    if (((com.appbrain.b.d)localObject).f()) {
      this.j = str;
    }
    return str;
  }
  
  public final boolean t()
  {
    return (this.c & 0x80) == 128;
  }
  
  public final boolean u()
  {
    return this.k;
  }
  
  public final boolean v()
  {
    return (this.c & 0x100) == 256;
  }
  
  public final boolean w()
  {
    return this.l;
  }
  
  @Deprecated
  public final boolean x()
  {
    return (this.c & 0x200) == 512;
  }
  
  @Deprecated
  public final boolean y()
  {
    return (this.c & 0x400) == 1024;
  }
  
  @Deprecated
  public final boolean z()
  {
    return (this.c & 0x800) == 2048;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */