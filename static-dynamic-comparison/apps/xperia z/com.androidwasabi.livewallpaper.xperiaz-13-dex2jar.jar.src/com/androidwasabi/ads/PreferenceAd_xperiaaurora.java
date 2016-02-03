package com.androidwasabi.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

public class PreferenceAd_xperiaaurora
  extends PreferenceAd
{
  public PreferenceAd_xperiaaurora(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void setInfo(Context paramContext)
  {
    this.url = "https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.xperiaaurora";
    this.name = paramContext.getString(R.string.xperiaaurora);
    this.image = paramContext.getResources().getDrawable(R.drawable.icon_xperiaaurora);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceAd_xperiaaurora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */