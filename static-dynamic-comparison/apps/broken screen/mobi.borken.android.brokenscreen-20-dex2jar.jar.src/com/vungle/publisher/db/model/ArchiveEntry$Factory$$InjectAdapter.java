package com.vungle.publisher.db.model;

import com.vungle.publisher.ar.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ArchiveEntry$Factory$$InjectAdapter
  extends cs<ArchiveEntry.Factory>
  implements cp<ArchiveEntry.Factory>, Provider<ArchiveEntry.Factory>
{
  private cs<Provider<ArchiveEntry>> a;
  private cs<ar.a> b;
  
  public ArchiveEntry$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.ArchiveEntry$Factory", "members/com.vungle.publisher.db.model.ArchiveEntry$Factory", true, ArchiveEntry.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.ArchiveEntry>", ArchiveEntry.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.BaseModel$Factory", ArchiveEntry.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final ArchiveEntry.Factory get()
  {
    ArchiveEntry.Factory localFactory = new ArchiveEntry.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ArchiveEntry.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/ArchiveEntry$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */