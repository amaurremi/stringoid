package com.inmobi.re.container;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDBasic;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.MRAIDResizeController;
import com.inmobi.re.controller.JSController.Dimensions;
import com.inmobi.re.controller.JSController.ExpandProperties;
import com.inmobi.re.controller.JSController.PlayerProperties;
import com.inmobi.re.controller.JSController.ResizeProperties;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayer.playerState;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONObject;

public class IMWebView
        extends WebView
        implements Serializable {
    public static final String DIMENSIONS = "expand_dimensions";
    public static final String EXPAND_URL = "expand_url";
    private static Class<?> G = null;
    protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static int[] d = {16843039, 16843040};
    private static final long serialVersionUID = 7098506283154473782L;
    public static boolean userInitiatedClose = false;
    private IMWebView.i A;
    private ArrayList<String> B = new ArrayList();
    private AtomicBoolean C = new AtomicBoolean();
    private ViewParent D;
    private int E;
    private boolean F = false;
    private WebViewClient H = new b(this);
    private WebChromeClient I = new c(this);
    private MediaPlayer.OnCompletionListener J = new a(this);
    private boolean K = true;
    double a = -1.0D;
    public AtomicBoolean acqMutexcPos = new AtomicBoolean(true);
    public AtomicBoolean acqMutexdPos = new AtomicBoolean(true);
    AtomicBoolean b = new AtomicBoolean(false);
    IMWebView.InstantVideoCallbackCallback c = null;
    public JSONObject curPosition;
    public JSONObject defPosition;
    public AtomicBoolean doNotFireVisibilityChanged = new AtomicBoolean(false);
    private boolean e;
    private boolean f = false;
    private JSUtilityController g;
    private float h;
    private int i;
    public AtomicBoolean isMutexAquired = new AtomicBoolean(false);
    public boolean isTablet = false;
    private int j;
    private IMWebView.ViewState k = IMWebView.ViewState.LOADING;
    private IMWebView.IMWebViewPlayableListener l;
    private VideoView m;
    public MRAIDAudioVideoController mAudioVideoController;
    public MRAIDExpandController mExpandController;
    public MRAIDInterstitialController mInterstitialController;
    public boolean mIsInterstitialAd = false;
    public boolean mIsViewable = false;
    public IMWebView.IMWebViewListener mListener;
    public MRAIDBasic mMraidBasic;
    public IMWebView mOriginalWebviewForExpandUrl = null;
    public MRAIDResizeController mResizeController;
    public boolean mWebViewIsBrowserActivity = false;
    protected boolean mraidLoaded;
    public Object mutex = new Object();
    public Object mutexcPos = new Object();
    public Object mutexdPos = new Object();
    private View n;
    private WebChromeClient.CustomViewCallback o = null;
    private ViewGroup p;
    public int publisherOrientation;
    private FrameLayout q;
    private ArrayList<IMWebView.g> r;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v;
    private Message w;
    public String webviewUserAgent;
    private Message x;
    private Activity y;
    private WebViewClient z;

    public IMWebView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.y = ((Activity) paramContext);
        c();
        getContext().obtainStyledAttributes(paramAttributeSet, d).recycle();
    }

    public IMWebView(Context paramContext, IMWebView.IMWebViewListener paramIMWebViewListener) {
        super(paramContext);
        this.mListener = paramIMWebViewListener;
        this.y = ((Activity) paramContext);
        c();
    }

    public IMWebView(Context paramContext, IMWebView.IMWebViewListener paramIMWebViewListener, boolean paramBoolean1, boolean paramBoolean2) {
        super(paramContext);
        this.y = ((Activity) paramContext);
        this.mIsInterstitialAd = paramBoolean1;
        this.mWebViewIsBrowserActivity = paramBoolean2;
        if (this.mIsInterstitialAd) {
            setId(117);
        }
        this.mListener = paramIMWebViewListener;
        c();
    }

    private int a(Activity paramActivity) {
        Iterator localIterator = paramActivity.getPackageManager().queryIntentActivities(new Intent(paramActivity, paramActivity.getClass()), 65536).iterator();
        ResolveInfo localResolveInfo;
        do {
            if (!localIterator.hasNext()) {
                break;
            }
            localResolveInfo = (ResolveInfo) localIterator.next();
        } while (!localResolveInfo.activityInfo.name.contentEquals(paramActivity.getClass().getName()));
        for (paramActivity = localResolveInfo; ; paramActivity = null) {
            return paramActivity.activityInfo.configChanges;
        }
    }

    private void a(int paramInt1, int paramInt2) {
        injectJavaScript("window.mraid.broadcastEvent('sizeChange'," + paramInt1 + "," + paramInt2 + ");");
    }

    private void a(View paramView, View.OnKeyListener paramOnKeyListener) {
        paramView.setOnKeyListener(paramOnKeyListener);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        if ((paramView instanceof ViewGroup)) {
            paramView = (ViewGroup) paramView;
            int i1 = 0;
            int i2 = paramView.getChildCount();
            while (i1 < i2) {
                a(paramView.getChildAt(i1), paramOnKeyListener);
                i1 += 1;
            }
        }
    }

    private void a(View paramView, View.OnTouchListener paramOnTouchListener) {
        paramView.setOnTouchListener(paramOnTouchListener);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        if ((paramView instanceof ViewGroup)) {
            paramView = (ViewGroup) paramView;
            int i1 = 0;
            int i2 = paramView.getChildCount();
            while (i1 < i2) {
                a(paramView.getChildAt(i1), paramOnTouchListener);
                i1 += 1;
            }
        }
    }

    @TargetApi(8)
    private void a(SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.y);
        localBuilder.setPositiveButton("Continue", new IMWebView.e(this, paramSslErrorHandler));
        localBuilder.setNegativeButton("Go Back", new IMWebView.f(this, paramSslErrorHandler));
        if (Build.VERSION.SDK_INT >= 14) {
            localBuilder.setNeutralButton("Open Browser", new IMWebView.d(this, paramSslError));
        }
        localBuilder.setTitle("Security Warning");
        localBuilder.setMessage("There are problems with the security certificate for this site.");
        paramSslErrorHandler = localBuilder.create();
        try {
            paramSslErrorHandler.show();
            return;
        } catch (Exception paramSslErrorHandler) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Dialog could not be shown due to an exception.", paramSslErrorHandler);
        }
    }

    private void a(String paramString) {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.addFlags(268435456);
        this.y.startActivity(paramString);
        fireOnLeaveApplication();
    }

    private void a(boolean paramBoolean) {
        Log.debug("[InMobi]-[RE]-4.5.1", "Viewable:" + paramBoolean);
        injectJavaScript("window.mraid.broadcastEvent('viewableChange'," + isViewable() + ");");
    }

    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    private void c() {
        b();
        userInitiatedClose = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.webviewUserAgent = getSettings().getUserAgentString();
        InternalSDKUtil.getUserAgent();
        setBackgroundColor(Initializer.getConfigParams().getWebviewBgColor());
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (Build.VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.h = this.y.getResources().getDisplayMetrics().density;
        this.e = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setGeolocationEnabled(true);
        this.g = new JSUtilityController(this, getContext());
        addJavascriptInterface(this.g, "utilityController");
        setWebViewClient(this.H);
        setWebChromeClient(this.I);
        this.mExpandController = new MRAIDExpandController(this, this.y);
        this.mResizeController = new MRAIDResizeController(this, this.y);
        this.mMraidBasic = new MRAIDBasic(this, this.y);
        this.mInterstitialController = new MRAIDInterstitialController(this, this.y);
        this.mAudioVideoController = new MRAIDAudioVideoController(this);
        this.A = new IMWebView.i(this, this.mMraidBasic, this.mExpandController, this.mInterstitialController, this.mAudioVideoController, this.mResizeController);
        this.mExpandController.mSensorDisplay = ((WindowManager) this.y.getSystemService("window")).getDefaultDisplay();
        this.mAudioVideoController.videoValidateWidth = this.y.getResources().getDisplayMetrics().widthPixels;
        try {
            addJavascriptInterface(G.getDeclaredConstructor(new Class[]{IMWebView.class}).newInstance(new Object[]{this}), "imaiController");
            this.g.setWebViewClosed(false);
            return;
        } catch (Exception localException) {
            for (; ; ) {
                Log.internal("[InMobi]-[RE]-4.5.1", "Error adding js interface imai controller");
            }
        }
    }

    private void d() {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> initStates");
        this.k = IMWebView.ViewState.LOADING;
        this.C.set(false);
    }

    private void e() {
        if (this.k == IMWebView.ViewState.EXPANDED) {
            this.mExpandController.closeExpanded();
        }
        invalidate();
        this.g.stopAllListeners();
        resetLayout();
    }

    private void f() {
        if (this.n == null) {
            return;
        }
        if (this.o != null) {
            this.o.onCustomViewHidden();
        }
        this.o = null;
        if (this.n.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        this.n = null;
    }

    private boolean g() {
        return this.b.get();
    }

    public static void setIMAIController(Class<?> paramClass) {
        G = paramClass;
    }

    void a() {
        for (; ; ) {
            int i1;
            try {
                if (this.r != null) {
                    i1 = 0;
                    if (i1 < this.r.size()) {
                        IMWebView.g localg = (IMWebView.g) this.r.get(i1);
                        if (localg.getStatus() == AsyncTask.Status.RUNNING) {
                            localg.cancel(true);
                        }
                    } else {
                        this.r.clear();
                        this.r = null;
                    }
                } else {
                    b();
                    return;
                }
            } catch (Exception localException) {
                Log.internal("[InMobi]-[RE]-4.5.1", "Exception deleting saved content dirs and stopping download task");
                return;
            }
            i1 += 1;
        }
    }

    public void addJavascriptObject(Object paramObject, String paramString) {
        addJavascriptInterface(paramObject, paramString);
    }

    void b() {
        try {
            Object localObject = InternalSDKUtil.getContext();
            localObject = new File(((Context) localObject).getExternalFilesDir(null) + "/im_cached_content/");
            if ((((File) localObject).exists()) && (((File) localObject).isDirectory())) {
                String[] arrayOfString = ((File) localObject).list();
                int i1 = 0;
                while (i1 < arrayOfString.length) {
                    new File((File) localObject, arrayOfString[i1]).delete();
                    i1 += 1;
                }
                ((File) localObject).delete();
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception deleting saved content dirs and stopping download task");
        }
    }

    public void broadcastEventIMraid(String paramString, Object paramObject) {
        try {
            this.y.runOnUiThread(new IMWebView.c(this, paramObject, paramString));
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception broadcasting events", paramString);
        }
    }

    public void broadcastEventIMraid(String paramString1, String paramString2) {
        try {
            this.y.runOnUiThread(new IMWebView.b(this, paramString2, paramString1));
            return;
        } catch (Exception paramString1) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception broadcasting events", paramString1);
        }
    }

    public void cancelLoad() {
        this.C.set(true);
    }

    public void cancelSaveContent(String paramString) {
        int i1;
        if (this.r != null) {
            i1 = 0;
        }
        for (; ; ) {
            if (i1 < this.r.size()) {
                IMWebView.g localg = (IMWebView.g) this.r.get(i1);
                if ((localg.a().equals(paramString)) && (localg.getStatus() == AsyncTask.Status.RUNNING)) {
                    localg.cancel(true);
                }
            } else {
                return;
            }
            i1 += 1;
        }
    }

    public void clearView() {
        e();
        super.clearView();
    }

    public void close() {
        try {
            a();
            this.g.setWebViewClosed(true);
            if (!this.A.hasMessages(1001)) {
                this.A.sendEmptyMessage(1001);
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception closing webview. Webview not initialized properly", localException);
        }
    }

    public void closeExpanded() {
        this.A.sendEmptyMessage(1005);
    }

    protected void closeOpened(View paramView) {
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(paramView);
        requestLayout();
    }

    public void closeResized() {
        this.A.sendEmptyMessage(1031);
    }

    public void closeVideo(String paramString) {
        AVPlayer localAVPlayer = this.mAudioVideoController.getVideoPlayer(paramString);
        if (localAVPlayer == null) {
            raiseError("Invalid property ID", "closeVideo");
            return;
        }
        if (localAVPlayer.getState() == AVPlayer.playerState.RELEASED) {
            raiseError("Invalid player state", "closeVideo");
            return;
        }
        this.mAudioVideoController.videoPlayerList.remove(paramString);
        paramString = this.A.obtainMessage(1012);
        paramString.obj = localAVPlayer;
        this.A.sendMessage(paramString);
    }

    public void deinit() {
        if ((getStateVariable() == IMWebView.ViewState.EXPANDED) || (getStateVariable() == IMWebView.ViewState.EXPANDING)) {
            close();
        }
    }

    public void destroy() {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView: Destroy called.");
        close();
        postInHandler(new IMWebView.m(this));
    }

    public void disableCloseRegion() {
        CustomView localCustomView = (CustomView) ((ViewGroup) getRootView()).findViewById(226);
        if (localCustomView != null) {
            localCustomView.disableView(this.u);
        }
    }

    public void disableHardwareAcceleration() {
        this.K = false;
        Log.internal("[InMobi]-[RE]-4.5.1", "disableHardwareAcceleration called.");
        if (Build.VERSION.SDK_INT >= 14) {
            WrapperFunctions.disableHardwareAccl(this);
            this.mExpandController.disableEnableHardwareAccelerationForExpandWithURLView();
        }
    }

    public void doHidePlayers() {
        this.A.sendEmptyMessage(1023);
    }

    public void expand(String paramString, JSController.ExpandProperties paramExpandProperties) {
        setState(IMWebView.ViewState.EXPANDING);
        this.mExpandController.mIsExpandUrlValid = false;
        this.isMutexAquired.set(true);
        Message localMessage = this.A.obtainMessage(1004);
        Bundle localBundle = new Bundle();
        localBundle.putString("expand_url", paramString);
        localMessage.setData(localBundle);
        this.mExpandController.expandProperties = paramExpandProperties;
        Log.debug("[InMobi]-[RE]-4.5.1", "Dimensions: {" + this.mExpandController.expandProperties.x + " ," + this.mExpandController.expandProperties.y + " ," + this.mExpandController.expandProperties.width + " ," + this.mExpandController.expandProperties.height + "}");
        this.mExpandController.tempExpPropsLock = this.mExpandController.expandProperties.lockOrientation;
        this.A.sendMessage(localMessage);
    }

    public void fireOnDismissAdScreen() {
        if (this.mListener != null) {
            this.mListener.onDismissAdScreen();
        }
    }

    public void fireOnLeaveApplication() {
        if (this.mListener != null) {
            this.mListener.onLeaveApplication();
        }
    }

    public void fireOnShowAdScreen() {
        if ((this.mListener != null) && (getStateVariable() == IMWebView.ViewState.DEFAULT) && (!this.mIsInterstitialAd)) {
            IMBrowserActivity.requestOnAdDismiss(this.A.obtainMessage(1028));
            this.mListener.onShowAdScreen();
        }
    }

    public Activity getActivity() {
        return this.y;
    }

    public int getAudioVolume(String paramString) {
        paramString = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "getAudioVolume");
            return -1;
        }
        return paramString.getVolume();
    }

    public String getCurrentRotation(int paramInt) {
        switch (paramInt) {
            default:
                return "-1";
            case 0:
                return "0";
            case 1:
                return "90";
            case 2:
                return "180";
        }
        return "270";
    }

    public boolean getCustomClose() {
        return this.t;
    }

    public float getDensity() {
        return this.h;
    }

    public boolean getDisableCloseRegion() {
        return this.u;
    }

    public int getDismissMessage() {
        return 1028;
    }

    public Activity getExpandedActivity() {
        return this.y;
    }

    public int getIntegerCurrentRotation() {
        int i1 = DeviceInfo.getDisplayRotation(((WindowManager) this.y.getSystemService("window")).getDefaultDisplay());
        int i2 = i1;
        if (DeviceInfo.isDefOrientationLandscape(i1, this.y.getResources().getDisplayMetrics().widthPixels, this.y.getResources().getDisplayMetrics().heightPixels)) {
            i2 = i1 + 1;
            i1 = i2;
            if (i2 > 3) {
                i1 = 0;
            }
            i2 = i1;
            if (DeviceInfo.isTablet(this.y.getApplicationContext())) {
                this.isTablet = true;
                i2 = i1;
            }
        }
        return i2;
    }

    public double getLastGoodKnownMicValue() {
        return this.a;
    }

    public ArrayList<String> getMRAIDUrls() {
        return this.B;
    }

    public int getOriginalIndex() {
        return this.E;
    }

    public ViewParent getOriginalParent() {
        if (this.D == null) {
            saveOriginalViewParent();
        }
        return this.D;
    }

    public String getPlacementType() {
        if (this.mIsInterstitialAd) {
            return "interstitial";
        }
        return "inline";
    }

    public IMWebView.IMWebViewPlayableListener getPlayableListener() {
        return this.l;
    }

    public String getSize() {
        return "{ width: " + (int) (getWidth() / this.h) + ", " + "height: " + (int) (getHeight() / this.h) + "}";
    }

    public String getState() {
        return this.k.toString().toLowerCase(Locale.ENGLISH);
    }

    public IMWebView.ViewState getStateVariable() {
        return this.k;
    }

    public int getVideoVolume(String paramString) {
        paramString = this.mAudioVideoController.getVideoPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "getVideoVolume");
            return -1;
        }
        return paramString.getVolume();
    }

    public IMWebView.ViewState getViewState() {
        return this.k;
    }

    public Handler getWebviewHandler() {
        return this.A;
    }

    public void hide() {
        this.A.sendEmptyMessage(1002);
    }

    public void hideVideo(String paramString) {
        Message localMessage = this.A.obtainMessage(1013);
        Bundle localBundle = new Bundle();
        localBundle.putString("pid", paramString);
        localMessage.setData(localBundle);
        this.A.sendMessage(localMessage);
    }

    public void incentCompleted(HashMap<Object, Object> paramHashMap) {
        Message localMessage = this.A.obtainMessage(1034);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("incent_ad_map", paramHashMap);
        localMessage.setData(localBundle);
        localMessage.sendToTarget();
    }

    public void injectJavaScript(String paramString) {
        if (paramString != null) {
        }
        try {
            if (paramString.length() < 400) {
                Log.debug("[InMobi]-[RE]-4.5.1", "Injecting JavaScript: " + paramString);
            }
            if (!g()) {
                super.loadUrl("javascript:try{" + paramString + "}catch(e){}");
            }
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Error injecting javascript ", paramString);
        }
    }

    public boolean isAudioMuted(String paramString) {
        paramString = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "isAudioMuted");
            return false;
        }
        return paramString.isMediaMuted();
    }

    public boolean isBusy() {
        return this.s;
    }

    public boolean isConfigChangesListed(Activity paramActivity) {
        int i2 = Build.VERSION.SDK_INT;
        int i3 = a(paramActivity);
        if (((i3 & 0x10) == 0) || ((i3 & 0x20) == 0) || ((i3 & 0x80) == 0)) {
        }
        for (int i1 = 0; ; i1 = 1) {
            if ((i2 >= 13) && (((i3 & 0x400) == 0) || ((i3 & 0x800) == 0))) {
            }
            for (i2 = 0; ; i2 = 1) {
                return (i1 != 0) && (i2 != 0);
            }
        }
    }

    public boolean isEnabledHardwareAcceleration() {
        return this.K;
    }

    public boolean isExpanded() {
        return this.k == IMWebView.ViewState.EXPANDED;
    }

    public boolean isLandscapeSyncOrientation(int paramInt) {
        return (paramInt == 1) || (paramInt == 3);
    }

    public boolean isModal() {
        return (this.mIsInterstitialAd) || (this.k == IMWebView.ViewState.EXPANDED);
    }

    public boolean isPageFinished() {
        return this.e;
    }

    public boolean isPortraitSyncOrientation(int paramInt) {
        return (paramInt == 0) || (paramInt == 2);
    }

    public boolean isVideoMuted(String paramString) {
        paramString = this.mAudioVideoController.getVideoPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "isVideoMuted");
            return false;
        }
        return paramString.isMediaMuted();
    }

    public boolean isViewable() {
        return this.mIsViewable;
    }

    public void loadData(String paramString1, String paramString2, String paramString3) {
        this.f = false;
        super.loadData(paramString1, paramString2, paramString3);
    }

    public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        this.f = false;
        if (this.k == IMWebView.ViewState.EXPANDED) {
            return;
        }
        d();
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    }

    public void loadUrl(String paramString) {
        this.f = false;
        if (this.k == IMWebView.ViewState.EXPANDED) {
            return;
        }
        d();
        super.loadUrl(paramString);
    }

    public void lockExpandOrientation(Activity paramActivity, boolean paramBoolean, String paramString) {
        int i1;
        try {
            if (!isConfigChangesListed(paramActivity)) {
                return;
            }
            i1 = paramActivity.getRequestedOrientation();
            if ((i1 == 0) || (i1 == 1) || ((Build.VERSION.SDK_INT >= 9) && ((i1 == 8) || (i1 == 9) || (i1 == 6) || (i1 == 7)))) {
                return;
            }
            if (paramBoolean) {
                break label203;
            }
            i1 = getIntegerCurrentRotation();
            this.mExpandController.initialExpandOrientation = paramActivity.getRequestedOrientation();
            if (paramString.equalsIgnoreCase("portrait")) {
                this.mExpandController.useLockOrient = true;
                paramActivity.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i1));
                return;
            }
        } catch (Exception paramActivity) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception handling the orientation ", paramActivity);
            return;
        }
        if (paramString.equalsIgnoreCase("landscape")) {
            this.mExpandController.useLockOrient = true;
            paramActivity.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i1));
            return;
        }
        this.mExpandController.useLockOrient = true;
        if (paramActivity.getResources().getConfiguration().orientation == 2) {
            Log.internal("[InMobi]-[RE]-4.5.1", "In allowFalse, none mode dev orientation:ORIENTATION_LANDSCAPE");
            paramActivity.setRequestedOrientation(0);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.1", "In allowFalse, none mode dev orientation:ORIENTATION_PORTRAIT");
        paramActivity.setRequestedOrientation(1);
        return;
        label203:
        if (paramActivity.getResources().getConfiguration().orientation == 2) {
            Log.internal("[InMobi]-[RE]-4.5.1", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.1", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
    }

    public void mediaPlayerReleased(AVPlayer paramAVPlayer) {
        this.mAudioVideoController.mediaPlayerReleased(paramAVPlayer);
    }

    public void muteAudio(String paramString) {
        Object localObject = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
        if (localObject == null) {
            raiseError("Invalid property ID", "muteAudio");
            return;
        }
        if (((AVPlayer) localObject).getState() == AVPlayer.playerState.RELEASED) {
            raiseError("Invalid player state", "muteAudio");
            return;
        }
        localObject = this.A.obtainMessage(1019);
        Bundle localBundle = new Bundle();
        localBundle.putString("aplayerref", paramString);
        ((Message) localObject).setData(localBundle);
        ((Message) localObject).sendToTarget();
    }

    public void muteVideo(String paramString) {
        paramString = this.mAudioVideoController.getVideoPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "muteVideo");
            return;
        }
        if ((paramString.getState() == AVPlayer.playerState.RELEASED) || (paramString.getState() == AVPlayer.playerState.INIT)) {
            raiseError("Invalid player state", "muteVideo");
            return;
        }
        Message localMessage = this.A.obtainMessage(1015);
        localMessage.obj = paramString;
        this.A.sendMessage(localMessage);
    }

    protected void onAttachedToWindow() {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onAttachedToWindow");
        saveOriginalViewParent();
        if (!this.v) {
            ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
            this.i = localLayoutParams.height;
            this.j = localLayoutParams.width;
            this.v = true;
        }
        this.g.registerBroadcastListener();
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onDetatchedFromWindow");
        this.g.stopAllListeners();
        this.B.clear();
        this.g.unRegisterBroadcastListener();
        if ((this.mIsInterstitialAd) && (!this.mWebViewIsBrowserActivity)) {
            this.mInterstitialController.handleInterstitialClose();
        }
        super.onDetachedFromWindow();
    }

    protected void onIMWebviewVisibilityChanged(boolean paramBoolean) {
        if (this.mIsViewable == paramBoolean) {
        }
        do {
            return;
            this.mIsViewable = paramBoolean;
        } while (this.doNotFireVisibilityChanged.get());
        a(paramBoolean);
    }

    public void onOrientationEventChange() {
        this.A.sendEmptyMessage(1027);
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((paramInt1 != 0) && (paramInt2 != 0)) {
            if (!this.F) {
                a((int) (paramInt1 / getDensity()), (int) (paramInt2 / getDensity()));
            }
            this.F = false;
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        requestFocus();
        return super.onTouchEvent(paramMotionEvent);
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        super.onWindowVisibilityChanged(paramInt);
        if (paramInt == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            onIMWebviewVisibilityChanged(bool);
            if (paramInt != 0) {
            }
            try {
                if (this.g.supports("vibrate")) {
                    ((Vibrator) this.y.getSystemService("vibrator")).cancel();
                }
                return;
            } catch (Exception localException) {
                Log.internal("[InMobi]-[RE]-4.5.1", "Failed to cancel existing vibration", localException);
            }
        }
    }

    public void openExternal(String paramString) {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramString));
        localIntent.addFlags(268435456);
        try {
            getContext().startActivity(localIntent);
            if (this.mListener != null) {
                this.mListener.onLeaveApplication();
            }
            return;
        } catch (Exception paramString) {
            raiseError("Request must specify a valid URL", "openExternal");
        }
    }

    public void openURL(String paramString) {
        if (!isViewable()) {
            raiseError("Cannot open URL.Ad is not viewable yet", "openURL");
            return;
        }
        Message localMessage = this.A.obtainMessage(1024);
        Bundle localBundle = new Bundle();
        localBundle.putString("expand_url", paramString);
        localMessage.setData(localBundle);
        this.A.sendMessage(localMessage);
    }

    public void pageFinishedCallbackForAdCreativeTesting(Message paramMessage) {
        this.x = paramMessage;
    }

    public void pauseAudio(String paramString) {
        Object localObject = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
        if (localObject == null) {
            raiseError("Invalid property ID", "pauseAudio");
        }
        do {
            return;
            if (((AVPlayer) localObject).getState() != AVPlayer.playerState.PLAYING) {
                if ((((AVPlayer) localObject).getState() == AVPlayer.playerState.INIT) && (!((AVPlayer) localObject).isPrepared())) {
                    ((AVPlayer) localObject).setAutoPlay(false);
                    return;
                }
                raiseError("Invalid player state", "pauseAudio");
                return;
            }
        } while (!((AVPlayer) localObject).isPlaying());
        localObject = this.A.obtainMessage(1010);
        Bundle localBundle = new Bundle();
        localBundle.putString("aplayerref", paramString);
        ((Message) localObject).setData(localBundle);
        ((Message) localObject).sendToTarget();
    }

    public void pauseVideo(String paramString) {
        Message localMessage = this.A.obtainMessage(1011);
        Bundle localBundle = new Bundle();
        localBundle.putString("pid", paramString);
        localMessage.setData(localBundle);
        this.A.sendMessage(localMessage);
    }

    public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4) {
        synchronized (this.mutex) {
            boolean bool = this.isMutexAquired.get();
            if (bool == true) {
            }
            try {
                this.mutex.wait();
                if ((!this.mIsInterstitialAd) && (this.k != IMWebView.ViewState.EXPANDED)) {
                    raiseError("Cannot play audio.Ad is not in an expanded state", "playAudio");
                    return;
                }
            } catch (InterruptedException localInterruptedException) {
                for (; ; ) {
                    Log.debug("[InMobi]-[RE]-4.5.1", "mutex failed ", localInterruptedException);
                }
            }
        }
        if (!isViewable()) {
            raiseError("Cannot play audio.Ad is not viewable yet", "playAudio");
            return;
        }
        ???=new JSController.PlayerProperties();
        ((JSController.PlayerProperties) ? ??).
        setProperties(false, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
        paramString2 = new Bundle();
        paramString2.putString("expand_url", paramString1);
        paramString2.putParcelable("player_properties", (Parcelable) ? ??);
        paramString1 = this.A.obtainMessage(1007);
        paramString1.setData(paramString2);
        this.A.sendMessage(paramString1);
    }

    public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, JSController.Dimensions paramDimensions, String paramString2, String paramString3, String paramString4) {
        synchronized (this.mutex) {
            boolean bool = this.isMutexAquired.get();
            if (bool == true) {
            }
            try {
                this.mutex.wait();
                if ((!this.mIsInterstitialAd) && (this.k != IMWebView.ViewState.EXPANDED)) {
                    raiseError("Cannot play video.Ad is not in an expanded state", "playVideo");
                    return;
                }
            } catch (InterruptedException localInterruptedException) {
                for (; ; ) {
                    Log.debug("[InMobi]-[RE]-4.5.1", "mutex failed ", localInterruptedException);
                }
            }
        }
        if (!isViewable()) {
            raiseError("Cannot play video.Ad is not viewable yet", "playVideo");
            return;
        }
        if ((!this.mAudioVideoController.videoPlayerList.isEmpty()) && (this.mAudioVideoController.videoPlayerList.size() >= 5) && (!this.mAudioVideoController.videoPlayerList.containsKey(paramString4))) {
            raiseError("Player Error. Exceeding permissible limit for saved play instances", "playVideo");
            return;
        }
        ???=this.A.obtainMessage(1006);
        JSController.PlayerProperties localPlayerProperties = new JSController.PlayerProperties();
        localPlayerProperties.setProperties(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramString3, paramString4);
        paramString2 = new Bundle();
        paramString2.putString("expand_url", paramString1);
        paramString2.putParcelable("player_properties", localPlayerProperties);
        Log.debug("[InMobi]-[RE]-4.5.1", "Before validation dimension: (" + paramDimensions.x + ", " + paramDimensions.y + ", " + paramDimensions.width + ", " + paramDimensions.height + ")");
        this.mAudioVideoController.validateVideoDimensions(paramDimensions);
        Log.debug("[InMobi]-[RE]-4.5.1", "After validation dimension: (" + paramDimensions.x + ", " + paramDimensions.y + ", " + paramDimensions.width + ", " + paramDimensions.height + ")");
        paramString2.putParcelable("expand_dimensions", paramDimensions);
        ((Message) ? ??).setData(paramString2);
        this.A.sendMessage((Message) ? ??);
    }

    public void postInHandler(Runnable paramRunnable) {
        this.A.post(paramRunnable);
    }

    public void postInjectJavaScript(String paramString) {
        if (paramString != null) {
            if (paramString.length() < 400) {
                Log.debug("[InMobi]-[RE]-4.5.1", "Injecting JavaScript: " + paramString);
            }
            Message localMessage = this.A.obtainMessage(1025);
            Bundle localBundle = new Bundle();
            localBundle.putString("injectMessage", paramString);
            localMessage.setData(localBundle);
            localMessage.sendToTarget();
        }
    }

    public void raiseCameraPictureCapturedEvent(String paramString, int paramInt1, int paramInt2) {
        paramString = "window.mraidview.fireCameraPictureCatpturedEvent('" + paramString + "'" + "," + "'" + paramInt1 + "','" + paramInt2 + "')";
        if (this.y != null) {
            this.y.runOnUiThread(new IMWebView.j(this, paramString));
        }
    }

    public void raiseError(String paramString1, String paramString2) {
        Message localMessage = this.A.obtainMessage(1008);
        Bundle localBundle = new Bundle();
        localBundle.putString("message", paramString1);
        localBundle.putString("action", paramString2);
        localMessage.setData(localBundle);
        this.A.sendMessage(localMessage);
    }

    public void raiseGalleryImageSelectedEvent(String paramString, int paramInt1, int paramInt2) {
        paramString = "window.mraidview.fireGalleryImageSelectedEvent('" + paramString + "'" + "," + "'" + paramInt1 + "','" + paramInt2 + "')";
        if (this.y != null) {
            this.y.runOnUiThread(new IMWebView.l(this, paramString));
        }
    }

    public void raiseMicEvent(double paramDouble) {
        this.a = paramDouble;
        String str = "window.mraid.broadcastEvent('micIntensityChange'," + paramDouble + ")";
        if (this.y != null) {
            this.y.runOnUiThread(new IMWebView.a(this, str));
        }
    }

    public void raiseVibrateCompleteEvent() {
        if (this.y != null) {
            this.y.runOnUiThread(new IMWebView.k(this));
        }
    }

    public void requestOnInterstitialClosed(Message paramMessage) {
        this.mInterstitialController.mMsgOnInterstitialClosed = paramMessage;
    }

    public void requestOnInterstitialShown(Message paramMessage) {
        this.mInterstitialController.mMsgOnInterstitialShown = paramMessage;
    }

    public void resetLayout() {
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        if (this.v) {
            localLayoutParams.height = this.i;
            localLayoutParams.width = this.j;
        }
        setVisibility(0);
        requestLayout();
    }

    public void resetMraid() {
        this.mExpandController.reset();
        this.mResizeController.reset();
        this.g.reset();
    }

    public void resize(JSController.ResizeProperties paramResizeProperties) {
        setState(IMWebView.ViewState.RESIZING);
        this.isMutexAquired.set(true);
        Message localMessage = this.A.obtainMessage(1030);
        this.mResizeController.resizeProperties = paramResizeProperties;
        this.A.sendMessage(localMessage);
    }

    public void saveFile(File paramFile, String paramString1, String paramString2) {
        new IMWebView.g(this, paramFile, paramString1, paramString2).execute(new Void[0]);
    }

    public void saveOriginalViewParent() {
        if (this.D != null) {
        }
        do {
            return;
            this.D = getParent();
        } while (this.D == null);
        int i2 = ((ViewGroup) this.D).getChildCount();
        int i1 = 0;
        for (; ; ) {
            if ((i1 >= i2) || (((ViewGroup) this.D).getChildAt(i1) == this)) {
                this.E = i1;
                return;
            }
            i1 += 1;
        }
    }

    public void seekAudio(String paramString, int paramInt) {
        paramString = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "seekAudio");
            return;
        }
        if (paramString.getState() == AVPlayer.playerState.RELEASED) {
            raiseError("Invalid player state", "seekAudio");
            return;
        }
        Message localMessage = this.A.obtainMessage(1022);
        Bundle localBundle = new Bundle();
        localBundle.putInt("seekaudio", paramInt);
        localMessage.setData(localBundle);
        localMessage.obj = paramString;
        localMessage.sendToTarget();
    }

    public void seekVideo(String paramString, int paramInt) {
        paramString = this.mAudioVideoController.getVideoPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "seekVideo");
            return;
        }
        if ((paramString.getState() == AVPlayer.playerState.RELEASED) || (paramString.getState() == AVPlayer.playerState.INIT)) {
            raiseError("Invalid player state", "seekVideo");
            return;
        }
        Message localMessage = this.A.obtainMessage(1018);
        Bundle localBundle = new Bundle();
        localBundle.putInt("seek", paramInt);
        localMessage.setData(localBundle);
        localMessage.obj = paramString;
        this.A.sendMessage(localMessage);
    }

    public void sendToCPHandler() {
        this.A.sendEmptyMessage(1029);
    }

    public void sendToDPHandler() {
        this.A.sendEmptyMessage(1032);
    }

    public void sendasyncPing(String paramString) {
        this.g.asyncPing(paramString);
    }

    public void setActivity(Activity paramActivity) {
        this.y = paramActivity;
    }

    public void setAudioVolume(String paramString, int paramInt) {
        if (this.mAudioVideoController.getCurrentAudioPlayer(paramString) == null) {
            raiseError("Invalid property ID", "setAudioVolume");
            return;
        }
        Message localMessage = this.A.obtainMessage(1021);
        Bundle localBundle = new Bundle();
        localBundle.putInt("vol", paramInt);
        localBundle.putString("aplayerref", paramString);
        localMessage.setData(localBundle);
        localMessage.sendToTarget();
    }

    public void setBrowserActivity(Activity paramActivity) {
        if (paramActivity != null) {
            this.y = ((IMBrowserActivity) paramActivity);
        }
    }

    public void setBusy(boolean paramBoolean) {
        this.s = paramBoolean;
    }

    public void setCallBack(IMWebView.InstantVideoCallbackCallback paramInstantVideoCallbackCallback) {
        this.c = paramInstantVideoCallbackCallback;
    }

    public void setCloseButton() {
        try {
            CustomView localCustomView = (CustomView) ((ViewGroup) getRootView()).findViewById(225);
            if (localCustomView != null) {
                if (!getCustomClose()) {
                    break label37;
                }
            }
            label37:
            for (int i1 = 8; ; i1 = 0) {
                localCustomView.setVisibility(i1);
                return;
            }
            return;
        } catch (Exception localException) {
        }
    }

    public void setCustomClose(boolean paramBoolean) {
        this.t = paramBoolean;
        Message localMessage = this.A.obtainMessage(1009);
        this.A.sendMessage(localMessage);
    }

    public void setDisableCloseRegion(boolean paramBoolean) {
        this.u = paramBoolean;
        Message localMessage = this.A.obtainMessage(1035);
        this.A.sendMessage(localMessage);
    }

    public void setExpandPropertiesForInterstitial(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
        setCustomClose(paramBoolean1);
        this.mInterstitialController.orientationValueForInterstitial = paramString;
        this.mInterstitialController.lockOrientationValueForInterstitial = paramBoolean2;
        if (this.mWebViewIsBrowserActivity) {
            this.mExpandController.handleOrientationFor2Piece();
        }
        if ((isViewable()) && (this.mIsInterstitialAd)) {
            this.A.sendEmptyMessage(1026);
        }
    }

    public void setExternalWebViewClient(WebViewClient paramWebViewClient) {
        this.z = paramWebViewClient;
    }

    public void setOrientationPropertiesForInterstitial(boolean paramBoolean, String paramString) {
        this.mInterstitialController.orientationValueForInterstitial = paramString;
        this.mInterstitialController.lockOrientationValueForInterstitial = paramBoolean;
        if (this.mWebViewIsBrowserActivity) {
            this.mExpandController.handleOrientationFor2Piece();
        }
        if ((isViewable()) && (this.mIsInterstitialAd)) {
            this.A.sendEmptyMessage(1026);
        }
    }

    public void setOriginalParent(ViewParent paramViewParent) {
        this.D = paramViewParent;
    }

    public void setPlayableListener(IMWebView.IMWebViewPlayableListener paramIMWebViewPlayableListener) {
        this.l = paramIMWebViewPlayableListener;
    }

    public void setState(IMWebView.ViewState paramViewState) {
        Log.debug("[InMobi]-[RE]-4.5.1", "State changing from " + this.k + " to " + paramViewState);
        this.k = paramViewState;
        if ((paramViewState != IMWebView.ViewState.EXPANDING) && (paramViewState != IMWebView.ViewState.RESIZING)) {
            injectJavaScript("window.mraid.broadcastEvent('stateChange','" + getState() + "');");
        }
    }

    public void setVideoVolume(String paramString, int paramInt) {
        paramString = this.mAudioVideoController.getVideoPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "setVideoVolume");
            return;
        }
        if (paramString.getState() == AVPlayer.playerState.RELEASED) {
            raiseError("Invalid player state", "setVideoVolume");
            return;
        }
        Message localMessage = this.A.obtainMessage(1017);
        Bundle localBundle = new Bundle();
        localBundle.putInt("volume", paramInt);
        localMessage.setData(localBundle);
        localMessage.obj = paramString;
        this.A.sendMessage(localMessage);
    }

    public void show() {
        this.A.sendEmptyMessage(1003);
    }

    public void showVideo(String paramString) {
        Message localMessage = this.A.obtainMessage(1014);
        Bundle localBundle = new Bundle();
        localBundle.putString("pid", paramString);
        localMessage.setData(localBundle);
        this.A.sendMessage(localMessage);
    }

    public void unMuteAudio(String paramString) {
        Object localObject = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
        if (localObject == null) {
            raiseError("Invalid property ID", "unmuteAudio");
            return;
        }
        if (((AVPlayer) localObject).getState() == AVPlayer.playerState.RELEASED) {
            raiseError("Invalid player state", "unmuteAudio");
            return;
        }
        localObject = this.A.obtainMessage(1020);
        Bundle localBundle = new Bundle();
        localBundle.putString("aplayerref", paramString);
        ((Message) localObject).setData(localBundle);
        ((Message) localObject).sendToTarget();
    }

    public void unMuteVideo(String paramString) {
        paramString = this.mAudioVideoController.getVideoPlayer(paramString);
        if (paramString == null) {
            raiseError("Invalid property ID", "unMuteVideo");
            return;
        }
        if ((paramString.getState() == AVPlayer.playerState.RELEASED) || (paramString.getState() == AVPlayer.playerState.INIT)) {
            raiseError("Invalid player state", "unMuteVideo");
            return;
        }
        Message localMessage = this.A.obtainMessage(1016);
        localMessage.obj = paramString;
        this.A.sendMessage(localMessage);
    }

    public void userInteraction(HashMap<String, String> paramHashMap) {
        Message localMessage = this.A.obtainMessage(1033);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("map", paramHashMap);
        localMessage.setData(localBundle);
        localMessage.sendToTarget();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */