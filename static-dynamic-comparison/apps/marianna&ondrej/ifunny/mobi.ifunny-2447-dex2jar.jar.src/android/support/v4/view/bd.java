package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public class bd {
    static final bm a = new be();

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            a = new bl();
            return;
        }
        if (i >= 17) {
            a = new bk();
            return;
        }
        if (i >= 16) {
            a = new bj();
            return;
        }
        if (i >= 14) {
            a = new bi();
            return;
        }
        if (i >= 11) {
            a = new bh();
            return;
        }
        if (i >= 9) {
            a = new bg();
            return;
        }
    }

    public static int a(View paramView) {
        return a.a(paramView);
    }

    public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public static void a(View paramView, int paramInt, Paint paramPaint) {
        a.a(paramView, paramInt, paramPaint);
    }

    public static void a(View paramView, Paint paramPaint) {
        a.a(paramView, paramPaint);
    }

    public static void a(View paramView, a parama) {
        a.a(paramView, parama);
    }

    public static void a(View paramView, Runnable paramRunnable) {
        a.a(paramView, paramRunnable);
    }

    public static boolean a(View paramView, int paramInt) {
        return a.a(paramView, paramInt);
    }

    public static boolean b(View paramView) {
        return a.b(paramView);
    }

    public static boolean b(View paramView, int paramInt) {
        return a.b(paramView, paramInt);
    }

    public static void c(View paramView) {
        a.c(paramView);
    }

    public static void c(View paramView, int paramInt) {
        a.c(paramView, paramInt);
    }

    public static int d(View paramView) {
        return a.d(paramView);
    }

    public static int e(View paramView) {
        return a.e(paramView);
    }

    public static int f(View paramView) {
        return a.f(paramView);
    }

    public static boolean g(View paramView) {
        return a.g(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */