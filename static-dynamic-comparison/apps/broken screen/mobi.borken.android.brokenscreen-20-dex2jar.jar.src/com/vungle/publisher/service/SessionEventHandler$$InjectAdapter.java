package com.vungle.publisher.service;

import com.vungle.publisher.cg.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import java.util.Collection;
import java.util.Set;

public final class SessionEventHandler$$InjectAdapter
  extends cs<SessionEventHandler>
  implements cp<SessionEventHandler>
{
  private cs<ProtocolHttpGateway> a;
  private cs<Collection<cg.a>> b;
  private cs<BaseHandler> c;
  
  public SessionEventHandler$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.service.SessionEventHandler", false, SessionEventHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.ProtocolHttpGateway", SessionEventHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("java.util.Collection<com.vungle.publisher.service.SessionEventIntentHandler$SessionEndListener>", SessionEventHandler.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.service.BaseHandler", SessionEventHandler.class, getClass().getClassLoader(), false);
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(SessionEventHandler paramSessionEventHandler)
  {
    paramSessionEventHandler.e = ((ProtocolHttpGateway)this.a.get());
    paramSessionEventHandler.f = ((Collection)this.b.get());
    this.c.injectMembers(paramSessionEventHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/SessionEventHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */