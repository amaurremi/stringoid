package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

class EventForwardingBroadcastReceiver
  extends BroadcastReceiver
{
  static final String ACTION_INTERSTITIAL_CLICK = "com.mopub.action.interstitial.click";
  static final String ACTION_INTERSTITIAL_DISMISS = "com.mopub.action.interstitial.dismiss";
  static final String ACTION_INTERSTITIAL_FAIL = "com.mopub.action.interstitial.fail";
  static final String ACTION_INTERSTITIAL_SHOW = "com.mopub.action.interstitial.show";
  static final String BROADCAST_IDENTIFIER_KEY = "broadcastIdentifier";
  private static IntentFilter sIntentFilter;
  private final long mBroadcastIdentifier;
  private Context mContext;
  private final CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
  
  public EventForwardingBroadcastReceiver(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, long paramLong)
  {
    this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
    this.mBroadcastIdentifier = paramLong;
    sIntentFilter = getHtmlInterstitialIntentFilter();
  }
  
  static void broadcastAction(Context paramContext, long paramLong, String paramString)
  {
    paramString = new Intent(paramString);
    paramString.putExtra("broadcastIdentifier", paramLong);
    LocalBroadcastManager.getInstance(paramContext.getApplicationContext()).sendBroadcast(paramString);
  }
  
  static IntentFilter getHtmlInterstitialIntentFilter()
  {
    if (sIntentFilter == null)
    {
      sIntentFilter = new IntentFilter();
      sIntentFilter.addAction("com.mopub.action.interstitial.fail");
      sIntentFilter.addAction("com.mopub.action.interstitial.show");
      sIntentFilter.addAction("com.mopub.action.interstitial.dismiss");
      sIntentFilter.addAction("com.mopub.action.interstitial.click");
    }
    return sIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.mCustomEventInterstitialListener == null) {}
    do
    {
      long l;
      do
      {
        return;
        l = paramIntent.getLongExtra("broadcastIdentifier", -1L);
      } while (this.mBroadcastIdentifier != l);
      paramContext = paramIntent.getAction();
      if ("com.mopub.action.interstitial.fail".equals(paramContext))
      {
        this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
        return;
      }
      if ("com.mopub.action.interstitial.show".equals(paramContext))
      {
        this.mCustomEventInterstitialListener.onInterstitialShown();
        return;
      }
      if ("com.mopub.action.interstitial.dismiss".equals(paramContext))
      {
        this.mCustomEventInterstitialListener.onInterstitialDismissed();
        unregister();
        return;
      }
    } while (!"com.mopub.action.interstitial.click".equals(paramContext));
    this.mCustomEventInterstitialListener.onInterstitialClicked();
  }
  
  public void register(Context paramContext)
  {
    this.mContext = paramContext;
    LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this, sIntentFilter);
  }
  
  public void unregister()
  {
    if (this.mContext != null)
    {
      LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this);
      this.mContext = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/EventForwardingBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */