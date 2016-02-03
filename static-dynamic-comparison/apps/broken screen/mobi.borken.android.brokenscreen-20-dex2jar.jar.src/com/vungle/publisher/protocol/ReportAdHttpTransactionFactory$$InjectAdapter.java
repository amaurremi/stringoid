package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportAdHttpTransactionFactory$$InjectAdapter
  extends cs<ReportAdHttpTransactionFactory>
  implements cp<ReportAdHttpTransactionFactory>, Provider<ReportAdHttpTransactionFactory>
{
  private cs<ReportAdHttpResponseHandler> a;
  private cs<ReportLocalAdHttpRequest.Factory> b;
  private cs<ReportStreamingAdHttpRequest.Factory> c;
  
  public ReportAdHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportAdHttpTransactionFactory", "members/com.vungle.publisher.protocol.ReportAdHttpTransactionFactory", true, ReportAdHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ReportAdHttpResponseHandler", ReportAdHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Factory", ReportAdHttpTransactionFactory.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Factory", ReportAdHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final ReportAdHttpTransactionFactory get()
  {
    ReportAdHttpTransactionFactory localReportAdHttpTransactionFactory = new ReportAdHttpTransactionFactory();
    injectMembers(localReportAdHttpTransactionFactory);
    return localReportAdHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(ReportAdHttpTransactionFactory paramReportAdHttpTransactionFactory)
  {
    paramReportAdHttpTransactionFactory.a = ((ReportAdHttpResponseHandler)this.a.get());
    paramReportAdHttpTransactionFactory.b = ((ReportLocalAdHttpRequest.Factory)this.b.get());
    paramReportAdHttpTransactionFactory.c = ((ReportStreamingAdHttpRequest.Factory)this.c.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportAdHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */