package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAdReportEvent$Factory$$InjectAdapter
  extends cs<LocalAdReportEvent.Factory>
  implements cp<LocalAdReportEvent.Factory>, Provider<LocalAdReportEvent.Factory>
{
  private cs<Provider<LocalAdReportEvent>> a;
  private cs<AdReportEvent.Factory> b;
  
  public LocalAdReportEvent$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAdReportEvent$Factory", "members/com.vungle.publisher.db.model.LocalAdReportEvent$Factory", true, LocalAdReportEvent.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.LocalAdReportEvent>", LocalAdReportEvent.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.AdReportEvent$Factory", LocalAdReportEvent.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAdReportEvent.Factory get()
  {
    LocalAdReportEvent.Factory localFactory = new LocalAdReportEvent.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(LocalAdReportEvent.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdReportEvent$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */