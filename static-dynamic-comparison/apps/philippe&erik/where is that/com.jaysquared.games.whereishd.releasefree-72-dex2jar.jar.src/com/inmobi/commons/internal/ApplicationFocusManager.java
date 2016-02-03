package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationFocusManager
{
  protected static final int MSG_PAUSED = 1001;
  protected static final int MSG_RESUMED = 1002;
  private static List<FocusChangedListener> a = new ArrayList();
  private static Object b;
  private static HandlerThread c = null;
  private static Application d;
  
  public static void addFocusChangedListener(FocusChangedListener paramFocusChangedListener)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return;
      a.add(paramFocusChangedListener);
    } while (a.size() != 1);
    b();
  }
  
  @TargetApi(14)
  private static void b()
  {
    c = new HandlerThread("InMobiAFM");
    c.start();
    b = new b();
    if (b != null) {
      d.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)b);
    }
  }
  
  private static void b(Boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((FocusChangedListener)localIterator.next()).onFocusChanged(paramBoolean.booleanValue());
    }
  }
  
  @TargetApi(14)
  private static void c()
  {
    if (b != null) {
      d.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)b);
    }
    c.stop();
    c = null;
  }
  
  @SuppressLint({"NewApi"})
  public static void init(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (d == null)) {
      d = paramActivity.getApplication();
    }
  }
  
  public static void removeFocusChangedListener(FocusChangedListener paramFocusChangedListener)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return;
      a.remove(paramFocusChangedListener);
    } while (a.size() != 0);
    c();
  }
  
  public static abstract interface FocusChangedListener
  {
    public abstract void onFocusChanged(boolean paramBoolean);
  }
  
  static class a
    extends Handler
  {
    private boolean a = true;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 1001) && (this.a))
      {
        this.a = false;
        ApplicationFocusManager.a(Boolean.valueOf(this.a));
      }
      while ((paramMessage.what != 1002) || (this.a)) {
        return;
      }
      this.a = true;
      ApplicationFocusManager.a(Boolean.valueOf(this.a));
    }
  }
  
  static final class b
    implements Application.ActivityLifecycleCallbacks
  {
    private final Handler a = new ApplicationFocusManager.a(ApplicationFocusManager.a().getLooper());
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity)
    {
      this.a.sendEmptyMessageDelayed(1001, 3000L);
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      this.a.removeMessages(1001);
      this.a.sendEmptyMessage(1002);
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/ApplicationFocusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */