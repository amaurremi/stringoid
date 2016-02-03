package com.google.android.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class b
  extends BroadcastReceiver
{
  private static boolean a = false;
  
  static final String b(Context paramContext)
  {
    return paramContext.getPackageName() + ".GCMIntentService";
  }
  
  protected String a(Context paramContext)
  {
    return b(paramContext);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.v("GCMBroadcastReceiver", "onReceive: " + paramIntent.getAction());
    if (!a)
    {
      a = true;
      str = getClass().getName();
      if (!str.equals(b.class.getName())) {
        c.a(str);
      }
    }
    String str = a(paramContext);
    Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + str);
    a.runIntentInService(paramContext, paramIntent, str);
    setResult(-1, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */