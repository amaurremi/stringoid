package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;

class MraidDisplayController
        extends MraidAbstractController {
    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String LOGTAG = "MraidDisplayController";
    protected int adContainerLayoutId_ = 0;
    private boolean mAdWantsCustomCloseButton;
    private ImageView mCloseButton;
    private Context mContext;
    protected float mDensity;
    private final MraidView.ExpansionStyle mExpansionStyle;
    private boolean mIsViewable;
    private final MraidView.NativeCloseButtonStyle mNativeCloseButtonStyle;
    private BroadcastReceiver mOrientationBroadcastReceiver = new BroadcastReceiver() {
        private int mLastRotation;

        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
            try {
                if (paramAnonymousIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
                    int i = MraidDisplayController.this.getDisplayRotation();
                    if (i != this.mLastRotation) {
                        this.mLastRotation = i;
                        MraidDisplayController.this.onOrientationChanged(this.mLastRotation);
                    }
                }
                return;
            } catch (Exception paramAnonymousContext) {
                Log.d("MraidDisplayController", "Orientation broadcast receiver got exception while executing: %s", new Object[]{paramAnonymousContext.getLocalizedMessage()});
            }
        }
    };
    private final int mOriginalRequestedOrientation;
    FrameLayout mPlaceholderView;
    private boolean mRegistered = false;
    private FrameLayout mRootView;
    protected int mScreenHeight = -1;
    protected int mScreenWidth = -1;
    private MraidView mTwoPartExpansionView;
    private int mViewHeight;
    private int mViewIndexInParent;
    private MraidView.ViewState mViewState = MraidView.ViewState.HIDDEN;
    private int mViewWidth;
    private int modalContainerLayoutId_ = 0;
    private double scalingMultiplier_;
    private AdVideoPlayer vidPlayer_;
    private boolean vidPlaying_ = false;
    private int videoContainerId_ = 0;
    private int viewCounterIncrement_ = 50;
    private int viewCounter_ = 1131261513;
    private int windowHeight_;
    private int windowWidth_;

    MraidDisplayController(MraidView paramMraidView, MraidView.ExpansionStyle paramExpansionStyle, MraidView.NativeCloseButtonStyle paramNativeCloseButtonStyle) {
        super(paramMraidView);
        this.mExpansionStyle = paramExpansionStyle;
        this.mNativeCloseButtonStyle = paramNativeCloseButtonStyle;
        this.windowHeight_ = paramMraidView.getWindowHeight();
        this.windowWidth_ = paramMraidView.getWindowWidth();
        this.scalingMultiplier_ = paramMraidView.getScalingMultiplier();
        this.mContext = getView().getContext();
        if ((this.mContext instanceof Activity)) {
            i = ((Activity) this.mContext).getRequestedOrientation();
        }
        this.mOriginalRequestedOrientation = i;
        initialize();
    }

    private void establishViewIds()
            throws IllegalArgumentException {
        if (this.modalContainerLayoutId_ != 0) {
            return;
        }
        this.modalContainerLayoutId_ = getUniqueViewId();
        this.adContainerLayoutId_ = getUniqueViewId();
        this.videoContainerId_ = getUniqueViewId();
    }

    private int getDisplayRotation() {
        return AndroidTargetUtils.getOrientation(((WindowManager) getView().getContext().getSystemService("window")).getDefaultDisplay());
    }

    private int getUniqueViewId()
            throws IllegalArgumentException {
        if (this.mRootView == null) {
            Log.w("MraidDisplayController", "Could not find root view. View ID may not be unique.");
            i = this.viewCounter_;
            this.viewCounter_ = (i + 1);
            return i;
        }
        this.viewCounter_ += 1;
        int j = 0;
        int i = 0;
        if ((i < 100) && (j == 0)) {
            if (this.mRootView.findViewById(this.viewCounter_) == null) {
                j = 1;
            }
            for (; ; ) {
                i += 1;
                break;
                this.viewCounter_ += this.viewCounterIncrement_;
            }
        }
        if (j == 0) {
            throw new IllegalArgumentException();
        }
        return this.viewCounter_;
    }

    private void onOrientationChanged(int paramInt) {
        initializeScreenMetrics();
        if (this.mRegistered == true) {
            getView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
        }
    }

    private void resetViewToDefaultState() {
        Object localObject = (FrameLayout) findViewByIdInRootView(this.adContainerLayoutId_);
        RelativeLayout localRelativeLayout = (RelativeLayout) findViewByIdInRootView(this.modalContainerLayoutId_);
        setNativeCloseButtonEnabled(false);
        ((FrameLayout) localObject).removeAllViewsInLayout();
        this.mRootView.removeView(localRelativeLayout);
        getView().requestLayout();
        localObject = (ViewGroup) this.mPlaceholderView.getParent();
        ((ViewGroup) localObject).addView(getView(), this.mViewIndexInParent, new ViewGroup.LayoutParams(this.mViewWidth, this.mViewHeight));
        ((ViewGroup) localObject).removeView(this.mPlaceholderView);
        ((ViewGroup) localObject).invalidate();
    }

    private void setOrientationLockEnabled(boolean paramBoolean) {
        Object localObject = getView().getContext();
        try {
            localObject = (Activity) localObject;
            if (paramBoolean) {
            }
            for (int i = Utils.determineCanonicalScreenOrientation(); ; i = this.mOriginalRequestedOrientation) {
                ((Activity) localObject).setRequestedOrientation(i);
                return;
            }
            return;
        } catch (Exception localException) {
            Log.d("MraidDisplayController", "Unable to modify device orientation.");
        }
    }

    private void swapViewWithPlaceholderView() {
        ViewGroup localViewGroup = getParentOfView();
        if (localViewGroup == null) {
            return;
        }
        this.mPlaceholderView = new FrameLayout(getView().getContext());
        int j = localViewGroup.getChildCount();
        int i = 0;
        for (; ; ) {
            if ((i >= j) || (localViewGroup.getChildAt(i) == getView())) {
                this.mViewIndexInParent = i;
                this.mViewHeight = getViewHeight();
                this.mViewWidth = getViewWidth();
                localViewGroup.addView(this.mPlaceholderView, i, new ViewGroup.LayoutParams(getView().getWidth(), getView().getHeight()));
                localViewGroup.removeView(getView());
                return;
            }
            i += 1;
        }
    }

    protected void addViewToRootView(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams) {
        this.mRootView.addView(paramViewGroup, paramLayoutParams);
    }

    protected boolean checkViewable() {
        return true;
    }

    protected void close() {
        if (this.vidPlaying_) {
            this.vidPlayer_.releasePlayer();
            this.vidPlaying_ = false;
        }
        removeKeyListenerFromWebView();
        if (this.mViewState == MraidView.ViewState.EXPANDED) {
            resetViewToDefaultState();
            setOrientationLockEnabled(false);
            this.mViewState = MraidView.ViewState.DEFAULT;
            getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        }
        for (; ; ) {
            if (getView().getOnCloseListener() != null) {
                getView().getOnCloseListener().onClose(getView(), this.mViewState);
            }
            return;
            if (this.mViewState == MraidView.ViewState.DEFAULT) {
                getView().setVisibility(4);
                this.mViewState = MraidView.ViewState.HIDDEN;
                getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
            }
        }
    }

    protected ViewGroup createExpansionViewContainer(View paramView, int paramInt1, int paramInt2) {
        int i = (int) (50.0F * this.mDensity + 0.5F);
        int j = paramInt1;
        if (paramInt1 < i) {
            j = i;
        }
        paramInt1 = paramInt2;
        if (paramInt2 < i) {
            paramInt1 = i;
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(getView().getContext());
        localRelativeLayout.setId(this.modalContainerLayoutId_);
        Object localObject = new View(getView().getContext());
        ((View) localObject).setBackgroundColor(0);
        ((View) localObject).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        localRelativeLayout.addView((View) localObject, new RelativeLayout.LayoutParams(-1, -1));
        localObject = new FrameLayout(getView().getContext());
        ((FrameLayout) localObject).setId(this.adContainerLayoutId_);
        ((FrameLayout) localObject).addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
        paramView = new RelativeLayout.LayoutParams(j, paramInt1);
        paramView.addRule(13);
        localRelativeLayout.addView((View) localObject, paramView);
        return localRelativeLayout;
    }

    public void destroy() {
        try {
            getView().getContext().unregisterReceiver(this.mOrientationBroadcastReceiver);
            if (this.mTwoPartExpansionView != null) {
                this.mTwoPartExpansionView.destroy();
                this.mTwoPartExpansionView = null;
            }
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {
            }
            throw localIllegalArgumentException;
        }
    }

    protected void detachExpandedView() {
        Object localObject;
        if (this.mViewState == MraidView.ViewState.EXPANDED) {
            Log.d("MraidDisplayController", "Ad is currently expanded. Detaching the expanded view and returning ad to its default state.");
            localObject = (RelativeLayout) this.mRootView.findViewById(this.modalContainerLayoutId_);
            if (localObject != null) {
                if (!((RelativeLayout) localObject).isShown()) {
                    break label102;
                }
                this.mRootView.removeView((View) localObject);
            }
        }
        for (; ; ) {
            localObject = (ViewGroup) this.mPlaceholderView.getParent();
            if (localObject != null) {
                ((ViewGroup) localObject).removeView(this.mPlaceholderView);
                setOrientationLockEnabled(false);
                this.mViewState = MraidView.ViewState.DEFAULT;
                getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
            }
            return;
            label102:
            ((RelativeLayout) localObject).removeAllViews();
        }
    }

    protected void expand(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        if ((this.mExpansionStyle == MraidView.ExpansionStyle.DISABLED) || (this.mViewState == MraidView.ViewState.EXPANDED)) {
        }
        for (; ; ) {
            return;
            if (isAdLoading()) {
                Log.e("MraidDisplayController", "Expansion failed because ad loading is currently in progress.");
                return;
            }
            if ((paramString != null) && (!URLUtil.isValidUrl(paramString))) {
                getView().fireErrorEvent("expand", "URL passed to expand() was invalid.");
                return;
            }
            if (!obtainRootView()) {
                getView().fireErrorEvent("expand", "Root view could not be found.");
                Log.e("MraidDisplayController", "Expansion failed because root view could not be found.");
                return;
            }
            try {
                establishViewIds();
                useCustomClose(paramBoolean1);
                setOrientationLockEnabled(paramBoolean2);
                swapViewWithPlaceholderView();
                Object localObject2 = getView();
                ((MraidView) localObject2).setWebViewLayoutParams(-1, -1);
                Object localObject1 = localObject2;
                if (paramString != null) {
                    localObject1 = (MraidRenderer) ((MraidView) localObject2).getAdView();
                    localObject2 = WebViewFactory.getInstance().createWebView(((MraidRenderer) localObject1).context);
                    this.mTwoPartExpansionView = new MraidView((AdView) localObject1, this.windowWidth_, this.windowHeight_, this.scalingMultiplier_, ((MraidRenderer) localObject1).context, (WebView) localObject2, MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INLINE);
                    this.mTwoPartExpansionView.setOnCloseListener(new MraidView.OnCloseListener() {
                        public void onClose(MraidView paramAnonymousMraidView, MraidView.ViewState paramAnonymousViewState) {
                            MraidDisplayController.this.close();
                        }
                    });
                    this.mTwoPartExpansionView.loadUrlForTwoPartExpansionView(paramString);
                    localObject1 = this.mTwoPartExpansionView;
                }
                addViewToRootView(createExpansionViewContainer((View) localObject1, (int) (paramInt1 * this.mDensity), (int) (paramInt2 * this.mDensity)), new RelativeLayout.LayoutParams(-1, -1));
                setKeyListenerToClose((MraidView) localObject1);
                if ((this.mNativeCloseButtonStyle == MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE) || ((!this.mAdWantsCustomCloseButton) && (this.mNativeCloseButtonStyle != MraidView.NativeCloseButtonStyle.ALWAYS_HIDDEN))) {
                    setNativeCloseButtonEnabled(true);
                }
                this.mViewState = MraidView.ViewState.EXPANDED;
                getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
                if (getView().getOnExpandListener() != null) {
                    getView().getOnExpandListener().onExpand(getView());
                    return;
                }
            } catch (IllegalArgumentException paramString) {
                getView().fireErrorEvent("expand", "Could not find available view ID.");
                Log.e("MraidDisplayController", "Expansion failed because available view ID could not be found.");
            }
        }
    }

    protected View findViewByIdInRootView(int paramInt) {
        return this.mRootView.findViewById(paramInt);
    }

    protected ViewGroup getParentOfView() {
        return (ViewGroup) getView().getParent();
    }

    protected int getViewHeight() {
        return getView().getHeight();
    }

    protected int getViewWidth() {
        return getView().getWidth();
    }

    protected void initialize() {
        this.mViewState = MraidView.ViewState.LOADING;
        initializeScreenMetrics();
        registerReceivers();
    }

    protected void initializeJavaScriptState() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
        localArrayList.add(MraidViewableProperty.createWithViewable(this.mIsViewable));
        getView().fireChangeEventForProperties(localArrayList);
        this.mViewState = MraidView.ViewState.DEFAULT;
        getView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
    }

    protected void initializeScreenMetrics() {
        Object localObject = getView().getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) ((Context) localObject).getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        this.mDensity = localDisplayMetrics.density;
        int i = 0;
        int j = 0;
        if ((localObject instanceof Activity)) {
            localObject = ((Activity) localObject).getWindow();
            Rect localRect = new Rect();
            ((Window) localObject).getDecorView().getWindowVisibleDisplayFrame(localRect);
            i = localRect.top;
            j = ((Window) localObject).findViewById(16908290).getTop() - i;
        }
        int k = localDisplayMetrics.widthPixels;
        int m = localDisplayMetrics.heightPixels;
        this.mScreenWidth = ((int) (k * (160.0D / localDisplayMetrics.densityDpi)));
        this.mScreenHeight = ((int) ((m - i - j) * (160.0D / localDisplayMetrics.densityDpi)));
    }

    protected boolean isAdLoading() {
        return ((MraidRenderer) getView().getAdView()).controller.isAdLoading();
    }

    protected boolean isExpanded() {
        return this.mViewState == MraidView.ViewState.EXPANDED;
    }

    protected boolean obtainRootView() {
        this.mRootView = ((FrameLayout) getView().getRootView().findViewById(16908290));
        return this.mRootView != null;
    }

    protected void playVideo(String paramString, Controller.Dimensions paramDimensions, Controller.PlayerProperties paramPlayerProperties) {
        Log.d("MraidDisplayController", "in playVideo");
        if (this.vidPlaying_) {
            return;
        }
        if (paramPlayerProperties.isFullScreen()) {
            Bundle localBundle = new Bundle();
            localBundle.putString("url", paramString);
            localBundle.putParcelable("player_dimensions", paramDimensions);
            localBundle.putParcelable("player_properties", paramPlayerProperties);
            try {
                paramString = new Intent(getView().getContext(), AdActivity.class);
                paramString.putExtra("adapter", VideoActionHandler.class.getName());
                paramString.putExtras(localBundle);
                getView().getContext().startActivity(paramString);
                return;
            } catch (ActivityNotFoundException paramString) {
                Log.e("MraidDisplayController", "Failed to open VideoAction activity");
                return;
            }
        }
        if (this.vidPlayer_ == null) {
            this.vidPlayer_ = new AdVideoPlayer(this.mContext);
        }
        this.vidPlayer_.setPlayData(new Controller.PlayerProperties(), paramString);
        this.vidPlayer_.setListener(new AdVideoPlayer.AdVideoPlayerListener() {
            public void onComplete() {
                Log.d("MraidDisplayController", "videoplayback complete");
                MraidDisplayController.access$202(MraidDisplayController.this, false);
                FrameLayout localFrameLayout = (FrameLayout) MraidDisplayController.this.mRootView.findViewById(MraidDisplayController.this.videoContainerId_);
                localFrameLayout.setVisibility(4);
                MraidDisplayController.this.mRootView.removeView(localFrameLayout);
            }

            public void onError() {
                onComplete();
            }
        });
        paramString = new FrameLayout.LayoutParams(paramDimensions.width, paramDimensions.height);
        paramString.topMargin = paramDimensions.x;
        paramString.bottomMargin = paramDimensions.y;
        this.vidPlayer_.setLayoutParams(paramString);
        paramString = new FrameLayout(getView().getContext());
        paramString.setId(this.videoContainerId_);
        paramString.setPadding(paramDimensions.x, paramDimensions.y, 0, 0);
        this.vidPlayer_.setViewGroup(paramString);
        this.mRootView.addView(paramString, -1, -1);
        this.vidPlaying_ = true;
        this.vidPlayer_.playVideo();
    }

    protected void registerReceivers() {
        if (!this.mRegistered) {
            this.mRegistered = true;
            getView().getContext().registerReceiver(this.mOrientationBroadcastReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    protected void removeKeyListenerFromWebView() {
        getView().getWebView().setOnKeyListener(null);
    }

    protected void setKeyListenerToClose(MraidView paramMraidView) {
        paramMraidView.getWebView().requestFocus();
        paramMraidView.getWebView().setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getRepeatCount() == 0)) {
                    MraidDisplayController.this.close();
                    return true;
                }
                return false;
            }
        });
    }

    protected void setNativeCloseButtonEnabled(boolean paramBoolean) {
        if (this.mRootView == null) {
            return;
        }
        Object localObject1 = (FrameLayout) this.mRootView.findViewById(this.adContainerLayoutId_);
        if (paramBoolean) {
            if (this.mCloseButton == null) {
                localObject2 = new StateListDrawable();
                BitmapDrawable localBitmapDrawable = AndroidTargetUtils.getNewBitmapDrawable(this.mContext.getResources(), Assets.getInstance().getFilePath("amazon_ads_close_button_normal.png"));
                ((StateListDrawable) localObject2).addState(new int[]{-16842919}, localBitmapDrawable);
                localBitmapDrawable = AndroidTargetUtils.getNewBitmapDrawable(this.mContext.getResources(), Assets.getInstance().getFilePath("amazon_ads_close_button_pressed.png"));
                ((StateListDrawable) localObject2).addState(new int[]{16842919}, localBitmapDrawable);
                this.mCloseButton = new ImageButton(getView().getContext());
                this.mCloseButton.setImageDrawable((Drawable) localObject2);
                AndroidTargetUtils.setBackgroundDrawable(this.mCloseButton, null);
                this.mCloseButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        MraidDisplayController.this.close();
                    }
                });
            }
            int i = (int) (50.0F * this.mDensity + 0.5F);
            Object localObject2 = new FrameLayout.LayoutParams(i, i, 5);
            ((FrameLayout) localObject1).addView(this.mCloseButton, (ViewGroup.LayoutParams) localObject2);
        }
        for (; ; ) {
            localObject1 = getView();
            if (((MraidView) localObject1).getOnCloseButtonStateChangeListener() == null) {
                break;
            }
            ((MraidView) localObject1).getOnCloseButtonStateChangeListener().onCloseButtonStateChange((MraidView) localObject1, paramBoolean);
            return;
            ((FrameLayout) localObject1).removeView(this.mCloseButton);
        }
    }

    protected void setRootView(FrameLayout paramFrameLayout) {
        this.mRootView = paramFrameLayout;
    }

    protected void surfaceAd() {
        getView().fireChangeEventForProperty(MraidViewableProperty.createWithViewable(true));
    }

    protected void unregisterReceivers() {
        if (this.mRegistered == true) {
            this.mRegistered = false;
        }
        try {
            getView().getContext().unregisterReceiver(this.mOrientationBroadcastReceiver);
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
        }
    }

    protected void useCustomClose(boolean paramBoolean) {
        this.mAdWantsCustomCloseButton = paramBoolean;
        MraidView localMraidView = getView();
        if (!paramBoolean) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            if (localMraidView.getOnCloseButtonStateChangeListener() != null) {
                localMraidView.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(localMraidView, paramBoolean);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */