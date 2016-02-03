package com.mopub.mobileads.util;

import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class Interstitials {
    public static boolean addCloseEventRegion(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, View.OnClickListener paramOnClickListener) {
        if ((paramViewGroup == null) || (paramViewGroup.getContext() == null)) {
            return false;
        }
        Button localButton = new Button(paramViewGroup.getContext());
        localButton.setVisibility(0);
        localButton.setBackgroundColor(0);
        localButton.setOnClickListener(paramOnClickListener);
        paramViewGroup.addView(localButton, paramLayoutParams);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/Interstitials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */