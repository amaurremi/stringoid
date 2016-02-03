package com.inmobi.re.configs;

import android.graphics.Color;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class ConfigParams
{
  String a = "#00000000";
  int b = 320;
  int c = 480;
  int d = 100;
  
  public int getPicHeight()
  {
    return this.c;
  }
  
  public int getPicQuality()
  {
    return this.d;
  }
  
  public int getPicWidth()
  {
    return this.b;
  }
  
  public UID getUID()
  {
    return UID.getCommonsUid();
  }
  
  public int getWebviewBgColor()
  {
    try
    {
      int i = Color.parseColor(this.a);
      return i;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "Invalid bg color. Reverting to default", localException);
    }
    return Color.parseColor("#00000000");
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getStringFromMap(paramMap, "wthc");
    this.c = InternalSDKUtil.getIntFromMap(paramMap, "picH", 1, 2147483647L);
    this.b = InternalSDKUtil.getIntFromMap(paramMap, "picW", 1, 2147483647L);
    this.d = InternalSDKUtil.getIntFromMap(paramMap, "picA", 1, 100L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/configs/ConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */