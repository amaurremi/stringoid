package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestLocalAdHttpResponseHandler$Creator$$InjectAdapter
  extends cs<RequestLocalAdHttpResponseHandler.Creator>
  implements cp<RequestLocalAdHttpResponseHandler.Creator>, Provider<RequestLocalAdHttpResponseHandler.Creator>
{
  private cs<Provider<RequestLocalAdHttpResponseHandler>> a;
  
  public RequestLocalAdHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler$Creator", true, RequestLocalAdHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.protocol.RequestLocalAdHttpResponseHandler>", RequestLocalAdHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final RequestLocalAdHttpResponseHandler.Creator get()
  {
    RequestLocalAdHttpResponseHandler.Creator localCreator = new RequestLocalAdHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestLocalAdHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestLocalAdHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */