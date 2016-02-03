package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.util.IntentUtils;
import com.mopub.mobileads.util.Utils;

class HtmlWebViewClient
  extends WebViewClient
{
  static final String MOPUB_FAIL_LOAD = "mopub://failLoad";
  static final String MOPUB_FINISH_LOAD = "mopub://finishLoad";
  private final String mClickthroughUrl;
  private final Context mContext;
  private BaseHtmlWebView mHtmlWebView;
  private HtmlWebViewListener mHtmlWebViewListener;
  private final String mRedirectUrl;
  
  HtmlWebViewClient(HtmlWebViewListener paramHtmlWebViewListener, BaseHtmlWebView paramBaseHtmlWebView, String paramString1, String paramString2)
  {
    this.mHtmlWebViewListener = paramHtmlWebViewListener;
    this.mHtmlWebView = paramBaseHtmlWebView;
    this.mClickthroughUrl = paramString1;
    this.mRedirectUrl = paramString2;
    this.mContext = paramBaseHtmlWebView.getContext();
  }
  
  private void handleCustomIntentFromUri(Uri paramUri)
  {
    try
    {
      String str1 = paramUri.getQueryParameter("fnc");
      String str2 = paramUri.getQueryParameter("data");
      paramUri = new Intent(str1);
      paramUri.addFlags(268435456);
      paramUri.putExtra("com.mopub.intent.extra.AD_CLICK_DATA", str2);
      str1 = "Could not handle custom intent: " + str1 + ". Is your intent spelled correctly?";
      launchIntentForUserClick(this.mContext, paramUri, str1);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.w("MoPub", "Could not handle custom intent with uri: " + paramUri);
    }
  }
  
  private boolean handleNativeBrowserScheme(String paramString)
  {
    if (!isNativeBrowserScheme(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = Uri.parse(paramString);
      try
      {
        String str = ((Uri)localObject).getQueryParameter("url");
        if (("navigate".equals(((Uri)localObject).getHost())) && (str != null))
        {
          localObject = new Intent("android.intent.action.VIEW", Uri.parse(str));
          ((Intent)localObject).setFlags(268435456);
          paramString = "Could not handle intent with URI: " + paramString + ". Is this intent supported on your phone?";
          launchIntentForUserClick(this.mContext, (Intent)localObject, paramString);
          return true;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Log.w("MoPub", "Could not handle url: " + paramString);
      }
    }
    return false;
  }
  
  private boolean handlePhoneScheme(String paramString)
  {
    if (!isPhoneScheme(paramString)) {
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    localIntent.addFlags(268435456);
    paramString = "Could not handle intent with URI: " + paramString + ". Is this intent supported on your phone?";
    launchIntentForUserClick(this.mContext, localIntent, paramString);
    return true;
  }
  
  private boolean handleSpecialMoPubScheme(String paramString)
  {
    if (!isSpecialMoPubScheme(paramString)) {
      return false;
    }
    paramString = Uri.parse(paramString);
    String str = paramString.getHost();
    if ("finishLoad".equals(str)) {
      this.mHtmlWebViewListener.onLoaded(this.mHtmlWebView);
    }
    for (;;)
    {
      return true;
      if ("close".equals(str)) {
        this.mHtmlWebViewListener.onCollapsed();
      } else if ("failLoad".equals(str)) {
        this.mHtmlWebViewListener.onFailed(MoPubErrorCode.UNSPECIFIED);
      } else if ("custom".equals(str)) {
        handleCustomIntentFromUri(paramString);
      }
    }
  }
  
  private boolean isNativeBrowserScheme(String paramString)
  {
    return paramString.startsWith("mopubnativebrowser://");
  }
  
  private boolean isPhoneScheme(String paramString)
  {
    return (paramString.startsWith("tel:")) || (paramString.startsWith("voicemail:")) || (paramString.startsWith("sms:")) || (paramString.startsWith("mailto:")) || (paramString.startsWith("geo:")) || (paramString.startsWith("google.streetview:"));
  }
  
  private boolean isSpecialMoPubScheme(String paramString)
  {
    return paramString.startsWith("mopub://");
  }
  
  private boolean isWebSiteUrl(String paramString)
  {
    return (paramString.startsWith("http://")) || (paramString.startsWith("https://"));
  }
  
  private boolean launchApplicationUrl(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    return launchIntentForUserClick(this.mContext, paramString, "Unable to open intent.");
  }
  
  private void showMoPubBrowserForUrl(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = "about:blank";
    }
    Log.d("MoPub", "Final URI to show in browser: " + str);
    paramString = new Intent(this.mContext, MoPubBrowser.class);
    paramString.putExtra("URL", str);
    paramString.addFlags(268435456);
    if (!launchIntentForUserClick(this.mContext, paramString, "Could not handle intent action. . Perhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file."))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse("about:blank"));
      paramString.setFlags(268435456);
      launchIntentForUserClick(this.mContext, paramString, null);
    }
  }
  
  private String urlWithClickTrackingRedirect(String paramString)
  {
    if (this.mClickthroughUrl == null) {
      return paramString;
    }
    paramString = Uri.encode(paramString);
    return this.mClickthroughUrl + "&r=" + paramString;
  }
  
  boolean launchIntentForUserClick(Context paramContext, Intent paramIntent, String paramString)
  {
    boolean bool1;
    if (!this.mHtmlWebView.wasClicked()) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = Utils.executeIntent(paramContext, paramIntent, paramString);
      bool1 = bool2;
    } while (!bool2);
    this.mHtmlWebViewListener.onClicked();
    this.mHtmlWebView.onResetUserClick();
    return bool2;
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.mRedirectUrl != null) && (paramString.startsWith(this.mRedirectUrl)))
    {
      paramString = urlWithClickTrackingRedirect(paramString);
      paramWebView.stopLoading();
      showMoPubBrowserForUrl(paramString);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((handleSpecialMoPubScheme(paramString)) || (handlePhoneScheme(paramString)) || (handleNativeBrowserScheme(paramString))) {}
    do
    {
      return true;
      paramWebView = urlWithClickTrackingRedirect(paramString);
      Log.d("MoPub", "Ad clicked. Click URL: " + paramWebView);
    } while ((!isWebSiteUrl(paramWebView)) && (IntentUtils.canHandleApplicationUrl(this.mContext, paramWebView)) && (launchApplicationUrl(paramWebView)));
    showMoPubBrowserForUrl(paramWebView);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/HtmlWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */