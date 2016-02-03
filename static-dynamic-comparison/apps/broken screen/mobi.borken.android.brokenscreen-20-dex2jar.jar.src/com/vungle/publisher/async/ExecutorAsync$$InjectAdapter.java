package com.vungle.publisher.async;

import com.vungle.publisher.ao;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;

public final class ExecutorAsync$$InjectAdapter
  extends cs<ao>
  implements cp<ao>
{
  private cs<ScheduledPriorityExecutor> a;
  
  public ExecutorAsync$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.async.ExecutorAsync", false, ao.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.async.ScheduledPriorityExecutor", ao.class, getClass().getClassLoader());
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ao paramao)
  {
    paramao.a = ((ScheduledPriorityExecutor)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/async/ExecutorAsync$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */