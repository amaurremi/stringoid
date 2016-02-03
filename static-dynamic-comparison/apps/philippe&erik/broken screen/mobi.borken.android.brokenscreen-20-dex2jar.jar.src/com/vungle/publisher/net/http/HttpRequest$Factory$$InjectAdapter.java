package com.vungle.publisher.net.http;

import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.env.WrapperFramework;
import java.util.Set;

public final class HttpRequest$Factory$$InjectAdapter
  extends cs<HttpRequest.Factory>
  implements cp<HttpRequest.Factory>
{
  private cs<WrapperFramework> a;
  private cs<String> b;
  
  public HttpRequest$Factory$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.net.http.HttpRequest$Factory", false, HttpRequest.Factory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.env.WrapperFramework", HttpRequest.Factory.class, getClass().getClassLoader());
    this.b = paramcy.a("@com.vungle.publisher.inject.annotations.WrapperFrameworkVersion()/java.lang.String", HttpRequest.Factory.class, getClass().getClassLoader());
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(HttpRequest.Factory paramFactory)
  {
    paramFactory.a = ((WrapperFramework)this.a.get());
    paramFactory.b = ((String)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */