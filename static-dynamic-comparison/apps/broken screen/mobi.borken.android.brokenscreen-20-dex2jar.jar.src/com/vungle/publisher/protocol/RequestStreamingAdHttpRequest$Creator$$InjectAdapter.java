package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestStreamingAdHttpRequest$Creator$$InjectAdapter
  extends cs<RequestStreamingAdHttpRequest.Creator>
  implements cp<RequestStreamingAdHttpRequest.Creator>, Provider<RequestStreamingAdHttpRequest.Creator>
{
  private cs<RequestStreamingAdHttpRequest.Factory> a;
  
  public RequestStreamingAdHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Creator", true, RequestStreamingAdHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Factory", RequestStreamingAdHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final RequestStreamingAdHttpRequest.Creator get()
  {
    RequestStreamingAdHttpRequest.Creator localCreator = new RequestStreamingAdHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestStreamingAdHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((RequestStreamingAdHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */