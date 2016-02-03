package com.androidwasabi.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PreferenceNewApp
  extends Preference
  implements Preference.OnPreferenceClickListener
{
  private String directlink = "0";
  private Bitmap image;
  private String info = "";
  private String title = "";
  private String url = "";
  
  public PreferenceNewApp(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnPreferenceClickListener(this);
  }
  
  public PreferenceNewApp(Context paramContext, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    super(paramContext, null);
    this.title = paramString1;
    this.image = paramBitmap;
    this.url = paramString2;
    this.directlink = "0";
    setOnPreferenceClickListener(this);
  }
  
  public PreferenceNewApp(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3)
  {
    super(paramContext, null);
    this.title = paramString1;
    this.info = paramString2;
    this.image = paramBitmap;
    this.url = paramString3;
    this.directlink = "0";
    setOnPreferenceClickListener(this);
  }
  
  public PreferenceNewApp(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    super(paramContext, null);
    this.title = paramString1;
    this.info = paramString2;
    this.image = paramBitmap;
    this.url = paramString3;
    this.directlink = paramString4;
    setOnPreferenceClickListener(this);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (this.info.equals(""))
    {
      if (this.image != null) {}
      for (i = R.layout.preference_ad;; i = R.layout.preference_ad2)
      {
        paramViewGroup = paramViewGroup.inflate(i, null);
        ((TextView)paramViewGroup.findViewById(R.id.title)).setText(this.title);
        if (this.image != null) {
          ((ImageView)paramViewGroup.findViewById(R.id.icon)).setImageBitmap(this.image);
        }
        return paramViewGroup;
      }
    }
    if (this.image != null) {}
    for (int i = R.layout.preference_ad3;; i = R.layout.preference_ad4)
    {
      paramViewGroup = paramViewGroup.inflate(i, null);
      ((TextView)paramViewGroup.findViewById(R.id.info)).setText(this.info);
      break;
    }
  }
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    if (this.url.equals("")) {
      return false;
    }
    AdManager.adHandler(getContext(), this.url, this.directlink);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/PreferenceNewApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */