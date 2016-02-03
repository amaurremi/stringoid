package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ReportAdHttpResponseHandler$Creator$$InjectAdapter
  extends cs<ReportAdHttpResponseHandler.Creator>
  implements cp<ReportAdHttpResponseHandler.Creator>, Provider<ReportAdHttpResponseHandler.Creator>
{
  private cs<ReportAdHttpResponseHandler> a;
  
  public ReportAdHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.ReportAdHttpResponseHandler$Creator", "members/com.vungle.publisher.protocol.ReportAdHttpResponseHandler$Creator", true, ReportAdHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ReportAdHttpResponseHandler", ReportAdHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final ReportAdHttpResponseHandler.Creator get()
  {
    ReportAdHttpResponseHandler.Creator localCreator = new ReportAdHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ReportAdHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((ReportAdHttpResponseHandler)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportAdHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */