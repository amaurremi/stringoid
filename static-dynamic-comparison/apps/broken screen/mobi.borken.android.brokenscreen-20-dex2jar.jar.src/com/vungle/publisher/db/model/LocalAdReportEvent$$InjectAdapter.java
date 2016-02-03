package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAdReportEvent$$InjectAdapter
  extends cs<LocalAdReportEvent>
  implements cp<LocalAdReportEvent>, Provider<LocalAdReportEvent>
{
  private cs<LocalAdReportEvent.Factory> a;
  private cs<LocalAdPlay.Factory> b;
  private cs<AdReportEvent> c;
  
  public LocalAdReportEvent$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAdReportEvent", "members/com.vungle.publisher.db.model.LocalAdReportEvent", false, LocalAdReportEvent.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAdReportEvent$Factory", LocalAdReportEvent.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalAdPlay$Factory", LocalAdReportEvent.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdReportEvent", LocalAdReportEvent.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAdReportEvent get()
  {
    LocalAdReportEvent localLocalAdReportEvent = new LocalAdReportEvent();
    injectMembers(localLocalAdReportEvent);
    return localLocalAdReportEvent;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalAdReportEvent paramLocalAdReportEvent)
  {
    paramLocalAdReportEvent.e = ((LocalAdReportEvent.Factory)this.a.get());
    paramLocalAdReportEvent.f = ((LocalAdPlay.Factory)this.b.get());
    this.c.injectMembers(paramLocalAdReportEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdReportEvent$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */