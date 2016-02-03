package mobi.ifunny.studio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.q;
import android.widget.Toast;
import mobi.ifunny.d;
import mobi.ifunny.f;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.social.auth.l;

public class ExportActivity
        extends f {
    private static final String o = ExportActivity.class.getSimpleName();

    private void o() {
        Intent localIntent = getIntent();
        if (localIntent.getType().contains("gif")) {
            d(localIntent);
            return;
        }
        c(localIntent);
    }

    void c(Intent paramIntent) {
        paramIntent = (Uri) paramIntent.getParcelableExtra("android.intent.extra.STREAM");
        if (paramIntent != null) {
            d.d(o, String.format("Image was received: %s", new Object[]{paramIntent}));
            q localq = f();
            c localc = (c) localq.a("static_pic_dialog");
            if (localc != null) {
                localc.b();
                localq.b();
            }
            c.a(paramIntent).a(f(), "static_pic_dialog");
            localq.b();
            return;
        }
        Toast.makeText(this, 2131690040, 0).show();
        finish();
    }

    void d(Intent paramIntent) {
        paramIntent = (Uri) paramIntent.getParcelableExtra("android.intent.extra.STREAM");
        if (paramIntent != null) {
            d.d(o, String.format("Gif was received: %s", new Object[]{paramIntent}));
            q localq = f();
            a locala = (a) localq.a("gif_dialog");
            if (locala != null) {
                locala.b();
                localq.b();
            }
            a.a(paramIntent).a(f(), "gif_dialog");
            localq.b();
            return;
        }
        Toast.makeText(this, 2131690040, 0).show();
        finish();
    }

    protected void n() {
        startActivityForResult(new Intent(this, AuthActivity.class), 0);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (!l.a().h()) {
            finish();
            return;
        }
        o();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (!l.a().h()) {
            n();
            return;
        }
        o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/ExportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */