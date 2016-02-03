package org.osmdroid.tileprovider.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.osmdroid.tileprovider.IRegisterReceiver;

public class SimpleRegisterReceiver
  implements IRegisterReceiver
{
  private final Context mContext;
  
  public SimpleRegisterReceiver(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.mContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.mContext.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/util/SimpleRegisterReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */