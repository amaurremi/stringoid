package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAdPlay$Factory$$InjectAdapter
  extends cs<LocalAdPlay.Factory>
  implements cp<LocalAdPlay.Factory>, Provider<LocalAdPlay.Factory>
{
  private cs<Provider<LocalAdPlay>> a;
  private cs<LocalAdReportEvent.Factory> b;
  private cs<AdPlay.Factory> c;
  
  public LocalAdPlay$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAdPlay$Factory", "members/com.vungle.publisher.db.model.LocalAdPlay$Factory", true, LocalAdPlay.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.LocalAdPlay>", LocalAdPlay.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalAdReportEvent$Factory", LocalAdPlay.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdPlay$Factory", LocalAdPlay.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAdPlay.Factory get()
  {
    LocalAdPlay.Factory localFactory = new LocalAdPlay.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalAdPlay.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    paramFactory.c = ((LocalAdReportEvent.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdPlay$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */