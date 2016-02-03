package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAdReport$$InjectAdapter
  extends cs<LocalAdReport>
  implements cp<LocalAdReport>, Provider<LocalAdReport>
{
  private cs<LocalAdReport.Factory> a;
  private cs<LocalAdPlay.Factory> b;
  private cs<AdReport> c;
  
  public LocalAdReport$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAdReport", "members/com.vungle.publisher.db.model.LocalAdReport", false, LocalAdReport.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAdReport$Factory", LocalAdReport.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalAdPlay$Factory", LocalAdReport.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdReport", LocalAdReport.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAdReport get()
  {
    LocalAdReport localLocalAdReport = new LocalAdReport();
    injectMembers(localLocalAdReport);
    return localLocalAdReport;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalAdReport paramLocalAdReport)
  {
    paramLocalAdReport.p = ((LocalAdReport.Factory)this.a.get());
    paramLocalAdReport.q = ((LocalAdPlay.Factory)this.b.get());
    this.c.injectMembers(paramLocalAdReport);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdReport$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */