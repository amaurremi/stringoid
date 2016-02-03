package com.vungle.publisher.reporting;

import com.vungle.publisher.bh;
import com.vungle.publisher.bt;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class AdReportingHandler$$InjectAdapter
  extends cs<AdReportingHandler>
  implements cp<AdReportingHandler>, Provider<AdReportingHandler>
{
  private cs<AdServiceReportingHandler> a;
  private cs<bt> b;
  private cs<ReportManager> c;
  private cs<bh> d;
  
  public AdReportingHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.reporting.AdReportingHandler", "members/com.vungle.publisher.reporting.AdReportingHandler", false, AdReportingHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.reporting.AdServiceReportingHandler", AdReportingHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.bt", AdReportingHandler.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.reporting.ReportManager", AdReportingHandler.class, getClass().getClassLoader());
    this.d = paramcy.a("members/com.vungle.publisher.event.BaseEventListener", AdReportingHandler.class, getClass().getClassLoader(), false);
  }
  
  public final AdReportingHandler get()
  {
    AdReportingHandler localAdReportingHandler = new AdReportingHandler();
    injectMembers(localAdReportingHandler);
    return localAdReportingHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(AdReportingHandler paramAdReportingHandler)
  {
    paramAdReportingHandler.d = ((AdServiceReportingHandler)this.a.get());
    paramAdReportingHandler.e = ((bt)this.b.get());
    paramAdReportingHandler.g = ((ReportManager)this.c.get());
    this.d.injectMembers(paramAdReportingHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/reporting/AdReportingHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */