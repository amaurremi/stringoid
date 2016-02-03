package com.vungle.publisher.net.http;

import com.vungle.publisher.bu;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpGateway$$InjectAdapter
  extends cs<DownloadHttpGateway>
  implements cp<DownloadHttpGateway>, Provider<DownloadHttpGateway>
{
  private cs<DownloadHttpTransactionFactory> a;
  private cs<bu> b;
  
  public DownloadHttpGateway$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpGateway", "members/com.vungle.publisher.net.http.DownloadHttpGateway", true, DownloadHttpGateway.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.DownloadHttpTransactionFactory", DownloadHttpGateway.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.net.http.HttpGateway", DownloadHttpGateway.class, getClass().getClassLoader(), false);
  }
  
  public final DownloadHttpGateway get()
  {
    DownloadHttpGateway localDownloadHttpGateway = new DownloadHttpGateway();
    injectMembers(localDownloadHttpGateway);
    return localDownloadHttpGateway;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(DownloadHttpGateway paramDownloadHttpGateway)
  {
    paramDownloadHttpGateway.a = ((DownloadHttpTransactionFactory)this.a.get());
    this.b.injectMembers(paramDownloadHttpGateway);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpGateway$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */