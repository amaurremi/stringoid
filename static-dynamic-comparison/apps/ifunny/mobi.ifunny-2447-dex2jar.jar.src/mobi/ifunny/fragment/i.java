package mobi.ifunny.fragment;

import android.support.v4.app.q;
import com.google.android.gms.common.GooglePlayServicesUtil;
import mobi.ifunny.social.a.h;
import mobi.ifunny.social.auth.b.c;
import mobi.ifunny.util.n;

public class i
        extends j {
    private void c(int paramInt) {
        q localq = getChildFragmentManager();
        h localh = (h) localq.a("GPLUS_ERROR_DIALOG_TAG");
        if (localh != null) {
            localh.b();
            localq.b();
        }
        h.a(paramInt).a(localq, "GPLUS_ERROR_DIALOG_TAG");
        localq.b();
    }

    protected void a(int paramInt) {
        switch (paramInt) {
            default:
                super.a(paramInt);
                return;
        }
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (i != 0) {
            c(i);
            return;
        }
        c localc = (c) n.a(getActivity(), getFragmentManager(), "TAG_GPLUS_AVATAR", c.class);
        localc.setTargetFragment(this, paramInt);
        localc.o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */