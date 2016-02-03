package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.b;
import com.google.ads.util.i.d;

public class AdActivity$StaticMethodWrapper
{
  public boolean isShowing()
  {
    for (;;)
    {
      synchronized ()
      {
        if (AdActivity.b() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void launchAdActivity(d paramd, e parame)
  {
    synchronized ()
    {
      if (AdActivity.d() == null) {
        AdActivity.b(paramd);
      }
      while (AdActivity.d() == paramd)
      {
        paramd = (Activity)paramd.i().c.a();
        if (paramd != null) {
          break;
        }
        b.e("activity was null while launching an AdActivity.");
        return;
      }
      b.b("Tried to launch a new AdActivity with a different AdManager.");
      return;
    }
    ??? = new Intent(paramd.getApplicationContext(), AdActivity.class);
    ((Intent)???).putExtra("com.google.ads.AdOpener", parame.a());
    try
    {
      b.a("Launching AdActivity.");
      paramd.startActivity((Intent)???);
      return;
    }
    catch (ActivityNotFoundException paramd)
    {
      b.b("Activity not found.", paramd);
    }
  }
  
  public boolean leftApplication()
  {
    for (;;)
    {
      synchronized ()
      {
        if (AdActivity.c() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/AdActivity$StaticMethodWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */