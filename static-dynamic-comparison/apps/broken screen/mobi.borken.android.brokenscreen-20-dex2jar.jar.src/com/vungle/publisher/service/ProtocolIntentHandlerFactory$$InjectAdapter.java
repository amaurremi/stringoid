package com.vungle.publisher.service;

import com.vungle.publisher.cd.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ProtocolIntentHandlerFactory$$InjectAdapter
  extends cs<ProtocolIntentHandlerFactory>
  implements cp<ProtocolIntentHandlerFactory>, Provider<ProtocolIntentHandlerFactory>
{
  private cs<cd.a> a;
  
  public ProtocolIntentHandlerFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.service.ProtocolIntentHandlerFactory", "members/com.vungle.publisher.service.ProtocolIntentHandlerFactory", true, ProtocolIntentHandlerFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.service.HttpRequestExecutorIntentHandler$Factory", ProtocolIntentHandlerFactory.class, getClass().getClassLoader(), false);
  }
  
  public final ProtocolIntentHandlerFactory get()
  {
    ProtocolIntentHandlerFactory localProtocolIntentHandlerFactory = new ProtocolIntentHandlerFactory();
    injectMembers(localProtocolIntentHandlerFactory);
    return localProtocolIntentHandlerFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ProtocolIntentHandlerFactory paramProtocolIntentHandlerFactory)
  {
    this.a.injectMembers(paramProtocolIntentHandlerFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/ProtocolIntentHandlerFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */