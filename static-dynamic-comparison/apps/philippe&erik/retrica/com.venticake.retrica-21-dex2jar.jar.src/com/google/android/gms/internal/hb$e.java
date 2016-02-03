package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class hb$e
  extends hh.a
{
  private hb Gl;
  
  public hb$e(hb paramhb)
  {
    this.Gl = paramhb;
  }
  
  public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    hm.b("onPostInitComplete can be called only once per call to getServiceFromBroker", this.Gl);
    this.Gl.a(paramInt, paramIBinder, paramBundle);
    this.Gl = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hb$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */