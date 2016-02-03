package com.androidwasabi.ads;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PreferenceMoreFreeApps
  extends Preference
{
  int title = R.string.app_wall_title_label;
  
  public PreferenceMoreFreeApps(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public PreferenceMoreFreeApps(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(R.layout.preference_morefreeapps, null);
    ((TextView)paramViewGroup.findViewById(R.id.title)).setText(this.title);
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceMoreFreeApps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */