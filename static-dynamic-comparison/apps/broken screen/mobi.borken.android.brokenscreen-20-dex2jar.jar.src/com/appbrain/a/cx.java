package com.appbrain.a;

import android.content.Context;
import cmn.ac.a;
import com.appbrain.b.g;
import com.appbrain.e.a.e;
import com.appbrain.e.a.k;
import com.appbrain.f.c;
import com.appbrain.g.a.a.a;

public final class cx
  extends c
{
  private static cx b = null;
  private final cl c;
  
  private cx(Context paramContext, ac.a parama)
  {
    super(paramContext);
    this.c = new cy(this, paramContext);
    a(parama);
  }
  
  public static cx a(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        aa.a().a(paramContext, false);
        b = new cx(paramContext, cl.a(aa.a().h(), aa.a().a("ppath", "/api/pb?action=")));
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final a.e a(a.k paramk)
  {
    paramk = b(paramk, "up");
    if (paramk == null) {
      return null;
    }
    return a.e.a(paramk);
  }
  
  protected final a.a.a a(g paramg, String paramString)
  {
    return this.c.a(paramg, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */