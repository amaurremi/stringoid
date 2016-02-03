package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportStreamingAd$Factory$$InjectAdapter
  extends cs<ReportStreamingAd.Factory>
  implements cp<ReportStreamingAd.Factory>, Provider<ReportStreamingAd.Factory>
{
  private cs<ReportStreamingAd.Factory.PlayFactory> a;
  private cs<RequestStreamingAd.Factory> b;
  private cs<ReportAd.Factory> c;
  
  public ReportStreamingAd$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.ReportStreamingAd$Factory", "members/com.vungle.publisher.protocol.message.ReportStreamingAd$Factory", true, ReportStreamingAd.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.ReportStreamingAd$Factory$PlayFactory", ReportStreamingAd.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestStreamingAd$Factory", ReportStreamingAd.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.message.ReportAd$Factory", ReportStreamingAd.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportStreamingAd.Factory get()
  {
    ReportStreamingAd.Factory localFactory = new ReportStreamingAd.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(ReportStreamingAd.Factory paramFactory)
  {
    paramFactory.a = ((ReportStreamingAd.Factory.PlayFactory)this.a.get());
    paramFactory.b = ((RequestStreamingAd.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportStreamingAd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */