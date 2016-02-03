package com.adwhirl.adapters;

import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class EventAdapter
  extends AdWhirlAdapter
{
  public EventAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  public void handle()
  {
    if (Extra2.verboselog) {
      Log.d("AdWhirl SDK", "Event notification request initiated");
    }
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    if (localAdWhirlLayout.adWhirlInterface != null)
    {
      String str = this.ration.key;
      if (str == null)
      {
        if (Extra2.verboselog) {
          Log.w("AdWhirl SDK", "Event key is null");
        }
        localAdWhirlLayout.rollover();
        return;
      }
      int i = str.indexOf("|;|");
      if (i < 0)
      {
        if (Extra2.verboselog) {
          Log.w("AdWhirl SDK", "Event key separator not found");
        }
        localAdWhirlLayout.rollover();
        return;
      }
      str = str.substring(i + 3);
      Class localClass = localAdWhirlLayout.adWhirlInterface.getClass();
      try
      {
        localClass.getMethod(str, null).invoke(localAdWhirlLayout.adWhirlInterface, null);
        return;
      }
      catch (Exception localException)
      {
        if (Extra2.verboselog) {
          Log.e("AdWhirl SDK", "Caught exception in handle()", localException);
        }
        localAdWhirlLayout.rollover();
        return;
      }
    }
    if (Extra2.verboselog) {
      Log.w("AdWhirl SDK", "Event notification would be sent, but no interface is listening");
    }
    localAdWhirlLayout.rollover();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/EventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */