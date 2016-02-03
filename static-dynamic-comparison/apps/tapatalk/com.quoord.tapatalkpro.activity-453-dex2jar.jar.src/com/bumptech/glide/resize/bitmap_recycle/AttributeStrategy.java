package com.bumptech.glide.resize.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class AttributeStrategy
        implements LruPoolStrategy {
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap();
    private final KeyPool keyPool = new KeyPool(null);

    private static String getBitmapString(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
        return "[" + paramInt1 + "x" + paramInt2 + "], " + paramConfig;
    }

    private static String getBitmapString(Bitmap paramBitmap) {
        return getBitmapString(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    }

    public Bitmap get(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
        paramConfig = this.keyPool.get(paramInt1, paramInt2, paramConfig);
        return (Bitmap) this.groupedMap.get(paramConfig);
    }

    public int getSize(Bitmap paramBitmap) {
        return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    public String logBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
        return getBitmapString(paramInt1, paramInt2, paramConfig);
    }

    public String logBitmap(Bitmap paramBitmap) {
        return getBitmapString(paramBitmap);
    }

    public void put(Bitmap paramBitmap) {
        Key localKey = this.keyPool.get(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
        this.groupedMap.put(localKey, paramBitmap);
    }

    public Bitmap removeLast() {
        return (Bitmap) this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    private static class Key
            implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final AttributeStrategy.KeyPool pool;
        private int width;

        public Key(AttributeStrategy.KeyPool paramKeyPool) {
            this.pool = paramKeyPool;
        }

        public boolean equals(Object paramObject) {
            if (this == paramObject) {
            }
            do {
                return true;
                if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                    return false;
                }
                paramObject = (Key) paramObject;
                if (this.height != ((Key) paramObject).height) {
                    return false;
                }
                if (this.width != ((Key) paramObject).width) {
                    return false;
                }
            } while (this.config == ((Key) paramObject).config);
            return false;
        }

        public int hashCode() {
            int j = this.width;
            int k = this.height;
            if (this.config != null) {
            }
            for (int i = this.config.hashCode(); ; i = 0) {
                return (j * 31 + k) * 31 + i;
            }
        }

        public void init(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
            this.width = paramInt1;
            this.height = paramInt2;
            this.config = paramConfig;
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    private static class KeyPool
            extends BaseKeyPool<AttributeStrategy.Key> {
        protected AttributeStrategy.Key create() {
            return new AttributeStrategy.Key(this);
        }

        public AttributeStrategy.Key get(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
            AttributeStrategy.Key localKey = (AttributeStrategy.Key) get();
            localKey.init(paramInt1, paramInt2, paramConfig);
            return localKey;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/AttributeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */