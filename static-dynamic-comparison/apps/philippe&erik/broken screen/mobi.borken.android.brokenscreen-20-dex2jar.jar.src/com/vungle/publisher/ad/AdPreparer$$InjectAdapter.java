package com.vungle.publisher.ad;

import android.content.Context;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class AdPreparer$$InjectAdapter
  extends cs<AdPreparer>
  implements cp<AdPreparer>, Provider<AdPreparer>
{
  private cs<Context> a;
  private cs<Class> b;
  
  public AdPreparer$$InjectAdapter()
  {
    super("com.vungle.publisher.ad.AdPreparer", "members/com.vungle.publisher.ad.AdPreparer", true, AdPreparer.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", AdPreparer.class, getClass().getClassLoader());
    this.b = paramcy.a("@com.vungle.publisher.inject.annotations.VungleServiceClass()/java.lang.Class", AdPreparer.class, getClass().getClassLoader());
  }
  
  public final AdPreparer get()
  {
    AdPreparer localAdPreparer = new AdPreparer();
    injectMembers(localAdPreparer);
    return localAdPreparer;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(AdPreparer paramAdPreparer)
  {
    paramAdPreparer.a = ((Context)this.a.get());
    paramAdPreparer.b = ((Class)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ad/AdPreparer$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */