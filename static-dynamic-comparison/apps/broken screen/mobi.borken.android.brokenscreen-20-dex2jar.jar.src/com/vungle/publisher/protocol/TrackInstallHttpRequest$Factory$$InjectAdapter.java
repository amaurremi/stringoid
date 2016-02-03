package com.vungle.publisher.protocol;

import com.vungle.publisher.bc;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.RequestLocalAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class TrackInstallHttpRequest$Factory$$InjectAdapter
  extends cs<TrackInstallHttpRequest.Factory>
  implements cp<TrackInstallHttpRequest.Factory>, Provider<TrackInstallHttpRequest.Factory>
{
  private cs<bc> a;
  private cs<RequestLocalAd.Factory> b;
  private cs<ProtocolHttpRequest.a> c;
  
  public TrackInstallHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.TrackInstallHttpRequest$Factory", "members/com.vungle.publisher.protocol.TrackInstallHttpRequest$Factory", true, TrackInstallHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.bc", TrackInstallHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestLocalAd$Factory", TrackInstallHttpRequest.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", TrackInstallHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final TrackInstallHttpRequest.Factory get()
  {
    TrackInstallHttpRequest.Factory localFactory = new TrackInstallHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(TrackInstallHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((bc)this.a.get());
    paramFactory.g = ((RequestLocalAd.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/TrackInstallHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */