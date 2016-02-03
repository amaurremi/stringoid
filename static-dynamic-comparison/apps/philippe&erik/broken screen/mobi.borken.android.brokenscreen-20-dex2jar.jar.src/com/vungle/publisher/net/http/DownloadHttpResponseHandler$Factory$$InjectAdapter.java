package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpResponseHandler$Factory$$InjectAdapter
  extends cs<DownloadHttpResponseHandler.Factory>
  implements cp<DownloadHttpResponseHandler.Factory>, Provider<DownloadHttpResponseHandler.Factory>
{
  private cs<Provider<DownloadHttpResponseHandler>> a;
  
  public DownloadHttpResponseHandler$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpResponseHandler$Factory", "members/com.vungle.publisher.net.http.DownloadHttpResponseHandler$Factory", true, DownloadHttpResponseHandler.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.net.http.DownloadHttpResponseHandler>", DownloadHttpResponseHandler.Factory.class, getClass().getClassLoader());
  }
  
  public final DownloadHttpResponseHandler.Factory get()
  {
    DownloadHttpResponseHandler.Factory localFactory = new DownloadHttpResponseHandler.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(DownloadHttpResponseHandler.Factory paramFactory)
  {
    paramFactory.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpResponseHandler$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */