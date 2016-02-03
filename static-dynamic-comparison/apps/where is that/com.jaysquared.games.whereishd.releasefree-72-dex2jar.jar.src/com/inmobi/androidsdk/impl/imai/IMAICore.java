package com.inmobi.androidsdk.impl.imai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.imai.db.ClickData;
import com.inmobi.androidsdk.impl.imai.db.ClickDatabaseManager;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.ViewState;
import java.lang.ref.WeakReference;
import java.util.Random;

public class IMAICore
{
  static Random a = new Random();
  
  public static void fireErrorEvent(WeakReference<IMWebView> paramWeakReference, String paramString1, String paramString2, String paramString3)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "Fire error event IMAI for action: " + paramString2 + " " + paramString1);
        injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('error','" + paramString1 + "'" + ",'" + paramString2 + "'" + ",'" + paramString3 + "'" + ")");
      }
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception", paramWeakReference);
    }
  }
  
  public static void fireOpenEmbeddedSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "fireOpenEmbeddedSuccessful");
        if ((!((IMWebView)paramWeakReference.get()).mWebViewIsBrowserActivity) && (!((IMWebView)paramWeakReference.get()).mIsInterstitialAd))
        {
          IMBrowserActivity.requestOnAdDismiss(((IMWebView)paramWeakReference.get()).getWebviewHandler().obtainMessage(((IMWebView)paramWeakReference.get()).getDismissMessage()));
          ((IMWebView)paramWeakReference.get()).fireOnShowAdScreen();
        }
        injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('openEmbeddedSuccessful','" + paramString + "')");
      }
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception", paramWeakReference);
    }
  }
  
  public static void fireOpenExternalSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "fireOpenExternalSuccessful");
        ((IMWebView)paramWeakReference.get()).fireOnLeaveApplication();
        injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('openExternalSuccessful','" + paramString + "')");
      }
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception", paramWeakReference);
    }
  }
  
  public static void firePingInWebViewSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "firePingInWebViewSuccessful");
        injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('pingInWebViewSuccessful','" + paramString + "')");
      }
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception", paramWeakReference);
    }
  }
  
  public static void firePingSuccessful(WeakReference<IMWebView> paramWeakReference, String paramString)
  {
    if (paramWeakReference != null) {}
    try
    {
      if (paramWeakReference.get() != null)
      {
        Log.debug("[InMobi]-[Network]-4.1.1", "firePingSuccessful");
        injectJavaScript((IMWebView)paramWeakReference.get(), "window._im_imai.broadcastEvent('pingSuccessful','" + paramString + "')");
      }
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Exception", paramWeakReference);
    }
  }
  
  public static int getRandomNumber()
  {
    return a.nextInt();
  }
  
  public static void initialize()
  {
    new RequestResponseManager().init();
    ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
  }
  
  public static void injectJavaScript(IMWebView paramIMWebView, final String paramString)
  {
    try
    {
      paramIMWebView.getActivity().runOnUiThread(new c(paramIMWebView, paramString));
      return;
    }
    catch (Exception paramIMWebView)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Error injecting javascript ", paramIMWebView);
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
      ((IMWebView)paramWeakReference.get()).getActivity().runOnUiThread(new a(paramString, paramBoolean, paramWeakReference));
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Failed to ping", paramWeakReference);
    }
  }
  
  public static void pingInWebview(final WeakReference<IMWebView> paramWeakReference, String paramString, final boolean paramBoolean)
  {
    try
    {
      ((IMWebView)paramWeakReference.get()).getActivity().runOnUiThread(new b(paramString, paramBoolean, paramWeakReference));
      return;
    }
    catch (Exception paramWeakReference)
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Failed to ping in webview", paramWeakReference);
    }
  }
  
  public static boolean validateURL(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.internal("[InMobi]-[Network]-4.1.1", "Null url passed");
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
      try
      {
        int i = Initializer.getConfigParams().getImai().getMaxRetry();
        ClickData localClickData = new ClickData(this.a, paramBoolean, false, i);
        RequestResponseManager localRequestResponseManager = new RequestResponseManager();
        localRequestResponseManager.init();
        RequestResponseManager.mNetworkQueue.add(0, localClickData);
        localRequestResponseManager.processClick(InternalSDKUtil.getContext(), new a());
        return;
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Exception ping in background", localException);
      }
    }
    
    class a
      implements HttpRequestCallback
    {
      a() {}
      
      public void notifyResult(int paramInt, Object paramObject)
      {
        try
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Got PING callback. Status: " + paramInt);
          if (paramInt == 0)
          {
            IMAICore.firePingSuccessful(IMAICore.a.this.c, IMAICore.a.this.a);
            return;
          }
          IMAICore.fireErrorEvent(IMAICore.a.this.c, "IMAI Ping in http client failed", "ping", IMAICore.a.this.a);
          return;
        }
        catch (Exception paramObject)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Exception", (Throwable)paramObject);
        }
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    b(String paramString, boolean paramBoolean, WeakReference paramWeakReference) {}
    
    public void run()
    {
      try
      {
        int i = Initializer.getConfigParams().getImai().getMaxRetry();
        ClickData localClickData = new ClickData(this.a, paramBoolean, true, i);
        RequestResponseManager localRequestResponseManager = new RequestResponseManager();
        localRequestResponseManager.init();
        RequestResponseManager.mNetworkQueue.add(0, localClickData);
        localRequestResponseManager.processClick(InternalSDKUtil.getContext(), new a());
        return;
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-[Network]-4.1.1", "Exception ping in background", localException);
      }
    }
    
    class a
      implements HttpRequestCallback
    {
      a() {}
      
      public void notifyResult(int paramInt, Object paramObject)
      {
        try
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Got PING IN WEBVIEW callback. Status: " + paramInt);
          if (paramInt == 0)
          {
            IMAICore.firePingInWebViewSuccessful(IMAICore.b.this.c, IMAICore.b.this.a);
            return;
          }
          IMAICore.fireErrorEvent(IMAICore.b.this.c, "IMAI Ping in webview failed", "pingInWebview", IMAICore.b.this.a);
          return;
        }
        catch (Exception paramObject)
        {
          Log.internal("[InMobi]-[Network]-4.1.1", "Exception", (Throwable)paramObject);
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    c(IMWebView paramIMWebView, String paramString) {}
    
    public void run()
    {
      this.a.injectJavaScript(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/IMAICore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */