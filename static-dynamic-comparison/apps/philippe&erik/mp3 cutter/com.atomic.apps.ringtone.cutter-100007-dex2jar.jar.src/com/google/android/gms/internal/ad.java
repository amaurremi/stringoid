package com.google.android.gms.internal;

final class ad
  implements Runnable
{
  ad(ac paramac, ab paramab) {}
  
  public final void run()
  {
    synchronized (ac.a(this.b))
    {
      if (ac.b(this.b) != -2) {
        return;
      }
      ac.a(this.b, ac.c(this.b));
      if (ac.d(this.b) == null)
      {
        this.b.a(4);
        return;
      }
    }
    this.a.a(this.b);
    ac.a(this.b, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */