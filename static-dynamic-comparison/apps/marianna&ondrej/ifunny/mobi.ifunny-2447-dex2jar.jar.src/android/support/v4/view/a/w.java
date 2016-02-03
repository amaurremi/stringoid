package android.support.v4.view.a;

import android.os.Build.VERSION;

public class w {
    private static final z a = new ab();
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new aa();
            return;
        }
        if (Build.VERSION.SDK_INT >= 15) {
            a = new y();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a = new x();
            return;
        }
    }

    public w(Object paramObject) {
        this.b = paramObject;
    }

    public static w a() {
        return new w(a.a());
    }

    public void a(int paramInt) {
        a.b(this.b, paramInt);
    }

    public void a(boolean paramBoolean) {
        a.a(this.b, paramBoolean);
    }

    public void b(int paramInt) {
        a.a(this.b, paramInt);
    }

    public void c(int paramInt) {
        a.c(this.b, paramInt);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            do {
                return true;
                if (paramObject == null) {
                    return false;
                }
                if (getClass() != paramObject.getClass()) {
                    return false;
                }
                paramObject = (w) paramObject;
                if (this.b != null) {
                    break;
                }
            } while (((w) paramObject).b == null);
            return false;
        } while (this.b.equals(((w) paramObject).b));
        return false;
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */