package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.ReportStreamingAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class ReportStreamingAdHttpRequest$Factory$$InjectAdapter
  extends cs<ReportStreamingAdHttpRequest.Factory>
  implements cp<ReportStreamingAdHttpRequest.Factory>, Provider<ReportStreamingAdHttpRequest.Factory>
{
  private cs<ReportStreamingAd.Factory> a;
  private cs<ReportAdHttpRequest.Factory> b;
  
  public ReportStreamingAdHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Factory", "members/com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Factory", true, ReportStreamingAdHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.ReportStreamingAd$Factory", ReportStreamingAdHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.ReportAdHttpRequest$Factory", ReportStreamingAdHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportStreamingAdHttpRequest.Factory get()
  {
    ReportStreamingAdHttpRequest.Factory localFactory = new ReportStreamingAdHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ReportStreamingAdHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((ReportStreamingAd.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportStreamingAdHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */