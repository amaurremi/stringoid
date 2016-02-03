package mobi.ifunny.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.widget.Toast;
import mobi.ifunny.a.a;
import mobi.ifunny.a.c;
import mobi.ifunny.f;

public class ProfileActivity
        extends f
        implements c {
    private static final String o = ProfileActivity.class.getSimpleName();
    private a p;

    public void a_(boolean paramBoolean) {
        this.p.b(paramBoolean);
    }

    public void b(boolean paramBoolean) {
        this.p.c(paramBoolean);
    }

    public void onBackPressed() {
        d locald = (d) f().a(2131493009);
        if ((locald != null) && (locald.q())) {
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903140);
        this.p = new a();
        this.p.a(findViewById(2131492867));
        Object localObject;
        if (paramBundle == null) {
            localObject = getIntent();
            paramBundle = ((Intent) localObject).getData();
            if (paramBundle == null) {
                paramBundle = ((Intent) localObject).getStringExtra("intent.uid");
                localObject = f().a();
                ((ab) localObject).a(2131493009, d.a(paramBundle), d.c(paramBundle));
                ((ab) localObject).b();
            }
        } else {
            return;
        }
        try {
            localObject = paramBundle.getQueryParameter("name");
            if (TextUtils.isEmpty((CharSequence) localObject)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception localException) {
            mobi.ifunny.d.c(o, "Can not parse data uri " + paramBundle, localException);
            Toast.makeText(this, getString(2131689608), 0).show();
            finish();
            return;
        }
        ab localab = f().a();
        localab.a(2131493009, d.b(localException), d.d(localException));
        localab.b();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.p.a();
    }

    protected void onPause() {
        super.onPause();
        this.p.b();
    }

    protected void onResume() {
        super.onResume();
        this.p.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/ProfileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */