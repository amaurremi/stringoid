package mobi.ifunny.util.a;

import android.graphics.Point;
import android.graphics.Rect;

public class a {
    private static final a a = new a(null);
    private String b;
    private Point c;
    private boolean d;
    private Rect e;
    private String f;

    public a(Point paramPoint, boolean paramBoolean) {
        this(null, paramPoint, paramBoolean);
    }

    public a(Point paramPoint, boolean paramBoolean, Rect paramRect) {
        this(null, paramPoint, paramBoolean, paramRect);
    }

    public a(String paramString) {
        this(paramString, null, false);
    }

    public a(String paramString, Point paramPoint, boolean paramBoolean) {
        this(paramString, paramPoint, paramBoolean, null);
    }

    public a(String paramString, Point paramPoint, boolean paramBoolean, Rect paramRect) {
        this.b = paramString;
        this.c = paramPoint;
        this.d = paramBoolean;
        this.e = new Rect();
        if (paramRect != null) {
            this.e.set(paramRect);
        }
    }

    public static a a() {
        return a;
    }

    public void a(String paramString) {
        this.f = paramString;
    }

    public Rect b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public Point d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof a)) {
                return false;
            }
            paramObject = (a) paramObject;
            if (this.d != ((a) paramObject).d) {
                return false;
            }
            if (this.e != null) {
                if (this.e.equals(((a) paramObject).e)) {
                }
            } else {
                while (((a) paramObject).e != null) {
                    return false;
                }
            }
            if (this.f != null) {
                if (this.f.equals(((a) paramObject).f)) {
                }
            } else {
                while (((a) paramObject).f != null) {
                    return false;
                }
            }
            if (this.c != null) {
                if (this.c.equals(((a) paramObject).c)) {
                }
            } else {
                while (((a) paramObject).c != null) {
                    return false;
                }
            }
            if (this.b == null) {
                break;
            }
        } while (this.b.equals(((a) paramObject).b));
        for (; ; ) {
            return false;
            if (((a) paramObject).b == null) {
                break;
            }
        }
    }

    public String f() {
        return this.f;
    }

    public int hashCode() {
        int n = 0;
        int i;
        int j;
        label33:
        int k;
        if (this.b != null) {
            i = this.b.hashCode();
            if (this.c == null) {
                break label103;
            }
            j = this.c.hashCode();
            if (!this.d) {
                break label108;
            }
            k = 1;
            label42:
            if (this.e == null) {
                break label113;
            }
        }
        label103:
        label108:
        label113:
        for (int m = this.e.hashCode(); ; m = 0) {
            if (this.f != null) {
                n = this.f.hashCode();
            }
            return (m + (k + (j + i * 31) * 31) * 31) * 31 + n;
            i = 0;
            break;
            j = 0;
            break label33;
            k = 0;
            break label42;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */