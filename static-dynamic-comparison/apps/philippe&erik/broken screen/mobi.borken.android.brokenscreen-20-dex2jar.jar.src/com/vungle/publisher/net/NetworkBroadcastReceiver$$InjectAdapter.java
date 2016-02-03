package com.vungle.publisher.net;

import android.content.Context;
import com.vungle.publisher.br;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class NetworkBroadcastReceiver$$InjectAdapter
  extends cs<NetworkBroadcastReceiver>
  implements cp<NetworkBroadcastReceiver>, Provider<NetworkBroadcastReceiver>
{
  private cs<Context> a;
  private cs<br> b;
  
  public NetworkBroadcastReceiver$$InjectAdapter()
  {
    super("com.vungle.publisher.net.NetworkBroadcastReceiver", "members/com.vungle.publisher.net.NetworkBroadcastReceiver", true, NetworkBroadcastReceiver.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", NetworkBroadcastReceiver.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.br", NetworkBroadcastReceiver.class, getClass().getClassLoader());
  }
  
  public final NetworkBroadcastReceiver get()
  {
    NetworkBroadcastReceiver localNetworkBroadcastReceiver = new NetworkBroadcastReceiver();
    injectMembers(localNetworkBroadcastReceiver);
    return localNetworkBroadcastReceiver;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(NetworkBroadcastReceiver paramNetworkBroadcastReceiver)
  {
    paramNetworkBroadcastReceiver.b = ((Context)this.a.get());
    paramNetworkBroadcastReceiver.c = ((br)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/NetworkBroadcastReceiver$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */