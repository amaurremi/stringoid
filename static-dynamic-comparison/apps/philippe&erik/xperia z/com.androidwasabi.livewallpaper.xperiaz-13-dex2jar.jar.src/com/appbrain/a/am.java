package com.appbrain.a;

import android.content.Context;
import cmn.d;
import com.appbrain.b.k;
import com.appbrain.e.h;
import com.appbrain.e.q;

public final class am
  extends com.appbrain.f.c
{
  private static am b = null;
  private final ag c;
  
  private am(Context paramContext, d paramd)
  {
    super(paramContext);
    this.c = new an(this, paramContext);
    a(paramd);
  }
  
  public static am a(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        aw.a().a(paramContext, false);
        b = new am(paramContext, ag.a(aw.a().g(), aw.a().a("ppath", "/api/pb?action=")));
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final h a(q paramq)
  {
    paramq = b(paramq, "up");
    if (paramq == null) {
      return null;
    }
    return h.a(paramq);
  }
  
  protected final com.appbrain.g.c a(k paramk, String paramString)
  {
    return this.c.a(paramk, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */