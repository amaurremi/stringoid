package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import com.vungle.publisher.net.http.MaxRetryAgeHttpResponseHandler;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class RequestStreamingAdHttpResponseHandler$$InjectAdapter
  extends cs<RequestStreamingAdHttpResponseHandler>
  implements cp<RequestStreamingAdHttpResponseHandler>, Provider<RequestStreamingAdHttpResponseHandler>
{
  private cs<di> a;
  private cs<RequestStreamingAdResponse.Factory> b;
  private cs<MaxRetryAgeHttpResponseHandler> c;
  
  public RequestStreamingAdHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler", true, RequestStreamingAdHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.di", RequestStreamingAdHttpResponseHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestStreamingAdResponse$Factory", RequestStreamingAdHttpResponseHandler.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.net.http.MaxRetryAgeHttpResponseHandler", RequestStreamingAdHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final RequestStreamingAdHttpResponseHandler get()
  {
    RequestStreamingAdHttpResponseHandler localRequestStreamingAdHttpResponseHandler = new RequestStreamingAdHttpResponseHandler();
    injectMembers(localRequestStreamingAdHttpResponseHandler);
    return localRequestStreamingAdHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(RequestStreamingAdHttpResponseHandler paramRequestStreamingAdHttpResponseHandler)
  {
    paramRequestStreamingAdHttpResponseHandler.a = ((di)this.a.get());
    paramRequestStreamingAdHttpResponseHandler.b = ((RequestStreamingAdResponse.Factory)this.b.get());
    this.c.injectMembers(paramRequestStreamingAdHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */