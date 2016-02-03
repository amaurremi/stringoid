package com.vungle.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.vungle.sdk.VungleIntentService;
import com.vungle.sdk.ak;
import com.vungle.sdk.al;
import com.vungle.sdk.al.a;

public final class f
{
  private static final f a = new f();
  
  public static final f a()
  {
    return a;
  }
  
  private static void a(g paramg)
  {
    Context localContext = ak.e();
    Intent localIntent = new Intent("Http", Uri.parse(paramg.c()), localContext, VungleIntentService.class);
    localIntent.putExtra("httpRequest", paramg);
    localContext.startService(localIntent);
  }
  
  public static void a(String paramString)
  {
    a(new a(paramString));
  }
  
  public static void a(String paramString, al paramal, al.a parama)
  {
    paramString = new l(paramString);
    n localn = new n();
    localn.a(paramal);
    localn.a(parama);
    paramString.a(localn);
    a(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */