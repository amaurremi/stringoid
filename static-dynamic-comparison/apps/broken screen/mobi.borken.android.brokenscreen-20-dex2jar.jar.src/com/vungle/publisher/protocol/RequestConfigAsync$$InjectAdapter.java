package com.vungle.publisher.protocol;

import com.vungle.publisher.ao;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfigAsync$$InjectAdapter
  extends cs<RequestConfigAsync>
  implements cp<RequestConfigAsync>, Provider<RequestConfigAsync>
{
  private cs<RequestConfigAsync.RequestConfigRunnable> a;
  private cs<ao> b;
  
  public RequestConfigAsync$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestConfigAsync", "members/com.vungle.publisher.protocol.RequestConfigAsync", true, RequestConfigAsync.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.RequestConfigAsync$RequestConfigRunnable", RequestConfigAsync.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.async.ExecutorAsync", RequestConfigAsync.class, getClass().getClassLoader(), false);
  }
  
  public final RequestConfigAsync get()
  {
    RequestConfigAsync localRequestConfigAsync = new RequestConfigAsync();
    injectMembers(localRequestConfigAsync);
    return localRequestConfigAsync;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestConfigAsync paramRequestConfigAsync)
  {
    paramRequestConfigAsync.b = ((RequestConfigAsync.RequestConfigRunnable)this.a.get());
    this.b.injectMembers(paramRequestConfigAsync);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigAsync$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */