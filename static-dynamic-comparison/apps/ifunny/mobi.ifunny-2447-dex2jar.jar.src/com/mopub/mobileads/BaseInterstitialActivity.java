package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.util.Interstitials;

abstract class BaseInterstitialActivity
        extends Activity {
    private static final float CLOSE_BUTTON_PADDING = 8.0F;
    private static final float CLOSE_BUTTON_SIZE_DP = 50.0F;
    private long mBroadcastIdentifier;
    private int mButtonPadding;
    private int mButtonSize;
    private ImageView mCloseButton;
    private View.OnClickListener mCloseOnClickListener;
    private RelativeLayout mLayout;

    private void createInterstitialCloseButton() {
        this.mCloseButton = new ImageButton(this);
        Object localObject = new StateListDrawable();
        Drawable localDrawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this);
        ((StateListDrawable) localObject).addState(new int[]{-16842919}, localDrawable);
        localDrawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this);
        ((StateListDrawable) localObject).addState(new int[]{16842919}, localDrawable);
        this.mCloseButton.setImageDrawable((Drawable) localObject);
        this.mCloseButton.setBackgroundDrawable(null);
        this.mCloseButton.setOnClickListener(new BaseInterstitialActivity .2 (this));
        localObject = new RelativeLayout.LayoutParams(this.mButtonSize, this.mButtonSize);
        ((RelativeLayout.LayoutParams) localObject).addRule(11);
        ((RelativeLayout.LayoutParams) localObject).setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
        this.mLayout.addView(this.mCloseButton, (ViewGroup.LayoutParams) localObject);
    }

    void addCloseEventRegion() {
        int i = Dips.dipsToIntPixels(50.0F, this);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(10);
        Interstitials.addCloseEventRegion(this.mLayout, localLayoutParams, this.mCloseOnClickListener);
    }

    protected AdConfiguration getAdConfiguration() {
        try {
            AdConfiguration localAdConfiguration = (AdConfiguration) getIntent().getSerializableExtra("Ad-Configuration");
            return localAdConfiguration;
        } catch (ClassCastException localClassCastException) {
        }
        return null;
    }

    public abstract View getAdView();

    long getBroadcastIdentifier() {
        return this.mBroadcastIdentifier;
    }

    protected void hideInterstitialCloseButton() {
        this.mCloseButton.setVisibility(4);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.mButtonSize = Dips.asIntPixels(50.0F, this);
        this.mButtonPadding = Dips.asIntPixels(8.0F, this);
        this.mCloseOnClickListener = new BaseInterstitialActivity .1 (this);
        this.mLayout = new RelativeLayout(this);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        this.mLayout.addView(getAdView(), paramBundle);
        setContentView(this.mLayout);
        paramBundle = getAdConfiguration();
        if (paramBundle != null) {
            this.mBroadcastIdentifier = paramBundle.getBroadcastIdentifier();
        }
        createInterstitialCloseButton();
    }

    protected void onDestroy() {
        this.mLayout.removeAllViews();
        super.onDestroy();
    }

    protected void showInterstitialCloseButton() {
        this.mCloseButton.setVisibility(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseInterstitialActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */