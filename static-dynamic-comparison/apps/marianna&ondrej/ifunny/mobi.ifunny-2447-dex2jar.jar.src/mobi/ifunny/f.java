package mobi.ifunny;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.aj;
import android.support.v4.app.ct;
import android.support.v7.a.a;
import android.support.v7.a.g;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class f
        extends g {
    private static final String o = f.class.getSimpleName();
    private boolean p;

    protected void a() {
        super.a();
        this.p = true;
    }

    protected void a(a parama) {
        parama.d(true);
        if (k()) {
            parama = findViewById(16908332);
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams) parama.getLayoutParams();
            localMarginLayoutParams.setMargins(0, 0, 0, 0);
            parama.setLayoutParams(localMarginLayoutParams);
        }
    }

    protected boolean k() {
        return true;
    }

    public boolean l() {
        return this.p;
    }

    protected boolean m() {
        boolean bool = false;
        try {
            PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            long l1 = localPackageInfo.firstInstallTime;
            long l2 = localPackageInfo.lastUpdateTime;
            if (l1 < l2) {
                bool = true;
            }
            return bool;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            d.e(o, "packageInfo wasn't found");
        }
        return false;
    }

    public void onBackPressed() {
        if (!l()) {
            return;
        }
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 16908332) {
            paramMenuItem = aj.a(this);
            if (paramMenuItem == null) {
                d.c(o, "No explicit parent activity, just go back");
                onBackPressed();
                return true;
            }
            d.c(o, "Up to component " + paramMenuItem.getComponent().toString());
            if (aj.a(this, paramMenuItem)) {
                d.c(o, "Should recreate task");
                ct.a(this).b(paramMenuItem).a();
                return true;
            }
            d.c(o, "Go up w/o recreating task");
            aj.b(this, paramMenuItem);
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    protected void onPause() {
        this.p = false;
        super.onPause();
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        a(h());
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        this.p = false;
        super.onSaveInstanceState(paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */