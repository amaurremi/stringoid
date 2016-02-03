package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAd$$InjectAdapter
  extends cs<LocalAd>
  implements cp<LocalAd>, Provider<LocalAd>
{
  private cs<LocalAd.Factory> a;
  private cs<Ad> b;
  
  public LocalAd$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAd", "members/com.vungle.publisher.db.model.LocalAd", false, LocalAd.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAd$Factory", LocalAd.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.Ad", LocalAd.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAd get()
  {
    LocalAd localLocalAd = new LocalAd();
    injectMembers(localLocalAd);
    return localLocalAd;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(LocalAd paramLocalAd)
  {
    paramLocalAd.x = ((LocalAd.Factory)this.a.get());
    this.b.injectMembers(paramLocalAd);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAd$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */