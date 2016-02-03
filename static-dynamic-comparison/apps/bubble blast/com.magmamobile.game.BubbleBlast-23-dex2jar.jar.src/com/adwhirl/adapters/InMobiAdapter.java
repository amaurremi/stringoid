package com.adwhirl.adapters;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.ViewAdRunnable;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.AdWhirlTargeting;
import com.adwhirl.AdWhirlTargeting.Gender;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.inmobi.androidsdk.IMAdListener;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.IMAdRequest.GenderType;
import com.inmobi.androidsdk.IMAdView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class InMobiAdapter
  extends AdWhirlAdapter
{
  public int adUnit = 15;
  private Extra extra = null;
  private IMAdListener mIMAdListener = new IMAdListener()
  {
    public void onAdRequestCompleted(IMAdView paramAnonymousIMAdView)
    {
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "InMobi success");
      }
      AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)InMobiAdapter.this.adWhirlLayoutReference.get();
      if (localAdWhirlLayout == null) {
        return;
      }
      localAdWhirlLayout.adWhirlManager.resetRollover();
      localAdWhirlLayout.handler.post(new AdWhirlLayout.ViewAdRunnable(localAdWhirlLayout, paramAnonymousIMAdView));
      localAdWhirlLayout.rotateThreadedDelayed();
    }
    
    public void onAdRequestFailed(IMAdView paramAnonymousIMAdView, IMAdRequest.ErrorCode paramAnonymousErrorCode)
    {
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "InMobi failure, errorCode: " + paramAnonymousErrorCode);
      }
      paramAnonymousIMAdView = (AdWhirlLayout)InMobiAdapter.this.adWhirlLayoutReference.get();
      if (paramAnonymousIMAdView == null) {
        return;
      }
      paramAnonymousIMAdView.rollover();
    }
    
    public void onDismissAdScreen(IMAdView paramAnonymousIMAdView) {}
    
    public void onLeaveApplication(IMAdView paramAnonymousIMAdView) {}
    
    public void onShowAdScreen(IMAdView paramAnonymousIMAdView) {}
  };
  
  public InMobiAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
    this.extra = paramAdWhirlLayout.extra;
  }
  
  public IMAdRequest.GenderType getGender()
  {
    AdWhirlTargeting.Gender localGender = AdWhirlTargeting.getGender();
    if (AdWhirlTargeting.Gender.MALE == localGender) {
      return IMAdRequest.GenderType.MALE;
    }
    if (AdWhirlTargeting.Gender.FEMALE == localGender) {
      return IMAdRequest.GenderType.FEMALE;
    }
    return IMAdRequest.GenderType.NONE;
  }
  
  public String getKeywords()
  {
    return AdWhirlTargeting.getKeywords();
  }
  
  public String getPostalCode()
  {
    return AdWhirlTargeting.getPostalCode();
  }
  
  public boolean getTestMode()
  {
    return AdWhirlTargeting.getTestMode();
  }
  
  public void handle()
  {
    Object localObject = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (Activity)((AdWhirlLayout)localObject).activityReference.get();
    } while (localObject == null);
    localObject = new IMAdView((Activity)localObject, this.adUnit, this.ration.key);
    IMAdRequest localIMAdRequest = new IMAdRequest();
    localIMAdRequest.setAge(AdWhirlTargeting.getAge());
    localIMAdRequest.setGender(getGender());
    localIMAdRequest.setLocationInquiryAllowed(isLocationInquiryAllowed());
    localIMAdRequest.setTestMode(getTestMode());
    localIMAdRequest.setKeywords(getKeywords());
    localIMAdRequest.setPostalCode(getPostalCode());
    HashMap localHashMap = new HashMap();
    localHashMap.put("tp", "c_adwhirl");
    localIMAdRequest.setRequestParams(localHashMap);
    ((IMAdView)localObject).setRefreshInterval(-1);
    ((IMAdView)localObject).setIMAdListener(this.mIMAdListener);
    ((IMAdView)localObject).loadNewAd(localIMAdRequest);
  }
  
  public boolean isLocationInquiryAllowed()
  {
    return this.extra.locationOn == 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/InMobiAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */