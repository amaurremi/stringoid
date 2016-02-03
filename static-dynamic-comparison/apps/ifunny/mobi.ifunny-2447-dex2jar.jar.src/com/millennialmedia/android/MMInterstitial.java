package com.millennialmedia.android;

import android.content.Context;

public final class MMInterstitial
        implements MMAd {
    MMAdImpl a;

    public MMInterstitial(Context paramContext) {
        this.a = new MMInterstitial.MMInterstitialAdImpl(this, paramContext.getApplicationContext());
        this.a.f = "i";
    }

    private void b() {
        if (isAdAvailable()) {
            MMLog.b("MMInterstitial", "Ad already fetched and ready for display...");
            MMSDK.Event.a(this.a, new MMException(17));
            return;
        }
        MMLog.b("MMInterstitial", "Fetching new ad...");
        this.a.f();
    }

    int a() {
        try {
            MMAdImplController.b(this.a);
            if (this.a.k != null) {
                int i = this.a.k.g(this.a);
                return i;
            }
        } catch (Exception localException) {
            MMLog.a("MMInterstitial", "There was an exception displaying a cached ad. ", localException);
            localException.printStackTrace();
        }
        return 100;
    }

    public boolean display() {
        return display(false);
    }

    public boolean display(boolean paramBoolean) {
        if (!MMSDK.a()) {
            MMLog.e("MMInterstitial", MMException.a(3));
        }
        int i;
        do {
            do {
                return false;
                try {
                    i = a();
                    if ((i == 0) || (!paramBoolean)) {
                        break;
                    }
                    throw new MMException(i);
                } catch (Exception localException) {
                }
            } while (!paramBoolean);
            throw new MMException(localException);
        } while (i != 0);
        return true;
    }

    public void fetch() {
        if ((this.a != null) && (this.a.c != null)) {
            fetch(this.a.b, this.a.c);
            return;
        }
        b();
    }

    public void fetch(MMRequest paramMMRequest) {
        if ((this.a != null) && (this.a.c != null)) {
            fetch(paramMMRequest, this.a.c);
            return;
        }
        b();
    }

    public void fetch(MMRequest paramMMRequest, RequestListener paramRequestListener) {
        if (this.a != null) {
            this.a.b = paramMMRequest;
            this.a.c = paramRequestListener;
        }
        b();
    }

    public String getApid() {
        return this.a.getApid();
    }

    public boolean getIgnoresDensityScaling() {
        return this.a.getIgnoresDensityScaling();
    }

    public RequestListener getListener() {
        return this.a.getListener();
    }

    public MMRequest getMMRequest() {
        return this.a.getMMRequest();
    }

    public boolean isAdAvailable() {
        if (!MMSDK.a()) {
            MMLog.e("MMInterstitial", MMException.a(3));
        }
        for (; ; ) {
            return false;
            try {
                MMAdImplController.b(this.a);
                if (this.a.k != null) {
                    int i = this.a.k.f(this.a);
                    if (i == 0) {
                        return true;
                    }
                }
            } catch (Exception localException) {
                MMLog.a("MMInterstitial", "There was an exception checking for a cached ad. ", localException);
                localException.printStackTrace();
            }
        }
        return false;
    }

    public void setApid(String paramString) {
        this.a.setApid(paramString);
    }

    public void setIgnoresDensityScaling(boolean paramBoolean) {
        this.a.setIgnoresDensityScaling(paramBoolean);
    }

    public void setListener(RequestListener paramRequestListener) {
        this.a.setListener(paramRequestListener);
    }

    public void setMMRequest(MMRequest paramMMRequest) {
        this.a.setMMRequest(paramMMRequest);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */