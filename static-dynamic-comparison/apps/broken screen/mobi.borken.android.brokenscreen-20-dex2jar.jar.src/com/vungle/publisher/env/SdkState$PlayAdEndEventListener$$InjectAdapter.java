package com.vungle.publisher.env;

import com.vungle.publisher.bh;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class SdkState$PlayAdEndEventListener$$InjectAdapter
  extends cs<SdkState.PlayAdEndEventListener>
  implements cp<SdkState.PlayAdEndEventListener>, Provider<SdkState.PlayAdEndEventListener>
{
  private cs<SdkState> a;
  private cs<bh> b;
  
  public SdkState$PlayAdEndEventListener$$InjectAdapter()
  {
    super("com.vungle.publisher.env.SdkState$PlayAdEndEventListener", "members/com.vungle.publisher.env.SdkState$PlayAdEndEventListener", true, SdkState.PlayAdEndEventListener.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.env.SdkState", SdkState.PlayAdEndEventListener.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.event.BaseEventListener", SdkState.PlayAdEndEventListener.class, getClass().getClassLoader(), false);
  }
  
  public final SdkState.PlayAdEndEventListener get()
  {
    SdkState.PlayAdEndEventListener localPlayAdEndEventListener = new SdkState.PlayAdEndEventListener();
    injectMembers(localPlayAdEndEventListener);
    return localPlayAdEndEventListener;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(SdkState.PlayAdEndEventListener paramPlayAdEndEventListener)
  {
    paramPlayAdEndEventListener.a = ((SdkState)this.a.get());
    this.b.injectMembers(paramPlayAdEndEventListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/SdkState$PlayAdEndEventListener$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */