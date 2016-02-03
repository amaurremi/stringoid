package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigHttpRequest$$InjectAdapter
  extends cs<RequestConfigHttpRequest>
  implements cp<RequestConfigHttpRequest>, Provider<RequestConfigHttpRequest>
{
  private cs<ProtocolHttpRequest> a;
  
  public RequestConfigHttpRequest$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigHttpRequest", "members/com.vungle.publisher.protocol.RequestConfigHttpRequest", true, RequestConfigHttpRequest.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest", RequestConfigHttpRequest.class, getClass().getClassLoader(), false);
  }
  
  public final RequestConfigHttpRequest get()
  {
    RequestConfigHttpRequest localRequestConfigHttpRequest = new RequestConfigHttpRequest();
    injectMembers(localRequestConfigHttpRequest);
    return localRequestConfigHttpRequest;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestConfigHttpRequest paramRequestConfigHttpRequest)
  {
    this.a.injectMembers(paramRequestConfigHttpRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpRequest$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */