package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class SessionEndHttpRequest$Creator$$InjectAdapter
  extends cs<SessionEndHttpRequest.Creator>
  implements cp<SessionEndHttpRequest.Creator>, Provider<SessionEndHttpRequest.Creator>
{
  private cs<SessionEndHttpRequest.Factory> a;
  
  public SessionEndHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.SessionEndHttpRequest$Creator", "members/com.vungle.publisher.protocol.SessionEndHttpRequest$Creator", true, SessionEndHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.SessionEndHttpRequest$Factory", SessionEndHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final SessionEndHttpRequest.Creator get()
  {
    SessionEndHttpRequest.Creator localCreator = new SessionEndHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(SessionEndHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((SessionEndHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionEndHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */