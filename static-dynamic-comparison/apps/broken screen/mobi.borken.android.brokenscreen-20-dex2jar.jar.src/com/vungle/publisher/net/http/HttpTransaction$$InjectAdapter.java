package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class HttpTransaction$$InjectAdapter
  extends cs<HttpTransaction>
  implements cp<HttpTransaction>, Provider<HttpTransaction>
{
  private cs<HttpTransport> a;
  
  public HttpTransaction$$InjectAdapter()
  {
    super("com.vungle.publisher.net.http.HttpTransaction", "members/com.vungle.publisher.net.http.HttpTransaction", false, HttpTransaction.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.net.http.HttpTransport", HttpTransaction.class, getClass().getClassLoader());
  }
  
  public final HttpTransaction get()
  {
    HttpTransaction localHttpTransaction = new HttpTransaction();
    injectMembers(localHttpTransaction);
    return localHttpTransaction;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(HttpTransaction paramHttpTransaction)
  {
    paramHttpTransaction.d = ((HttpTransport)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpTransaction$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */