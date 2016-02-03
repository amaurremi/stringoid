package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.RequestStreamingAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class RequestStreamingAdHttpRequest$Factory$$InjectAdapter
  extends cs<RequestStreamingAdHttpRequest.Factory>
  implements cp<RequestStreamingAdHttpRequest.Factory>, Provider<RequestStreamingAdHttpRequest.Factory>
{
  private cs<RequestStreamingAd.Factory> a;
  private cs<ProtocolHttpRequest.a> b;
  
  public RequestStreamingAdHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Factory", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Factory", true, RequestStreamingAdHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.RequestStreamingAd$Factory", RequestStreamingAdHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", RequestStreamingAdHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestStreamingAdHttpRequest.Factory get()
  {
    RequestStreamingAdHttpRequest.Factory localFactory = new RequestStreamingAdHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestStreamingAdHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((RequestStreamingAd.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */