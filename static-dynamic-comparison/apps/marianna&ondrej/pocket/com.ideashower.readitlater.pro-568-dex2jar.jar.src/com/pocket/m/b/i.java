package com.pocket.m.b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.db.operation.z;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.s;
import com.pocket.m.a.c;
import com.pocket.m.c.e;
import com.pocket.p.q;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class i
  extends f
{
  protected boolean C;
  protected boolean D = false;
  protected SparseArray E;
  protected SparseArray F;
  private boolean G = false;
  private j H;
  private boolean I = false;
  
  public i(int paramInt1, int paramInt2, com.pocket.m.a.k paramk, o paramo, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2, paramk, paramo, paramBoolean1);
    this.D = paramBoolean2;
  }
  
  public i(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, com.pocket.m.a.k paramk)
  {
    super(paramInt1, paramInt2, paramString, paramBoolean, paramk);
  }
  
  private void B()
  {
    int j = 0;
    if (i()) {}
    do
    {
      return;
      if ((this.f != null) && (this.f.h()) && (this.H.b() != null))
      {
        new e(this.H.b()).d();
        if ((!this.C) && (com.ideashower.readitlater.h.i.c()) && (!this.D)) {
          com.pocket.m.a.a(this.f, 2, true, true, k(), false);
        }
      }
      int i;
      Object localObject2;
      if (this.E != null)
      {
        int k = this.E.size();
        i = 0;
        while (i < k)
        {
          localObject1 = (com.ideashower.readitlater.e.a)this.E.valueAt(i);
          localObject2 = com.pocket.m.a.a.a(((com.ideashower.readitlater.e.a)localObject1).a(), 1, com.pocket.m.a.l.c());
          if ((this.f != null) && (this.f.h()) && ((((com.ideashower.readitlater.e.a)localObject1).e() == 0) || (((com.ideashower.readitlater.e.a)localObject1).f() == 0))) {
            ((com.pocket.m.a.a)localObject2).a(new com.pocket.m.a.b()
            {
              public void a(byte[] paramAnonymousArrayOfByte)
              {
                BitmapFactory.Options localOptions = new BitmapFactory.Options();
                localOptions.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length, localOptions);
                int i = localOptions.outWidth;
                int j = localOptions.outHeight;
                if ((i < 1) || (j < 1)) {
                  return;
                }
                new z(i.this.f.f(), localObject1.b(), i, j).f();
              }
            });
          }
          a((com.pocket.m.a.a)localObject2, 1, null);
          i += 1;
        }
      }
      final Object localObject1 = this.H.c();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        i = j;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = com.pocket.m.a.a.a((String)((Iterator)localObject1).next(), 1, com.pocket.m.a.l.c());
          if (a((com.pocket.m.a.a)localObject3, 1, null)) {
            this.I = true;
          }
          localObject2 = "{%pkt_resource_path_" + i + "}";
          localObject3 = ((com.pocket.m.a.a)localObject3).c();
          this.q = org.apache.a.c.k.b(this.q, (String)localObject2, (String)localObject3);
          i += 1;
        }
      }
    } while (((this.E == null) || (this.E.size() <= 0)) && (!this.I));
    this.u = true;
  }
  
  private int a(InputStream paramInputStream)
  {
    boolean bool;
    if (this.f != null)
    {
      bool = this.f.M();
      this.H = new j(this, bool);
      paramInputStream = com.ideashower.readitlater.util.l.d().createJsonParser(paramInputStream);
      paramInputStream.nextToken();
    }
    for (;;)
    {
      if ((paramInputStream.nextToken() == JsonToken.END_OBJECT) || (paramInputStream.isClosed())) {
        break label306;
      }
      Object localObject = paramInputStream.getCurrentName();
      paramInputStream.nextToken();
      if ("article".equals(localObject))
      {
        this.H.a(com.ideashower.readitlater.util.l.a(paramInputStream));
        continue;
        bool = false;
        break;
      }
      if ("item".equals(localObject))
      {
        localObject = s.a(paramInputStream, null);
        if (this.f != null)
        {
          ((o)localObject).j(this.f.i());
          ((o)localObject).k(this.f.j());
        }
        this.H.a((o)localObject);
      }
      else if ("resources".equals(localObject))
      {
        if (paramInputStream.getCurrentToken() == JsonToken.START_ARRAY) {
          while ((paramInputStream.nextToken() != JsonToken.END_ARRAY) && (!paramInputStream.isClosed())) {
            while ((paramInputStream.nextToken() != JsonToken.END_OBJECT) && (!paramInputStream.isClosed()))
            {
              localObject = paramInputStream.getCurrentName();
              paramInputStream.nextToken();
              if ("url".equals(localObject)) {
                this.H.b(com.ideashower.readitlater.util.l.a(paramInputStream));
              } else {
                paramInputStream.skipChildren();
              }
            }
          }
        }
        if (com.ideashower.readitlater.a.g.y()) {
          throw new JsonParseException("exepecting start array, but token is" + paramInputStream.getCurrentToken().asString(), paramInputStream.getCurrentLocation());
        }
        paramInputStream.skipChildren();
      }
      else
      {
        paramInputStream.skipChildren();
      }
    }
    label306:
    paramInputStream.close();
    this.q = this.H.a();
    this.E = this.H.b().W();
    this.F = this.H.b().V();
    this.C = this.H.b().d(false);
    return 1;
  }
  
  protected void I()
  {
    if (this.f == null) {
      com.pocket.m.a.a(this);
    }
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    if (!this.G) {
      com.pocket.m.a.a(this);
    }
    this.G = true;
    super.b(paramBoolean, paramThrowable);
  }
  
  public int l()
  {
    return 1;
  }
  
  protected void m()
  {
    super.m();
    if ((this.f == null) && (this.g == null)) {
      G();
    }
  }
  
  protected void n()
  {
    if (this.f != null) {
      this.p = com.pocket.m.a.l.c().d(this.f.f());
    }
    for (;;)
    {
      super.n();
      return;
      if (this.g != null) {
        this.p = com.pocket.m.a.l.c().a(this.g);
      }
    }
  }
  
  protected void o()
  {
    int i = 1;
    com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("http://text.getpocket.com/v3beta/mobile", false);
    locala.a("url", this.g);
    locala.a("getItem");
    locala.a("promptSubs");
    locala.a("msg");
    locala.a("formfactor", com.ideashower.readitlater.util.j.b(false));
    locala.a("u", as.i());
    Object localObject;
    if (this.f != null)
    {
      localObject = q.b(this.f);
      if (((String)localObject).length() > 0) {
        locala.b((String)localObject);
      }
    }
    boolean bool = this.h;
    if (com.ideashower.readitlater.a.a.a.c().c(com.ideashower.readitlater.util.g.a(this.g)))
    {
      localObject = com.ideashower.readitlater.f.a.a(new com.ideashower.readitlater.f.d(this.g, 0), false, true);
      if ((localObject != null) && (((com.ideashower.readitlater.f.b)localObject).a() != null)) {
        locala.a("source", ((com.ideashower.readitlater.f.b)localObject).a());
      }
    }
    for (;;)
    {
      if (i != 0) {
        locala.a("refresh");
      }
      locala.a(new com.ideashower.readitlater.objects.b()
      {
        public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
        {
          return i.a(i.this, paramAnonymousInputStream);
        }
      });
      locala.b();
      switch (locala.c())
      {
      default: 
        if ((locala.d() == 415) || (locala.d() == 413))
        {
          b(-2);
          return;
        }
        break;
      case 1: 
        B();
        return;
      }
      b(-3);
      return;
      i = bool;
    }
  }
  
  protected void p()
  {
    if (((!this.b.get()) || (this.u)) && (!i()))
    {
      this.A.b();
      r();
      if (!i()) {
        this.B.b();
      }
      return;
    }
    r();
  }
  
  protected void q()
  {
    this.G = true;
    if (this.f != null)
    {
      com.pocket.m.a.a(this);
      return;
    }
    com.pocket.m.a.a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */