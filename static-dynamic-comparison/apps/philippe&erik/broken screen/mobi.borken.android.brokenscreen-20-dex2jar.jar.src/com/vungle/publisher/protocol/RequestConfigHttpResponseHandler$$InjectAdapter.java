package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler;
import com.vungle.publisher.protocol.message.RequestConfigResponse.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigHttpResponseHandler$$InjectAdapter
  extends cs<RequestConfigHttpResponseHandler>
  implements cp<RequestConfigHttpResponseHandler>, Provider<RequestConfigHttpResponseHandler>
{
  private cs<RequestConfigResponse.Factory> a;
  private cs<SdkConfig> b;
  private cs<Provider<RequestConfigAsync>> c;
  private cs<InfiniteRetryHttpResponseHandler> d;
  
  public RequestConfigHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigHttpResponseHandler", "members/com.vungle.publisher.protocol.RequestConfigHttpResponseHandler", false, RequestConfigHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.RequestConfigResponse$Factory", RequestConfigHttpResponseHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.env.SdkConfig", RequestConfigHttpResponseHandler.class, getClass().getClassLoader());
    this.c = paramcy.a("javax.inject.Provider<com.vungle.publisher.protocol.RequestConfigAsync>", RequestConfigHttpResponseHandler.class, getClass().getClassLoader());
    this.d = paramcy.a("members/com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler", RequestConfigHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final RequestConfigHttpResponseHandler get()
  {
    RequestConfigHttpResponseHandler localRequestConfigHttpResponseHandler = new RequestConfigHttpResponseHandler();
    injectMembers(localRequestConfigHttpResponseHandler);
    return localRequestConfigHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(RequestConfigHttpResponseHandler paramRequestConfigHttpResponseHandler)
  {
    paramRequestConfigHttpResponseHandler.a = ((RequestConfigResponse.Factory)this.a.get());
    paramRequestConfigHttpResponseHandler.b = ((SdkConfig)this.b.get());
    paramRequestConfigHttpResponseHandler.c = ((Provider)this.c.get());
    this.d.injectMembers(paramRequestConfigHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */