package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestLocalAdHttpRequest$Creator$$InjectAdapter
  extends cs<RequestLocalAdHttpRequest.Creator>
  implements cp<RequestLocalAdHttpRequest.Creator>, Provider<RequestLocalAdHttpRequest.Creator>
{
  private cs<RequestLocalAdHttpRequest.Factory> a;
  
  public RequestLocalAdHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Creator", true, RequestLocalAdHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.RequestLocalAdHttpRequest$Factory", RequestLocalAdHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final RequestLocalAdHttpRequest.Creator get()
  {
    RequestLocalAdHttpRequest.Creator localCreator = new RequestLocalAdHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestLocalAdHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((RequestLocalAdHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestLocalAdHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */