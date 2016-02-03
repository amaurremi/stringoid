package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class SessionStart$Factory$$InjectAdapter
  extends cs<SessionStart.Factory>
  implements cp<SessionStart.Factory>, Provider<SessionStart.Factory>
{
  private cs<bc> a;
  private cs<be> b;
  
  public SessionStart$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.SessionStart$Factory", "members/com.vungle.publisher.protocol.message.SessionStart$Factory", true, SessionStart.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.bc", SessionStart.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.be", SessionStart.Factory.class, getClass().getClassLoader());
  }
  
  public final SessionStart.Factory get()
  {
    SessionStart.Factory localFactory = new SessionStart.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(SessionStart.Factory paramFactory)
  {
    paramFactory.a = ((bc)this.a.get());
    paramFactory.b = ((be)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/SessionStart$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */