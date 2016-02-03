package com.adwhirl.adapters;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.ScrollView;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.ViewAdRunnable;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.AdWhirlTargeting;
import com.adwhirl.AdWhirlTargeting.Gender;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.google.ads.AdSenseSpec;
import com.google.ads.AdSenseSpec.AdFormat;
import com.google.ads.AdSenseSpec.ExpandDirection;
import com.google.ads.AdSpec.Parameter;
import com.google.ads.AdViewListener;
import com.google.ads.GoogleAdView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AdSenseAdapter
  extends AdWhirlAdapter
  implements AdViewListener
{
  private GoogleAdView adView;
  
  public AdSenseAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  private String channelValueToHex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 255)) {
      return null;
    }
    if (paramInt <= 15) {
      return "0" + Integer.toHexString(paramInt);
    }
    return Integer.toHexString(paramInt);
  }
  
  private String rgbToHex(int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = channelValueToHex(paramInt1);
    String str2 = channelValueToHex(paramInt2);
    String str3 = channelValueToHex(paramInt3);
    if ((str1 == null) || (str2 == null) || (str3 == null)) {
      return null;
    }
    return str1 + str2 + str3;
  }
  
  public void handle()
  {
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    Object localObject = this.ration.key;
    if ((localObject == null) || (!((String)localObject).startsWith("ca-mb-app-pub-")))
    {
      if (Extra2.verboselog) {
        Log.w("AdWhirl SDK", "Invalid AdSense client ID");
      }
      localAdWhirlLayout.rollover();
      return;
    }
    if ((TextUtils.isEmpty(googleAdSenseCompanyName)) || (TextUtils.isEmpty(googleAdSenseAppName)))
    {
      if (Extra2.verboselog) {
        Log.w("AdWhirl SDK", "AdSense company name and app name are required parameters");
      }
      localAdWhirlLayout.rollover();
      return;
    }
    ExtendedAdSenseSpec localExtendedAdSenseSpec = new ExtendedAdSenseSpec((String)localObject);
    localExtendedAdSenseSpec.setCompanyName(googleAdSenseCompanyName);
    localExtendedAdSenseSpec.setAppName(googleAdSenseAppName);
    if (!TextUtils.isEmpty(googleAdSenseChannel)) {
      localExtendedAdSenseSpec.setChannel(googleAdSenseChannel);
    }
    localExtendedAdSenseSpec.setKeywords(AdWhirlTargeting.getKeywords());
    if (!TextUtils.isEmpty(Extra2.googleAdSenseWebEquivalentUrl)) {
      localExtendedAdSenseSpec.setWebEquivalentUrl(Extra2.googleAdSenseWebEquivalentUrl);
    }
    if (localAdWhirlLayout.adsenseAdType != null) {
      localExtendedAdSenseSpec.setAdType(localAdWhirlLayout.adsenseAdType);
    }
    localExtendedAdSenseSpec.setAdFormat(AdSenseSpec.AdFormat.FORMAT_320x50);
    localExtendedAdSenseSpec.setAdTestEnabled(AdWhirlTargeting.getTestMode());
    this.adView = new GoogleAdView(localAdWhirlLayout.getContext());
    this.adView.setAdViewListener(this);
    localExtendedAdSenseSpec.setColorBackground(Extra2.adsenseColorBackground);
    localExtendedAdSenseSpec.setColorText(Extra2.adsenseColorText);
    localExtendedAdSenseSpec.setColorUrl(Extra2.adsenseColorUrl);
    localExtendedAdSenseSpec.setColorBorder(Extra2.adsenseColorBorder);
    localExtendedAdSenseSpec.setColorLink(Extra2.adsenseColorLink);
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "adsense keywords : " + AdWhirlTargeting.getKeywords());
    }
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "adsense googleAdSenseWebEquivalentUrl : " + Extra2.googleAdSenseWebEquivalentUrl);
    }
    localExtendedAdSenseSpec.setGender(AdWhirlTargeting.getGender());
    localExtendedAdSenseSpec.setAge(AdWhirlTargeting.getAge());
    if (AdWhirlTargeting.getKeywordSet() != null) {
      localObject = TextUtils.join(",", AdWhirlTargeting.getKeywordSet());
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localExtendedAdSenseSpec.setKeywords((String)localObject);
      }
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "adsense keywords : " + (String)localObject);
      }
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "adsense googleAdSenseWebEquivalentUrl : " + Extra2.googleAdSenseWebEquivalentUrl);
      }
      int i = 1;
      ViewParent localViewParent = localAdWhirlLayout.getParent();
      localObject = localViewParent;
      if (localViewParent == null)
      {
        i = 0;
        if ((i == 0) || (googleAdSenseExpandDirection == null)) {}
      }
      try
      {
        localExtendedAdSenseSpec.setExpandDirection(AdSenseSpec.ExpandDirection.valueOf(googleAdSenseExpandDirection));
        this.adView.setVisibility(4);
        localAdWhirlLayout.addView(this.adView, new ViewGroup.LayoutParams(-2, -2));
        this.adView.showAds(localExtendedAdSenseSpec);
        return;
        localObject = AdWhirlTargeting.getKeywords();
        continue;
        do
        {
          if (((localObject instanceof ListView)) || ((localObject instanceof ScrollView)))
          {
            i = 0;
            break;
          }
          localViewParent = ((ViewParent)localObject).getParent();
          localObject = localViewParent;
        } while (localViewParent != null);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;) {}
      }
    }
  }
  
  public void onAdFetchFailure()
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "AdSense failure");
    }
    this.adView.setAdViewListener(null);
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    localAdWhirlLayout.removeView(this.adView);
    localAdWhirlLayout.rollover();
  }
  
  public void onClickAd() {}
  
  public void onFinishFetchAd()
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "AdSense success");
    }
    this.adView.setAdViewListener(null);
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    localAdWhirlLayout.removeView(this.adView);
    this.adView.setVisibility(0);
    localAdWhirlLayout.adWhirlManager.resetRollover();
    localAdWhirlLayout.handler.post(new AdWhirlLayout.ViewAdRunnable(localAdWhirlLayout, this.adView));
    localAdWhirlLayout.rotateThreadedDelayed();
  }
  
  public void onStartFetchAd() {}
  
  class ExtendedAdSenseSpec
    extends AdSenseSpec
  {
    public int ageCode = -1;
    public int genderCode = -1;
    
    public ExtendedAdSenseSpec(String paramString)
    {
      super();
    }
    
    public List<AdSpec.Parameter> generateParameters(Context paramContext)
    {
      paramContext = new ArrayList(super.generateParameters(paramContext));
      if (this.ageCode != -1) {
        paramContext.add(new AdSpec.Parameter("cust_age", Integer.toString(this.ageCode)));
      }
      if (this.genderCode != -1) {
        paramContext.add(new AdSpec.Parameter("cust_gender", Integer.toString(this.genderCode)));
      }
      return paramContext;
    }
    
    public void setAge(int paramInt)
    {
      if (paramInt <= 0)
      {
        this.ageCode = -1;
        return;
      }
      if (paramInt <= 17)
      {
        this.ageCode = 1000;
        return;
      }
      if (paramInt <= 24)
      {
        this.ageCode = 1001;
        return;
      }
      if (paramInt <= 34)
      {
        this.ageCode = 1002;
        return;
      }
      if (paramInt <= 44)
      {
        this.ageCode = 1003;
        return;
      }
      if (paramInt <= 54)
      {
        this.ageCode = 1004;
        return;
      }
      if (paramInt <= 64)
      {
        this.ageCode = 1005;
        return;
      }
      this.ageCode = 1006;
    }
    
    public void setGender(AdWhirlTargeting.Gender paramGender)
    {
      if (paramGender == AdWhirlTargeting.Gender.MALE)
      {
        this.genderCode = 1;
        return;
      }
      if (paramGender == AdWhirlTargeting.Gender.FEMALE)
      {
        this.genderCode = 2;
        return;
      }
      this.genderCode = -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/AdSenseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */