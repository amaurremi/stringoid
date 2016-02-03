package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.message.SessionEnd.Factory;
import java.util.Set;
import javax.inject.Provider;

public final class SessionEndHttpRequest$Factory$$InjectAdapter
  extends cs<SessionEndHttpRequest.Factory>
  implements cp<SessionEndHttpRequest.Factory>, Provider<SessionEndHttpRequest.Factory>
{
  private cs<SessionEnd.Factory> a;
  private cs<ProtocolHttpRequest.a> b;
  
  public SessionEndHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.SessionEndHttpRequest$Factory", "members/com.vungle.publisher.protocol.SessionEndHttpRequest$Factory", true, SessionEndHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.message.SessionEnd$Factory", SessionEndHttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", SessionEndHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final SessionEndHttpRequest.Factory get()
  {
    SessionEndHttpRequest.Factory localFactory = new SessionEndHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(SessionEndHttpRequest.Factory paramFactory)
  {
    paramFactory.f = ((SessionEnd.Factory)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionEndHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */