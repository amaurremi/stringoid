package com.tapjoy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout.LayoutParams;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.view.MraidView;
import com.tapjoy.mraid.view.MraidView.PLACEMENT_TYPE;
import com.tapjoy.mraid.view.MraidView.VIEW_STATE;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class TapjoyDisplayAd
{
  private static final String TAG = "Banner Ad";
  private static int bannerHeight;
  private static int bannerWidth;
  private static TapjoyDisplayAdNotifier displayAdNotifier;
  private static String displayAdSize;
  public static Map<String, String> displayAdURLParams;
  private static String htmlData;
  private static String lastCurrencyID;
  private static TapjoyURLConnection tapjoyURLConnection = null;
  private Activity activityContext;
  View adView;
  private boolean autoRefresh;
  long elapsed_time;
  Bitmap lastAd;
  Timer resumeTimer;
  Timer timer;
  MraidView webView;
  
  public TapjoyDisplayAd(Context paramContext)
  {
    setDisplayAdSize("640x100");
    tapjoyURLConnection = new TapjoyURLConnection();
  }
  
  public static String getHtmlString()
  {
    return htmlData;
  }
  
  public void enableAutoRefresh(boolean paramBoolean)
  {
    this.autoRefresh = paramBoolean;
  }
  
  public String getBannerAdSize()
  {
    return getDisplayAdSize();
  }
  
  public void getDisplayAd(Activity paramActivity, TapjoyDisplayAdNotifier paramTapjoyDisplayAdNotifier)
  {
    TapjoyLog.i("Banner Ad", "Get Banner Ad");
    getDisplayAd(paramActivity, null, paramTapjoyDisplayAdNotifier);
  }
  
  public void getDisplayAd(Activity paramActivity, String paramString, TapjoyDisplayAdNotifier paramTapjoyDisplayAdNotifier)
  {
    TapjoyLog.i("Banner Ad", "Get Banner Ad, currencyID: " + paramString);
    displayAdNotifier = paramTapjoyDisplayAdNotifier;
    if (paramActivity == null)
    {
      Log.e("Banner Ad", "getDisplayAd must take an Activity context");
      if (displayAdNotifier != null) {
        displayAdNotifier.getDisplayAdResponseFailed("getDisplayAd must take an Activity context");
      }
      return;
    }
    this.activityContext = paramActivity;
    this.activityContext.runOnUiThread(new Runnable()
    {
      public void run()
      {
        TapjoyDisplayAd.this.webView = new MraidView(TapjoyDisplayAd.this.activityContext);
      }
    });
    lastCurrencyID = paramString;
    displayAdURLParams = TapjoyConnectCore.getURLParams();
    TapjoyUtil.safePut(displayAdURLParams, "size", displayAdSize, true);
    TapjoyUtil.safePut(displayAdURLParams, "currency_id", paramString, true);
    new GetBannerAdTask(null).execute(new Object[] { TapjoyConnectCore.getHostURL() + "display_ad.html?", displayAdURLParams });
  }
  
  public String getDisplayAdSize()
  {
    return displayAdSize;
  }
  
  public void setBannerAdSize(String paramString)
  {
    setDisplayAdSize(paramString);
  }
  
  public void setDisplayAdSize(String paramString)
  {
    displayAdSize = paramString;
    if (paramString.equals("320x50"))
    {
      bannerWidth = 320;
      bannerHeight = 50;
    }
    do
    {
      return;
      if (paramString.equals("640x100"))
      {
        bannerWidth = 640;
        bannerHeight = 100;
        return;
      }
    } while (!paramString.equals("768x90"));
    bannerWidth = 768;
    bannerHeight = 90;
  }
  
  private class CheckForResumeTimer
    extends TimerTask
  {
    private CheckForResumeTimer() {}
    
    public void run()
    {
      TapjoyDisplayAd localTapjoyDisplayAd = TapjoyDisplayAd.this;
      localTapjoyDisplayAd.elapsed_time += 10000L;
      TapjoyLog.i("Banner Ad", "banner elapsed_time: " + TapjoyDisplayAd.this.elapsed_time + " (" + TapjoyDisplayAd.this.elapsed_time / 1000L / 60L + "m " + TapjoyDisplayAd.this.elapsed_time / 1000L % 60L + "s)");
      if (TapjoyDisplayAd.this.adView == null) {
        cancel();
      }
      do
      {
        return;
        TapjoyLog.i("Banner Ad", "adView.isShown: " + TapjoyDisplayAd.this.adView.isShown());
        if ((TapjoyDisplayAd.this.adView.isShown()) && (TapjoyConnectCore.getInstance() != null))
        {
          TapjoyLog.i("Banner Ad", "call connect");
          TapjoyConnectCore.getInstance().callConnect();
          cancel();
        }
      } while (TapjoyDisplayAd.this.elapsed_time < 1200000L);
      cancel();
    }
  }
  
  private class GetBannerAdTask
    extends AsyncTask<Object, Void, TapjoyHttpURLResponse>
  {
    private GetBannerAdTask() {}
    
    protected TapjoyHttpURLResponse doInBackground(Object... paramVarArgs)
    {
      String str = (String)paramVarArgs[0];
      paramVarArgs = (Map)paramVarArgs[1];
      return TapjoyDisplayAd.tapjoyURLConnection.getResponseFromURL(str, paramVarArgs);
    }
    
    protected void onPostExecute(TapjoyHttpURLResponse paramTapjoyHttpURLResponse)
    {
      if (paramTapjoyHttpURLResponse != null) {
        switch (paramTapjoyHttpURLResponse.statusCode)
        {
        default: 
          TapjoyDisplayAd.displayAdNotifier.getDisplayAdResponseFailed("No ad to display.");
        }
      }
      do
      {
        return;
        TapjoyDisplayAd.access$402(paramTapjoyHttpURLResponse.response);
        TapjoyDisplayAd.this.webView.getSettings().setJavaScriptEnabled(true);
        TapjoyDisplayAd.this.webView.setPlacementType(MraidView.PLACEMENT_TYPE.INLINE);
        TapjoyLog.i("Banner Ad", "response: " + paramTapjoyHttpURLResponse.response);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(TapjoyDisplayAd.bannerWidth, TapjoyDisplayAd.bannerHeight);
        TapjoyDisplayAd.this.webView.setLayoutParams(localLayoutParams);
        TapjoyDisplayAd.this.webView.setInitialScale(100);
        TapjoyDisplayAd.this.webView.setBackgroundColor(0);
        TapjoyDisplayAd.this.webView.loadDataWithBaseURL(null, paramTapjoyHttpURLResponse.response, "text/html", "utf-8", null);
        TapjoyLog.i("Banner Ad", "isMraid: " + TapjoyDisplayAd.this.webView.isMraid());
        if (!TapjoyDisplayAd.this.webView.isMraid()) {
          TapjoyDisplayAd.this.webView.setListener(new MraidViewListener()
          {
            public boolean onClose()
            {
              return false;
            }
            
            @TargetApi(8)
            public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
            {
              return false;
            }
            
            public boolean onEventFired()
            {
              return false;
            }
            
            public boolean onExpand()
            {
              return false;
            }
            
            public boolean onExpandClose()
            {
              return false;
            }
            
            public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {}
            
            public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
            
            public boolean onReady()
            {
              return false;
            }
            
            public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {}
            
            public boolean onResize()
            {
              return false;
            }
            
            public boolean onResizeClose()
            {
              return false;
            }
            
            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
            {
              TapjoyLog.i("Banner Ad", "shouldOverrideUrlLoading: " + paramAnonymousString);
              if ((paramAnonymousString.contains("ws.tapjoyads.com")) || (paramAnonymousString.contains("tjyoutubevideo=true")))
              {
                TapjoyLog.i("Banner Ad", "Open redirecting URL = [" + paramAnonymousString + "]");
                ((MraidView)paramAnonymousWebView).loadUrlStandard(paramAnonymousString);
              }
              for (;;)
              {
                if (TapjoyDisplayAd.this.resumeTimer != null) {
                  TapjoyDisplayAd.this.resumeTimer.cancel();
                }
                TapjoyDisplayAd.this.elapsed_time = 0L;
                TapjoyDisplayAd.this.resumeTimer = new Timer();
                TapjoyDisplayAd.this.resumeTimer.schedule(new TapjoyDisplayAd.CheckForResumeTimer(TapjoyDisplayAd.this, null), 10000L, 10000L);
                return true;
                paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
                TapjoyDisplayAd.this.activityContext.startActivity(paramAnonymousWebView);
              }
            }
          });
        }
        if (TapjoyDisplayAd.this.adView != null) {
          TapjoyDisplayAd.this.lastAd = TapjoyUtil.createBitmapFromView(TapjoyDisplayAd.this.adView);
        }
        TapjoyDisplayAd.this.adView = TapjoyDisplayAd.this.webView;
        TapjoyDisplayAd.displayAdNotifier.getDisplayAdResponse(TapjoyDisplayAd.this.adView);
        if (TapjoyDisplayAd.this.timer != null)
        {
          TapjoyDisplayAd.this.timer.cancel();
          TapjoyDisplayAd.this.timer = null;
        }
      } while ((!TapjoyDisplayAd.this.autoRefresh) || (TapjoyDisplayAd.this.timer != null));
      TapjoyLog.i("Banner Ad", "will refresh banner ad in 60000ms...");
      TapjoyDisplayAd.this.timer = new Timer();
      TapjoyDisplayAd.this.timer.schedule(new TapjoyDisplayAd.RefreshTimer(TapjoyDisplayAd.this, null), 60000L);
    }
    
    protected void onProgressUpdate(Void... paramVarArgs) {}
  }
  
  private class RefreshTimer
    extends TimerTask
  {
    private RefreshTimer() {}
    
    public void run()
    {
      if (TapjoyDisplayAd.this.webView.getState().equals(MraidView.VIEW_STATE.DEFAULT.toString().toLowerCase(Locale.ENGLISH)))
      {
        TapjoyLog.i("Banner Ad", "refreshing banner ad...");
        TapjoyDisplayAd.this.getDisplayAd(TapjoyDisplayAd.this.activityContext, TapjoyDisplayAd.lastCurrencyID, TapjoyDisplayAd.displayAdNotifier);
        TapjoyDisplayAd.this.timer.cancel();
        TapjoyDisplayAd.this.timer = null;
        return;
      }
      TapjoyLog.i("Banner Ad", "ad is not in default state.  will try refreshing again in 60000s...");
      TapjoyDisplayAd.this.timer.cancel();
      TapjoyDisplayAd.this.timer = null;
      TapjoyDisplayAd.this.timer = new Timer();
      TapjoyDisplayAd.this.timer.schedule(new RefreshTimer(TapjoyDisplayAd.this), 60000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyDisplayAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */