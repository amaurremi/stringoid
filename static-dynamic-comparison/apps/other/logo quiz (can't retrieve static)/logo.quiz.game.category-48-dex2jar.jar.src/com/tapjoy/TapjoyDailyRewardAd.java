package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import java.util.Map;

public class TapjoyDailyRewardAd
{
  private static final String TAG = "Daily Reward";
  private static TapjoyDailyRewardAdNotifier dailyRewardNotifier;
  private static String htmlResponseData = null;
  private Context context;
  private Map<String, String> legacyDailyRewardAdParams;
  
  public TapjoyDailyRewardAd(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void getDailyRewardAd(TapjoyDailyRewardAdNotifier paramTapjoyDailyRewardAdNotifier)
  {
    TapjoyLog.i("Daily Reward", "Getting Daily Reward Ad");
    getDailyRewardAdWithCurrencyID(null, paramTapjoyDailyRewardAdNotifier);
  }
  
  public void getDailyRewardAdLegacy(String paramString)
  {
    this.legacyDailyRewardAdParams = TapjoyConnectCore.getURLParams();
    TapjoyUtil.safePut(this.legacyDailyRewardAdParams, "currency_id", paramString, true);
    new Thread(new Runnable()
    {
      public void run()
      {
        TapjoyHttpURLResponse localTapjoyHttpURLResponse = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + "reengagement_rewards?", TapjoyDailyRewardAd.this.legacyDailyRewardAdParams);
        if (localTapjoyHttpURLResponse != null)
        {
          switch (localTapjoyHttpURLResponse.statusCode)
          {
          default: 
            return;
          case 200: 
            TapjoyDailyRewardAd.access$102(localTapjoyHttpURLResponse.response);
            TapjoyDailyRewardAd.dailyRewardNotifier.getDailyRewardAdResponse();
            return;
          }
          TapjoyDailyRewardAd.dailyRewardNotifier.getDailyRewardAdResponseFailed(1);
          return;
        }
        TapjoyDailyRewardAd.dailyRewardNotifier.getDailyRewardAdResponseFailed(2);
      }
    }).start();
  }
  
  public void getDailyRewardAdWithCurrencyID(String paramString, TapjoyDailyRewardAdNotifier paramTapjoyDailyRewardAdNotifier)
  {
    dailyRewardNotifier = paramTapjoyDailyRewardAdNotifier;
    getDailyRewardAdLegacy(paramString);
  }
  
  public void showDailyRewardAd()
  {
    TapjoyLog.i("Daily Reward", "Displaying Daily Reward ad...");
    if ((htmlResponseData != null) && (htmlResponseData.length() > 0))
    {
      Intent localIntent = new Intent(this.context, TapjoyDailyRewardAdWebView.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("html", htmlResponseData);
      localIntent.putExtra("base_url", TapjoyConnectCore.getHostURL());
      localIntent.putExtra("legacy_view", true);
      this.context.startActivity(localIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyDailyRewardAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */