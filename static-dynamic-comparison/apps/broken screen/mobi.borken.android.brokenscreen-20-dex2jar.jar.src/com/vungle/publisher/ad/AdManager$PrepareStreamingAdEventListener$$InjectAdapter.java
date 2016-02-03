package com.vungle.publisher.ad;

import com.vungle.publisher.bh;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.db.model.StreamingAd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class AdManager$PrepareStreamingAdEventListener$$InjectAdapter
  extends cs<AdManager.PrepareStreamingAdEventListener>
  implements cp<AdManager.PrepareStreamingAdEventListener>, Provider<AdManager.PrepareStreamingAdEventListener>
{
  private cs<StreamingAd.Factory> a;
  private cs<bh> b;
  
  public AdManager$PrepareStreamingAdEventListener$$InjectAdapter()
  {
    super("com.vungle.publisher.ad.AdManager$PrepareStreamingAdEventListener", "members/com.vungle.publisher.ad.AdManager$PrepareStreamingAdEventListener", false, AdManager.PrepareStreamingAdEventListener.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.StreamingAd$Factory", AdManager.PrepareStreamingAdEventListener.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.event.BaseEventListener", AdManager.PrepareStreamingAdEventListener.class, getClass().getClassLoader(), false);
  }
  
  public final AdManager.PrepareStreamingAdEventListener get()
  {
    AdManager.PrepareStreamingAdEventListener localPrepareStreamingAdEventListener = new AdManager.PrepareStreamingAdEventListener();
    injectMembers(localPrepareStreamingAdEventListener);
    return localPrepareStreamingAdEventListener;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(AdManager.PrepareStreamingAdEventListener paramPrepareStreamingAdEventListener)
  {
    paramPrepareStreamingAdEventListener.e = ((StreamingAd.Factory)this.a.get());
    this.b.injectMembers(paramPrepareStreamingAdEventListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */