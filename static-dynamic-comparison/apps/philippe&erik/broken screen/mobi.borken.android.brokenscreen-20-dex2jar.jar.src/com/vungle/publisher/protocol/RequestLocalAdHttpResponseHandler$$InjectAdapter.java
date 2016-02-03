package com.vungle.publisher.protocol;

import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.ad.AdPreparer;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse.Factory;
import com.vungle.publisher.reporting.AdServiceReportingHandler;
import java.util.Set;
import javax.inject.Provider;

public final class RequestLocalAdHttpResponseHandler$$InjectAdapter
  extends cs<RequestLocalAdHttpResponseHandler>
  implements cp<RequestLocalAdHttpResponseHandler>, Provider<RequestLocalAdHttpResponseHandler>
{
  private cs<AdManager> a;
  private cs<AdPreparer> b;
  private cs<SdkState> c;
  private cs<di> d;
  private cs<RequestLocalAdResponse.Factory> e;
  private cs<AdServiceReportingHandler> f;
  private cs<InfiniteRetryHttpResponseHandler> g;
  
  public RequestLocalAdHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler", "members/com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler", true, RequestLocalAdHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdManager", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.ad.AdPreparer", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.env.SdkState", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.di", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.protocol.message.RequestLocalAdResponse$Factory", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader());
    this.f = paramcy.a("com.vungle.publisher.reporting.AdServiceReportingHandler", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader());
    this.g = paramcy.a("members/com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler", RequestLocalAdHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final RequestLocalAdHttpResponseHandler get()
  {
    RequestLocalAdHttpResponseHandler localRequestLocalAdHttpResponseHandler = new RequestLocalAdHttpResponseHandler();
    injectMembers(localRequestLocalAdHttpResponseHandler);
    return localRequestLocalAdHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
    paramSet2.add(this.f);
    paramSet2.add(this.g);
  }
  
  public final void injectMembers(RequestLocalAdHttpResponseHandler paramRequestLocalAdHttpResponseHandler)
  {
    paramRequestLocalAdHttpResponseHandler.a = ((AdManager)this.a.get());
    paramRequestLocalAdHttpResponseHandler.b = ((AdPreparer)this.b.get());
    paramRequestLocalAdHttpResponseHandler.c = ((SdkState)this.c.get());
    paramRequestLocalAdHttpResponseHandler.d = ((di)this.d.get());
    paramRequestLocalAdHttpResponseHandler.e = ((RequestLocalAdResponse.Factory)this.e.get());
    paramRequestLocalAdHttpResponseHandler.i = ((AdServiceReportingHandler)this.f.get());
    this.g.injectMembers(paramRequestLocalAdHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestLocalAdHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */