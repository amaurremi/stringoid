package com.everimaging.fotorsdk.uil.cache.memory.impl;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.uil.cache.memory.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class b
        implements a<String, Bitmap> {
    private final LinkedHashMap<String, Bitmap> a;
    private final int b;
    private int c;

    public b(int paramInt) {
        if (paramInt <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = paramInt;
        this.a = new LinkedHashMap(0, 0.75F, true);
    }

    private void a(int paramInt) {
        try {
            if ((this.c < 0) || ((this.a.isEmpty()) && (this.c != 0))) {
                throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
            }
        } finally {
            throw ((Throwable) localObject1);
            if ((this.c <= paramInt) || (this.a.isEmpty())) {
                return;
            }
            Object localObject2 = (Map.Entry) this.a.entrySet().iterator().next();
            if (localObject2 == null) {
                return;
            }
            String str = (String) ((Map.Entry) localObject2).getKey();
            localObject2 = (Bitmap) ((Map.Entry) localObject2).getValue();
            this.a.remove(str);
            this.c -= b(str, (Bitmap) localObject2);
        }
    }

    private int b(String paramString, Bitmap paramBitmap) {
        return paramBitmap.getRowBytes() * paramBitmap.getHeight();
    }

    public final Bitmap a(String paramString) {
        if (paramString == null) {
            throw new NullPointerException("key == null");
        }
        try {
            paramString = (Bitmap) this.a.get(paramString);
            return paramString;
        } finally {
        }
    }

    public Collection<String> a() {
        try {
            HashSet localHashSet = new HashSet(this.a.keySet());
            return localHashSet;
        } finally {
        }
    }

    public final boolean a(String paramString, Bitmap paramBitmap) {
        if ((paramString == null) || (paramBitmap == null)) {
            throw new NullPointerException("key == null || value == null");
        }
        try {
            this.c += b(paramString, paramBitmap);
            paramBitmap = (Bitmap) this.a.put(paramString, paramBitmap);
            if (paramBitmap != null) {
                this.c -= b(paramString, paramBitmap);
            }
            a(this.b);
            return true;
        } finally {
        }
    }

    public final void b(String paramString) {
        if (paramString == null) {
            throw new NullPointerException("key == null");
        }
        try {
            Bitmap localBitmap = (Bitmap) this.a.remove(paramString);
            if (localBitmap != null) {
                this.c -= b(paramString, localBitmap);
            }
            return;
        } finally {
        }
    }

    public final String toString() {
        try {
            String str = String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.b)});
            return str;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/cache/memory/impl/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */