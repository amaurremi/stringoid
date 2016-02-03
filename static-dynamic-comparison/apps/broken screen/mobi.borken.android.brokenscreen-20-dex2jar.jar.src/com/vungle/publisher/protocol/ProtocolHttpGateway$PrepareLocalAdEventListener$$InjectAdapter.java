package com.vungle.publisher.protocol;

import com.vungle.publisher.bh;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.env.SdkConfig;
import java.util.Set;
import javax.inject.Provider;

public final class ProtocolHttpGateway$PrepareLocalAdEventListener$$InjectAdapter
  extends cs<ProtocolHttpGateway.PrepareLocalAdEventListener>
  implements cp<ProtocolHttpGateway.PrepareLocalAdEventListener>, Provider<ProtocolHttpGateway.PrepareLocalAdEventListener>
{
  private cs<SdkConfig> a;
  private cs<Provider<ProtocolHttpGateway>> b;
  private cs<bh> c;
  
  public ProtocolHttpGateway$PrepareLocalAdEventListener$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ProtocolHttpGateway$PrepareLocalAdEventListener", "members/com.vungle.publisher.protocol.ProtocolHttpGateway$PrepareLocalAdEventListener", true, ProtocolHttpGateway.PrepareLocalAdEventListener.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.env.SdkConfig", ProtocolHttpGateway.PrepareLocalAdEventListener.class, getClass().getClassLoader());
    this.b = paramcy.a("javax.inject.Provider<com.vungle.publisher.protocol.ProtocolHttpGateway>", ProtocolHttpGateway.PrepareLocalAdEventListener.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.event.BaseEventListener", ProtocolHttpGateway.PrepareLocalAdEventListener.class, getClass().getClassLoader(), false);
  }
  
  public final ProtocolHttpGateway.PrepareLocalAdEventListener get()
  {
    ProtocolHttpGateway.PrepareLocalAdEventListener localPrepareLocalAdEventListener = new ProtocolHttpGateway.PrepareLocalAdEventListener();
    injectMembers(localPrepareLocalAdEventListener);
    return localPrepareLocalAdEventListener;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(ProtocolHttpGateway.PrepareLocalAdEventListener paramPrepareLocalAdEventListener)
  {
    paramPrepareLocalAdEventListener.a = ((SdkConfig)this.a.get());
    paramPrepareLocalAdEventListener.b = ((Provider)this.b.get());
    this.c.injectMembers(paramPrepareLocalAdEventListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ProtocolHttpGateway$PrepareLocalAdEventListener$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */