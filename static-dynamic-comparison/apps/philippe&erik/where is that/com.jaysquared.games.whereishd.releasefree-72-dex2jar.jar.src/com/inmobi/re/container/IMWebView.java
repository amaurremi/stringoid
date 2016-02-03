package com.inmobi.re.container;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
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
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import com.inmobi.re.controller.JSController.Dimensions;
import com.inmobi.re.controller.JSController.ExpandProperties;
import com.inmobi.re.controller.JSController.PlayerProperties;
import com.inmobi.re.controller.JSController.ResizeProperties;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayer.playerState;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class IMWebView
  extends WebView
  implements Serializable
{
  private static Class<?> B = null;
  public static final String DIMENSIONS = "expand_dimensions";
  public static final String EXPAND_URL = "expand_url";
  protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
  public static final String PLAYER_PROPERTIES = "player_properties";
  private static int[] c = { 16843039, 16843040 };
  private static final long serialVersionUID = 7098506283154473782L;
  public static boolean userInitiatedClose = false;
  private boolean A = false;
  private WebViewClient C = new b(this);
  private WebChromeClient D = new a(this);
  private boolean E = false;
  private MediaPlayer.OnCompletionListener F = new c(this);
  private boolean G = true;
  double a = -1.0D;
  public AtomicBoolean acqMutexcPos = new AtomicBoolean(true);
  public AtomicBoolean acqMutexdPos = new AtomicBoolean(true);
  AtomicBoolean b = new AtomicBoolean(false);
  public JSONObject curPosition;
  private boolean d;
  public JSONObject defPosition;
  public AtomicBoolean doNotFireVisibilityChanged = new AtomicBoolean(false);
  private JSUtilityController e;
  private float f;
  private int g;
  private int h;
  private ViewState i = ViewState.LOADING;
  public AtomicBoolean isMutexAquired = new AtomicBoolean(false);
  public boolean isTablet = false;
  private VideoView j;
  private View k;
  private WebChromeClient.CustomViewCallback l = null;
  private ViewGroup m;
  public MRAIDAudioVideoController mAudioVideoController;
  public MRAIDExpandController mExpandController;
  public MRAIDInterstitialController mInterstitialController;
  public boolean mIsInterstitialAd = false;
  public IMWebViewListener mListener;
  public MRAIDBasic mMraidBasic;
  public IMWebView mOriginalWebviewForExpandUrl = null;
  public MRAIDResizeController mResizeController;
  public boolean mWebViewIsBrowserActivity = false;
  protected boolean mraidLoaded;
  public Object mutex = new Object();
  public Object mutexcPos = new Object();
  public Object mutexdPos = new Object();
  private FrameLayout n;
  private boolean o = false;
  private boolean p = false;
  public int publisherOrientation;
  private boolean q;
  private Message r;
  private Message s;
  private Activity t;
  private WebViewClient u;
  private f v;
  private ArrayList<String> w = new ArrayList();
  public String webviewUserAgent;
  private AtomicBoolean x = new AtomicBoolean();
  private ViewParent y;
  private int z;
  
  public IMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.t = ((Activity)paramContext);
    a();
    getContext().obtainStyledAttributes(paramAttributeSet, c).recycle();
  }
  
  public IMWebView(Context paramContext, IMWebViewListener paramIMWebViewListener)
  {
    super(paramContext);
    this.mListener = paramIMWebViewListener;
    this.t = ((Activity)paramContext);
    a();
  }
  
  public IMWebView(Context paramContext, IMWebViewListener paramIMWebViewListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.t = ((Activity)paramContext);
    this.mIsInterstitialAd = paramBoolean1;
    this.mWebViewIsBrowserActivity = paramBoolean2;
    if (this.mIsInterstitialAd) {
      setId(117);
    }
    this.mListener = paramIMWebViewListener;
    a();
  }
  
  private int a(Activity paramActivity)
  {
    Iterator localIterator = paramActivity.getPackageManager().queryIntentActivities(new Intent(paramActivity, paramActivity.getClass()), 65536).iterator();
    ResolveInfo localResolveInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localResolveInfo = (ResolveInfo)localIterator.next();
    } while (!localResolveInfo.activityInfo.name.contentEquals(paramActivity.getClass().getName()));
    for (paramActivity = localResolveInfo;; paramActivity = null) {
      return paramActivity.activityInfo.configChanges;
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void a()
  {
    userInitiatedClose = false;
    setScrollContainer(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.webviewUserAgent = getSettings().getUserAgentString();
    InternalSDKUtil.getUserAgent(this.t);
    setBackgroundColor(Initializer.getConfigParams().getWebviewBgColor());
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.f = this.t.getResources().getDisplayMetrics().density;
    this.d = false;
    getSettings().setJavaScriptEnabled(true);
    getSettings().setGeolocationEnabled(true);
    this.e = new JSUtilityController(this, getContext());
    addJavascriptInterface(this.e, "utilityController");
    setWebViewClient(this.C);
    setWebChromeClient(this.D);
    this.mExpandController = new MRAIDExpandController(this, this.t);
    this.mResizeController = new MRAIDResizeController(this, this.t);
    this.mMraidBasic = new MRAIDBasic(this, this.t);
    this.mInterstitialController = new MRAIDInterstitialController(this, this.t);
    this.mAudioVideoController = new MRAIDAudioVideoController(this);
    this.v = new f(this, this.mMraidBasic, this.mExpandController, this.mInterstitialController, this.mAudioVideoController, this.mResizeController);
    this.mExpandController.mSensorDisplay = ((WindowManager)this.t.getSystemService("window")).getDefaultDisplay();
    this.mAudioVideoController.videoValidateWidth = this.t.getResources().getDisplayMetrics().widthPixels;
    try
    {
      addJavascriptInterface(B.getDeclaredConstructor(new Class[] { IMWebView.class }).newInstance(new Object[] { this }), "imaiController");
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "Error adding js interface imai controller");
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    injectJavaScript("window.mraid.broadcastEvent('sizeChange'," + paramInt1 + "," + paramInt2 + ");");
  }
  
  private void a(View paramView, View.OnKeyListener paramOnKeyListener)
  {
    paramView.setOnKeyListener(paramOnKeyListener);
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      int i2 = paramView.getChildCount();
      while (i1 < i2)
      {
        a(paramView.getChildAt(i1), paramOnKeyListener);
        i1 += 1;
      }
    }
  }
  
  private void a(View paramView, View.OnTouchListener paramOnTouchListener)
  {
    paramView.setOnTouchListener(paramOnTouchListener);
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = 0;
      int i2 = paramView.getChildCount();
      while (i1 < i2)
      {
        a(paramView.getChildAt(i1), paramOnTouchListener);
        i1 += 1;
      }
    }
  }
  
  @TargetApi(8)
  private void a(final SslErrorHandler paramSslErrorHandler, final SslError paramSslError)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.t);
    localBuilder.setPositiveButton("Continue", new e(paramSslErrorHandler));
    localBuilder.setNegativeButton("Go Back", new d(paramSslErrorHandler));
    if (Build.VERSION.SDK_INT >= 14) {
      localBuilder.setNeutralButton("Open Browser", new b(paramSslError));
    }
    localBuilder.setTitle("Security Warning");
    localBuilder.setMessage("There are problems with the security certificate for this site.");
    paramSslErrorHandler = localBuilder.create();
    try
    {
      paramSslErrorHandler.show();
      return;
    }
    catch (Exception paramSslErrorHandler)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "Dialog could not be shown due to an exception.", paramSslErrorHandler);
    }
  }
  
  private void a(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    this.t.startActivity(paramString);
    fireOnLeaveApplication();
  }
  
  private void a(boolean paramBoolean)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "Viewable:" + paramBoolean);
    injectJavaScript("window.mraid.broadcastEvent('viewableChange'," + isViewable() + ");");
  }
  
  private void b()
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "IMWebView-> initStates");
    this.i = ViewState.LOADING;
    this.x.set(false);
  }
  
  private void c()
  {
    if (this.i == ViewState.EXPANDED) {
      this.mExpandController.closeExpanded();
    }
    invalidate();
    this.e.stopAllListeners();
    resetLayout();
  }
  
  private void d()
  {
    if (this.k == null) {
      return;
    }
    if (this.l != null) {
      this.l.onCustomViewHidden();
    }
    this.l = null;
    if (this.k.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    }
    this.k = null;
  }
  
  private boolean e()
  {
    return this.b.get();
  }
  
  public static void setIMAIController(Class<?> paramClass)
  {
    B = paramClass;
  }
  
  public void addJavascriptObject(Object paramObject, String paramString)
  {
    addJavascriptInterface(paramObject, paramString);
  }
  
  public void cancelLoad()
  {
    this.x.set(true);
  }
  
  public void clearView()
  {
    c();
    super.clearView();
  }
  
  public void close()
  {
    if (!this.v.hasMessages(1001)) {
      this.v.sendEmptyMessage(1001);
    }
  }
  
  public void closeExpanded()
  {
    this.v.sendEmptyMessage(1005);
  }
  
  protected void closeOpened(View paramView)
  {
    ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(paramView);
    requestLayout();
  }
  
  public void closeResized()
  {
    this.v.sendEmptyMessage(1031);
  }
  
  public void closeVideo(String paramString)
  {
    AVPlayer localAVPlayer = this.mAudioVideoController.getVideoPlayer(paramString);
    if (localAVPlayer == null)
    {
      raiseError("Invalid property ID", "closeVideo");
      return;
    }
    if (localAVPlayer.getState() == AVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "closeVideo");
      return;
    }
    this.mAudioVideoController.videoPlayerList.remove(paramString);
    paramString = this.v.obtainMessage(1012);
    paramString.obj = localAVPlayer;
    this.v.sendMessage(paramString);
  }
  
  public void deinit()
  {
    if ((getStateVariable() == ViewState.EXPANDED) || (getStateVariable() == ViewState.EXPANDING)) {
      close();
    }
  }
  
  public void destroy()
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "IMWebView: Destroy called.");
    close();
    postInHandler(new c());
  }
  
  public void disableHardwareAcceleration()
  {
    this.G = false;
    Log.internal("[InMobi]-[RE]-4.1.1", "disableHardwareAcceleration called.");
    if (Build.VERSION.SDK_INT >= 14)
    {
      WrapperFunctions.disableHardwareAccl(this);
      this.mExpandController.disableEnableHardwareAccelerationForExpandWithURLView();
    }
  }
  
  public void doHidePlayers()
  {
    this.v.sendEmptyMessage(1023);
  }
  
  public void expand(String paramString, JSController.ExpandProperties paramExpandProperties)
  {
    setState(ViewState.EXPANDING);
    this.mExpandController.mIsExpandUrlValid = false;
    this.isMutexAquired.set(true);
    Message localMessage = this.v.obtainMessage(1004);
    Bundle localBundle = new Bundle();
    localBundle.putString("expand_url", paramString);
    localMessage.setData(localBundle);
    this.mExpandController.expandProperties = paramExpandProperties;
    Log.debug("[InMobi]-[RE]-4.1.1", "Dimensions: {" + this.mExpandController.expandProperties.x + " ," + this.mExpandController.expandProperties.y + " ," + this.mExpandController.expandProperties.width + " ," + this.mExpandController.expandProperties.height + "}");
    this.mExpandController.tempExpPropsLock = this.mExpandController.expandProperties.lockOrientation;
    this.v.sendMessage(localMessage);
  }
  
  public void fireOnLeaveApplication()
  {
    if (this.mListener != null) {
      this.mListener.onLeaveApplication();
    }
  }
  
  public void fireOnShowAdScreen()
  {
    if ((this.mListener != null) && (getStateVariable() == ViewState.DEFAULT) && (!this.mIsInterstitialAd))
    {
      IMBrowserActivity.requestOnAdDismiss(this.v.obtainMessage(1028));
      this.mListener.onShowAdScreen();
    }
  }
  
  public Activity getActivity()
  {
    return this.t;
  }
  
  public int getAudioVolume(String paramString)
  {
    paramString = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "getAudioVolume");
      return -1;
    }
    return paramString.getVolume();
  }
  
  public String getCurrentRotation(int paramInt)
  {
    switch (paramInt)
    {
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
  
  public boolean getCustomClose()
  {
    return this.p;
  }
  
  public float getDensity()
  {
    return this.f;
  }
  
  public int getDismissMessage()
  {
    return 1028;
  }
  
  public int getIntegerCurrentRotation()
  {
    int i1 = InternalSDKUtil.getDisplayRotation(((WindowManager)this.t.getSystemService("window")).getDefaultDisplay());
    int i2 = i1;
    if (InternalSDKUtil.isDefOrientationLandscape(i1, this.t.getResources().getDisplayMetrics().widthPixels, this.t.getResources().getDisplayMetrics().heightPixels))
    {
      i2 = i1 + 1;
      i1 = i2;
      if (i2 > 3) {
        i1 = 0;
      }
      i2 = i1;
      if (InternalSDKUtil.isTablet(this.t.getApplicationContext()))
      {
        this.isTablet = true;
        i2 = i1;
      }
    }
    return i2;
  }
  
  public double getLastGoodKnownMicValue()
  {
    return this.a;
  }
  
  public ArrayList<String> getMRAIDUrls()
  {
    return this.w;
  }
  
  public int getOriginalIndex()
  {
    return this.z;
  }
  
  public ViewParent getOriginalParent()
  {
    if (this.y == null) {
      saveOriginalViewParent();
    }
    return this.y;
  }
  
  public String getPlacementType()
  {
    if (this.mIsInterstitialAd) {
      return "interstitial";
    }
    return "inline";
  }
  
  public String getSize()
  {
    return "{ width: " + (int)(getWidth() / this.f) + ", " + "height: " + (int)(getHeight() / this.f) + "}";
  }
  
  public String getState()
  {
    return this.i.toString().toLowerCase(Locale.ENGLISH);
  }
  
  public ViewState getStateVariable()
  {
    return this.i;
  }
  
  public int getVideoVolume(String paramString)
  {
    paramString = this.mAudioVideoController.getVideoPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "getVideoVolume");
      return -1;
    }
    return paramString.getVolume();
  }
  
  public ViewState getViewState()
  {
    return this.i;
  }
  
  public Handler getWebviewHandler()
  {
    return this.v;
  }
  
  public void hide()
  {
    this.v.sendEmptyMessage(1002);
  }
  
  public void hideVideo(String paramString)
  {
    Message localMessage = this.v.obtainMessage(1013);
    Bundle localBundle = new Bundle();
    localBundle.putString("pid", paramString);
    localMessage.setData(localBundle);
    this.v.sendMessage(localMessage);
  }
  
  public void injectJavaScript(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() < 400) {
        Log.debug("[InMobi]-[RE]-4.1.1", "Injecting JavaScript: " + paramString);
      }
      if (!e()) {
        super.loadUrl("javascript:try{" + paramString + "}catch(e){}");
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "Error injecting javascript ", paramString);
    }
  }
  
  public boolean isAudioMuted(String paramString)
  {
    paramString = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "isAudioMuted");
      return false;
    }
    return paramString.isMediaMuted();
  }
  
  public boolean isBusy()
  {
    return this.o;
  }
  
  public boolean isConfigChangesListed(Activity paramActivity)
  {
    int i2 = Build.VERSION.SDK_INT;
    int i3 = a(paramActivity);
    if (((i3 & 0x10) == 0) || ((i3 & 0x20) == 0) || ((i3 & 0x80) == 0)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if ((i2 >= 13) && (((i3 & 0x400) == 0) || ((i3 & 0x800) == 0))) {}
      for (i2 = 0;; i2 = 1) {
        return (i1 != 0) && (i2 != 0);
      }
    }
  }
  
  public boolean isEnabledHardwareAcceleration()
  {
    return this.G;
  }
  
  public boolean isExpanded()
  {
    return this.i == ViewState.EXPANDED;
  }
  
  public boolean isLandscapeSyncOrientation(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public boolean isModal()
  {
    return (this.mIsInterstitialAd) || (this.i == ViewState.EXPANDED);
  }
  
  public boolean isPageFinished()
  {
    return this.d;
  }
  
  public boolean isPortraitSyncOrientation(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  public boolean isVideoMuted(String paramString)
  {
    paramString = this.mAudioVideoController.getVideoPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "isVideoMuted");
      return false;
    }
    return paramString.isMediaMuted();
  }
  
  public boolean isViewable()
  {
    return this.E;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.i == ViewState.EXPANDED) {
      return;
    }
    b();
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.i == ViewState.EXPANDED) {
      return;
    }
    b();
    super.loadUrl(paramString);
  }
  
  public void lockExpandOrientation(boolean paramBoolean, String paramString)
  {
    int i1;
    try
    {
      if (!isConfigChangesListed(this.t)) {
        return;
      }
      i1 = this.t.getRequestedOrientation();
      if ((i1 == 0) || (i1 == 1) || ((Build.VERSION.SDK_INT >= 9) && ((i1 == 8) || (i1 == 9) || (i1 == 6) || (i1 == 7))) || (paramBoolean != true)) {
        return;
      }
      i1 = getIntegerCurrentRotation();
      this.mExpandController.initialExpandOrientation = this.t.getRequestedOrientation();
      if (paramString.equalsIgnoreCase("portrait"))
      {
        this.mExpandController.useLockOrient = true;
        this.t.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i1));
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Exception handling the orientation ", paramString);
      return;
    }
    if (paramString.equalsIgnoreCase("landscape"))
    {
      this.mExpandController.useLockOrient = true;
      this.t.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i1));
    }
  }
  
  public void mediaPlayerReleased(AVPlayer paramAVPlayer)
  {
    this.mAudioVideoController.mediaPlayerReleased(paramAVPlayer);
  }
  
  public void muteAudio(String paramString)
  {
    Object localObject = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
    if (localObject == null)
    {
      raiseError("Invalid property ID", "muteAudio");
      return;
    }
    if (((AVPlayer)localObject).getState() == AVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "muteAudio");
      return;
    }
    localObject = this.v.obtainMessage(1019);
    Bundle localBundle = new Bundle();
    localBundle.putString("aplayerref", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).sendToTarget();
  }
  
  public void muteVideo(String paramString)
  {
    paramString = this.mAudioVideoController.getVideoPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "muteVideo");
      return;
    }
    if ((paramString.getState() == AVPlayer.playerState.RELEASED) || (paramString.getState() == AVPlayer.playerState.INIT))
    {
      raiseError("Invalid player state", "muteVideo");
      return;
    }
    Message localMessage = this.v.obtainMessage(1015);
    localMessage.obj = paramString;
    this.v.sendMessage(localMessage);
  }
  
  protected void onAttachedToWindow()
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "IMWebView-> onAttachedToWindow");
    saveOriginalViewParent();
    if (!this.q)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.g = localLayoutParams.height;
      this.h = localLayoutParams.width;
      this.q = true;
    }
    this.e.registerBroadcastListener();
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "IMWebView-> onDetatchedFromWindow");
    this.e.stopAllListeners();
    this.w.clear();
    this.e.unRegisterBroadcastListener();
    if ((this.mIsInterstitialAd) && (!this.mWebViewIsBrowserActivity)) {
      this.mInterstitialController.handleInterstitialClose();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onIMWebviewVisibilityChanged(boolean paramBoolean)
  {
    if (this.E == paramBoolean) {}
    do
    {
      return;
      this.E = paramBoolean;
    } while (this.doNotFireVisibilityChanged.get());
    a(paramBoolean);
  }
  
  public void onOrientationEventChange()
  {
    this.v.sendEmptyMessage(1027);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (!this.A) {
        a((int)(paramInt1 / getDensity()), (int)(paramInt2 / getDensity()));
      }
      this.A = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    requestFocus();
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      onIMWebviewVisibilityChanged(bool);
      return;
    }
  }
  
  public void openExternal(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    localIntent.addFlags(268435456);
    try
    {
      getContext().startActivity(localIntent);
      if (this.mListener != null) {
        this.mListener.onLeaveApplication();
      }
      return;
    }
    catch (Exception paramString)
    {
      raiseError("Request must specify a valid URL", "openExternal");
    }
  }
  
  public void openURL(String paramString)
  {
    if (!isViewable())
    {
      raiseError("Cannot open URL.Ad is not viewable yet", "openURL");
      return;
    }
    Message localMessage = this.v.obtainMessage(1024);
    Bundle localBundle = new Bundle();
    localBundle.putString("expand_url", paramString);
    localMessage.setData(localBundle);
    this.v.sendMessage(localMessage);
  }
  
  public void pageFinishedCallbackForAdCreativeTesting(Message paramMessage)
  {
    this.s = paramMessage;
  }
  
  public void pauseAudio(String paramString)
  {
    Object localObject = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
    if (localObject == null) {
      raiseError("Invalid property ID", "pauseAudio");
    }
    do
    {
      return;
      if (((AVPlayer)localObject).getState() != AVPlayer.playerState.PLAYING)
      {
        if ((((AVPlayer)localObject).getState() == AVPlayer.playerState.INIT) && (!((AVPlayer)localObject).isPrepared()))
        {
          ((AVPlayer)localObject).setAutoPlay(false);
          return;
        }
        raiseError("Invalid player state", "pauseAudio");
        return;
      }
    } while (!((AVPlayer)localObject).isPlaying());
    localObject = this.v.obtainMessage(1010);
    Bundle localBundle = new Bundle();
    localBundle.putString("aplayerref", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).sendToTarget();
  }
  
  public void pauseVideo(String paramString)
  {
    Message localMessage = this.v.obtainMessage(1011);
    Bundle localBundle = new Bundle();
    localBundle.putString("pid", paramString);
    localMessage.setData(localBundle);
    this.v.sendMessage(localMessage);
  }
  
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4)
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isMutexAquired.get();
      if (bool == true) {}
      try
      {
        this.mutex.wait();
        if ((!this.mIsInterstitialAd) && (this.i != ViewState.EXPANDED))
        {
          raiseError("Cannot play audio.Ad is not in an expanded state", "playAudio");
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.debug("[InMobi]-[RE]-4.1.1", "mutex failed ", localInterruptedException);
        }
      }
    }
    if (!isViewable())
    {
      raiseError("Cannot play audio.Ad is not viewable yet", "playAudio");
      return;
    }
    ??? = new JSController.PlayerProperties();
    ((JSController.PlayerProperties)???).setProperties(false, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putString("expand_url", paramString1);
    paramString2.putParcelable("player_properties", (Parcelable)???);
    paramString1 = this.v.obtainMessage(1007);
    paramString1.setData(paramString2);
    this.v.sendMessage(paramString1);
  }
  
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, JSController.Dimensions paramDimensions, String paramString2, String paramString3, String paramString4)
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isMutexAquired.get();
      if (bool == true) {}
      try
      {
        this.mutex.wait();
        if ((!this.mIsInterstitialAd) && (this.i != ViewState.EXPANDED))
        {
          raiseError("Cannot play video.Ad is not in an expanded state", "playVideo");
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.debug("[InMobi]-[RE]-4.1.1", "mutex failed ", localInterruptedException);
        }
      }
    }
    if (!isViewable())
    {
      raiseError("Cannot play video.Ad is not viewable yet", "playVideo");
      return;
    }
    if ((!this.mAudioVideoController.videoPlayerList.isEmpty()) && (this.mAudioVideoController.videoPlayerList.size() >= 5) && (!this.mAudioVideoController.videoPlayerList.containsKey(paramString4)))
    {
      raiseError("Player Error. Exceeding permissible limit for saved play instances", "playVideo");
      return;
    }
    ??? = this.v.obtainMessage(1006);
    JSController.PlayerProperties localPlayerProperties = new JSController.PlayerProperties();
    localPlayerProperties.setProperties(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putString("expand_url", paramString1);
    paramString2.putParcelable("player_properties", localPlayerProperties);
    Log.debug("[InMobi]-[RE]-4.1.1", "Before validation dimension: (" + paramDimensions.x + ", " + paramDimensions.y + ", " + paramDimensions.width + ", " + paramDimensions.height + ")");
    this.mAudioVideoController.validateVideoDimensions(paramDimensions);
    Log.debug("[InMobi]-[RE]-4.1.1", "After validation dimension: (" + paramDimensions.x + ", " + paramDimensions.y + ", " + paramDimensions.width + ", " + paramDimensions.height + ")");
    paramString2.putParcelable("expand_dimensions", paramDimensions);
    ((Message)???).setData(paramString2);
    this.v.sendMessage((Message)???);
  }
  
  public void postInHandler(Runnable paramRunnable)
  {
    this.v.post(paramRunnable);
  }
  
  public void postInjectJavaScript(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() < 400) {
        Log.debug("[InMobi]-[RE]-4.1.1", "Injecting JavaScript: " + paramString);
      }
      Message localMessage = this.v.obtainMessage(1025);
      Bundle localBundle = new Bundle();
      localBundle.putString("injectMessage", paramString);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  public void raiseCameraPictureCapturedEvent(String paramString, int paramInt1, int paramInt2)
  {
    injectJavaScript("window.mraidview.fireCameraPictureCatpturedEvent('" + paramString + "'" + "," + "'" + paramInt1 + "','" + paramInt2 + "')");
  }
  
  public void raiseError(String paramString1, String paramString2)
  {
    Message localMessage = this.v.obtainMessage(1008);
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString1);
    localBundle.putString("action", paramString2);
    localMessage.setData(localBundle);
    this.v.sendMessage(localMessage);
  }
  
  public void raiseGalleryImageSelectedEvent(String paramString, int paramInt1, int paramInt2)
  {
    injectJavaScript("window.mraidview.fireGalleryImageSelectedEvent('" + paramString + "'" + "," + "'" + paramInt1 + "','" + paramInt2 + "')");
  }
  
  public void raiseMicEvent(double paramDouble)
  {
    this.a = paramDouble;
    injectJavaScript("window.mraid.broadcastEvent('micIntensityChange'," + paramDouble + ")");
  }
  
  public void raiseVibrateCompleteEvent()
  {
    injectJavaScript("window.mraid.broadcastEvent('vibrateComplete')");
  }
  
  public void requestOnInterstitialClosed(Message paramMessage)
  {
    this.mInterstitialController.mMsgOnInterstitialClosed = paramMessage;
  }
  
  public void requestOnInterstitialShown(Message paramMessage)
  {
    this.mInterstitialController.mMsgOnInterstitialShown = paramMessage;
  }
  
  public void requestOnPageFinishedCallback(Message paramMessage)
  {
    this.r = paramMessage;
  }
  
  public void resetLayout()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (this.q)
    {
      localLayoutParams.height = this.g;
      localLayoutParams.width = this.h;
    }
    setVisibility(0);
    requestLayout();
  }
  
  public void resetMraid()
  {
    this.mExpandController.reset();
    this.mResizeController.reset();
    this.e.reset();
  }
  
  public void resize(JSController.ResizeProperties paramResizeProperties)
  {
    setState(ViewState.RESIZING);
    this.isMutexAquired.set(true);
    Message localMessage = this.v.obtainMessage(1030);
    this.mResizeController.resizeProperties = paramResizeProperties;
    this.v.sendMessage(localMessage);
  }
  
  public void saveOriginalViewParent()
  {
    if (this.y != null) {}
    do
    {
      return;
      this.y = getParent();
    } while (this.y == null);
    int i2 = ((ViewGroup)this.y).getChildCount();
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= i2) || (((ViewGroup)this.y).getChildAt(i1) == this))
      {
        this.z = i1;
        return;
      }
      i1 += 1;
    }
  }
  
  public void seekAudio(String paramString, int paramInt)
  {
    paramString = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "seekAudio");
      return;
    }
    if (paramString.getState() == AVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "seekAudio");
      return;
    }
    Message localMessage = this.v.obtainMessage(1022);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seekaudio", paramInt);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void seekVideo(String paramString, int paramInt)
  {
    paramString = this.mAudioVideoController.getVideoPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "seekVideo");
      return;
    }
    if ((paramString.getState() == AVPlayer.playerState.RELEASED) || (paramString.getState() == AVPlayer.playerState.INIT))
    {
      raiseError("Invalid player state", "seekVideo");
      return;
    }
    Message localMessage = this.v.obtainMessage(1018);
    Bundle localBundle = new Bundle();
    localBundle.putInt("seek", paramInt);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    this.v.sendMessage(localMessage);
  }
  
  public void sendToCPHandler()
  {
    this.v.sendEmptyMessage(1029);
  }
  
  public void sendToDPHandler()
  {
    this.v.sendEmptyMessage(1032);
  }
  
  public void sendasyncPing(String paramString)
  {
    this.e.asyncPing(paramString);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.t = paramActivity;
  }
  
  public void setAudioVolume(String paramString, int paramInt)
  {
    if (this.mAudioVideoController.getCurrentAudioPlayer(paramString) == null)
    {
      raiseError("Invalid property ID", "setAudioVolume");
      return;
    }
    Message localMessage = this.v.obtainMessage(1021);
    Bundle localBundle = new Bundle();
    localBundle.putInt("vol", paramInt);
    localBundle.putString("aplayerref", paramString);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void setBusy(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setCloseButton()
  {
    try
    {
      CustomView localCustomView = (CustomView)((ViewGroup)getRootView()).findViewById(225);
      if (localCustomView != null)
      {
        if (getCustomClose())
        {
          localCustomView.setSwitchInt(CustomView.SwitchIconType.CLOSE_TRANSPARENT);
          localCustomView.invalidate();
          return;
        }
        localCustomView.setSwitchInt(CustomView.SwitchIconType.CLOSE_BUTTON);
        localCustomView.invalidate();
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public void setCustomClose(boolean paramBoolean)
  {
    this.p = paramBoolean;
    Message localMessage = this.v.obtainMessage(1009);
    this.v.sendMessage(localMessage);
  }
  
  public void setExpandPropertiesForInterstitial(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    setCustomClose(paramBoolean1);
    this.mInterstitialController.orientationValueForInterstitial = paramString;
    this.mInterstitialController.lockOrientationValueForInterstitial = paramBoolean2;
    if (this.mWebViewIsBrowserActivity) {
      this.mExpandController.handleOrientationFor2Piece();
    }
    if ((isViewable()) && (this.mIsInterstitialAd)) {
      this.v.sendEmptyMessage(1026);
    }
  }
  
  public void setExternalWebViewClient(WebViewClient paramWebViewClient)
  {
    this.u = paramWebViewClient;
  }
  
  public void setOrientationPropertiesForInterstitial(boolean paramBoolean, String paramString)
  {
    this.mInterstitialController.orientationValueForInterstitial = paramString;
    this.mInterstitialController.lockOrientationValueForInterstitial = paramBoolean;
    if (this.mWebViewIsBrowserActivity) {
      this.mExpandController.handleOrientationFor2Piece();
    }
    if ((isViewable()) && (this.mIsInterstitialAd)) {
      this.v.sendEmptyMessage(1026);
    }
  }
  
  public void setOriginalParent(ViewParent paramViewParent)
  {
    this.y = paramViewParent;
  }
  
  public void setState(ViewState paramViewState)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "State changing from " + this.i + " to " + paramViewState);
    this.i = paramViewState;
    if ((paramViewState != ViewState.EXPANDING) && (paramViewState != ViewState.RESIZING)) {
      injectJavaScript("window.mraid.broadcastEvent('stateChange','" + getState() + "');");
    }
  }
  
  public void setVideoVolume(String paramString, int paramInt)
  {
    paramString = this.mAudioVideoController.getVideoPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "setVideoVolume");
      return;
    }
    if (paramString.getState() == AVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "setVideoVolume");
      return;
    }
    Message localMessage = this.v.obtainMessage(1017);
    Bundle localBundle = new Bundle();
    localBundle.putInt("volume", paramInt);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    this.v.sendMessage(localMessage);
  }
  
  public void show()
  {
    this.v.sendEmptyMessage(1003);
  }
  
  public void showVideo(String paramString)
  {
    Message localMessage = this.v.obtainMessage(1014);
    Bundle localBundle = new Bundle();
    localBundle.putString("pid", paramString);
    localMessage.setData(localBundle);
    this.v.sendMessage(localMessage);
  }
  
  public void unMuteAudio(String paramString)
  {
    Object localObject = this.mAudioVideoController.getCurrentAudioPlayer(paramString);
    if (localObject == null)
    {
      raiseError("Invalid property ID", "unmuteAudio");
      return;
    }
    if (((AVPlayer)localObject).getState() == AVPlayer.playerState.RELEASED)
    {
      raiseError("Invalid player state", "unmuteAudio");
      return;
    }
    localObject = this.v.obtainMessage(1020);
    Bundle localBundle = new Bundle();
    localBundle.putString("aplayerref", paramString);
    ((Message)localObject).setData(localBundle);
    ((Message)localObject).sendToTarget();
  }
  
  public void unMuteVideo(String paramString)
  {
    paramString = this.mAudioVideoController.getVideoPlayer(paramString);
    if (paramString == null)
    {
      raiseError("Invalid property ID", "unMuteVideo");
      return;
    }
    if ((paramString.getState() == AVPlayer.playerState.RELEASED) || (paramString.getState() == AVPlayer.playerState.INIT))
    {
      raiseError("Invalid player state", "unMuteVideo");
      return;
    }
    Message localMessage = this.v.obtainMessage(1016);
    localMessage.obj = paramString;
    this.v.sendMessage(localMessage);
  }
  
  public void userInteraction(HashMap<String, String> paramHashMap)
  {
    Message localMessage = this.v.obtainMessage(1033);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("map", paramHashMap);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public static abstract interface IMWebViewListener
  {
    public abstract void onDismissAdScreen();
    
    public abstract void onError();
    
    public abstract void onExpand();
    
    public abstract void onExpandClose();
    
    public abstract void onLeaveApplication();
    
    public abstract void onResize(ResizeDimensions paramResizeDimensions);
    
    public abstract void onResizeClose();
    
    public abstract void onShowAdScreen();
    
    public abstract void onUserInteraction(Map<String, String> paramMap);
  }
  
  public static enum ViewState
  {
    static
    {
      DEFAULT = new ViewState("DEFAULT", 1);
      RESIZED = new ViewState("RESIZED", 2);
    }
    
    private ViewState() {}
  }
  
  class b
    implements DialogInterface.OnClickListener
  {
    b(SslError paramSslError) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramDialogInterface.cancel();
      IMWebView.a(IMWebView.this, WrapperFunctions.getSSLErrorUrl(paramSslError));
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      if (IMWebView.this.getParent() != null) {
        ((ViewGroup)IMWebView.this.getParent()).removeView(IMWebView.this);
      }
      IMWebView.this.b.set(true);
      IMWebView.n(IMWebView.this);
    }
  }
  
  class d
    implements DialogInterface.OnClickListener
  {
    d(SslErrorHandler paramSslErrorHandler) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramDialogInterface.cancel();
      paramSslErrorHandler.cancel();
    }
  }
  
  class e
    implements DialogInterface.OnClickListener
  {
    e(SslErrorHandler paramSslErrorHandler) {}
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramDialogInterface.cancel();
      paramSslErrorHandler.proceed();
    }
  }
  
  static class f
    extends Handler
  {
    private final WeakReference<IMWebView> a;
    private final WeakReference<MRAIDExpandController> b;
    private final WeakReference<MRAIDResizeController> c;
    private final WeakReference<MRAIDBasic> d;
    private final WeakReference<MRAIDInterstitialController> e;
    private final WeakReference<MRAIDAudioVideoController> f;
    
    public f(IMWebView paramIMWebView, MRAIDBasic paramMRAIDBasic, MRAIDExpandController paramMRAIDExpandController, MRAIDInterstitialController paramMRAIDInterstitialController, MRAIDAudioVideoController paramMRAIDAudioVideoController, MRAIDResizeController paramMRAIDResizeController)
    {
      this.a = new WeakReference(paramIMWebView);
      this.b = new WeakReference(paramMRAIDExpandController);
      this.d = new WeakReference(paramMRAIDBasic);
      this.e = new WeakReference(paramMRAIDInterstitialController);
      this.f = new WeakReference(paramMRAIDAudioVideoController);
      this.c = new WeakReference(paramMRAIDResizeController);
    }
    
    public void handleMessage(Message paramMessage)
    {
      IMWebView localIMWebView;
      Object localObject3;
      MRAIDResizeController localMRAIDResizeController;
      MRAIDInterstitialController localMRAIDInterstitialController;
      Object localObject2;
      for (;;)
      {
        MRAIDExpandController localMRAIDExpandController;
        MRAIDAudioVideoController localMRAIDAudioVideoController;
        try
        {
          localIMWebView = (IMWebView)this.a.get();
          localObject3 = (MRAIDBasic)this.d.get();
          localMRAIDExpandController = (MRAIDExpandController)this.b.get();
          localMRAIDResizeController = (MRAIDResizeController)this.c.get();
          localMRAIDInterstitialController = (MRAIDInterstitialController)this.e.get();
          localMRAIDAudioVideoController = (MRAIDAudioVideoController)this.f.get();
          if (localIMWebView != null)
          {
            Log.debug("[InMobi]-[RE]-4.1.1", "IMWebView->handleMessage: msg: " + paramMessage);
            localObject2 = paramMessage.getData();
          }
          switch (paramMessage.what)
          {
          case 1031: 
            super.handleMessage(paramMessage);
            return;
          }
        }
        catch (Exception paramMessage)
        {
          Log.internal("[InMobi]-[RE]-4.1.1", "Webview Handle Message Exception ", paramMessage);
          return;
        }
        if (localIMWebView.mListener != null)
        {
          localIMWebView.mListener.onResizeClose();
          continue;
          if (localIMWebView.mListener != null)
          {
            localIMWebView.mListener.onExpandClose();
            continue;
            switch (IMWebView.a.a[IMWebView.b(localIMWebView).ordinal()])
            {
            case 5: 
              if (localIMWebView.mIsInterstitialAd) {
                localMRAIDInterstitialController.resetContentsForInterstitials();
              }
              break;
            case 1: 
            case 2: 
              localMRAIDResizeController.closeResized();
              break;
            case 3: 
            case 4: 
              label356:
              localMRAIDExpandController.closeExpanded();
              localMRAIDExpandController.mIsExpandUrlValid = false;
              continue;
              localIMWebView.hide();
              continue;
              localIMWebView.setVisibility(4);
              localIMWebView.setState(IMWebView.ViewState.HIDDEN);
              continue;
              localIMWebView.injectJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
              localIMWebView.setVisibility(0);
              continue;
              if (IMWebView.b(localIMWebView) == IMWebView.ViewState.RESIZING)
              {
                localMRAIDResizeController.doResize((Bundle)localObject2);
                continue;
                if (IMWebView.b(localIMWebView) == IMWebView.ViewState.EXPANDING)
                {
                  localMRAIDExpandController.doExpand((Bundle)localObject2);
                  continue;
                  try
                  {
                    localMRAIDAudioVideoController.playAudioImpl((Bundle)localObject2, IMWebView.h(localIMWebView));
                  }
                  catch (Exception localException1)
                  {
                    Log.debug("[InMobi]-[RE]-4.1.1", "Play audio failed ", localException1);
                  }
                  continue;
                  try
                  {
                    localException1.playVideoImpl((Bundle)localObject2, IMWebView.h(localIMWebView));
                  }
                  catch (Exception localException2)
                  {
                    Log.debug("[InMobi]-[RE]-4.1.1", "Play video failed ", localException2);
                  }
                  continue;
                  localObject1 = (AVPlayer)localException2.audioPlayerList.get(((Bundle)localObject2).getString("aplayerref"));
                  if (localObject1 != null)
                  {
                    ((AVPlayer)localObject1).pause();
                    continue;
                    localObject1 = (AVPlayer)((MRAIDAudioVideoController)localObject1).audioPlayerList.get(((Bundle)localObject2).getString("aplayerref"));
                    if (localObject1 != null)
                    {
                      ((AVPlayer)localObject1).mute();
                      continue;
                      localObject1 = (AVPlayer)((MRAIDAudioVideoController)localObject1).audioPlayerList.get(((Bundle)localObject2).getString("aplayerref"));
                      if (localObject1 != null)
                      {
                        ((AVPlayer)localObject1).unMute();
                        continue;
                        localObject1 = (AVPlayer)((MRAIDAudioVideoController)localObject1).audioPlayerList.get(((Bundle)localObject2).getString("aplayerref"));
                        if (localObject1 != null)
                        {
                          ((AVPlayer)localObject1).setVolume(((Bundle)localObject2).getInt("vol"));
                          continue;
                          ((AVPlayer)paramMessage.obj).seekPlayer(((Bundle)localObject2).getInt("seekaudio") * 1000);
                        }
                      }
                    }
                  }
                }
              }
              break;
            }
          }
        }
      }
      Object localObject1 = ((MRAIDAudioVideoController)localObject1).getVideoPlayer(((Bundle)localObject2).getString("pid"));
      if (localObject1 == null) {}
      for (localObject1 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"pauseVideo\")";; localObject1 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"pauseVideo\")")
      {
        localIMWebView.injectJavaScript((String)localObject1);
        break;
        if (((AVPlayer)localObject1).getState() != AVPlayer.playerState.PLAYING)
        {
          if (((AVPlayer)localObject1).getState() != AVPlayer.playerState.INIT) {
            continue;
          }
          if (((AVPlayer)localObject1).isPrepared()) {
            break;
          }
          ((AVPlayer)localObject1).setAutoPlay(false);
          break;
        }
        ((AVPlayer)localObject1).pause();
        return;
        ((AVPlayer)paramMessage.obj).releasePlayer(false);
        break;
        localObject2 = ((Bundle)localObject2).getString("pid");
        localObject3 = ((MRAIDAudioVideoController)localObject1).getVideoPlayer((String)localObject2);
        if (localObject3 == null) {}
        for (localObject1 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"hideVideo\")";; localObject1 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"hideVideo\")")
        {
          localIMWebView.injectJavaScript((String)localObject1);
          break;
          if (((AVPlayer)localObject3).getState() != AVPlayer.playerState.RELEASED) {
            break label799;
          }
        }
        label799:
        ((MRAIDAudioVideoController)localObject1).videoPlayerList.put(localObject2, localObject3);
        ((AVPlayer)localObject3).hide();
        return;
        localObject2 = ((Bundle)localObject2).getString("pid");
        localObject3 = ((MRAIDAudioVideoController)localObject1).getVideoPlayer((String)localObject2);
        if (localObject3 == null) {
          localObject1 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"showVideo\")";
        }
        for (;;)
        {
          localIMWebView.injectJavaScript((String)localObject1);
          break;
          if ((((AVPlayer)localObject3).getState() != AVPlayer.playerState.RELEASED) && (((AVPlayer)localObject3).getState() != AVPlayer.playerState.HIDDEN))
          {
            localObject1 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"showVideo\")";
          }
          else
          {
            if ((((MRAIDAudioVideoController)localObject1).videoPlayer == null) || (((MRAIDAudioVideoController)localObject1).videoPlayer.getPropertyID().equalsIgnoreCase((String)localObject2))) {
              break label909;
            }
            localObject1 = "window.mraid.broadcastEvent('error',\"Show failed. There is already a video playing\", \"showVideo\")";
          }
        }
        label909:
        ((MRAIDAudioVideoController)localObject1).videoPlayerList.remove(localObject2);
        ((MRAIDAudioVideoController)localObject1).videoPlayer = ((AVPlayer)localObject3);
        ((AVPlayer)localObject3).show();
        return;
        ((AVPlayer)paramMessage.obj).mute();
        break;
        ((AVPlayer)paramMessage.obj).unMute();
        break;
        ((AVPlayer)paramMessage.obj).seekPlayer(((Bundle)localObject2).getInt("seek") * 1000);
        break;
        ((AVPlayer)paramMessage.obj).setVolume(((Bundle)localObject2).getInt("volume"));
        break;
        localObject1 = ((Bundle)localObject2).getString("message");
        localObject2 = ((Bundle)localObject2).getString("action");
        localIMWebView.injectJavaScript("window.mraid.broadcastEvent('error',\"" + (String)localObject1 + "\", \"" + (String)localObject2 + "\")");
        break;
        localIMWebView.setCloseButton();
        break;
        ((MRAIDAudioVideoController)localObject1).hidePlayers();
        break;
        ((MRAIDBasic)localObject3).open(((Bundle)localObject2).getString("expand_url"));
        break;
        localObject1 = ((Bundle)localObject2).getString("injectMessage");
        if (localObject1 == null) {
          break;
        }
        localIMWebView.loadUrl("javascript:" + (String)localObject1);
        break;
        localMRAIDInterstitialController.handleOrientationForInterstitial();
        break;
        if (localIMWebView.mIsInterstitialAd) {
          break;
        }
        localMRAIDResizeController.onOrientationChange();
        break;
        if (localIMWebView.mListener == null) {
          break;
        }
        localIMWebView.mListener.onDismissAdScreen();
        break;
        ((MRAIDBasic)localObject3).getCurrentPosition();
        break;
        ((MRAIDBasic)localObject3).getDefaultPosition();
        break;
        localObject1 = (HashMap)paramMessage.getData().getSerializable("map");
        if (localIMWebView.mListener == null) {
          break;
        }
        localIMWebView.mListener.onUserInteraction((Map)localObject1);
        break;
        break;
        break label356;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/container/IMWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */