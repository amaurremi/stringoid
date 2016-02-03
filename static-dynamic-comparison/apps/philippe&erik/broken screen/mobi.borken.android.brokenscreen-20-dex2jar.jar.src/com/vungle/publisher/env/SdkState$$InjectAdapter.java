package com.vungle.publisher.env;

import android.content.Context;
import android.content.SharedPreferences;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import java.util.Set;
import javax.inject.Provider;

public final class SdkState$$InjectAdapter
  extends cs<SdkState>
  implements cp<SdkState>, Provider<SdkState>
{
  private cs<Context> a;
  private cs<di> b;
  private cs<Provider<SdkState.PlayAdEndEventListener>> c;
  private cs<Class> d;
  private cs<SharedPreferences> e;
  
  public SdkState$$InjectAdapter()
  {
    super("com.vungle.publisher.env.SdkState", "members/com.vungle.publisher.env.SdkState", true, SdkState.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", SdkState.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.di", SdkState.class, getClass().getClassLoader());
    this.c = paramcy.a("javax.inject.Provider<com.vungle.publisher.env.SdkState$PlayAdEndEventListener>", SdkState.class, getClass().getClassLoader());
    this.d = paramcy.a("@com.vungle.publisher.inject.annotations.VungleServiceClass()/java.lang.Class", SdkState.class, getClass().getClassLoader());
    this.e = paramcy.a("@com.vungle.publisher.inject.annotations.SdkStateSharedPreferences()/android.content.SharedPreferences", SdkState.class, getClass().getClassLoader());
  }
  
  public final SdkState get()
  {
    SdkState localSdkState = new SdkState();
    injectMembers(localSdkState);
    return localSdkState;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
  }
  
  public final void injectMembers(SdkState paramSdkState)
  {
    paramSdkState.a = ((Context)this.a.get());
    paramSdkState.b = ((di)this.b.get());
    paramSdkState.c = ((Provider)this.c.get());
    paramSdkState.d = ((Class)this.d.get());
    paramSdkState.h = ((SharedPreferences)this.e.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/SdkState$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */