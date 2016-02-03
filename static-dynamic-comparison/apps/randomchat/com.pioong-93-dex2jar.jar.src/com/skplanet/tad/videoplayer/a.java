package com.skplanet.tad.videoplayer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.skplanet.tad.AdVideoPlayer;
import com.skplanet.tad.videoplayer.data.c;
import com.skplanet.tad.videoplayer.util.b;
import com.skplanet.tad.videoplayer.util.d;

public class a
{
  private String a(String paramString)
  {
    if (!paramString.toLowerCase().endsWith(".xml")) {}
    do
    {
      return null;
      paramString = com.skplanet.tad.videoplayer.manager.a.a(paramString, "GET", null);
    } while ("error".equals(paramString));
    b.a("META DATA XML = " + paramString);
    return paramString;
  }
  
  public int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      b.a("<adStart>");
      b.a("<cookie>:" + paramString1);
      b.a("<adsID>:" + paramString2);
      b.a("<appID>:" + paramString3);
      b.a("<metaURL>:" + paramString4);
      b.a("<multimedia>:" + paramString5);
      paramString1 = new c(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5);
      b.a("adStart, request:" + paramString1);
      paramString2 = a(paramString4);
      if (paramString2 == null) {
        return 101;
      }
      paramString3 = d.a(paramString2);
      if (paramString3 == null) {
        return 102;
      }
      try
      {
        paramString3 = new Intent(paramContext, AdVideoPlayer.class);
        paramString3.putExtra("multimedia", paramString5);
        com.skplanet.tad.videoplayer.util.a.a(paramString3, paramString1);
        paramString3.putExtra("metaFileStr", paramString2);
        b.a("intent: " + paramString3.getComponent().getClassName());
        ((Activity)paramContext).startActivityForResult(paramString3, 1);
        return 100;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return 107;
      }
      return 199;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */