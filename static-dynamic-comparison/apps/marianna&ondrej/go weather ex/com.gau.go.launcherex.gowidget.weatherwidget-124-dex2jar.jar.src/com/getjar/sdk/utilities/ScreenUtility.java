package com.getjar.sdk.utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.data.MetadataValue.MetadataReliability;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ScreenUtility
{
  private static DecimalFormat decimalFormat = new DecimalFormat("##.###");
  
  public static HashMap<String, MetadataValue> getDisplayDetails(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    HashMap localHashMap = new HashMap();
    paramContext = getScreenData(paramContext);
    localHashMap.put("device.screen_dpi.width", new MetadataValue(Double.toString(paramContext.getXDpi()), MetadataValue.MetadataReliability.AVAILABLE));
    localHashMap.put("device.screen_dpi.height", new MetadataValue(Double.toString(paramContext.getYDpi()), MetadataValue.MetadataReliability.AVAILABLE));
    localHashMap.put("device.screen_resolution.width", new MetadataValue(Integer.toString(paramContext.getResolutionX()), MetadataValue.MetadataReliability.AVAILABLE));
    localHashMap.put("device.screen_resolution.height", new MetadataValue(Integer.toString(paramContext.getResolutionY()), MetadataValue.MetadataReliability.AVAILABLE));
    return localHashMap;
  }
  
  public static JSONObject getDisplayMetrics(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    JSONObject localJSONObject5 = new JSONObject();
    paramContext = getScreenData(paramContext);
    try
    {
      localJSONObject3.put("width", paramContext.getAvailableResX());
      localJSONObject3.put("height", paramContext.getAvailableResY());
    }
    catch (JSONException paramContext)
    {
      try
      {
        localJSONObject2.put("width", paramContext.getResolutionX());
        localJSONObject2.put("height", paramContext.getResolutionY());
      }
      catch (JSONException paramContext)
      {
        try
        {
          localJSONObject4.put("x", decimalFormat.format(paramContext.getXDpi()));
          localJSONObject4.put("y", decimalFormat.format(paramContext.getYDpi()));
        }
        catch (JSONException paramContext)
        {
          try
          {
            localJSONObject5.put("height", decimalFormat.format(paramContext.getScreenHeight()));
            localJSONObject5.put("width", decimalFormat.format(paramContext.getScreenWidth()));
          }
          catch (JSONException paramContext)
          {
            try
            {
              for (;;)
              {
                localJSONObject1.put("screen_dpi", localJSONObject4);
                localJSONObject1.put("screen_resolution", localJSONObject2);
                localJSONObject1.put("available_resolution", localJSONObject3);
                localJSONObject1.put("screen_size", localJSONObject5);
                Logger.d(Area.UI.value() | Area.CONFIG.value(), "Screen details: " + localJSONObject1.toString(), new Object[0]);
                return localJSONObject1;
                localJSONException1 = localJSONException1;
                Logger.d(Area.UI.value() | Area.CONFIG.value(), "ScreenUtility getDisplayMetrics() -- Error getting availableRes " + localJSONException1.getLocalizedMessage(), new Object[0]);
                continue;
                localJSONException2 = localJSONException2;
                Logger.d(Area.UI.value() | Area.CONFIG.value(), "ScreenUtility getDisplayMetrics() -- Error getting screenRes " + localJSONException2.getLocalizedMessage(), new Object[0]);
                continue;
                localJSONException3 = localJSONException3;
                Logger.d(Area.UI.value() | Area.CONFIG.value(), "ScreenUtility getDisplayMetrics() -- Error getting screenDpi " + localJSONException3.getLocalizedMessage(), new Object[0]);
                continue;
                paramContext = paramContext;
                Logger.d(Area.UI.value() | Area.CONFIG.value(), "ScreenUtility getDisplayMetrics() -- Error getting screenSize " + paramContext.getLocalizedMessage(), new Object[0]);
              }
            }
            catch (JSONException paramContext)
            {
              for (;;)
              {
                Logger.d(Area.UI.value() | Area.CONFIG.value(), "ScreenUtility getDisplayMetrics() -- Error getting all json objects together " + paramContext.getLocalizedMessage(), new Object[0]);
              }
            }
          }
        }
      }
    }
  }
  
  private static ScreenData getScreenData(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    Object localObject = null;
    if (Activity.class.isAssignableFrom(paramContext.getClass())) {
      localObject = (Activity)paramContext;
    }
    paramContext = null;
    Integer localInteger = null;
    if (localObject != null)
    {
      paramContext = new Rect();
      localObject = ((Activity)localObject).getWindow();
      ((Window)localObject).getDecorView().getWindowVisibleDisplayFrame(paramContext);
      int i = ((Window)localObject).findViewById(16908290).getTop();
      paramContext = Integer.valueOf(localDisplayMetrics.widthPixels);
      localInteger = Integer.valueOf(localDisplayMetrics.heightPixels - i);
    }
    double d1 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
    double d2 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
    return new ScreenData(localDisplayMetrics.xdpi, localDisplayMetrics.ydpi, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, d2, d1, paramContext, localInteger);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/ScreenUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */