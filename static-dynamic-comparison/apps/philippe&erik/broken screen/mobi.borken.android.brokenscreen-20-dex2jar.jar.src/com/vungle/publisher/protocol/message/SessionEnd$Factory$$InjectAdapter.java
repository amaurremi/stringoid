package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class SessionEnd$Factory$$InjectAdapter
  extends cs<SessionEnd.Factory>
  implements cp<SessionEnd.Factory>, Provider<SessionEnd.Factory>
{
  private cs<SessionStart.Factory> a;
  
  public SessionEnd$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.SessionEnd$Factory", "members/com.vungle.publisher.protocol.message.SessionEnd$Factory", true, SessionEnd.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.SessionStart$Factory", SessionEnd.Factory.class, getClass().getClassLoader());
  }
  
  public final SessionEnd.Factory get()
  {
    SessionEnd.Factory localFactory = new SessionEnd.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(SessionEnd.Factory paramFactory)
  {
    paramFactory.a = ((SessionStart.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/SessionEnd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */