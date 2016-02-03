package com.google.android.gms.internal;

import android.content.Context;
import com.atomic.apps.ringtone.cutter.aa;

final class bs
  implements Runnable
{
  bs(Context paramContext, cx paramcx, bv parambv, ca paramca, String paramString) {}
  
  public final void run()
  {
    bW localbW = bW.a(this.a, new ak(), false, false, null, this.b.k);
    localbW.setWillNotDraw(true);
    this.c.a(localbW);
    bY localbY = localbW.f();
    localbY.a("/invalidRequest", this.c.a);
    localbY.a("/loadAdURL", this.c.b);
    localbY.a("/log", I.g);
    localbY.a(this.d);
    aa.a("Loading the JS library.");
    localbW.loadUrl(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */