package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;

public final class RequestAdResponse$Factory$$InjectAdapter
  extends cs<RequestAdResponse.a>
  implements cp<RequestAdResponse.a>
{
  private cs<RequestAdResponse.CallToActionOverlay.Factory> a;
  private cs<RequestAdResponse.ThirdPartyAdTracking.Factory> b;
  private cs<JsonDeserializationFactory> c;
  
  public RequestAdResponse$Factory$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.protocol.message.RequestAdResponse$Factory", false, RequestAdResponse.a.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.RequestAdResponse$CallToActionOverlay$Factory", RequestAdResponse.a.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestAdResponse$ThirdPartyAdTracking$Factory", RequestAdResponse.a.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.message.JsonDeserializationFactory", RequestAdResponse.a.class, getClass().getClassLoader(), false);
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(RequestAdResponse.a parama)
  {
    parama.a = ((RequestAdResponse.CallToActionOverlay.Factory)this.a.get());
    parama.b = ((RequestAdResponse.ThirdPartyAdTracking.Factory)this.b.get());
    this.c.injectMembers(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAdResponse$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */