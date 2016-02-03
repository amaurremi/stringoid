package com.vungle.publisher.env;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class SdkState$SessionEndListener$$InjectAdapter
  extends cs<SdkState.SessionEndListener>
  implements cp<SdkState.SessionEndListener>, Provider<SdkState.SessionEndListener>
{
  private cs<SdkState> a;
  
  public SdkState$SessionEndListener$$InjectAdapter()
  {
    super("com.vungle.publisher.env.SdkState$SessionEndListener", "members/com.vungle.publisher.env.SdkState$SessionEndListener", true, SdkState.SessionEndListener.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.env.SdkState", SdkState.SessionEndListener.class, getClass().getClassLoader());
  }
  
  public final SdkState.SessionEndListener get()
  {
    SdkState.SessionEndListener localSessionEndListener = new SdkState.SessionEndListener();
    injectMembers(localSessionEndListener);
    return localSessionEndListener;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(SdkState.SessionEndListener paramSessionEndListener)
  {
    paramSessionEndListener.a = ((SdkState)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/SdkState$SessionEndListener$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */