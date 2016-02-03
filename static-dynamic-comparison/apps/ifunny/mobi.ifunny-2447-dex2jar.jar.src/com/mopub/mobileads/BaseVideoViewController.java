package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.logging.MoPubLog;

abstract class BaseVideoViewController {
    private final BaseVideoViewController.BaseVideoViewControllerListener mBaseVideoViewControllerListener;
    private long mBroadcastIdentifier;
    private final Context mContext;
    private final RelativeLayout mLayout;

    BaseVideoViewController(Context paramContext, long paramLong, BaseVideoViewController.BaseVideoViewControllerListener paramBaseVideoViewControllerListener) {
        this.mContext = paramContext.getApplicationContext();
        this.mBroadcastIdentifier = paramLong;
        this.mBaseVideoViewControllerListener = paramBaseVideoViewControllerListener;
        this.mLayout = new RelativeLayout(this.mContext);
    }

    boolean backButtonEnabled() {
        return true;
    }

    void broadcastAction(String paramString) {
        EventForwardingBroadcastReceiver.broadcastAction(this.mContext, this.mBroadcastIdentifier, paramString);
    }

    BaseVideoViewController.BaseVideoViewControllerListener getBaseVideoViewControllerListener() {
        return this.mBaseVideoViewControllerListener;
    }

    Context getContext() {
        return this.mContext;
    }

    ViewGroup getLayout() {
        return this.mLayout;
    }

    abstract VideoView getVideoView();

    void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    }

    void onCreate() {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(13);
        this.mLayout.addView(getVideoView(), 0, localLayoutParams);
        this.mBaseVideoViewControllerListener.onSetContentView(this.mLayout);
    }

    abstract void onDestroy();

    abstract void onPause();

    abstract void onResume();

    void videoClicked() {
        broadcastAction("com.mopub.action.interstitial.click");
    }

    void videoCompleted(boolean paramBoolean) {
        if (paramBoolean) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }

    void videoError(boolean paramBoolean) {
        MoPubLog.d("Error: video can not be played.");
        broadcastAction("com.mopub.action.interstitial.fail");
        if (paramBoolean) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseVideoViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */