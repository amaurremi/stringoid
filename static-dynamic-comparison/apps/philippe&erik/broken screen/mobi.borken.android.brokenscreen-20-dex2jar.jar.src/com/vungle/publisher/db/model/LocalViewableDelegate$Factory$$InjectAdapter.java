package com.vungle.publisher.db.model;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class LocalViewableDelegate$Factory$$InjectAdapter
  extends cs<LocalViewableDelegate.Factory>
  implements cp<LocalViewableDelegate.Factory>, Provider<LocalViewableDelegate.Factory>
{
  private cs<Provider<LocalViewableDelegate>> a;
  
  public LocalViewableDelegate$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.LocalViewableDelegate$Factory", "members/com.vungle.publisher.db.model.LocalViewableDelegate$Factory", true, LocalViewableDelegate.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.LocalViewableDelegate>", LocalViewableDelegate.Factory.class, getClass().getClassLoader());
  }
  
  public final LocalViewableDelegate.Factory get()
  {
    LocalViewableDelegate.Factory localFactory = new LocalViewableDelegate.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(LocalViewableDelegate.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalViewableDelegate$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */