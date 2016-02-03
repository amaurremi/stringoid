package com.flurry.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class qu {
    final qs a;

    public qu(qs paramqs) {
        this.a = paramqs;
    }

    protected sh a(a parama)
            throws IllegalArgumentException {
        if (!parama.hasMoreTokens()) {
            throw a(parama, "Unexpected end-of-string");
        }
        Class localClass = a(parama.nextToken(), parama);
        if (parama.hasMoreTokens()) {
            String str = parama.nextToken();
            if ("<".equals(str)) {
                return this.a.a(localClass, b(parama));
            }
            parama.a(str);
        }
        return this.a.a(localClass, null);
    }

    public sh a(String paramString)
            throws IllegalArgumentException {
        paramString = new a(paramString.trim());
        sh localsh = a(paramString);
        if (paramString.hasMoreTokens()) {
            throw a(paramString, "Unexpected tokens after complete type");
        }
        return localsh;
    }

    protected Class<?> a(String paramString, a parama) {
        try {
            Class localClass = Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
            return localClass;
        } catch (Exception localException) {
            if ((localException instanceof RuntimeException)) {
                throw ((RuntimeException) localException);
            }
            throw a(parama, "Can not locate class '" + paramString + "', problem: " + localException.getMessage());
        }
    }

    protected IllegalArgumentException a(a parama, String paramString) {
        return new IllegalArgumentException("Failed to parse type '" + parama.a() + "' (remaining: '" + parama.b() + "'): " + paramString);
    }

    protected List<sh> b(a parama)
            throws IllegalArgumentException {
        ArrayList localArrayList = new ArrayList();
        String str;
        do {
            if (parama.hasMoreTokens()) {
                localArrayList.add(a(parama));
                if (parama.hasMoreTokens()) {
                }
            } else {
                throw a(parama, "Unexpected end-of-string");
            }
            str = parama.nextToken();
            if (">".equals(str)) {
                return localArrayList;
            }
        } while (",".equals(str));
        throw a(parama, "Unexpected token '" + str + "', expected ',' or '>')");
    }

    static final class a
            extends StringTokenizer {
        protected final String a;
        protected int b;
        protected String c;

        public a(String paramString) {
            super("<,>", true);
            this.a = paramString;
        }

        public String a() {
            return this.a;
        }

        public void a(String paramString) {
            this.c = paramString;
            this.b -= paramString.length();
        }

        public String b() {
            return this.a.substring(this.b);
        }

        public boolean hasMoreTokens() {
            return (this.c != null) || (super.hasMoreTokens());
        }

        public String nextToken() {
            String str;
            if (this.c != null) {
                str = this.c;
                this.c = null;
            }
            for (; ; ) {
                this.b += str.length();
                return str;
                str = super.nextToken();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */