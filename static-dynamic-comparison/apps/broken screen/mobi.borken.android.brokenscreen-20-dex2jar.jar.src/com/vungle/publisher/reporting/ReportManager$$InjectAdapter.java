package com.vungle.publisher.reporting;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.db.model.LocalAdReport.Factory;
import com.vungle.publisher.db.model.StreamingAdReport.Factory;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import java.util.Set;
import javax.inject.Provider;

public final class ReportManager$$InjectAdapter
  extends cs<ReportManager>
  implements cp<ReportManager>, Provider<ReportManager>
{
  private cs<LocalAdReport.Factory> a;
  private cs<ProtocolHttpGateway> b;
  private cs<SdkState> c;
  private cs<StreamingAdReport.Factory> d;
  
  public ReportManager$$InjectAdapter()
  {
    super("com.vungle.publisher.reporting.ReportManager", "members/com.vungle.publisher.reporting.ReportManager", true, ReportManager.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAdReport$Factory", ReportManager.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway", ReportManager.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.env.SdkState", ReportManager.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.db.model.StreamingAdReport$Factory", ReportManager.class, getClass().getClassLoader());
  }
  
  public final ReportManager get()
  {
    ReportManager localReportManager = new ReportManager();
    injectMembers(localReportManager);
    return localReportManager;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(ReportManager paramReportManager)
  {
    paramReportManager.a = ((LocalAdReport.Factory)this.a.get());
    paramReportManager.b = ((ProtocolHttpGateway)this.b.get());
    paramReportManager.c = ((SdkState)this.c.get());
    paramReportManager.d = ((StreamingAdReport.Factory)this.d.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/reporting/ReportManager$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */