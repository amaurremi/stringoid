package com.appflood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.FrameLayout.LayoutParams;
import com.appflood.b.b;
import com.appflood.c.d;
import com.appflood.c.e;
import com.appflood.c.e.1;
import com.appflood.c.e.3;
import com.appflood.c.e.5;
import com.appflood.c.e.6;
import com.appflood.c.e.7;
import com.appflood.c.e.8;
import com.appflood.c.e.9;
import com.appflood.c.g;
import com.appflood.e.j;
import com.appflood.e.k;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public class AppFlood
{
  public static final int AD_ALL = 255;
  public static final int AD_BANNER = 1;
  public static final int AD_DATA = 16;
  public static final int AD_FULLSCREEN = 4;
  public static final int AD_ICON = 64;
  public static final int AD_INTERSTITIAL = 128;
  public static final int AD_LIST = 8;
  public static final int AD_NONE = 0;
  public static final int AD_NOTIFICATION = 32;
  public static final int AD_PANEL = 2;
  public static final int BANNER_CUSTOM = 14;
  public static final int BANNER_INTERSTITIAL = 13;
  public static final int BANNER_LARGE = 10;
  public static final int BANNER_MIDDLE = 16;
  public static final int BANNER_POSITION_BOTTOM = 1;
  public static final int BANNER_POSITION_TOP = 0;
  public static final int BANNER_SMALL = 17;
  public static final int BANNER_WEB_FULLSCREEN = 15;
  public static final int BANNER_WEB_VIDEO = 25;
  public static int ICON_STYLE_MULTIPLE = 2;
  public static int ICON_STYLE_SINGLE = 0;
  public static final int LIST_ALL = 2;
  public static final int LIST_APP = 1;
  public static final int LIST_GAME = 0;
  public static final int LIST_TAB_APP = 4;
  public static final int LIST_TAB_GAME = 3;
  public static int NOTIFICATION_STYLE_BANNER = 0;
  public static int NOTIFICATION_STYLE_TEXT = 1;
  public static final int PANEL_BOTTOM = 1;
  public static final int PANEL_LANDSCAPE = 20;
  public static final int PANEL_PORTRAIT = 21;
  public static final int PANEL_TOP = 0;
  public static final int REGION_AUTO = 2;
  public static final int REGION_CHINA = 0;
  public static final int REGION_GLOBAL = 1;
  
  static
  {
    NOTIFICATION_STYLE_BANNER = 2;
    ICON_STYLE_SINGLE = 1;
  }
  
  public static void consumeAFPoint(int paramInt, AFRequestDelegate paramAFRequestDelegate)
  {
    e locale = e.a();
    if (!locale.b)
    {
      j.c("AppFlood not initialized");
      return;
    }
    d.a(new e.7(locale, paramAFRequestDelegate, paramInt));
  }
  
  public static void destroy()
  {
    e.a().b();
  }
  
  public static void getADData(AFRequestDelegate paramAFRequestDelegate)
  {
    if ((d.F & 0x10) > 0)
    {
      e locale = e.a();
      if (!locale.b)
      {
        j.c("AppFlood not initialized");
        return;
      }
      d.a(new e.9(locale, paramAFRequestDelegate));
      return;
    }
    j.c("AD_TYPE not supported. Please initialize AppFlood with correct parameters.");
  }
  
  public static int getAdType()
  {
    return d.F;
  }
  
  public static AFEventDelegate getEventDelegate()
  {
    return e.a().a;
  }
  
  public static String getVersion()
  {
    return "V2.22";
  }
  
  public static void handleAFClick(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!e.a().b) {
      j.c("AppFlood not initialized");
    }
    while ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    try
    {
      new b(paramString1, null).b(true);
      paramString1 = paramString2;
      if (!paramString2.contains("://")) {
        paramString1 = k.b(paramString2, null).toString();
      }
      paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString1)));
      return;
    }
    catch (Throwable paramActivity)
    {
      j.b(paramActivity, "error in handleClick");
    }
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    initialize(paramContext, paramString1, paramString2, null, null, paramInt, 1);
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    e.a().a(paramContext, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
  }
  
  public static boolean isConnected()
  {
    return d.j;
  }
  
  public static void preload(int paramInt, AFRequestDelegate paramAFRequestDelegate)
  {
    preload(paramInt, paramAFRequestDelegate, 2);
  }
  
  public static void preload(int paramInt1, AFRequestDelegate paramAFRequestDelegate, int paramInt2)
  {
    e locale = e.a();
    if (!locale.b)
    {
      j.c("AppFlood not initialized");
      return;
    }
    d.a(new e.3(locale, paramInt1, paramAFRequestDelegate, paramInt2));
  }
  
  public static void preloadBanner(int paramInt, AFRequestDelegate paramAFRequestDelegate)
  {
    e.a();
    g.a().a(paramInt, paramAFRequestDelegate, true);
  }
  
  public static void queryAFPoint(AFRequestDelegate paramAFRequestDelegate)
  {
    e locale = e.a();
    if (!locale.b)
    {
      j.c("AppFlood not initialized");
      return;
    }
    d.a(new e.8(locale, paramAFRequestDelegate));
  }
  
  public static void setEventDelegate(AFEventDelegate paramAFEventDelegate)
  {
    e.a().a = paramAFEventDelegate;
  }
  
  public static void setUserData(HashMap<String, Object> paramHashMap)
  {
    e.a();
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      j.c("UserData is null or empty!");
    }
    d.i = paramHashMap;
  }
  
  public static void showBanner(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (!d.H) {
      return;
    }
    if ((d.F & 0x1) > 0)
    {
      e.a();
      AFBannerView localAFBannerView = new AFBannerView(paramActivity, paramInt2);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      paramInt2 = 12;
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        localLayoutParams.gravity = paramInt1;
        paramActivity.addContentView(localAFBannerView, localLayoutParams);
        return;
        paramInt1 = 48;
        continue;
        paramInt1 = 80;
      }
    }
    j.c("AD_TYPE not supported. Please initialize AppFlood with correct parameters.");
  }
  
  public static void showFullScreen(Activity paramActivity)
  {
    if (!d.H) {
      return;
    }
    if ((d.F & 0x4) > 0)
    {
      e.a().a(paramActivity);
      return;
    }
    j.c("AD_TYPE not supported. Please initialize AppFlood with correct parameters.");
  }
  
  public static void showInterstitial(Activity paramActivity)
  {
    if (!d.H) {
      return;
    }
    if ((d.F & 0x80) > 0)
    {
      e locale = e.a();
      if (!locale.b)
      {
        j.c("AppFlood not initialized");
        return;
      }
      if (paramActivity == null)
      {
        j.c("context con is null");
        return;
      }
      d.a(paramActivity, new e.6(locale, paramActivity));
      return;
    }
    j.c("AD_TYPE not supported. Please initialize AppFlood with correct parameters.");
  }
  
  public static void showList(Activity paramActivity, int paramInt)
  {
    if (!d.H) {
      return;
    }
    if ((d.F & 0x8) > 0)
    {
      if (!e.a().b)
      {
        j.c("AppFlood not initialized");
        return;
      }
      if (paramActivity == null)
      {
        j.c("activity is null");
        return;
      }
      d.a(paramActivity, new e.1(paramActivity, paramInt));
      return;
    }
    j.c("AD_TYPE not supported. Please initialize AppFlood with correct parameters.");
  }
  
  public static void showPanel(Activity paramActivity, int paramInt)
  {
    if (!d.H) {
      return;
    }
    if ((d.F & 0x2) > 0)
    {
      if (!e.a().b)
      {
        j.c("AppFlood not initialized");
        return;
      }
      if (paramActivity == null)
      {
        j.c("context con is null");
        return;
      }
      d.a(paramActivity, new e.5(paramActivity, paramInt));
      return;
    }
    j.c("AD_TYPE not supported. Please initialize AppFlood with correct parameters.");
  }
  
  public static void showWaitingLoading(boolean paramBoolean)
  {
    d.I = paramBoolean;
  }
  
  public static abstract interface AFBannerShowDelegate
  {
    public abstract void onResume();
  }
  
  public static abstract interface AFEventDelegate
  {
    public abstract void onClick(JSONObject paramJSONObject);
    
    public abstract void onClose(JSONObject paramJSONObject);
    
    public abstract void onFinish(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface AFRequestDelegate
  {
    public abstract void onFinish(JSONObject paramJSONObject);
  }
  
  public static abstract interface AFVideoDelegate
  {
    public abstract void onComplete();
    
    public abstract void onSkip();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AppFlood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */