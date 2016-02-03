package com.skplanet.tad.videoplayer.manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.skplanet.tad.videoplayer.activity.a;

public class b
{
  public static void a(Activity paramActivity, a parama, String paramString1, String paramString2)
  {
    if ("C2WEB".contains(paramString1)) {
      a(paramActivity, paramString2);
    }
    while (!"C2PLAYER".contains(paramString1)) {
      return;
    }
    a(parama, paramString2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    com.skplanet.tad.videoplayer.util.b.a("landingWeb= " + paramString);
    paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }
  
  public static void a(a parama, String paramString)
  {
    parama.a(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/manager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */