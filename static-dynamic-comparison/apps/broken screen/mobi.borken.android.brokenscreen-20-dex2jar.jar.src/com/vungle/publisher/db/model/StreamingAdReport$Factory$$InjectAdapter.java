package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAdReport$Factory$$InjectAdapter
  extends cs<StreamingAdReport.Factory>
  implements cp<StreamingAdReport.Factory>, Provider<StreamingAdReport.Factory>
{
  private cs<StreamingAdPlay.Factory> a;
  private cs<StreamingAd.Factory> b;
  private cs<Provider<StreamingAdReport>> c;
  private cs<AdReport.Factory> d;
  
  public StreamingAdReport$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAdReport$Factory", "members/com.vungle.publisher.db.model.StreamingAdReport$Factory", true, StreamingAdReport.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAdPlay$Factory", StreamingAdReport.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.StreamingAd$Factory", StreamingAdReport.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.StreamingAdReport>", StreamingAdReport.Factory.class, getClass().getClassLoader());
    this.d = paramcy.a("members/com.vungle.publisher.db.model.AdReport$Factory", StreamingAdReport.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAdReport.Factory get()
  {
    StreamingAdReport.Factory localFactory = new StreamingAdReport.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(StreamingAdReport.Factory paramFactory)
  {
    paramFactory.a = ((StreamingAdPlay.Factory)this.a.get());
    paramFactory.c = ((StreamingAd.Factory)this.b.get());
    paramFactory.d = ((Provider)this.c.get());
    this.d.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdReport$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */