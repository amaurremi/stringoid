package com.jaysquared.games.whereishd.ads;

import android.app.Activity;
import android.util.Log;
import com.jaysquared.games.whereishd.utils.SLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener;
import java.util.Timer;
import java.util.TimerTask;

public class MoPubInterstitialAd
  implements MoPubInterstitial.InterstitialAdListener
{
  private static final long INTERSTITIAL_EVENT_TIME = 5000L;
  private static final long INTERSTITIAL_FAILED_RELOAD_TIME = 10000L;
  private static final String LOG_TAG = MoPubInterstitialAd.class.getSimpleName();
  private final Activity activity;
  private MoPubInterstitial interstitial;
  private long interstitialDelay;
  private boolean interstitialRepeat;
  private boolean interstitialShouldReload;
  private long interstitialTimeCounter;
  private long interstitialTimeout;
  private Timer interstitialTimer;
  private final String moPubId;
  private boolean testMode;
  
  public MoPubInterstitialAd(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    this.activity = paramActivity;
    this.moPubId = paramString;
    this.interstitial = null;
    this.testMode = false;
    this.interstitialTimer = null;
    this.interstitialDelay = 0L;
    this.interstitialTimeout = 0L;
    this.interstitialTimeCounter = 0L;
    this.interstitialRepeat = false;
    this.interstitialShouldReload = true;
  }
  
  private void interstitialTimerEvent()
  {
    this.interstitialTimeCounter -= 5000L;
    SLog.d(LOG_TAG, "Timer event for MoPub ads, delay left : " + this.interstitialTimeCounter + "ms");
    if (this.interstitialTimeCounter <= 0L)
    {
      SLog.i(LOG_TAG, "Ad is ready to show...");
      if (!this.interstitial.isReady()) {
        break label147;
      }
      this.interstitial.show();
      this.interstitialShouldReload = true;
      if (!this.interstitialRepeat) {
        break label134;
      }
      SLog.d(LOG_TAG, "Resettting ad delay to " + this.interstitialDelay + "ms");
      this.interstitialTimeCounter = this.interstitialDelay;
    }
    label134:
    label147:
    while (this.interstitialTimeCounter > -this.interstitialTimeout)
    {
      return;
      SLog.d(LOG_TAG, "This ad has been shown and will turn off now.");
      stop();
      return;
    }
    SLog.w(LOG_TAG, "Timeout has been reached and this ad will turn off now.");
    stop();
  }
  
  private void reloadAds()
  {
    if ((this.interstitialTimer == null) || (this.interstitial == null))
    {
      SLog.d(LOG_TAG, "Ads have been disabled, reloading of ads stopped.");
      return;
    }
    SLog.d(LOG_TAG, "Trying to reload ads in 10000ms...");
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        if (MoPubInterstitialAd.this.interstitial != null)
        {
          SLog.i(MoPubInterstitialAd.LOG_TAG, "Reloading ads...");
          MoPubInterstitialAd.this.interstitial.load();
        }
      }
    }, 10000L);
  }
  
  protected void finalize()
    throws Throwable
  {
    if (this.interstitial != null) {
      stop();
    }
    super.finalize();
  }
  
  public void onInterstitialClicked(MoPubInterstitial paramMoPubInterstitial)
  {
    SLog.d(LOG_TAG, "MoPub interstitial clicked.");
  }
  
  public void onInterstitialDismissed(MoPubInterstitial paramMoPubInterstitial)
  {
    SLog.d(LOG_TAG, "MoPub interstitial dismissed.");
  }
  
  public void onInterstitialFailed(MoPubInterstitial paramMoPubInterstitial, MoPubErrorCode paramMoPubErrorCode)
  {
    SLog.w(LOG_TAG, "MoPub interstitial failed: " + paramMoPubErrorCode.toString());
    reloadAds();
  }
  
  public void onInterstitialLoaded(MoPubInterstitial paramMoPubInterstitial)
  {
    SLog.d(LOG_TAG, "MoPub interstitial has finished loading.");
  }
  
  public void onInterstitialShown(MoPubInterstitial paramMoPubInterstitial)
  {
    SLog.d(LOG_TAG, "MoPub interstitial shown.");
  }
  
  public void pauseShowing()
  {
    if (this.interstitialTimer != null)
    {
      this.interstitialTimer.cancel();
      this.interstitialTimer.purge();
      this.interstitialTimer = null;
    }
  }
  
  public void setTestMode(boolean paramBoolean)
  {
    Log.d(LOG_TAG, "Ad test mode set to: " + paramBoolean);
    this.testMode = paramBoolean;
    if (this.interstitial != null) {
      this.interstitial.setTesting(paramBoolean);
    }
  }
  
  public void show(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    SLog.i(LOG_TAG, "Show MoPub interstitial ads with delay: " + paramLong1 + ", timeout: " + paramLong2 + " and repeat: " + paramBoolean1);
    if ((!paramBoolean2) || (this.interstitialDelay == 0L))
    {
      SLog.d(LOG_TAG, "Setting up a new ad cycle...");
      this.interstitialDelay = paramLong1;
      this.interstitialTimeCounter = paramLong1;
      this.interstitialTimeout = paramLong2;
      this.interstitialRepeat = paramBoolean1;
    }
    for (;;)
    {
      if (this.interstitial == null)
      {
        SLog.d(LOG_TAG, "Interstitial has nothing preloaded. Will start loading now");
        startPreloading();
      }
      if (this.interstitialTimer != null)
      {
        SLog.d(LOG_TAG, "Disabling previous interstitial timer...");
        this.interstitialTimer.cancel();
        this.interstitialTimer.purge();
      }
      this.interstitialTimer = new Timer();
      this.interstitialTimer.schedule(new TimerTask()
      {
        public void run()
        {
          MoPubInterstitialAd.this.interstitialTimerEvent();
        }
      }, 0L, 5000L);
      return;
      SLog.d(LOG_TAG, "Resuming a previous ad cycle...");
      if ((this.interstitialTimeCounter < 20000L) && (this.interstitialDelay >= 20000L)) {
        this.interstitialTimeCounter = 20000L;
      }
    }
  }
  
  public void startPreloading()
  {
    SLog.i(LOG_TAG, "Enabling MoPub interstitial ads. Will start preloading...");
    if (this.interstitial == null)
    {
      SLog.d(LOG_TAG, "Interstitial ad has not been initialized yet, doing it now...");
      this.interstitial = new MoPubInterstitial(this.activity, this.moPubId);
      this.interstitial.setInterstitialAdListener(this);
    }
    setTestMode(this.testMode);
    if ((!this.interstitial.isReady()) || (this.interstitialShouldReload))
    {
      this.interstitialShouldReload = false;
      this.interstitial.load();
    }
  }
  
  public void stop()
  {
    SLog.d(LOG_TAG, "Stopping interstitial and clearing cache...");
    pauseShowing();
    if (this.interstitial != null)
    {
      this.interstitial.destroy();
      this.interstitial = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ads/MoPubInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */