package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;

public class AdView
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final String ACTION_KEY = "action";
  public static final String DIMENSIONS = "expand_dimensions";
  public static final String EXPAND_URL = "expand_url";
  public static final int ORMMA_ID = 102;
  public static final String PLAYER_PROPERTIES = "player_properties";
  private static Context b;
  private static int[] e = { 16843039, 16843040 };
  private static String f;
  private static AdPlayer t;
  private boolean A;
  final WebView a = this;
  private AdController c;
  private AdListener d;
  private boolean g;
  private AdUtilityController h;
  private float i;
  private int j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private GestureDetector q;
  private AdView.ViewState r = AdView.ViewState.DEFAULT;
  private AdView.AdViewListener s;
  private String u;
  private final HashSet v = new HashSet();
  private String w;
  private Handler x = new O(this);
  private WebViewClient y = new R(this);
  private WebChromeClient z = new W(this, b);
  
  public AdView(Context paramContext)
  {
    super(paramContext);
    b = paramContext;
    f();
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, e);
    int i1 = paramContext.getDimensionPixelSize(0, -1);
    int i2 = paramContext.getDimensionPixelSize(1, -1);
    if ((i1 > 0) && (i2 > 0)) {
      this.h.setMaxSize(i1, i2);
    }
    paramContext.recycle();
  }
  
  public AdView(Context paramContext, AdController paramAdController, AdListener paramAdListener)
  {
    super(paramContext);
    b = paramContext;
    this.c = paramAdController;
    this.d = paramAdListener;
    f();
  }
  
  public AdView(Context paramContext, AdView.AdViewListener paramAdViewListener)
  {
    super(paramContext);
    b = paramContext;
    setListener(paramAdViewListener);
    f();
  }
  
  public AdView(Context paramContext, String paramString)
  {
    super(paramContext);
    b = paramContext;
    this.w = paramString;
    f();
  }
  
  public AdView(Context paramContext, String paramString, AdView.AdViewListener paramAdViewListener)
  {
    super(paramContext);
    b = paramContext;
    this.w = paramString;
    setListener(paramAdViewListener);
    f();
  }
  
  private void a(InputStream paramInputStream, String paramString)
  {
    AdLog.d("LBAdView", "loadInputStream, data =" + paramString);
    d();
    new Y(this, paramInputStream, paramString).execute(new Void[0]);
  }
  
  private void d()
  {
    if (this.r == AdView.ViewState.EXPANDED) {
      a();
    }
    for (;;)
    {
      invalidate();
      this.h.deleteOldAds();
      this.h.stopAllListeners();
      i();
      return;
      if (this.r == AdView.ViewState.RESIZED) {
        e();
      }
    }
  }
  
  private void e()
  {
    if (this.s != null) {
      this.s.onResizeClose();
    }
    String str = "window.ormmaview.fireChangeEvent({ state: 'default', size: { width: " + this.m + ", height: " + this.l + "}});";
    AdLog.d("LBAdView", "closeResized: injection: " + str);
    injectJavaScript(str);
    i();
  }
  
  private void f()
  {
    AdLog.d("LBAdView", "Going to initialize mView");
    setScrollContainer(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.q = new GestureDetector(new Z(this));
    setBackgroundColor(0);
    Object localObject = new DisplayMetrics();
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.i = ((DisplayMetrics)localObject).density;
    this.g = false;
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setDomStorageEnabled(true);
    if (Build.VERSION.SDK_INT >= 8) {
      getSettings().setPluginState(WebSettings.PluginState.ON);
    }
    setWebViewClient(this.y);
    setWebChromeClient(this.z);
    this.h = new AdUtilityController(this, getContext());
    localObject = new AdAssetController(this, getContext());
    AdDisplayController localAdDisplayController = new AdDisplayController(this, getContext());
    AdLocationController localAdLocationController = new AdLocationController(this, getContext());
    AdNetworkController localAdNetworkController = new AdNetworkController(this, getContext());
    AdSensorController localAdSensorController = new AdSensorController(this, getContext());
    addJavascriptInterface(this.h, "ORMMAUtilityControllerBridge");
    addJavascriptInterface(localObject, "ORMMAAssetsControllerBridge");
    addJavascriptInterface(localAdDisplayController, "ORMMADisplayControllerBridge");
    addJavascriptInterface(localAdLocationController, "ORMMALocationControllerBridge");
    addJavascriptInterface(localAdNetworkController, "ORMMANetworkControllerBridge");
    addJavascriptInterface(localAdSensorController, "ORMMASensorControllerBridge");
    addJavascriptInterface(new AdJSInterface((Activity)b, this.c, this.d), "LBOUT");
    h();
    this.j = g();
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    AdLog.d("LBAdView", "mView Initialize complete");
  }
  
  private int g()
  {
    View localView = getRootView().findViewById(16908290);
    if (localView != null) {
      return localView.getHeight();
    }
    return -1;
  }
  
  private void h()
  {
    try
    {
      if (f == null)
      {
        f = this.h.copyTextFromJarIntoAssetDir("/js/ormma.js", "js/ormma.js");
        AdLog.d("LBAdView", "mScriptPath = " + f);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void i()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (this.A)
    {
      localLayoutParams.height = this.n;
      localLayoutParams.width = this.o;
    }
    setVisibility(0);
    requestLayout();
  }
  
  private AdPlayer j()
  {
    if (t != null) {
      t.releasePlayer();
    }
    AdPlayer localAdPlayer = new AdPlayer(getContext());
    t = localAdPlayer;
    return localAdPlayer;
  }
  
  protected final void a()
  {
    try
    {
      resetContents();
      String str = "window.ormmaview.fireChangeEvent({ state: 'default', size: { width: " + this.m + ", height: " + this.l + "}});";
      Log.d("LBAdView", "closeExpanded: injection: " + str);
      injectJavaScript(str);
      this.r = AdView.ViewState.DEFAULT;
      this.x.sendEmptyMessage(1005);
      setVisibility(0);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void addJavascriptObject(Object paramObject, String paramString)
  {
    addJavascriptInterface(paramObject, paramString);
  }
  
  public void clearView()
  {
    d();
    super.clearView();
  }
  
  public void close()
  {
    ((Activity)b).runOnUiThread(new S(this));
  }
  
  public void deregisterProtocol(String paramString)
  {
    if (paramString != null) {
      this.v.remove(paramString.toLowerCase());
    }
  }
  
  public void dump() {}
  
  public void expand(AdController.Dimensions paramDimensions, String paramString, AdController.Properties paramProperties)
  {
    Message localMessage = this.x.obtainMessage(1004);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("expand_dimensions", paramDimensions);
    localBundle.putString("expand_url", paramString);
    localBundle.putParcelable("expand_properties", paramProperties);
    localMessage.setData(localBundle);
    this.x.sendMessage(localMessage);
  }
  
  public ConnectivityManager getConnectivityManager()
  {
    return (ConnectivityManager)getContext().getSystemService("connectivity");
  }
  
  public String getSize()
  {
    return "{ width: " + (int)(getWidth() / this.i) + ", height: " + (int)(getHeight() / this.i) + "}";
  }
  
  public String getState()
  {
    return this.r.toString().toLowerCase();
  }
  
  public void hide()
  {
    try
    {
      Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this, null);
      this.x.sendEmptyMessage(1002);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void injectJavaScript(String paramString)
  {
    if (paramString != null) {
      ((Activity)b).runOnUiThread(new N(this, paramString));
    }
  }
  
  public boolean isExpanded()
  {
    return this.r == AdView.ViewState.EXPANDED;
  }
  
  public boolean isPageFinished()
  {
    return false;
  }
  
  public void loadFile(File paramFile, String paramString)
  {
    try
    {
      a(new FileInputStream(paramFile), paramString);
      return;
    }
    catch (Exception paramFile)
    {
      AdLog.e("LBAdView", "erro with loadFile - " + paramFile.getMessage());
      AdLog.printStackTrace("LBAdView", paramFile);
    }
  }
  
  public void loadHTMLWrap(String paramString)
  {
    this.u = this.h.writeHTMLToDiskWrap(paramString, "_ormma_current", true, null, null, f);
    paramString = "file://" + this.u + File.separator + "_ormma_current";
    ((Activity)b).runOnUiThread(new Q(this, paramString));
  }
  
  public void loadUrl(String paramString)
  {
    loadUrl(paramString, false, null);
  }
  
  public void loadUrl(String paramString1, String paramString2)
  {
    loadUrl(paramString1, false, paramString2);
  }
  
  public void loadUrl(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (URLUtil.isValidUrl(paramString1)) {
      if (!paramBoolean) {
        this.g = false;
      }
    }
    try
    {
      new X(this, paramString1, paramString2).execute(new Void[0]);
      super.loadUrl(paramString1);
      return;
    }
    catch (Exception paramString2)
    {
      for (;;) {}
    }
  }
  
  protected void onAttachedToWindow()
  {
    if (!this.A)
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.n = localLayoutParams.height;
      this.o = localLayoutParams.width;
      this.A = true;
    }
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    this.h.stopAllListeners();
    super.onDetachedFromWindow();
  }
  
  public void onGlobalLayout()
  {
    AdLog.d("LBAdView", "onGlobalLayout called");
    boolean bool2 = this.k;
    boolean bool1 = bool2;
    if (!this.k)
    {
      bool1 = bool2;
      if (this.j >= 0)
      {
        bool1 = bool2;
        if (g() >= 0)
        {
          bool1 = bool2;
          if (this.j != g())
          {
            bool1 = true;
            injectJavaScript("window.ormmaview.fireChangeEvent({ keyboardState: true});");
          }
        }
      }
    }
    bool2 = bool1;
    if (this.k)
    {
      bool2 = bool1;
      if (this.j >= 0)
      {
        bool2 = bool1;
        if (g() >= 0)
        {
          bool2 = bool1;
          if (this.j == g())
          {
            bool2 = false;
            injectJavaScript("window.ormmaview.fireChangeEvent({ keyboardState: false});");
          }
        }
      }
    }
    if (this.j < 0) {
      this.j = g();
    }
    this.k = bool2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.q.onTouchEvent(paramMotionEvent)) {
      paramMotionEvent.setAction(3);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void open(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent(getContext(), AdBrowser.class);
    AdLog.d("LBAdView", "open:" + paramString);
    localIntent.putExtra("extra_url", paramString);
    localIntent.putExtra("open_show_back", paramBoolean1);
    localIntent.putExtra("open_show_forward", paramBoolean2);
    localIntent.putExtra("open_show_refresh", paramBoolean3);
    localIntent.addFlags(268435456);
    getContext().startActivity(localIntent);
  }
  
  public void openMap(String paramString, boolean paramBoolean)
  {
    AdLog.d("LBAdView", "Opening Map Url " + paramString);
    paramString = AdUtils.convert(paramString.trim());
    if (paramBoolean) {}
    while (this.w != null) {
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.setFlags(268435456);
        getContext().startActivity(paramString);
        return;
      }
      catch (ActivityNotFoundException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    Toast.makeText(getContext(), "Error: no Google Maps API Key provided for embedded map", 1).show();
  }
  
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3)
  {
    AdController.PlayerProperties localPlayerProperties = new AdController.PlayerProperties();
    localPlayerProperties.setProperties(false, paramBoolean1, paramBoolean2, paramBoolean4, paramBoolean3, paramString2, paramString3);
    paramString2 = new Bundle();
    paramString2.putString("action", AdView.ACTION.PLAY_AUDIO.toString());
    paramString2.putString("expand_url", paramString1);
    paramString2.putParcelable("player_properties", localPlayerProperties);
    if (localPlayerProperties.isFullScreen()) {
      try
      {
        paramString1 = new Intent(getContext(), AdActionHandler.class);
        paramString1.putExtras(paramString2);
        getContext().startActivity(paramString1);
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    paramString1 = this.x.obtainMessage(1008);
    paramString1.setData(paramString2);
    this.x.sendMessage(paramString1);
  }
  
  public void playAudioImpl(Bundle paramBundle)
  {
    AdController.PlayerProperties localPlayerProperties = (AdController.PlayerProperties)paramBundle.getParcelable("player_properties");
    paramBundle = paramBundle.getString("expand_url");
    AdPlayer localAdPlayer = j();
    localAdPlayer.setPlayData(localPlayerProperties, paramBundle);
    localAdPlayer.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
    ((ViewGroup)getParent()).addView(localAdPlayer);
    localAdPlayer.playAudio();
  }
  
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, AdController.Dimensions paramDimensions, String paramString2, String paramString3)
  {
    AdLog.i("LBAdView", "playVideo, Video URL - " + paramString1);
    Message localMessage = this.x.obtainMessage(1007);
    AdController.PlayerProperties localPlayerProperties = new AdController.PlayerProperties();
    localPlayerProperties.setProperties(paramBoolean1, paramBoolean2, paramBoolean3, false, paramBoolean4, paramString2, paramString3);
    paramString2 = new Bundle();
    paramString2.putString("expand_url", paramString1);
    paramString2.putString("action", AdView.ACTION.PLAY_VIDEO.toString());
    paramString2.putParcelable("player_properties", localPlayerProperties);
    if (paramDimensions != null) {
      paramString2.putParcelable("expand_dimensions", paramDimensions);
    }
    if (localPlayerProperties.isFullScreen()) {}
    while (paramDimensions == null) {
      try
      {
        paramString1 = new Intent(getContext(), AdActionHandler.class);
        paramString1.putExtras(paramString2);
        getContext().startActivity(paramString1);
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    localMessage.setData(paramString2);
    this.x.sendMessage(localMessage);
  }
  
  public void playVideoImpl(Bundle paramBundle)
  {
    Object localObject = (AdController.PlayerProperties)paramBundle.getParcelable("player_properties");
    AdController.Dimensions localDimensions = (AdController.Dimensions)paramBundle.getParcelable("expand_dimensions");
    String str = paramBundle.getString("expand_url");
    paramBundle = j();
    paramBundle.setPlayData((AdController.PlayerProperties)localObject, str);
    AdLog.i("LBAdView", "Video URL - " + str);
    localObject = new FrameLayout.LayoutParams(localDimensions.width, localDimensions.height);
    ((FrameLayout.LayoutParams)localObject).topMargin = localDimensions.x;
    ((FrameLayout.LayoutParams)localObject).leftMargin = localDimensions.y;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setOnTouchListener(new T(this));
    ((FrameLayout)localObject).setId(101);
    ((FrameLayout)localObject).setPadding(localDimensions.x, localDimensions.y, 0, 0);
    ((FrameLayout)getRootView().findViewById(16908290)).addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject).addView(paramBundle);
    setVisibility(4);
    paramBundle.setListener(new U(this));
    paramBundle.playVideo();
  }
  
  public void raiseError(String paramString1, String paramString2)
  {
    Message localMessage = this.x.obtainMessage(1009);
    Bundle localBundle = new Bundle();
    localBundle.putString("message", paramString1);
    localBundle.putString("action", paramString2);
    localMessage.setData(localBundle);
    this.x.sendMessage(localMessage);
  }
  
  public void registerProtocol(String paramString)
  {
    if (paramString != null) {
      this.v.add(paramString.toLowerCase());
    }
  }
  
  public void removeListener()
  {
    this.s = null;
  }
  
  public void resetContents()
  {
    FrameLayout localFrameLayout1 = (FrameLayout)getRootView().findViewById(16908290);
    FrameLayout localFrameLayout2 = (FrameLayout)getRootView().findViewById(100);
    FrameLayout localFrameLayout3 = (FrameLayout)getRootView().findViewById(101);
    ViewGroup localViewGroup = (ViewGroup)localFrameLayout2.getParent();
    localFrameLayout3.removeView(this);
    localFrameLayout1.removeView(localFrameLayout3);
    i();
    try
    {
      localViewGroup.addView(this, this.p);
      localViewGroup.removeView(localFrameLayout2);
      localViewGroup.invalidate();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    Message localMessage = this.x.obtainMessage(1000);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resize_width", paramInt1);
    localBundle.putInt("resize_height", paramInt2);
    localMessage.setData(localBundle);
    this.x.sendMessage(localMessage);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    this.u = paramBundle.getString("AD_PATH");
    super.loadUrl("file://" + this.u + File.separator + "_ormma_current");
    return null;
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    paramBundle.putString("AD_PATH", this.u);
    return null;
  }
  
  public void setListener(AdView.AdViewListener paramAdViewListener)
  {
    this.s = paramAdViewListener;
  }
  
  public void setMapAPIKey(String paramString)
  {
    this.w = paramString;
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    this.h.setMaxSize(paramInt1, paramInt2);
  }
  
  public void show()
  {
    this.x.sendEmptyMessage(1003);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */