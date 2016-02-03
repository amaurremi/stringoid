package com.badlogic.gdx.a.a;

import com.badlogic.gdx.graphics.glutils.c;
import com.badlogic.gdx.graphics.k;
import com.badlogic.gdx.graphics.n;
import com.badlogic.gdx.graphics.p;
import com.badlogic.gdx.graphics.t;

public class e
  extends b<p, g>
{
  f a;
  
  public com.badlogic.gdx.utils.a<com.badlogic.gdx.a.a> a(String paramString, com.badlogic.gdx.c.a parama, g paramg)
  {
    return null;
  }
  
  public void a(com.badlogic.gdx.a.f paramf, String paramString, com.badlogic.gdx.c.a parama, g paramg)
  {
    paramf = null;
    this.a.a = paramString;
    if ((paramg == null) || (paramg.e == null))
    {
      boolean bool = false;
      this.a.c = null;
      if (paramg != null)
      {
        paramf = paramg.b;
        bool = paramg.c;
        this.a.c = paramg.d;
      }
      if (!paramString.contains(".etc1"))
      {
        if (paramString.contains(".cim")) {}
        for (paramString = n.a(parama);; paramString = new k(parama))
        {
          this.a.b = new c(parama, paramString, paramf, bool);
          return;
        }
      }
      this.a.b = new com.badlogic.gdx.graphics.glutils.b(parama, bool);
      return;
    }
    this.a.b = paramg.e;
    if (!this.a.b.a()) {
      this.a.b.b();
    }
    this.a.c = paramg.d;
  }
  
  public p b(com.badlogic.gdx.a.f paramf, String paramString, com.badlogic.gdx.c.a parama, g paramg)
  {
    if (this.a == null)
    {
      paramString = null;
      return paramString;
    }
    paramf = this.a.c;
    if (paramf != null) {
      paramf.a(this.a.b);
    }
    for (;;)
    {
      paramString = paramf;
      if (paramg == null) {
        break;
      }
      paramf.a(paramg.f, paramg.g);
      paramf.a(paramg.h, paramg.i);
      return paramf;
      paramf = new p(this.a.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */