package com.vungle.publisher.service;

import android.content.Context;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import com.vungle.publisher.net.http.DownloadHttpGateway;
import com.vungle.publisher.reporting.ReportManager;
import java.util.Set;
import javax.inject.Provider;

public final class PrepareLocalAdIntentHandler$Factory$$InjectAdapter
  extends cs<PrepareLocalAdIntentHandler.Factory>
  implements cp<PrepareLocalAdIntentHandler.Factory>, Provider<PrepareLocalAdIntentHandler.Factory>
{
  private cs<AdManager> a;
  private cs<Context> b;
  private cs<DownloadHttpGateway> c;
  private cs<di> d;
  private cs<ReportManager> e;
  
  public PrepareLocalAdIntentHandler$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.service.PrepareLocalAdIntentHandler$Factory", "members/com.vungle.publisher.service.PrepareLocalAdIntentHandler$Factory", true, PrepareLocalAdIntentHandler.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdManager", PrepareLocalAdIntentHandler.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("android.content.Context", PrepareLocalAdIntentHandler.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.net.http.DownloadHttpGateway", PrepareLocalAdIntentHandler.Factory.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.di", PrepareLocalAdIntentHandler.Factory.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.reporting.ReportManager", PrepareLocalAdIntentHandler.Factory.class, getClass().getClassLoader());
  }
  
  public final PrepareLocalAdIntentHandler.Factory get()
  {
    PrepareLocalAdIntentHandler.Factory localFactory = new PrepareLocalAdIntentHandler.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
  }
  
  public final void injectMembers(PrepareLocalAdIntentHandler.Factory paramFactory)
  {
    paramFactory.a = ((AdManager)this.a.get());
    paramFactory.b = ((Context)this.b.get());
    paramFactory.c = ((DownloadHttpGateway)this.c.get());
    paramFactory.d = ((di)this.d.get());
    paramFactory.e = ((ReportManager)this.e.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/PrepareLocalAdIntentHandler$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */