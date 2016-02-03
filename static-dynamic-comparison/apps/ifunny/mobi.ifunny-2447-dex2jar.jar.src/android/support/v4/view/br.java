package android.support.v4.view;

import android.view.View;

class br {
    public static void a(View paramView, int paramInt) {
        paramView.setImportantForAccessibility(paramInt);
    }

    public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public static void a(View paramView, Runnable paramRunnable) {
        paramView.postOnAnimation(paramRunnable);
    }

    public static boolean a(View paramView) {
        return paramView.hasTransientState();
    }

    public static void b(View paramView) {
        paramView.postInvalidateOnAnimation();
    }

    public static int c(View paramView) {
        return paramView.getImportantForAccessibility();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */