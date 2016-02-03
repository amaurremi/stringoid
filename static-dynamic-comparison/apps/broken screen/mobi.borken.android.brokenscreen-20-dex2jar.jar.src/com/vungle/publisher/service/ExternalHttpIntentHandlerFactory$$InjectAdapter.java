package com.vungle.publisher.service;

import com.vungle.publisher.cd.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ExternalHttpIntentHandlerFactory$$InjectAdapter
  extends cs<ExternalHttpIntentHandlerFactory>
  implements cp<ExternalHttpIntentHandlerFactory>, Provider<ExternalHttpIntentHandlerFactory>
{
  private cs<cd.a> a;
  
  public ExternalHttpIntentHandlerFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.service.ExternalHttpIntentHandlerFactory", "members/com.vungle.publisher.service.ExternalHttpIntentHandlerFactory", true, ExternalHttpIntentHandlerFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.service.HttpRequestExecutorIntentHandler$Factory", ExternalHttpIntentHandlerFactory.class, getClass().getClassLoader(), false);
  }
  
  public final ExternalHttpIntentHandlerFactory get()
  {
    ExternalHttpIntentHandlerFactory localExternalHttpIntentHandlerFactory = new ExternalHttpIntentHandlerFactory();
    injectMembers(localExternalHttpIntentHandlerFactory);
    return localExternalHttpIntentHandlerFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ExternalHttpIntentHandlerFactory paramExternalHttpIntentHandlerFactory)
  {
    this.a.injectMembers(paramExternalHttpIntentHandlerFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/ExternalHttpIntentHandlerFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */