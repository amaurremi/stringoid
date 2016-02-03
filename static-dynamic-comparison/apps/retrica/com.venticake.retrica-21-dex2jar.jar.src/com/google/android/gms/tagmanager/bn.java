package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ij;

class bn
  implements da.a
{
  bn(bm parambm) {}
  
  public void a(z paramz)
  {
    bm.a(this.a, paramz.a());
  }
  
  public void b(z paramz)
  {
    bm.a(this.a, paramz.a());
    as.e("Permanent failure dispatching hitId: " + paramz.a());
  }
  
  public void c(z paramz)
  {
    long l = paramz.b();
    if (l == 0L) {
      bm.a(this.a, paramz.a(), bm.a(this.a).currentTimeMillis());
    }
    while (l + 14400000L >= bm.a(this.a).currentTimeMillis()) {
      return;
    }
    bm.a(this.a, paramz.a());
    as.e("Giving up on failed hitId: " + paramz.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */