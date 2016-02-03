package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class FireAndForgetHttpResponseHandler$Creator$$InjectAdapter
  extends cs<FireAndForgetHttpResponseHandler.Creator>
  implements cp<FireAndForgetHttpResponseHandler.Creator>, Provider<FireAndForgetHttpResponseHandler.Creator>
{
  private cs<FireAndForgetHttpResponseHandler> a;
  
  public FireAndForgetHttpResponseHandler$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler$Creator", "members/com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler$Creator", true, FireAndForgetHttpResponseHandler.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler", FireAndForgetHttpResponseHandler.Creator.class, getClass().getClassLoader());
  }
  
  public final FireAndForgetHttpResponseHandler.Creator get()
  {
    FireAndForgetHttpResponseHandler.Creator localCreator = new FireAndForgetHttpResponseHandler.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(FireAndForgetHttpResponseHandler.Creator paramCreator)
  {
    paramCreator.a = ((FireAndForgetHttpResponseHandler)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/FireAndForgetHttpResponseHandler$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */