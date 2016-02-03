package android.support.v4.view;

import android.view.View;

class bj
        extends bi {
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        br.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void a(View paramView, Runnable paramRunnable) {
        br.a(paramView, paramRunnable);
    }

    public boolean b(View paramView) {
        return br.a(paramView);
    }

    public void c(View paramView) {
        br.b(paramView);
    }

    public void c(View paramView, int paramInt) {
        int i = paramInt;
        if (paramInt == 4) {
            i = 2;
        }
        br.a(paramView, i);
    }

    public int d(View paramView) {
        return br.c(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */