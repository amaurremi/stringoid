package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class y
  extends ag
{
  private s a;
  
  public y(s params)
  {
    this.a = params;
  }
  
  public void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    an.a("onPostInitComplete can be called only once per call to getServiceFromBroker", this.a);
    this.a.a(paramInt, paramIBinder, paramBundle);
    this.a = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */