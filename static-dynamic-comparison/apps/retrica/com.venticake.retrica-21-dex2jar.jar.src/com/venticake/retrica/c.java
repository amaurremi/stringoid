package com.venticake.retrica;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v7.a.f;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

public abstract class c
  extends f
  implements d
{
  public static String a(float paramFloat)
  {
    return String.valueOf(Math.round(10.0F * paramFloat) * 10);
  }
  
  public static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      FlurryAgent.onStartSession(paramActivity, com.venticake.retrica.setting.a.a);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, d paramd)
  {
    if (paramd.shouldDisplayAd()) {}
    try
    {
      com.venticake.a.a.a().c(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(String paramString, Map<String, String> paramMap)
  {
    if (Build.VERSION.SDK_INT < 10) {
      return;
    }
    try
    {
      FlurryAgent.logEvent(paramString, paramMap);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      FlurryAgent.onEndSession(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void b(Activity paramActivity, d paramd)
  {
    if (paramd.shouldDisplayAd()) {}
    try
    {
      com.venticake.a.a.a().d(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void b(String paramString)
  {
    if (Build.VERSION.SDK_INT < 10) {
      return;
    }
    try
    {
      FlurryAgent.logEvent(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static Map<String, String> j()
  {
    HashMap localHashMap = m();
    localHashMap.put("Take Type", "Single Still");
    return localHashMap;
  }
  
  public static Map<String, String> k()
  {
    HashMap localHashMap = m();
    localHashMap.put("Take Type", "Single Render");
    return localHashMap;
  }
  
  public static Map<String, String> l()
  {
    HashMap localHashMap = m();
    localHashMap.put("Take Type", "Collage");
    return localHashMap;
  }
  
  public static HashMap<String, String> m()
  {
    int i = 1;
    HashMap localHashMap = new HashMap();
    com.venticake.retrica.setting.a locala = com.venticake.retrica.setting.a.a();
    if (locala.m() == 1) {}
    for (;;)
    {
      localHashMap.put("Camera Position", String.valueOf(i));
      localHashMap.put("Frame", String.valueOf(locala.n()));
      localHashMap.put("Use Vignette", String.valueOf(locala.h()));
      localHashMap.put("Use Blur", String.valueOf(locala.i()));
      localHashMap.put("Lens Name", String.valueOf(locala.f()));
      localHashMap.put("Border Width", String.valueOf(locala.k()));
      localHashMap.put("Border Color", String.valueOf(locala.l()));
      localHashMap.put("Timer Delay", String.valueOf(locala.s()));
      localHashMap.put("Timer Interval", String.valueOf(locala.t()));
      localHashMap.put("Intensity", a(locala.g()));
      return localHashMap;
      i = 0;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    b(this, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    a(this, this);
  }
  
  protected void onStart()
  {
    super.onStart();
    a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    b(this);
  }
  
  public boolean shouldDisplayAd()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */