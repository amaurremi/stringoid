package com.everimaging.fotorsdk.store;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public abstract class FotorStoreBaseFragment
        extends Fragment {
    protected Context a;

    protected abstract String a();

    public void a(FragmentManager paramFragmentManager) {
        a(paramFragmentManager, true);
    }

    public void a(FragmentManager paramFragmentManager, boolean paramBoolean) {
        paramFragmentManager = paramFragmentManager.beginTransaction();
        paramFragmentManager.add(16908290, this, a());
        if (paramBoolean) {
            paramFragmentManager.commitAllowingStateLoss();
            return;
        }
        paramFragmentManager.commit();
    }

    public boolean b() {
        return false;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = getActivity();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/FotorStoreBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */