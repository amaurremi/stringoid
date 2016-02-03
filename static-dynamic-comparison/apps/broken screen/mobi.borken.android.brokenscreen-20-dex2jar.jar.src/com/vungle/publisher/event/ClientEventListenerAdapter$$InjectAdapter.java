package com.vungle.publisher.event;

import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.bh;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ClientEventListenerAdapter$$InjectAdapter
  extends cs<ClientEventListenerAdapter>
  implements cp<ClientEventListenerAdapter>, Provider<ClientEventListenerAdapter>
{
  private cs<ScheduledPriorityExecutor> a;
  private cs<bh> b;
  
  public ClientEventListenerAdapter$$InjectAdapter()
  {
    super("com.vungle.publisher.event.ClientEventListenerAdapter", "members/com.vungle.publisher.event.ClientEventListenerAdapter", false, ClientEventListenerAdapter.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.async.ScheduledPriorityExecutor", ClientEventListenerAdapter.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.event.BaseEventListener", ClientEventListenerAdapter.class, getClass().getClassLoader(), false);
  }
  
  public final ClientEventListenerAdapter get()
  {
    ClientEventListenerAdapter localClientEventListenerAdapter = new ClientEventListenerAdapter();
    injectMembers(localClientEventListenerAdapter);
    return localClientEventListenerAdapter;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ClientEventListenerAdapter paramClientEventListenerAdapter)
  {
    paramClientEventListenerAdapter.b = ((ScheduledPriorityExecutor)this.a.get());
    this.b.injectMembers(paramClientEventListenerAdapter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/event/ClientEventListenerAdapter$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */