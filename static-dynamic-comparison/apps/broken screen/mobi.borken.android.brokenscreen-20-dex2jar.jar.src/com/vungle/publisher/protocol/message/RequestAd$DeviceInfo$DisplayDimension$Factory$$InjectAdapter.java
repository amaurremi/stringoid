package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bc;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAd$DeviceInfo$DisplayDimension$Factory$$InjectAdapter
  extends cs<RequestAd.DeviceInfo.DisplayDimension.Factory>
  implements cp<RequestAd.DeviceInfo.DisplayDimension.Factory>, Provider<RequestAd.DeviceInfo.DisplayDimension.Factory>
{
  private cs<bc> a;
  private cs<MessageFactory> b;
  
  public RequestAd$DeviceInfo$DisplayDimension$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAd$DeviceInfo$DisplayDimension$Factory", "members/com.vungle.publisher.protocol.message.RequestAd$DeviceInfo$DisplayDimension$Factory", true, RequestAd.DeviceInfo.DisplayDimension.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.bc", RequestAd.DeviceInfo.DisplayDimension.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.message.MessageFactory", RequestAd.DeviceInfo.DisplayDimension.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAd.DeviceInfo.DisplayDimension.Factory get()
  {
    RequestAd.DeviceInfo.DisplayDimension.Factory localFactory = new RequestAd.DeviceInfo.DisplayDimension.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestAd.DeviceInfo.DisplayDimension.Factory paramFactory)
  {
    paramFactory.a = ((bc)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAd$DeviceInfo$DisplayDimension$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */