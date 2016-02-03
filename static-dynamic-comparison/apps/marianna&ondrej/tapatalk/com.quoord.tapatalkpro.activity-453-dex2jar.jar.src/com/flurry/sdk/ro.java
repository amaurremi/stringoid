package com.flurry.sdk;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ro
        extends rk {
    rs d;

    protected ro(rs paramrs) {
        this.d = paramrs;
    }

    public String n() {
        return "";
    }

    public final ru s() {
        return this.d.a();
    }

    public static class a
            implements Iterator<hh> {
        static final a a = new a();

        public static a a() {
            return a;
        }

        public hh b() {
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return false;
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    public static class b
            implements Iterator<String> {
        static final b a = new b();

        public static b a() {
            return a;
        }

        public String b() {
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return false;
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */