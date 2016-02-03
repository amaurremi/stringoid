package mobi.ifunny.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v7.a.a;
import mobi.ifunny.a.c;
import mobi.ifunny.f;
import mobi.ifunny.fragment.FragmentPage;
import mobi.ifunny.main.a.b;

public abstract class i
        extends FragmentPage {
    private c a;
    private j b;

    public void B() {
        if (this.a != null) {
            this.a.a_(i());
            this.a.b(y());
        }
    }

    public f C() {
        return (f) getActivity();
    }

    public IFunnyMenuActivity D() {
        k localk = getActivity();
        if ((localk instanceof IFunnyMenuActivity)) {
            return (IFunnyMenuActivity) localk;
        }
        return null;
    }

    public Object E() {
        return getActivity().c();
    }

    public void a(b paramb) {
        a(paramb, false);
    }

    public void a(b paramb, boolean paramBoolean) {
        if (this.b != null) {
            this.b.a(paramb, null, paramBoolean);
        }
    }

    protected boolean i() {
        return false;
    }

    public Object n() {
        return null;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = a();
        paramBundle.f();
        paramBundle.b(true);
        paramBundle.c(false);
        B();
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            this.a = ((c) paramActivity);
            try {
                this.b = ((j) paramActivity);
                return;
            } catch (ClassCastException paramActivity) {
            }
        } catch (ClassCastException localClassCastException) {
            for (; ; ) {
            }
        }
    }

    public boolean q() {
        return false;
    }

    protected boolean y() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */