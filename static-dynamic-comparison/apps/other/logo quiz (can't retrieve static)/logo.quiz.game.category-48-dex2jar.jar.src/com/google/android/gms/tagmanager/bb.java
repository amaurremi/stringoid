package com.google.android.gms.tagmanager;

import android.util.LruCache;

class bb<K, V>
  implements k<K, V>
{
  private LruCache<K, V> apx;
  
  bb(int paramInt, final l.a<K, V> parama)
  {
    this.apx = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return parama.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public void e(K paramK, V paramV)
  {
    this.apx.put(paramK, paramV);
  }
  
  public V get(K paramK)
  {
    return (V)this.apx.get(paramK);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */