package com.adwhirl.adapters;

import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.AdWhirlInterface;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import java.lang.ref.WeakReference;

public class GenericAdapter
  extends AdWhirlAdapter
{
  public GenericAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  public void handle()
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Generic notification request initiated");
    }
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    if (localAdWhirlLayout.adWhirlInterface != null) {
      localAdWhirlLayout.adWhirlInterface.adWhirlGeneric();
    }
    for (;;)
    {
      localAdWhirlLayout.adWhirlManager.resetRollover();
      localAdWhirlLayout.rotateThreadedDelayed();
      return;
      if (Extra2.verboselog) {
        Log.w("AdWhirl SDK", "Generic notification sent, but no interface is listening");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/GenericAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */