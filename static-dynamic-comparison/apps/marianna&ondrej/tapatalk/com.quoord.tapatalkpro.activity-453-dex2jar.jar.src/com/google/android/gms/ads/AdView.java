package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.at;

public final class AdView
        extends ViewGroup {
    private final at ku;

    public AdView(Context paramContext) {
        super(paramContext);
        this.ku = new at(this);
    }

    public AdView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.ku = new at(this, paramAttributeSet, false);
    }

    public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.ku = new at(this, paramAttributeSet, false);
    }

    public void destroy() {
        this.ku.destroy();
    }

    public AdListener getAdListener() {
        return this.ku.getAdListener();
    }

    public AdSize getAdSize() {
        return this.ku.getAdSize();
    }

    public String getAdUnitId() {
        return this.ku.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.ku.getInAppPurchaseListener();
    }

    public void loadAd(AdRequest paramAdRequest) {
        this.ku.a(paramAdRequest.O());
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        View localView = getChildAt(0);
        if ((localView != null) && (localView.getVisibility() != 8)) {
            int i = localView.getMeasuredWidth();
            int j = localView.getMeasuredHeight();
            paramInt1 = (paramInt3 - paramInt1 - i) / 2;
            paramInt2 = (paramInt4 - paramInt2 - j) / 2;
            localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i = 0;
        Object localObject = getChildAt(0);
        AdSize localAdSize = getAdSize();
        int j;
        if ((localObject != null) && (((View) localObject).getVisibility() != 8)) {
            measureChild((View) localObject, paramInt1, paramInt2);
            j = ((View) localObject).getMeasuredWidth();
            i = ((View) localObject).getMeasuredHeight();
        }
        for (; ; ) {
            j = Math.max(j, getSuggestedMinimumWidth());
            i = Math.max(i, getSuggestedMinimumHeight());
            setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
            return;
            if (localAdSize != null) {
                localObject = getContext();
                j = localAdSize.getWidthInPixels((Context) localObject);
                i = localAdSize.getHeightInPixels((Context) localObject);
            } else {
                j = 0;
            }
        }
    }

    public void pause() {
        this.ku.pause();
    }

    public void resume() {
        this.ku.resume();
    }

    public void setAdListener(AdListener paramAdListener) {
        this.ku.setAdListener(paramAdListener);
    }

    public void setAdSize(AdSize paramAdSize) {
        this.ku.setAdSizes(new AdSize[]{paramAdSize});
    }

    public void setAdUnitId(String paramString) {
        this.ku.setAdUnitId(paramString);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener) {
        this.ku.setInAppPurchaseListener(paramInAppPurchaseListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/ads/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */