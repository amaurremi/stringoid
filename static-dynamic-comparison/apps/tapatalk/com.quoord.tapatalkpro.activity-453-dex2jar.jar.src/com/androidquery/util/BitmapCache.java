package com.androidquery.util;

import android.graphics.Bitmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class BitmapCache
        extends LinkedHashMap<String, Bitmap> {
    private static final long serialVersionUID = 1L;
    private int maxCount;
    private int maxPixels;
    private int maxTotalPixels;
    private int pixels;

    public BitmapCache(int paramInt1, int paramInt2, int paramInt3) {
        super(8, 0.75F, true);
        this.maxCount = paramInt1;
        this.maxPixels = paramInt2;
        this.maxTotalPixels = paramInt3;
    }

    private int pixels(Bitmap paramBitmap) {
        if (paramBitmap == null) {
            return 0;
        }
        return paramBitmap.getWidth() * paramBitmap.getHeight();
    }

    private void shrink() {
        Iterator localIterator;
        if (this.pixels > this.maxTotalPixels) {
            localIterator = keySet().iterator();
        }
        do {
            if (!localIterator.hasNext()) {
                return;
            }
            localIterator.next();
            localIterator.remove();
        } while (this.pixels > this.maxTotalPixels);
    }

    public void clear() {
        super.clear();
        this.pixels = 0;
    }

    public Bitmap put(String paramString, Bitmap paramBitmap) {
        String str = null;
        int i = pixels(paramBitmap);
        if (i <= this.maxPixels) {
            this.pixels += i;
            paramString = (Bitmap) super.put(paramString, paramBitmap);
            str = paramString;
            if (paramString != null) {
                this.pixels -= pixels(paramString);
                str = paramString;
            }
        }
        return str;
    }

    public Bitmap remove(Object paramObject) {
        paramObject = (Bitmap) super.remove(paramObject);
        if (paramObject != null) {
            this.pixels -= pixels((Bitmap) paramObject);
        }
        return (Bitmap) paramObject;
    }

    public boolean removeEldestEntry(Map.Entry<String, Bitmap> paramEntry) {
        if ((this.pixels > this.maxTotalPixels) || (size() > this.maxCount)) {
            remove(paramEntry.getKey());
        }
        shrink();
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/BitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */