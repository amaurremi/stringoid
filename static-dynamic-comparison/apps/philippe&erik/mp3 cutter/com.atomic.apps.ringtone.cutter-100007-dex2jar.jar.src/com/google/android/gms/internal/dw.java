package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;

final class dw
  implements ComponentCallbacks
{
  dw(dv paramdv) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((dv.a(this.a) != null) && (dv.a(this.a).i != null) && (dv.a(this.a).i.b != null)) {
      dv.a(this.a).i.b.a();
    }
  }
  
  public final void onLowMemory() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */