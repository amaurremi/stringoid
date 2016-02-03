package com.vungle.publisher.service;

import com.vungle.publisher.cd.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DownloadIntentHandlerFactory$$InjectAdapter
  extends cs<DownloadIntentHandlerFactory>
  implements cp<DownloadIntentHandlerFactory>, Provider<DownloadIntentHandlerFactory>
{
  private cs<cd.a> a;
  
  public DownloadIntentHandlerFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.service.DownloadIntentHandlerFactory", "members/com.vungle.publisher.service.DownloadIntentHandlerFactory", true, DownloadIntentHandlerFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.service.HttpRequestExecutorIntentHandler$Factory", DownloadIntentHandlerFactory.class, getClass().getClassLoader(), false);
  }
  
  public final DownloadIntentHandlerFactory get()
  {
    DownloadIntentHandlerFactory localDownloadIntentHandlerFactory = new DownloadIntentHandlerFactory();
    injectMembers(localDownloadIntentHandlerFactory);
    return localDownloadIntentHandlerFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(DownloadIntentHandlerFactory paramDownloadIntentHandlerFactory)
  {
    this.a.injectMembers(paramDownloadIntentHandlerFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/DownloadIntentHandlerFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */