package mobi.ifunny.preferences;

import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.b.g;
import mobi.ifunny.f;

public class PreferencesActivity
        extends f {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        if (paramBundle == null) {
            paramBundle = f().a();
            paramBundle.a(2131493009, new PreferencesFragment(), "PREFERENCES_FRAGMENT");
            paramBundle.b();
            g.a(this, "Preferences");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/preferences/PreferencesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */