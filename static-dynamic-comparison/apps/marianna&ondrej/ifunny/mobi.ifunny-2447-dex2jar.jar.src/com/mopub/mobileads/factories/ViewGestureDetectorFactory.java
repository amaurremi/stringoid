package com.mopub.mobileads.factories;

import android.content.Context;
import android.view.View;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.ViewGestureDetector;

public class ViewGestureDetectorFactory {
    protected static ViewGestureDetectorFactory a = new ViewGestureDetectorFactory();

    public static ViewGestureDetector create(Context paramContext, View paramView, AdConfiguration paramAdConfiguration) {
        return a.a(paramContext, paramView, paramAdConfiguration);
    }

    @Deprecated
    public static void setInstance(ViewGestureDetectorFactory paramViewGestureDetectorFactory) {
        a = paramViewGestureDetectorFactory;
    }

    protected ViewGestureDetector a(Context paramContext, View paramView, AdConfiguration paramAdConfiguration) {
        return new ViewGestureDetector(paramContext, paramView, paramAdConfiguration);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/ViewGestureDetectorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */