package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportStreamingAd$Factory$PlayFactory$UserActionFactory$$InjectAdapter
  extends cs<ReportStreamingAd.Factory.PlayFactory.UserActionFactory>
  implements cp<ReportStreamingAd.Factory.PlayFactory.UserActionFactory>, Provider<ReportStreamingAd.Factory.PlayFactory.UserActionFactory>
{
  private cs<ReportAd.Play.UserAction.Factory> a;
  
  public ReportStreamingAd$Factory$PlayFactory$UserActionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.ReportStreamingAd$Factory$PlayFactory$UserActionFactory", "members/com.vungle.publisher.protocol.message.ReportStreamingAd$Factory$PlayFactory$UserActionFactory", true, ReportStreamingAd.Factory.PlayFactory.UserActionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.ReportAd$Play$UserAction$Factory", ReportStreamingAd.Factory.PlayFactory.UserActionFactory.class, getClass().getClassLoader(), false);
  }
  
  public final ReportStreamingAd.Factory.PlayFactory.UserActionFactory get()
  {
    ReportStreamingAd.Factory.PlayFactory.UserActionFactory localUserActionFactory = new ReportStreamingAd.Factory.PlayFactory.UserActionFactory();
    injectMembers(localUserActionFactory);
    return localUserActionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ReportStreamingAd.Factory.PlayFactory.UserActionFactory paramUserActionFactory)
  {
    this.a.injectMembers(paramUserActionFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportStreamingAd$Factory$PlayFactory$UserActionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */