package com.vungle.publisher;

import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import com.vungle.publisher.reporting.ReportManager;
import java.util.Set;
import javax.inject.Provider;

public final class VunglePub$DatabaseOpenEventListener$$InjectAdapter
  extends cs<VunglePub.DatabaseOpenEventListener>
  implements cp<VunglePub.DatabaseOpenEventListener>, Provider<VunglePub.DatabaseOpenEventListener>
{
  private cs<AdManager> a;
  private cs<ProtocolHttpGateway> b;
  private cs<ReportManager> c;
  private cs<bh> d;
  
  public VunglePub$DatabaseOpenEventListener$$InjectAdapter()
  {
    super("com.vungle.publisher.VunglePub$DatabaseOpenEventListener", "members/com.vungle.publisher.VunglePub$DatabaseOpenEventListener", true, VunglePub.DatabaseOpenEventListener.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdManager", VunglePub.DatabaseOpenEventListener.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway", VunglePub.DatabaseOpenEventListener.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.reporting.ReportManager", VunglePub.DatabaseOpenEventListener.class, getClass().getClassLoader());
    this.d = paramcy.a("members/com.vungle.publisher.event.BaseEventListener", VunglePub.DatabaseOpenEventListener.class, getClass().getClassLoader(), false);
  }
  
  public final VunglePub.DatabaseOpenEventListener get()
  {
    VunglePub.DatabaseOpenEventListener localDatabaseOpenEventListener = new VunglePub.DatabaseOpenEventListener();
    injectMembers(localDatabaseOpenEventListener);
    return localDatabaseOpenEventListener;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(VunglePub.DatabaseOpenEventListener paramDatabaseOpenEventListener)
  {
    paramDatabaseOpenEventListener.a = ((AdManager)this.a.get());
    paramDatabaseOpenEventListener.b = ((ProtocolHttpGateway)this.b.get());
    paramDatabaseOpenEventListener.c = ((ReportManager)this.c.get());
    this.d.injectMembers(paramDatabaseOpenEventListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/VunglePub$DatabaseOpenEventListener$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */