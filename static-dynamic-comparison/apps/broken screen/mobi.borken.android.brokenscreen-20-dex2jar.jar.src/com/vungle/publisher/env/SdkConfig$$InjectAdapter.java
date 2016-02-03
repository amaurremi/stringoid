package com.vungle.publisher.env;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.event.ClientEventListenerAdapter.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class SdkConfig$$InjectAdapter
  extends cs<SdkConfig>
  implements cp<SdkConfig>, Provider<SdkConfig>
{
  private cs<ClientEventListenerAdapter.Factory> a;
  
  public SdkConfig$$InjectAdapter()
  {
    super("com.vungle.publisher.env.SdkConfig", "members/com.vungle.publisher.env.SdkConfig", true, SdkConfig.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.event.ClientEventListenerAdapter$Factory", SdkConfig.class, getClass().getClassLoader());
  }
  
  public final SdkConfig get()
  {
    SdkConfig localSdkConfig = new SdkConfig();
    injectMembers(localSdkConfig);
    return localSdkConfig;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(SdkConfig paramSdkConfig)
  {
    paramSdkConfig.e = ((ClientEventListenerAdapter.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/env/SdkConfig$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */