package com.vungle.publisher.display.view;

import android.media.AudioManager;
import com.vungle.publisher.audio.VolumeChangeContentObserver.Factory;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import com.vungle.publisher.image.BitmapFactory;
import java.util.Set;
import javax.inject.Provider;

public final class VideoFragment$$InjectAdapter
  extends cs<VideoFragment>
  implements cp<VideoFragment>, Provider<VideoFragment>
{
  private cs<AlertDialogFactory> a;
  private cs<AudioManager> b;
  private cs<BitmapFactory> c;
  private cs<CountdownProgressView.Factory> d;
  private cs<DisplayUtils> e;
  private cs<di> f;
  private cs<VolumeChangeContentObserver.Factory> g;
  private cs<AdFragment> h;
  
  public VideoFragment$$InjectAdapter()
  {
    super("com.vungle.publisher.display.view.VideoFragment", "members/com.vungle.publisher.display.view.VideoFragment", false, VideoFragment.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.display.view.AlertDialogFactory", VideoFragment.class, getClass().getClassLoader());
    this.b = paramcy.a("android.media.AudioManager", VideoFragment.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.image.BitmapFactory", VideoFragment.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.display.view.CountdownProgressView$Factory", VideoFragment.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.display.view.DisplayUtils", VideoFragment.class, getClass().getClassLoader());
    this.f = paramcy.a("com.vungle.publisher.di", VideoFragment.class, getClass().getClassLoader());
    this.g = paramcy.a("com.vungle.publisher.audio.VolumeChangeContentObserver$Factory", VideoFragment.class, getClass().getClassLoader());
    this.h = paramcy.a("members/com.vungle.publisher.display.view.AdFragment", VideoFragment.class, getClass().getClassLoader(), false);
  }
  
  public final VideoFragment get()
  {
    VideoFragment localVideoFragment = new VideoFragment();
    injectMembers(localVideoFragment);
    return localVideoFragment;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
    paramSet2.add(this.f);
    paramSet2.add(this.g);
    paramSet2.add(this.h);
  }
  
  public final void injectMembers(VideoFragment paramVideoFragment)
  {
    paramVideoFragment.k = ((AlertDialogFactory)this.a.get());
    paramVideoFragment.l = ((AudioManager)this.b.get());
    paramVideoFragment.m = ((BitmapFactory)this.c.get());
    paramVideoFragment.n = ((CountdownProgressView.Factory)this.d.get());
    paramVideoFragment.o = ((DisplayUtils)this.e.get());
    paramVideoFragment.p = ((di)this.f.get());
    paramVideoFragment.q = ((VolumeChangeContentObserver.Factory)this.g.get());
    this.h.injectMembers(paramVideoFragment);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/VideoFragment$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */