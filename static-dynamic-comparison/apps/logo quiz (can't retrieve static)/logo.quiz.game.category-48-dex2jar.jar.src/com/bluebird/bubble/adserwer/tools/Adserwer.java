package com.bluebird.bubble.adserwer.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.bluebird.bubble.adserwer.tools.ads.Ad;
import com.bluebird.mobile.tools.CommonPreferencesName;
import com.bluebird.mobile.tools.counter.BasicCounterServiceFactory;
import com.bluebird.mobile.tools.counter.CounterService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Adserwer
{
  public static final String GOOGLE_PLAY_PREFIX_URL = "market://details?id=";
  protected Activity activity;
  public String adViewContainer320x50 = "adview_container";
  private List<Ad> ads = new ArrayList();
  protected CounterService prizeCounterService;
  protected PrizeListener prizeListener;
  
  public Adserwer(CommonPreferencesName paramCommonPreferencesName, Activity paramActivity)
  {
    this.activity = paramActivity;
    this.prizeCounterService = BasicCounterServiceFactory.getInstance(paramActivity, paramCommonPreferencesName);
  }
  
  public Adserwer(List<Ad> paramList, CommonPreferencesName paramCommonPreferencesName, Activity paramActivity)
  {
    this.ads = paramList;
    this.activity = paramActivity;
    this.prizeCounterService = BasicCounterServiceFactory.getInstance(paramActivity, paramCommonPreferencesName);
  }
  
  private ImageView createAd320x50(final Ad paramAd)
  {
    ImageView localImageView = new ImageView(this.activity);
    Object localObject = new RelativeLayout.LayoutParams(dip(320), dip(50));
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = false;
    localImageView.setImageBitmap(BitmapFactory.decodeResource(this.activity.getResources(), paramAd.getImageRes320x50(), (BitmapFactory.Options)localObject));
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent("android.intent.action.VIEW");
        paramAnonymousView.addFlags(1073741824);
        paramAnonymousView.setData(Uri.parse(paramAd.getAdUrl()));
        Adserwer.this.activity.startActivity(paramAnonymousView);
        paramAd.onClickAd();
      }
    });
    return localImageView;
  }
  
  private int dip(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, this.activity.getResources().getDisplayMetrics());
  }
  
  private ViewGroup getAdviewContainer()
  {
    int i = this.activity.getResources().getIdentifier(this.adViewContainer320x50, "id", this.activity.getPackageName());
    return (ViewGroup)this.activity.findViewById(i);
  }
  
  public int collectPrizes()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.activity);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("FIRST_COLLECT_PRIZES", true);
    int i = 0;
    Iterator localIterator = this.ads.iterator();
    while (localIterator.hasNext())
    {
      Ad localAd = (Ad)localIterator.next();
      if (localAd.isEnable())
      {
        boolean bool2 = localAd.collectPrize();
        if ((!bool1) && (bool2))
        {
          this.prizeCounterService.add(localAd.getPrizePerInstall());
          i += localAd.getPrizePerInstall();
        }
      }
    }
    if (i > 0) {
      this.prizeListener.onPrizeCollection(i);
    }
    if (bool1)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("FIRST_COLLECT_PRIZES", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return i;
  }
  
  public List<Ad> getActiveAds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ads.iterator();
    while (localIterator.hasNext())
    {
      Ad localAd = (Ad)localIterator.next();
      if (localAd.isActive()) {
        localArrayList.add(localAd);
      }
    }
    return localArrayList;
  }
  
  public List<Ad> getAllAds()
  {
    return this.ads;
  }
  
  public List<Ad> getNoClickedAds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ads.iterator();
    while (localIterator.hasNext())
    {
      Ad localAd = (Ad)localIterator.next();
      if ((!localAd.isClicked()) && (localAd.isActive())) {
        localArrayList.add(localAd);
      }
    }
    return localArrayList;
  }
  
  public Ad getRandomAd()
  {
    Ad localAd = null;
    List localList = getActiveAds();
    if (localList.size() > 0) {
      localAd = (Ad)localList.get((int)(System.currentTimeMillis() % localList.size()));
    }
    return localAd;
  }
  
  public Ad getRandomAdByWeight()
  {
    return getRandomAdByWeight(getActiveAds());
  }
  
  public Ad getRandomAdByWeight(List<Ad> paramList)
  {
    Object localObject = null;
    double d;
    int k;
    int i;
    if (paramList.size() > 0)
    {
      d = 0.0D;
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext()) {
        d += ((Ad)((Iterator)localObject).next()).getWeight();
      }
      k = -1;
      d = Math.random() * d;
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < paramList.size())
      {
        d -= ((Ad)paramList.get(i)).getWeight();
        if (d <= 0.0D) {
          j = i;
        }
      }
      else
      {
        localObject = (Ad)paramList.get(j);
        return (Ad)localObject;
      }
      i += 1;
    }
  }
  
  public Ad getRandomNoClickedAdByWeight()
  {
    return getRandomAdByWeight(getNoClickedAds());
  }
  
  public void setAd320x50(Ad paramAd1, Ad paramAd2)
  {
    Object localObject = null;
    if (paramAd1 != null) {}
    try
    {
      paramAd1 = createAd320x50(paramAd1);
      for (;;)
      {
        if (paramAd1 != null)
        {
          paramAd2 = getAdviewContainer();
          paramAd2.removeAllViews();
          paramAd2.addView(paramAd1);
        }
        return;
        paramAd1 = (Ad)localObject;
        if (paramAd2 != null) {
          paramAd1 = createAd320x50((Ad)this.ads.get(0));
        }
      }
    }
    catch (Exception paramAd1)
    {
      for (;;)
      {
        paramAd1 = null;
      }
    }
  }
  
  public void setAdViewContainer320x50(String paramString)
  {
    this.adViewContainer320x50 = paramString;
  }
  
  public void setAds(List<Ad> paramList)
  {
    this.ads = paramList;
  }
  
  public void setPrizeListener(PrizeListener paramPrizeListener)
  {
    this.prizeListener = paramPrizeListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/bubble/adserwer/tools/Adserwer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */