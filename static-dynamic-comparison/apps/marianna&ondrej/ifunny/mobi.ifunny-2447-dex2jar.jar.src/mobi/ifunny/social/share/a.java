package mobi.ifunny.social.share;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.text.TextUtils;
import mobi.ifunny.e;

public abstract class a
        extends Fragment {
    protected SharingContent a;

    private b a() {
        k localk = getActivity();
        if ((localk != null) && ((localk instanceof b))) {
            return (b) localk;
        }
        return null;
    }

    protected void R_() {
        this.a = null;
        b localb = a();
        if (localb != null) {
            localb.n();
        }
    }

    protected void S_() {
        this.a = null;
        b localb = a();
        if (localb != null) {
            localb.o();
        }
    }

    protected void a(String paramString) {
        this.a = null;
        b localb = a();
        if (localb != null) {
            localb.b(paramString);
        }
    }

    public void a(SharingContent paramSharingContent) {
        this.a = paramSharingContent;
        b();
    }

    protected void a_(Throwable paramThrowable) {
        a(b(paramThrowable));
    }

    protected String b(Throwable paramThrowable) {
        Resources localResources = e.a.getResources();
        if ((paramThrowable != null) && (!TextUtils.isEmpty(paramThrowable.getMessage()))) {
            return paramThrowable.getMessage() + " " + localResources.getString(2131689929);
        }
        return e() + " " + localResources.getString(2131689930);
    }

    protected abstract void b();

    protected abstract String e();

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.a = ((SharingContent) paramBundle.getParcelable("STATE_SHARING_CONTENT"));
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_SHARING_CONTENT", this.a);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */