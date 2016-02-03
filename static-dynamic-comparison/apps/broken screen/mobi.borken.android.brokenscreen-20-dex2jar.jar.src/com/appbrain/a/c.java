package com.appbrain.a;

import android.content.Context;
import cmn.ac.a;
import com.appbrain.b.g;
import com.appbrain.b.o;
import com.appbrain.e.a.e;
import com.appbrain.e.j.b;
import com.appbrain.e.j.f;
import com.appbrain.e.j.k;
import com.appbrain.e.j.m;
import com.appbrain.g.a.a.a;

public final class c
  extends com.appbrain.f.c
{
  private static c b = null;
  private final cl c;
  
  private c(Context paramContext, ac.a parama)
  {
    super(paramContext);
    this.c = new b(paramContext);
    a(parama);
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        aa.a().a(paramContext, false);
        b = new c(paramContext, cl.a(cz.a().d(), aa.a().a("ppath", "/api/pb?action=")));
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private Object a(g paramg, String paramString, o paramo)
  {
    paramg = super.b(paramg, paramString);
    if (paramg == null) {
      return null;
    }
    return paramo.a(paramg);
  }
  
  public final a.e a(j.k paramk)
  {
    return (a.e)a(paramk, "ev", a.e.a);
  }
  
  public final a.e a(j.m paramm)
  {
    return (a.e)a(paramm, "ai", a.e.a);
  }
  
  public final j.b a(j.f paramf)
  {
    return (j.b)a(paramf, "ba", j.b.a);
  }
  
  protected final a.a.a a(g paramg, String paramString)
  {
    return this.c.a(paramg, paramString);
  }
  
  protected final byte[] b(g paramg, String paramString)
  {
    return super.b(paramg, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */