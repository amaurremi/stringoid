package com.appbrain.g;

import com.appbrain.b.d;
import com.appbrain.b.e;
import com.appbrain.b.g;
import com.appbrain.b.g.a;
import com.appbrain.b.h.a;
import com.appbrain.b.i;
import com.appbrain.b.n;
import com.appbrain.b.o;
import com.appbrain.b.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  public static final class a
    extends g
    implements a.b
  {
    public static o a = new b();
    private static final a b;
    private int c;
    private Object d;
    private com.appbrain.b.c e;
    private com.appbrain.b.c f;
    private long g;
    private a.c h;
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
      a locala = new a((byte)0);
      b = locala;
      locala.R();
    }
    
    private a()
    {
      super();
    }
    
    private a(byte paramByte) {}
    
    private a(d paramd)
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
          i2 = paramd.a();
          switch (i2)
          {
          case 10: 
            i4 = i1;
            i5 = i1;
            i6 = i1;
            if (paramd.b(i2)) {
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
            this.m = paramd.e();
          }
        }
        catch (i paramd)
        {
          i2 = i4;
          try
          {
            throw paramd.a(this);
          }
          finally {}
          if ((i2 & 0x10000) == 65536) {
            this.t = Collections.unmodifiableList(this.t);
          }
          if ((i2 & 0x20000) == 131072) {
            this.u = Collections.unmodifiableList(this.u);
          }
          throw paramd;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x400;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.n = paramd.e();
        }
        catch (IOException paramd)
        {
          i2 = i5;
          throw new i(paramd.getMessage()).a(this);
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x800;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.o = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x1000;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.p = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x2000;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.q = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x4000;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.r = paramd.c();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x8000;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.s = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x1;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.d = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x2;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.e = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x8;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.g = paramd.b();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          a.c localc = a.c.a(paramd.f());
          if (localc == null) {
            continue;
          }
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x10;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.h = localc;
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x20;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.i = paramd.d();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x40;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.j = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x80;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.k = paramd.d();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x4;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.f = paramd.e();
          continue;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.c |= 0x100;
          i4 = i1;
          i5 = i1;
          i6 = i1;
          this.l = paramd.d();
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
              this.t.add(Integer.valueOf(paramd.c()));
              break;
              i4 = i1;
              i5 = i1;
              i6 = i1;
              int i7 = paramd.c(paramd.g());
              if ((i1 & 0x10000) != 65536)
              {
                i4 = i1;
                i5 = i1;
                i6 = i1;
                if (paramd.h() > 0)
                {
                  i4 = i1;
                  i5 = i1;
                  i6 = i1;
                  this.t = new ArrayList();
                  i1 |= 0x10000;
                  i2 = i1;
                  i4 = i1;
                  i5 = i1;
                  if (paramd.h() > 0)
                  {
                    i2 = i1;
                    i4 = i1;
                    i5 = i1;
                    this.t.add(Integer.valueOf(paramd.c()));
                    continue;
                  }
                  i2 = i1;
                  i4 = i1;
                  i5 = i1;
                  paramd.d(i7);
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
                  this.u.add(paramd.e());
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
            catch (IOException paramd)
            {
              i2 = i4;
              continue;
              continue;
              continue;
              continue;
              i3 = 1;
              break;
              paramd = finally;
              i2 = i6;
            }
            catch (i paramd)
            {
              int i2 = i5;
            }
          }
        }
      }
    }
    
    public static a H()
    {
      return a.k();
    }
    
    private com.appbrain.b.c J()
    {
      Object localObject = this.d;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.d = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    private com.appbrain.b.c K()
    {
      Object localObject = this.j;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.j = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    @Deprecated
    private com.appbrain.b.c L()
    {
      Object localObject = this.m;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.m = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    @Deprecated
    private com.appbrain.b.c M()
    {
      Object localObject = this.n;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.n = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    @Deprecated
    private com.appbrain.b.c N()
    {
      Object localObject = this.o;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.o = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    @Deprecated
    private com.appbrain.b.c O()
    {
      Object localObject = this.p;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.p = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    @Deprecated
    private com.appbrain.b.c P()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.q = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    @Deprecated
    private com.appbrain.b.c Q()
    {
      Object localObject = this.s;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.s = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    private void R()
    {
      this.d = "";
      this.e = com.appbrain.b.c.a;
      this.f = com.appbrain.b.c.a;
      this.g = 0L;
      this.h = a.c.a;
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
    
    public static a a(byte[] paramArrayOfByte)
    {
      return (a)a.a(paramArrayOfByte);
    }
    
    public static a f()
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
    
    public final a I()
    {
      return a.k().a(this);
    }
    
    public final int a(int paramInt)
    {
      return ((Integer)this.t.get(paramInt)).intValue();
    }
    
    public final void a(e parame)
    {
      int i3 = 0;
      c();
      if ((this.c & 0x200) == 512) {
        parame.a(1, L());
      }
      if ((this.c & 0x400) == 1024) {
        parame.a(2, M());
      }
      if ((this.c & 0x800) == 2048) {
        parame.a(3, N());
      }
      if ((this.c & 0x1000) == 4096) {
        parame.a(4, O());
      }
      if ((this.c & 0x2000) == 8192) {
        parame.a(5, P());
      }
      if ((this.c & 0x4000) == 16384) {
        parame.a(6, this.r);
      }
      if ((this.c & 0x8000) == 32768) {
        parame.a(7, Q());
      }
      if ((this.c & 0x1) == 1) {
        parame.a(9, J());
      }
      if ((this.c & 0x2) == 2) {
        parame.a(10, this.e);
      }
      if ((this.c & 0x8) == 8) {
        parame.a(11, this.g);
      }
      if ((this.c & 0x10) == 16) {
        parame.b(12, this.h.a());
      }
      if ((this.c & 0x20) == 32) {
        parame.a(13, this.i);
      }
      if ((this.c & 0x40) == 64) {
        parame.a(14, K());
      }
      if ((this.c & 0x80) == 128) {
        parame.a(15, this.k);
      }
      if ((this.c & 0x4) == 4) {
        parame.a(16, this.f);
      }
      if ((this.c & 0x100) == 256) {
        parame.a(17, this.l);
      }
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.t.size()) {
          break;
        }
        parame.a(19, ((Integer)this.t.get(i1)).intValue());
        i1 += 1;
      }
      while (i2 < this.u.size())
      {
        parame.a(20, (com.appbrain.b.c)this.u.get(i2));
        i2 += 1;
      }
    }
    
    public final com.appbrain.b.c b(int paramInt)
    {
      return (com.appbrain.b.c)this.u.get(paramInt);
    }
    
    public final int c()
    {
      int i4 = 0;
      int i1 = this.w;
      if (i1 != -1) {
        return i1;
      }
      if ((this.c & 0x200) == 512) {}
      for (int i2 = e.b(1, L()) + 0;; i2 = 0)
      {
        i1 = i2;
        if ((this.c & 0x400) == 1024) {
          i1 = i2 + e.b(2, M());
        }
        i2 = i1;
        if ((this.c & 0x800) == 2048) {
          i2 = i1 + e.b(3, N());
        }
        i1 = i2;
        if ((this.c & 0x1000) == 4096) {
          i1 = i2 + e.b(4, O());
        }
        i2 = i1;
        if ((this.c & 0x2000) == 8192) {
          i2 = i1 + e.b(5, P());
        }
        i1 = i2;
        if ((this.c & 0x4000) == 16384) {
          i1 = i2 + e.c(6, this.r);
        }
        i2 = i1;
        if ((this.c & 0x8000) == 32768) {
          i2 = i1 + e.b(7, Q());
        }
        i1 = i2;
        if ((this.c & 0x1) == 1) {
          i1 = i2 + e.b(9, J());
        }
        i2 = i1;
        if ((this.c & 0x2) == 2) {
          i2 = i1 + e.b(10, this.e);
        }
        i1 = i2;
        if ((this.c & 0x8) == 8) {
          i1 = i2 + e.b(11, this.g);
        }
        i2 = i1;
        if ((this.c & 0x10) == 16) {
          i2 = i1 + e.d(12, this.h.a());
        }
        i1 = i2;
        boolean bool;
        if ((this.c & 0x20) == 32)
        {
          bool = this.i;
          i1 = i2 + e.a(13);
        }
        i2 = i1;
        if ((this.c & 0x40) == 64) {
          i2 = i1 + e.b(14, K());
        }
        i1 = i2;
        if ((this.c & 0x80) == 128)
        {
          bool = this.k;
          i1 = i2 + e.a(15);
        }
        i2 = i1;
        if ((this.c & 0x4) == 4) {
          i2 = i1 + e.b(16, this.f);
        }
        if ((this.c & 0x100) == 256) {
          bool = this.l;
        }
        for (i1 = i2 + e.a(17);; i1 = i2)
        {
          int i3 = 0;
          i2 = 0;
          while (i3 < this.t.size())
          {
            i2 += e.b(((Integer)this.t.get(i3)).intValue());
            i3 += 1;
          }
          int i5 = this.t.size();
          int i6;
          for (i3 = 0; i4 < this.u.size(); i3 = i6 + i3)
          {
            i6 = e.a((com.appbrain.b.c)this.u.get(i4));
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
    
    public final com.appbrain.b.c i()
    {
      return this.e;
    }
    
    public final boolean j()
    {
      return (this.c & 0x4) == 4;
    }
    
    public final com.appbrain.b.c k()
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
    
    public final a.c o()
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
      localObject = (com.appbrain.b.c)localObject;
      String str = ((com.appbrain.b.c)localObject).d();
      if (((com.appbrain.b.c)localObject).e()) {
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
    
    public static final class a
      extends g.a
      implements a.b
    {
      private int a;
      private Object b = "";
      private com.appbrain.b.c c = com.appbrain.b.c.a;
      private com.appbrain.b.c d = com.appbrain.b.c.a;
      private long e;
      private a.c f = a.c.a;
      private boolean g;
      private Object h = "";
      private boolean i;
      private boolean j;
      private Object k = "";
      private Object l = "";
      private Object m = "";
      private Object n = "";
      private Object o = "";
      private int p;
      private Object q = "";
      private List r = Collections.emptyList();
      private List s = Collections.emptyList();
      
      private a.a l()
      {
        int i2 = 1;
        a.a locala = new a.a('\000');
        int i3 = this.a;
        if ((i3 & 0x1) == 1) {}
        for (;;)
        {
          a.a.a(locala, this.b);
          int i1 = i2;
          if ((i3 & 0x2) == 2) {
            i1 = i2 | 0x2;
          }
          a.a.a(locala, this.c);
          i2 = i1;
          if ((i3 & 0x4) == 4) {
            i2 = i1 | 0x4;
          }
          a.a.b(locala, this.d);
          i1 = i2;
          if ((i3 & 0x8) == 8) {
            i1 = i2 | 0x8;
          }
          a.a.a(locala, this.e);
          i2 = i1;
          if ((i3 & 0x10) == 16) {
            i2 = i1 | 0x10;
          }
          a.a.a(locala, this.f);
          i1 = i2;
          if ((i3 & 0x20) == 32) {
            i1 = i2 | 0x20;
          }
          a.a.a(locala, this.g);
          i2 = i1;
          if ((i3 & 0x40) == 64) {
            i2 = i1 | 0x40;
          }
          a.a.b(locala, this.h);
          i1 = i2;
          if ((i3 & 0x80) == 128) {
            i1 = i2 | 0x80;
          }
          a.a.b(locala, this.i);
          i2 = i1;
          if ((i3 & 0x100) == 256) {
            i2 = i1 | 0x100;
          }
          a.a.c(locala, this.j);
          i1 = i2;
          if ((i3 & 0x200) == 512) {
            i1 = i2 | 0x200;
          }
          a.a.c(locala, this.k);
          i2 = i1;
          if ((i3 & 0x400) == 1024) {
            i2 = i1 | 0x400;
          }
          a.a.d(locala, this.l);
          i1 = i2;
          if ((i3 & 0x800) == 2048) {
            i1 = i2 | 0x800;
          }
          a.a.e(locala, this.m);
          i2 = i1;
          if ((i3 & 0x1000) == 4096) {
            i2 = i1 | 0x1000;
          }
          a.a.f(locala, this.n);
          i1 = i2;
          if ((i3 & 0x2000) == 8192) {
            i1 = i2 | 0x2000;
          }
          a.a.g(locala, this.o);
          i2 = i1;
          if ((i3 & 0x4000) == 16384) {
            i2 = i1 | 0x4000;
          }
          a.a.a(locala, this.p);
          i1 = i2;
          if ((i3 & 0x8000) == 32768) {
            i1 = i2 | 0x8000;
          }
          a.a.h(locala, this.q);
          if ((this.a & 0x10000) == 65536)
          {
            this.r = Collections.unmodifiableList(this.r);
            this.a &= 0xFFFEFFFF;
          }
          a.a.a(locala, this.r);
          if ((this.a & 0x20000) == 131072)
          {
            this.s = Collections.unmodifiableList(this.s);
            this.a &= 0xFFFDFFFF;
          }
          a.a.b(locala, this.s);
          a.a.b(locala, i1);
          return locala;
          i2 = 0;
        }
      }
      
      private void m()
      {
        if ((this.a & 0x10000) != 65536)
        {
          this.r = new ArrayList(this.r);
          this.a |= 0x10000;
        }
      }
      
      private void n()
      {
        if ((this.a & 0x20000) != 131072)
        {
          this.s = new ArrayList(this.s);
          this.a |= 0x20000;
        }
      }
      
      public final a a(int paramInt)
      {
        this.a |= 0x4000;
        this.p = paramInt;
        return this;
      }
      
      public final a a(long paramLong)
      {
        this.a |= 0x8;
        this.e = paramLong;
        return this;
      }
      
      public final a a(com.appbrain.b.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.a |= 0x2;
        this.c = paramc;
        return this;
      }
      
      public final a a(a.a parama)
      {
        if (parama == a.a.f()) {}
        for (;;)
        {
          return this;
          if (parama.g())
          {
            this.a |= 0x1;
            this.b = a.a.a(parama);
          }
          if (parama.h()) {
            a(parama.i());
          }
          if (parama.j())
          {
            com.appbrain.b.c localc = parama.k();
            if (localc == null) {
              throw new NullPointerException();
            }
            this.a |= 0x4;
            this.d = localc;
          }
          if (parama.l()) {
            a(parama.m());
          }
          if (parama.n()) {
            a(parama.o());
          }
          boolean bool;
          if (parama.p())
          {
            bool = parama.q();
            this.a |= 0x20;
            this.g = bool;
          }
          if (parama.r())
          {
            this.a |= 0x40;
            this.h = a.a.b(parama);
          }
          if (parama.t())
          {
            bool = parama.u();
            this.a |= 0x80;
            this.i = bool;
          }
          if (parama.v())
          {
            bool = parama.w();
            this.a |= 0x100;
            this.j = bool;
          }
          if (parama.x())
          {
            this.a |= 0x200;
            this.k = a.a.c(parama);
          }
          if (parama.y())
          {
            this.a |= 0x400;
            this.l = a.a.d(parama);
          }
          if (parama.z())
          {
            this.a |= 0x800;
            this.m = a.a.e(parama);
          }
          if (parama.A())
          {
            this.a |= 0x1000;
            this.n = a.a.f(parama);
          }
          if (parama.B())
          {
            this.a |= 0x2000;
            this.o = a.a.g(parama);
          }
          if (parama.C()) {
            a(parama.D());
          }
          if (parama.E())
          {
            this.a |= 0x8000;
            this.q = a.a.h(parama);
          }
          if (!a.a.i(parama).isEmpty())
          {
            if (!this.r.isEmpty()) {
              break label498;
            }
            this.r = a.a.i(parama);
            this.a &= 0xFFFEFFFF;
          }
          while (!a.a.j(parama).isEmpty())
          {
            if (!this.s.isEmpty()) {
              break label519;
            }
            this.s = a.a.j(parama);
            this.a &= 0xFFFDFFFF;
            return this;
            label498:
            m();
            this.r.addAll(a.a.i(parama));
          }
        }
        label519:
        n();
        this.s.addAll(a.a.j(parama));
        return this;
      }
      
      public final a a(a.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.a |= 0x10;
        this.f = paramc;
        return this;
      }
      
      public final a a(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = paramString;
        return this;
      }
      
      public final a b(int paramInt)
      {
        m();
        this.r.add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final a b(com.appbrain.b.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        n();
        this.s.add(paramc);
        return this;
      }
      
      public final a d()
      {
        return new a().a(l());
      }
      
      public final boolean e()
      {
        return true;
      }
      
      public final a.a f()
      {
        a.a locala = l();
        if (!locala.e()) {
          throw new q();
        }
        return locala;
      }
      
      public final boolean g()
      {
        return (this.a & 0x8) == 8;
      }
      
      public final a h()
      {
        this.a &= 0xFFFFFFF7;
        this.e = 0L;
        return this;
      }
      
      public final boolean i()
      {
        return (this.a & 0x10) == 16;
      }
      
      public final a j()
      {
        this.a &= 0xFFFFFFEF;
        this.f = a.c.a;
        return this;
      }
    }
  }
  
  public static abstract interface b
    extends n
  {}
  
  public static enum c
  {
    private static h.a c = new c();
    private final int d;
    
    private c(int paramInt1)
    {
      this.d = paramInt1;
    }
    
    public static c a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return a;
      }
      return b;
    }
    
    public final int a()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */