package com.androidwasabi.livewallpaper.xperiaz;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebViewDatabase;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.AdManager.AdItem;
import com.androidwasabi.ads.ImageLoader;
import com.androidwasabi.ads.NewAppManager;
import com.appbrain.d;
import com.appbrain.e;
import com.google.ads.AdRequest;
import com.google.ads.AdView;
import java.util.ArrayList;

public class AppLauncher
  extends Activity
  implements View.OnClickListener
{
  boolean a = false;
  
  private void a()
  {
    e.a(this);
    if (WebViewDatabase.getInstance(this) != null)
    {
      AdView localAdView = (AdView)findViewById(2131296257);
      AdRequest localAdRequest = new AdRequest();
      localAdRequest.addTestDevice("CF4A70D1C5BE6A662EB6FB0D055C871C");
      localAdRequest.addTestDevice("FBE1F6D6AF7F9E4D0CF767DDCA5F8742");
      localAdRequest.addTestDevice("ECFBB1F1A14F7D3E3EC29DA3EE6C4E0A");
      localAdRequest.addTestDevice("7CD2B9DD1AA9996F17E605715828F699");
      localAdRequest.addTestDevice("637F0DF1F2BD166CF052061DE1409340");
      localAdRequest.addTestDevice("35CED9A0A8306835A874A38ADE57B8E1");
      localAdView.loadAd(localAdRequest);
    }
    AdManager.init(this);
    AdManager.setListener(new a(this));
    AdManager.loadAd(50);
    ((LinearLayout)findViewById(2131296263)).setVisibility(8);
  }
  
  private void b()
  {
    NewAppManager.setListener(new b(this));
    NewAppManager.load(this, 100);
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = AdManager.getAdList();
        if (localArrayList != null)
        {
          ImageLoader localImageLoader = AdManager.getImageLoader();
          if (localArrayList.size() == 1)
          {
            i = 1;
            String[] arrayOfString = new String[i];
            int j = 0;
            if (j >= i)
            {
              localImageLoader.saveImageCache(arrayOfString);
              localImageLoader.setCacheListener(new f(this, localArrayList));
              return;
            }
            arrayOfString[j] = ((AdManager.AdItem)localArrayList.get(j)).image;
            j += 1;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException) {}
      int i = 2;
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.a) && (!AdManager.showAdActivity(this)) && (AdManager.hasPlayStore())) {
      e.a().b(this);
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296259: 
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          paramView = new Intent();
          ComponentName localComponentName = new ComponentName(this, XperiaZ.class);
          paramView.setAction("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
          paramView.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", localComponentName);
          startActivity(paramView);
          return;
        }
        catch (ActivityNotFoundException paramView)
        {
          return;
        }
      }
      Toast.makeText(this, 2131099798, 1).show();
      try
      {
        paramView = new Intent();
        paramView.setAction("android.service.wallpaper.LIVE_WALLPAPER_CHOOSER");
        startActivity(paramView);
        return;
      }
      catch (ActivityNotFoundException paramView)
      {
        return;
      }
    case 2131296260: 
      try
      {
        startActivity(new Intent(this, Settings.class));
        return;
      }
      catch (ActivityNotFoundException paramView)
      {
        return;
      }
    case 2131296261: 
      try
      {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=Wasabi")));
        return;
      }
      catch (ActivityNotFoundException paramView)
      {
        return;
      }
    }
    if ((!AdManager.showAdActivity(this)) && (AdManager.hasPlayStore())) {
      e.a().b(this);
    }
    this.a = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(1);
    setContentView(2130903040);
    findViewById(2131296259).setOnClickListener(this);
    findViewById(2131296260).setOnClickListener(this);
    findViewById(2131296261).setOnClickListener(this);
    findViewById(2131296262).setOnClickListener(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/AppLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */