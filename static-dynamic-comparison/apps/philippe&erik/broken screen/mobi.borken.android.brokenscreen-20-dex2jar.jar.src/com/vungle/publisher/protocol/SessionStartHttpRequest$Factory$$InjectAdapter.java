package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.SessionStart.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class SessionStartHttpRequest$Factory$$InjectAdapter
  extends cs<SessionStartHttpRequest.Factory>
  implements cp<SessionStartHttpRequest.Factory>, Provider<SessionStartHttpRequest.Factory>
{
  private cs<SessionStart.Factory> a;
  private cs<ProtocolHttpRequest.a> b;
  
  public SessionStartHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.SessionStartHttpRequest$Factory", "members/com.vungle.publisher.protocol.SessionStartHttpRequest$Factory", true, SessionStartHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.SessionStart$Factory", SessionStartHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", SessionStartHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final SessionStartHttpRequest.Factory get()
  {
    SessionStartHttpRequest.Factory localFactory = new SessionStartHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(SessionStartHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((SessionStart.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionStartHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */