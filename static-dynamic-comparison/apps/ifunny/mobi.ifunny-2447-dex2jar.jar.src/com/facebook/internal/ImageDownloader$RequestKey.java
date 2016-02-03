package com.facebook.internal;

import java.net.URI;

class ImageDownloader$RequestKey {
    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    Object tag;
    URI uri;

    ImageDownloader$RequestKey(URI paramURI, Object paramObject) {
        this.uri = paramURI;
        this.tag = paramObject;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramObject != null) {
            bool1 = bool2;
            if ((paramObject instanceof RequestKey)) {
                paramObject = (RequestKey) paramObject;
                bool1 = bool2;
                if (((RequestKey) paramObject).uri == this.uri) {
                    bool1 = bool2;
                    if (((RequestKey) paramObject).tag == this.tag) {
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    public int hashCode() {
        return (this.uri.hashCode() + 1073) * 37 + this.tag.hashCode();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageDownloader$RequestKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */