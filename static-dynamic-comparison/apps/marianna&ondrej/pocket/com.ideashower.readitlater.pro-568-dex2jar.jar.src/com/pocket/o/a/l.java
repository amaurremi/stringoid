package com.pocket.o.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.au;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.r;
import com.pocket.p.x;
import com.pocket.widget.ay;
import java.util.ArrayList;
import java.util.Iterator;

public class l
  implements au, j, ay
{
  private final ArrayList a = new ArrayList();
  private final ArrayList b = new ArrayList();
  private final ArrayList c = new ArrayList();
  private final m d;
  private x e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  
  public l(m paramm, Bundle paramBundle)
  {
    this.d = paramm;
    if ((paramBundle != null) && (paramBundle.getBoolean("isModified"))) {
      m();
    }
    this.e = new x()
    {
      public String a(String paramAnonymousString)
      {
        if (paramAnonymousString.equalsIgnoreCase("_untagged_")) {
          return g.c().getResources().getString(2131493103, new Object[] { "_untagged_" });
        }
        if (paramAnonymousString.length() > 25) {
          return g.c().getResources().getString(2131493169);
        }
        return null;
      }
    };
    as.a(this);
  }
  
  private void l()
  {
    this.h = true;
    this.i = true;
    this.j = this.b.size();
    this.d.a(false);
  }
  
  private void m()
  {
    if (this.f > 0) {
      return;
    }
    this.g = true;
    this.d.b();
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putBoolean("isModified", this.g);
    paramBundle.putStringArrayList("tagList", d());
  }
  
  public void a(i parami)
  {
    this.c.add(parami);
  }
  
  protected void a(i parami, CharSequence paramCharSequence)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali != parami) {
        locali.a(paramCharSequence);
      }
    }
    m();
  }
  
  protected void a(String paramString)
  {
    if (paramString != null)
    {
      this.d.a(paramString);
      return;
    }
    this.d.a();
  }
  
  public void a(final String paramString, final ArrayList paramArrayList, final boolean paramBoolean)
  {
    this.d.a(true);
    this.f = (this.c.size() + 1);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).a(this);
    }
    paramString = new com.ideashower.readitlater.db.operation.j()
    {
      protected void c_()
      {
        l.a(l.this).clear();
        l.a(l.this).addAll(x());
        if ((paramString != null) && (paramBoolean))
        {
          com.ideashower.readitlater.e.e locale = r.a(paramString, this.h);
          if (locale != null)
          {
            paramArrayList.clear();
            paramArrayList.addAll(locale.w());
          }
        }
      }
    };
    paramString.a(new com.ideashower.readitlater.g.l()
    {
      public void a() {}
      
      public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          throw new RuntimeException("could not load tags");
        }
        if (paramArrayList != null)
        {
          paramAnonymousk = paramArrayList.iterator();
          while (paramAnonymousk.hasNext())
          {
            String str = (String)paramAnonymousk.next();
            l.this.a(null, str);
          }
        }
        paramAnonymousk = l.b(l.this).iterator();
        while (paramAnonymousk.hasNext()) {
          ((i)paramAnonymousk.next()).a(l.a(l.this));
        }
        l.this.b();
      }
    }, true);
    paramString.f();
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  protected boolean a(i parami, String paramString)
  {
    if (this.i)
    {
      if (!(parami instanceof c)) {
        break label51;
      }
      this.l += 1;
    }
    for (;;)
    {
      localObject = this.e.a(paramString);
      if (localObject == null) {
        break;
      }
      this.d.a((String)localObject);
      return false;
      label51:
      if (((parami instanceof a)) || ((parami instanceof e))) {
        this.k += 1;
      } else if ((parami instanceof f)) {
        if (((f)parami).a) {
          this.k += 1;
        } else {
          this.m += 1;
        }
      }
    }
    this.d.a();
    this.b.add(paramString);
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      if (locali != parami) {
        locali.a(paramString);
      }
    }
    m();
    return true;
  }
  
  public boolean a(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (org.apache.a.c.k.b((String)localIterator.next(), paramCharSequence)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.f -= 1;
    if (this.f == 0) {
      l();
    }
  }
  
  protected void b(i parami, String paramString)
  {
    if ((parami instanceof e)) {
      this.n += 1;
    }
    this.b.remove(paramString);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali != parami) {
        locali.b(paramString);
      }
    }
    m();
  }
  
  public void c()
  {
    a(null, null, true);
  }
  
  public ArrayList d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  protected x f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.h)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).i(paramBoolean);
      }
    }
  }
  
  public int j()
  {
    return this.m;
  }
  
  public int k()
  {
    return this.n;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/o/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */