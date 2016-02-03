package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class ax
{
  public aw a()
  {
    if (b() < 8) {
      return new af();
    }
    return new ag();
  }
  
  int b()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */