package com.vungle.publisher.ad;

import com.vungle.publisher.bc;
import com.vungle.publisher.br;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.db.model.LocalAd.Factory;
import com.vungle.publisher.db.model.StreamingAd.Factory;
import com.vungle.publisher.di;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import java.util.Set;
import javax.inject.Provider;

public final class AdManager$$InjectAdapter
  extends cs<AdManager>
  implements cp<AdManager>, Provider<AdManager>
{
  private cs<AdPreparer> a;
  private cs<bc> b;
  private cs<di> c;
  private cs<LocalAd.Factory> d;
  private cs<br> e;
  private cs<Provider<AdManager.PrepareStreamingAdEventListener>> f;
  private cs<ProtocolHttpGateway> g;
  private cs<SdkConfig> h;
  private cs<StreamingAd.Factory> i;
  
  public AdManager$$InjectAdapter()
  {
    super("com.vungle.publisher.ad.AdManager", "members/com.vungle.publisher.ad.AdManager", true, AdManager.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdPreparer", AdManager.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.bc", AdManager.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.di", AdManager.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.db.model.LocalAd$Factory", AdManager.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.br", AdManager.class, getClass().getClassLoader());
    this.f = paramcy.a("javax.inject.Provider<com.vungle.publisher.ad.AdManager$PrepareStreamingAdEventListener>", AdManager.class, getClass().getClassLoader());
    this.g = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway", AdManager.class, getClass().getClassLoader());
    this.h = paramcy.a("com.vungle.publisher.env.SdkConfig", AdManager.class, getClass().getClassLoader());
    this.i = paramcy.a("com.vungle.publisher.db.model.StreamingAd$Factory", AdManager.class, getClass().getClassLoader());
  }
  
  public final AdManager get()
  {
    AdManager localAdManager = new AdManager();
    injectMembers(localAdManager);
    return localAdManager;
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
  }
  
  public final void injectMembers(AdManager paramAdManager)
  {
    paramAdManager.b = ((AdPreparer)this.a.get());
    paramAdManager.c = ((bc)this.b.get());
    paramAdManager.d = ((di)this.c.get());
    paramAdManager.e = ((LocalAd.Factory)this.d.get());
    paramAdManager.f = ((br)this.e.get());
    paramAdManager.g = ((Provider)this.f.get());
    paramAdManager.h = ((ProtocolHttpGateway)this.g.get());
    paramAdManager.i = ((SdkConfig)this.h.get());
    paramAdManager.j = ((StreamingAd.Factory)this.i.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ad/AdManager$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */