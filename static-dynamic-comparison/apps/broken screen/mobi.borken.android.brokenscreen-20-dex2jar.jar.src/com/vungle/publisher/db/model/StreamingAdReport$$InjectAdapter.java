package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAdReport$$InjectAdapter
  extends cs<StreamingAdReport>
  implements cp<StreamingAdReport>, Provider<StreamingAdReport>
{
  private cs<StreamingAdReport.Factory> a;
  private cs<StreamingAdPlay.Factory> b;
  private cs<AdReport> c;
  
  public StreamingAdReport$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAdReport", "members/com.vungle.publisher.db.model.StreamingAdReport", false, StreamingAdReport.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAdReport$Factory", StreamingAdReport.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.StreamingAdPlay$Factory", StreamingAdReport.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdReport", StreamingAdReport.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAdReport get()
  {
    StreamingAdReport localStreamingAdReport = new StreamingAdReport();
    injectMembers(localStreamingAdReport);
    return localStreamingAdReport;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(StreamingAdReport paramStreamingAdReport)
  {
    paramStreamingAdReport.l = ((StreamingAdReport.Factory)this.a.get());
    paramStreamingAdReport.p = ((StreamingAdPlay.Factory)this.b.get());
    this.c.injectMembers(paramStreamingAdReport);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdReport$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */