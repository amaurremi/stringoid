package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class l<K, V>
{
  final a<K, V> aeo = new a()
  {
    public int sizeOf(K paramAnonymousK, V paramAnonymousV)
    {
      return 1;
    }
  };
  
  public k<K, V> a(int paramInt, a<K, V> parama)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (le() < 12) {
      return new cz(paramInt, parama);
    }
    return new bb(paramInt, parama);
  }
  
  int le()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static abstract interface a<K, V>
  {
    public abstract int sizeOf(K paramK, V paramV);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */