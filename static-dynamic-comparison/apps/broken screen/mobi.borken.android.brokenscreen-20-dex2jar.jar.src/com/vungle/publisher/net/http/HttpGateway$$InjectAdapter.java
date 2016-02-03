package com.vungle.publisher.net.http;

import android.content.Context;
import com.vungle.publisher.bu;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;

public final class HttpGateway$$InjectAdapter
  extends cs<bu>
  implements cp<bu>
{
  private cs<Context> a;
  private cs<Class> b;
  
  public HttpGateway$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.net.http.HttpGateway", false, bu.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", bu.class, getClass().getClassLoader());
    this.b = paramcy.a("@com.vungle.publisher.inject.annotations.VungleServiceClass()/java.lang.Class", bu.class, getClass().getClassLoader());
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(bu parambu)
  {
    parambu.b = ((Context)this.a.get());
    parambu.c = ((Class)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/HttpGateway$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */