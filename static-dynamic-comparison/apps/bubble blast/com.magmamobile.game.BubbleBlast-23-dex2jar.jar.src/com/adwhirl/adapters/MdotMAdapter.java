package com.adwhirl.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.ViewAdRunnable;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.mdotm.android.ads.MdotMManager;
import com.mdotm.android.ads.MdotMView;
import com.mdotm.android.ads.MdotMView.MdotMActionListener;
import java.lang.ref.WeakReference;

public class MdotMAdapter
  extends AdWhirlAdapter
  implements MdotMView.MdotMActionListener
{
  public MdotMAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  public void adRequestCompletedSuccessfully(MdotMView paramMdotMView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "MdotM success");
    }
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    paramMdotMView.setListener(null);
    paramMdotMView.setVisibility(0);
    localAdWhirlLayout.adWhirlManager.resetRollover();
    localAdWhirlLayout.handler.post(new AdWhirlLayout.ViewAdRunnable(localAdWhirlLayout, paramMdotMView));
    localAdWhirlLayout.rotateThreadedDelayed();
  }
  
  public void adRequestFailed(MdotMView paramMdotMView)
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "MdotM failure");
    }
    paramMdotMView.setListener(null);
    paramMdotMView = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (paramMdotMView == null) {
      return;
    }
    paramMdotMView.rollover();
  }
  
  public void handle()
  {
    Object localObject1 = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      try
      {
        MdotMManager.setPublisherId(this.ration.key);
        MdotMManager.setMediationLayerName("AdWhirl SDK");
        MdotMManager.setMediationLayerVersion(300);
        Object localObject2 = (Activity)((AdWhirlLayout)localObject1).activityReference.get();
        if (localObject2 != null)
        {
          localObject2 = new MdotMView((Context)localObject2, this);
          ((MdotMView)localObject2).setListener(this);
          localObject1 = ((AdWhirlLayout)localObject1).extra;
          int i = Color.rgb(((Extra)localObject1).bgRed, ((Extra)localObject1).bgGreen, ((Extra)localObject1).bgBlue);
          int j = Color.rgb(((Extra)localObject1).fgRed, ((Extra)localObject1).fgGreen, ((Extra)localObject1).fgBlue);
          ((MdotMView)localObject2).setBackgroundColor(i);
          ((MdotMView)localObject2).setTextColor(j);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ((AdWhirlLayout)localObject1).rollover();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/MdotMAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */