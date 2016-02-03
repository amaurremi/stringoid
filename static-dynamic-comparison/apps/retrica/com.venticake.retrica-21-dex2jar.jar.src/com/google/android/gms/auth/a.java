package com.google.android.gms.auth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

class a
  extends Handler
{
  private final Context a;
  
  a(Context paramContext) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.a);
      if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
        GooglePlayServicesUtil.showErrorNotification(i, this.a);
      }
      return;
    }
    Log.wtf("GoogleAuthUtil", "Don't know how to handle this message: " + paramMessage.what);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */