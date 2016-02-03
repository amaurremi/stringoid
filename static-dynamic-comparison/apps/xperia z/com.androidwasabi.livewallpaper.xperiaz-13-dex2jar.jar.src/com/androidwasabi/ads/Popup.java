package com.androidwasabi.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Popup
{
  public static AlertDialog createAdPopup(Activity paramActivity, String paramString, Popup.OnAdPopupListener paramOnAdPopupListener)
  {
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(R.layout.popup_ad, null);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView(localView);
    localBuilder.setCancelable(false).setPositiveButton(paramActivity.getString(R.string.ok_title_label), new Popup.1(paramOnAdPopupListener)).setNegativeButton(paramActivity.getString(R.string.skip_title_label), new Popup.2(paramOnAdPopupListener));
    ((TextView)localView.findViewById(R.id.ad_title)).setText(paramString);
    return localBuilder.create();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/Popup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */