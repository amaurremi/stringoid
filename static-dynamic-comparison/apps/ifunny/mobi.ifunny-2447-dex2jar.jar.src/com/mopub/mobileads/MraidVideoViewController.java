package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

public class MraidVideoViewController
        extends BaseVideoViewController {
    private static final float CLOSE_BUTTON_PADDING = 8.0F;
    private static final float CLOSE_BUTTON_SIZE = 50.0F;
    private int mButtonPadding;
    private int mButtonSize;
    private ImageButton mCloseButton;
    private final VideoView mVideoView;

    MraidVideoViewController(Context paramContext, Bundle paramBundle, long paramLong, BaseVideoViewController.BaseVideoViewControllerListener paramBaseVideoViewControllerListener) {
        super(paramContext, paramLong, paramBaseVideoViewControllerListener);
        this.mVideoView = new VideoView(paramContext);
        this.mVideoView.setOnCompletionListener(new MraidVideoViewController .1 (this));
        this.mVideoView.setOnErrorListener(new MraidVideoViewController .2 (this));
        this.mVideoView.setVideoPath(paramBundle.getString("video_url"));
    }

    private void createInterstitialCloseButton() {
        this.mCloseButton = new ImageButton(getContext());
        Object localObject = new StateListDrawable();
        Drawable localDrawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(getContext());
        ((StateListDrawable) localObject).addState(new int[]{-16842919}, localDrawable);
        localDrawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(getContext());
        ((StateListDrawable) localObject).addState(new int[]{16842919}, localDrawable);
        this.mCloseButton.setImageDrawable((Drawable) localObject);
        this.mCloseButton.setBackgroundDrawable(null);
        this.mCloseButton.setOnClickListener(new MraidVideoViewController .3 (this));
        localObject = new RelativeLayout.LayoutParams(this.mButtonSize, this.mButtonSize);
        ((RelativeLayout.LayoutParams) localObject).addRule(11);
        ((RelativeLayout.LayoutParams) localObject).setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
        getLayout().addView(this.mCloseButton, (ViewGroup.LayoutParams) localObject);
    }

    VideoView getVideoView() {
        return this.mVideoView;
    }

    void onCreate() {
        super.onCreate();
        this.mButtonSize = Dips.asIntPixels(50.0F, getContext());
        this.mButtonPadding = Dips.asIntPixels(8.0F, getContext());
        createInterstitialCloseButton();
        this.mCloseButton.setVisibility(8);
        this.mVideoView.start();
    }

    void onDestroy() {
    }

    void onPause() {
    }

    void onResume() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidVideoViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */