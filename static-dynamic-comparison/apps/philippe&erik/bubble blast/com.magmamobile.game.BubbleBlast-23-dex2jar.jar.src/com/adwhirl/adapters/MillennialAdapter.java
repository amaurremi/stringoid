package com.adwhirl.adapters;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.ViewAdRunnable;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.AdWhirlTargeting;
import com.adwhirl.AdWhirlTargeting.Gender;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView.MMAdListener;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

public class MillennialAdapter
  extends AdWhirlAdapter
  implements MMAdView.MMAdListener
{
  public MillennialAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  public void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean) {}
  
  public void MMAdClickedToNewBrowser(MMAdView paramMMAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Millennial Ad clicked, new browser launched");
    }
  }
  
  public void MMAdClickedToOverlay(MMAdView paramMMAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Millennial Ad Clicked to overlay");
    }
  }
  
  public void MMAdFailed(MMAdView paramMMAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Millennial failure");
    }
    paramMMAdView.setListener(null);
    paramMMAdView = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (paramMMAdView == null) {
      return;
    }
    paramMMAdView.rollover();
  }
  
  public void MMAdOverlayLaunched(MMAdView paramMMAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Millennial Ad Overlay Launched");
    }
  }
  
  public void MMAdRequestIsCaching(MMAdView paramMMAdView) {}
  
  public void MMAdReturned(MMAdView paramMMAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Millennial success");
    }
    paramMMAdView.setListener(null);
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    localAdWhirlLayout.adWhirlManager.resetRollover();
    localAdWhirlLayout.handler.post(new AdWhirlLayout.ViewAdRunnable(localAdWhirlLayout, paramMMAdView));
    localAdWhirlLayout.rotateThreadedDelayed();
  }
  
  public void handle()
  {
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    Object localObject = AdWhirlTargeting.getGender();
    if (localObject == AdWhirlTargeting.Gender.MALE)
    {
      localHashtable.put("gender", "male");
      int i = AdWhirlTargeting.getAge();
      if (i != -1) {
        localHashtable.put("age", String.valueOf(i));
      }
      localObject = AdWhirlTargeting.getPostalCode();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashtable.put("zip", localObject);
      }
      if (AdWhirlTargeting.getKeywordSet() == null) {
        break label233;
      }
    }
    label233:
    for (localObject = TextUtils.join(",", AdWhirlTargeting.getKeywordSet());; localObject = AdWhirlTargeting.getKeywords())
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashtable.put("keywords", localObject);
      }
      localHashtable.put("vendor", "adwhirl");
      localObject = new MMAdView((Activity)localAdWhirlLayout.getContext(), this.ration.key, "MMBannerAdTop", -1, localHashtable);
      ((MMAdView)localObject).setId(1897808289);
      ((MMAdView)localObject).setListener(this);
      ((MMAdView)localObject).callForAd();
      if ((localAdWhirlLayout.extra.locationOn == 1) && (localAdWhirlLayout.adWhirlManager.location != null)) {
        ((MMAdView)localObject).updateUserLocation(localAdWhirlLayout.adWhirlManager.location);
      }
      ((MMAdView)localObject).setHorizontalScrollBarEnabled(false);
      ((MMAdView)localObject).setVerticalScrollBarEnabled(false);
      return;
      if (localObject != AdWhirlTargeting.Gender.FEMALE) {
        break;
      }
      localHashtable.put("gender", "female");
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/MillennialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */