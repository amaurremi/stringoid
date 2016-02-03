package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MMBroadcastReceiver
  extends BroadcastReceiver
{
  public static IntentFilter createIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addCategory("millennialmedia.category.CATEGORY_SDK");
    localIntentFilter.addAction("millennialmedia.action.ACTION_DISPLAY_STARTED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_FETCH_FAILED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_FETCH_FINISHED_CACHING");
    localIntentFilter.addAction("millennialmedia.action.ACTION_FETCH_STARTED_CACHING");
    localIntentFilter.addAction("millennialmedia.action.ACTION_GETAD_FAILED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_GETAD_SUCCEEDED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_INTENT_STARTED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_OVERLAY_CLOSED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_OVERLAY_OPENED");
    localIntentFilter.addAction("millennialmedia.action.ACTION_OVERLAY_TAP");
    return localIntentFilter;
  }
  
  public void displayStarted(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media display started.");
  }
  
  public void fetchFailure(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media fetch failed.");
  }
  
  public void fetchFinishedCaching(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media fetch finished caching.");
  }
  
  public void fetchStartedCaching(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media fetch started caching.");
  }
  
  public void getAdFailure(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media ad Failure.");
  }
  
  public void getAdSuccess(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media ad Success.");
  }
  
  public void intentStarted(MMAdView paramMMAdView, String paramString)
  {
    if (paramString != null) {
      MMAdViewSDK.Log.i("Millennial Media started intent: " + paramString);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    String str2 = paramIntent.getStringExtra("packageName");
    long l = paramIntent.getLongExtra("internalId", 0L);
    Object localObject = null;
    if (!paramContext.getPackageName().equals(str2)) {}
    do
    {
      return;
      paramContext = (Context)localObject;
      if (l != 0L) {
        paramContext = MMAdViewController.getAdViewWithId(new Long(l));
      }
      if (str1.equals("millennialmedia.action.ACTION_OVERLAY_OPENED"))
      {
        overlayOpened(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_OVERLAY_CLOSED"))
      {
        overlayClosed(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_OVERLAY_TAP"))
      {
        overlayTap(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_DISPLAY_STARTED"))
      {
        displayStarted(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_FETCH_FAILED"))
      {
        fetchFailure(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_FETCH_FINISHED_CACHING"))
      {
        fetchFinishedCaching(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"))
      {
        fetchStartedCaching(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_GETAD_FAILED"))
      {
        getAdFailure(paramContext);
        return;
      }
      if (str1.equals("millennialmedia.action.ACTION_GETAD_SUCCEEDED"))
      {
        getAdSuccess(paramContext);
        return;
      }
    } while (!str1.equals("millennialmedia.action.ACTION_INTENT_STARTED"));
    intentStarted(paramContext, paramIntent.getStringExtra("intentType"));
  }
  
  public void overlayClosed(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media overlay closed.");
  }
  
  public void overlayOpened(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media overlay opened.");
  }
  
  public void overlayTap(MMAdView paramMMAdView)
  {
    MMAdViewSDK.Log.i("Millennial Media overlay Tap.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */