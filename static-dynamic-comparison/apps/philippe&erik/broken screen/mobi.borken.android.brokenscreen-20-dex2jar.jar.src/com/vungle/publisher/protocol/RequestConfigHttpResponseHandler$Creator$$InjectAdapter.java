package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigHttpResponseHandler$Creator$$InjectAdapter
  extends cs<RequestConfigHttpResponseHandler.Creator>
  implements cp<RequestConfigHttpResponseHandler.Creator>, Provider<RequestConfigHttpResponseHandler.Creator>
{
  private cs<Provider<RequestConfigHttpResponseHandler>> a;
  
  public RequestConfigHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.RequestConfigHttpResponseHandler$Creator", true, RequestConfigHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.protocol.RequestConfigHttpResponseHandler>", RequestConfigHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final RequestConfigHttpResponseHandler.Creator get()
  {
    RequestConfigHttpResponseHandler.Creator localCreator = new RequestConfigHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestConfigHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */