package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.ReportLocalAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class ReportLocalAdHttpRequest$Factory$$InjectAdapter
  extends cs<ReportLocalAdHttpRequest.Factory>
  implements cp<ReportLocalAdHttpRequest.Factory>, Provider<ReportLocalAdHttpRequest.Factory>
{
  private cs<ReportLocalAd.Factory> a;
  private cs<ReportAdHttpRequest.Factory> b;
  
  public ReportLocalAdHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Factory", "members/com.vungle.publisher.protocol.ReportLocalAdHttpRequest$Factory", true, ReportLocalAdHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.ReportLocalAd$Factory", ReportLocalAdHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.ReportAdHttpRequest$Factory", ReportLocalAdHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportLocalAdHttpRequest.Factory get()
  {
    ReportLocalAdHttpRequest.Factory localFactory = new ReportLocalAdHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ReportLocalAdHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((ReportLocalAd.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportLocalAdHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */