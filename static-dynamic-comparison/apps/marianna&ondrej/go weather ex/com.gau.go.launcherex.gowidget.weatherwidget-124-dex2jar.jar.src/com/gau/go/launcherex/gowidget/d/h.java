package com.gau.go.launcherex.gowidget.d;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.gtp.a.a.b.c;

public class h
{
  private long a = 1200L;
  private SparseArray b = new SparseArray();
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public boolean a(int paramInt)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = ((Long)this.b.get(paramInt, Long.valueOf(0L))).longValue();
    boolean bool;
    if ((l2 != 0L) && (l1 - l2 < this.a))
    {
      bool = true;
      c.a("QuickClickGuard", "clickObjectId[" + paramInt + "]" + " is isQuickClick!");
    }
    for (;;)
    {
      this.b.put(paramInt, Long.valueOf(l1));
      return bool;
      bool = false;
    }
  }
  
  public boolean a(View paramView)
  {
    return a(paramView.getId());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */