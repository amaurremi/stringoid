package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportLocalAd$Factory$$InjectAdapter
  extends cs<ReportLocalAd.Factory>
  implements cp<ReportLocalAd.Factory>, Provider<ReportLocalAd.Factory>
{
  private cs<ReportLocalAd.Factory.PlayFactory> a;
  private cs<RequestLocalAd.Factory> b;
  private cs<ReportAd.Factory> c;
  
  public ReportLocalAd$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.ReportLocalAd$Factory", "members/com.vungle.publisher.protocol.message.ReportLocalAd$Factory", true, ReportLocalAd.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.ReportLocalAd$Factory$PlayFactory", ReportLocalAd.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestLocalAd$Factory", ReportLocalAd.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.message.ReportAd$Factory", ReportLocalAd.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportLocalAd.Factory get()
  {
    ReportLocalAd.Factory localFactory = new ReportLocalAd.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(ReportLocalAd.Factory paramFactory)
  {
    paramFactory.a = ((ReportLocalAd.Factory.PlayFactory)this.a.get());
    paramFactory.b = ((RequestLocalAd.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportLocalAd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */