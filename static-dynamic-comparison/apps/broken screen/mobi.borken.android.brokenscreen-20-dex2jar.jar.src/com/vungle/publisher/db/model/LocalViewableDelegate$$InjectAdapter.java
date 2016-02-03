package com.vungle.publisher.db.model;

import com.vungle.publisher.bc;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import com.vungle.publisher.net.http.DownloadHttpGateway;
import java.util.Set;
import javax.inject.Provider;

public final class LocalViewableDelegate$$InjectAdapter
  extends cs<LocalViewableDelegate>
  implements cp<LocalViewableDelegate>, Provider<LocalViewableDelegate>
{
  private cs<DownloadHttpGateway> a;
  private cs<bc> b;
  private cs<di> c;
  
  public LocalViewableDelegate$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalViewableDelegate", "members/com.vungle.publisher.db.model.LocalViewableDelegate", false, LocalViewableDelegate.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.DownloadHttpGateway", LocalViewableDelegate.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.bc", LocalViewableDelegate.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.di", LocalViewableDelegate.class, getClass().getClassLoader());
  }
  
  public final LocalViewableDelegate get()
  {
    LocalViewableDelegate localLocalViewableDelegate = new LocalViewableDelegate();
    injectMembers(localLocalViewableDelegate);
    return localLocalViewableDelegate;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(LocalViewableDelegate paramLocalViewableDelegate)
  {
    paramLocalViewableDelegate.e = ((DownloadHttpGateway)this.a.get());
    paramLocalViewableDelegate.f = ((bc)this.b.get());
    paramLocalViewableDelegate.g = ((di)this.c.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalViewableDelegate$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */