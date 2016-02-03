package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportStreamingAdHttpRequest$Creator$$InjectAdapter
  extends cs<ReportStreamingAdHttpRequest.Creator>
  implements cp<ReportStreamingAdHttpRequest.Creator>, Provider<ReportStreamingAdHttpRequest.Creator>
{
  private cs<ReportStreamingAdHttpRequest.Factory> a;
  
  public ReportStreamingAdHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Creator", true, ReportStreamingAdHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Factory", ReportStreamingAdHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final ReportStreamingAdHttpRequest.Creator get()
  {
    ReportStreamingAdHttpRequest.Creator localCreator = new ReportStreamingAdHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ReportStreamingAdHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((ReportStreamingAdHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportStreamingAdHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */