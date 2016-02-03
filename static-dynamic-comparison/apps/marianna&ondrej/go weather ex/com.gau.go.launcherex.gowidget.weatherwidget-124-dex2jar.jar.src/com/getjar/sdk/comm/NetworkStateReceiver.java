package com.getjar.sdk.comm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;

public class NetworkStateReceiver
  extends BroadcastReceiver
{
  private static volatile NetworkStateReceiver _Instance = null;
  private volatile boolean _isRegistered = false;
  private volatile Object _registrationLock = new Object();
  
  public static NetworkStateReceiver getInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new NetworkStateReceiver();
      }
      NetworkStateReceiver localNetworkStateReceiver = _Instance;
      return localNetworkStateReceiver;
    }
    finally {}
  }
  
  public void doOnReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getAction();
      if (StringUtility.isNullOrEmpty(str)) {
        return;
      }
      if (str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        if (paramIntent.getBooleanExtra("noConnectivity", false))
        {
          Logger.i(Area.COMM.value() | Area.AUTH.value() | Area.TRANSACTION.value(), "NetworkStateReceiver: onReceive() network connection lost", new Object[0]);
          return;
        }
      }
    }
    catch (AuthException paramContext)
    {
      Logger.w(Area.COMM.value() | Area.AUTH.value() | Area.TRANSACTION.value(), "NetworkStateReceiver: onReceive() not yet authed [%1$s]", new Object[] { paramContext.getMessage() });
      return;
      Logger.i(Area.COMM.value() | Area.AUTH.value() | Area.TRANSACTION.value(), "NetworkStateReceiver: onReceive() network connection restored", new Object[0]);
      paramIntent = CommManager.createContext(paramContext);
      AuthManager.initialize(paramContext);
      AuthManager.getInstance().waitOnAuth();
      new TransactionManager(paramContext).recoverOrphanedTransactions(paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.COMM.value() | Area.AUTH.value() | Area.TRANSACTION.value(), paramContext, "NetworkStateReceiver: onReceive() failed", new Object[0]);
    }
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    Logger.d(Area.COMM.value(), "NetworkStateReceiver: onReceive(): START", new Object[0]);
    try
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            NetworkStateReceiver.this.doOnReceive(paramContext, paramIntent);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.COMM.value(), localException, "NetworkStateReceiver: onReceive() failed", new Object[0]);
          }
        }
      }, "NetworkStateReceiver Worker Thread").start();
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.COMM.value(), paramContext, "PackageMonitor: onReceive() failed", new Object[0]);
    }
  }
  
  public void registerReceiver(Context paramContext)
  {
    synchronized (this._registrationLock)
    {
      if (!this._isRegistered)
      {
        IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
        this._isRegistered = true;
        Logger.v(Area.COMM.value(), "NetworkStateReceiver: registered", new Object[0]);
      }
      return;
    }
  }
  
  protected void unregisterReceiver(Context paramContext)
  {
    synchronized (this._registrationLock)
    {
      if (this._isRegistered)
      {
        paramContext.getApplicationContext().unregisterReceiver(this);
        this._isRegistered = false;
        Logger.v(Area.COMM.value(), "NetworkStateReceiver: unregistered", new Object[0]);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/NetworkStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */