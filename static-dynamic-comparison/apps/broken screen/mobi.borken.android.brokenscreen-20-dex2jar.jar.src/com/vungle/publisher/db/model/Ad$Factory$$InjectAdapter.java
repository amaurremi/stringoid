package com.vungle.publisher.db.model;

import com.vungle.publisher.ar.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;

public final class Ad$Factory$$InjectAdapter
  extends cs<Ad.Factory>
  implements cp<Ad.Factory>
{
  private cs<EventTracking.Factory> a;
  private cs<ar.a> b;
  
  public Ad$Factory$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.db.model.Ad$Factory", false, Ad.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.EventTracking$Factory", Ad.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.BaseModel$Factory", Ad.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(Ad.Factory paramFactory)
  {
    paramFactory.a = ((EventTracking.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/Ad$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */