package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Message;
import android.view.Display;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.ViewState;

import java.util.concurrent.atomic.AtomicBoolean;

public class MRAIDInterstitialController {
    protected static final int INT_BACKGROUND_ID = 224;
    public static AtomicBoolean isInterstitialDisplayed = new AtomicBoolean();
    private IMWebView a;
    private Activity b;
    private long c = 0L;
    private int d;
    public boolean lockOrientationValueForInterstitial = true;
    public Message mMsgOnInterstitialClosed;
    public Message mMsgOnInterstitialShown;
    public Display mSensorDisplay;
    public String orientationValueForInterstitial;

    public MRAIDInterstitialController(IMWebView paramIMWebView, Activity paramActivity) {
        this.a = paramIMWebView;
    }

    private CustomView a() {
        CustomView localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        localCustomView.setId(226);
        localCustomView.disableView(this.a.getDisableCloseRegion());
        return localCustomView;
    }

    public void animateAndDismissWebview() {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
        localAlphaAnimation.setStartOffset(0L);
        localAlphaAnimation.setDuration(this.c);
        localAlphaAnimation.setAnimationListener(new MRAIDInterstitialController.c(this));
        this.a.startAnimation(localAlphaAnimation);
    }

    public void changeContentAreaForInterstitials(long paramLong) {
        try {
            this.c = paramLong;
            int j = Initializer.getConfigParams().getWebviewBgColor();
            this.d = this.b.getRequestedOrientation();
            handleOrientationForInterstitial();
            FrameLayout localFrameLayout = (FrameLayout) this.b.findViewById(16908290);
            RelativeLayout localRelativeLayout = new RelativeLayout(this.a.getContext());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
            localLayoutParams.addRule(10);
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
            localRelativeLayout.addView(this.a, localLayoutParams);
            localLayoutParams = new RelativeLayout.LayoutParams((int) (this.a.getDensity() * 50.0F), (int) (this.a.getDensity() * 50.0F));
            localLayoutParams.addRule(11);
            localRelativeLayout.addView(a(), localLayoutParams);
            CustomView localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_BUTTON);
            if (this.a.getCustomClose()) {
            }
            for (int i = 8; ; i = 0) {
                localCustomView.setVisibility(i);
                localCustomView.setId(225);
                localRelativeLayout.addView(localCustomView, localLayoutParams);
                localLayoutParams = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
                localRelativeLayout.setId(224);
                localRelativeLayout.setBackgroundColor(j);
                localFrameLayout.addView(localRelativeLayout, localLayoutParams);
                this.a.setBackgroundColor(j);
                this.a.requestFocus();
                this.a.setOnKeyListener(new MRAIDInterstitialController.b(this));
                this.a.setOnTouchListener(new MRAIDInterstitialController.d(this));
                isInterstitialDisplayed.set(true);
                this.a.fireOnShowAdScreen();
                return;
            }
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Failed showing interstitial ad", localException);
        }
    }

    public void dismissWebview() {
        FrameLayout localFrameLayout = (FrameLayout) this.b.findViewById(16908290);
        RelativeLayout localRelativeLayout = (RelativeLayout) localFrameLayout.findViewById(224);
        this.b.runOnUiThread(new MRAIDInterstitialController.a(this, localRelativeLayout, localFrameLayout));
    }

    public void handleInterstitialClose() {
        IMWebView.userInitiatedClose = true;
        isInterstitialDisplayed.set(false);
        this.a.close();
    }

    public void handleOrientationForInterstitial() {
        this.a.lockExpandOrientation(this.b, this.lockOrientationValueForInterstitial, this.orientationValueForInterstitial);
    }

    public void resetContentsForInterstitials() {
        for (; ; ) {
            try {
                if (this.a.getParent() == null) {
                    return;
                }
                this.b.setRequestedOrientation(this.d);
                this.a.mAudioVideoController.releaseAllPlayers();
                if ((RelativeLayout) ((FrameLayout) this.b.findViewById(16908290)).findViewById(224) != null) {
                    if (this.c > 0L) {
                        animateAndDismissWebview();
                    }
                } else {
                    this.a.fireOnDismissAdScreen();
                    this.a.injectJavaScript("window.mraidview.unRegisterOrientationListener()");
                    this.a.setState(IMWebView.ViewState.HIDDEN);
                    this.b.finish();
                    return;
                }
            } catch (Exception localException) {
                Log.debug("[InMobi]-[RE]-4.5.1", "Failed to close the interstitial ad", localException);
                return;
            }
            dismissWebview();
        }
    }

    public void setActivity(Activity paramActivity) {
        if (paramActivity != null) {
            this.b = paramActivity;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDInterstitialController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */