package mobi.ifunny.social.share.a;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.text.TextUtils;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.ShareDialogBuilder;
import com.facebook.widget.FacebookDialog.ShareDialogFeature;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.z;
import mobi.ifunny.social.share.SharingContent;

public class d
        extends mobi.ifunny.social.share.a
        implements z, c {
    private UiLifecycleHelper b;

    private void f() {
        q localq = getActivity().f();
        Object localObject2 = (mobi.ifunny.social.auth.a.d) localq.a("TAG_FACEBOOK_SHARE_LOGIN");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new mobi.ifunny.social.auth.a.d();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "TAG_FACEBOOK_SHARE_LOGIN");
            ((ab) localObject2).c();
            localq.b();
        }
        ((mobi.ifunny.social.auth.a.d) localObject1).setTargetFragment(this, 1);
        ((mobi.ifunny.social.auth.a.d) localObject1).b(true);
    }

    private void g() {
        Object localObject = new Bundle();
        ((Bundle) localObject).putString("link", this.a.a);
        if (!TextUtils.isEmpty(this.a.d)) {
            ((Bundle) localObject).putString("picture", this.a.d);
        }
        if (!TextUtils.isEmpty(this.a.b)) {
            ((Bundle) localObject).putString("name", this.a.b);
        }
        q localq = getActivity().f();
        a locala = (a) localq.a("TAG_FACEBOOK_SHARE_FEED");
        if (locala != null) {
            locala.b();
            localq.b();
        }
        localObject = a.b((Bundle) localObject);
        ((a) localObject).setTargetFragment(this, 1);
        ((a) localObject).a(localq, "TAG_FACEBOOK_SHARE_FEED");
    }

    public void a() {
        S_();
    }

    public void a(String paramString1, String paramString2) {
        a(paramString2);
    }

    public void a(Throwable paramThrowable) {
        a_(paramThrowable);
    }

    public void a(n paramn) {
        g();
    }

    protected void b() {
        if (FacebookDialog.canPresentShareDialog(getActivity().getApplicationContext(), new FacebookDialog.ShareDialogFeature[]{FacebookDialog.ShareDialogFeature.SHARE_DIALOG})) {
            Object localObject = (FacebookDialog.ShareDialogBuilder) ((FacebookDialog.ShareDialogBuilder) new FacebookDialog.ShareDialogBuilder(getActivity()).setLink(this.a.a)).setFragment(this);
            if (!TextUtils.isEmpty(this.a.d)) {
                ((FacebookDialog.ShareDialogBuilder) localObject).setPicture(this.a.d);
            }
            if (!TextUtils.isEmpty(this.a.b)) {
                ((FacebookDialog.ShareDialogBuilder) localObject).setName(this.a.b);
            }
            if (!TextUtils.isEmpty(this.a.g)) {
                ((FacebookDialog.ShareDialogBuilder) localObject).setApplicationName(this.a.g);
            }
            localObject = ((FacebookDialog.ShareDialogBuilder) localObject).build();
            this.b.trackPendingDialogCall(((FacebookDialog) localObject).present());
            return;
        }
        f();
    }

    public void c() {
        R_();
    }

    public void d() {
        S_();
    }

    protected String e() {
        return mobi.ifunny.e.a.getResources().getString(2131689931);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.b.onActivityResult(paramInt1, paramInt2, paramIntent, new e(this));
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.b = new UiLifecycleHelper(getActivity(), null);
        this.b.onCreate(paramBundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.b.onPause();
    }

    public void onResume() {
        super.onResume();
        this.b.onResume();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        this.b.onSaveInstanceState(paramBundle);
    }

    public void onStop() {
        super.onStop();
        this.b.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */