package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJAdUnitView
  extends Activity
{
  private static final String TAG = "TJAdUnitView";
  protected TJAdUnitJSBridge bridge;
  private String callbackID;
  private TJEvent event;
  private TJEventData eventData;
  protected int historyIndex = 0;
  private boolean isLegacyView = false;
  protected RelativeLayout layout = null;
  protected String offersURL = null;
  protected boolean pauseCalled = false;
  private ProgressBar progressBar;
  protected boolean redirectedActivity;
  protected boolean skipOfferWall = false;
  protected String url = null;
  private int viewType = 0;
  protected MraidView webView = null;
  
  private void finishWithResult(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  private void handleBackKey()
  {
    this.bridge.shouldClose = false;
    if ((this.isLegacyView) && (this.webView.canGoBack())) {
      if (this.webView.copyBackForwardList().getCurrentIndex() == this.historyIndex) {
        if (this != null) {
          finish();
        }
      }
    }
    do
    {
      return;
      this.webView.goBack();
      return;
      if (this.viewType == 4)
      {
        finishWithResult("offer_wall");
        return;
      }
    } while (this == null);
    finish();
  }
  
  private void handleTJVideoURL(String paramString)
  {
    Object localObject = TapjoyUtil.convertURLParams(paramString.substring(paramString.indexOf("://") + "://".length()), true);
    paramString = (String)((Map)localObject).get("video_id");
    String str1 = (String)((Map)localObject).get("amount");
    String str2 = (String)((Map)localObject).get("currency_name");
    String str3 = (String)((Map)localObject).get("click_url");
    String str4 = (String)((Map)localObject).get("video_complete_url");
    localObject = (String)((Map)localObject).get("video_url");
    TapjoyLog.i("TJAdUnitView", "video_id: " + paramString);
    TapjoyLog.i("TJAdUnitView", "amount: " + str1);
    TapjoyLog.i("TJAdUnitView", "currency_name: " + str2);
    TapjoyLog.i("TJAdUnitView", "click_url: " + str3);
    TapjoyLog.i("TJAdUnitView", "video_complete_url: " + str4);
    TapjoyLog.i("TJAdUnitView", "video_url: " + (String)localObject);
    if (TapjoyVideo.getInstance().startVideo(paramString, str2, str1, str3, str4, (String)localObject))
    {
      TapjoyLog.i("TJAdUnitView", "Video started successfully");
      return;
    }
    TapjoyLog.e("TJAdUnitView", "Unable to play video: " + paramString);
    paramString = new AlertDialog.Builder(this).setTitle("").setMessage("Unable to play video.").setPositiveButton("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).create();
    try
    {
      paramString.show();
      return;
    }
    catch (Exception paramString)
    {
      TapjoyLog.e("TJAdUnitView", "e: " + paramString.toString());
    }
  }
  
  public void finish()
  {
    if ((this.viewType != 1) && (this.viewType != 4))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", Boolean.TRUE);
      localIntent.putExtra("callback_id", this.callbackID);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  protected void initUI()
  {
    TapjoyLog.i("TJAdUnitView", "initUI");
    int i = 0;
    Object localObject1 = getIntent().getExtras();
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      if (((Bundle)localObject1).getString("DISPLAY_AD_URL") == null) {
        break label509;
      }
      this.skipOfferWall = true;
      this.offersURL = ((Bundle)localObject1).getString("DISPLAY_AD_URL");
      this.eventData = ((TJEventData)((Bundle)localObject1).getSerializable("tjevent"));
      if (this.eventData != null) {
        this.event = TJEventManager.get(this.eventData.guid);
      }
      this.viewType = ((Bundle)localObject1).getInt("view_type");
      localObject2 = ((Bundle)localObject1).getString("html");
      str = ((Bundle)localObject1).getString("base_url");
      this.url = ((Bundle)localObject1).getString("url");
      this.callbackID = ((Bundle)localObject1).getString("callback_id");
      this.isLegacyView = ((Bundle)localObject1).getBoolean("legacy_view");
      if (this.webView == null)
      {
        this.webView = new MraidView(this);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.clearCache(true);
        this.webView.setListener(new TJAdUnitViewListener(null));
        if (this.viewType != 1) {
          break label597;
        }
        if (this.event != null) {
          this.webView.loadDataWithBaseURL(this.eventData.baseURL, this.eventData.httpResponse, "text/html", "utf-8", null);
        }
        this.webView.setVisibility(4);
        this.event.getCallback().contentDidShow(this.event);
        this.bridge = new TJAdUnitJSBridge(this, this.webView, this.eventData);
        if (Build.VERSION.SDK_INT >= 11) {
          getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(1610612736));
        localObject1 = new ViewGroup.LayoutParams(-1, -1);
        this.layout = new RelativeLayout(this);
        this.layout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (this.viewType != 1) {
          break label742;
        }
        this.layout.setBackgroundColor(0);
        this.layout.getBackground().setAlpha(0);
      }
    }
    for (;;)
    {
      this.webView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.webView.getParent() != null) {
        ((ViewGroup)this.webView.getParent()).removeView(this.webView);
      }
      this.layout.addView(this.webView, -1, -1);
      setContentView(this.layout);
      if ((this.isLegacyView) && (i != 0))
      {
        this.progressBar = new ProgressBar(this, null, 16842874);
        this.progressBar.setVisibility(0);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(13);
        this.progressBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.layout.addView(this.progressBar);
      }
      return;
      label509:
      if (((Bundle)localObject1).getSerializable("URL_PARAMS") == null) {
        break;
      }
      this.skipOfferWall = false;
      localObject2 = (HashMap)((Bundle)localObject1).getSerializable("URL_PARAMS");
      TapjoyLog.i("TJAdUnitView", "urlParams: " + localObject2);
      this.offersURL = (TapjoyConnectCore.getHostURL() + "get_offers/webpage?" + TapjoyUtil.convertURLParams((Map)localObject2, false));
      break;
      label597:
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        TapjoyLog.i("TJAdUnitView", "HTML data");
        if (this.isLegacyView) {
          this.webView.loadDataWithBaseURL(str, (String)localObject2, "text/html", "utf-8", null);
        }
      }
      for (;;)
      {
        i = 1;
        break;
        this.webView.loadDataWithBaseURL(null, (String)localObject2, "text/html", "utf-8", null);
        continue;
        if (this.url != null)
        {
          TapjoyLog.i("TJAdUnitView", "Load URL: " + this.url);
          this.webView.loadUrl(this.url);
        }
        else if (this.offersURL != null)
        {
          TapjoyLog.i("TJAdUnitView", "Load Offer Wall URL");
          this.webView.loadUrl(this.offersURL);
        }
      }
      label742:
      this.layout.setBackgroundColor(-1);
      this.layout.getBackground().setAlpha(255);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("TJAdUnitView", "onActivityResult requestCode:" + paramInt1 + ", resultCode: " + paramInt2);
    Bundle localBundle = null;
    if (paramIntent != null) {
      localBundle = paramIntent.getExtras();
    }
    if ((localBundle != null) && (localBundle.getString("callback_id") != null))
    {
      TapjoyLog.i("TJAdUnitView", "onActivityResult extras: " + localBundle.keySet());
      this.bridge.invokeJSCallback(localBundle.getString("callback_id"), new Object[] { Boolean.valueOf(localBundle.getBoolean("result")) });
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    TapjoyLog.i("TJAdUnitView", "onConfigurationChanged");
    super.onConfigurationChanged(paramConfiguration);
    initUI();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 11) {
      setTheme(16973839);
    }
    for (;;)
    {
      TapjoyLog.i("TJAdUnitView", "TJAdUnitView onCreate: " + paramBundle);
      super.onCreate(paramBundle);
      initUI();
      return;
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TapjoyLog.i("TJAdUnitView", "onDestroy isFinishing: " + isFinishing());
    if (isFinishing())
    {
      if (this.viewType == 1)
      {
        this.bridge.destroy();
        if (this.event != null) {
          this.event.getCallback().contentDidDisappear(this.event);
        }
        TJEventManager.remove(this.eventData.guid);
      }
      if (this.webView == null) {}
    }
    try
    {
      WebView.class.getMethod("onPause", new Class[0]).invoke(this.webView, new Object[0]);
      try
      {
        this.webView.clearCache(true);
        this.webView.destroyDrawingCache();
        this.webView = null;
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.webView.videoPlaying())
      {
        this.webView.videoViewCleanup();
        return true;
      }
      if (this.bridge.customClose)
      {
        TapjoyLog.i("TJAdUnitView", "customClose");
        if (this.bridge.shouldClose)
        {
          TapjoyLog.i("TJAdUnitView", "customClose called twice before first request completed");
          handleBackKey();
          return true;
        }
        TapjoyLog.i("TJAdUnitView", "closeRequested...");
        this.bridge.closeRequested();
        paramKeyEvent = new TimerTask()
        {
          public void run()
          {
            if (TJAdUnitView.this.bridge.shouldClose)
            {
              TapjoyLog.i("TJAdUnitView", "customClose timeout");
              TJAdUnitView.this.handleBackKey();
            }
          }
        };
        new Timer().schedule(paramKeyEvent, 1000L);
        return true;
      }
      handleBackKey();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.pauseCalled = true;
    try
    {
      WebView.class.getMethod("onPause", new Class[0]).invoke(this.webView, new Object[0]);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.webView.restoreState(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      WebView.class.getMethod("onResume", new Class[0]).invoke(this.webView, new Object[0]);
      if ((this.viewType == 1) && (this.bridge.didLaunchOtherActivity))
      {
        TapjoyLog.i("TJAdUnitView", "onResume bridge.didLaunchOtherActivity callbackID: " + this.bridge.otherActivityCallbackID);
        this.bridge.invokeJSCallback(this.bridge.otherActivityCallbackID, new Object[] { Boolean.TRUE });
        this.bridge.didLaunchOtherActivity = false;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.webView.saveState(paramBundle);
  }
  
  private class TJAdUnitViewListener
    implements MraidViewListener
  {
    private TJAdUnitViewListener() {}
    
    public boolean onClose()
    {
      TJAdUnitView.this.finish();
      return false;
    }
    
    @TargetApi(8)
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      if (TJAdUnitView.this.bridge.shouldClose)
      {
        String[] arrayOfString = new String[5];
        arrayOfString[0] = "Uncaught";
        arrayOfString[1] = "uncaught";
        arrayOfString[2] = "Error";
        arrayOfString[3] = "error";
        arrayOfString[4] = "not defined";
        TapjoyLog.i("TJAdUnitView", "shouldClose...");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (paramConsoleMessage.message().contains(str)) {
            TJAdUnitView.this.handleBackKey();
          }
          i += 1;
        }
      }
      return true;
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
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (TJAdUnitView.this.isLegacyView) {
        TJAdUnitView.this.progressBar.setVisibility(8);
      }
      TJAdUnitView.this.bridge.display();
      if ((TJAdUnitView.this.webView != null) && (TJAdUnitView.this.webView.isMraid())) {
        TJAdUnitView.this.bridge.allowRedirect = false;
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      TapjoyLog.i("TJAdUnitView", "onPageStarted: " + paramString);
      if (TJAdUnitView.this.isLegacyView)
      {
        TJAdUnitView.this.progressBar.setVisibility(0);
        TJAdUnitView.this.progressBar.bringToFront();
      }
      if (TJAdUnitView.this.bridge != null)
      {
        TJAdUnitView.this.bridge.allowRedirect = true;
        TJAdUnitView.this.bridge.customClose = false;
        TJAdUnitView.this.bridge.shouldClose = false;
      }
    }
    
    public boolean onReady()
    {
      return false;
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
    
    public boolean onResize()
    {
      return false;
    }
    
    public boolean onResizeClose()
    {
      return false;
    }
    
    @TargetApi(9)
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      TJAdUnitView.this.redirectedActivity = false;
      TapjoyLog.i("TJAdUnitView", "interceptURL: " + paramString);
      if ((TJAdUnitView.this.webView != null) && (TJAdUnitView.this.webView.isMraid()) && (paramString.contains("mraid"))) {
        return false;
      }
      if ((TJAdUnitView.this.viewType == 4) && (paramString.contains("offer_wall")))
      {
        TJAdUnitView.this.finishWithResult("offer_wall");
        return true;
      }
      if ((TJAdUnitView.this.viewType == 4) && (paramString.contains("tjvideo")))
      {
        TJAdUnitView.this.finishWithResult("tjvideo");
        return true;
      }
      if (paramString.startsWith("tjvideo://"))
      {
        TJAdUnitView.this.handleTJVideoURL(paramString);
        return true;
      }
      if (paramString.contains("showOffers"))
      {
        TapjoyLog.i("TJAdUnitView", "showOffers");
        new TJCOffers(TJAdUnitView.this).showOffers();
        return true;
      }
      if (paramString.contains("dismiss"))
      {
        TapjoyLog.i("TJAdUnitView", "dismiss");
        TJAdUnitView.this.finish();
        return true;
      }
      if (paramString.startsWith("http://ok"))
      {
        TapjoyLog.i("TJAdUnitView", "http://ok");
        TJAdUnitView.this.finish();
        return true;
      }
      if ((paramString.contains("ws.tapjoyads.com")) || (paramString.contains("tjyoutubevideo=true")) || (paramString.contains(TapjoyConnectCore.getRedirectDomain())))
      {
        TapjoyLog.i("TJAdUnitView", "Open redirecting URL:" + paramString);
        ((MraidView)paramWebView).loadUrlStandard(paramString);
        return true;
      }
      if (TJAdUnitView.this.bridge.allowRedirect)
      {
        TJAdUnitView.this.redirectedActivity = true;
        return false;
      }
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJAdUnitView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */