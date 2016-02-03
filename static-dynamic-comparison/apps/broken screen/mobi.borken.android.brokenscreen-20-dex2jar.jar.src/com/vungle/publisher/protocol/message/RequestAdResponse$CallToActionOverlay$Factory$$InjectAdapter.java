package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAdResponse$CallToActionOverlay$Factory$$InjectAdapter
  extends cs<RequestAdResponse.CallToActionOverlay.Factory>
  implements cp<RequestAdResponse.CallToActionOverlay.Factory>, Provider<RequestAdResponse.CallToActionOverlay.Factory>
{
  private cs<JsonDeserializationFactory> a;
  
  public RequestAdResponse$CallToActionOverlay$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAdResponse$CallToActionOverlay$Factory", "members/com.vungle.publisher.protocol.message.RequestAdResponse$CallToActionOverlay$Factory", true, RequestAdResponse.CallToActionOverlay.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.JsonDeserializationFactory", RequestAdResponse.CallToActionOverlay.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAdResponse.CallToActionOverlay.Factory get()
  {
    RequestAdResponse.CallToActionOverlay.Factory localFactory = new RequestAdResponse.CallToActionOverlay.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestAdResponse.CallToActionOverlay.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAdResponse$CallToActionOverlay$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */