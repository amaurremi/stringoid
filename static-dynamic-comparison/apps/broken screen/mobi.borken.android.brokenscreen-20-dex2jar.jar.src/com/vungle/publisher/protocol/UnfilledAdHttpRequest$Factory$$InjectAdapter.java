package com.vungle.publisher.protocol;

import com.vungle.publisher.bc;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.RequestLocalAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class UnfilledAdHttpRequest$Factory$$InjectAdapter
  extends cs<UnfilledAdHttpRequest.Factory>
  implements cp<UnfilledAdHttpRequest.Factory>, Provider<UnfilledAdHttpRequest.Factory>
{
  private cs<bc> a;
  private cs<RequestLocalAd.Factory> b;
  private cs<ProtocolHttpRequest.a> c;
  
  public UnfilledAdHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.UnfilledAdHttpRequest$Factory", "members/com.vungle.publisher.protocol.UnfilledAdHttpRequest$Factory", true, UnfilledAdHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.bc", UnfilledAdHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestLocalAd$Factory", UnfilledAdHttpRequest.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", UnfilledAdHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final UnfilledAdHttpRequest.Factory get()
  {
    UnfilledAdHttpRequest.Factory localFactory = new UnfilledAdHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(UnfilledAdHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((bc)this.a.get());
    paramFactory.g = ((RequestLocalAd.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/UnfilledAdHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */