package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalVideo$$InjectAdapter
  extends cs<LocalVideo>
  implements cp<LocalVideo>, Provider<LocalVideo>
{
  private cs<LocalAd.Factory> a;
  private cs<LocalVideo.Factory> b;
  private cs<Video> c;
  
  public LocalVideo$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalVideo", "members/com.vungle.publisher.db.model.LocalVideo", false, LocalVideo.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAd$Factory", LocalVideo.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalVideo$Factory", LocalVideo.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.Video", LocalVideo.class, getClass().getClassLoader(), false);
  }
  
  public final LocalVideo get()
  {
    LocalVideo localLocalVideo = new LocalVideo();
    injectMembers(localLocalVideo);
    return localLocalVideo;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalVideo paramLocalVideo)
  {
    paramLocalVideo.g = ((LocalAd.Factory)this.a.get());
    paramLocalVideo.h = ((LocalVideo.Factory)this.b.get());
    this.c.injectMembers(paramLocalVideo);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalVideo$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */