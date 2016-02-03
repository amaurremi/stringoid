package com.vungle.publisher.protocol.message;

import com.vungle.publisher.Demographic;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAd$Demographic$Factory$$InjectAdapter
  extends cs<RequestAd.Demographic.Factory>
  implements cp<RequestAd.Demographic.Factory>, Provider<RequestAd.Demographic.Factory>
{
  private cs<Demographic> a;
  private cs<RequestAd.Demographic.Location.Factory> b;
  private cs<MessageFactory> c;
  
  public RequestAd$Demographic$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAd$Demographic$Factory", "members/com.vungle.publisher.protocol.message.RequestAd$Demographic$Factory", true, RequestAd.Demographic.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.Demographic", RequestAd.Demographic.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.message.RequestAd$Demographic$Location$Factory", RequestAd.Demographic.Factory.class, getClass().getClassLoader());
    this.c = paramcy.a("members/com.vungle.publisher.protocol.message.MessageFactory", RequestAd.Demographic.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAd.Demographic.Factory get()
  {
    RequestAd.Demographic.Factory localFactory = new RequestAd.Demographic.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(RequestAd.Demographic.Factory paramFactory)
  {
    paramFactory.a = ((Demographic)this.a.get());
    paramFactory.b = ((RequestAd.Demographic.Location.Factory)this.b.get());
    this.c.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAd$Demographic$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */