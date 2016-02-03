package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;

import java.lang.ref.WeakReference;

final class HttpRedirection$1
        implements Runnable {
    HttpRedirection$1(WeakReference paramWeakReference) {
    }

    private void a(HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl) {
        Object localObject2 = null;
        Context localContext = (Context) paramRedirectionListenerImpl.b.get();
        Object localObject1;
        if (localContext != null) {
            String str = paramRedirectionListenerImpl.c.getScheme();
            localObject1 = localObject2;
            if (str != null) {
                if (str.equalsIgnoreCase("mmvideo")) {
                    break label139;
                }
                localObject1 = Utils.IntentUtils.a(paramRedirectionListenerImpl);
            }
        }
        for (; ; ) {
            if (localObject1 != null) {
                localObject2 = paramRedirectionListenerImpl.getOverlaySettings();
                if ((localObject1 != null) && (localObject2 != null)) {
                    if (paramRedirectionListenerImpl.d != null) {
                        ((OverlaySettings) localObject2).c = paramRedirectionListenerImpl.d;
                    }
                    ((Intent) localObject1).putExtra("settings", (Parcelable) localObject2);
                }
                localObject2 = ((Intent) localObject1).getStringExtra("class");
                if ((localObject2 != null) && (((String) localObject2).equals(AdViewOverlayActivity.class.getCanonicalName()))) {
                }
            }
            try {
                if (paramRedirectionListenerImpl.isActivityStartable(paramRedirectionListenerImpl.c)) {
                    Utils.IntentUtils.c(localContext, (Intent) localObject1);
                    paramRedirectionListenerImpl.startingActivity(paramRedirectionListenerImpl.c);
                }
                return;
            } catch (ActivityNotFoundException localActivityNotFoundException) {
                label139:
                MMLog.a("HttpRedirection", String.format("No activity found for %s", new Object[]{paramRedirectionListenerImpl.c}), localActivityNotFoundException);
            }
            localObject1 = localObject2;
            if (!paramRedirectionListenerImpl.isHandlingMMVideo(paramRedirectionListenerImpl.c)) {
                VideoAd.a(localContext, paramRedirectionListenerImpl.c.getHost(), paramRedirectionListenerImpl);
                localObject1 = localObject2;
            }
        }
    }

    public void run() {
        HttpRedirection.RedirectionListenerImpl localRedirectionListenerImpl = (HttpRedirection.RedirectionListenerImpl) this.a.get();
        String str;
        if (localRedirectionListenerImpl != null) {
            str = HttpRedirection.a(localRedirectionListenerImpl.a);
            if (str != null) {
                localRedirectionListenerImpl.c = Uri.parse(str);
                if (localRedirectionListenerImpl.c == null) {
                    break label48;
                }
                a(localRedirectionListenerImpl);
            }
        }
        return;
        label48:
        MMLog.e("HttpRedirection", String.format("Could not start activity for %s", new Object[]{str}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpRedirection$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */