package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAdReport$Factory$$InjectAdapter
  extends cs<LocalAdReport.Factory>
  implements cp<LocalAdReport.Factory>, Provider<LocalAdReport.Factory>
{
  private cs<LocalAd.Factory> a;
  private cs<LocalAdPlay.Factory> b;
  private cs<Provider<LocalAdReport>> c;
  private cs<AdReport.Factory> d;
  
  public LocalAdReport$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAdReport$Factory", "members/com.vungle.publisher.db.model.LocalAdReport$Factory", true, LocalAdReport.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAd$Factory", LocalAdReport.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalAdPlay$Factory", LocalAdReport.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.LocalAdReport>", LocalAdReport.Factory.class, getClass().getClassLoader());
    this.d = paramcy.a("members/com.vungle.publisher.db.model.AdReport$Factory", LocalAdReport.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAdReport.Factory get()
  {
    LocalAdReport.Factory localFactory = new LocalAdReport.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(LocalAdReport.Factory paramFactory)
  {
    paramFactory.a = ((LocalAd.Factory)this.a.get());
    paramFactory.c = ((LocalAdPlay.Factory)this.b.get());
    paramFactory.d = ((Provider)this.c.get());
    this.d.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdReport$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */