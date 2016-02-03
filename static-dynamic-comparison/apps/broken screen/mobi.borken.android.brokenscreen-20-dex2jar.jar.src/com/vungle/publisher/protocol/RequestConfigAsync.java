package com.vungle.publisher.protocol;

import com.vungle.publisher.ao;
import com.vungle.publisher.async.ScheduledPriorityExecutor.b;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RequestConfigAsync
  extends ao
{
  @Inject
  RequestConfigRunnable b;
  
  protected final Runnable a()
  {
    return this.b;
  }
  
  protected final ScheduledPriorityExecutor.b b()
  {
    return ScheduledPriorityExecutor.b.c;
  }
  
  @Singleton
  static class RequestConfigRunnable
    implements Runnable
  {
    @Inject
    ProtocolHttpGateway a;
    
    public void run()
    {
      this.a.c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigAsync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */