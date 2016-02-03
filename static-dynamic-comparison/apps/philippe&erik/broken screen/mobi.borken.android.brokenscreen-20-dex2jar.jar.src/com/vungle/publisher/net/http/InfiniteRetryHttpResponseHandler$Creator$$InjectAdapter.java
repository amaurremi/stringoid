package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class InfiniteRetryHttpResponseHandler$Creator$$InjectAdapter
  extends cs<InfiniteRetryHttpResponseHandler.Creator>
  implements cp<InfiniteRetryHttpResponseHandler.Creator>, Provider<InfiniteRetryHttpResponseHandler.Creator>
{
  private cs<InfiniteRetryHttpResponseHandler> a;
  
  public InfiniteRetryHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler$Creator", "members/com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler$Creator", true, InfiniteRetryHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler", InfiniteRetryHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final InfiniteRetryHttpResponseHandler.Creator get()
  {
    InfiniteRetryHttpResponseHandler.Creator localCreator = new InfiniteRetryHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(InfiniteRetryHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((InfiniteRetryHttpResponseHandler)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/InfiniteRetryHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */