package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportLocalAd$Factory$PlayFactory$$InjectAdapter
  extends cs<ReportLocalAd.Factory.PlayFactory>
  implements cp<ReportLocalAd.Factory.PlayFactory>, Provider<ReportLocalAd.Factory.PlayFactory>
{
  private cs<ReportLocalAd.Factory.PlayFactory.UserActionFactory> a;
  private cs<ReportAd.Play.Factory> b;
  
  public ReportLocalAd$Factory$PlayFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.ReportLocalAd$Factory$PlayFactory", "members/com.vungle.publisher.protocol.message.ReportLocalAd$Factory$PlayFactory", true, ReportLocalAd.Factory.PlayFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.ReportLocalAd$Factory$PlayFactory$UserActionFactory", ReportLocalAd.Factory.PlayFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.message.ReportAd$Play$Factory", ReportLocalAd.Factory.PlayFactory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportLocalAd.Factory.PlayFactory get()
  {
    ReportLocalAd.Factory.PlayFactory localPlayFactory = new ReportLocalAd.Factory.PlayFactory();
    injectMembers(localPlayFactory);
    return localPlayFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ReportLocalAd.Factory.PlayFactory paramPlayFactory)
  {
    paramPlayFactory.a = ((ReportLocalAd.Factory.PlayFactory.UserActionFactory)this.a.get());
    this.b.injectMembers(paramPlayFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportLocalAd$Factory$PlayFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */