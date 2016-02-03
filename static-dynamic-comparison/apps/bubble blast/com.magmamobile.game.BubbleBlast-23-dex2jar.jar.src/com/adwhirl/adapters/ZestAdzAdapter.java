package com.adwhirl.adapters;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.ViewAdRunnable;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.zestadz.android.AdManager;
import com.zestadz.android.ZestADZAdView;
import com.zestadz.android.ZestADZAdView.ZestADZListener;
import java.lang.ref.WeakReference;

public class ZestAdzAdapter
  extends AdWhirlAdapter
  implements ZestADZAdView.ZestADZListener
{
  public ZestAdzAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  public void AdFailed(ZestADZAdView paramZestADZAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "ZestADZ failure");
    }
    paramZestADZAdView.setListener(null);
    paramZestADZAdView = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (paramZestADZAdView == null) {
      return;
    }
    paramZestADZAdView.rollover();
  }
  
  public void AdReturned(ZestADZAdView paramZestADZAdView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "ZestADZ success");
    }
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    localAdWhirlLayout.adWhirlManager.resetRollover();
    localAdWhirlLayout.handler.post(new AdWhirlLayout.ViewAdRunnable(localAdWhirlLayout, paramZestADZAdView));
    localAdWhirlLayout.rotateThreadedDelayed();
  }
  
  public void handle()
  {
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {}
    for (;;)
    {
      return;
      try
      {
        AdManager.setadclientId(this.ration.key);
        try
        {
          Object localObject = (Activity)localAdWhirlLayout.activityReference.get();
          if (localObject == null) {
            continue;
          }
          localObject = new ZestADZAdView((Activity)localObject);
          ((ZestADZAdView)localObject).setListener(this);
          ((ZestADZAdView)localObject).displayAd();
          return;
        }
        catch (Exception localException)
        {
          localAdWhirlLayout.rollover();
          return;
        }
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localAdWhirlLayout.rollover();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/ZestAdzAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */