package com.vungle.publisher.service;

import com.vungle.publisher.br;
import com.vungle.publisher.cd.a;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class HttpRequestExecutorIntentHandler$Factory$$InjectAdapter
  extends cs<cd.a>
  implements cp<cd.a>, Provider<cd.a>
{
  private cs<br> a;
  
  public HttpRequestExecutorIntentHandler$Factory$$InjectAdapter()
  {
    super("com.vungle.publisher.cd$a", "members/com.vungle.publisher.service.HttpRequestExecutorIntentHandler$Factory", false, cd.a.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.br", cd.a.class, getClass().getClassLoader());
  }
  
  public final cd.a get()
  {
    cd.a locala = new cd.a();
    injectMembers(locala);
    return locala;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(cd.a parama)
  {
    parama.a = ((br)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/service/HttpRequestExecutorIntentHandler$Factory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */