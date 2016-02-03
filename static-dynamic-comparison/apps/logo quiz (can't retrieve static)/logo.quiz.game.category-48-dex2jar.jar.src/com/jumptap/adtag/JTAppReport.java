package com.jumptap.adtag;

import android.app.Activity;
import android.util.Log;
import com.jumptap.adtag.events.EventManager;
import com.jumptap.adtag.events.EventType;
import com.jumptap.adtag.utils.JtAdManager;
import java.util.HashMap;
import java.util.Map;

public class JTAppReport
{
  private static EventType getEventType(Activity paramActivity)
  {
    String str = EventManager.getFirstLaunchStr();
    paramActivity = JtAdManager.getPreferences(paramActivity, EventManager.getFirstPrefName(), str);
    if ((paramActivity == null) || ("".equals(paramActivity)) || (str.equals(paramActivity))) {
      return EventType.download;
    }
    return EventType.run;
  }
  
  public static void sendConversionTrackingReport(Activity paramActivity, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    Log.d("JtAd", "Application request to send conversion tracking url");
    String str1 = JtAdManager.getHIDSHA1(paramActivity);
    EventType localEventType = getEventType(paramActivity);
    String str2 = EventManager.getDateByEventType(localEventType, paramActivity);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("hid_sha1", str1);
    ((Map)localObject).put("app", paramString1);
    ((Map)localObject).put("appVer", paramString2);
    ((Map)localObject).put("event", localEventType.name());
    ((Map)localObject).put("date", str2);
    EventManager.sendReport(paramActivity, EventManager.buildEventTrackingUrl((Map)localObject), localEventType, str2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/JTAppReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */