package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import java.util.Set;
import javax.inject.Provider;

public final class SessionStartHttpTransactionFactory$$InjectAdapter
  extends cs<SessionStartHttpTransactionFactory>
  implements cp<SessionStartHttpTransactionFactory>, Provider<SessionStartHttpTransactionFactory>
{
  private cs<SessionStartHttpRequest.Factory> a;
  private cs<FireAndForgetHttpResponseHandler> b;
  
  public SessionStartHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.SessionStartHttpTransactionFactory", "members/com.vungle.publisher.protocol.SessionStartHttpTransactionFactory", true, SessionStartHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.SessionStartHttpRequest$Factory", SessionStartHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", SessionStartHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final SessionStartHttpTransactionFactory get()
  {
    SessionStartHttpTransactionFactory localSessionStartHttpTransactionFactory = new SessionStartHttpTransactionFactory();
    injectMembers(localSessionStartHttpTransactionFactory);
    return localSessionStartHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(SessionStartHttpTransactionFactory paramSessionStartHttpTransactionFactory)
  {
    paramSessionStartHttpTransactionFactory.a = ((SessionStartHttpRequest.Factory)this.a.get());
    paramSessionStartHttpTransactionFactory.b = ((FireAndForgetHttpResponseHandler)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionStartHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */