package com.vungle.publisher.protocol;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class RequestStreamingAdHttpTransactionFactory$$InjectAdapter
  extends cs<RequestStreamingAdHttpTransactionFactory>
  implements cp<RequestStreamingAdHttpTransactionFactory>, Provider<RequestStreamingAdHttpTransactionFactory>
{
  private cs<RequestStreamingAdHttpRequest.Factory> a;
  private cs<RequestStreamingAdHttpResponseHandler> b;
  
  public RequestStreamingAdHttpTransactionFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.protocol.RequestStreamingAdHttpTransactionFactory", "members/com.vungle.publisher.protocol.RequestStreamingAdHttpTransactionFactory", true, RequestStreamingAdHttpTransactionFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.RequestStreamingAdHttpRequest$Factory", RequestStreamingAdHttpTransactionFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.protocol.RequestStreamingAdHttpResponseHandler", RequestStreamingAdHttpTransactionFactory.class, getClass().getClassLoader());
  }
  
  public final RequestStreamingAdHttpTransactionFactory get()
  {
    RequestStreamingAdHttpTransactionFactory localRequestStreamingAdHttpTransactionFactory = new RequestStreamingAdHttpTransactionFactory();
    injectMembers(localRequestStreamingAdHttpTransactionFactory);
    return localRequestStreamingAdHttpTransactionFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(RequestStreamingAdHttpTransactionFactory paramRequestStreamingAdHttpTransactionFactory)
  {
    paramRequestStreamingAdHttpTransactionFactory.a = ((RequestStreamingAdHttpRequest.Factory)this.a.get());
    paramRequestStreamingAdHttpTransactionFactory.b = ((RequestStreamingAdHttpResponseHandler)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpTransactionFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */