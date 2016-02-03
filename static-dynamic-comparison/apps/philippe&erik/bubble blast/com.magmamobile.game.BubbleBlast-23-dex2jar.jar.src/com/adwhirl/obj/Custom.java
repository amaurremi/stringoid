package com.adwhirl.obj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.adwhirl.ModCommon;

public class Custom
{
  public String description;
  public Drawable image;
  public String imageLink;
  public String imageLink480x75;
  public String link;
  public String trackingClick;
  public String trackingDisplay;
  public int type;
  
  public void setTrackingClick(Context paramContext, String paramString)
  {
    if (Extra2.kreativeTest) {}
    for (String str = "http://dep-adserver.feedvalue.com/tracking.html";; str = "http://adserver.feedvalue.com/tracking.html")
    {
      this.trackingClick = str.concat(String.format("?type=%s&cat=%s&userID=%s&dev=%s&os=%s&devID=3&appID=%s&adID=%s", new Object[] { Integer.valueOf(2), Integer.valueOf(Extra2.kreativeCat), ModCommon.getDeviceID(paramContext), ModCommon.getModelNumber(), ModCommon.getSDK(), Integer.valueOf(Extra2.kreativeAppID), paramString }));
      if (Extra2.verboselog) {
        Log.d("TRACKING CLICK", this.trackingClick);
      }
      return;
    }
  }
  
  public void setTrackingDisplay(Context paramContext, String paramString)
  {
    if (Extra2.kreativeTest) {}
    for (String str = "http://dep-adserver.feedvalue.com/tracking.html";; str = "http://adserver.feedvalue.com/tracking.html")
    {
      this.trackingDisplay = str.concat(String.format("?type=%s&cat=%s&userID=%s&dev=%s&os=%s&devID=3&appID=%s&adID=%s", new Object[] { Integer.valueOf(1), Integer.valueOf(Extra2.kreativeCat), ModCommon.getDeviceID(paramContext), ModCommon.getModelNumber(), ModCommon.getSDK(), Integer.valueOf(Extra2.kreativeAppID), paramString }));
      if (Extra2.verboselog) {
        Log.i("TRACKING DISPLAY", this.trackingDisplay);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/obj/Custom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */