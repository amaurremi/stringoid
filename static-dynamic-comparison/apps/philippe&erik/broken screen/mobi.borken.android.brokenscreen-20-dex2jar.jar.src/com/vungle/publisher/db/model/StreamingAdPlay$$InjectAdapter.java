package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAdPlay$$InjectAdapter
  extends cs<StreamingAdPlay>
  implements cp<StreamingAdPlay>, Provider<StreamingAdPlay>
{
  private cs<StreamingAdPlay.Factory> a;
  private cs<StreamingAdReportEvent.Factory> b;
  private cs<AdPlay> c;
  
  public StreamingAdPlay$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAdPlay", "members/com.vungle.publisher.db.model.StreamingAdPlay", false, StreamingAdPlay.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAdPlay$Factory", StreamingAdPlay.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.StreamingAdReportEvent$Factory", StreamingAdPlay.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdPlay", StreamingAdPlay.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAdPlay get()
  {
    StreamingAdPlay localStreamingAdPlay = new StreamingAdPlay();
    injectMembers(localStreamingAdPlay);
    return localStreamingAdPlay;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(StreamingAdPlay paramStreamingAdPlay)
  {
    paramStreamingAdPlay.e = ((StreamingAdPlay.Factory)this.a.get());
    paramStreamingAdPlay.f = ((StreamingAdReportEvent.Factory)this.b.get());
    this.c.injectMembers(paramStreamingAdPlay);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdPlay$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */