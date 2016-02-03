package com.google.android.gms.tagmanager;

import android.util.LruCache;

class bb<K, V>
        implements k<K, V> {
    private LruCache<K, V> Yu;

    bb(int paramInt, final l.a<K, V> parama) {
        this.Yu = new LruCache(paramInt) {
            protected int sizeOf(K paramAnonymousK, V paramAnonymousV) {
                return parama.sizeOf(paramAnonymousK, paramAnonymousV);
            }
        };
    }

    public void e(K paramK, V paramV) {
        this.Yu.put(paramK, paramV);
    }

    public V get(K paramK) {
        return (V) this.Yu.get(paramK);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */