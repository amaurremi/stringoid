package uk.co.a.a.a.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import uk.co.a.a.b.e;
import uk.co.a.a.b.g;

public class c
        extends g {
    private FrameLayout a;

    public c(Activity paramActivity, e parame) {
        super(paramActivity, parame);
    }

    protected uk.co.a.a.b.c a() {
        return new d();
    }

    protected void a(View paramView) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.a(paramView);
        }
        Activity localActivity;
        do {
            return;
            localActivity = l();
        } while ((localActivity == null) || (localActivity.getWindow() == null));
        this.a = new FrameLayout(localActivity);
        this.a.addView(paramView);
        super.a(this.a);
    }

    protected uk.co.a.a.b.d b() {
        return new a();
    }

    protected void b(View paramView) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.b(paramView);
        }
        while (this.a == null) {
            return;
        }
        super.b(this.a);
    }

    protected void c(View paramView) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.c(paramView);
        }
        while (this.a == null) {
            return;
        }
        super.c(this.a);
        this.a = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */