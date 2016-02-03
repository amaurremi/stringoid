package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import java.util.Set;
import javax.inject.Provider;

public final class SessionEndHttpTransactionFactory$$InjectAdapter
  extends cs<SessionEndHttpTransactionFactory>
  implements cp<SessionEndHttpTransactionFactory>, Provider<SessionEndHttpTransactionFactory>
{
  private cs<SessionEndHttpRequest.Factory> a;
  private cs<FireAndForgetHttpResponseHandler> b;
  
  public SessionEndHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.SessionEndHttpTransactionFactory", "members/com.vungle.publisher.protocol.SessionEndHttpTransactionFactory", true, SessionEndHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.SessionEndHttpRequest$Factory", SessionEndHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", SessionEndHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final SessionEndHttpTransactionFactory get()
  {
    SessionEndHttpTransactionFactory localSessionEndHttpTransactionFactory = new SessionEndHttpTransactionFactory();
    injectMembers(localSessionEndHttpTransactionFactory);
    return localSessionEndHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(SessionEndHttpTransactionFactory paramSessionEndHttpTransactionFactory)
  {
    paramSessionEndHttpTransactionFactory.a = ((SessionEndHttpRequest.Factory)this.a.get());
    paramSessionEndHttpTransactionFactory.b = ((FireAndForgetHttpResponseHandler)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionEndHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */