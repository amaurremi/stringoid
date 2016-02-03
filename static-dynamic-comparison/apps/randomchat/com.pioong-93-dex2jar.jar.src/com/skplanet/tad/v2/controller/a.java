package com.skplanet.tad.v2.controller;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.skplanet.tad.AdActivity;
import com.skplanet.tad.AdActivity.a;
import com.skplanet.tad.mraid.controller.MraidController.PlayerProperties;

public class a
{
  public static void a(Context paramContext, String paramString)
  {
    if (a(paramString)) {
      return;
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
  }
  
  public static void a(Context paramContext, String paramString, Message paramMessage)
  {
    if (a(paramString)) {}
    MraidController.PlayerProperties localPlayerProperties;
    Bundle localBundle;
    do
    {
      return;
      localPlayerProperties = new MraidController.PlayerProperties();
      localPlayerProperties.setProperties(true, true, true, false, "fullscreen", "normal");
      localBundle = new Bundle();
      localBundle.putString("action", AdActivity.a.e.toString());
      localBundle.putString("player_url", paramString);
      localBundle.putParcelable("player_properties", localPlayerProperties);
    } while (!localPlayerProperties.isFullScreen());
    if (paramMessage != null)
    {
      localBundle.putBoolean("interstitial", true);
      AdActivity.a(paramMessage);
    }
    try
    {
      paramString = new Intent(paramContext, AdActivity.class);
      paramString.putExtras(localBundle);
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Message paramMessage)
  {
    if (a(paramString4)) {
      return;
    }
    paramString1 = new Bundle();
    paramString1.putString("action", AdActivity.a.g.toString());
    paramString1.putString("btb.url", paramString4);
    paramString1.putString("btb.bypass", paramString2);
    paramString1.putString("client_id", paramString3);
    if (paramString5 != null) {
      paramString1.putString("slot_num", paramString5);
    }
    if (paramMessage != null)
    {
      paramString1.putBoolean("interstitial", true);
      AdActivity.a(paramMessage);
    }
    try
    {
      paramString2 = new Intent(paramContext, AdActivity.class);
      paramString2.putExtras(paramString1);
      paramContext.startActivity(paramString2);
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  private static boolean a(String paramString)
  {
    return TextUtils.isEmpty(paramString);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (a(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("action", AdActivity.a.c.toString());
    localBundle.putString("popup_ad.url", paramString);
    try
    {
      paramString = new Intent(paramContext, AdActivity.class);
      paramString.putExtras(localBundle);
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (a(paramString)) {
      return;
    }
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri.getScheme().equalsIgnoreCase("tel"))
      {
        paramString = new Intent("android.intent.action.DIAL");
        paramString.setData(localUri);
      }
      for (;;)
      {
        paramContext.startActivity(paramString);
        return;
        paramString = new Intent("android.intent.action.VIEW");
        paramString.setData(localUri);
      }
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (a(paramString)) {
      return;
    }
    String str2 = paramString.substring(0, 6);
    String str1 = paramString.substring(9);
    if (str2.equalsIgnoreCase("tstore")) {
      try
      {
        paramString = new Intent();
        paramString.addFlags(536870912);
        paramString.setClassName("com.skt.skaf.A000Z00040", "com.skt.skaf.A000Z00040.A000Z00040");
        paramString.setAction("COLLAB_ACTION");
        paramString.putExtra("com.skt.skaf.COL.URI", str1.getBytes());
        paramString.putExtra("com.skt.skaf.COL.REQUESTER", "A000Z00040");
        paramContext.startActivity(paramString);
        return;
      }
      catch (ActivityNotFoundException paramString)
      {
        a(paramContext, "http://m.tstore.co.kr/");
        return;
      }
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    paramContext.startActivity(paramString);
  }
  
  public static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */