package com.pocket.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.ideashower.readitlater.f.e;
import com.ideashower.readitlater.f.h;

public abstract class c
  extends a
{
  protected h g = new h()
  {
    protected void a(com.ideashower.readitlater.util.a.b paramAnonymousb)
    {
      c.this.a(paramAnonymousb);
    }
  };
  protected com.ideashower.readitlater.util.a.b h;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected void a(e parame)
  {
    this.g.b(parame);
  }
  
  protected void a(com.ideashower.readitlater.util.a.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramb != null) {
      if (!paramb.c()) {
        break label35;
      }
    }
    for (localObject1 = paramb.b();; localObject1 = localObject2)
    {
      if (localObject1 != null) {
        a((Bitmap)localObject1);
      }
      this.h = paramb;
      return;
      label35:
      paramb.b(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */