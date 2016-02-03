package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@ii
public class aa {
    private final int a;
    private final int b;
    private final int c;
    private final aj d;
    private final Object e = new Object();
    private ArrayList<String> f = new ArrayList();
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j;
    private String k = "";

    public aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = new aj(paramInt4);
    }

    private String a(ArrayList<String> paramArrayList, int paramInt) {
        if (paramArrayList.isEmpty()) {
            paramArrayList = "";
        }
        Object localObject;
        do {
            return paramArrayList;
            localObject = new StringBuffer();
            paramArrayList = paramArrayList.iterator();
            do {
                if (!paramArrayList.hasNext()) {
                    break;
                }
                ((StringBuffer) localObject).append((String) paramArrayList.next());
                ((StringBuffer) localObject).append(' ');
            } while (((StringBuffer) localObject).length() <= paramInt);
            ((StringBuffer) localObject).deleteCharAt(((StringBuffer) localObject).length() - 1);
            localObject = ((StringBuffer) localObject).toString();
            paramArrayList = (ArrayList<String>) localObject;
        } while (((String) localObject).length() < paramInt);
        return ((String) localObject).substring(0, paramInt);
    }

    private void c(String paramString) {
        if ((paramString == null) || (paramString.length() < this.c)) {
            return;
        }
        synchronized (this.e) {
            this.f.add(paramString);
            this.g += paramString.length();
            return;
        }
    }

    int a(int paramInt1, int paramInt2) {
        return this.a * paramInt1 + this.b * paramInt2;
    }

    public void a(int paramInt) {
        this.h = paramInt;
    }

    public void a(String arg1) {
        c( ???);
        synchronized (this.e) {
            if (this.i < 0) {
                mx.a("ActivityContent: negative number of WebViews.");
            }
            f();
            return;
        }
    }

    public boolean a() {
        for (; ; ) {
            synchronized (this.e) {
                if (this.i == 0) {
                    bool = true;
                    return bool;
                }
            }
            boolean bool = false;
        }
    }

    public String b() {
        return this.k;
    }

    public void b(String paramString) {
        c(paramString);
    }

    public void c() {
        synchronized (this.e) {
            this.j -= 100;
            return;
        }
    }

    public void d() {
        synchronized (this.e) {
            this.i -= 1;
            return;
        }
    }

    public void e() {
        synchronized (this.e) {
            this.i += 1;
            return;
        }
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof aa)) {
        }
        do {
            return false;
            if (paramObject == this) {
                return true;
            }
            paramObject = (aa) paramObject;
        } while ((((aa) paramObject).b() == null) || (!((aa) paramObject).b().equals(b())));
        return true;
    }

    public void f() {
        synchronized (this.e) {
            int m = a(this.g, this.h);
            if (m > this.j) {
                this.j = m;
                this.k = this.d.a(this.f);
            }
            return;
        }
    }

    public int g() {
        return this.j;
    }

    int h() {
        return this.g;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.h + " score:" + this.j + " total_length:" + this.g + "\n text: " + a(this.f, 200) + "\n signture: " + this.k;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */