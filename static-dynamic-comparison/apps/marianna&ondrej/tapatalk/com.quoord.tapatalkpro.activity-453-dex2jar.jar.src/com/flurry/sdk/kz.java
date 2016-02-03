package com.flurry.sdk;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class kz {
    private final a[] a;
    private final int b;
    private final int c;

    public kz(Collection<kt> paramCollection) {
        this.c = paramCollection.size();
        int i = a(this.c);
        this.b = (i - 1);
        a[] arrayOfa = new a[i];
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            kt localkt = (kt) paramCollection.next();
            String str = localkt.c();
            i = str.hashCode() & this.b;
            arrayOfa[i] = new a(arrayOfa[i], str, localkt);
        }
        this.a = arrayOfa;
    }

    private static final int a(int paramInt) {
        if (paramInt <= 32) {
            paramInt += paramInt;
        }
        int i;
        for (; ; ) {
            i = 2;
            while (i < paramInt) {
                i += i;
            }
            paramInt = (paramInt >> 2) + paramInt;
        }
        return i;
    }

    private kt a(String paramString, int paramInt) {
        for (a locala = this.a[paramInt]; locala != null; locala = locala.a) {
            if (paramString.equals(locala.b)) {
                return locala.c;
            }
        }
        return null;
    }

    public kt a(String paramString) {
        int i = paramString.hashCode();
        i = this.b & i;
        a locala2 = this.a[i];
        if (locala2 == null) {
            return null;
        }
        a locala1 = locala2;
        if (locala2.b == paramString) {
            return locala2.c;
        }
        do {
            locala2 = locala1.a;
            if (locala2 == null) {
                break;
            }
            locala1 = locala2;
        } while (locala2.b != paramString);
        return locala2.c;
        return a(paramString, i);
    }

    public void a() {
        a[] arrayOfa = this.a;
        int k = arrayOfa.length;
        int i = 0;
        int j = 0;
        while (i < k) {
            a locala = arrayOfa[i];
            while (locala != null) {
                locala.c.a(j);
                locala = locala.a;
                j += 1;
            }
            i += 1;
        }
    }

    public void a(kt paramkt) {
        String str = paramkt.c();
        int j = str.hashCode() & this.a.length - 1;
        a locala1 = this.a[j];
        int i = 0;
        a locala2 = null;
        if (locala1 != null) {
            if ((i == 0) && (locala1.b.equals(str))) {
                i = 1;
            }
            for (; ; ) {
                locala1 = locala1.a;
                break;
                locala2 = new a(locala2, locala1.b, locala1.c);
            }
        }
        if (i == 0) {
            throw new NoSuchElementException("No entry '" + paramkt + "' found, can't replace");
        }
        this.a[j] = new a(locala2, str, paramkt);
    }

    public int b() {
        return this.c;
    }

    public void b(kt paramkt) {
        String str = paramkt.c();
        int j = str.hashCode() & this.a.length - 1;
        a locala1 = this.a[j];
        int i = 0;
        a locala2 = null;
        if (locala1 != null) {
            if ((i == 0) && (locala1.b.equals(str))) {
                i = 1;
            }
            for (; ; ) {
                locala1 = locala1.a;
                break;
                locala2 = new a(locala2, locala1.b, locala1.c);
            }
        }
        if (i == 0) {
            throw new NoSuchElementException("No entry '" + paramkt + "' found, can't remove");
        }
        this.a[j] = locala2;
    }

    public Iterator<kt> c() {
        return new b(this.a);
    }

    static final class a {
        public final a a;
        public final String b;
        public final kt c;

        public a(a parama, String paramString, kt paramkt) {
            this.a = parama;
            this.b = paramString;
            this.c = paramkt;
        }
    }

    static final class b
            implements Iterator<kt> {
        private final kz.a[] a;
        private kz.a b;
        private int c;

        public b(kz.a[] paramArrayOfa) {
            this.a = paramArrayOfa;
            int i = 0;
            int k = this.a.length;
            int j;
            if (i < k) {
                paramArrayOfa = this.a;
                j = i + 1;
                paramArrayOfa = paramArrayOfa[i];
                if (paramArrayOfa != null) {
                    this.b = paramArrayOfa;
                }
            }
            for (; ; ) {
                this.c = j;
                return;
                i = j;
                break;
                j = i;
            }
        }

        public kt a() {
            kz.a locala = this.b;
            if (locala == null) {
                throw new NoSuchElementException();
            }
            int i;
            for (Object localObject = locala.a; (localObject == null) && (this.c < this.a.length); localObject = localObject[i]) {
                localObject = this.a;
                i = this.c;
                this.c = (i + 1);
            }
            this.b = ((kz.a) localObject);
            return locala.c;
        }

        public boolean hasNext() {
            return this.b != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */