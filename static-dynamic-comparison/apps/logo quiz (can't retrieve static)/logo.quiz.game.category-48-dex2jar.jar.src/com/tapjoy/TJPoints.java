package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Map;
import java.util.UUID;
import org.w3c.dom.Document;

public class TJPoints
{
  private static final String TAG = "TapjoyPoints";
  private static TapjoyAwardPointsNotifier tapjoyAwardPointsNotifier;
  private static TapjoyEarnedPointsNotifier tapjoyEarnedPointsNotifier;
  private static TapjoyNotifier tapjoyNotifier;
  private static TapjoySpendPointsNotifier tapjoySpendPointsNotifier;
  int awardTapPoints = 0;
  Context context;
  String spendTapPoints = null;
  
  public TJPoints(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean handleAwardPointsResponse(String paramString)
  {
    paramString = TapjoyUtil.buildDocument(paramString);
    String str;
    if (paramString != null)
    {
      str = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Success"));
      if ((str == null) || (!str.equals("true"))) {
        break label98;
      }
      str = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("TapPoints"));
      paramString = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("CurrencyName"));
      if ((str != null) && (paramString != null))
      {
        saveTapPointsTotal(Integer.parseInt(str));
        tapjoyAwardPointsNotifier.getAwardPointsResponse(paramString, Integer.parseInt(str));
        return true;
      }
      TapjoyLog.e("TapjoyPoints", "Invalid XML: Missing tags.");
    }
    for (;;)
    {
      return false;
      label98:
      if ((str != null) && (str.endsWith("false")))
      {
        paramString = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Message"));
        TapjoyLog.i("TapjoyPoints", paramString);
        tapjoyAwardPointsNotifier.getAwardPointsResponseFailed(paramString);
        return true;
      }
      TapjoyLog.e("TapjoyPoints", "Invalid XML: Missing <Success> tag.");
    }
  }
  
  private boolean handleGetPointsResponse(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = TapjoyUtil.buildDocument(paramString);
        if (paramString == null) {
          break label223;
        }
        String str = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Success"));
        if ((str != null) && (str.equals("true")))
        {
          str = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("TapPoints"));
          paramString = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("CurrencyName"));
          if ((str != null) && (paramString != null)) {
            try
            {
              int i = Integer.parseInt(str);
              int j = getLocalTapPointsTotal();
              if ((tapjoyEarnedPointsNotifier != null) && (j != 55537) && (i > j))
              {
                TapjoyLog.i("TapjoyPoints", "earned: " + (i - j));
                tapjoyEarnedPointsNotifier.earnedTapPoints(i - j);
              }
              saveTapPointsTotal(Integer.parseInt(str));
              tapjoyNotifier.getUpdatePoints(paramString, Integer.parseInt(str));
              bool = true;
              return bool;
            }
            catch (Exception paramString)
            {
              TapjoyLog.e("TapjoyPoints", "Error parsing XML and calling notifier: " + paramString.toString());
            }
          }
          TapjoyLog.e("TapjoyPoints", "Invalid XML: Missing tags.");
        }
      }
      finally {}
      TapjoyLog.e("TapjoyPoints", "Invalid XML: Missing <Success> tag.");
      label223:
      boolean bool = false;
    }
  }
  
  private boolean handleSpendPointsResponse(String paramString)
  {
    paramString = TapjoyUtil.buildDocument(paramString);
    String str;
    if (paramString != null)
    {
      str = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Success"));
      if ((str == null) || (!str.equals("true"))) {
        break label98;
      }
      str = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("TapPoints"));
      paramString = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("CurrencyName"));
      if ((str != null) && (paramString != null))
      {
        saveTapPointsTotal(Integer.parseInt(str));
        tapjoySpendPointsNotifier.getSpendPointsResponse(paramString, Integer.parseInt(str));
        return true;
      }
      TapjoyLog.e("TapjoyPoints", "Invalid XML: Missing tags.");
    }
    for (;;)
    {
      return false;
      label98:
      if ((str != null) && (str.endsWith("false")))
      {
        paramString = TapjoyUtil.getNodeTrimValue(paramString.getElementsByTagName("Message"));
        TapjoyLog.i("TapjoyPoints", paramString);
        tapjoySpendPointsNotifier.getSpendPointsResponseFailed(paramString);
        return true;
      }
      TapjoyLog.e("TapjoyPoints", "Invalid XML: Missing <Success> tag.");
    }
  }
  
  public void awardTapPoints(int paramInt, TapjoyAwardPointsNotifier paramTapjoyAwardPointsNotifier)
  {
    if (paramInt < 0)
    {
      TapjoyLog.e("TapjoyPoints", "spendTapPoints error: amount must be a positive number");
      return;
    }
    this.awardTapPoints = paramInt;
    tapjoyAwardPointsNotifier = paramTapjoyAwardPointsNotifier;
    new Thread(new Runnable()
    {
      public void run()
      {
        boolean bool = false;
        Object localObject = UUID.randomUUID().toString();
        long l = System.currentTimeMillis() / 1000L;
        Map localMap = TapjoyConnectCore.getGenericURLParams();
        TapjoyUtil.safePut(localMap, "tap_points", String.valueOf(TJPoints.this.awardTapPoints), true);
        TapjoyUtil.safePut(localMap, "guid", (String)localObject, true);
        TapjoyUtil.safePut(localMap, "timestamp", String.valueOf(l), true);
        TapjoyUtil.safePut(localMap, "verifier", TapjoyConnectCore.getAwardPointsVerifier(l, TJPoints.this.awardTapPoints, (String)localObject), true);
        localObject = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + "points/award?", localMap);
        if (((TapjoyHttpURLResponse)localObject).response != null) {
          bool = TJPoints.this.handleAwardPointsResponse(((TapjoyHttpURLResponse)localObject).response);
        }
        if (!bool) {
          TJPoints.tapjoyAwardPointsNotifier.getAwardPointsResponseFailed("Failed to award points.");
        }
      }
    }).start();
  }
  
  public int getLocalTapPointsTotal()
  {
    return this.context.getSharedPreferences("tjcPrefrences", 0).getInt("last_tap_points", 55537);
  }
  
  public void getTapPoints(TapjoyNotifier paramTapjoyNotifier)
  {
    tapjoyNotifier = paramTapjoyNotifier;
    new Thread(new Runnable()
    {
      public void run()
      {
        boolean bool = false;
        TapjoyHttpURLResponse localTapjoyHttpURLResponse = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + "get_vg_store_items/user_account?", TapjoyConnectCore.getURLParams());
        if (localTapjoyHttpURLResponse.response != null) {
          bool = TJPoints.this.handleGetPointsResponse(localTapjoyHttpURLResponse.response);
        }
        if (!bool) {
          TJPoints.tapjoyNotifier.getUpdatePointsFailed("Failed to retrieve points from server");
        }
      }
    }).start();
  }
  
  public void saveTapPointsTotal(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("tjcPrefrences", 0).edit();
    localEditor.putInt("last_tap_points", paramInt);
    localEditor.commit();
  }
  
  public void setEarnedPointsNotifier(TapjoyEarnedPointsNotifier paramTapjoyEarnedPointsNotifier)
  {
    tapjoyEarnedPointsNotifier = paramTapjoyEarnedPointsNotifier;
  }
  
  public void spendTapPoints(int paramInt, TapjoySpendPointsNotifier paramTapjoySpendPointsNotifier)
  {
    if (paramInt < 0)
    {
      TapjoyLog.e("TapjoyPoints", "spendTapPoints error: amount must be a positive number");
      return;
    }
    this.spendTapPoints = ("" + paramInt);
    tapjoySpendPointsNotifier = paramTapjoySpendPointsNotifier;
    new Thread(new Runnable()
    {
      public void run()
      {
        boolean bool = false;
        Object localObject = TapjoyConnectCore.getURLParams();
        TapjoyUtil.safePut((Map)localObject, "tap_points", TJPoints.this.spendTapPoints, true);
        localObject = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + "points/spend?", (Map)localObject);
        if (((TapjoyHttpURLResponse)localObject).response != null) {
          bool = TJPoints.this.handleSpendPointsResponse(((TapjoyHttpURLResponse)localObject).response);
        }
        if (!bool) {
          TJPoints.tapjoySpendPointsNotifier.getSpendPointsResponseFailed("Failed to spend points.");
        }
      }
    }).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJPoints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */