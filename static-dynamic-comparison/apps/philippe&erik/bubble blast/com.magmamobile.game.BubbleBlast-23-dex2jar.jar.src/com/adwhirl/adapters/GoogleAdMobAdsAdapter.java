package com.adwhirl.adapters;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.ViewAdRunnable;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.AdWhirlTargeting;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GoogleAdMobAdsAdapter
  extends AdWhirlAdapter
  implements AdListener
{
  public GoogleAdMobAdsAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  protected String birthdayForAdWhirlTargeting()
  {
    if (AdWhirlTargeting.getBirthDate() != null) {
      return new SimpleDateFormat("yyyyMMdd").format(AdWhirlTargeting.getBirthDate().getTime());
    }
    return null;
  }
  
  protected AdRequest.Gender genderForAdWhirlTargeting()
  {
    switch (AdWhirlTargeting.getGender())
    {
    default: 
      return null;
    case MALE: 
      return AdRequest.Gender.MALE;
    }
    return AdRequest.Gender.FEMALE;
  }
  
  public void handle()
  {
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {}
    do
    {
      return;
      localObject = (Activity)localAdWhirlLayout.activityReference.get();
    } while (localObject == null);
    Object localObject = new AdView((Activity)localObject, AdSize.BANNER, this.ration.key);
    ((AdView)localObject).setAdListener(this);
    ((AdView)localObject).loadAd(requestForAdWhirlLayout(localAdWhirlLayout));
  }
  
  protected void log(String paramString)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "GoogleAdapter " + paramString);
    }
  }
  
  public void onDismissScreen(Ad paramAd) {}
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
    log("failure (" + paramErrorCode + ")");
    paramAd.setAdListener(null);
    paramAd = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (paramAd == null) {
      return;
    }
    paramAd.rollover();
  }
  
  public void onLeaveApplication(Ad paramAd) {}
  
  public void onPresentScreen(Ad paramAd) {}
  
  public void onReceiveAd(Ad paramAd)
  {
    log("success");
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    if (!(paramAd instanceof AdView))
    {
      log("invalid AdView");
      return;
    }
    paramAd = (AdView)paramAd;
    localAdWhirlLayout.adWhirlManager.resetRollover();
    localAdWhirlLayout.handler.post(new AdWhirlLayout.ViewAdRunnable(localAdWhirlLayout, paramAd));
    localAdWhirlLayout.rotateThreadedDelayed();
  }
  
  protected AdRequest requestForAdWhirlLayout(AdWhirlLayout paramAdWhirlLayout)
  {
    AdRequest localAdRequest = new AdRequest();
    localAdRequest.setGender(genderForAdWhirlTargeting());
    if (paramAdWhirlLayout.extra.locationOn == 1) {
      localAdRequest.setLocation(paramAdWhirlLayout.adWhirlManager.location);
    }
    localAdRequest.setKeywords(AdWhirlTargeting.getKeywordSet());
    return localAdRequest;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/GoogleAdMobAdsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */