package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import java.util.Set;
import javax.inject.Provider;

public final class UnfilledAdHttpTransactionFactory$$InjectAdapter
  extends cs<UnfilledAdHttpTransactionFactory>
  implements cp<UnfilledAdHttpTransactionFactory>, Provider<UnfilledAdHttpTransactionFactory>
{
  private cs<UnfilledAdHttpRequest.Factory> a;
  private cs<FireAndForgetHttpResponseHandler> b;
  
  public UnfilledAdHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.UnfilledAdHttpTransactionFactory", "members/com.vungle.publisher.protocol.UnfilledAdHttpTransactionFactory", true, UnfilledAdHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.UnfilledAdHttpRequest$Factory", UnfilledAdHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", UnfilledAdHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final UnfilledAdHttpTransactionFactory get()
  {
    UnfilledAdHttpTransactionFactory localUnfilledAdHttpTransactionFactory = new UnfilledAdHttpTransactionFactory();
    injectMembers(localUnfilledAdHttpTransactionFactory);
    return localUnfilledAdHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(UnfilledAdHttpTransactionFactory paramUnfilledAdHttpTransactionFactory)
  {
    paramUnfilledAdHttpTransactionFactory.a = ((UnfilledAdHttpRequest.Factory)this.a.get());
    paramUnfilledAdHttpTransactionFactory.b = ((FireAndForgetHttpResponseHandler)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/UnfilledAdHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */