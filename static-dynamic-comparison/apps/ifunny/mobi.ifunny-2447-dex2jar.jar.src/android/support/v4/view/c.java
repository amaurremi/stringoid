package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class c
        implements j {
    c(b paramb, a parama) {
    }

    public void a(View paramView, int paramInt) {
        this.a.a(paramView, paramInt);
    }

    public void a(View paramView, Object paramObject) {
        this.a.a(paramView, new android.support.v4.view.a.a(paramObject));
    }

    public boolean a(View paramView, AccessibilityEvent paramAccessibilityEvent) {
        return this.a.b(paramView, paramAccessibilityEvent);
    }

    public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
        return this.a.a(paramViewGroup, paramView, paramAccessibilityEvent);
    }

    public void b(View paramView, AccessibilityEvent paramAccessibilityEvent) {
        this.a.d(paramView, paramAccessibilityEvent);
    }

    public void c(View paramView, AccessibilityEvent paramAccessibilityEvent) {
        this.a.c(paramView, paramAccessibilityEvent);
    }

    public void d(View paramView, AccessibilityEvent paramAccessibilityEvent) {
        this.a.a(paramView, paramAccessibilityEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */