package com.backflipstudios.android.mopub;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.backflipstudios.android.debug.BFSDebug;
import com.backflipstudios.android.engine.app.addons.BFSBannerAdActivityAddon;
import com.backflipstudios.android.engine.app.addons.BFSBannerAdActivityAddon.BannerPosition;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.OnAdClickedListener;
import com.mopub.mobileads.MoPubView.OnAdClosedListener;
import com.mopub.mobileads.MoPubView.OnAdFailedListener;
import com.mopub.mobileads.MoPubView.OnAdLoadedListener;
import com.mopub.mobileads.MoPubView.OnAdWillLoadListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BFSMoPubBannerAdAddon
  extends BFSBannerAdActivityAddon
{
  public static final String NAME = "BFSMoPubBannerAdAddon";
  private HashMap<String, BannerAdPackage> m_bannerAds = null;
  private RelativeLayout m_layout = null;
  private Handler m_mainHandler = null;
  private boolean m_precachingEnabled = false;
  private ArrayList<String> m_shouldBeShownArray = null;
  
  public BFSMoPubBannerAdAddon(Activity paramActivity, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    super(paramActivity);
    this.m_layout = paramRelativeLayout;
    this.m_precachingEnabled = paramBoolean;
    this.m_mainHandler = new Handler();
  }
  
  public String getName()
  {
    return "BFSMoPubBannerAdAddon";
  }
  
  public void hideAdWithTag(String paramString)
  {
    paramString = (BannerAdPackage)this.m_bannerAds.get(paramString);
    if ((paramString != null) && (paramString.isShown())) {
      paramString.hide();
    }
  }
  
  public void hideBannerAds()
  {
    Iterator localIterator = this.m_bannerAds.values().iterator();
    while (localIterator.hasNext())
    {
      BannerAdPackage localBannerAdPackage = (BannerAdPackage)localIterator.next();
      if (localBannerAdPackage.isShown()) {
        localBannerAdPackage.hide();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    BFSDebug.d("BFSMoPubBannerAdsAddon.onDestroy()");
    Iterator localIterator = this.m_bannerAds.values().iterator();
    while (localIterator.hasNext()) {
      ((BannerAdPackage)localIterator.next()).destroy();
    }
    this.m_bannerAds.clear();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause()
  {
    Iterator localIterator = this.m_bannerAds.values().iterator();
    while (localIterator.hasNext())
    {
      BannerAdPackage localBannerAdPackage = (BannerAdPackage)localIterator.next();
      if (localBannerAdPackage.isShown())
      {
        this.m_shouldBeShownArray.add(localBannerAdPackage.getTag());
        localBannerAdPackage.hide();
      }
    }
  }
  
  public void onResume()
  {
    if (this.m_shouldBeShownArray.size() > 0)
    {
      Iterator localIterator = this.m_shouldBeShownArray.iterator();
      while (localIterator.hasNext()) {
        showAdWithTagDelayed((String)localIterator.next(), 1000L);
      }
      this.m_shouldBeShownArray.clear();
    }
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void pauseAdWithTag(String paramString)
  {
    paramString = (BannerAdPackage)this.m_bannerAds.get(paramString);
    if ((paramString != null) && (paramString.isShown())) {
      paramString.pauseRotation();
    }
  }
  
  public void prepareAdWithTag(String paramString)
  {
    BannerAdPackage localBannerAdPackage = (BannerAdPackage)this.m_bannerAds.get(paramString);
    if (localBannerAdPackage != null)
    {
      BFSDebug.d("BFSMoPubBannerAdsAddon: Preparing Banner Ad: " + paramString);
      localBannerAdPackage.prepare();
      return;
    }
    BFSDebug.w("BFSMoPubBannerAdsAddon: Unable to find ad to prepare: " + paramString);
  }
  
  public void registerAd(String paramString1, String paramString2, BFSBannerAdActivityAddon.BannerPosition paramBannerPosition)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      BFSDebug.w("BFSMoPubBannerAdsAddon: Attempting to register ad with no adId: " + paramString1);
      return;
    }
    BFSDebug.d("BFSMoPubBannerAdsAddon: Registering Banner Ad: " + paramString1);
    paramString2 = new BannerAdPackage(paramString1, paramString2, paramBannerPosition);
    this.m_bannerAds.put(paramString1, paramString2);
  }
  
  public void resumeAdWithTag(String paramString)
  {
    paramString = (BannerAdPackage)this.m_bannerAds.get(paramString);
    if ((paramString != null) && (paramString.isShown())) {
      paramString.resumeRotation();
    }
  }
  
  public void setRefreshRate(int paramInt) {}
  
  public void showAdWithTag(String paramString)
  {
    showAdWithTagDelayed(paramString, 0L);
  }
  
  public void showAdWithTagDelayed(String paramString, long paramLong)
  {
    Iterator localIterator = this.m_bannerAds.values().iterator();
    while (localIterator.hasNext())
    {
      BannerAdPackage localBannerAdPackage = (BannerAdPackage)localIterator.next();
      if (localBannerAdPackage.getTag().equals(paramString))
      {
        if (!localBannerAdPackage.isShown()) {
          localBannerAdPackage.show(paramLong);
        }
      }
      else if (localBannerAdPackage.isShown()) {
        localBannerAdPackage.hide();
      }
    }
  }
  
  private class BannerAdPackage
    implements MoPubView.OnAdWillLoadListener, MoPubView.OnAdLoadedListener, MoPubView.OnAdFailedListener, MoPubView.OnAdClosedListener, MoPubView.OnAdClickedListener
  {
    private String m_adId = "";
    private MoPubView m_adView = null;
    private boolean m_isShown = false;
    private RelativeLayout.LayoutParams m_layoutParams = null;
    private BFSBannerAdActivityAddon.BannerPosition m_position = BFSBannerAdActivityAddon.BannerPosition.BannerPositionTop;
    private String m_tag = "";
    private Timer m_timer = null;
    
    public BannerAdPackage(String paramString1, String paramString2, BFSBannerAdActivityAddon.BannerPosition paramBannerPosition)
    {
      this.m_tag = paramString1;
      this.m_adId = paramString2;
      this.m_position = paramBannerPosition;
    }
    
    private void doShow()
    {
      if (!this.m_isShown)
      {
        this.m_isShown = true;
        BFSMoPubBannerAdAddon.this.m_layout.addView(this.m_adView, this.m_layoutParams);
        this.m_adView.loadAd();
        BFSDebug.d("BFSMoPubBannerAdsAddon: Ad Shown: " + this.m_tag);
      }
      this.m_timer = null;
    }
    
    public void OnAdClicked(MoPubView paramMoPubView)
    {
      BFSDebug.d("BFSMoPubBannerAdsAddon: Ad clicked");
    }
    
    public void OnAdClosed(MoPubView paramMoPubView)
    {
      BFSDebug.d("BFSMoPubBannerAdsAddon: Ad closed");
    }
    
    public void OnAdFailed(MoPubView paramMoPubView)
    {
      BFSDebug.d("BFSMoPubBannerAdsAddon: Ad failed");
    }
    
    public void OnAdLoaded(MoPubView paramMoPubView)
    {
      BFSDebug.d("BFSMoPubBannerAdsAddon: Ad loaded");
    }
    
    public void OnAdWillLoad(MoPubView paramMoPubView, String paramString)
    {
      BFSDebug.d("BFSMoPubBannerAdsAddon: Ad will load: " + paramString);
    }
    
    public void destroy()
    {
      hide();
      if (this.m_adView.getParent() != null) {
        ((ViewGroup)this.m_adView.getParent()).removeView(this.m_adView);
      }
      this.m_adView.destroy();
    }
    
    public String getTag()
    {
      return this.m_tag;
    }
    
    public void hide()
    {
      if (this.m_timer != null)
      {
        this.m_timer.cancel();
        this.m_timer = null;
      }
      if (this.m_isShown)
      {
        if (this.m_adView.getParent() != null) {
          ((ViewGroup)this.m_adView.getParent()).removeView(this.m_adView);
        }
        this.m_isShown = false;
        BFSDebug.d("BFSMoPubBannerAdsAddon: Ad Hidden: " + this.m_tag);
      }
    }
    
    public boolean isShown()
    {
      return this.m_isShown;
    }
    
    public void pauseRotation()
    {
      this.m_adView.setAutorefreshEnabled(false);
    }
    
    public void prepare()
    {
      this.m_adView = new MoPubView(BFSMoPubBannerAdAddon.this.m_activity);
      this.m_adView.setAdUnitId(this.m_adId);
      this.m_adView.setId(new Random(System.currentTimeMillis()).nextInt());
      this.m_adView.setKeywords(String.format("m_version:%s,m_versioncode:%d,m_source:%d", new Object[] { BFSMoPubConstants.getApplicationVersion(BFSMoPubBannerAdAddon.this.m_activity), Integer.valueOf(BFSMoPubConstants.getApplicationVersionCode(BFSMoPubBannerAdAddon.this.m_activity)), Integer.valueOf(BFSMoPubConstants.getInstallerSource(BFSMoPubBannerAdAddon.this.m_activity)) }));
      this.m_adView.setOnAdWillLoadListener(this);
      this.m_adView.setOnAdLoadedListener(this);
      this.m_adView.setOnAdFailedListener(this);
      this.m_adView.setOnAdClosedListener(this);
      this.m_adView.setOnAdClickedListener(this);
      this.m_layoutParams = new RelativeLayout.LayoutParams(-1, -2);
      if (this.m_position == BFSBannerAdActivityAddon.BannerPosition.BannerPositionTop) {
        this.m_layoutParams.addRule(10, -1);
      }
      for (;;)
      {
        if (BFSMoPubBannerAdAddon.this.m_precachingEnabled) {
          this.m_adView.loadAd();
        }
        return;
        this.m_layoutParams.addRule(12, -1);
      }
    }
    
    public void resumeRotation()
    {
      this.m_adView.setAutorefreshEnabled(true);
    }
    
    public void show(long paramLong)
    {
      if (!isShown())
      {
        if (paramLong > 0L)
        {
          this.m_timer = new Timer();
          this.m_timer.schedule(new BFSMoPubBannerAdAddon.ShowBannerTask(BFSMoPubBannerAdAddon.this, this), paramLong);
          BFSDebug.d("BFSMoPubBannerAdsAddon: Ad Display Scheduled: " + this.m_tag);
        }
      }
      else {
        return;
      }
      doShow();
    }
  }
  
  private class ShowBannerTask
    extends TimerTask
  {
    private BFSMoPubBannerAdAddon.BannerAdPackage m_banner = null;
    
    public ShowBannerTask(BFSMoPubBannerAdAddon.BannerAdPackage paramBannerAdPackage)
    {
      this.m_banner = paramBannerAdPackage;
    }
    
    public void run()
    {
      BFSMoPubBannerAdAddon.this.m_mainHandler.post(new Runnable()
      {
        public void run()
        {
          BFSMoPubBannerAdAddon.ShowBannerTask.this.m_banner.doShow();
          BFSMoPubBannerAdAddon.ShowBannerTask.access$602(BFSMoPubBannerAdAddon.ShowBannerTask.this, null);
        }
      });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/mopub/BFSMoPubBannerAdAddon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */