package mobi.ifunny.social.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.webkit.CookieSyncManager;
import mobi.ifunny.i.b;

public class a
        implements DialogInterface.OnCancelListener {
    public static String a = "ifunny://twitter";
    private e b;
    private int c;

    public a(int paramInt, e parame) {
        this.c = paramInt;
        this.b = parame;
    }

    public void a(k paramk, q paramq, String paramString) {
        CookieSyncManager.createInstance(paramk);
        if (paramk.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            b.a(paramk, "Error", "Application requires permission to access the Internet");
            this.b.a();
            return;
        }
        paramk = c(paramq);
        if (paramk != null) {
            paramk.a(null);
            paramk.a();
            paramq.b();
        }
        paramk = c.a(paramString, this.c);
        paramk.a(this.b);
        paramk.a(paramq, "DIALOG_TAG");
        paramq.b();
    }

    public void a(q paramq) {
        paramq = c(paramq);
        if (paramq != null) {
            paramq.a(this.b);
        }
    }

    public void b(q paramq) {
        paramq = c(paramq);
        if (paramq != null) {
            paramq.a(null);
        }
    }

    public c c(q paramq) {
        return (c) paramq.a("DIALOG_TAG");
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        this.b.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */