package com.google.android.gms.ads.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.e;
import com.google.android.gms.internal.bo;

public final class b
        extends ViewGroup {
    private final bo a;

    public com.google.android.gms.ads.a getAdListener() {
        return this.a.b();
    }

    public e getAdSize() {
        return this.a.c();
    }

    public e[] getAdSizes() {
        return this.a.d();
    }

    public String getAdUnitId() {
        return this.a.e();
    }

    public a getAppEventListener() {
        return this.a.f();
    }

    public String getMediationAdapterClassName() {
        return this.a.j();
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
        e locale = getAdSize();
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
            if (locale != null) {
                localObject = getContext();
                j = locale.b((Context) localObject);
                i = locale.a((Context) localObject);
            } else {
                j = 0;
            }
        }
    }

    public void setAdListener(com.google.android.gms.ads.a parama) {
        this.a.a(parama);
    }

    public void setAdSizes(e... paramVarArgs) {
        if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.a.b(paramVarArgs);
    }

    public void setAdUnitId(String paramString) {
        this.a.a(paramString);
    }

    public void setAppEventListener(a parama) {
        this.a.a(parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/ads/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */