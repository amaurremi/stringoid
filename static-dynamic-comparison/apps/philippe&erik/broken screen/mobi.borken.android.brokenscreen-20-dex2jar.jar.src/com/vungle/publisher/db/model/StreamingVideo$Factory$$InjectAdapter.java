package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingVideo$Factory$$InjectAdapter
  extends cs<StreamingVideo.Factory>
  implements cp<StreamingVideo.Factory>, Provider<StreamingVideo.Factory>
{
  private cs<Provider<StreamingVideo>> a;
  private cs<Video.Factory> b;
  
  public StreamingVideo$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingVideo$Factory", "members/com.vungle.publisher.db.model.StreamingVideo$Factory", true, StreamingVideo.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.StreamingVideo>", StreamingVideo.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.Video$Factory", StreamingVideo.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingVideo.Factory get()
  {
    StreamingVideo.Factory localFactory = new StreamingVideo.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(StreamingVideo.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingVideo$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */