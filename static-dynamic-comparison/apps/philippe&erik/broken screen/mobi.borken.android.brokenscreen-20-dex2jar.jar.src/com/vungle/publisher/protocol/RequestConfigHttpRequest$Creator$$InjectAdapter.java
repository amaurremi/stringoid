package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigHttpRequest$Creator$$InjectAdapter
  extends cs<RequestConfigHttpRequest.Creator>
  implements cp<RequestConfigHttpRequest.Creator>, Provider<RequestConfigHttpRequest.Creator>
{
  private cs<RequestConfigHttpRequest.Factory> a;
  
  public RequestConfigHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigHttpRequest$Creator", "members/com.vungle.publisher.protocol.RequestConfigHttpRequest$Creator", true, RequestConfigHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.RequestConfigHttpRequest$Factory", RequestConfigHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final RequestConfigHttpRequest.Creator get()
  {
    RequestConfigHttpRequest.Creator localCreator = new RequestConfigHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestConfigHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((RequestConfigHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */