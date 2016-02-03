package mobi.ifunny.social.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.widget.Toast;
import mobi.ifunny.f;
import mobi.ifunny.social.share.a.d;

public class ShareActivity
        extends f
        implements b {
    private int o;
    private SharingContent p;

    protected void a(android.support.v7.a.a parama) {
    }

    public void b(String paramString) {
        if ((this.o != 1) && (!TextUtils.isEmpty(paramString))) {
            Toast.makeText(this, paramString, 1).show();
        }
        finish();
    }

    public void n() {
        finish();
    }

    public void o() {
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getIntent();
        this.o = paramBundle.getIntExtra("INTENT_SHARE_TYPE", 1);
        this.p = ((SharingContent) paramBundle.getParcelableExtra("INTENT_SHARE_CONTENT"));
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        if (paramBundle == null) {
            paramBundle = null;
            switch (this.o) {
            }
        }
        for (; ; ) {
            q localq = f();
            ab localab = localq.a();
            localab.a(paramBundle, "TAG_SHARE");
            localab.b();
            localq.b();
            paramBundle.a(this.p);
            return;
            paramBundle = new d();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/ShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */