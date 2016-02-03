package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.RequestConfig;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigHttpRequest$Factory$$InjectAdapter
  extends cs<RequestConfigHttpRequest.Factory>
  implements cp<RequestConfigHttpRequest.Factory>, Provider<RequestConfigHttpRequest.Factory>
{
  private cs<RequestConfigHttpRequest> a;
  private cs<RequestConfig> b;
  private cs<ProtocolHttpRequest.a> c;
  
  public RequestConfigHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigHttpRequest$Factory", "members/com.vungle.publisher.protocol.RequestConfigHttpRequest$Factory", true, RequestConfigHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.RequestConfigHttpRequest", RequestConfigHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestConfig", RequestConfigHttpRequest.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", RequestConfigHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestConfigHttpRequest.Factory get()
  {
    RequestConfigHttpRequest.Factory localFactory = new RequestConfigHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(RequestConfigHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((RequestConfigHttpRequest)this.a.get());
    paramFactory.g = ((RequestConfig)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */