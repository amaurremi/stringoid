package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;

class SpinningProgressView
        extends ViewGroup {
    private final ProgressBar mProgressBar;
    private int mProgressIndicatorRadius;

    SpinningProgressView(Context paramContext) {
        super(paramContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams.gravity = 17;
        setLayoutParams(localLayoutParams);
        setVisibility(8);
        setBackgroundColor(-16777216);
        getBackground().setAlpha(180);
        this.mProgressBar = new ProgressBar(paramContext);
        this.mProgressIndicatorRadius = Dips.asIntPixels(25.0F, getContext());
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    boolean addToRoot(View paramView) {
        if (paramView == null) {
            return false;
        }
        paramView = paramView.getRootView();
        if ((paramView != null) && ((paramView instanceof ViewGroup))) {
            ViewGroup localViewGroup = (ViewGroup) paramView;
            setVisibility(0);
            setMeasuredDimension(paramView.getWidth(), paramView.getHeight());
            localViewGroup.addView(this);
            forceLayout();
            return true;
        }
        return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramBoolean) {
            paramInt1 = (paramInt1 + paramInt3) / 2;
            paramInt2 = (paramInt2 + paramInt4) / 2;
            this.mProgressBar.layout(paramInt1 - this.mProgressIndicatorRadius, paramInt2 - this.mProgressIndicatorRadius, paramInt1 + this.mProgressIndicatorRadius, paramInt2 + this.mProgressIndicatorRadius);
        }
    }

    boolean removeFromRoot() {
        Views.removeFromParent(this);
        setVisibility(8);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/SpinningProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */