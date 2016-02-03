package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportLocalAdHttpRequest$Creator$$InjectAdapter
  extends cs<ReportLocalAdHttpRequest.Creator>
  implements cp<ReportLocalAdHttpRequest.Creator>, Provider<ReportLocalAdHttpRequest.Creator>
{
  private cs<ReportLocalAdHttpRequest.Factory> a;
  
  public ReportLocalAdHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Creator", true, ReportLocalAdHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Factory", ReportLocalAdHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final ReportLocalAdHttpRequest.Creator get()
  {
    ReportLocalAdHttpRequest.Creator localCreator = new ReportLocalAdHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ReportLocalAdHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((ReportLocalAdHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportLocalAdHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */