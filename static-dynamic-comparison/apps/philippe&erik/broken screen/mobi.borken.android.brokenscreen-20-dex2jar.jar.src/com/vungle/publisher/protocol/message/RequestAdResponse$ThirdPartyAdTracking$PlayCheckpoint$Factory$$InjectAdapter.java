package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAdResponse$ThirdPartyAdTracking$PlayCheckpoint$Factory$$InjectAdapter
  extends cs<RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory>
  implements cp<RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory>, Provider<RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory>
{
  private cs<JsonDeserializationFactory> a;
  
  public RequestAdResponse$ThirdPartyAdTracking$PlayCheckpoint$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAdResponse$ThirdPartyAdTracking$PlayCheckpoint$Factory", "members/com.vungle.publisher.protocol.message.RequestAdResponse$ThirdPartyAdTracking$PlayCheckpoint$Factory", true, RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.JsonDeserializationFactory", RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory get()
  {
    RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory localFactory = new RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAdResponse$ThirdPartyAdTracking$PlayCheckpoint$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */