package com.vungle.publisher.display.view;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class VideoFragment$Factory$$InjectAdapter
  extends cs<VideoFragment.Factory>
  implements cp<VideoFragment.Factory>, Provider<VideoFragment.Factory>
{
  private cs<Provider<VideoFragment>> a;
  
  public VideoFragment$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.display.view.VideoFragment$Factory", "members/com.vungle.publisher.display.view.VideoFragment$Factory", true, VideoFragment.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.display.view.VideoFragment>", VideoFragment.Factory.class, getClass().getClassLoader());
  }
  
  public final VideoFragment.Factory get()
  {
    VideoFragment.Factory localFactory = new VideoFragment.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(VideoFragment.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/VideoFragment$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */