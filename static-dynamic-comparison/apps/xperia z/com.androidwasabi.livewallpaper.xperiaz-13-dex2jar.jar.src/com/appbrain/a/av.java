package com.appbrain.a;

import android.content.Context;
import cmn.d;
import com.appbrain.b.k;
import com.appbrain.b.w;
import com.appbrain.e.am;
import com.appbrain.e.aq;
import com.appbrain.e.at;
import com.appbrain.e.h;

public final class av
  extends com.appbrain.f.c
{
  private static av b = null;
  private final ag c;
  
  private av(Context paramContext, d paramd)
  {
    super(paramContext);
    this.c = new o(paramContext);
    a(paramd);
  }
  
  public static av a(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        aw.a().a(paramContext, false);
        b = new av(paramContext, ag.a(ao.a().d(), aw.a().a("ppath", "/api/pb?action=")));
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private Object a(k paramk, String paramString, w paramw)
  {
    paramk = super.b(paramk, paramString);
    if (paramk == null) {
      return null;
    }
    return paramw.a(paramk);
  }
  
  public final com.appbrain.e.ag a(am paramam)
  {
    return (com.appbrain.e.ag)a(paramam, "ba", com.appbrain.e.ag.a);
  }
  
  public final h a(aq paramaq)
  {
    return (h)a(paramaq, "ev", h.a);
  }
  
  public final h a(at paramat)
  {
    return (h)a(paramat, "ai", h.a);
  }
  
  protected final com.appbrain.g.c a(k paramk, String paramString)
  {
    return this.c.a(paramk, paramString);
  }
  
  protected final byte[] b(k paramk, String paramString)
  {
    return super.b(paramk, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */