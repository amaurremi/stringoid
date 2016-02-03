package com.skplanet.tad.videoplayer.util;

import android.content.Context;
import android.content.Intent;
import com.skplanet.tad.videoplayer.data.b;
import com.skplanet.tad.videoplayer.data.c;

public class a
{
  public static b a(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("metaFileStr");
    paramIntent = paramIntent.getStringExtra("multimedia");
    localObject = d.a((String)localObject);
    if (localObject != null) {
      ((b)localObject).a = paramIntent;
    }
    return (b)localObject;
  }
  
  public static c a(Context paramContext, Intent paramIntent)
  {
    return new c(paramContext, paramIntent.getStringExtra("reqData_cookie"), paramIntent.getStringExtra("reqData_adsID"), paramIntent.getStringExtra("reqData_appID"), paramIntent.getStringExtra("reqData_metaURL"), paramIntent.getStringExtra("reqData_multimedia"));
  }
  
  public static void a(Intent paramIntent, c paramc)
  {
    paramIntent.putExtra("reqData_cookie", paramc.a);
    paramIntent.putExtra("reqData_adsID", paramc.b);
    paramIntent.putExtra("reqData_appID", paramc.c);
    paramIntent.putExtra("reqData_metaURL", paramc.d);
    paramIntent.putExtra("reqData_multimedia", paramc.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */