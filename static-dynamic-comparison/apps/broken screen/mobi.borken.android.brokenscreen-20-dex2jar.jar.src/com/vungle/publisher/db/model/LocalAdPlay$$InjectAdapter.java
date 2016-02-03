package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalAdPlay$$InjectAdapter
  extends cs<LocalAdPlay>
  implements cp<LocalAdPlay>, Provider<LocalAdPlay>
{
  private cs<LocalAdPlay.Factory> a;
  private cs<LocalAdReportEvent.Factory> b;
  private cs<AdPlay> c;
  
  public LocalAdPlay$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalAdPlay", "members/com.vungle.publisher.db.model.LocalAdPlay", false, LocalAdPlay.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.LocalAdPlay$Factory", LocalAdPlay.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.model.LocalAdReportEvent$Factory", LocalAdPlay.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.db.model.AdPlay", LocalAdPlay.class, getClass().getClassLoader(), false);
  }
  
  public final LocalAdPlay get()
  {
    LocalAdPlay localLocalAdPlay = new LocalAdPlay();
    injectMembers(localLocalAdPlay);
    return localLocalAdPlay;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalAdPlay paramLocalAdPlay)
  {
    paramLocalAdPlay.e = ((LocalAdPlay.Factory)this.a.get());
    paramLocalAdPlay.f = ((LocalAdReportEvent.Factory)this.b.get());
    this.c.injectMembers(paramLocalAdPlay);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdPlay$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */