package mobi.ifunny.profile.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.q;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import java.util.ArrayList;

import mobi.ifunny.profile.a;
import mobi.ifunny.profile.i;
import mobi.ifunny.rest.content.User;

public class b
        extends mobi.ifunny.fragment.d {
    private User a;
    private final boolean b;
    private FrameLayout.LayoutParams c;

    public b(q paramq, User paramUser, FrameLayout.LayoutParams paramLayoutParams, boolean paramBoolean) {
        super(paramq);
        this.a = paramUser;
        this.b = paramBoolean;
        this.c = paramLayoutParams;
    }

    public static int a(boolean paramBoolean) {
        if (paramBoolean) {
            return 5;
        }
        return 2;
    }

    public Fragment a(int paramInt) {
        if (paramInt >= a().size()) {
            return null;
        }
        return (Fragment) a().get(paramInt);
    }

    public void a(int paramInt, FrameLayout.LayoutParams paramLayoutParams) {
        if (paramLayoutParams == null) {
        }
        Fragment localFragment;
        do {
            return;
            localFragment = a(paramInt);
        } while ((localFragment == null) || (!(localFragment instanceof a)));
        ((a) localFragment).a(paramLayoutParams);
    }

    public void a(int paramInt, User paramUser, boolean paramBoolean) {
        Fragment localFragment = a(paramInt);
        if ((localFragment != null) && ((localFragment instanceof i))) {
            ((i) localFragment).a(paramUser, paramBoolean);
        }
    }

    public int getCount() {
        return a(this.b);
    }

    public Fragment getItem(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 0:
                return new c();
            case 1:
                return new ProfileInfoFragment();
            case 2:
                return new mobi.ifunny.mynews.d();
            case 3:
                return new mobi.ifunny.h.b();
        }
        return new mobi.ifunny.g.b();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        paramViewGroup = (Fragment) super.instantiateItem(paramViewGroup, paramInt);
        if ((paramViewGroup instanceof i)) {
            ((i) paramViewGroup).a(this.a);
        }
        if ((paramViewGroup != null) && ((paramViewGroup instanceof a))) {
            ((a) paramViewGroup).a(this.c);
        }
        return paramViewGroup;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/fragments/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */