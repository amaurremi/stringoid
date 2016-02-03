package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class l<K, V>
{
  final l.a<K, V> a = new l.a()
  {
    public int sizeOf(K paramAnonymousK, V paramAnonymousV)
    {
      return 1;
    }
  };
  
  int a()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public dn<K, V> a(int paramInt, l.a<K, V> parama)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (a() < 12) {
      return new cu(paramInt, parama);
    }
    return new an(paramInt, parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */