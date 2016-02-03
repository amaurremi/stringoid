package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class MMInterstitial
  extends MMJSObject
{
  public MMJSResponse close(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (Context)this.contextRef.get();
    if ((paramHashMap != null) && ((paramHashMap instanceof Activity)))
    {
      ((Activity)paramHashMap).finish();
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse expandWithProperties(HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("OVERLAY_type");
    if ((localObject != null) && (!Boolean.parseBoolean((String)localObject))) {
      return MMJSResponse.responseWithError("Cannot expand a non banner ad");
    }
    String str1 = (String)paramHashMap.get("url");
    String str4 = (String)paramHashMap.get("transparent");
    String str5 = (String)paramHashMap.get("showTitlebar");
    String str6 = (String)paramHashMap.get("showBottombar");
    String str7 = (String)paramHashMap.get("enableBottombar");
    String str8 = (String)paramHashMap.get("enableNativeAccelerometer");
    String str9 = (String)paramHashMap.get("useCustomClose");
    String str10 = (String)paramHashMap.get("title");
    String str11 = (String)paramHashMap.get("transition");
    String str12 = (String)paramHashMap.get("orientation");
    String str2 = (String)paramHashMap.get("transitionDuration");
    String str13 = (String)paramHashMap.get("delayEnableBottombar");
    String str3 = (String)paramHashMap.get("delayShowBottombar");
    Context localContext = (Context)this.contextRef.get();
    Intent localIntent;
    if (localContext != null)
    {
      localIntent = new Intent(localContext, MMActivity.class);
      localIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      localObject = str1;
      if (str1 == null)
      {
        paramHashMap = (String)paramHashMap.get("OVERLAY_adurl");
        localObject = paramHashMap;
        if (paramHashMap == null) {
          return MMJSResponse.responseWithError("No url");
        }
      }
      if (!(localContext instanceof MMActivity)) {
        localIntent.setFlags(603979776);
      }
      localIntent.setData(Uri.parse((String)localObject));
      paramHashMap = new OverlaySettings();
      if (str4 != null) {
        paramHashMap.shouldMakeOverlayTransparent = Boolean.parseBoolean(str4);
      }
      if (str5 != null) {
        paramHashMap.shouldShowTitlebar = Boolean.parseBoolean(str5);
      }
      if (str6 != null) {
        paramHashMap.shouldShowBottomBar = Boolean.parseBoolean(str6);
      }
      if (str7 != null) {
        paramHashMap.shouldEnableBottomBar = Boolean.parseBoolean(str7);
      }
      if (str8 != null) {
        paramHashMap.canAccelerate = Boolean.parseBoolean(str8);
      }
      if (str9 != null) {
        paramHashMap.shouldShowCustomClose = Boolean.parseBoolean(str9);
      }
      if (str10 != null) {
        paramHashMap.overlayTitle = str10;
      }
      if (str11 != null) {
        paramHashMap.overlayTransition = str11;
      }
      if (str12 != null) {
        paramHashMap.orientation = str12;
      }
      if (str13 == null) {}
    }
    try
    {
      paramHashMap.delayEnableBottombar = Long.parseLong(str13);
      if (str3 != null) {}
      try
      {
        paramHashMap.delayShowBottombar = Long.parseLong(str3);
        if (str2 != null) {}
        try
        {
          paramHashMap.transitionTime = Long.parseLong(str2);
          localIntent.putExtra("settings", paramHashMap);
          localIntent.setFlags(603979776);
          if (!(localContext instanceof Activity)) {
            localIntent.addFlags(268435456);
          }
          localContext.startActivity(localIntent);
          MMAdViewSDK.Event.overlayOpened(localContext, null);
          return MMJSResponse.responseWithSuccess();
          return null;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  public MMJSResponse open(HashMap<String, String> paramHashMap)
  {
    Object localObject = null;
    String str = (String)paramHashMap.get("url");
    Context localContext = (Context)this.contextRef.get();
    paramHashMap = (HashMap<String, String>)localObject;
    if (str != null)
    {
      paramHashMap = (HashMap<String, String>)localObject;
      if (localContext != null)
      {
        paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse(str));
        paramHashMap.setFlags(603979776);
        if (!(localContext instanceof Activity)) {
          paramHashMap.addFlags(268435456);
        }
        MMAdViewSDK.Event.intentStarted(localContext, null, "browser");
        localContext.startActivity(paramHashMap);
        paramHashMap = MMJSResponse.responseWithSuccess();
      }
    }
    return paramHashMap;
  }
  
  public MMJSResponse show(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("url");
    Context localContext = (Context)this.contextRef.get();
    if ((paramHashMap != null) && (localContext != null))
    {
      Intent localIntent = new Intent(localContext, MMActivity.class);
      localIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      localIntent.setData(Uri.parse(paramHashMap));
      if (!(localContext instanceof MMActivity)) {
        localIntent.setFlags(603979776);
      }
      if (!(localContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localContext.startActivity(localIntent);
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */