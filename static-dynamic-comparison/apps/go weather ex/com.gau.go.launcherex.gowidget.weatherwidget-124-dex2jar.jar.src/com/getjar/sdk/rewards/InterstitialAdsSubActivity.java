package com.getjar.sdk.rewards;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.getjar.sdk.OnAdExpiredListener;
import com.getjar.sdk.comm.BeaconManager;
import com.getjar.sdk.comm.BeaconMessage.BeaconType;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.data.cache.Ad.State;
import com.getjar.sdk.data.cache.AdManager;
import com.getjar.sdk.data.cache.AdManager.AdType;
import com.getjar.sdk.exceptions.UnauthorizedException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

public class InterstitialAdsSubActivity
  extends GetJarWebViewSubActivity
{
  private final OnAdExpiredListener _adExpiredCallback = new OnAdExpiredListener()
  {
    public void onAdExpired(com.getjar.sdk.Ad paramAnonymousAd)
    {
      if (paramAnonymousAd.equals(InterstitialAdsSubActivity.this._currentAd))
      {
        Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: _adExpiredCallback.onAdExpired() closing UI", new Object[0]);
        InterstitialAdsSubActivity.access$202(InterstitialAdsSubActivity.this, Integer.valueOf(6));
        InterstitialAdsSubActivity.this.getJarActivity.setResult(6);
        InterstitialAdsSubActivity.this.getJarActivity.finish();
      }
    }
  };
  private final String _baseUrl;
  private volatile com.getjar.sdk.data.cache.Ad _currentAd = null;
  private volatile Integer _currentResultCode = null;
  private final JavaScriptAPI.JavaScriptCallbacks _javaScriptCallbacks = new JavaScriptAPI.JavaScriptCallbacks()
  {
    private final String _id = UUID.randomUUID().toString();
    
    public int compare(JavaScriptAPI.JavaScriptCallbacks paramAnonymousJavaScriptCallbacks1, JavaScriptAPI.JavaScriptCallbacks paramAnonymousJavaScriptCallbacks2)
    {
      return paramAnonymousJavaScriptCallbacks1.getUniqueId().compareTo(paramAnonymousJavaScriptCallbacks2.getUniqueId());
    }
    
    public boolean equals(Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof JavaScriptAPI.JavaScriptCallbacks))) {
        return false;
      }
      return getUniqueId().equals(((JavaScriptAPI.JavaScriptCallbacks)paramAnonymousObject).getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this._id;
    }
    
    public int hashCode()
    {
      return getUniqueId().hashCode();
    }
    
    public void notifyOnError(String paramAnonymousString)
    {
      try
      {
        Logger.e(Area.UI.value(), "InterstitialAdsSubActivity: _javaScriptCallbacks: notifyOnError() '%1$s'", new Object[] { paramAnonymousString });
        InterstitialAdsSubActivity.this._javaScriptErrorTags.add(paramAnonymousString);
        InterstitialAdsSubActivity.access$202(InterstitialAdsSubActivity.this, Integer.valueOf(2));
        InterstitialAdsSubActivity.this.getJarActivity.setResult(2);
        InterstitialAdsSubActivity.this.getJarActivity.finish();
        return;
      }
      catch (Exception paramAnonymousString)
      {
        Logger.e(Area.UI.value(), paramAnonymousString, "InterstitialAdsSubActivity: _javaScriptCallbacks: notifyOnError() failed", new Object[0]);
      }
    }
    
    public void notifyOnLoaded(String paramAnonymousString)
    {
      Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: _javaScriptCallbacks: notifyOnLoaded() '%1$s'", new Object[] { paramAnonymousString });
      InterstitialAdsSubActivity.this._javaScriptLoadedTags.add(paramAnonymousString);
    }
    
    public String toString()
    {
      return getUniqueId();
    }
  };
  private final ConcurrentLinkedQueue<String> _javaScriptErrorTags = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<String> _javaScriptLoadedTags = new ConcurrentLinkedQueue();
  private String _placementTag;
  private final String _uiSpecifier;
  
  InterstitialAdsSubActivity(GetJarActivity paramGetJarActivity, String paramString)
  {
    super(paramGetJarActivity, false);
    this._baseUrl = String.format("file:///android_asset/scopes/interstitial/templates/01410fa10000000000000001/1/main.html", new Object[] { GetJarConfig.getInstance(paramGetJarActivity).getDirectiveValue("interstitial_scope.template.id", SettingsManager.Scope.CLIENT), Integer.valueOf(GetJarConfig.getInstance(paramGetJarActivity).getIntegerValue("interstitial_scope.template.version", Integer.valueOf(-1), SettingsManager.Scope.CLIENT).intValue()) });
    this._uiSpecifier = paramString;
    Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: created [BaseURL:'%1$s']", new Object[] { this._baseUrl });
  }
  
  private String ensureCurrencyKey()
  {
    String str = getCurrencyKey();
    if (StringUtility.isNullOrEmpty(str)) {
      throw new IllegalStateException("No currency key currently set");
    }
    return str;
  }
  
  protected com.getjar.sdk.data.cache.Ad getAd()
  {
    return this._currentAd;
  }
  
  protected String getBaseUrl()
  {
    return this._baseUrl;
  }
  
  protected String getUiSpecifier()
  {
    return this._uiSpecifier;
  }
  
  public void onBackPressed()
  {
    try
    {
      if (this._currentAd != null) {
        _ExecutorServiceUIWork.execute(new Runnable()
        {
          public void run()
          {
            try
            {
              AdManager.getInstance().updateAdState(InterstitialAdsSubActivity.this._currentAd.getAdInventoryId(), Ad.State.CANCELLED, AdManager.AdType.INTERSTITIAL);
              HashMap localHashMap = Utility.jsonArrayStringToMap(InterstitialAdsSubActivity.this._currentAd.getTrackingMetadata());
              localHashMap.put("ads.layout_type", AdManager.AdType.INTERSTITIAL.name());
              if (InterstitialAdsSubActivity.this._placementTag == null) {}
              for (String str = "";; str = InterstitialAdsSubActivity.this._placementTag)
              {
                localHashMap.put("ads.placement", str);
                BeaconManager.getInstance(InterstitialAdsSubActivity.this.getJarActivity.getApplicationContext()).initiateBeaconMessage(InterstitialAdsSubActivity.this.mCommContext, BeaconMessage.BeaconType.AD_CANCELLED, localHashMap);
                return;
              }
              return;
            }
            catch (Throwable localThrowable)
            {
              Logger.e(Area.UI.value(), localThrowable, "InterstitialAdsSubActivity: onBackPressed() ExecutorService Runnable failed", new Object[0]);
            }
          }
        });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e(Area.UI.value(), localThrowable, "InterstitialAdsSubActivity: onBackPressed() failed", new Object[0]);
      return;
    }
    finally
    {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject3 = null;
    this._allowWaitDialog = false;
    super.ensureCommContext(this.getJarActivity);
    super.processIncomingIntent();
    this._placementTag = this.getJarActivity.getIntent().getStringExtra("placement_tag");
    Object localObject4;
    for (;;)
    {
      try
      {
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("ads.layout_type", AdManager.AdType.INTERSTITIAL.name());
        if (this._placementTag != null) {
          continue;
        }
        localObject1 = "";
        ((HashMap)localObject4).put("ads.placement", localObject1);
        BeaconManager.getInstance(this.getJarActivity.getApplicationContext()).initiateBeaconMessage(this.mCommContext, BeaconMessage.BeaconType.AD_ATTEMPT_SHOWN, (HashMap)localObject4);
      }
      catch (Exception localException)
      {
        Object localObject1;
        Logger.e(Area.DEVELOPER_API.value(), localException, "InterstitialAdsSubActivity: onCreate() beacon call failed [AD_ATTEMPT_SHOWN]", new Object[0]);
        continue;
      }
      localObject4 = ensureCurrencyKey();
      AdManager.initialize(this.mCommContext);
      localObject1 = AdManager.getInstance().getAd(this._placementTag, (String)localObject4, this._adExpiredCallback);
      if ((localObject1 == null) || (((com.getjar.sdk.data.cache.Ad)localObject1).hasImageType("INTERSTITIAL"))) {
        break;
      }
      localObject1 = AdManager.getInstance().getAd(this._placementTag, (String)localObject4, this._adExpiredCallback);
      continue;
      localObject1 = this._placementTag;
    }
    if (localException == null)
    {
      Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: onCreate() no ad available, closing UI", new Object[0]);
      while (AdManager.getInstance().getAd(this._placementTag, (String)localObject4, null) != null) {
        Logger.e(Area.UI.value(), "InterstitialAdsSubActivity: onCreate() consumed ad with missing image asset", new Object[0]);
      }
      this._currentResultCode = Integer.valueOf(2);
      this.getJarActivity.setResult(2);
      this.getJarActivity.finish();
      return;
    }
    this._currentAd = localException;
    long l = Area.UI.value();
    if (this._currentAd == null) {}
    for (Object localObject2 = localObject3;; localObject2 = this._currentAd.getAdInventoryId())
    {
      Logger.d(l, "InterstitialAdsSubActivity: onCreate() ad loaded [InventoryId:'%1$s']", new Object[] { localObject2 });
      super.onCreate(paramBundle);
      this.mJavaScriptInterface.setInterstitialAdPlacementTag(this._placementTag);
      mWebView.setBackgroundColor(0);
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      try
      {
        View.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(mWebView, new Object[] { Integer.valueOf(1), new Paint() });
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mJavaScriptInterface.unregisterCallbacks(this._javaScriptCallbacks);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mJavaScriptInterface.registerCallbacks(this._javaScriptCallbacks);
    if (!"none".equalsIgnoreCase(ensureCurrencyKey()))
    {
      AuthManager.initialize(this.getJarActivity);
      if (!AuthManager.getInstance().getClaimsManager(this.getJarActivity).canEarn()) {
        throw new UnauthorizedException("The provided Application Token is not allowed to use the incentivized Interstitial features");
      }
    }
  }
  
  public void onStop()
  {
    String str = null;
    for (;;)
    {
      try
      {
        long l = Area.UI.value();
        int j;
        if (this._currentAd == null)
        {
          Logger.d(l, "InterstitialAdsSubActivity: onStop() START [InventoryId:'%1$s']", new Object[] { str });
          j = 0;
          i = j;
          if (this._currentAd != null)
          {
            i = j;
            if (this._currentResultCode == null)
            {
              if (!this._currentAd.hasBeenTriggered()) {
                continue;
              }
              i = 1;
              Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: onStop() ad TRIGGERED [InventoryId:'%1$s']", new Object[] { this._currentAd.getAdInventoryId() });
            }
          }
          if (i == 0) {
            break label240;
          }
          this.getJarActivity.setResult(-1);
          Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: onStop() result set to %1$d", new Object[] { Integer.valueOf(-1) });
          this._currentResultCode = null;
          this._currentAd = null;
          this.getJarActivity.finish();
          super.onStop();
        }
        else
        {
          str = this._currentAd.getAdInventoryId();
          continue;
        }
        int i = j;
        if (!this._currentAd.hasBeenCancelled()) {
          continue;
        }
        Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: onStop() ad CANCELLED [InventoryId:'%1$s']", new Object[] { this._currentAd.getAdInventoryId() });
        i = j;
        continue;
        if (this._currentResultCode != null) {
          continue;
        }
      }
      finally
      {
        Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: onStop() FINISH", new Object[0]);
      }
      label240:
      this.getJarActivity.setResult(0);
      Logger.d(Area.UI.value(), "InterstitialAdsSubActivity: onStop() result set to %1$d", new Object[] { Integer.valueOf(0) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/InterstitialAdsSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */