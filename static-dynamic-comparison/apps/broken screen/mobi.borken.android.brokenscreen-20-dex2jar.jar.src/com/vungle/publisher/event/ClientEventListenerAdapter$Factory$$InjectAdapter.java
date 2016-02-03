package com.vungle.publisher.event;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ClientEventListenerAdapter$Factory$$InjectAdapter
  extends cs<ClientEventListenerAdapter.Factory>
  implements cp<ClientEventListenerAdapter.Factory>, Provider<ClientEventListenerAdapter.Factory>
{
  private cs<Provider<ClientEventListenerAdapter>> a;
  
  public ClientEventListenerAdapter$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.event.ClientEventListenerAdapter$Factory", "members/com.vungle.publisher.event.ClientEventListenerAdapter$Factory", true, ClientEventListenerAdapter.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.event.ClientEventListenerAdapter>", ClientEventListenerAdapter.Factory.class, getClass().getClassLoader());
  }
  
  public final ClientEventListenerAdapter.Factory get()
  {
    ClientEventListenerAdapter.Factory localFactory = new ClientEventListenerAdapter.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ClientEventListenerAdapter.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/event/ClientEventListenerAdapter$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */