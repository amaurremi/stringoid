package com.vungle.publisher.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.vungle.publisher.ad.AdManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExternalStorageStateBroadcastReceiver
  extends BroadcastReceiver
{
  @Inject
  AdManager a;
  @Inject
  public Context b;
  
  public final void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addDataScheme("file");
    this.b.registerReceiver(this, localIntentFilter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.MEDIA_MOUNTED".equals(paramIntent.getAction())) {
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/device/ExternalStorageStateBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */