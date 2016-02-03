package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ou {
    private final a[] a;
    private final int b;

    public ou(Map<ox.a, jk<Object>> paramMap) {
        int i = a(paramMap.size());
        this.b = i;
        a[] arrayOfa = new a[i];
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            ox.a locala = (ox.a) localEntry.getKey();
            int j = locala.hashCode() & i - 1;
            arrayOfa[j] = new a(arrayOfa[j], locala, (jk) localEntry.getValue());
        }
        this.a = arrayOfa;
    }

    private static final int a(int paramInt) {
        if (paramInt <= 64) {
            paramInt += paramInt;
        }
        int i;
        for (; ; ) {
            i = 8;
            while (i < paramInt) {
                i += i;
            }
            paramInt = (paramInt >> 2) + paramInt;
        }
        return i;
    }

    public jk<Object> a(ox.a parama) {
        int i = parama.hashCode();
        int j = this.a.length;
        a locala2 = this.a[(i & j - 1)];
        if (locala2 == null) {
            return null;
        }
        a locala1 = locala2;
        if (parama.equals(locala2.a)) {
            return locala2.b;
        }
        do {
            locala2 = locala1.c;
            if (locala2 == null) {
                break;
            }
            locala1 = locala2;
        } while (!parama.equals(locala2.a));
        return locala2.b;
        return null;
    }

    static final class a {
        public final ox.a a;
        public final jk<Object> b;
        public final a c;

        public a(a parama, ox.a parama1, jk<Object> paramjk) {
            this.c = parama;
            this.a = parama1;
            this.b = paramjk;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */