package com.vungle.publisher.device;

import android.content.Context;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class ExternalStorageStateBroadcastReceiver$$InjectAdapter
  extends cs<ExternalStorageStateBroadcastReceiver>
  implements cp<ExternalStorageStateBroadcastReceiver>, Provider<ExternalStorageStateBroadcastReceiver>
{
  private cs<AdManager> a;
  private cs<Context> b;
  
  public ExternalStorageStateBroadcastReceiver$$InjectAdapter()
  {
    super("com.vungle.publisher.device.ExternalStorageStateBroadcastReceiver", "members/com.vungle.publisher.device.ExternalStorageStateBroadcastReceiver", true, ExternalStorageStateBroadcastReceiver.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.ad.AdManager", ExternalStorageStateBroadcastReceiver.class, getClass().getClassLoader());
    this.b = paramcy.a("android.content.Context", ExternalStorageStateBroadcastReceiver.class, getClass().getClassLoader());
  }
  
  public final ExternalStorageStateBroadcastReceiver get()
  {
    ExternalStorageStateBroadcastReceiver localExternalStorageStateBroadcastReceiver = new ExternalStorageStateBroadcastReceiver();
    injectMembers(localExternalStorageStateBroadcastReceiver);
    return localExternalStorageStateBroadcastReceiver;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(ExternalStorageStateBroadcastReceiver paramExternalStorageStateBroadcastReceiver)
  {
    paramExternalStorageStateBroadcastReceiver.a = ((AdManager)this.a.get());
    paramExternalStorageStateBroadcastReceiver.b = ((Context)this.b.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/device/ExternalStorageStateBroadcastReceiver$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */