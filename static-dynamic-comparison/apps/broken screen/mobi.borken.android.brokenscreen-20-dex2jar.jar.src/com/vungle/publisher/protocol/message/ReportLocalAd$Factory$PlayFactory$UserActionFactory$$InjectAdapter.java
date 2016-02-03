package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportLocalAd$Factory$PlayFactory$UserActionFactory$$InjectAdapter
  extends cs<ReportLocalAd.Factory.PlayFactory.UserActionFactory>
  implements cp<ReportLocalAd.Factory.PlayFactory.UserActionFactory>, Provider<ReportLocalAd.Factory.PlayFactory.UserActionFactory>
{
  private cs<ReportAd.Play.UserAction.Factory> a;
  
  public ReportLocalAd$Factory$PlayFactory$UserActionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.ReportLocalAd$Factory$PlayFactory$UserActionFactory", "members/com.vungle.publisher.protocol.message.ReportLocalAd$Factory$PlayFactory$UserActionFactory", true, ReportLocalAd.Factory.PlayFactory.UserActionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.ReportAd$Play$UserAction$Factory", ReportLocalAd.Factory.PlayFactory.UserActionFactory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportLocalAd.Factory.PlayFactory.UserActionFactory get()
  {
    ReportLocalAd.Factory.PlayFactory.UserActionFactory localUserActionFactory = new ReportLocalAd.Factory.PlayFactory.UserActionFactory();
    injectMembers(localUserActionFactory);
    return localUserActionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ReportLocalAd.Factory.PlayFactory.UserActionFactory paramUserActionFactory)
  {
    this.a.injectMembers(paramUserActionFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportLocalAd$Factory$PlayFactory$UserActionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */