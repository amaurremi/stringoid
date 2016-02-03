package com.millennialmedia.android;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.lang.ref.WeakReference;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

class AdViewOverlayView$FetchWebViewContentTask
        extends AsyncTask<Void, Void, String> {
    private String a;
    private boolean b;
    private WeakReference<AdViewOverlayView> c;

    public AdViewOverlayView$FetchWebViewContentTask(AdViewOverlayView paramAdViewOverlayView, String paramString) {
        this.a = paramString;
        this.c = new WeakReference(paramAdViewOverlayView);
    }

    protected String a(Void... paramVarArgs) {
        this.b = true;
        if (!TextUtils.isEmpty(this.a)) {
            try {
                paramVarArgs = new HttpGetRequest().a(this.a);
                if (paramVarArgs != null) {
                    StatusLine localStatusLine = paramVarArgs.getStatusLine();
                    if ((paramVarArgs != null) && (localStatusLine != null) && (localStatusLine.getStatusCode() != 404)) {
                        paramVarArgs = paramVarArgs.getEntity();
                        if (paramVarArgs != null) {
                            paramVarArgs = HttpGetRequest.a(paramVarArgs.getContent());
                            this.b = false;
                            return paramVarArgs;
                        }
                    }
                }
            } catch (Exception paramVarArgs) {
                MMLog.a("AdViewOverlayView", "Unable to get weboverlay", paramVarArgs);
            }
        }
        return null;
    }

    protected void a(String paramString) {
        AdViewOverlayView localAdViewOverlayView = (AdViewOverlayView) this.c.get();
        if (localAdViewOverlayView != null) {
            if (this.b) {
                AdViewOverlayActivity localAdViewOverlayActivity = (AdViewOverlayActivity) localAdViewOverlayView.b.get();
                if (localAdViewOverlayActivity == null) {
                    break label78;
                }
                localAdViewOverlayActivity.finish();
            }
        }
        for (; ; ) {
            if ((paramString != null) && (localAdViewOverlayView.h != null) && (localAdViewOverlayView.h.k != null)) {
                localAdViewOverlayView.h.k.a(paramString, this.a);
            }
            return;
            label78:
            AdViewOverlayView.a(localAdViewOverlayView);
        }
    }

    protected void onPreExecute() {
        AdViewOverlayView localAdViewOverlayView = (AdViewOverlayView) this.c.get();
        if ((localAdViewOverlayView != null) && (AdViewOverlayView.c(localAdViewOverlayView) == null)) {
            AdViewOverlayView.d(localAdViewOverlayView);
        }
        super.onPreExecute();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$FetchWebViewContentTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */