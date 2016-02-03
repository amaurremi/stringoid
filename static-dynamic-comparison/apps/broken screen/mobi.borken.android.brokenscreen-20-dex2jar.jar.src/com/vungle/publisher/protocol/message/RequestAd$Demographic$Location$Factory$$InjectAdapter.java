package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestAd$Demographic$Location$Factory$$InjectAdapter
  extends cs<RequestAd.Demographic.Location.Factory>
  implements cp<RequestAd.Demographic.Location.Factory>, Provider<RequestAd.Demographic.Location.Factory>
{
  private cs<MessageFactory> a;
  
  public RequestAd$Demographic$Location$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestAd$Demographic$Location$Factory", "members/com.vungle.publisher.protocol.message.RequestAd$Demographic$Location$Factory", true, RequestAd.Demographic.Location.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("members/com.vungle.publisher.protocol.message.MessageFactory", RequestAd.Demographic.Location.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestAd.Demographic.Location.Factory get()
  {
    RequestAd.Demographic.Location.Factory localFactory = new RequestAd.Demographic.Location.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(RequestAd.Demographic.Location.Factory paramFactory)
  {
    this.a.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestAd$Demographic$Location$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */