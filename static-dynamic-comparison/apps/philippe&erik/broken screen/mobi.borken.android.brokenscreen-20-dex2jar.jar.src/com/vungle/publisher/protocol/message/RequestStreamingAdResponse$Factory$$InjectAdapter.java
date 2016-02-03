package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestStreamingAdResponse$Factory$$InjectAdapter
  extends cs<RequestStreamingAdResponse.Factory>
  implements cp<RequestStreamingAdResponse.Factory>, Provider<RequestStreamingAdResponse.Factory>
{
  private cs<RequestAdResponse.a> a;
  
  public RequestStreamingAdResponse$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestStreamingAdResponse$Factory", "members/com.vungle.publisher.protocol.message.RequestStreamingAdResponse$Factory", true, RequestStreamingAdResponse.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.RequestAdResponse$Factory", RequestStreamingAdResponse.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestStreamingAdResponse.Factory get()
  {
    RequestStreamingAdResponse.Factory localFactory = new RequestStreamingAdResponse.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestStreamingAdResponse.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestStreamingAdResponse$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */