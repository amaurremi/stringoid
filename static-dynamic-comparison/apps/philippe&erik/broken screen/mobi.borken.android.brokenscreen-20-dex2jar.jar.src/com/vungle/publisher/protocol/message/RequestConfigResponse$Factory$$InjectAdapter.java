package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigResponse$Factory$$InjectAdapter
  extends cs<RequestConfigResponse.Factory>
  implements cp<RequestConfigResponse.Factory>, Provider<RequestConfigResponse.Factory>
{
  private cs<JsonDeserializationFactory> a;
  
  public RequestConfigResponse$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestConfigResponse$Factory", "members/com.vungle.publisher.protocol.message.RequestConfigResponse$Factory", true, RequestConfigResponse.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.JsonDeserializationFactory", RequestConfigResponse.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestConfigResponse.Factory get()
  {
    RequestConfigResponse.Factory localFactory = new RequestConfigResponse.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestConfigResponse.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestConfigResponse$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */