package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.db.DatabaseBroadcastReceiver;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.device.ExternalStorageStateBroadcastReceiver;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import com.vungle.publisher.reporting.ReportManager;
import java.util.Set;

public final class VunglePub$$InjectAdapter
  extends cs<VunglePub>
  implements cp<VunglePub>
{
  private cs<AdManager> a;
  private cs<Context> b;
  private cs<DatabaseBroadcastReceiver> c;
  private cs<DatabaseHelper> d;
  private cs<VunglePub.DatabaseOpenEventListener> e;
  private cs<Demographic> f;
  private cs<di> g;
  private cs<Class> h;
  private cs<AdConfig> i;
  private cs<ProtocolHttpGateway> j;
  private cs<ReportManager> k;
  private cs<SdkConfig> l;
  private cs<SdkState> m;
  private cs<ScheduledPriorityExecutor> n;
  private cs<ExternalStorageStateBroadcastReceiver> o;
  
  public VunglePub$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.VunglePub", false, VunglePub.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdManager", VunglePub.class, getClass().getClassLoader());
    this.b = paramcy.a("android.content.Context", VunglePub.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.db.DatabaseBroadcastReceiver", VunglePub.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.db.DatabaseHelper", VunglePub.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.VunglePub$DatabaseOpenEventListener", VunglePub.class, getClass().getClassLoader());
    this.f = paramcy.a("com.vungle.publisher.Demographic", VunglePub.class, getClass().getClassLoader());
    this.g = paramcy.a("com.vungle.publisher.di", VunglePub.class, getClass().getClassLoader());
    this.h = paramcy.a("@com.vungle.publisher.inject.annotations.FullScreenAdActivityClass()/java.lang.Class", VunglePub.class, getClass().getClassLoader());
    this.i = paramcy.a("com.vungle.publisher.AdConfig", VunglePub.class, getClass().getClassLoader());
    this.j = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway", VunglePub.class, getClass().getClassLoader());
    this.k = paramcy.a("com.vungle.publisher.reporting.ReportManager", VunglePub.class, getClass().getClassLoader());
    this.l = paramcy.a("com.vungle.publisher.env.SdkConfig", VunglePub.class, getClass().getClassLoader());
    this.m = paramcy.a("com.vungle.publisher.env.SdkState", VunglePub.class, getClass().getClassLoader());
    this.n = paramcy.a("com.vungle.publisher.async.ScheduledPriorityExecutor", VunglePub.class, getClass().getClassLoader());
    this.o = paramcy.a("com.vungle.publisher.device.ExternalStorageStateBroadcastReceiver", VunglePub.class, getClass().getClassLoader());
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
    paramSet2.add(this.f);
    paramSet2.add(this.g);
    paramSet2.add(this.h);
    paramSet2.add(this.i);
    paramSet2.add(this.j);
    paramSet2.add(this.k);
    paramSet2.add(this.l);
    paramSet2.add(this.m);
    paramSet2.add(this.n);
    paramSet2.add(this.o);
  }
  
  public final void injectMembers(VunglePub paramVunglePub)
  {
    paramVunglePub.a = ((AdManager)this.a.get());
    paramVunglePub.b = ((Context)this.b.get());
    paramVunglePub.c = ((DatabaseBroadcastReceiver)this.c.get());
    paramVunglePub.d = ((DatabaseHelper)this.d.get());
    paramVunglePub.e = ((VunglePub.DatabaseOpenEventListener)this.e.get());
    paramVunglePub.f = ((Demographic)this.f.get());
    paramVunglePub.g = ((di)this.g.get());
    paramVunglePub.h = ((Class)this.h.get());
    paramVunglePub.i = ((AdConfig)this.i.get());
    paramVunglePub.j = ((ProtocolHttpGateway)this.j.get());
    paramVunglePub.k = ((ReportManager)this.k.get());
    paramVunglePub.l = ((SdkConfig)this.l.get());
    paramVunglePub.m = ((SdkState)this.m.get());
    paramVunglePub.n = ((ScheduledPriorityExecutor)this.n.get());
    paramVunglePub.o = ((ExternalStorageStateBroadcastReceiver)this.o.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/VunglePub$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */