package com.vungle.publisher.protocol.message;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.env.SdkState;
import java.util.Set;
import javax.inject.Provider;

public final class RequestLocalAd$Factory$$InjectAdapter
  extends cs<RequestLocalAd.Factory>
  implements cp<RequestLocalAd.Factory>, Provider<RequestLocalAd.Factory>
{
  private cs<SdkState> a;
  private cs<RequestAd.a> b;
  
  public RequestLocalAd$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestLocalAd$Factory", "members/com.vungle.publisher.protocol.message.RequestLocalAd$Factory", true, RequestLocalAd.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.env.SdkState", RequestLocalAd.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.message.RequestAd$Factory", RequestLocalAd.Factory.class, getClass().getClassLoader(), false);
  }
  
  public final RequestLocalAd.Factory get()
  {
    RequestLocalAd.Factory localFactory = new RequestLocalAd.Factory();
    injectMembers(localFactory);
    return localFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestLocalAd.Factory paramFactory)
  {
    paramFactory.e = ((SdkState)this.a.get());
    this.b.injectMembers(paramFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestLocalAd$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */