package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpRequest$Factory$$InjectAdapter
  extends cs<DownloadHttpRequest.Factory>
  implements cp<DownloadHttpRequest.Factory>, Provider<DownloadHttpRequest.Factory>
{
  private cs<HttpRequest.Factory> a;
  
  public DownloadHttpRequest$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpRequest$Factory", "members/com.vungle.publisher.net.http.DownloadHttpRequest$Factory", true, DownloadHttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.net.http.HttpRequest$Factory", DownloadHttpRequest.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final DownloadHttpRequest.Factory get()
  {
    DownloadHttpRequest.Factory localFactory = new DownloadHttpRequest.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(DownloadHttpRequest.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */