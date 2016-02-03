package com.flurry.sdk;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class qa
        implements rg<Map.Entry<Class<?>, Object>> {
    public Collection<Map.Entry<Class<?>, Object>> a() {
        HashMap localHashMap = new HashMap();
        qg localqg = qg.a;
        localHashMap.put(URL.class, localqg);
        localHashMap.put(URI.class, localqg);
        localHashMap.put(Currency.class, localqg);
        localHashMap.put(UUID.class, localqg);
        localHashMap.put(Pattern.class, localqg);
        localHashMap.put(Locale.class, localqg);
        localHashMap.put(Locale.class, localqg);
        localHashMap.put(AtomicReference.class, d.class);
        localHashMap.put(AtomicBoolean.class, a.class);
        localHashMap.put(AtomicInteger.class, b.class);
        localHashMap.put(AtomicLong.class, c.class);
        localHashMap.put(File.class, f.class);
        localHashMap.put(Class.class, e.class);
        localHashMap.put(Void.TYPE, pq.class);
        return localHashMap.entrySet();
    }

    public static final class a
            extends pt<AtomicBoolean> {
        public a() {
            super(false);
        }

        public void a(AtomicBoolean paramAtomicBoolean, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramAtomicBoolean.get());
        }
    }

    public static final class b
            extends pt<AtomicInteger> {
        public b() {
            super(false);
        }

        public void a(AtomicInteger paramAtomicInteger, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramAtomicInteger.get());
        }
    }

    public static final class c
            extends pt<AtomicLong> {
        public c() {
            super(false);
        }

        public void a(AtomicLong paramAtomicLong, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramAtomicLong.get());
        }
    }

    public static final class d
            extends pw<AtomicReference<?>> {
        public d() {
            super(false);
        }

        public void a(AtomicReference<?> paramAtomicReference, hf paramhf, jw paramjw)
                throws IOException, he {
            paramjw.a(paramAtomicReference.get(), paramhf);
        }
    }

    public static final class e
            extends pt<Class<?>> {
        public e() {
            super(false);
        }

        public void a(Class<?> paramClass, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramClass.getName());
        }
    }

    public static final class f
            extends pt<File> {
        public f() {
            super();
        }

        public void a(File paramFile, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.b(paramFile.getAbsolutePath());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */