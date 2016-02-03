package mobi.ifunny.profile.editor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.b.g;
import mobi.ifunny.f;
import mobi.ifunny.rest.content.User;

public class ProfileEditorActivity
        extends f {
    protected void a(android.support.v7.a.a parama) {
    }

    public void onBackPressed() {
        a locala = (a) f().a(2131493009);
        if (locala == null) {
            super.onBackPressed();
        }
        while (!locala.b()) {
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        if (paramBundle == null) {
            paramBundle = (User) getIntent().getParcelableExtra("intent.profile");
            ab localab = f().a();
            localab.a(2131493009, a.a(paramBundle), "fragment");
            localab.b();
            g.a(this, "EditProfile");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/ProfileEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */