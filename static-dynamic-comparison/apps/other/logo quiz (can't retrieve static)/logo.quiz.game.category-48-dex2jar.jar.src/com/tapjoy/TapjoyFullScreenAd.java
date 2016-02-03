package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import java.util.Map;

public class TapjoyFullScreenAd
{
  private static final String TAG = "Full Screen Ad";
  private static String baseURL = null;
  private static TapjoyFeaturedAppNotifier featuredAppNotifier;
  private static TapjoyFullScreenAdNotifier fullScreenAdNotifier;
  private static String htmlResponseData = null;
  private Context context;
  private Map<String, String> legacyFullScreenAdParams;
  
  public TapjoyFullScreenAd(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void getFeaturedApp(TapjoyFeaturedAppNotifier paramTapjoyFeaturedAppNotifier)
  {
    TapjoyLog.i("Full Screen Ad", "getFeaturedApp");
    getFeaturedApp(null, paramTapjoyFeaturedAppNotifier);
  }
  
  public void getFeaturedApp(String paramString, TapjoyFeaturedAppNotifier paramTapjoyFeaturedAppNotifier)
  {
    featuredAppNotifier = paramTapjoyFeaturedAppNotifier;
    getFullScreenAdLegacy(paramString);
  }
  
  public void getFullScreenAd(TapjoyFullScreenAdNotifier paramTapjoyFullScreenAdNotifier)
  {
    TapjoyLog.i("Full Screen Ad", "getFullScreenAd");
    getFullScreenAd(null, paramTapjoyFullScreenAdNotifier);
  }
  
  public void getFullScreenAd(String paramString, TapjoyFullScreenAdNotifier paramTapjoyFullScreenAdNotifier)
  {
    fullScreenAdNotifier = paramTapjoyFullScreenAdNotifier;
    getFullScreenAdLegacy(paramString);
  }
  
  public void getFullScreenAdLegacy(String paramString)
  {
    TapjoyLog.i("Full Screen Ad", "Getting Full Screen Ad");
    this.legacyFullScreenAdParams = TapjoyConnectCore.getURLParams();
    TapjoyUtil.safePut(this.legacyFullScreenAdParams, "currency_id", paramString, true);
    this.legacyFullScreenAdParams.putAll(TapjoyConnectCore.getVideoParams());
    new Thread(new Runnable()
    {
      public void run()
      {
        TapjoyHttpURLResponse localTapjoyHttpURLResponse = new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + "get_offers/featured.html?", TapjoyFullScreenAd.this.legacyFullScreenAdParams);
        TapjoyFullScreenAd.access$102(TapjoyConnectCore.getHostURL());
        if (localTapjoyHttpURLResponse != null) {
          switch (localTapjoyHttpURLResponse.statusCode)
          {
          default: 
            if (TapjoyFullScreenAd.featuredAppNotifier != null) {
              TapjoyFullScreenAd.featuredAppNotifier.getFeaturedAppResponseFailed("Error retrieving full screen ad data from the server.");
            }
            if (TapjoyFullScreenAd.fullScreenAdNotifier != null) {
              TapjoyFullScreenAd.fullScreenAdNotifier.getFullScreenAdResponseFailed(1);
            }
            break;
          }
        }
        do
        {
          do
          {
            return;
            TapjoyFullScreenAd.access$202(localTapjoyHttpURLResponse.response);
            if (TapjoyFullScreenAd.featuredAppNotifier != null) {
              TapjoyFullScreenAd.featuredAppNotifier.getFeaturedAppResponse(null);
            }
          } while (TapjoyFullScreenAd.fullScreenAdNotifier == null);
          TapjoyFullScreenAd.fullScreenAdNotifier.getFullScreenAdResponse();
          return;
          if (TapjoyFullScreenAd.featuredAppNotifier != null) {
            TapjoyFullScreenAd.featuredAppNotifier.getFeaturedAppResponseFailed("Error retrieving full screen ad data from the server.");
          }
        } while (TapjoyFullScreenAd.fullScreenAdNotifier == null);
        TapjoyFullScreenAd.fullScreenAdNotifier.getFullScreenAdResponseFailed(2);
      }
    }).start();
  }
  
  public void setDisplayCount(int paramInt) {}
  
  public void showFeaturedAppFullScreenAd()
  {
    if ((htmlResponseData != null) && (htmlResponseData.length() > 0))
    {
      Intent localIntent = new Intent(this.context, TapjoyFeaturedAppWebView.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("html", htmlResponseData);
      localIntent.putExtra("base_url", baseURL);
      localIntent.putExtra("legacy_view", true);
      this.context.startActivity(localIntent);
    }
  }
  
  public void showFullScreenAd()
  {
    if ((htmlResponseData != null) && (htmlResponseData.length() > 0))
    {
      Intent localIntent = new Intent(this.context, TapjoyFullScreenAdWebView.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("html", htmlResponseData);
      localIntent.putExtra("base_url", baseURL);
      localIntent.putExtra("legacy_view", true);
      this.context.startActivity(localIntent);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyFullScreenAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */