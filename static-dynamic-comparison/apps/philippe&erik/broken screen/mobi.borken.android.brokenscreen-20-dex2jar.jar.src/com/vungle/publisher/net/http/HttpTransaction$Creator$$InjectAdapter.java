package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class HttpTransaction$Creator$$InjectAdapter
  extends cs<HttpTransaction.Creator>
  implements cp<HttpTransaction.Creator>, Provider<HttpTransaction.Creator>
{
  private cs<Provider<HttpTransaction>> a;
  
  public HttpTransaction$Creator$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.HttpTransaction$Creator", "members/com.vungle.publisher.net.http.HttpTransaction$Creator", true, HttpTransaction.Creator.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("javax.inject.Provider<com.vungle.publisher.net.http.HttpTransaction>", HttpTransaction.Creator.class, getClass().getClassLoader());
  }
  
  public final HttpTransaction.Creator get()
  {
    HttpTransaction.Creator localCreator = new HttpTransaction.Creator();
    injectMembers(localCreator);
    return localCreator;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(HttpTransaction.Creator paramCreator)
  {
    paramCreator.a = ((Provider)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpTransaction$Creator$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */