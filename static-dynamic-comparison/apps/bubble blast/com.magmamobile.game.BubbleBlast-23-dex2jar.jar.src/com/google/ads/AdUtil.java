package com.google.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class AdUtil
{
  private static final String LOGTAG = "Google.AdUtil";
  private static float density = -1.0F;
  
  static String generateJSONParameters(List<AdSpec.Parameter> paramList)
  {
    Object localObject = new JSONObject();
    Iterator localIterator = paramList.iterator();
    paramList = (List<AdSpec.Parameter>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (AdSpec.Parameter)localIterator.next();
      String str1 = ((AdSpec.Parameter)localObject).getName();
      String str2 = ((AdSpec.Parameter)localObject).getValue();
      try
      {
        localObject = paramList.put(str1, str2);
        paramList = (List<AdSpec.Parameter>)localObject;
      }
      catch (JSONException localJSONException)
      {
        Log.w("Google.AdUtil", "Error encoding JSON: " + str1 + "=" + str2);
      }
    }
    return paramList.toString();
  }
  
  static int scaleDipsToPixels(Context paramContext, int paramInt)
  {
    if (density < 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * density);
  }
  
  static int scalePixelsToDips(Context paramContext, int paramInt)
  {
    if (density < 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt / density);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/AdUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */