package com.androidwasabi.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PreferenceAd
  extends Preference
  implements Preference.OnPreferenceClickListener
{
  protected Drawable image = null;
  protected String name = "";
  protected String url = "";
  
  public PreferenceAd(Context paramContext)
  {
    super(paramContext, null);
    setOnPreferenceClickListener(this);
    setInfo(paramContext);
  }
  
  public PreferenceAd(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnPreferenceClickListener(this);
    setInfo(paramContext);
  }
  
  public PreferenceAd(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    super(paramContext, null);
    setOnPreferenceClickListener(this);
    setInfo(paramString1, paramString2, paramDrawable);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (this.image != null) {}
    for (int i = R.layout.preference_ad;; i = R.layout.preference_ad2)
    {
      paramViewGroup = paramViewGroup.inflate(i, null);
      ((TextView)paramViewGroup.findViewById(R.id.title)).setText(this.name);
      if (this.image != null) {
        ((ImageView)paramViewGroup.findViewById(R.id.icon)).setImageDrawable(this.image);
      }
      return paramViewGroup;
    }
  }
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    if (this.url.equals("")) {
      return false;
    }
    try
    {
      paramPreference = new Intent("android.intent.action.VIEW", Uri.parse(this.url));
      getContext().startActivity(paramPreference);
      return true;
    }
    catch (ActivityNotFoundException paramPreference) {}
    return false;
  }
  
  protected void setInfo(Context paramContext)
  {
    this.name = "";
    this.url = "";
    this.image = null;
  }
  
  protected void setInfo(String paramString1, String paramString2, Drawable paramDrawable)
  {
    this.name = paramString1;
    this.url = paramString2;
    this.image = paramDrawable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */