package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpTransactionFactory$$InjectAdapter
  extends cs<DownloadHttpTransactionFactory>
  implements cp<DownloadHttpTransactionFactory>, Provider<DownloadHttpTransactionFactory>
{
  private cs<DownloadHttpRequest.Factory> a;
  private cs<DownloadHttpResponseHandler.Factory> b;
  
  public DownloadHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpTransactionFactory", "members/com.vungle.publisher.net.http.DownloadHttpTransactionFactory", true, DownloadHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.DownloadHttpRequest$Factory", DownloadHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.net.http.DownloadHttpResponseHandler$Factory", DownloadHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final DownloadHttpTransactionFactory get()
  {
    DownloadHttpTransactionFactory localDownloadHttpTransactionFactory = new DownloadHttpTransactionFactory();
    injectMembers(localDownloadHttpTransactionFactory);
    return localDownloadHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(DownloadHttpTransactionFactory paramDownloadHttpTransactionFactory)
  {
    paramDownloadHttpTransactionFactory.a = ((DownloadHttpRequest.Factory)this.a.get());
    paramDownloadHttpTransactionFactory.b = ((DownloadHttpResponseHandler.Factory)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */