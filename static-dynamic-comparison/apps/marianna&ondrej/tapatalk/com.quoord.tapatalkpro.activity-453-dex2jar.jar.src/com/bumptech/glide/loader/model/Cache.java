package com.bumptech.glide.loader.model;

import java.util.HashMap;
import java.util.Map;

public class Cache<A> {
    private Map<ModelKey, A> cache = new HashMap();

    public A get(String paramString, int paramInt1, int paramInt2) {
        return (A) this.cache.get(new ModelKey(paramString, paramInt1, paramInt2));
    }

    public void put(String paramString, int paramInt1, int paramInt2, A paramA) {
        this.cache.put(new ModelKey(paramString, paramInt1, paramInt2), paramA);
    }

    private static class ModelKey {
        private final int height;
        private final String id;
        private final int width;

        public ModelKey(String paramString, int paramInt1, int paramInt2) {
            this.id = paramString;
            this.width = paramInt1;
            this.height = paramInt2;
        }

        public boolean equals(Object paramObject) {
            if (this == paramObject) {
            }
            do {
                return true;
                if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                    return false;
                }
                paramObject = (ModelKey) paramObject;
                if (this.height != ((ModelKey) paramObject).height) {
                    return false;
                }
                if (this.width != ((ModelKey) paramObject).width) {
                    return false;
                }
            } while (this.id.equals(((ModelKey) paramObject).id));
            return false;
        }

        public int hashCode() {
            return (this.height * 31 + this.width) * 31 + this.id.hashCode();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */