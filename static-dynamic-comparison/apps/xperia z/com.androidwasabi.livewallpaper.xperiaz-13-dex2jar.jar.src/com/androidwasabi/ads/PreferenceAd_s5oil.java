package com.androidwasabi.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

public class PreferenceAd_s5oil
  extends PreferenceAd
{
  public PreferenceAd_s5oil(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void setInfo(Context paramContext)
  {
    this.url = "https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.s5oil";
    this.name = paramContext.getString(R.string.s5oil);
    this.image = paramContext.getResources().getDrawable(R.drawable.icon_s5oil);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceAd_s5oil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */