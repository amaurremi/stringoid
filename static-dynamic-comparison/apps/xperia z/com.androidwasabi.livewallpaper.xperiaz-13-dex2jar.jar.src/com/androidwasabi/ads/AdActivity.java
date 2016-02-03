package com.androidwasabi.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

public class AdActivity
  extends Activity
{
  public static final String TAG = "AdActivity";
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(1);
    setContentView(R.layout.wall_activity);
    paramBundle = (TextView)findViewById(R.id.title);
    if (new Random().nextInt(2) == 0) {}
    for (int i = R.string.app_wall2_title_label;; i = R.string.app_wall3_title_label)
    {
      paramBundle.setText(i);
      ((ImageButton)findViewById(R.id.close_btn)).setOnClickListener(new AdActivity.1(this));
      AdManager.init(this);
      AdManager.setListener(new AdActivity.2(this));
      AdManager.loadAdList();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */