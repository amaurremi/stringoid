package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAdReportEvent$Factory$$InjectAdapter
  extends cs<StreamingAdReportEvent.Factory>
  implements cp<StreamingAdReportEvent.Factory>, Provider<StreamingAdReportEvent.Factory>
{
  private cs<Provider<StreamingAdReportEvent>> a;
  private cs<AdReportEvent.Factory> b;
  
  public StreamingAdReportEvent$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAdReportEvent$Factory", "members/com.vungle.publisher.db.model.StreamingAdReportEvent$Factory", true, StreamingAdReportEvent.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.StreamingAdReportEvent>", StreamingAdReportEvent.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.AdReportEvent$Factory", StreamingAdReportEvent.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAdReportEvent.Factory get()
  {
    StreamingAdReportEvent.Factory localFactory = new StreamingAdReportEvent.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(StreamingAdReportEvent.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdReportEvent$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */