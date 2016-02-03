package com.bubble.adserwer;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.bluebird.bubble.adserwer.tools.ads.Ad;
import com.bluebird.mobile.tools.commons.PopupListener;
import com.bluebird.mobile.tools.net.NetUtils;
import com.bluebird.mobile.tools.todays.offer.TodayOffer;
import com.bluebird.mobile.tools.todays.offer.TodayOfferAd;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Tracker;

public class HouseAd
{
  public static final int DEFAULT_SHOW_DELAY = 2000;
  Activity activity;
  TodayOffer adForHints;
  AdserwerBubble adserwer;
  
  public HouseAd(AdserwerBubble paramAdserwerBubble, Activity paramActivity)
  {
    this.adserwer = paramAdserwerBubble;
    this.activity = paramActivity;
  }
  
  private int getId(String paramString)
  {
    return this.activity.getResources().getIdentifier(paramString, "id", this.activity.getPackageName());
  }
  
  private void showAd(final Ad paramAd, boolean paramBoolean)
  {
    int i = paramAd.getImageRes96x96();
    Object localObject = paramAd.getAdUrl();
    String str1 = "" + paramAd.getPrizePerInstall();
    String str2 = paramAd.getAdName();
    String str3 = paramAd.getAdName();
    localObject = new TodayOfferAd(i, (String)localObject, new String[] { str1 }, new String[] { str2 }, new String[] { str3 });
    ((TodayOfferAd)localObject).setPopupListener(new PopupListener()
    {
      public void onClick()
      {
        paramAd.onClickAd();
        if (NetUtils.isOnline(HouseAd.this.activity.getApplicationContext())) {
          HouseAd.this.closeAdForHints();
        }
        EasyTracker.getTracker().trackEvent("HouseAdForHints", "Button Clicked", "'HouseAd click", Long.valueOf(0L));
      }
      
      public void onDismiss()
      {
        paramAd.onClickAd();
        EasyTracker.getTracker().trackEvent("HouseAdForHints", "Button Clicked", "'HouseAd close", Long.valueOf(0L));
      }
      
      public void onShowEnd() {}
      
      public void onShowStart()
      {
        EasyTracker.getTracker().trackEvent("HouseAdForHints", "HouseAd show", "'show", Long.valueOf(0L));
      }
    });
    this.adForHints = new TodayOffer((TodayOfferAd)localObject, this.activity);
    this.activity.findViewById(getId("todayOfferContainer")).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HouseAd.this.adForHints.openOfferUrl();
      }
    });
    this.adForHints.showOffer(paramBoolean);
    this.activity.findViewById(R.id.todayOfferLabel1).setVisibility(8);
  }
  
  public void closeAdForHints()
  {
    if (this.adForHints != null) {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          HouseAd.this.adForHints.closeOffer(false);
          HouseAd.this.showAdForHints(0, false);
        }
      }, 1500L);
    }
  }
  
  public void showAdForHints()
  {
    showAdForHints(0, false);
  }
  
  public boolean showAdForHints(int paramInt, final boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    final Ad localAd = this.adserwer.getRandomNoClickedAdByWeight();
    if (localAd != null)
    {
      if ((this.activity.findViewById(getId("todayOfferContainer")) == null) && (this.activity.findViewById(getId("todayOfferContainerViewStub")) != null)) {
        ((ViewStub)this.activity.findViewById(getId("todayOfferContainerViewStub"))).inflate();
      }
      bool1 = bool2;
      if (this.activity.findViewById(getId("todayOfferContainer")) != null) {
        bool1 = true;
      }
      if (paramInt == 0) {
        showAd(localAd, paramBoolean);
      }
    }
    else
    {
      return bool1;
    }
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        HouseAd.this.showAd(localAd, paramBoolean);
      }
    }, paramInt);
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/adserwer/HouseAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */