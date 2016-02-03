package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class StreamingVideo$$InjectAdapter
  extends cs<StreamingVideo>
  implements cp<StreamingVideo>, Provider<StreamingVideo>
{
  private cs<StreamingAd.Factory> a;
  private cs<StreamingVideo.Factory> b;
  private cs<Video> c;
  
  public StreamingVideo$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.StreamingVideo", "members/com.vungle.publisher.db.model.StreamingVideo", false, StreamingVideo.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAd$Factory", StreamingVideo.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.StreamingVideo$Factory", StreamingVideo.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.Video", StreamingVideo.class, getClass().getClassLoader(), false);
  }
  
  public final StreamingVideo get()
  {
    StreamingVideo localStreamingVideo = new StreamingVideo();
    injectMembers(localStreamingVideo);
    return localStreamingVideo;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(StreamingVideo paramStreamingVideo)
  {
    paramStreamingVideo.e = ((StreamingAd.Factory)this.a.get());
    paramStreamingVideo.f = ((StreamingVideo.Factory)this.b.get());
    this.c.injectMembers(paramStreamingVideo);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingVideo$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */