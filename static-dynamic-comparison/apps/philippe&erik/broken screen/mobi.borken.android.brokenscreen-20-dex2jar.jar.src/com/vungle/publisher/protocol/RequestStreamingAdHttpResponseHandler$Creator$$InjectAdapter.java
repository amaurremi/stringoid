package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestStreamingAdHttpResponseHandler$Creator$$InjectAdapter
  extends cs<RequestStreamingAdHttpResponseHandler.Creator>
  implements cp<RequestStreamingAdHttpResponseHandler.Creator>, Provider<RequestStreamingAdHttpResponseHandler.Creator>
{
  private cs<Provider<RequestStreamingAdHttpResponseHandler>> a;
  
  public RequestStreamingAdHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler$Creator", true, RequestStreamingAdHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler>", RequestStreamingAdHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final RequestStreamingAdHttpResponseHandler.Creator get()
  {
    RequestStreamingAdHttpResponseHandler.Creator localCreator = new RequestStreamingAdHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestStreamingAdHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */