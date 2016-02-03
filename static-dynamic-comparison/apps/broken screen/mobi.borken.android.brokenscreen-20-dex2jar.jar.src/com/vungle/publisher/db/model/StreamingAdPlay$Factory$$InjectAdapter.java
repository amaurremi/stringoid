package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAdPlay$Factory$$InjectAdapter
  extends cs<StreamingAdPlay.Factory>
  implements cp<StreamingAdPlay.Factory>, Provider<StreamingAdPlay.Factory>
{
  private cs<Provider<StreamingAdPlay>> a;
  private cs<StreamingAdReportEvent.Factory> b;
  private cs<AdPlay.Factory> c;
  
  public StreamingAdPlay$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAdPlay$Factory", "members/com.vungle.publisher.db.model.StreamingAdPlay$Factory", true, StreamingAdPlay.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.StreamingAdPlay>", StreamingAdPlay.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.StreamingAdReportEvent$Factory", StreamingAdPlay.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdPlay$Factory", StreamingAdPlay.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAdPlay.Factory get()
  {
    StreamingAdPlay.Factory localFactory = new StreamingAdPlay.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(StreamingAdPlay.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    paramFactory.c = ((StreamingAdReportEvent.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdPlay$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */