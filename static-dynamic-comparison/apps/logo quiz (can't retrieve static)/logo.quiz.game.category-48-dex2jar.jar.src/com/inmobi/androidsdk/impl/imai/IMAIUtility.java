package com.inmobi.androidsdk.impl.imai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.ViewState;
import java.lang.ref.WeakReference;
import java.util.Random;

public class IMAIUtility
{
  static Random a;
  public static HttpRequestCallback mPingReqCallback = new b();
  public static HttpRequestCallback mPingWebviewCallback = new a();
  
  static int a()
  {
    return a.nextInt();
  }
  
  public static void fireErrorEvent(WeakReference<IMWebView> paramWeakReference, String paramString1, String paramString2, String paramString3)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Fire error event IMAI for action: " + paramString2 + " " + paramString1);
      injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('error','" + paramString1 + "'" + ",'" + paramString2 + "'" + ",'" + paramString3 + "'" + ")");
    }
  }
  
  public static void fireOpenEmbeddedSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "fireOpenEmbeddedSuccessful");
      if ((!((IMWebView)paramWeakReference.get()).mWebViewIsBrowserActivity) && (!((IMWebView)paramWeakReference.get()).mIsInterstitialAd))
      {
        IMBrowserActivity.requestOnAdDismiss(((IMWebView)paramWeakReference.get()).getWebviewHandler().obtainMessage(((IMWebView)paramWeakReference.get()).getDismissMessage()));
        ((IMWebView)paramWeakReference.get()).fireOnShowAdScreen();
      }
      injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('openEmbeddedSuccessful','" + paramString + "')");
    }
  }
  
  public static void fireOpenExternalSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "fireOpenExternalSuccessful");
      ((IMWebView)paramWeakReference.get()).fireOnLeaveApplication();
      injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('openExternalSuccessful','" + paramString + "')");
    }
  }
  
  public static void firePingInWebViewSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "firePingInWebViewSuccessful");
      injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('pingInWebViewSuccessful','" + paramString + "')");
    }
  }
  
  public static void firePingSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "firePingSuccessful");
      injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('pingSuccessful','" + paramString + "')");
    }
  }
  
  public static void initialize()
  {
    a = new Random();
    new RequestResponseManager().init();
  }
  
  public static void injectJavaScript(IMWebView paramIMWebView, final String paramString)
  {
    try
    {
      paramIMWebView.getActivity().runOnUiThread(new b(paramIMWebView, paramString));
      return;
    }
    catch (Exception paramIMWebView)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Error injecting javascript ", paramIMWebView);
    }
  }
  
  public static void launchEmbeddedBrowser(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    Intent localIntent = new Intent(((IMWebView)paramWeakReference.get()).getActivity(), IMBrowserActivity.class);
    localIntent.putExtra("extra_url", paramString);
    localIntent.setFlags(268435456);
    IMBrowserActivity.setWebViewListener(((IMWebView)paramWeakReference.get()).mListener);
    if ((!((IMWebView)paramWeakReference.get()).mWebViewIsBrowserActivity) && (!((IMWebView)paramWeakReference.get()).mIsInterstitialAd) && (((IMWebView)paramWeakReference.get()).getStateVariable() == IMWebView.ViewState.DEFAULT))
    {
      localIntent.putExtra("FIRST_INSTANCE", true);
      localIntent.putExtra("QAMODE", SDKUtil.getQAMode());
    }
    ((IMWebView)paramWeakReference.get()).getActivity().getApplicationContext().startActivity(localIntent);
  }
  
  public static void launchExternalApp(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    localIntent.setFlags(268435456);
    InternalSDKUtil.getContext().startActivity(localIntent);
  }
  
  public static void ping(final WeakReference<IMWebView> paramWeakReference, String paramString, final boolean paramBoolean)
  {
    try
    {
      ((IMWebView)paramWeakReference.get()).getActivity().runOnUiThread(new c(paramString, paramBoolean, paramWeakReference));
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Failed to ping", paramWeakReference);
    }
  }
  
  public static void pingInWebview(final WeakReference<IMWebView> paramWeakReference, String paramString, final boolean paramBoolean)
  {
    try
    {
      ((IMWebView)paramWeakReference.get()).getActivity().runOnUiThread(new a(paramString, paramBoolean, paramWeakReference));
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Failed to ping in webview", paramWeakReference);
    }
  }
  
  public static boolean validateURL(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Null url passed");
      return false;
    }
    return true;
  }
  
  static final class a
    implements Runnable
  {
    a(String paramString, boolean paramBoolean, WeakReference paramWeakReference) {}
    
    public void run()
    {
      RequestResponseManager localRequestResponseManager = new RequestResponseManager();
      localRequestResponseManager.init();
      RequestResponseManager.mClickEventList.addClickEvent(this.a, paramBoolean, true, paramWeakReference);
      localRequestResponseManager.processClickInBackground(InternalSDKUtil.getContext());
    }
  }
  
  static final class b
    implements Runnable
  {
    b(IMWebView paramIMWebView, String paramString) {}
    
    public void run()
    {
      this.a.injectJavaScript(paramString);
    }
  }
  
  static final class c
    implements Runnable
  {
    c(String paramString, boolean paramBoolean, WeakReference paramWeakReference) {}
    
    public void run()
    {
      RequestResponseManager localRequestResponseManager = new RequestResponseManager();
      localRequestResponseManager.init();
      RequestResponseManager.mClickEventList.addClickEvent(this.a, paramBoolean, false, paramWeakReference);
      localRequestResponseManager.processClickInBackground(InternalSDKUtil.getContext());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/IMAIUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */