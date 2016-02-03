package com.pocket.oauth;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.text.TextUtils;
import com.ideashower.readitlater.h.l;
import com.pocket.c.u;

public class d
  extends a
{
  public static final String[] e = { "profile", "email" };
  public static final String f = TextUtils.join(" ", e);
  public static final Bundle g = null;
  protected boolean h;
  private final com.google.android.gms.b.a i;
  private final h j;
  private com.google.android.gms.common.a k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  public d(Context paramContext, h paramh)
  {
    super(paramContext, paramh);
    this.j = paramh;
    this.i = new com.google.android.gms.b.b(paramContext, new com.google.android.gms.common.c()new com.google.android.gms.common.d
    {
      public void a() {}
      
      public void a(Bundle paramAnonymousBundle)
      {
        if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.u))
        {
          d.this.a(true);
          com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.u, false).a();
        }
        do
        {
          return;
          if (d.a(d.this)) {
            break;
          }
        } while ((d.b(d.this)) || (!com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.v)) || (!d.c(d.this).c()));
        d.this.h = true;
        com.pocket.stats.c.t.b();
        com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.v, false);
        for (;;)
        {
          d.d(d.this);
          return;
          d.a(d.this, false);
        }
      }
    }, new com.google.android.gms.common.d()
    {
      public void a(com.google.android.gms.common.a paramAnonymousa)
      {
        if ((d.c(d.this).a()) && (d.a(d.this))) {
          d.a(d.this, paramAnonymousa);
        }
        d.b(d.this, paramAnonymousa);
      }
    }).a(e).a();
  }
  
  private static void a(com.google.android.gms.b.a parama, g paramg)
  {
    try
    {
      parama.a(new com.google.android.gms.b.d()
      {
        public void a(com.google.android.gms.common.a paramAnonymousa, com.google.android.gms.b.a.b.k paramAnonymousk, String paramAnonymousString)
        {
          localObject1 = null;
          Object localObject2 = null;
          paramAnonymousString = (String)localObject1;
          if (paramAnonymousa.b())
          {
            paramAnonymousString = (String)localObject1;
            if (paramAnonymousk != null) {
              paramAnonymousa = (com.google.android.gms.common.a)localObject2;
            }
          }
          try
          {
            if (paramAnonymousk.a() > 0) {
              paramAnonymousa = paramAnonymousk.b(0);
            }
            paramAnonymousk.b();
            paramAnonymousString = paramAnonymousa;
          }
          catch (Throwable paramAnonymousa)
          {
            for (;;)
            {
              com.ideashower.readitlater.util.e.a(paramAnonymousa);
              paramAnonymousk.b();
              paramAnonymousString = (String)localObject1;
            }
          }
          finally
          {
            paramAnonymousk.b();
          }
          d.this.a(paramAnonymousString);
        }
      }, new String[] { "me" });
      return;
    }
    catch (Throwable parama)
    {
      com.ideashower.readitlater.util.e.a(parama);
      paramg.a(null);
    }
  }
  
  private void a(com.google.android.gms.common.a parama)
  {
    this.k = null;
    this.j.a(parama);
  }
  
  public static void a(String paramString, f paramf)
  {
    e.a(new e(paramString, paramf, null));
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    switch (com.google.android.gms.common.g.a(paramContext))
    {
    default: 
      paramBoolean = false;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      return paramBoolean;
    case 1: 
    case 9: 
    case 10: 
    case 11: 
      return false;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    paramString = com.google.android.gms.auth.b.a(com.ideashower.readitlater.a.g.c(), paramString, "audience:server:client_id:173409440056-qf7d205mr2cmhave0q1majlb5cfej31f.apps.googleusercontent.com", g);
    if (org.apache.a.c.k.c(paramString)) {
      throw new com.google.android.gms.auth.a("empty id token");
    }
    return paramString;
  }
  
  private void d()
  {
    if (this.l) {
      return;
    }
    final com.pocket.c.b localb;
    final boolean bool;
    if (this.h)
    {
      localb = com.pocket.c.b.b;
      this.h = false;
      bool = true;
      if (localb != com.pocket.c.b.b) {
        break label100;
      }
      com.pocket.stats.c.u.b();
    }
    for (;;)
    {
      if (!this.b.a()) {
        this.b.a(this);
      }
      if (this.i.a() != null) {
        break label109;
      }
      a(false);
      this.j.d();
      com.ideashower.readitlater.util.e.a("missing account name", true);
      return;
      localb = this.c;
      bool = false;
      break;
      label100:
      com.pocket.stats.c.w.b();
    }
    label109:
    this.l = true;
    a(this.i, new g()
    {
      public void a(com.google.android.gms.b.a.b.a paramAnonymousa)
      {
        if (paramAnonymousa != null)
        {
          paramAnonymousa = new u(localb, d.e(d.this).a(), paramAnonymousa, bool, new i()
          {
            public void a(com.pocket.c.f paramAnonymous2f, boolean paramAnonymous2Boolean)
            {
              d.this.b.a((com.pocket.c.a)paramAnonymous2f, paramAnonymous2Boolean);
              d.b(d.this, false);
            }
            
            public boolean a(int paramAnonymous2Int)
            {
              d.b(d.this, false);
              return d.c(d.this).a(paramAnonymous2Int);
            }
            
            public boolean a(Intent paramAnonymous2Intent)
            {
              d.b(d.this, false);
              return d.c(d.this).a(paramAnonymous2Intent);
            }
          });
          paramAnonymousa.a(d.this.d);
          paramAnonymousa.h();
          return;
        }
        d.b(d.this, false);
        d.this.a(false);
        d.c(d.this).d();
      }
    });
  }
  
  public void a()
  {
    this.i.c();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.k = null;
    this.n = false;
    if (paramInt == 0) {
      if (this.c == com.pocket.c.b.a)
      {
        com.pocket.stats.c.x.b();
        this.b.b();
      }
    }
    while (paramInt != -1) {
      for (;;)
      {
        return;
        com.pocket.stats.c.v.b();
      }
    }
    this.i.c();
  }
  
  public void a(Bundle paramBundle)
  {
    this.m = true;
    if (this.i.d()) {
      d();
    }
    do
    {
      return;
      if (this.k != null) {
        break;
      }
      this.j.a(this);
    } while (this.i.e());
    this.i.c();
    return;
    this.j.a(this);
    a(this.k);
  }
  
  public void a(com.google.android.gms.common.a parama, android.support.v4.app.f paramf, int paramInt)
  {
    if (this.n) {
      return;
    }
    this.n = true;
    try
    {
      parama.a(paramf, paramInt);
      return;
    }
    catch (IntentSender.SendIntentException parama)
    {
      this.n = false;
      throw parama;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.i.d())
    {
      this.i.b();
      this.i.f();
      this.i.c();
      return;
    }
    com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.u);
  }
  
  public void b()
  {
    this.i.f();
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("isResolvingError", this.n);
  }
  
  public void c()
  {
    a(null);
  }
  
  public void c(Bundle paramBundle)
  {
    this.n = paramBundle.getBoolean("isResolvingError");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */