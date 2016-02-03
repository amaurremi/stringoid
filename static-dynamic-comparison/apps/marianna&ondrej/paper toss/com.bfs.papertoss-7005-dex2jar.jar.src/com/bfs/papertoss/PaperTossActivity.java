package com.bfs.papertoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.backflipstudios.android.debug.BFSDebug;
import com.backflipstudios.android.engine.app.BFSActivityAddon;
import com.backflipstudios.android.engine.app.BFSActivityAddon.AddonType;
import com.backflipstudios.android.engine.app.addons.BFSBannerAdActivityAddon;
import com.backflipstudios.android.engine.app.addons.BFSBannerAdActivityAddon.BannerPosition;
import com.backflipstudios.android.engine.app.addons.BFSInterstitialAdActivityAddon;
import com.backflipstudios.android.engine.app.addons.BFSInterstitialAdActivityAddon.ActivityListener;
import com.backflipstudios.android.engine.app.addons.BFSInterstitialAdActivityAddon.InterstitialType;
import com.backflipstudios.android.engine.platform.BFSDeviceInfo;
import com.backflipstudios.android.googleanalytics.BFSGoogleAnalyticsActivityAddon;
import com.backflipstudios.android.mopub.BFSMoPubBannerAdAddon;
import com.backflipstudios.android.mopub.BFSMoPubConversionTrackerAddon;
import com.backflipstudios.android.mopub.BFSMoPubInterstitialAdAddon;
import com.bfs.papertoss.cpp.Papertoss;
import com.bfs.papertoss.cpp.Papertoss.GameState;
import com.bfs.papertoss.platform.Evt;
import com.bfs.papertoss.platform.EvtListener;
import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.platform.SoundMgr;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PaperTossActivity
  extends Activity
  implements BFSInterstitialAdActivityAddon.ActivityListener
{
  private static final boolean ADS_ENABLED = true;
  private static final long STARTUP_INTERSTITIAL_PAUSE_INTERVAL = 300000L;
  private ExitPressed exitPressed = new ExitPressed(null);
  GoToMenu gotoMenu = new GoToMenu(null);
  HideAds hideAds = new HideAds(null);
  private boolean m_adDidShow = false;
  private boolean m_adWillShow = false;
  private String m_ad_device_type = "phone";
  private String m_ad_storefront_type = "google";
  private HashMap<String, BFSActivityAddon> m_addons = null;
  private PapertossGLSurfaceView m_glView = null;
  private RelativeLayout m_layout = null;
  private long m_pauseTime = 0L;
  private ImageView m_splashImage = null;
  private boolean m_startedGame = false;
  ShowGameplayAds showGameplayAds = new ShowGameplayAds(null);
  
  private void handleEventSubscriptions(boolean paramBoolean)
  {
    Evt localEvt = Evt.getInstance();
    if (paramBoolean)
    {
      localEvt.subscribe("gotoMenu", this.gotoMenu);
      localEvt.subscribe("gotoLevel", this.showGameplayAds);
      if (!Globals.HI_RES) {
        localEvt.subscribe("gotoScores", this.hideAds);
      }
      localEvt.subscribe("onExitPressed", this.exitPressed);
      return;
    }
    localEvt.unsubscribe("gotoMenu", this.gotoMenu);
    localEvt.unsubscribe("gotoLevel", this.showGameplayAds);
    localEvt.unsubscribe("gotoScores", this.hideAds);
    localEvt.unsubscribe("onExitPressed", this.exitPressed);
  }
  
  private boolean showGameplayInterstitialAd()
  {
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (BFSActivityAddon)this.m_addons.get(localObject);
      if ((((BFSActivityAddon)localObject).getType() == BFSActivityAddon.AddonType.InterstitialAds) && (((BFSInterstitialAdActivityAddon)localObject).isAdWithTagPrecached("gameplay_interstitial")))
      {
        ((BFSInterstitialAdActivityAddon)localObject).showAdWithTag("gameplay_interstitial");
        return true;
      }
    }
    return false;
  }
  
  private boolean showStartupInterstitialAd(int paramInt)
  {
    if ((!BFSDeviceInfo.isConnectedToNetwork(this)) || (paramInt < 3)) {}
    Object localObject;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = this.m_addons.keySet().iterator();
      }
      localObject = (String)localIterator.next();
      localObject = (BFSActivityAddon)this.m_addons.get(localObject);
    } while (((BFSActivityAddon)localObject).getType() != BFSActivityAddon.AddonType.InterstitialAds);
    ((BFSInterstitialAdActivityAddon)localObject).showAdWithTag("startup_interstitial");
    return true;
  }
  
  private void startGame()
  {
    if (!this.m_startedGame)
    {
      BFSDebug.i("PaperTossActivity.startingGame()");
      this.m_startedGame = true;
      Object localObject = new BFSMoPubBannerAdAddon(this, this.m_layout, false);
      ((BFSMoPubBannerAdAddon)localObject).onCreate();
      this.m_addons.put(((BFSMoPubBannerAdAddon)localObject).getName(), localObject);
      ((BFSMoPubBannerAdAddon)localObject).registerAd("main_menu", PaperTossThirdParty.query("MOPUB", this.m_ad_storefront_type, this.m_ad_device_type, "MENU_BANNER"), BFSBannerAdActivityAddon.BannerPosition.BannerPositionBottom);
      ((BFSMoPubBannerAdAddon)localObject).registerAd("gameplay", PaperTossThirdParty.query("MOPUB", this.m_ad_storefront_type, this.m_ad_device_type, "GAMEPLAY_BANNER"), BFSBannerAdActivityAddon.BannerPosition.BannerPositionTop);
      ((BFSMoPubBannerAdAddon)localObject).prepareAdWithTag("main_menu");
      ((BFSMoPubBannerAdAddon)localObject).showAdWithTag("main_menu");
      ((BFSMoPubBannerAdAddon)localObject).prepareAdWithTag("gameplay");
      localObject = (BFSMoPubInterstitialAdAddon)this.m_addons.get("BFSMoPubInterstitialAdAddon");
      if (localObject != null)
      {
        ((BFSMoPubInterstitialAdAddon)localObject).registerAd("gameplay_interstitial", PaperTossThirdParty.query("MOPUB", this.m_ad_storefront_type, this.m_ad_device_type, "GAMEPLAY_INTERSTITIAL"), BFSInterstitialAdActivityAddon.InterstitialType.GameplayInterstitial);
        ((BFSMoPubInterstitialAdAddon)localObject).prepareAdWithTag("gameplay_interstitial");
      }
      if (this.m_splashImage != null)
      {
        this.m_layout.removeView(this.m_splashImage);
        this.m_splashImage = null;
      }
      this.m_glView = new PapertossGLSurfaceView(this);
      this.m_glView.setRenderMode(1);
      if (Globals.soundMgr != null) {
        Globals.soundMgr.startBackgroundSound();
      }
      handleEventSubscriptions(true);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.m_layout.addView(this.m_glView, 0, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void adDidShow(String paramString)
  {
    BFSDebug.i("PaperTossActivity.adDidShow()");
    this.m_adDidShow = true;
  }
  
  public void adWillNotShow(String paramString)
  {
    BFSDebug.i("PaperTossActivity.adWillNotShow()");
    startGame();
  }
  
  public void adWillShow(String paramString)
  {
    BFSDebug.i("PaperTossActivity.adWillShow()");
    this.m_adWillShow = true;
  }
  
  protected void buildUserInterface()
  {
    this.m_layout = new RelativeLayout(this);
    this.m_layout.setBackgroundColor(-16777216);
    this.m_splashImage = new ImageView(this);
    this.m_splashImage.setImageResource(2130837517);
    this.m_splashImage.setScaleType(ImageView.ScaleType.FIT_XY);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.m_layout.addView(this.m_splashImage, localLayoutParams);
    setContentView(this.m_layout);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((BFSActivityAddon)this.m_addons.get(str)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    BFSDebug.i("PaperTossActivity.onCreate");
    super.onCreate(paramBundle);
    Globals.m_activity = this;
    buildUserInterface();
    this.m_startedGame = false;
    this.m_adWillShow = false;
    this.m_adDidShow = false;
    this.m_pauseTime = 0L;
    this.m_addons = new HashMap();
    paramBundle = new BFSMoPubConversionTrackerAddon(this);
    paramBundle.onCreate();
    this.m_addons.put(paramBundle.getName(), paramBundle);
    if (BFSDeviceInfo.isTabletDevice(this)) {}
    for (paramBundle = new BFSGoogleAnalyticsActivityAddon(this, "UA-29101149-8");; paramBundle = new BFSGoogleAnalyticsActivityAddon(this, "UA-29101149-2"))
    {
      paramBundle.onCreate();
      this.m_addons.put(paramBundle.getName(), paramBundle);
      paramBundle = new BFSMoPubInterstitialAdAddon(this, true);
      paramBundle.onCreate();
      this.m_addons.put(paramBundle.getName(), paramBundle);
      if (BFSDeviceInfo.isTabletDevice(this)) {
        this.m_ad_device_type = "tablet";
      }
      if (PaperTossApplication.getInstance().checkBuildConfigurationParameter("target-storefront", "amazon")) {
        this.m_ad_storefront_type = "amazon";
      }
      paramBundle.registerAd("startup_interstitial", PaperTossThirdParty.query("MOPUB", this.m_ad_storefront_type, this.m_ad_device_type, "STARTUP_INTERSTITIAL"), BFSInterstitialAdActivityAddon.InterstitialType.StartupInterstitial);
      paramBundle.prepareAdWithTag("startup_interstitial");
      return;
    }
  }
  
  public void onDestroy()
  {
    BFSDebug.i("PaperTossActivity.onDestroy");
    super.onDestroy();
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((BFSActivityAddon)this.m_addons.get(str)).onDestroy();
    }
    this.m_addons.clear();
    handleEventSubscriptions(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.m_startedGame) && (paramInt == 4))
    {
      if (Papertoss.state == Papertoss.GameState.LEVEL) {
        Evt.getInstance().publish("paperTossPlaySound", "Crumple.wav");
      }
      for (;;)
      {
        if (this.m_glView != null) {
          this.m_glView.queueEvent(new Runnable()
          {
            public void run()
            {
              Evt.getInstance().publish("gotoMenu");
            }
          });
        }
        return true;
        if (Papertoss.state == Papertoss.GameState.SCORE)
        {
          Evt.getInstance().publish("paperTossPlaySound", "Computer.wav");
        }
        else if (Papertoss.state == Papertoss.GameState.MENU)
        {
          Evt.getInstance().publish("paperTossPlaySound", "Crumple.wav");
          super.onKeyDown(paramInt, paramKeyEvent);
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    super.onOptionsItemSelected(paramMenuItem);
    if (paramMenuItem.getItemId() == 1) {
      this.m_glView.queueEvent(new Runnable()
      {
        public void run()
        {
          if (!Papertoss.getSound()) {}
          for (boolean bool = true;; bool = false)
          {
            Papertoss.setSound(bool);
            bool = Papertoss.getSound();
            Evt.getInstance().publish("setSound", Boolean.valueOf(bool));
            Evt.getInstance().publish("paperTossPlaySound", "Crumple.wav");
            return;
          }
        }
      });
    }
    while (paramMenuItem.getItemId() != 2) {
      return true;
    }
    this.m_glView.queueEvent(new Runnable()
    {
      public void run()
      {
        Evt.getInstance().publish("paperTossPlaySound", "Crumple.wav");
        Evt.getInstance().publish("scorePrompt");
      }
    });
    return true;
  }
  
  public void onPause()
  {
    BFSDebug.i("PaperTossActivity.onPause");
    super.onPause();
    this.m_pauseTime = System.currentTimeMillis();
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((BFSActivityAddon)this.m_addons.get(str)).onPause();
    }
    if (this.m_glView != null)
    {
      this.m_glView.onPause();
      this.m_glView.queueEvent(new Runnable()
      {
        public void run()
        {
          try
          {
            Papertoss.deactiviate();
            Papertoss.shutdown();
            return;
          }
          catch (Exception localException)
          {
            PaperTossApplication.logErrorWithFlurry("onPause", localException, "PaperToss");
          }
        }
      });
      if (Globals.soundMgr != null) {
        Globals.soundMgr.stopBackgroundSound();
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    paramMenu.removeGroup(0);
    Object localObject;
    if (Papertoss.getSound())
    {
      localObject = "Turn Sound Off";
      localObject = paramMenu.add(0, 1, 1, (CharSequence)localObject);
      if (!Papertoss.getSound()) {
        break label91;
      }
    }
    label91:
    for (int i = 2130837511;; i = 2130837510)
    {
      ((MenuItem)localObject).setIcon(i);
      if (Papertoss.state == Papertoss.GameState.LEVEL) {
        paramMenu.add(0, 2, 2, "Submit Score").setIcon(2130837509);
      }
      return true;
      localObject = "Turn Sound On";
      break;
    }
  }
  
  public void onResume()
  {
    BFSDebug.i("PaperTossActivity.onResume");
    super.onResume();
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((BFSActivityAddon)this.m_addons.get(str)).onResume();
    }
    boolean bool1 = this.m_adWillShow | this.m_adDidShow;
    this.m_adWillShow = false;
    this.m_adDidShow = false;
    int i = PaperTossApplication.getInstance().getRunCount();
    if (!this.m_startedGame) {
      if (!bool1) {
        if (!showStartupInterstitialAd(i)) {
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              PaperTossActivity.this.startGame();
            }
          }, 2000L);
        }
      }
    }
    do
    {
      boolean bool2;
      do
      {
        return;
        startGame();
        return;
        boolean bool3 = false;
        bool2 = bool3;
        if (!bool1)
        {
          bool2 = bool3;
          if (Math.abs(System.currentTimeMillis() - this.m_pauseTime) >= 300000L) {
            bool2 = showStartupInterstitialAd(i);
          }
        }
      } while (bool2);
      if (this.m_glView != null) {
        this.m_glView.onResume();
      }
    } while (Globals.soundMgr == null);
    Globals.soundMgr.startBackgroundSound();
  }
  
  public void onStart()
  {
    BFSDebug.i("PaperTossActivity.onStart");
    super.onStart();
    PaperTossApplication.getInstance().startFlurrySession();
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (BFSActivityAddon)this.m_addons.get(localObject);
      ((BFSActivityAddon)localObject).onStart();
      if (((BFSActivityAddon)localObject).getType() == BFSActivityAddon.AddonType.InterstitialAds) {
        ((BFSInterstitialAdActivityAddon)localObject).addActivityListener(this);
      }
    }
  }
  
  public void onStop()
  {
    BFSDebug.i("PaperTossActivity.onStop");
    super.onStop();
    Iterator localIterator = this.m_addons.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (BFSActivityAddon)this.m_addons.get(localObject);
      if (((BFSActivityAddon)localObject).getType() == BFSActivityAddon.AddonType.InterstitialAds) {
        ((BFSInterstitialAdActivityAddon)localObject).removeActivityListener(this);
      }
      ((BFSActivityAddon)localObject).onStop();
    }
    PaperTossApplication.getInstance().closeFlurrySession();
  }
  
  private class ExitPressed
    implements EvtListener
  {
    private ExitPressed() {}
    
    public void run(Object paramObject)
    {
      FlurryAgent.onEvent("ExitPressed");
      PaperTossActivity.this.finish();
    }
  }
  
  private class GoToMenu
    implements EvtListener
  {
    private GoToMenu() {}
    
    public void run(Object paramObject)
    {
      Globals.mainHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = PaperTossActivity.this.m_addons.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            localObject = (BFSActivityAddon)PaperTossActivity.this.m_addons.get(localObject);
            if (((BFSActivityAddon)localObject).getType() == BFSActivityAddon.AddonType.BannerAds) {
              ((BFSBannerAdActivityAddon)localObject).showAdWithTagDelayed("main_menu", 500L);
            }
          }
          PaperTossActivity.this.showGameplayInterstitialAd();
        }
      });
    }
  }
  
  private class HideAds
    implements EvtListener
  {
    private HideAds() {}
    
    public void run(Object paramObject)
    {
      Globals.mainHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = PaperTossActivity.this.m_addons.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            localObject = (BFSActivityAddon)PaperTossActivity.this.m_addons.get(localObject);
            if (((BFSActivityAddon)localObject).getType() == BFSActivityAddon.AddonType.BannerAds) {
              ((BFSBannerAdActivityAddon)localObject).hideBannerAds();
            }
          }
        }
      });
    }
  }
  
  private class ShowGameplayAds
    implements EvtListener
  {
    private ShowGameplayAds() {}
    
    public void run(Object paramObject)
    {
      Globals.mainHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = PaperTossActivity.this.m_addons.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            localObject = (BFSActivityAddon)PaperTossActivity.this.m_addons.get(localObject);
            if (((BFSActivityAddon)localObject).getType() == BFSActivityAddon.AddonType.BannerAds) {
              ((BFSBannerAdActivityAddon)localObject).showAdWithTagDelayed("gameplay", 1000L);
            }
          }
        }
      });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/PaperTossActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */