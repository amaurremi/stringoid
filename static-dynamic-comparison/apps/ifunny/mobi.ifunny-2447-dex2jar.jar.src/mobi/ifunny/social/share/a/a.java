package mobi.ifunny.social.share.a;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.g;
import com.facebook.Session;
import com.facebook.widget.WebDialog.FeedDialogBuilder;

public class a
        extends g {
    private Bundle j;

    private void a(Throwable paramThrowable) {
        c localc = d();
        if (localc != null) {
            localc.a(paramThrowable);
        }
    }

    public static a b(Bundle paramBundle) {
        a locala = new a();
        Bundle localBundle = new Bundle();
        localBundle.putBundle("ARG_PARAMS", paramBundle);
        locala.setArguments(localBundle);
        return locala;
    }

    private c d() {
        Object localObject = getActivity();
        if ((localObject != null) && ((localObject instanceof c))) {
            return (c) localObject;
        }
        localObject = getTargetFragment();
        if ((localObject != null) && ((localObject instanceof c))) {
            return (c) localObject;
        }
        return null;
    }

    private void e() {
        c localc = d();
        if (localc != null) {
            localc.c();
        }
    }

    private void f() {
        c localc = d();
        if (localc != null) {
            localc.d();
        }
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new WebDialog.FeedDialogBuilder(getActivity(), Session.getActiveSession(), this.j);
        paramBundle.setTheme(2131755185);
        paramBundle.setOnCompleteListener(new b(this));
        return paramBundle.build();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.j = getArguments().getBundle("ARG_PARAMS");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */