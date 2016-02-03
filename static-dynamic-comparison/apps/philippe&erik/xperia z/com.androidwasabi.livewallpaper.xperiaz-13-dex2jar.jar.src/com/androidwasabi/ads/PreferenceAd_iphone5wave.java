package com.androidwasabi.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

public class PreferenceAd_iphone5wave
  extends PreferenceAd
{
  public PreferenceAd_iphone5wave(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void setInfo(Context paramContext)
  {
    this.url = "https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.iphone5wave";
    this.name = paramContext.getString(R.string.iphone5wave);
    this.image = paramContext.getResources().getDrawable(R.drawable.icon_iphone5wave);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceAd_iphone5wave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */