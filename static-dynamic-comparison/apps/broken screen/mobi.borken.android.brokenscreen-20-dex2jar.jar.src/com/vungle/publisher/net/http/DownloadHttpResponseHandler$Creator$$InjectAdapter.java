package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpResponseHandler$Creator$$InjectAdapter
  extends cs<DownloadHttpResponseHandler.Creator>
  implements cp<DownloadHttpResponseHandler.Creator>, Provider<DownloadHttpResponseHandler.Creator>
{
  private cs<Provider<DownloadHttpResponseHandler>> a;
  
  public DownloadHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpResponseHandler$Creator", "members/com.vungle.publisher.net.http.DownloadHttpResponseHandler$Creator", true, DownloadHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.net.http.DownloadHttpResponseHandler>", DownloadHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final DownloadHttpResponseHandler.Creator get()
  {
    DownloadHttpResponseHandler.Creator localCreator = new DownloadHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(DownloadHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */