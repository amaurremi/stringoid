package com.vungle.publisher.protocol;

import com.vungle.publisher.bd;
import com.vungle.publisher.be;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.net.http.HttpRequest.Factory;
import java.util.Set;

public final class ProtocolHttpRequest$Factory$$InjectAdapter
  extends cs<ProtocolHttpRequest.a>
  implements cp<ProtocolHttpRequest.a>
{
  private cs<bd> a;
  private cs<be> b;
  private cs<String> c;
  private cs<HttpRequest.Factory> d;
  
  public ProtocolHttpRequest$Factory$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.protocol.ProtocolHttpRequest$Factory", false, ProtocolHttpRequest.a.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.bd", ProtocolHttpRequest.a.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.be", ProtocolHttpRequest.a.class, getClass().getClassLoader());
    this.c = paramcy.a("@com.vungle.publisher.inject.annotations.VungleBaseUrl()/java.lang.String", ProtocolHttpRequest.a.class, getClass().getClassLoader());
    this.d = paramcy.a("members/com.vungle.publisher.net.http.HttpRequest$Factory", ProtocolHttpRequest.a.class, getClass().getClassLoader(), false);
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(ProtocolHttpRequest.a parama)
  {
    parama.c = ((bd)this.a.get());
    parama.d = ((be)this.b.get());
    parama.e = ((String)this.c.get());
    this.d.injectMembers(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ProtocolHttpRequest$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */