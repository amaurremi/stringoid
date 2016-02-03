package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;

public final class RequestAd$Factory$$InjectAdapter
  extends cs<RequestAd.a>
  implements cp<RequestAd.a>
{
  private cs<RequestAd.Demographic.Factory> a;
  private cs<RequestAd.DeviceInfo.Factory> b;
  private cs<bc> c;
  private cs<be> d;
  private cs<MessageFactory> e;
  
  public RequestAd$Factory$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.protocol.message.RequestAd$Factory", false, RequestAd.a.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.RequestAd$Demographic$Factory", RequestAd.a.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestAd$DeviceInfo$Factory", RequestAd.a.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.bc", RequestAd.a.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.be", RequestAd.a.class, getClass().getClassLoader());
    this.e = paramcy.a("members/com.vungle.publisher.protocol.message.MessageFactory", RequestAd.a.class, getClass().getClassLoader(), false);
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
  }
  
  public final void injectMembers(RequestAd.a parama)
  {
    parama.a = ((RequestAd.Demographic.Factory)this.a.get());
    parama.b = ((RequestAd.DeviceInfo.Factory)this.b.get());
    parama.c = ((bc)this.c.get());
    parama.d = ((be)this.d.get());
    this.e.injectMembers(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */