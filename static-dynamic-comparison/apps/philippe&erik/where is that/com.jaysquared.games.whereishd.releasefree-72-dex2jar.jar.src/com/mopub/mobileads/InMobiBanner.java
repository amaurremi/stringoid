package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.InMobi.LOG_LEVEL;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import com.mopub.common.util.Views;
import java.util.HashMap;
import java.util.Map;

public class InMobiBanner
  extends CustomEventBanner
  implements IMBannerListener
{
  private static boolean isAppInitialized = false;
  private IMBanner iMBanner;
  private CustomEventBanner.CustomEventBannerListener mBannerListener;
  
  protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    this.mBannerListener = paramCustomEventBannerListener;
    paramCustomEventBannerListener = null;
    if ((paramContext instanceof Activity)) {
      paramCustomEventBannerListener = (Activity)paramContext;
    }
    if (paramCustomEventBannerListener == null)
    {
      this.mBannerListener.onBannerFailed(null);
      return;
    }
    if (!isAppInitialized)
    {
      InMobi.initialize(paramCustomEventBannerListener, "YOUR_INMOBI_APP_ID");
      isAppInitialized = true;
    }
    this.iMBanner = new IMBanner(paramCustomEventBannerListener, "YOUR_INMOBI_APP_ID", 15);
    paramContext = new HashMap();
    paramContext.put("tp", "c_mopub");
    paramContext.put("tp-ver", "2.0");
    this.iMBanner.setRequestParams(paramContext);
    InMobi.setLogLevel(InMobi.LOG_LEVEL.VERBOSE);
    this.iMBanner.setIMBannerListener(this);
    this.iMBanner.setRefreshInterval(-1);
    this.iMBanner.loadBanner();
  }
  
  public void onBannerInteraction(IMBanner paramIMBanner, Map<String, String> paramMap)
  {
    this.mBannerListener.onBannerClicked();
  }
  
  public void onBannerRequestFailed(IMBanner paramIMBanner, IMErrorCode paramIMErrorCode)
  {
    if (paramIMErrorCode == IMErrorCode.INTERNAL_ERROR)
    {
      this.mBannerListener.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramIMErrorCode == IMErrorCode.INVALID_REQUEST)
    {
      this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
      return;
    }
    if (paramIMErrorCode == IMErrorCode.NETWORK_ERROR)
    {
      this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
      return;
    }
    if (paramIMErrorCode == IMErrorCode.NO_FILL)
    {
      this.mBannerListener.onBannerFailed(MoPubErrorCode.NO_FILL);
      return;
    }
    this.mBannerListener.onBannerFailed(MoPubErrorCode.UNSPECIFIED);
  }
  
  public void onBannerRequestSucceeded(IMBanner paramIMBanner)
  {
    if (this.iMBanner != null)
    {
      this.mBannerListener.onBannerLoaded(paramIMBanner);
      return;
    }
    this.mBannerListener.onBannerFailed(null);
  }
  
  public void onDismissBannerScreen(IMBanner paramIMBanner)
  {
    this.mBannerListener.onBannerCollapsed();
  }
  
  public void onInvalidate()
  {
    if (this.iMBanner != null)
    {
      this.iMBanner.setIMBannerListener(null);
      Views.removeFromParent(this.iMBanner);
      this.iMBanner.destroy();
    }
  }
  
  public void onLeaveApplication(IMBanner paramIMBanner) {}
  
  public void onShowBannerScreen(IMBanner paramIMBanner)
  {
    this.mBannerListener.onBannerExpanded();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/InMobiBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */