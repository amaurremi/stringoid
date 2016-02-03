package com.vungle.publisher.audio;

import android.media.AudioManager;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class VolumeChangeContentObserver$Factory$$InjectAdapter
  extends cs<VolumeChangeContentObserver.Factory>
  implements cp<VolumeChangeContentObserver.Factory>, Provider<VolumeChangeContentObserver.Factory>
{
  private cs<AudioManager> a;
  
  public VolumeChangeContentObserver$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.audio.VolumeChangeContentObserver$Factory", "members/com.vungle.publisher.audio.VolumeChangeContentObserver$Factory", true, VolumeChangeContentObserver.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.media.AudioManager", VolumeChangeContentObserver.Factory.class, getClass().getClassLoader());
  }
  
  public final VolumeChangeContentObserver.Factory get()
  {
    VolumeChangeContentObserver.Factory localFactory = new VolumeChangeContentObserver.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(VolumeChangeContentObserver.Factory paramFactory)
  {
    paramFactory.a = ((AudioManager)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/audio/VolumeChangeContentObserver$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */