package com.venticake.retrica.view.album;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity
  extends Activity
{
  private final ArrayList<MonitoredActivity.LifeCycleListener> mListeners = new ArrayList();
  
  public void addLifeCycleListener(MonitoredActivity.LifeCycleListener paramLifeCycleListener)
  {
    if (this.mListeners.contains(paramLifeCycleListener)) {
      return;
    }
    this.mListeners.add(paramLifeCycleListener);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.mListeners.iterator();
    for (;;)
    {
      if (!paramBundle.hasNext()) {
        return;
      }
      ((MonitoredActivity.LifeCycleListener)paramBundle.next()).onActivityCreated(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).onActivityDestroyed(this);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).onActivityStarted(this);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((MonitoredActivity.LifeCycleListener)localIterator.next()).onActivityStopped(this);
    }
  }
  
  public void removeLifeCycleListener(MonitoredActivity.LifeCycleListener paramLifeCycleListener)
  {
    this.mListeners.remove(paramLifeCycleListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MonitoredActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */