package com.vungle.publisher.net.http;

import com.vungle.publisher.ad.AdPreparer;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpResponseHandler$$InjectAdapter
  extends cs<DownloadHttpResponseHandler>
  implements cp<DownloadHttpResponseHandler>, Provider<DownloadHttpResponseHandler>
{
  private cs<AdPreparer> a;
  private cs<di> b;
  private cs<MaxRetryAgeHttpResponseHandler> c;
  
  public DownloadHttpResponseHandler$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpResponseHandler", "members/com.vungle.publisher.net.http.DownloadHttpResponseHandler", false, DownloadHttpResponseHandler.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdPreparer", DownloadHttpResponseHandler.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.di", DownloadHttpResponseHandler.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.net.http.MaxRetryAgeHttpResponseHandler", DownloadHttpResponseHandler.class, getClass().getClassLoader(), false);
  }
  
  public final DownloadHttpResponseHandler get()
  {
    DownloadHttpResponseHandler localDownloadHttpResponseHandler = new DownloadHttpResponseHandler();
    injectMembers(localDownloadHttpResponseHandler);
    return localDownloadHttpResponseHandler;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(DownloadHttpResponseHandler paramDownloadHttpResponseHandler)
  {
    paramDownloadHttpResponseHandler.d = ((AdPreparer)this.a.get());
    paramDownloadHttpResponseHandler.e = ((di)this.b.get());
    this.c.injectMembers(paramDownloadHttpResponseHandler);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpResponseHandler$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */