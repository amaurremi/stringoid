package com.vungle.publisher.protocol.message;

import com.vungle.publisher.be;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestConfig$$InjectAdapter
  extends cs<RequestConfig>
  implements cp<RequestConfig>, Provider<RequestConfig>
{
  private cs<be> a;
  private cs<BaseJsonSerializable> b;
  
  public RequestConfig$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.message.RequestConfig", "members/com.vungle.publisher.protocol.message.RequestConfig", true, RequestConfig.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.be", RequestConfig.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.protocol.message.BaseJsonSerializable", RequestConfig.class, getClass().getClassLoader(), false);
  }
  
  public final RequestConfig get()
  {
    RequestConfig localRequestConfig = new RequestConfig();
    injectMembers(localRequestConfig);
    return localRequestConfig;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestConfig paramRequestConfig)
  {
    paramRequestConfig.a = ((be)this.a.get());
    this.b.injectMembers(paramRequestConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestConfig$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */