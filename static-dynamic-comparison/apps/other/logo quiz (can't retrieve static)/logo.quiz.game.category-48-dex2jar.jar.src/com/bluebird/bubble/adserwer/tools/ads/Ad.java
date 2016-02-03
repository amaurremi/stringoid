package com.bluebird.bubble.adserwer.tools.ads;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Ad
{
  protected Activity activity;
  protected String adName;
  protected String adUrl;
  protected boolean enable = true;
  protected int id;
  protected int imageRes320x50;
  protected int imageRes96x96;
  protected int prizePerInstall = 0;
  protected int weight;
  
  public Ad(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, Activity paramActivity)
  {
    this.id = paramInt1;
    this.weight = paramInt2;
    this.imageRes96x96 = paramInt3;
    this.imageRes320x50 = paramInt4;
    this.prizePerInstall = paramInt5;
    this.adName = paramString1;
    this.adUrl = paramString2;
    this.activity = paramActivity;
  }
  
  public boolean collectPrize()
  {
    boolean bool = false;
    if (!isCollected())
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).edit();
      localEditor.putBoolean("ad" + getId() + "collected", true);
      localEditor.commit();
      bool = true;
    }
    return bool;
  }
  
  public String getAdName()
  {
    return this.adName;
  }
  
  public String getAdUrl()
  {
    return this.adUrl;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getImageRes320x50()
  {
    return this.imageRes320x50;
  }
  
  public int getImageRes96x96()
  {
    return this.imageRes96x96;
  }
  
  public int getPrizePerInstall()
  {
    return this.prizePerInstall;
  }
  
  public int getWeight()
  {
    return this.weight;
  }
  
  public boolean isActive()
  {
    return (this.enable) && (!isCollected());
  }
  
  public boolean isClicked()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).getBoolean("ad" + getId() + "clicked", false);
  }
  
  public boolean isCollected()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).getBoolean("ad" + getId() + "collected", false);
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void onClickAd()
  {
    if (!isClicked())
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).edit();
      localEditor.putBoolean("ad" + getId() + "clicked", true);
      localEditor.commit();
    }
  }
  
  public void setAdName(String paramString)
  {
    this.adName = paramString;
  }
  
  public void setAdUrl(String paramString)
  {
    this.adUrl = paramString;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageRes320x50(int paramInt)
  {
    this.imageRes320x50 = paramInt;
  }
  
  public void setImageRes96x96(int paramInt)
  {
    this.imageRes96x96 = paramInt;
  }
  
  public void setPrizePerInstall(int paramInt)
  {
    this.prizePerInstall = paramInt;
  }
  
  public void setWeight(int paramInt)
  {
    this.weight = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/bubble/adserwer/tools/ads/Ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */