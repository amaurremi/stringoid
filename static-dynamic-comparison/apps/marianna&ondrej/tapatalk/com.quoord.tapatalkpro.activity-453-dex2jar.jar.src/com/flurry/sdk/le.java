package com.flurry.sdk;

import java.io.IOException;
import java.util.Map;

public abstract class le {
    public final le a;
    public final Object b;

    protected le(le paramle, Object paramObject) {
        this.a = paramle;
        this.b = paramObject;
    }

    public abstract void a(Object paramObject)
            throws IOException, hk;

    static final class a
            extends le {
        final ks c;
        final String d;

        public a(le paramle, Object paramObject, ks paramks, String paramString) {
            super(paramObject);
            this.c = paramks;
            this.d = paramString;
        }

        public void a(Object paramObject)
                throws IOException, hk {
            this.c.a(paramObject, this.d, this.b);
        }
    }

    static final class b
            extends le {
        final Object c;

        public b(le paramle, Object paramObject1, Object paramObject2) {
            super(paramObject1);
            this.c = paramObject2;
        }

        public void a(Object paramObject)
                throws IOException, hk {
            ((Map) paramObject).put(this.c, this.b);
        }
    }

    static final class c
            extends le {
        final kt c;

        public c(le paramle, Object paramObject, kt paramkt) {
            super(paramObject);
            this.c = paramkt;
        }

        public void a(Object paramObject)
                throws IOException, hk {
            this.c.a(paramObject, this.b);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/le.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */