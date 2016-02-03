package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.IntentUtils;

public class MraidVideoPlayerActivity
        extends BaseVideoPlayerActivity
        implements BaseVideoViewController.BaseVideoViewControllerListener {
    private BaseVideoViewController mBaseVideoController;
    private long mBroadcastIdentifier;

    private BaseVideoViewController createVideoViewController() {
        String str = getIntent().getStringExtra("video_view_class_name");
        if ("vast".equals(str)) {
            return new VastVideoViewController(this, getIntent().getExtras(), this.mBroadcastIdentifier, this);
        }
        if ("mraid".equals(str)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), this.mBroadcastIdentifier, this);
        }
        throw new IllegalStateException("Unsupported video type: " + str);
    }

    private AdConfiguration getAdConfiguration() {
        try {
            AdConfiguration localAdConfiguration = (AdConfiguration) getIntent().getSerializableExtra("Ad-Configuration");
            return localAdConfiguration;
        } catch (ClassCastException localClassCastException) {
        }
        return null;
    }

    @Deprecated
    BaseVideoViewController getBaseVideoViewController() {
        return this.mBaseVideoController;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        this.mBaseVideoController.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onBackPressed() {
        if (this.mBaseVideoController.backButtonEnabled()) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        paramBundle = getAdConfiguration();
        if (paramBundle != null) {
            this.mBroadcastIdentifier = paramBundle.getBroadcastIdentifier();
        }
        for (; ; ) {
            try {
                this.mBaseVideoController = createVideoViewController();
                this.mBaseVideoController.onCreate();
                return;
            } catch (IllegalStateException paramBundle) {
                EventForwardingBroadcastReceiver.broadcastAction(this, this.mBroadcastIdentifier, "com.mopub.action.interstitial.fail");
                finish();
            }
            MoPubLog.d("Unable to obtain broadcast identifier. Video interactions cannot be tracked.");
        }
    }

    protected void onDestroy() {
        this.mBaseVideoController.onDestroy();
        super.onDestroy();
    }

    public void onFinish() {
        finish();
    }

    protected void onPause() {
        this.mBaseVideoController.onPause();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.mBaseVideoController.onResume();
    }

    public void onSetContentView(View paramView) {
        setContentView(paramView);
    }

    public void onSetRequestedOrientation(int paramInt) {
        setRequestedOrientation(paramInt);
    }

    public void onStartActivityForResult(Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle) {
        if (paramClass == null) {
            return;
        }
        paramBundle = IntentUtils.getStartActivityIntent(this, paramClass, paramBundle);
        try {
            startActivityForResult(paramBundle, paramInt);
            return;
        } catch (ActivityNotFoundException paramBundle) {
            MoPubLog.d("Activity " + paramClass.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    @Deprecated
    void setBaseVideoViewController(BaseVideoViewController paramBaseVideoViewController) {
        this.mBaseVideoController = paramBaseVideoViewController;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidVideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */