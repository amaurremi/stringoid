package com.vungle.publisher;

import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.service.DownloadIntentHandlerFactory;
import com.vungle.publisher.service.ExternalHttpIntentHandlerFactory;
import com.vungle.publisher.service.PrepareLocalAdIntentHandler.Factory;
import com.vungle.publisher.service.ProtocolIntentHandlerFactory;
import java.util.Set;
import javax.inject.Provider;

public final class VungleService$$InjectAdapter
  extends cs<VungleService>
  implements cp<VungleService>, Provider<VungleService>
{
  private cs<DownloadIntentHandlerFactory> a;
  private cs<ExternalHttpIntentHandlerFactory> b;
  private cs<PrepareLocalAdIntentHandler.Factory> c;
  private cs<ProtocolIntentHandlerFactory> d;
  private cs<DatabaseHelper> e;
  
  public VungleService$$InjectAdapter()
  {
    super("com.vungle.publisher.VungleService", "members/com.vungle.publisher.VungleService", false, VungleService.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.service.DownloadIntentHandlerFactory", VungleService.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.service.ExternalHttpIntentHandlerFactory", VungleService.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.service.PrepareLocalAdIntentHandler$Factory", VungleService.class, getClass().getClassLoader());
    this.d = paramcy.a("com.vungle.publisher.service.ProtocolIntentHandlerFactory", VungleService.class, getClass().getClassLoader());
    this.e = paramcy.a("com.vungle.publisher.db.DatabaseHelper", VungleService.class, getClass().getClassLoader());
  }
  
  public final VungleService get()
  {
    VungleService localVungleService = new VungleService();
    injectMembers(localVungleService);
    return localVungleService;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
    paramSet2.add(this.e);
  }
  
  public final void injectMembers(VungleService paramVungleService)
  {
    paramVungleService.b = ((DownloadIntentHandlerFactory)this.a.get());
    paramVungleService.c = ((ExternalHttpIntentHandlerFactory)this.b.get());
    paramVungleService.d = ((PrepareLocalAdIntentHandler.Factory)this.c.get());
    paramVungleService.e = ((ProtocolIntentHandlerFactory)this.d.get());
    paramVungleService.f = ((DatabaseHelper)this.e.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/VungleService$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */