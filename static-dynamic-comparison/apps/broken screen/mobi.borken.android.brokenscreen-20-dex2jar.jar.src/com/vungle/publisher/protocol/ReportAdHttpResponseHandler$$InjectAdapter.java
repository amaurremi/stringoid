package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler;
import com.vungle.publisher.reporting.ReportManager;
import java.util.Set;
import javax.inject.Provider;

public final class ReportAdHttpResponseHandler$$InjectAdapter
  extends cs<ReportAdHttpResponseHandler>
  implements cp<ReportAdHttpResponseHandler>, Provider<ReportAdHttpResponseHandler>
{
  private cs<Provider<ReportManager>> a;
  private cs<InfiniteRetryHttpResponseHandler> b;
  
  public ReportAdHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportAdHttpResponseHandler", "members/com.vungle.publisher.protocol.ReportAdHttpResponseHandler", true, ReportAdHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.reporting.ReportManager>", ReportAdHttpResponseHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler", ReportAdHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final ReportAdHttpResponseHandler get()
  {
    ReportAdHttpResponseHandler localReportAdHttpResponseHandler = new ReportAdHttpResponseHandler();
    injectMembers(localReportAdHttpResponseHandler);
    return localReportAdHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ReportAdHttpResponseHandler paramReportAdHttpResponseHandler)
  {
    paramReportAdHttpResponseHandler.a = ((Provider)this.a.get());
    this.b.injectMembers(paramReportAdHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportAdHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */