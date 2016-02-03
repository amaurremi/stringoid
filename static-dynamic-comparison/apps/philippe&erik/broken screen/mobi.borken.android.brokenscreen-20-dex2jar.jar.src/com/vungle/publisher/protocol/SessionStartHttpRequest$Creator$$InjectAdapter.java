package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class SessionStartHttpRequest$Creator$$InjectAdapter
  extends cs<SessionStartHttpRequest.Creator>
  implements cp<SessionStartHttpRequest.Creator>, Provider<SessionStartHttpRequest.Creator>
{
  private cs<SessionStartHttpRequest.Factory> a;
  
  public SessionStartHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.SessionStartHttpRequest$Creator", "members/com.vungle.publisher.protocol.SessionStartHttpRequest$Creator", true, SessionStartHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.SessionStartHttpRequest$Factory", SessionStartHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final SessionStartHttpRequest.Creator get()
  {
    SessionStartHttpRequest.Creator localCreator = new SessionStartHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(SessionStartHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((SessionStartHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionStartHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */