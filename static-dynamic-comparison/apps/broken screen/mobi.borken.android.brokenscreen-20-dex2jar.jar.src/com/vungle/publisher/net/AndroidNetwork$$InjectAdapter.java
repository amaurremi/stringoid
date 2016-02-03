package com.vungle.publisher.net;

import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class AndroidNetwork$$InjectAdapter
  extends cs<AndroidNetwork>
  implements cp<AndroidNetwork>, Provider<AndroidNetwork>
{
  private cs<ConnectivityManager> a;
  private cs<Provider<NetworkBroadcastReceiver>> b;
  private cs<TelephonyManager> c;
  
  public AndroidNetwork$$InjectAdapter()
  {
    super("com.vungle.publisher.net.AndroidNetwork", "members/com.vungle.publisher.net.AndroidNetwork", true, AndroidNetwork.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.net.ConnectivityManager", AndroidNetwork.class, getClass().getClassLoader());
    this.b = paramcy.a("javax.inject.Provider<com.vungle.publisher.net.NetworkBroadcastReceiver>", AndroidNetwork.class, getClass().getClassLoader());
    this.c = paramcy.a("android.telephony.TelephonyManager", AndroidNetwork.class, getClass().getClassLoader());
  }
  
  public final AndroidNetwork get()
  {
    AndroidNetwork localAndroidNetwork = new AndroidNetwork();
    injectMembers(localAndroidNetwork);
    return localAndroidNetwork;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(AndroidNetwork paramAndroidNetwork)
  {
    paramAndroidNetwork.a = ((ConnectivityManager)this.a.get());
    paramAndroidNetwork.b = ((Provider)this.b.get());
    paramAndroidNetwork.c = ((TelephonyManager)this.c.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/AndroidNetwork$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */