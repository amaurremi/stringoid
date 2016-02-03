package com.androidwasabi.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

public class PreferenceAd_ios7
  extends PreferenceAd
{
  public PreferenceAd_ios7(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void setInfo(Context paramContext)
  {
    this.url = "https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.ios7";
    this.name = paramContext.getString(R.string.ios7);
    this.image = paramContext.getResources().getDrawable(R.drawable.icon_ios7);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceAd_ios7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */