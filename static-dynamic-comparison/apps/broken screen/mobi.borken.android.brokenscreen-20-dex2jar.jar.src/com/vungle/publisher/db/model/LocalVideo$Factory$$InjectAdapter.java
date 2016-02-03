package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalVideo$Factory$$InjectAdapter
  extends cs<LocalVideo.Factory>
  implements cp<LocalVideo.Factory>, Provider<LocalVideo.Factory>
{
  private cs<Provider<LocalVideo>> a;
  private cs<LocalViewableDelegate.Factory> b;
  private cs<Video.Factory> c;
  
  public LocalVideo$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalVideo$Factory", "members/com.vungle.publisher.db.model.LocalVideo$Factory", true, LocalVideo.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.LocalVideo>", LocalVideo.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalViewableDelegate$Factory", LocalVideo.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.Video$Factory", LocalVideo.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final LocalVideo.Factory get()
  {
    LocalVideo.Factory localFactory = new LocalVideo.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalVideo.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    paramFactory.c = ((LocalViewableDelegate.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalVideo$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */