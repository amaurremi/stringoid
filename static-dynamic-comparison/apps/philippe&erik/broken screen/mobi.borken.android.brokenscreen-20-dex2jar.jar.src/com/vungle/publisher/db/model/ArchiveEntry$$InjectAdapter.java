package com.vungle.publisher.db.model;

import com.vungle.publisher.ar;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ArchiveEntry$$InjectAdapter
  extends cs<ArchiveEntry>
  implements cp<ArchiveEntry>, Provider<ArchiveEntry>
{
  private cs<ArchiveEntry.Factory> a;
  private cs<LocalArchive.Factory> b;
  private cs<ar> c;
  
  public ArchiveEntry$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.ArchiveEntry", "members/com.vungle.publisher.db.model.ArchiveEntry", false, ArchiveEntry.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.ArchiveEntry$Factory", ArchiveEntry.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalArchive$Factory", ArchiveEntry.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.BaseModel", ArchiveEntry.class, getClass().getClassLoader(), false);
  }
  
  public final ArchiveEntry get()
  {
    ArchiveEntry localArchiveEntry = new ArchiveEntry();
    injectMembers(localArchiveEntry);
    return localArchiveEntry;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(ArchiveEntry paramArchiveEntry)
  {
    paramArchiveEntry.d = ((ArchiveEntry.Factory)this.a.get());
    paramArchiveEntry.e = ((LocalArchive.Factory)this.b.get());
    this.c.injectMembers(paramArchiveEntry);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/ArchiveEntry$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */