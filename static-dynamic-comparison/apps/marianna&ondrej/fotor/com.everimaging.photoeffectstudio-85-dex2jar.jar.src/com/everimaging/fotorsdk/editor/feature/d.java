package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.everimaging.fotorsdk.a;
import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.AdjustFilter.AdjustFilterType;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;

public class d
        extends b {
    public d(c paramc) {
        super(paramc);
    }

    protected void E() {
    }

    protected int a(AdjustFilter.AdjustFilterType paramAdjustFilterType) {
        float f = 0.0F;
        switch (1. a[paramAdjustFilterType.ordinal()])
        {
        }
        for (; ; ) {
            return (int) f;
            f = this.q.getDisplayBrightness();
            continue;
            f = this.q.getDisplayContrast();
            continue;
            f = this.q.getDisplaySaturation();
            continue;
            f = this.q.getDisplaySharpening();
        }
    }

    protected int[] a() {
        return new int[]{R.string.fotor_adjust_brightness, R.string.fotor_adjust_contrast, R.string.fotor_adjust_saturation, R.string.fotor_adjust_sharpen};
    }

    protected int b(AdjustFilter.AdjustFilterType paramAdjustFilterType) {
        float f = 0.0F;
        switch (1. a[paramAdjustFilterType.ordinal()])
        {
        }
        for (; ; ) {
            return (int) f;
            f = this.q.getDisplayBrightness() + 100.0F;
            continue;
            f = this.q.getDisplayContrast() + 100.0F;
            continue;
            f = this.q.getDisplaySaturation() + 100.0F;
            continue;
            f = this.q.getDisplaySharpening() + 100.0F;
        }
    }

    protected void b(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        if ((!paramBoolean) || (!G())) {
            return;
        }
        paramInt -= 100;
        if (this.p == AdjustFilter.AdjustFilterType.BRIGHTNESS) {
            this.q.setBrightness(paramInt);
        }
        for (; ; ) {
            this.o.setDisplayValue(String.valueOf(a(this.p)));
            d();
            return;
            if (this.p == AdjustFilter.AdjustFilterType.CONTRAST) {
                this.q.setContrast(paramInt);
            } else if (this.p == AdjustFilter.AdjustFilterType.SATURATION) {
                this.q.setSaturation(paramInt);
            } else if (this.p == AdjustFilter.AdjustFilterType.SHARPEN) {
                this.q.setSharpening(paramInt);
            }
        }
    }

    protected int[] b() {
        return new int[]{R.drawable.fotor_adjust_brightness, R.drawable.fotor_adjust_contrast, R.drawable.fotor_adjust_saturation, R.drawable.fotor_adjust_sharpen};
    }

    protected AdjustFilter.AdjustFilterType[] c() {
        return new AdjustFilter.AdjustFilterType[]{AdjustFilter.AdjustFilterType.BRIGHTNESS, AdjustFilter.AdjustFilterType.CONTRAST, AdjustFilter.AdjustFilterType.SATURATION, AdjustFilter.AdjustFilterType.SHARPEN};
    }

    public void onClick(View paramView) {
        AdjustFilter.AdjustFilterType localAdjustFilterType = (AdjustFilter.AdjustFilterType) paramView.getTag();
        if ((localAdjustFilterType == this.p) || (!G())) {
            return;
        }
        this.p = localAdjustFilterType;
        if (this.v != null) {
            this.v.setSelected(false);
        }
        this.v = paramView;
        this.v.setSelected(true);
        this.o.setProgress(b(this.p));
        if (this.n.getParent() == null) {
            this.a.a(this.n);
        }
        paramView = "Unknow";
        if (this.p != null) {
            paramView = this.p.name();
        }
        a.a("EDIT_BASICADJUST_ITEM_TAP", "Basic_Adjust_Type", paramView);
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.ADJUST;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_adjust);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */