package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAdReportEvent$$InjectAdapter
  extends cs<StreamingAdReportEvent>
  implements cp<StreamingAdReportEvent>, Provider<StreamingAdReportEvent>
{
  private cs<StreamingAdReportEvent.Factory> a;
  private cs<AdReportEvent> b;
  
  public StreamingAdReportEvent$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAdReportEvent", "members/com.vungle.publisher.db.model.StreamingAdReportEvent", false, StreamingAdReportEvent.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAdReportEvent$Factory", StreamingAdReportEvent.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.AdReportEvent", StreamingAdReportEvent.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAdReportEvent get()
  {
    StreamingAdReportEvent localStreamingAdReportEvent = new StreamingAdReportEvent();
    injectMembers(localStreamingAdReportEvent);
    return localStreamingAdReportEvent;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(StreamingAdReportEvent paramStreamingAdReportEvent)
  {
    paramStreamingAdReportEvent.e = ((StreamingAdReportEvent.Factory)this.a.get());
    this.b.injectMembers(paramStreamingAdReportEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdReportEvent$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */