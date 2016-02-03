package com.millennialmedia.android;

import android.app.Activity;
import android.net.Uri;

import java.lang.ref.WeakReference;

class MMAdImpl$MMAdImplRedirectionListenerImpl
        extends HttpRedirection.RedirectionListenerImpl {
    WeakReference<MMAdImpl> f;

    public MMAdImpl$MMAdImplRedirectionListenerImpl(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl != null) {
            this.f = new WeakReference(paramMMAdImpl);
            this.e = paramMMAdImpl.h;
        }
    }

    public boolean isActivityStartable(Uri paramUri) {
        paramUri = (MMAdImpl) this.f.get();
        if (paramUri != null) {
            paramUri = paramUri.j();
            if ((paramUri != null) && ((paramUri instanceof Activity)) && (((Activity) paramUri).isFinishing())) {
                return false;
            }
        }
        return true;
    }

    public void startingActivity(Uri paramUri) {
        super.startingActivity(paramUri);
        if ((paramUri.getScheme().equalsIgnoreCase("http")) || (paramUri.getScheme().equalsIgnoreCase("https"))) {
            paramUri = (MMAdImpl) this.f.get();
            if (paramUri != null) {
                MMSDK.Event.d(paramUri);
            }
        }
    }

    public void updateLastVideoViewedTime() {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.f.get();
        if ((localMMAdImpl != null) && (localMMAdImpl.f != null)) {
            HandShake.a(localMMAdImpl.j()).b(localMMAdImpl.j(), localMMAdImpl.f);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdImpl$MMAdImplRedirectionListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */