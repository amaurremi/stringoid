package mobi.ifunny.social.auth;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.q;
import android.text.TextUtils;

public abstract class f
        extends mobi.ifunny.l.e {
    protected final int a = 0;
    protected int b;
    private final String c = "SAVE_STATE";

    protected String a(Throwable paramThrowable, int paramInt) {
        Resources localResources = mobi.ifunny.e.a.getResources();
        if ((paramThrowable != null) && (!TextUtils.isEmpty(paramThrowable.getMessage()))) {
            return localResources.getString(paramInt) + ": " + paramThrowable.getMessage() + localResources.getString(2131689929);
        }
        if (paramInt != 0) {
            return localResources.getString(paramInt) + ". " + localResources.getString(2131689929);
        }
        return g();
    }

    protected void a(int paramInt) {
        a(null, paramInt, null);
    }

    protected void a(String paramString) {
        a(null, paramString, null);
    }

    protected void a(String paramString, int paramInt, n paramn) {
        String str = null;
        if (paramInt == 0) {
        }
        for (; ; ) {
            a(paramString, str, paramn);
            return;
            str = a(null, paramInt);
        }
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        e();
        this.b = 0;
    }

    protected void b() {
        e();
        this.b = 0;
    }

    protected void c() {
        a(null, null, null);
    }

    protected void d() {
        if ((android.support.v4.app.g) getChildFragmentManager().a("dialog.loading") == null) {
            new g().a(getChildFragmentManager(), "dialog.loading");
        }
    }

    protected void e() {
        android.support.v4.app.g localg = (android.support.v4.app.g) getChildFragmentManager().a("dialog.loading");
        if (localg != null) {
            localg.b();
        }
    }

    protected abstract int f();

    protected String g() {
        Resources localResources = mobi.ifunny.e.a.getResources();
        return localResources.getString(2131689928, new Object[]{localResources.getString(f())});
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.b = 0;
        if (paramBundle != null) {
            this.b = paramBundle.getInt("SAVE_STATE");
            return;
        }
        this.b = 0;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("SAVE_STATE", this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */