package com.vungle.publisher.protocol.message;

import com.vungle.publisher.AdConfig;
import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import com.vungle.publisher.br;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAd$DeviceInfo$Factory$$InjectAdapter
  extends cs<RequestAd.DeviceInfo.Factory>
  implements cp<RequestAd.DeviceInfo.Factory>, Provider<RequestAd.DeviceInfo.Factory>
{
  private cs<AdConfig> a;
  private cs<bc> b;
  private cs<RequestAd.DeviceInfo.DisplayDimension.Factory> c;
  private cs<br> d;
  private cs<be> e;
  private cs<MessageFactory> f;
  
  public RequestAd$DeviceInfo$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAd$DeviceInfo$Factory", "members/com.vungle.publisher.protocol.message.RequestAd$DeviceInfo$Factory", true, RequestAd.DeviceInfo.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.AdConfig", RequestAd.DeviceInfo.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.bc", RequestAd.DeviceInfo.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.protocol.message.RequestAd$DeviceInfo$DisplayDimension$Factory", RequestAd.DeviceInfo.Factory.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.br", RequestAd.DeviceInfo.Factory.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.be", RequestAd.DeviceInfo.Factory.class, getClass().getClassLoader());
    this.f = paramcy.a("members/com.vungle.publisher.protocol.message.MessageFactory", RequestAd.DeviceInfo.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAd.DeviceInfo.Factory get()
  {
    RequestAd.DeviceInfo.Factory localFactory = new RequestAd.DeviceInfo.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
    paramSet2.add(this.f);
  }
  
  public final void injectMembers(RequestAd.DeviceInfo.Factory paramFactory)
  {
    paramFactory.a = ((AdConfig)this.a.get());
    paramFactory.b = ((bc)this.b.get());
    paramFactory.c = ((RequestAd.DeviceInfo.DisplayDimension.Factory)this.c.get());
    paramFactory.d = ((br)this.d.get());
    paramFactory.e = ((be)this.e.get());
    this.f.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAd$DeviceInfo$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */