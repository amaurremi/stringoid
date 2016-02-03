package com.androidwasabi.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

public class PreferenceAd_notepro
  extends PreferenceAd
{
  public PreferenceAd_notepro(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void setInfo(Context paramContext)
  {
    this.url = "https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.notepro";
    this.name = paramContext.getString(R.string.notepro);
    this.image = paramContext.getResources().getDrawable(R.drawable.icon_notepro);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceAd_notepro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */