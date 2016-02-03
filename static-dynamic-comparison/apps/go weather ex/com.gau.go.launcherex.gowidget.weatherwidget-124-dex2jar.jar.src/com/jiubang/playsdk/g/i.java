package com.jiubang.playsdk.g;

import java.util.HashMap;
import java.util.Map;

public class i
{
  private Map a = new HashMap();
  private Map b = new HashMap();
  
  public i()
  {
    this.a.put("com.jb.gokeyboard", "http://godfs.3g.cn/dynamic/gokeyboard_v2.05_release.apk");
    this.a.put("com.jb.gosms", "http://godfs.3g.cn/soft/gosms/channel/GOSmsPro_132.apk");
    this.a.put("com.gau.go.launcherex.gowidget.weatherwidget", "http://godfs.3g.cn/soft/3GHeart/golauncher/widget/qudao/goweatherex/goweatherex_204.apk");
    this.a.put("com.jiubang.goscreenlock", "http://godfs.3g.cn/soft/golocker/GOLocker(China543).apk");
    this.a.put("com.gau.go.launcherex", "http://godfs.3g.cn/gosoft/go_launcher/qudao/go_launcher_ex_555.apk");
  }
  
  private Map a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt == 80)
    {
      localHashMap.put("com.jb.gokeyboard", "market://details?id=com.jb.gokeyboard&referrer=utm_source%3DGOKEYBOARD%26utm_medium%3Dhyperlink%26utm_campaign%3DNewStoreSMS");
      localHashMap.put("com.gau.go.launcherex.gowidget.weatherwidget", "market://details?id=com.gau.go.launcherex.gowidget.weatherwidget&referrer=utm_source%3Dsms_store%26utm_medium%3DHyperlink%26utm_campaign%3Dthemestore");
      localHashMap.put("com.jiubang.goscreenlock", "market://details?id=com.jiubang.goscreenlock&referrer=utm_source%3DGOSMSStore%26utm_medium%3Dbanner%26utm_campaign%3DGOthemeStore");
      localHashMap.put("com.gau.go.launcherex", "market://details?id=com.gau.go.launcherex&referrer=utm_source%3Dsms_store%26utm_medium%3DHyperlink%26utm_campaign%3Dgolauncher");
    }
    while (paramInt != 81) {
      return localHashMap;
    }
    localHashMap.put("com.jb.gosms", "market://details?id=com.jb.gosms&referrer=utm_source%3DGOSMS%26utm_medium%3Dhyperlink%26utm_campaign%3DNewStoreKeybo");
    localHashMap.put("com.gau.go.launcherex.gowidget.weatherwidget", "market://details?id=com.gau.go.launcherex.gowidget.weatherwidget&referrer=utm_source%3Dkeyboard_store%26utm_medium%3DHyperlink%26utm_campaign%3Dthemestore");
    localHashMap.put("com.jiubang.goscreenlock", "market://details?id=com.jiubang.goscreenlock&referrer=utm_source%3DGOKeyboardStore%26utm_medium%3Dbanner%26utm_campaign%3DGOthemeStore");
    localHashMap.put("com.gau.go.launcherex", "market://details?id=com.gau.go.launcherex&referrer=utm_source%3Dkeyboard_store%26utm_medium%3DHyperlink%26utm_campaign%3Dgolauncher");
    return localHashMap;
  }
  
  public String a(int paramInt, String paramString)
  {
    if (!this.b.containsKey(Integer.valueOf(paramInt)))
    {
      localMap = a(paramInt);
      this.b.put(Integer.valueOf(paramInt), localMap);
    }
    Map localMap = (Map)this.b.get(Integer.valueOf(paramInt));
    if (localMap != null) {
      return (String)localMap.get(paramString);
    }
    return "";
  }
  
  public String a(String paramString)
  {
    return (String)this.a.get(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */