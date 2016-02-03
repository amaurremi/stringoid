package mobi.ifunny.profile;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.emilsjolander.components.StickyScrollViewItems.StickyScrollView;
import mobi.ifunny.profile.fragments.b;
import mobi.ifunny.view.FragmentTabWidget;

class v
        implements ViewTreeObserver.OnGlobalLayoutListener {
    private v(l paraml) {
    }

    public void onGlobalLayout() {
        int i = 1;
        if (this.a.getActivity() == null) {
            return;
        }
        l.b(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        Object localObject1 = this.a.getResources().getConfiguration();
        label48:
        int k;
        int j;
        label70:
        int m;
        int n;
        if (((Configuration) localObject1).orientation == 1) {
            k = ((Configuration) localObject1).screenLayout;
            if (i == 0) {
                break label427;
            }
            j = l.c(this.a).getMeasuredHeight();
            m = l.b(this.a).getWidth();
            n = l.b(this.a).getHeight();
            switch (k & 0xF) {
                default:
                    if (i != 0) {
                        l.a(this.a, new FrameLayout.LayoutParams(m, n - l.d(this.a).getMeasuredHeight() - j, 49));
                    }
                    break;
            }
        }
        for (; ; ) {
            localObject1 = l.e(this.a).getLayoutParams();
            j = n - j;
            if (((ViewGroup.LayoutParams) localObject1).height != j) {
                ((ViewGroup.LayoutParams) localObject1).height = j;
                l.e(this.a).setLayoutParams((ViewGroup.LayoutParams) localObject1);
                l.b(this.a).getViewTreeObserver().addOnGlobalLayoutListener(l.f(this.a));
                l.b(this.a).getViewTreeObserver().addOnPreDrawListener(l.g(this.a));
            }
            if (i == 0) {
                localObject1 = l.d(this.a).getLayoutParams();
                j = l.d(this.a).getMeasuredWidth() / 2;
                ((ViewGroup.LayoutParams) localObject1).width = -1;
                ((ViewGroup.LayoutParams) localObject1).height = j;
                i = l.h(this.a).getMeasuredHeight();
                j = (int) (j * 0.6F);
                if (i > j) {
                    Object localObject2 = l.h(this.a).getLayoutParams();
                    ((ViewGroup.LayoutParams) localObject2).height = j;
                    ((ViewGroup.LayoutParams) localObject2).width = j;
                    l.h(this.a).setLayoutParams((ViewGroup.LayoutParams) localObject2);
                    localObject2 = l.i(this.a);
                    float f = l.i(this.a).getTextSize();
                    ((TextView) localObject2).setTextSize(0, j * f / i);
                }
                l.d(this.a).setLayoutParams((ViewGroup.LayoutParams) localObject1);
            }
            if (l.j(this.a) == null) {
                break;
            }
            l.j(this.a).a(l.k(this.a), l.l(this.a));
            return;
            i = 0;
            break label48;
            label427:
            j = 0;
            break label70;
            if (i != 0) {
                localObject1 = l.d(this.a).getLayoutParams();
                k = m / 2;
                ((ViewGroup.LayoutParams) localObject1).width = -1;
                ((ViewGroup.LayoutParams) localObject1).height = k;
                l.d(this.a).setLayoutParams((ViewGroup.LayoutParams) localObject1);
                l.a(this.a, new FrameLayout.LayoutParams(m, n - k - j, 49));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */