package com.umeng.analytics.b;

import android.content.Context;
import com.umeng.analytics.d.b;
import com.umeng.analytics.d.i;
import com.umeng.analytics.d.p;
import com.umeng.analytics.d.x;
import com.umeng.analytics.d.z;

public abstract class g
        implements f {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    private z d = new z();
    private p e = new p();
    private String f = null;
    private Context g;

    public g(Context paramContext) {
        this.g = paramContext;
    }

    public void a(b paramb) {
        try {
            this.d.a(paramb);
            return;
        } finally {
            paramb =finally;
            throw paramb;
        }
    }

    public void a(com.umeng.analytics.d.g paramg) {
        try {
            this.e.a(paramg);
            return;
        } finally {
            paramg =finally;
            throw paramg;
        }
    }

    public void a(i parami) {
        this.e.b(parami);
    }

    public void a(x paramx) {
        try {
            this.d.a(paramx);
            return;
        } finally {
            paramx =finally;
            throw paramx;
        }
    }

    public void a(String paramString) {
        try {
            this.f = paramString;
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public boolean a(int paramInt) {
        return true;
    }

    public void b(i parami) {
        try {
            this.e.a(parami);
            return;
        } finally {
            parami =finally;
            throw parami;
        }
    }

    public Context e() {
        return this.g;
    }

    public int f() {
        int j = 0 + this.e.l() + this.e.f() + this.d.x() + this.e.q();
        int i = j;
        if (this.d.r()) {
            i = j + 1;
        }
        return i;
    }

    public z g() {
        try {
            Object localObject1 = this.f;
            if ((!this.e.e()) && (localObject1 != null)) {
                this.e.a((String) localObject1);
            }
            if ((this.e.e()) && ((this.e.k()) || (this.e.p()) || (this.e.u()))) {
                this.d.a(this.e);
                this.e = new p();
            }
            localObject1 = this.d;
            this.d = new z();
            return (z) localObject1;
        } finally {
        }
    }

    public void h() {
        try {
            this.d.b();
            this.e.b();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean i() {
        try {
            boolean bool = this.d.r();
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */