package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAdResponse$ThirdPartyAdTracking$Factory$$InjectAdapter
  extends cs<RequestAdResponse.ThirdPartyAdTracking.Factory>
  implements cp<RequestAdResponse.ThirdPartyAdTracking.Factory>, Provider<RequestAdResponse.ThirdPartyAdTracking.Factory>
{
  private cs<RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory> a;
  private cs<JsonDeserializationFactory> b;
  
  public RequestAdResponse$ThirdPartyAdTracking$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAdResponse$ThirdPartyAdTracking$Factory", "members/com.vungle.publisher.protocol.message.RequestAdResponse$ThirdPartyAdTracking$Factory", true, RequestAdResponse.ThirdPartyAdTracking.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.RequestAdResponse$ThirdPartyAdTracking$PlayCheckpoint$Factory", RequestAdResponse.ThirdPartyAdTracking.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.message.JsonDeserializationFactory", RequestAdResponse.ThirdPartyAdTracking.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAdResponse.ThirdPartyAdTracking.Factory get()
  {
    RequestAdResponse.ThirdPartyAdTracking.Factory localFactory = new RequestAdResponse.ThirdPartyAdTracking.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestAdResponse.ThirdPartyAdTracking.Factory paramFactory)
  {
    paramFactory.a = ((RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAdResponse$ThirdPartyAdTracking$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */