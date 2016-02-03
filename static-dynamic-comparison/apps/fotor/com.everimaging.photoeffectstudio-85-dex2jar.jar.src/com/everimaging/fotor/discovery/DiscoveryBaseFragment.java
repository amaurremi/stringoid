package com.everimaging.fotor.discovery;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class DiscoveryBaseFragment
        extends Fragment {
    protected Context a;

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = getActivity().getApplicationContext();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/DiscoveryBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */