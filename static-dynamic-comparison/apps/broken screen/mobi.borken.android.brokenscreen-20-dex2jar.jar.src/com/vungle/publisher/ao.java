package com.vungle.publisher;

import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.async.ScheduledPriorityExecutor.a;
import com.vungle.publisher.async.ScheduledPriorityExecutor.b;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;

public abstract class ao
{
  @Inject
  public ScheduledPriorityExecutor a;
  
  public abstract Runnable a();
  
  public final void a(long paramLong)
  {
    ScheduledPriorityExecutor localScheduledPriorityExecutor = this.a;
    Runnable localRunnable = a();
    ScheduledPriorityExecutor.b localb = b();
    Logger.d("VungleAsync", "scheduling " + localb + " delayed " + paramLong + " ms");
    localScheduledPriorityExecutor.a.sendMessageDelayed(localScheduledPriorityExecutor.b(localRunnable, localb), paramLong);
  }
  
  public ScheduledPriorityExecutor.b b()
  {
    return ScheduledPriorityExecutor.b.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */