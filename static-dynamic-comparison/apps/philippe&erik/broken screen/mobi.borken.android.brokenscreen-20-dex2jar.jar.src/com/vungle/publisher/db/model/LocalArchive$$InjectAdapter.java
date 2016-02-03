package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalArchive$$InjectAdapter
  extends cs<LocalArchive>
  implements cp<LocalArchive>, Provider<LocalArchive>
{
  private cs<LocalArchive.Factory> a;
  private cs<ArchiveEntry.Factory> b;
  private cs<LocalAd.Factory> c;
  private cs<LocalViewableDelegate> d;
  private cs<BaseViewable> e;
  
  public LocalArchive$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalArchive", "members/com.vungle.publisher.db.model.LocalArchive", false, LocalArchive.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalArchive$Factory", LocalArchive.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.ArchiveEntry$Factory", LocalArchive.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.db.model.LocalAd$Factory", LocalArchive.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.db.model.LocalViewableDelegate", LocalArchive.class, getClass().getClassLoader());
    this.e = paramcy.a("members/com.vungle.publisher.db.model.BaseViewable", LocalArchive.class, getClass().getClassLoader(), false);
  }
  
  public final LocalArchive get()
  {
    LocalArchive localLocalArchive = new LocalArchive();
    injectMembers(localLocalArchive);
    return localLocalArchive;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
  }
  
  public final void injectMembers(LocalArchive paramLocalArchive)
  {
    paramLocalArchive.i = ((LocalArchive.Factory)this.a.get());
    paramLocalArchive.j = ((ArchiveEntry.Factory)this.b.get());
    paramLocalArchive.k = ((LocalAd.Factory)this.c.get());
    paramLocalArchive.l = ((LocalViewableDelegate)this.d.get());
    this.e.injectMembers(paramLocalArchive);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalArchive$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */