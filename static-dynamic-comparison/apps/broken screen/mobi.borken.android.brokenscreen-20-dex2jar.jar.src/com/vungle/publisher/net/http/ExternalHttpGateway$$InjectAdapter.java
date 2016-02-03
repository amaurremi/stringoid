package com.vungle.publisher.net.http;

import com.vungle.publisher.bt;
import com.vungle.publisher.bu;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.protocol.TrackEventHttpTransactionFactory;
import java.util.Set;
import javax.inject.Provider;

public final class ExternalHttpGateway$$InjectAdapter
  extends cs<bt>
  implements cp<bt>, Provider<bt>
{
  private cs<TrackEventHttpTransactionFactory> a;
  private cs<bu> b;
  
  public ExternalHttpGateway$$InjectAdapter()
  {
    super("com.vungle.publisher.bt", "members/com.vungle.publisher.net.http.ExternalHttpGateway", false, bt.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.protocol.TrackEventHttpTransactionFactory", bt.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.net.http.HttpGateway", bt.class, getClass().getClassLoader(), false);
  }
  
  public final bt get()
  {
    bt localbt = new bt();
    injectMembers(localbt);
    return localbt;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(bt parambt)
  {
    parambt.a = ((TrackEventHttpTransactionFactory)this.a.get());
    this.b.injectMembers(parambt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/ExternalHttpGateway$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */