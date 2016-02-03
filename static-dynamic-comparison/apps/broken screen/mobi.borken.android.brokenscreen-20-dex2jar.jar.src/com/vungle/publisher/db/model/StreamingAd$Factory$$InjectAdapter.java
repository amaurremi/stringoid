package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingAd$Factory$$InjectAdapter
  extends cs<StreamingAd.Factory>
  implements cp<StreamingAd.Factory>, Provider<StreamingAd.Factory>
{
  private cs<Provider<StreamingAd>> a;
  private cs<StreamingVideo.Factory> b;
  private cs<Ad.Factory> c;
  
  public StreamingAd$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingAd$Factory", "members/com.vungle.publisher.db.model.StreamingAd$Factory", true, StreamingAd.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.StreamingAd>", StreamingAd.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.StreamingVideo$Factory", StreamingAd.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.Ad$Factory", StreamingAd.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingAd.Factory get()
  {
    StreamingAd.Factory localFactory = new StreamingAd.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(StreamingAd.Factory paramFactory)
  {
    paramFactory.c = ((Provider)this.a.get());
    paramFactory.d = ((StreamingVideo.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */