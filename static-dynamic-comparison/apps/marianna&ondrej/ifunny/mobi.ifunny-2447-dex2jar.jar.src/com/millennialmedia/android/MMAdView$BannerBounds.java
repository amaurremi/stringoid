package com.millennialmedia.android;

import android.view.ViewGroup.LayoutParams;

class MMAdView$BannerBounds {
    int a;
    int b;
    DTOResizeParameters c;

    MMAdView$BannerBounds(MMAdView paramMMAdView, DTOResizeParameters paramDTOResizeParameters) {
        this.c = paramDTOResizeParameters;
        this.a = paramDTOResizeParameters.d;
        this.b = paramDTOResizeParameters.e;
    }

    private MMAdView.BannerBounds.BoundsResult a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i;
        int j;
        if (paramInt1 + paramInt3 + paramInt2 > paramInt4) {
            paramInt2 += paramInt4 - paramInt3;
            if (paramInt2 < 0) {
                i = 0;
                j = paramInt4;
            }
        }
        for (; ; ) {
            MMAdView.BannerBounds.BoundsResult localBoundsResult = new MMAdView.BannerBounds.BoundsResult(this, null);
            localBoundsResult.a = (i - paramInt1);
            localBoundsResult.b = j;
            return localBoundsResult;
            i = paramInt2;
            j = paramInt3;
            if (paramInt2 + paramInt3 > paramInt4) {
                i = paramInt4 - paramInt3;
                j = paramInt3;
                continue;
                i = paramInt2;
                j = paramInt3;
                if (paramInt2 <= 0) {
                    i = paramInt1;
                    j = paramInt3;
                }
            }
        }
    }

    private void b() {
        Object localObject = new int[2];
        this.d.getLocationInWindow((int[]) localObject);
        localObject = a(localObject[0], this.c.d, this.c.a, this.c.g);
        this.c.a = ((MMAdView.BannerBounds.BoundsResult) localObject).b;
        this.a = ((MMAdView.BannerBounds.BoundsResult) localObject).a;
    }

    private void c() {
        Object localObject = new int[2];
        this.d.getLocationInWindow((int[]) localObject);
        localObject = a(localObject[1], this.c.e, this.c.b, this.c.h);
        this.c.b = ((MMAdView.BannerBounds.BoundsResult) localObject).b;
        this.b = ((MMAdView.BannerBounds.BoundsResult) localObject).a;
    }

    ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
        paramLayoutParams.width = this.c.a;
        paramLayoutParams.height = this.c.b;
        return paramLayoutParams;
    }

    void a() {
        b();
        c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdView$BannerBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */