package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.ViewState;
import com.inmobi.re.controller.JSController.ExpandProperties;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MRAIDExpandController {
    protected static final int PLACEHOLDER_ID = 437;
    protected static final int RELATIVELAYOUT_ID = 438;
    private IMWebView a;
    private Activity b;
    private Activity c;
    private IMWebView d = null;
    private IMWebView e = null;
    public JSController.ExpandProperties expandProperties;
    public int initialExpandOrientation;
    public boolean lockOrientationValueForExpand = true;
    public boolean mIsExpandUrlValid = false;
    public Display mSensorDisplay;
    public String orientationValueForExpand;
    public boolean tempExpPropsLock = true;
    public boolean useLockOrient;

    public MRAIDExpandController(IMWebView paramIMWebView, Activity paramActivity) {
        this.a = paramIMWebView;
        this.b = paramActivity;
    }

    private FrameLayout a(JSController.ExpandProperties paramExpandProperties) {
        FrameLayout localFrameLayout1 = (FrameLayout) ((ViewGroup) this.a.getOriginalParent()).getRootView().findViewById(16908290);
        a();
        FrameLayout localFrameLayout2 = new FrameLayout(this.a.getContext());
        FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        localFrameLayout2.setId(435);
        localFrameLayout2.setOnTouchListener(new MRAIDExpandController.a(this));
        localFrameLayout2.setPadding(paramExpandProperties.x, paramExpandProperties.y, 0, 0);
        FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        RelativeLayout localRelativeLayout = new RelativeLayout(this.a.getContext());
        localRelativeLayout.setId(438);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        if (this.mIsExpandUrlValid) {
            localRelativeLayout.addView(this.d, localLayoutParams);
        }
        for (; ; ) {
            a(localRelativeLayout, paramExpandProperties.useCustomClose);
            localFrameLayout2.addView(localRelativeLayout, localLayoutParams2);
            localFrameLayout1.addView(localFrameLayout2, localLayoutParams1);
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
            this.a.requestFocus();
            return localFrameLayout2;
            localRelativeLayout.addView(this.a, localLayoutParams);
        }
    }

    private void a() {
        try {
            if (this.a.getOriginalParent() != this.a.getParent()) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
                return;
            }
            FrameLayout localFrameLayout = new FrameLayout(this.a.getContext());
            localFrameLayout.setId(437);
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.a.getWidth(), this.a.getHeight());
            ((ViewGroup) this.a.getOriginalParent()).addView(localFrameLayout, this.a.getOriginalIndex(), localLayoutParams);
            ((ViewGroup) this.a.getParent()).removeView(this.a);
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception in replaceByPlaceHolder ", localException);
        }
    }

    private void a(ViewGroup paramViewGroup, boolean paramBoolean) {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int) (this.a.getDensity() * 50.0F), (int) (this.a.getDensity() * 50.0F));
        localLayoutParams.addRule(11);
        paramViewGroup.addView(b(), localLayoutParams);
        CustomView localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_BUTTON);
        if ((paramBoolean) || (this.a.getCustomClose())) {
        }
        for (int i = 8; ; i = 0) {
            localCustomView.setVisibility(i);
            localCustomView.setId(225);
            paramViewGroup.addView(localCustomView, localLayoutParams);
            return;
        }
    }

    private CustomView b() {
        CustomView localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        localCustomView.setId(226);
        localCustomView.disableView(this.a.getDisableCloseRegion());
        return localCustomView;
    }

    private void c() {
        if (this.d == null) {
            ((ViewGroup) this.a.getParent().getParent().getParent()).removeView((View) this.a.getParent().getParent());
            ((ViewGroup) this.a.getParent()).removeView(this.a);
            localObject = ((View) this.a.getOriginalParent()).findViewById(437);
            ((ViewGroup) ((View) localObject).getParent()).removeView((View) localObject);
            if (this.a.mOriginalWebviewForExpandUrl == null) {
                break label192;
            }
        }
        label192:
        for (Object localObject = this.a.mOriginalWebviewForExpandUrl; ; localObject = this.a) {
            ((ViewGroup) this.a.getOriginalParent()).addView((View) localObject, this.a.getOriginalIndex());
            ((IMWebView) localObject).resetLayout();
            return;
            ((ViewGroup) this.d.getParent().getParent().getParent()).removeView((View) this.d.getParent().getParent());
            ((ViewGroup) this.d.getParent()).removeView(this.d);
            break;
        }
    }

    public void closeExpanded() {
        if (this.a.getViewState().compareTo(IMWebView.ViewState.DEFAULT) == 0) {
            return;
        }
        if (this.e != null) {
            this.e.destroy();
        }
        if (this.a.mOriginalWebviewForExpandUrl != null) {
            this.a.mOriginalWebviewForExpandUrl.setState(IMWebView.ViewState.DEFAULT);
            this.a.mAudioVideoController.releaseAllPlayers();
            this.a.mOriginalWebviewForExpandUrl.mAudioVideoController.releaseAllPlayers();
            this.a.mOriginalWebviewForExpandUrl.mExpandController.e = null;
            this.a.destroy();
        }
        synchronized (this.a.mutex) {
            this.a.isMutexAquired.set(false);
            this.a.mutex.notifyAll();
            if ((!this.tempExpPropsLock) && (this.a.publisherOrientation == -1)) {
                this.tempExpPropsLock = true;
            }
            this.a.doNotFireVisibilityChanged.set(true);
            c();
            this.a.mAudioVideoController.releaseAllPlayers();
            this.a.getMRAIDUrls().clear();
            this.a.closeExpanded();
            this.a.setVisibility(0);
            this.mIsExpandUrlValid = false;
            if (this.useLockOrient) {
                this.b.setRequestedOrientation(this.initialExpandOrientation);
            }
            this.a.setState(IMWebView.ViewState.DEFAULT);
            this.a.doNotFireVisibilityChanged.set(false);
            return;
            this.e = null;
        }
    }

    public void disableEnableHardwareAccelerationForExpandWithURLView() {
        if (this.e != null) {
            this.e.disableHardwareAcceleration();
        }
    }

    public void doExpand(Bundle arg1) {
        this.a.doNotFireVisibilityChanged.set(true);
        for (; ; ) {
            try {
                if (this.a.getOriginalParent() == null) {
                    this.a.saveOriginalViewParent();
                }
                if (((FrameLayout) this.a.getParent().getParent()).getId() == 435) {
                    ((ViewGroup) this.a.getParent().getParent().getParent()).removeView((View) this.a.getParent().getParent());
                }
            } catch (Exception localException2) {
                Intent localIntent;
                continue;
            }
            try {
                ???=???.getString("expand_url");
                if (URLUtil.isValidUrl( ???))
                {
                    this.mIsExpandUrlValid = true;
                    this.d = new IMWebView(this.a.getContext(), this.a.mListener, false, false);
                    this.e = this.d;
                    this.d.publisherOrientation = this.a.publisherOrientation;
                    this.d.mExpandController.tempExpPropsLock = this.a.mExpandController.tempExpPropsLock;
                    this.d.mExpandController.expandProperties = new JSController.ExpandProperties();
                    this.d.mExpandController.expandProperties.x = this.a.mExpandController.expandProperties.x;
                    this.d.mExpandController.expandProperties.y = this.expandProperties.y;
                    this.d.mExpandController.expandProperties.currentX = this.expandProperties.currentX;
                    this.d.mExpandController.expandProperties.currentY = this.expandProperties.currentY;
                    this.d.mExpandController.initialExpandOrientation = this.a.mExpandController.initialExpandOrientation;
                    this.d.mExpandController.useLockOrient = this.a.mExpandController.useLockOrient;
                    this.d.mExpandController.mIsExpandUrlValid = this.a.mExpandController.mIsExpandUrlValid;
                    this.d.mExpandController.e = this.a.mExpandController.e;
                    this.d.mOriginalWebviewForExpandUrl = this.a;
                    this.d.setOriginalParent(this.a.getOriginalParent());
                    this.a.doNotFireVisibilityChanged.set(false);
                    ???=a(this.expandProperties);
                    ((FrameLayout) ? ??).setBackgroundColor(0);
                }
            } catch (Exception localException1) {
                try {
                    localIntent = new Intent(this.b, IMBrowserActivity.class);
                    localIntent.putExtra("extra_browser_type", 102);
                    IMBrowserActivity.setExpandedLayout((FrameLayout) ? ??);
                    if (this.mIsExpandUrlValid) {
                        IMBrowserActivity.setExpandedWebview(this.d);
                        IMBrowserActivity.setOriginalActivity(this.b);
                        this.b.startActivity(localIntent);
                        this.a.mAudioVideoController.videoValidateWidth = this.expandProperties.width;
                        if (this.d != null) {
                            this.d.mAudioVideoController.videoValidateWidth = this.expandProperties.width;
                        }
                    }
                } catch (Exception localException1) {
                    synchronized (this.a.mutex) {
                        this.a.isMutexAquired.set(false);
                        this.a.mutex.notifyAll();
                        if (this.mIsExpandUrlValid) {
                            this.d.loadUrl( ???);
                        }
                        this.a.requestLayout();
                        this.a.invalidate();
                        this.a.postInHandler(new MRAIDExpandController.b(this));
                        this.a.doNotFireVisibilityChanged.set(false);
                        return;
                        this.mIsExpandUrlValid = false;
                        continue;
                        ???=???;
                        Log.debug("[InMobi]-[RE]-4.5.1", "Exception in doexpand ", ???);
                        this.a.setState(IMWebView.ViewState.DEFAULT);
                        synchronized (this.a.mutex) {
                            this.a.isMutexAquired.set(false);
                            this.a.mutex.notifyAll();
                        }
                        IMBrowserActivity.setExpandedWebview(this.a);
                        continue;
                        localException1 = localException1;
                        Log.internal("[InMobi]-[RE]-4.5.1", "Exception in expand in separate activity ", localException1);
                    }
                }
            }
        }
    }

    public void handleOrientationFor2Piece() {
        try {
            int i = this.a.getIntegerCurrentRotation();
            if (this.a.mInterstitialController.lockOrientationValueForInterstitial) {
                break label145;
            }
            if (this.a.mInterstitialController.orientationValueForInterstitial.equals("portrait")) {
                this.b.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i));
                return;
            }
            if (this.a.mInterstitialController.orientationValueForInterstitial.equals("landscape")) {
                this.b.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i));
                return;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "IMWebview Handle orientation for 2 piece ", localException);
            return;
        }
        if (this.b.getResources().getConfiguration().orientation == 2) {
            Log.internal("[InMobi]-[RE]-4.5.1", "In allowFalse, none mode dev orientation:ORIENTATION_LANDSCAPE");
            this.b.setRequestedOrientation(0);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.1", "In allowFalse, none mode dev orientation:ORIENTATION_PORTRAIT");
        this.b.setRequestedOrientation(1);
        return;
        label145:
        if (this.b.getResources().getConfiguration().orientation == 2) {
            Log.internal("[InMobi]-[RE]-4.5.1", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.1", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
    }

    public void handleOrientationForExpand() {
        if (this.mIsExpandUrlValid) {
            this.e.lockExpandOrientation(this.c, this.lockOrientationValueForExpand, this.orientationValueForExpand);
            return;
        }
        this.a.lockExpandOrientation(this.c, this.lockOrientationValueForExpand, this.orientationValueForExpand);
    }

    public void reset() {
        this.expandProperties = new JSController.ExpandProperties();
    }

    public void setActivity(Activity paramActivity) {
        if (paramActivity != null) {
            this.c = paramActivity;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDExpandController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */