package uk.co.a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class a
        extends uk.co.a.a.b.a {
    private Animation a;
    private Animation b;

    protected Drawable a(Context paramContext) {
        if (Build.VERSION.SDK_INT >= super.d()) {
            return super.a(paramContext);
        }
        paramContext = a(paramContext, g.actionBarStyle, i.ActionBar);
        try {
            Drawable localDrawable = paramContext.getDrawable(i.ActionBar_background);
            return localDrawable;
        } finally {
            paramContext.recycle();
        }
    }

    public void a(Activity paramActivity, View paramView) {
        super.a(paramActivity, paramView);
        this.a = AnimationUtils.loadAnimation(paramActivity, f.fade_in);
        this.b = AnimationUtils.loadAnimation(paramActivity, f.fade_out);
        if ((this.b != null) || (this.a != null)) {
            paramActivity = new b(this);
            if (this.b != null) {
                this.b.setAnimationListener(paramActivity);
            }
        }
    }

    public boolean a() {
        boolean bool2;
        if (Build.VERSION.SDK_INT >= super.d()) {
            bool2 = super.a();
            return bool2;
        }
        View localView = g();
        if ((localView != null) && (localView.getVisibility() != 0)) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            bool2 = bool1;
            if (!bool1) {
                break;
            }
            if (this.a != null) {
                localView.startAnimation(this.a);
            }
            localView.setVisibility(0);
            return bool1;
        }
    }

    protected int b(Context paramContext) {
        if (Build.VERSION.SDK_INT >= super.d()) {
            return super.b(paramContext);
        }
        paramContext = paramContext.obtainStyledAttributes(new int[]{g.actionBarSize});
        try {
            int i = paramContext.getDimensionPixelSize(0, 0);
            return i;
        } finally {
            paramContext.recycle();
        }
    }

    public boolean b() {
        boolean bool2;
        if (Build.VERSION.SDK_INT >= super.d()) {
            bool2 = super.b();
            return bool2;
        }
        View localView = g();
        if ((localView != null) && (localView.getVisibility() != 8)) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            bool2 = bool1;
            if (!bool1) {
                break;
            }
            if (this.b == null) {
                break label65;
            }
            localView.startAnimation(this.b);
            return bool1;
        }
        label65:
        localView.setVisibility(8);
        e();
        return bool1;
    }

    protected int c(Context paramContext) {
        if (Build.VERSION.SDK_INT >= super.d()) {
            return super.c(paramContext);
        }
        paramContext = a(paramContext, g.actionBarStyle, i.ActionBar);
        try {
            int i = paramContext.getResourceId(i.ActionBar_titleTextStyle, 0);
            return i;
        } finally {
            paramContext.recycle();
        }
    }

    public void c() {
        if (Build.VERSION.SDK_INT >= super.d()) {
            super.c();
        }
        View localView;
        do {
            return;
            localView = g().findViewById(h.ptr_content);
        } while (localView == null);
        localView.startAnimation(AnimationUtils.loadAnimation(localView.getContext(), f.fade_out));
        localView.setVisibility(4);
    }

    protected int d() {
        return 7;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */