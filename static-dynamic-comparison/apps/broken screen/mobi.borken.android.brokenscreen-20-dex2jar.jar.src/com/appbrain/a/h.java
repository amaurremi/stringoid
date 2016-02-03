package com.appbrain.a;

import android.content.Context;
import com.appbrain.AdvertiserService;
import com.appbrain.e.a.c;
import com.appbrain.e.a.c.a;

public final class h
  implements AdvertiserService
{
  private static h a;
  
  public static h a()
  {
    try
    {
      if (a == null) {
        a = new h();
      }
      h localh = a;
      return localh;
    }
    finally {}
  }
  
  public final void sendConversionEvent(String paramString, int paramInt)
  {
    Context localContext = aa.a().i();
    if ((aa.a().c()) || (aa.a().a("convoff", 0) != 0)) {
      return;
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 20) {
        str = paramString.substring(0, 20);
      }
    }
    paramString = a.c.l().a(System.currentTimeMillis()).a(str).a(paramInt).d();
    cr.a(localContext).a(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */