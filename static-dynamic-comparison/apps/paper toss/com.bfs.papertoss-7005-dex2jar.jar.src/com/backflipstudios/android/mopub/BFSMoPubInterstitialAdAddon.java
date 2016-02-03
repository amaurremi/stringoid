package com.backflipstudios.android.mopub;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import com.backflipstudios.android.debug.BFSDebug;
import com.backflipstudios.android.engine.app.addons.BFSInterstitialAdActivityAddon;
import com.backflipstudios.android.engine.app.addons.BFSInterstitialAdActivityAddon.ActivityListener;
import com.backflipstudios.android.engine.app.addons.BFSInterstitialAdActivityAddon.InterstitialType;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.MoPubInterstitialListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class BFSMoPubInterstitialAdAddon
  extends BFSInterstitialAdActivityAddon
{
  public static final String NAME = "BFSMoPubInterstitialAdAddon";
  private static String m_adShown = null;
  private HashMap<String, AdPackage> m_interstitials = null;
  private HashSet<BFSInterstitialAdActivityAddon.ActivityListener> m_listeners = null;
  private Handler m_mainHandler = null;
  private boolean m_precachingEnabled = true;
  
  public BFSMoPubInterstitialAdAddon(Activity paramActivity, boolean paramBoolean)
  {
    super(paramActivity);
    this.m_precachingEnabled = paramBoolean;
    this.m_mainHandler = new Handler();
  }
  
  private void fireAdDidShow(String paramString)
  {
    Object localObject = this.m_listeners;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BFSInterstitialAdActivityAddon.ActivityListener)((Iterator)localObject).next()).adDidShow(paramString);
      }
    }
  }
  
  private void fireAdWillNotShow(String paramString)
  {
    Object localObject = this.m_listeners;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BFSInterstitialAdActivityAddon.ActivityListener)((Iterator)localObject).next()).adWillNotShow(paramString);
      }
    }
  }
  
  private void fireAdWillShow(String paramString)
  {
    Object localObject = this.m_listeners;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BFSInterstitialAdActivityAddon.ActivityListener)((Iterator)localObject).next()).adWillShow(paramString);
      }
    }
  }
  
  private void showingAdWithTag(String paramString)
  {
    m_adShown = paramString;
    fireAdWillShow(paramString);
  }
  
  public void addActivityListener(BFSInterstitialAdActivityAddon.ActivityListener paramActivityListener)
  {
    if (this.m_listeners == null)
    {
      this.m_listeners = new HashSet();
      this.m_listeners.add(paramActivityListener);
    }
    while (this.m_listeners.contains(paramActivityListener)) {
      return;
    }
    this.m_listeners = new HashSet(this.m_listeners);
    this.m_listeners.add(paramActivityListener);
  }
  
  public String getName()
  {
    return "BFSMoPubInterstitialAdAddon";
  }
  
  public boolean isAdWithTagPrecached(String paramString)
  {
    Iterator localIterator = this.m_interstitials.values().iterator();
    while (localIterator.hasNext())
    {
      AdPackage localAdPackage = (AdPackage)localIterator.next();
      if (localAdPackage.getTag().equals(paramString)) {
        return localAdPackage.isReady();
      }
    }
    return false;
  }
  
  public boolean isPrecachingEnabled()
  {
    return this.m_precachingEnabled;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    Iterator localIterator = this.m_interstitials.values().iterator();
    while (localIterator.hasNext()) {
      ((AdPackage)localIterator.next()).destroy();
    }
    this.m_interstitials.clear();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if ((m_adShown != null) && (m_adShown.length() > 0))
    {
      fireAdDidShow(m_adShown);
      if (this.m_precachingEnabled)
      {
        Iterator localIterator = this.m_interstitials.values().iterator();
        while (localIterator.hasNext())
        {
          AdPackage localAdPackage = (AdPackage)localIterator.next();
          if (localAdPackage.getTag().equals(m_adShown)) {
            localAdPackage.load();
          }
        }
      }
      m_adShown = null;
    }
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void prepareAdWithTag(String paramString)
  {
    AdPackage localAdPackage = (AdPackage)this.m_interstitials.get(paramString);
    if (localAdPackage != null)
    {
      BFSDebug.d("BFSMoPubInterstitialAdAddon: Preparing interstitial ad: " + paramString);
      localAdPackage.prepare(this.m_activity);
      if (this.m_precachingEnabled) {
        localAdPackage.load();
      }
      return;
    }
    BFSDebug.w("BFSMoPubInterstitialAdAddon: Unable to find ad to prepare: " + paramString);
  }
  
  public void registerAd(String paramString1, String paramString2, BFSInterstitialAdActivityAddon.InterstitialType paramInterstitialType)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      BFSDebug.w("BFSMoPubInterstitialAdAddon: Attempting to register ad with no adId: " + paramString1);
      return;
    }
    BFSDebug.d("BFSMoPubInterstitialAdAddon: Registering interstitial ad: " + paramString1);
    paramString2 = new AdPackage(this, paramInterstitialType, paramString1, paramString2);
    this.m_interstitials.put(paramString1, paramString2);
  }
  
  public void removeActivityListener(BFSInterstitialAdActivityAddon.ActivityListener paramActivityListener)
  {
    if ((this.m_listeners != null) && (this.m_listeners.contains(paramActivityListener)))
    {
      if (this.m_listeners.size() == 1) {
        this.m_listeners = null;
      }
    }
    else {
      return;
    }
    this.m_listeners = new HashSet(this.m_listeners);
    this.m_listeners.remove(paramActivityListener);
  }
  
  public boolean showAdWithTag(String paramString)
  {
    Iterator localIterator = this.m_interstitials.values().iterator();
    while (localIterator.hasNext())
    {
      AdPackage localAdPackage = (AdPackage)localIterator.next();
      if (localAdPackage.getTag().equals(paramString))
      {
        BFSDebug.d("BFSMoPubInterstitialAdAddon: Showing precached interstitial for : " + paramString);
        localAdPackage.show();
      }
    }
    return true;
  }
  
  private class AdPackage
    implements MoPubInterstitial.MoPubInterstitialListener
  {
    private String m_adId = "";
    private int m_consecutiveLoadFailures = 0;
    private MoPubInterstitial m_interstitial = null;
    private BFSMoPubInterstitialAdAddon m_owner = null;
    private boolean m_precaching = false;
    private String m_tag = "";
    private Timer m_timer = null;
    private BFSInterstitialAdActivityAddon.InterstitialType m_type = BFSInterstitialAdActivityAddon.InterstitialType.GameplayInterstitial;
    private boolean m_waiting = false;
    
    public AdPackage(BFSMoPubInterstitialAdAddon paramBFSMoPubInterstitialAdAddon, BFSInterstitialAdActivityAddon.InterstitialType paramInterstitialType, String paramString1, String paramString2)
    {
      this.m_owner = paramBFSMoPubInterstitialAdAddon;
      this.m_type = paramInterstitialType;
      this.m_tag = paramString1;
      this.m_adId = paramString2;
    }
    
    public void OnInterstitialFailed()
    {
      BFSDebug.w("BFSMoPubIterstitialAdAdon: Failed to load interstitial ad");
      if (this.m_timer != null)
      {
        this.m_timer.cancel();
        this.m_timer = null;
      }
      this.m_consecutiveLoadFailures += 1;
      if ((this.m_precaching) && (this.m_consecutiveLoadFailures <= 3)) {
        this.m_interstitial.load();
      }
      if ((!this.m_precaching) || (this.m_waiting)) {
        this.m_owner.fireAdWillNotShow(this.m_tag);
      }
      this.m_waiting = false;
    }
    
    public void OnInterstitialLoaded()
    {
      BFSDebug.d("BFSMoPubIterstitialAdAdon: Interstitial ad loaded");
      if (this.m_timer != null)
      {
        this.m_timer.cancel();
        this.m_timer = null;
      }
      this.m_consecutiveLoadFailures = 0;
      if ((!this.m_precaching) || (this.m_waiting))
      {
        this.m_owner.showingAdWithTag(this.m_tag);
        this.m_interstitial.show();
      }
      this.m_waiting = false;
    }
    
    public void cancel()
    {
      if (this.m_waiting)
      {
        this.m_waiting = false;
        this.m_owner.fireAdWillNotShow(this.m_tag);
      }
    }
    
    public void destroy()
    {
      this.m_interstitial.destroy();
    }
    
    public String getTag()
    {
      return this.m_tag;
    }
    
    public BFSInterstitialAdActivityAddon.InterstitialType getType()
    {
      return this.m_type;
    }
    
    public boolean isReady()
    {
      if (this.m_interstitial != null) {
        return this.m_interstitial.isReady();
      }
      return false;
    }
    
    public void load()
    {
      this.m_precaching = true;
      this.m_interstitial.load();
    }
    
    public void prepare(Activity paramActivity)
    {
      this.m_interstitial = new MoPubInterstitial(paramActivity, this.m_adId);
      this.m_interstitial.setListener(this);
      this.m_interstitial.setKeywords(String.format("m_version:%s,m_versioncode:%d,m_source:%d", new Object[] { BFSMoPubConstants.getApplicationVersion(BFSMoPubInterstitialAdAddon.this.m_activity), Integer.valueOf(BFSMoPubConstants.getApplicationVersionCode(BFSMoPubInterstitialAdAddon.this.m_activity)), Integer.valueOf(BFSMoPubConstants.getInstallerSource(BFSMoPubInterstitialAdAddon.this.m_activity)) }));
    }
    
    public void show()
    {
      if ((this.m_precaching) && (this.m_interstitial.isReady()))
      {
        this.m_owner.showingAdWithTag(this.m_tag);
        this.m_interstitial.show();
        return;
      }
      this.m_interstitial.load();
      this.m_waiting = true;
      this.m_timer = new Timer();
      this.m_timer.schedule(new BFSMoPubInterstitialAdAddon.CancelTask(BFSMoPubInterstitialAdAddon.this, this), 5000L);
    }
  }
  
  private class CancelTask
    extends TimerTask
  {
    private BFSMoPubInterstitialAdAddon.AdPackage m_ad = null;
    
    public CancelTask(BFSMoPubInterstitialAdAddon.AdPackage paramAdPackage)
    {
      this.m_ad = paramAdPackage;
    }
    
    public void run()
    {
      BFSMoPubInterstitialAdAddon.this.m_mainHandler.post(new Runnable()
      {
        public void run()
        {
          BFSMoPubInterstitialAdAddon.CancelTask.this.m_ad.cancel();
        }
      });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/mopub/BFSMoPubInterstitialAdAddon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */