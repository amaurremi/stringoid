package mobi.ifunny.profile.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.b.g;
import mobi.ifunny.f;
import mobi.ifunny.rest.content.User;

public class ProfileSettingsActivity
        extends f {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        if (paramBundle == null) {
            Object localObject = (User) getIntent().getParcelableExtra("intent.profile");
            paramBundle = f().a();
            localObject = e.c((User) localObject);
            paramBundle.a(2131493009, (Fragment) localObject, ((e) localObject).e());
            paramBundle.b();
            g.a(this, "AccountSettings");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/ProfileSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */