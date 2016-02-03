package com.google.android.gms.a;

import java.util.SortedSet;
import java.util.TreeSet;

class bl {
    private static final bl d = new bl();
    private SortedSet<bm> a = new TreeSet();
    private StringBuilder b = new StringBuilder();
    private boolean c = false;

    public static bl a() {
        return d;
    }

    public void a(bm parambm) {
        try {
            if (!this.c) {
                this.a.add(parambm);
                this.b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parambm.ordinal()));
            }
            return;
        } finally {
            parambm =finally;
            throw parambm;
        }
    }

    public void a(boolean paramBoolean) {
        try {
            this.c = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public String b() {
        try {
            Object localObject1 = new StringBuilder();
            int j = 6;
            int i = 0;
            while (this.a.size() > 0) {
                bm localbm = (bm) this.a.first();
                this.a.remove(localbm);
                int k = localbm.ordinal();
                while (k >= j) {
                    ((StringBuilder) localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
                    j += 6;
                    i = 0;
                }
                i += (1 << localbm.ordinal() % 6);
            }
            if ((i > 0) || (((StringBuilder) localObject1).length() == 0)) {
                ((StringBuilder) localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
            }
            this.a.clear();
            localObject1 = ((StringBuilder) localObject1).toString();
            return (String) localObject1;
        } finally {
        }
    }

    public String c() {
        try {
            if (this.b.length() > 0) {
                this.b.insert(0, ".");
            }
            String str = this.b.toString();
            this.b = new StringBuilder();
            return str;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */