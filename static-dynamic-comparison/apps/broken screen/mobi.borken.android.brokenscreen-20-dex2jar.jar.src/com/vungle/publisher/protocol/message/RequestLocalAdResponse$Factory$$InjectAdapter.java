package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestLocalAdResponse$Factory$$InjectAdapter
  extends cs<RequestLocalAdResponse.Factory>
  implements cp<RequestLocalAdResponse.Factory>, Provider<RequestLocalAdResponse.Factory>
{
  private cs<RequestAdResponse.a> a;
  
  public RequestLocalAdResponse$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestLocalAdResponse$Factory", "members/com.vungle.publisher.protocol.message.RequestLocalAdResponse$Factory", true, RequestLocalAdResponse.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.RequestAdResponse$Factory", RequestLocalAdResponse.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestLocalAdResponse.Factory get()
  {
    RequestLocalAdResponse.Factory localFactory = new RequestLocalAdResponse.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestLocalAdResponse.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestLocalAdResponse$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */