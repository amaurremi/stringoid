package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class g
  implements ComponentCallbacks2
{
  private final d a;
  
  public g(d paramd)
  {
    this.a = paramd;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    this.a.evictAll();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 60) {
      this.a.evictAll();
    }
    while (paramInt < 20) {
      return;
    }
    this.a.trimToSize(this.a.size() / 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */