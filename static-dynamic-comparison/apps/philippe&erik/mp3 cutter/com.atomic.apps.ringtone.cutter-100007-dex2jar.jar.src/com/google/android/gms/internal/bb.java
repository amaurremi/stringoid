package com.google.android.gms.internal;

import com.atomic.apps.ringtone.cutter.aa;

final class bb
  implements Runnable
{
  bb(aY paramaY) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized (aY.a(this.a))
      {
        if (aY.c(this.a).e != -2) {
          return;
        }
        aY.d(this.a).f().a(this.a);
        if (aY.c(this.a).e == -3)
        {
          aa.d("Loading URL in WebView: " + aY.c(this.a).b);
          aY.d(this.a).loadUrl(aY.c(this.a).b);
          return;
        }
      }
      aa.d("Loading HTML in WebView.");
      aY.d(this.a).loadDataWithBaseURL(bN.a(aY.c(this.a).b), aY.c(this.a).c, "text/html", "UTF-8", null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */