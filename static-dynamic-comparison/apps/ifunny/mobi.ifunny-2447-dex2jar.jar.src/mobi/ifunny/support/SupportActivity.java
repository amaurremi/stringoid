package mobi.ifunny.support;

import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.view.MenuItem;
import mobi.ifunny.b.g;
import mobi.ifunny.f;

public class SupportActivity
        extends f {
    private SupportFragment n() {
        return (SupportFragment) f().a("SUPPORT_FRAGMENT");
    }

    public void onBackPressed() {
        SupportFragment localSupportFragment = n();
        if ((localSupportFragment == null) || (!localSupportFragment.q())) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        if (paramBundle == null) {
            paramBundle = f().a();
            paramBundle.a(2131493009, new SupportFragment(), "SUPPORT_FRAGMENT");
            paramBundle.b();
            g.a(this, "Support");
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        SupportFragment localSupportFragment;
        do {
            return super.onOptionsItemSelected(paramMenuItem);
            localSupportFragment = n();
        } while ((localSupportFragment == null) || (!localSupportFragment.q()));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/support/SupportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */