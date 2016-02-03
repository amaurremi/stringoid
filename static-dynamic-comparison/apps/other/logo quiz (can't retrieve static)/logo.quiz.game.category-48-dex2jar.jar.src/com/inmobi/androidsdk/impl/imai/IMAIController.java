package com.inmobi.androidsdk.impl.imai;

import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;

public class IMAIController
{
  public static final String IMAI_BRIDGE = "imaiController";
  private transient WeakReference<IMWebView> a;
  
  public IMAIController(IMWebView paramIMWebView)
  {
    IMAIUtility.initialize();
    this.a = new WeakReference(paramIMWebView);
  }
  
  @JavascriptInterface
  public String getPlatformVersion()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "get platform version");
    return Integer.toString(Build.VERSION.SDK_INT);
  }
  
  @JavascriptInterface
  public void log(String paramString)
  {
    Log.debug("InMobiAndroidSDK_3.7.1", paramString);
  }
  
  @JavascriptInterface
  public void openEmbedded(String paramString)
  {
    try
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "IMAI open Embedded");
      if (!IMAIUtility.validateURL(paramString))
      {
        IMAIUtility.fireErrorEvent(this.a, "Null url passed", "openEmbedded", paramString);
        return;
      }
      if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
      {
        IMAIUtility.launchEmbeddedBrowser(this.a, paramString);
        IMAIUtility.fireOpenEmbeddedSuccessful(this.a, paramString);
        return;
      }
    }
    catch (Exception localException)
    {
      IMAIUtility.fireErrorEvent(this.a, localException.getMessage(), "openEmbedded", paramString);
      Log.internal("InMobiAndroidSDK_3.7.1", "IMAI openEmbedded failed", localException);
      return;
    }
    openExternal(paramString);
  }
  
  @JavascriptInterface
  public void openExternal(String paramString)
  {
    try
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "IMAI open external");
      if (!IMAIUtility.validateURL(paramString))
      {
        IMAIUtility.fireErrorEvent(this.a, "Null url passed", "openExternal", paramString);
        return;
      }
      IMAIUtility.launchExternalApp(paramString);
      IMAIUtility.fireOpenExternalSuccessful(this.a, paramString);
      return;
    }
    catch (Exception localException)
    {
      IMAIUtility.fireErrorEvent(this.a, localException.getMessage(), "openExternal", paramString);
      Log.internal("InMobiAndroidSDK_3.7.1", "IMAI openExternal failed", localException);
    }
  }
  
  @JavascriptInterface
  public void ping(String paramString, boolean paramBoolean)
  {
    try
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "IMAI ping");
      if (!IMAIUtility.validateURL(paramString))
      {
        IMAIUtility.fireErrorEvent(this.a, "Null url passed", "ping", paramString);
        return;
      }
      if ((paramString.contains("http")) || (paramString.contains("https")))
      {
        IMAIUtility.ping(this.a, paramString, paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      IMAIUtility.fireErrorEvent(this.a, localException.getMessage(), "ping", paramString);
      Log.internal("InMobiAndroidSDK_3.7.1", "IMAI ping failed", localException);
      return;
    }
    IMAIUtility.fireErrorEvent(this.a, "Invalid url passed", "ping", paramString);
  }
  
  @JavascriptInterface
  public void pingInWebView(String paramString, boolean paramBoolean)
  {
    try
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "IMAI ping in webview");
      if (!IMAIUtility.validateURL(paramString))
      {
        IMAIUtility.fireErrorEvent(this.a, "Null url passed", "pingInWebView", paramString);
        return;
      }
      if ((paramString.contains("http")) || (paramString.contains("https")))
      {
        IMAIUtility.pingInWebview(this.a, paramString, paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      IMAIUtility.fireErrorEvent(this.a, localException.getMessage(), "pingInWebView", paramString);
      Log.internal("InMobiAndroidSDK_3.7.1", "IMAI pingInWebView failed", localException);
      return;
    }
    IMAIUtility.fireErrorEvent(this.a, "Invalid url passed", "pingInWebView", paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/IMAIController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */