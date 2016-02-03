package org.osmdroid.tileprovider;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

public abstract interface IRegisterReceiver
{
  public abstract Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter);
  
  public abstract void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/IRegisterReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */