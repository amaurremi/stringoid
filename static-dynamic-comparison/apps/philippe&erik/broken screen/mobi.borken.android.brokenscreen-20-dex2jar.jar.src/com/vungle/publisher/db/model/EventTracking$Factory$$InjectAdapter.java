package com.vungle.publisher.db.model;

import com.vungle.publisher.ar.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class EventTracking$Factory$$InjectAdapter
  extends cs<EventTracking.Factory>
  implements cp<EventTracking.Factory>, Provider<EventTracking.Factory>
{
  private cs<Provider<EventTracking>> a;
  private cs<ar.a> b;
  
  public EventTracking$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.EventTracking$Factory", "members/com.vungle.publisher.db.model.EventTracking$Factory", true, EventTracking.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.db.model.EventTracking>", EventTracking.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.BaseModel$Factory", EventTracking.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final EventTracking.Factory get()
  {
    EventTracking.Factory localFactory = new EventTracking.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(EventTracking.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/EventTracking$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */