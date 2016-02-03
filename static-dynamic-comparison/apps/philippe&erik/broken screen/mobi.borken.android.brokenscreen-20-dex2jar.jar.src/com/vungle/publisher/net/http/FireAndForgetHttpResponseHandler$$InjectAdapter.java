package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class FireAndForgetHttpResponseHandler$$InjectAdapter
  extends cs<FireAndForgetHttpResponseHandler>
  implements cp<FireAndForgetHttpResponseHandler>, Provider<FireAndForgetHttpResponseHandler>
{
  private cs<MaxRetryAgeHttpResponseHandler> a;
  
  public FireAndForgetHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", "members/com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", true, FireAndForgetHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.net.http.MaxRetryAgeHttpResponseHandler", FireAndForgetHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final FireAndForgetHttpResponseHandler get()
  {
    FireAndForgetHttpResponseHandler localFireAndForgetHttpResponseHandler = new FireAndForgetHttpResponseHandler();
    injectMembers(localFireAndForgetHttpResponseHandler);
    return localFireAndForgetHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(FireAndForgetHttpResponseHandler paramFireAndForgetHttpResponseHandler)
  {
    this.a.injectMembers(paramFireAndForgetHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/FireAndForgetHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */