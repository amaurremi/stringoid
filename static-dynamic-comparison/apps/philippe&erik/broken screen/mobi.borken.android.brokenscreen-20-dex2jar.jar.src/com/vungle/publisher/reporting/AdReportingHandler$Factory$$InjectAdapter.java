package com.vungle.publisher.reporting;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class AdReportingHandler$Factory$$InjectAdapter
  extends cs<AdReportingHandler.Factory>
  implements cp<AdReportingHandler.Factory>, Provider<AdReportingHandler.Factory>
{
  private cs<Provider<AdReportingHandler>> a;
  private cs<ReportManager> b;
  
  public AdReportingHandler$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.reporting.AdReportingHandler$Factory", "members/com.vungle.publisher.reporting.AdReportingHandler$Factory", true, AdReportingHandler.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.reporting.AdReportingHandler>", AdReportingHandler.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.reporting.ReportManager", AdReportingHandler.Factory.class, getClass().getClassLoader());
  }
  
  public final AdReportingHandler.Factory get()
  {
    AdReportingHandler.Factory localFactory = new AdReportingHandler.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(AdReportingHandler.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    paramFactory.b = ((ReportManager)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/reporting/AdReportingHandler$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */