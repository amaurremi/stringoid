package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class InfiniteRetryHttpResponseHandler$$InjectAdapter
  extends cs<InfiniteRetryHttpResponseHandler>
  implements cp<InfiniteRetryHttpResponseHandler>, Provider<InfiniteRetryHttpResponseHandler>
{
  private cs<MaxRetryAgeHttpResponseHandler> a;
  
  public InfiniteRetryHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler", "members/com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler", true, InfiniteRetryHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.net.http.MaxRetryAgeHttpResponseHandler", InfiniteRetryHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final InfiniteRetryHttpResponseHandler get()
  {
    InfiniteRetryHttpResponseHandler localInfiniteRetryHttpResponseHandler = new InfiniteRetryHttpResponseHandler();
    injectMembers(localInfiniteRetryHttpResponseHandler);
    return localInfiniteRetryHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(InfiniteRetryHttpResponseHandler paramInfiniteRetryHttpResponseHandler)
  {
    this.a.injectMembers(paramInfiniteRetryHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/InfiniteRetryHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */