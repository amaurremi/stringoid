package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public abstract class lt<T>
        extends mc<T> {
    protected lt(Class<?> paramClass) {
        super(paramClass);
    }

    public static Iterable<lt<?>> d() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new i());
        localArrayList.add(new h());
        localArrayList.add(new g());
        localArrayList.add(new b());
        localArrayList.add(new e());
        localArrayList.add(new d());
        localArrayList.add(new c());
        localArrayList.add(new f());
        localArrayList.add(new a());
        return localArrayList;
    }

    public final T a(hj paramhj, iz paramiz)
            throws IOException, hk {
        Object localObject1 = null;
        if (paramhj.e() == hm.h) {
            paramhj = paramhj.k().trim();
            if (paramhj.length() == 0) {
                paramhj = (hj) localObject1;
            }
        }
        do {
            for (; ; ) {
                return paramhj;
                try {
                    localObject1 = a(paramhj, paramiz);
                    paramhj = (hj) localObject1;
                    if (localObject1 != null) {
                    }
                } catch (IllegalArgumentException paramhj) {
                    Object localObject2;
                    for (; ; ) {
                    }
                }
            }
            throw paramiz.b(this.q, "not a valid textual representation");
            if (paramhj.e() != hm.g) {
                break;
            }
            localObject2 = paramhj.z();
            paramhj = (hj) localObject1;
        } while (localObject2 == null);
        if (this.q.isAssignableFrom(localObject2.getClass())) {
            return (T) localObject2;
        }
        return (T) a(localObject2, paramiz);
        throw paramiz.b(this.q);
    }

    protected T a(Object paramObject, iz paramiz)
            throws IOException, hk {
        throw paramiz.b("Don't know how to convert embedded Object of type " + paramObject.getClass().getName() + " into " + this.q.getName());
    }

    protected abstract T a(String paramString, iz paramiz)
            throws IOException, hk;

    public static class a
            extends lt<Charset> {
        public a() {
            super();
        }

        protected Charset b(String paramString, iz paramiz)
                throws IOException {
            return Charset.forName(paramString);
        }
    }

    public static class b
            extends lt<Currency> {
        public b() {
            super();
        }

        protected Currency b(String paramString, iz paramiz)
                throws IllegalArgumentException {
            return Currency.getInstance(paramString);
        }
    }

    public static class c
            extends lt<InetAddress> {
        public c() {
            super();
        }

        protected InetAddress b(String paramString, iz paramiz)
                throws IOException {
            return InetAddress.getByName(paramString);
        }
    }

    public static class d
            extends lt<Locale> {
        public d() {
            super();
        }

        protected Locale b(String paramString, iz paramiz)
                throws IOException {
            int i = paramString.indexOf('_');
            if (i < 0) {
                return new Locale(paramString);
            }
            paramiz = paramString.substring(0, i);
            paramString = paramString.substring(i + 1);
            i = paramString.indexOf('_');
            if (i < 0) {
                return new Locale(paramiz, paramString);
            }
            return new Locale(paramiz, paramString.substring(0, i), paramString.substring(i + 1));
        }
    }

    public static class e
            extends lt<Pattern> {
        public e() {
            super();
        }

        protected Pattern b(String paramString, iz paramiz)
                throws IllegalArgumentException {
            return Pattern.compile(paramString);
        }
    }

    public static class f
            extends lt<TimeZone> {
        public f() {
            super();
        }

        protected TimeZone b(String paramString, iz paramiz)
                throws IOException {
            return TimeZone.getTimeZone(paramString);
        }
    }

    public static class g
            extends lt<URI> {
        public g() {
            super();
        }

        protected URI b(String paramString, iz paramiz)
                throws IllegalArgumentException {
            return URI.create(paramString);
        }
    }

    public static class h
            extends lt<URL> {
        public h() {
            super();
        }

        protected URL b(String paramString, iz paramiz)
                throws IOException {
            return new URL(paramString);
        }
    }

    public static class i
            extends lt<UUID> {
        public i() {
            super();
        }

        protected UUID b(Object paramObject, iz paramiz)
                throws IOException, hk {
            if ((paramObject instanceof byte[])) {
                paramObject = (byte[]) paramObject;
                if (paramObject.length != 16) {
                    paramiz.b("Can only construct UUIDs from 16 byte arrays; got " + paramObject.length + " bytes");
                }
                paramObject = new DataInputStream(new ByteArrayInputStream((byte[]) paramObject));
                return new UUID(((DataInputStream) paramObject).readLong(), ((DataInputStream) paramObject).readLong());
            }
            super.a(paramObject, paramiz);
            return null;
        }

        protected UUID b(String paramString, iz paramiz)
                throws IOException, hk {
            return UUID.fromString(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */