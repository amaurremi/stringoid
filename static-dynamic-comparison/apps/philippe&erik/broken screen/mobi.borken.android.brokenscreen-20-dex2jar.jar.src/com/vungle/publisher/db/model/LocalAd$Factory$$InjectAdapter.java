package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAd$Factory$$InjectAdapter
  extends cs<LocalAd.Factory>
  implements cp<LocalAd.Factory>, Provider<LocalAd.Factory>
{
  private cs<Provider<String>> a;
  private cs<LocalArchive.Factory> b;
  private cs<di> c;
  private cs<Provider<LocalAd>> d;
  private cs<LocalVideo.Factory> e;
  private cs<Ad.Factory> f;
  
  public LocalAd$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAd$Factory", "members/com.vungle.publisher.db.model.LocalAd$Factory", true, LocalAd.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("@com.vungle.publisher.inject.annotations.AdTempDirectory()/javax.inject.Provider<java.lang.String>", LocalAd.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalArchive$Factory", LocalAd.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.di", LocalAd.Factory.class, getClass().getClassLoader());
    this.d = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.LocalAd>", LocalAd.Factory.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.db.model.LocalVideo$Factory", LocalAd.Factory.class, getClass().getClassLoader());
    this.f = paramcy.a("members/com.vungle.publisher.db.model.Ad$Factory", LocalAd.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAd.Factory get()
  {
    LocalAd.Factory localFactory = new LocalAd.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
    paramSet2.add(this.f);
  }
  
  public final void injectMembers(LocalAd.Factory paramFactory)
  {
    paramFactory.c = ((Provider)this.a.get());
    paramFactory.d = ((LocalArchive.Factory)this.b.get());
    paramFactory.e = ((di)this.c.get());
    paramFactory.f = ((Provider)this.d.get());
    paramFactory.g = ((LocalVideo.Factory)this.e.get());
    this.f.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */