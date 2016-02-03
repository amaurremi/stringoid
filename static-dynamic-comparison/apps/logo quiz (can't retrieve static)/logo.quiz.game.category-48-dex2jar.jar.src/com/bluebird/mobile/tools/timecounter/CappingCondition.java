package com.bluebird.mobile.tools.timecounter;

import android.content.Context;
import android.util.Log;
import com.bluebird.mobile.tools.capping.CappingEvent;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class CappingCondition
  implements FireEventCondition, Observer
{
  private CappingEvent cappingEvent;
  private WeakReference<Context> contextWeakReference;
  
  public CappingCondition(CappingEvent paramCappingEvent, Context paramContext)
  {
    this.cappingEvent = paramCappingEvent;
    this.contextWeakReference = new WeakReference(paramContext);
  }
  
  public boolean canBeFired()
  {
    Context localContext = (Context)this.contextWeakReference.get();
    if ((localContext != null) && (this.cappingEvent.canBeUsed(localContext))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("BTC", "Capping condition - can be fired: " + bool);
      return bool;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Context)this.contextWeakReference.get();
    if (paramObservable != null)
    {
      Log.d("BTC", "Capping condition - notified");
      this.cappingEvent.useInAsync(paramObservable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/timecounter/CappingCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */