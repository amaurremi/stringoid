package com.a.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.TextView;

public class a {
    public static final b a = new b(5000, j.alert);
    public static final b b = new b(3000, j.confirm);
    public static final b c = new b(3000, j.info);
    Animation d;
    Animation e;
    int f = 0;
    private final Activity g;
    private int h = 3000;
    private View i;
    private ViewGroup j;
    private ViewGroup.LayoutParams k;
    private boolean l;

    public a(Activity paramActivity) {
        this.g = paramActivity;
    }

    public static a a(Activity paramActivity, CharSequence paramCharSequence, b paramb, int paramInt) {
        return a(paramActivity, paramCharSequence, paramb, ((LayoutInflater) paramActivity.getSystemService("layout_inflater")).inflate(paramInt, null), true);
    }

    private static a a(Activity paramActivity, CharSequence paramCharSequence, b paramb, View paramView, boolean paramBoolean) {
        return a(paramActivity, paramCharSequence, paramb, paramView, paramBoolean, 0.0F);
    }

    private static a a(Activity paramActivity, CharSequence paramCharSequence, b paramb, View paramView, boolean paramBoolean, float paramFloat) {
        paramActivity = new a(paramActivity);
        paramView.setBackgroundResource(b.a(paramb));
        TextView localTextView = (TextView) paramView.findViewById(16908299);
        if (paramFloat > 0.0F) {
            localTextView.setTextSize(paramFloat);
        }
        localTextView.setText(paramCharSequence);
        paramActivity.i = paramView;
        paramActivity.h = b.b(paramb);
        paramActivity.l = paramBoolean;
        return paramActivity;
    }

    public void a() {
        c.a(this.g).a(this);
    }

    public boolean b() {
        if (this.l) {
            if ((this.i == null) || (this.i.getParent() == null)) {
            }
        }
        while (this.i.getVisibility() == 0) {
            return true;
            return false;
        }
        return false;
    }

    public void c() {
        c.a(this.g).b(this);
    }

    public Activity d() {
        return this.g;
    }

    public View e() {
        return this.i;
    }

    public int f() {
        return this.h;
    }

    public ViewGroup.LayoutParams g() {
        if (this.k == null) {
            this.k = new ViewGroup.LayoutParams(-1, -2);
        }
        return this.k;
    }

    public boolean h() {
        return this.l;
    }

    public ViewGroup i() {
        return this.j;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */