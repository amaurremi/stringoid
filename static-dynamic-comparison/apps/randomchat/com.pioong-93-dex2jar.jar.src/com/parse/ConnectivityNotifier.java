package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ConnectivityNotifier
  extends BroadcastReceiver
{
  static final String TAG = "com.parse.ConnectivityNotifier";
  private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
  private boolean hasRegisteredReceiver = false;
  private Set<ConnectivityListener> listeners = new HashSet();
  private final Object lock = new Object();
  
  static ConnectivityNotifier getNotifier()
  {
    return singleton;
  }
  
  public void addListener(ConnectivityListener paramConnectivityListener, Context arg2)
  {
    synchronized (this.lock)
    {
      this.listeners.add(paramConnectivityListener);
      tryToRegisterForNetworkStatusNotifications();
      return;
    }
  }
  
  public boolean isConnected()
  {
    if (Parse.applicationContext == null) {
      Parse.logW("com.parse.ConnectivityNotifier", "Trying to check network connectivity without a known context. Has Parse.initialize been called from Application.onCreate? (Not Activity.onCreate)");
    }
    Object localObject;
    do
    {
      do
      {
        return true;
        localObject = (ConnectivityManager)Parse.applicationContext.getSystemService("connectivity");
      } while (localObject == null);
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while ((localObject == null) || (((NetworkInfo)localObject).isConnected()));
    return false;
  }
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        ArrayList localArrayList = new ArrayList(this.listeners);
        ??? = localArrayList.iterator();
        if (!???.hasNext()) {
          return;
        }
      }
      ((ConnectivityListener)???.next()).networkConnectivityStatusChanged(paramIntent);
    }
  }
  
  public void removeListener(ConnectivityListener paramConnectivityListener)
  {
    synchronized (this.lock)
    {
      this.listeners.remove(paramConnectivityListener);
      tryToRegisterForNetworkStatusNotifications();
      return;
    }
  }
  
  public boolean tryToRegisterForNetworkStatusNotifications()
  {
    Context localContext;
    synchronized (this.lock)
    {
      if (this.hasRegisteredReceiver) {
        return true;
      }
    }
    return false;
  }
  
  protected static abstract interface ConnectivityListener
  {
    public abstract void networkConnectivityStatusChanged(Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ConnectivityNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */