package android.support.v7.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aj;
import android.support.v7.c.b;
import android.support.v7.internal.view.f;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

abstract class h {
    final g a;
    boolean b;
    boolean c;
    private a d;
    private MenuInflater e;
    private boolean f;

    h(g paramg) {
        this.a = paramg;
    }

    static h a(g paramg) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new i(paramg);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new r(paramg);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new q(paramg);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new o(paramg);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new n(paramg);
        }
        return new k(paramg);
    }

    abstract a a();

    abstract android.support.v7.c.a a(b paramb);

    abstract void a(int paramInt);

    abstract void a(Configuration paramConfiguration);

    void a(Bundle paramBundle) {
        paramBundle = this.a.obtainStyledAttributes(android.support.v7.b.k.ActionBarWindow);
        if (!paramBundle.hasValue(0)) {
            paramBundle.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        this.b = paramBundle.getBoolean(0, false);
        this.c = paramBundle.getBoolean(1, false);
        paramBundle.recycle();
        if (aj.b(this.a) != null) {
            if (this.d == null) {
                this.f = true;
            }
        } else {
            return;
        }
        this.d.a(true);
    }

    abstract void a(View paramView);

    abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);

    abstract void a(CharSequence paramCharSequence);

    abstract boolean a(int paramInt, Menu paramMenu);

    abstract boolean a(int paramInt, MenuItem paramMenuItem);

    abstract boolean a(int paramInt, View paramView, Menu paramMenu);

    boolean a(View paramView, Menu paramMenu) {
        if (Build.VERSION.SDK_INT < 16) {
            return this.a.onPrepareOptionsMenu(paramMenu);
        }
        return this.a.b(paramView, paramMenu);
    }

    final a b() {
        if ((this.b) || (this.c)) {
            if (this.d == null) {
                this.d = a();
                if (this.f) {
                    this.d.a(true);
                }
            }
        }
        for (; ; ) {
            return this.d;
            this.d = null;
        }
    }

    abstract View b(int paramInt);

    abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);

    MenuInflater c() {
        if (this.e == null) {
            this.e = new f(j());
        }
        return this.e;
    }

    abstract void d();

    abstract void e();

    abstract void f();

    abstract boolean g();

    abstract void h();

    protected final String i() {
        String str = null;
        try {
            ActivityInfo localActivityInfo = this.a.getPackageManager().getActivityInfo(this.a.getComponentName(), 128);
            if (localActivityInfo.metaData != null) {
                str = localActivityInfo.metaData.getString("android.support.UI_OPTIONS");
            }
            return str;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            Log.e("ActionBarActivityDelegate", "getUiOptionsFromMetadata: Activity '" + this.a.getClass().getSimpleName() + "' not in manifest");
        }
        return null;
    }

    protected final Context j() {
        Object localObject = this.a;
        a locala = b();
        if (locala != null) {
            localObject = locala.i();
        }
        return (Context) localObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */