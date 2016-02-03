package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CountdownDrawable;
import com.mopub.mobileads.resource.LearnMoreDrawable;

class VastVideoToolbar
        extends LinearLayout {
    private static final int THRESHOLD_FOR_HIDING_VIDEO_DURATION = 200;
    private static final int TOOLBAR_HEIGHT_DIPS = 44;
    private final ToolbarWidget mCloseButtonWidget;
    private final ToolbarWidget mCountdownWidget;
    private final ToolbarWidget mDurationWidget;
    private final ToolbarWidget mLearnMoreWidget;

    public VastVideoToolbar(Context paramContext) {
        super(paramContext);
        setId((int) Utils.generateUniqueId());
        setOnTouchListener(new VastVideoToolbar .1 (this));
        setLayoutParams(new LinearLayout.LayoutParams(-1, Dips.dipsToIntPixels(44.0F, getContext())));
        setBackgroundColor(-16777216);
        getBackground().setAlpha(180);
        this.mDurationWidget = createDurationWidget();
        this.mLearnMoreWidget = createLearnMoreWidget();
        this.mCountdownWidget = createCountdownWidget();
        this.mCloseButtonWidget = createCloseButtonWidget();
        addView(this.mDurationWidget);
        addView(this.mLearnMoreWidget);
        addView(this.mCountdownWidget);
        addView(this.mCloseButtonWidget);
    }

    private ToolbarWidget createCloseButtonWidget() {
        return new ToolbarWidget.Builder(getContext()).weight(1.0F).widgetGravity(21).defaultText("Close").drawable(new CloseButtonDrawable()).visibility(8).build();
    }

    private ToolbarWidget createCountdownWidget() {
        CountdownDrawable localCountdownDrawable = new CountdownDrawable(getContext());
        return new ToolbarWidget.Builder(getContext()).weight(1.0F).widgetGravity(21).defaultText("Skip in").drawable(localCountdownDrawable).visibility(4).build();
    }

    private ToolbarWidget createDurationWidget() {
        return new ToolbarWidget.Builder(getContext()).weight(2.0F).widgetGravity(19).hasText().textAlign(9).build();
    }

    private ToolbarWidget createLearnMoreWidget() {
        return new ToolbarWidget.Builder(getContext()).weight(1.0F).widgetGravity(21).defaultText("Learn More").drawable(new LearnMoreDrawable()).visibility(4).build();
    }

    @Deprecated
    ToolbarWidget getCloseButtonWidget() {
        return this.mCloseButtonWidget;
    }

    @Deprecated
    ToolbarWidget getCountdownWidget() {
        return this.mCountdownWidget;
    }

    String getDisplaySeconds(long paramLong) {
        return String.valueOf(Math.round(Math.ceil((float) paramLong / 1000.0F)));
    }

    @Deprecated
    ToolbarWidget getDurationWidget() {
        return this.mDurationWidget;
    }

    @Deprecated
    ToolbarWidget getLearnMoreWidget() {
        return this.mLearnMoreWidget;
    }

    void makeInteractable() {
        this.mCountdownWidget.setVisibility(8);
        this.mLearnMoreWidget.setVisibility(0);
        this.mCloseButtonWidget.setVisibility(0);
    }

    void setCloseButtonOnTouchListener(View.OnTouchListener paramOnTouchListener) {
        this.mCloseButtonWidget.setOnTouchListener(paramOnTouchListener);
    }

    void setLearnMoreButtonOnTouchListener(View.OnTouchListener paramOnTouchListener) {
        this.mLearnMoreWidget.setOnTouchListener(paramOnTouchListener);
    }

    void updateCountdownWidget(int paramInt) {
        if ((paramInt >= 0) && (this.mCountdownWidget.getVisibility() == 4)) {
            this.mCloseButtonWidget.setVisibility(8);
            this.mCountdownWidget.setVisibility(0);
        }
        this.mCountdownWidget.updateImageText(getDisplaySeconds(paramInt));
    }

    void updateDurationWidget(int paramInt) {
        if (paramInt >= 200) {
            this.mDurationWidget.updateText("Ends in " + getDisplaySeconds(paramInt) + " seconds");
        }
        while (paramInt < 0) {
            return;
        }
        this.mDurationWidget.updateText("Thanks for watching");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */