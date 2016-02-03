package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.a.n;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

abstract class IAbaseInterstitialAdActivity
        extends Activity {
    private static final float CLOSE_BUTTON_PADDING = 8.0F;
    private static final float CLOSE_BUTTON_SIZE = 50.0F;
    private int mButtonPadding;
    private int mButtonSize;
    private ImageView mCloseButton;
    private RelativeLayout mLayout;

    private void createInterstitialCloseButton() {
        this.mCloseButton = new ImageButton(this);
        Object localObject = new StateListDrawable();
        BitmapDrawable localBitmapDrawable = IAdefines.IAresources.h.a(this);
        ((StateListDrawable) localObject).addState(new int[]{-16842919}, localBitmapDrawable);
        localBitmapDrawable = IAdefines.IAresources.i.a(this);
        ((StateListDrawable) localObject).addState(new int[]{16842919}, localBitmapDrawable);
        this.mCloseButton.setImageDrawable((Drawable) localObject);
        this.mCloseButton.setBackgroundDrawable(null);
        this.mCloseButton.setVisibility(4);
        this.mCloseButton.setOnClickListener(new IAbaseInterstitialAdActivity .1 (this));
        localObject = new RelativeLayout.LayoutParams(this.mButtonSize, this.mButtonSize);
        ((RelativeLayout.LayoutParams) localObject).addRule(11);
        ((RelativeLayout.LayoutParams) localObject).setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
        this.mLayout.addView(this.mCloseButton, (ViewGroup.LayoutParams) localObject);
    }

    protected void broadcastInterstitialAction(String paramString) {
        paramString = new Intent(paramString);
        n.a(this).a(paramString);
    }

    protected void concealInterstitialCloseBtn() {
        this.mCloseButton.setVisibility(4);
    }

    protected void displayInterstitialCloseBtn() {
        this.mCloseButton.setVisibility(0);
    }

    protected IAadConfig getAdConfig() {
        try {
            IAadConfig localIAadConfig = (IAadConfig) getIntent().getSerializableExtra(IAdefines.AdParams.b.c);
            return localIAadConfig;
        } catch (ClassCastException localClassCastException) {
        }
        return null;
    }

    public abstract View getAdView();

    public ImageView getCloseButton() {
        return this.mCloseButton;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.mButtonSize = c.a(50.0F, this);
        this.mButtonPadding = c.a(8.0F, this);
        this.mLayout = new RelativeLayout(this);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramBundle.addRule(13);
        this.mLayout.addView(getAdView(), paramBundle);
        setContentView(this.mLayout);
        createInterstitialCloseButton();
    }

    protected void onDestroy() {
        this.mLayout.removeAllViews();
        super.onDestroy();
    }

    public void setCloseButton(ImageView paramImageView) {
        this.mCloseButton = paramImageView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAbaseInterstitialAdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */