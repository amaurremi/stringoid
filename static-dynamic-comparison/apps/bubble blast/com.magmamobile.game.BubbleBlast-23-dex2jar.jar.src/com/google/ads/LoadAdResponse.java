package com.google.ads;

import android.util.Log;
import java.util.Map;

class LoadAdResponse
  implements AdResponse
{
  private static final String LOGTAG = "LoadAdResponse";
  
  public void run(Map<String, String> paramMap, GoogleAdView paramGoogleAdView)
  {
    paramMap = (String)paramMap.get("src");
    if (paramMap == null)
    {
      Log.e("LoadAdResponse", "ERROR: src parameter not found in loadAdUrl");
      return;
    }
    paramGoogleAdView.loadAdFromUrl(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/LoadAdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */