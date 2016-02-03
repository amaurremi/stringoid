package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigAsync$RequestConfigRunnable$$InjectAdapter
  extends cs<RequestConfigAsync.RequestConfigRunnable>
  implements cp<RequestConfigAsync.RequestConfigRunnable>, Provider<RequestConfigAsync.RequestConfigRunnable>
{
  private cs<ProtocolHttpGateway> a;
  
  public RequestConfigAsync$RequestConfigRunnable$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigAsync$RequestConfigRunnable", "members/com.vungle.publisher.protocol.RequestConfigAsync$RequestConfigRunnable", true, RequestConfigAsync.RequestConfigRunnable.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway", RequestConfigAsync.RequestConfigRunnable.class, getClass().getClassLoader());
  }
  
  public final RequestConfigAsync.RequestConfigRunnable get()
  {
    RequestConfigAsync.RequestConfigRunnable localRequestConfigRunnable = new RequestConfigAsync.RequestConfigRunnable();
    injectMembers(localRequestConfigRunnable);
    return localRequestConfigRunnable;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestConfigAsync.RequestConfigRunnable paramRequestConfigRunnable)
  {
    paramRequestConfigRunnable.a = ((ProtocolHttpGateway)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigAsync$RequestConfigRunnable$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */