package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class CustomTabHost
        extends TabHost {
    private int device_x = getResources().getDisplayMetrics().widthPixels;
    private Animation slideLeftIn;
    private Animation slideLeftOut;
    private Animation slideRightIn;
    private Animation slideRightOut;
    private int tabCount = 3;

    public CustomTabHost(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initAnima();
    }

    private void initAnima() {
        this.slideLeftIn = new TranslateAnimation(this.device_x, 0.0F, 1.0F, 1.0F);
        this.slideLeftIn.setDuration(500L);
        this.slideRightIn = new TranslateAnimation(-this.device_x, 0.0F, 1.0F, 1.0F);
        this.slideRightIn.setDuration(500L);
        this.slideLeftOut = new TranslateAnimation(0.0F, -this.device_x, 1.0F, 1.0F);
        this.slideLeftOut.setDuration(500L);
        this.slideRightOut = new TranslateAnimation(0.0F, this.device_x, 1.0F, 1.0F);
        this.slideRightOut.setDuration(500L);
    }

    public void addTab(TabHost.TabSpec paramTabSpec) {
        this.tabCount += 1;
        super.addTab(paramTabSpec);
    }

    public int getTabCount() {
        return this.tabCount;
    }

    public void setCurrentTab(int paramInt) {
        int i = getCurrentTab();
        if (getCurrentView() != null) {
            if ((i == this.tabCount - 1) && (paramInt == 0)) {
                getCurrentView().startAnimation(this.slideLeftOut);
            }
        } else {
            super.setCurrentTab(paramInt);
            if ((i != this.tabCount - 1) || (paramInt != 0)) {
                break label134;
            }
            getCurrentView().startAnimation(this.slideLeftIn);
        }
        label134:
        do {
            return;
            if ((i == 0) && (paramInt == this.tabCount - 1)) {
                getCurrentView().startAnimation(this.slideRightOut);
                break;
            }
            if (paramInt > i) {
                getCurrentView().startAnimation(this.slideLeftOut);
                break;
            }
            if (paramInt >= i) {
                break;
            }
            getCurrentView().startAnimation(this.slideRightOut);
            break;
            if ((i == 0) && (paramInt == this.tabCount - 1)) {
                getCurrentView().startAnimation(this.slideRightIn);
                return;
            }
            if (paramInt > i) {
                getCurrentView().startAnimation(this.slideLeftIn);
                return;
            }
        } while (paramInt >= i);
        getCurrentView().startAnimation(this.slideRightIn);
    }

    public void setDevice_X(int paramInt) {
        this.device_x = paramInt;
        initAnima();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/CustomTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */