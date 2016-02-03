package com.vungle.publisher.db.model;

import com.vungle.publisher.ar;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class EventTracking$$InjectAdapter
  extends cs<EventTracking>
  implements cp<EventTracking>, Provider<EventTracking>
{
  private cs<EventTracking.Factory> a;
  private cs<ar> b;
  
  public EventTracking$$InjectAdapter()
  {
    super("com.vungle.publisher.db.model.EventTracking", "members/com.vungle.publisher.db.model.EventTracking", false, EventTracking.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.model.EventTracking$Factory", EventTracking.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.db.model.BaseModel", EventTracking.class, getClass().getClassLoader(), false);
  }
  
  public final EventTracking get()
  {
    EventTracking localEventTracking = new EventTracking();
    injectMembers(localEventTracking);
    return localEventTracking;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(EventTracking paramEventTracking)
  {
    paramEventTracking.d = ((EventTracking.Factory)this.a.get());
    this.b.injectMembers(paramEventTracking);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/EventTracking$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */