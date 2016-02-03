package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.RequestLocalAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class RequestLocalAdHttpRequest$Factory$$InjectAdapter
  extends cs<RequestLocalAdHttpRequest.Factory>
  implements cp<RequestLocalAdHttpRequest.Factory>, Provider<RequestLocalAdHttpRequest.Factory>
{
  private cs<RequestLocalAd.Factory> a;
  private cs<ProtocolHttpRequest.a> b;
  
  public RequestLocalAdHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Factory", "members/com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Factory", true, RequestLocalAdHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.RequestLocalAd$Factory", RequestLocalAdHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", RequestLocalAdHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestLocalAdHttpRequest.Factory get()
  {
    RequestLocalAdHttpRequest.Factory localFactory = new RequestLocalAdHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestLocalAdHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((RequestLocalAd.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestLocalAdHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */