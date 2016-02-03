package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadHttpRequest$Creator$$InjectAdapter
  extends cs<DownloadHttpRequest.Creator>
  implements cp<DownloadHttpRequest.Creator>, Provider<DownloadHttpRequest.Creator>
{
  private cs<DownloadHttpRequest.Factory> a;
  
  public DownloadHttpRequest$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.DownloadHttpRequest$Creator", "members/com.vungle.publisher.net.http.DownloadHttpRequest$Creator", true, DownloadHttpRequest.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.DownloadHttpRequest$Factory", DownloadHttpRequest.Creator.class, getClass().getClassLoader());
  }
  
  public final DownloadHttpRequest.Creator get()
  {
    DownloadHttpRequest.Creator localCreator = new DownloadHttpRequest.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(DownloadHttpRequest.Creator paramCreator)
  {
    paramCreator.a = ((DownloadHttpRequest.Factory)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/DownloadHttpRequest$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */