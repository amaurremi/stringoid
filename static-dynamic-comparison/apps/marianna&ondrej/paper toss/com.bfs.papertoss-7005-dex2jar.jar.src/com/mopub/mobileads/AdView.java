package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public class AdView
  extends WebView
{
  public static final String AD_ORIENTATION_BOTH = "b";
  public static final String AD_ORIENTATION_LANDSCAPE_ONLY = "l";
  public static final String AD_ORIENTATION_PORTRAIT_ONLY = "p";
  public static final String DEVICE_ORIENTATION_LANDSCAPE = "l";
  public static final String DEVICE_ORIENTATION_PORTRAIT = "p";
  public static final String DEVICE_ORIENTATION_SQUARE = "s";
  public static final String DEVICE_ORIENTATION_UNKNOWN = "u";
  public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";
  private static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
  private AdFetcher mAdFetcher;
  private String mAdOrientation;
  private String mAdUnitId;
  private boolean mAutorefreshEnabled;
  private String mClickthroughUrl;
  private String mFailUrl;
  private final Handler mHandler = new Handler();
  private int mHeight;
  private String mImpressionUrl;
  private boolean mIsDestroyed;
  private boolean mIsLoading;
  private String mKeywords;
  private Location mLocation;
  protected MoPubView mMoPubView;
  private String mRedirectUrl;
  private Handler mRefreshHandler = new Handler();
  private Runnable mRefreshRunnable = new Runnable()
  {
    public void run()
    {
      AdView.this.loadAd();
    }
  };
  private int mRefreshTimeMilliseconds = 60000;
  private String mResponseString;
  private boolean mTesting;
  private String mUrl;
  private String mUserAgent;
  private int mWidth;
  
  public AdView(Context paramContext, MoPubView paramMoPubView)
  {
    super(paramContext.getApplicationContext());
    this.mMoPubView = paramMoPubView;
    this.mAutorefreshEnabled = true;
    this.mUserAgent = getSettings().getUserAgentString();
    this.mAdFetcher = new AdFetcher(this, this.mUserAgent);
    disableScrollingAndZoom();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    setBackgroundColor(0);
    setWebViewClient(new AdWebViewClient(null));
    addMoPubUriJavascriptInterface();
  }
  
  private void adDidClose()
  {
    this.mMoPubView.adClosed();
  }
  
  private void adDidFail()
  {
    Log.i("MoPub", "Ad failed to load.");
    this.mIsLoading = false;
    scheduleRefreshTimerIfEnabled();
    this.mMoPubView.adFailed();
  }
  
  private void adDidLoad()
  {
    Log.i("MoPub", "Ad successfully loaded.");
    this.mIsLoading = false;
    scheduleRefreshTimerIfEnabled();
    setAdContentView(this);
    this.mMoPubView.adLoaded();
  }
  
  private String addKeyword(String paramString1, String paramString2)
  {
    String str;
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      str = paramString1;
    }
    do
    {
      do
      {
        return str;
        str = paramString2;
      } while (paramString1 == null);
      str = paramString2;
    } while (paramString1.length() == 0);
    return paramString1 + "," + paramString2;
  }
  
  private void addMoPubUriJavascriptInterface()
  {
    addJavascriptInterface(new Object()
    {
      public boolean fireFinishLoad()
      {
        AdView.this.postHandlerRunnable(new Runnable()
        {
          public void run()
          {
            AdView.this.adDidLoad();
          }
        });
        return true;
      }
    }, "mopubUriInterface");
  }
  
  private void disableScrollingAndZoom()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    getSettings().setSupportZoom(false);
  }
  
  private String generateAdUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder("http://" + getServerHostname() + "/m/ad");
    localStringBuilder.append("?v=6&id=" + this.mAdUnitId);
    localStringBuilder.append("&nv=1.9.0.5");
    Object localObject = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localStringBuilder.append("&udid=sha:" + (String)localObject);
      localObject = addKeyword(this.mKeywords, getFacebookKeyword());
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        localStringBuilder.append("&q=" + Uri.encode((String)localObject));
      }
      if (this.mLocation != null) {
        localStringBuilder.append("&ll=" + this.mLocation.getLatitude() + "," + this.mLocation.getLongitude());
      }
      localStringBuilder.append("&z=" + getTimeZoneOffsetString());
      int i = getResources().getConfiguration().orientation;
      localObject = "u";
      if (i == 1)
      {
        localObject = "p";
        label275:
        localStringBuilder.append("&o=" + (String)localObject);
        localObject = new DisplayMetrics();
        ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        localStringBuilder.append("&sc_a=" + ((DisplayMetrics)localObject).density);
        i = 1;
      }
      try
      {
        Class.forName("com.mopub.mraid.MraidView", false, ClassLoader.getSystemClassLoader());
        if (i != 0) {
          localStringBuilder.append("&mr=1");
        }
        return localStringBuilder.toString();
        localObject = Utils.sha1((String)localObject);
        continue;
        if (i == 2)
        {
          localObject = "l";
          break label275;
        }
        if (i != 3) {
          break label275;
        }
        localObject = "s";
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
  }
  
  private String getFacebookKeyword()
  {
    try
    {
      Object localObject = Class.forName("com.mopub.mobileads.FacebookKeywordProvider");
      localObject = (String)((Class)localObject).getMethod("getKeyword", new Class[] { Context.class }).invoke(localObject, new Object[] { getContext() });
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private Location getLastKnownLocation()
  {
    MoPubView.LocationAwareness localLocationAwareness = this.mMoPubView.getLocationAwareness();
    int i = this.mMoPubView.getLocationPrecision();
    if (localLocationAwareness == MoPubView.LocationAwareness.LOCATION_AWARENESS_DISABLED) {
      return null;
    }
    Object localObject3 = (LocationManager)getContext().getSystemService("location");
    Object localObject1 = null;
    try
    {
      localObject2 = ((LocationManager)localObject3).getLastKnownLocation("gps");
      localObject1 = localObject2;
    }
    catch (SecurityException localSecurityException1)
    {
      for (;;)
      {
        Object localObject2;
        Log.d("MoPub", "Failed to retrieve GPS location: access appears to be disabled.");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      for (;;)
      {
        Log.d("MoPub", "Failed to retrieve GPS location: device has no GPS provider.");
      }
    }
    localObject2 = null;
    try
    {
      localObject3 = ((LocationManager)localObject3).getLastKnownLocation("network");
      localObject2 = localObject3;
    }
    catch (SecurityException localSecurityException2)
    {
      for (;;)
      {
        Log.d("MoPub", "Failed to retrieve network location: access appears to be disabled.");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      for (;;)
      {
        Log.d("MoPub", "Failed to retrieve network location: device has no network provider.");
      }
      if (localObject1 == null) {
        break label207;
      }
    }
    if ((localObject1 == null) && (localObject2 == null)) {
      return null;
    }
    if (localIllegalArgumentException1 != null) {
      if (((Location)localObject1).getTime() <= localIllegalArgumentException1.getTime()) {}
    }
    for (;;)
    {
      if (localLocationAwareness == MoPubView.LocationAwareness.LOCATION_AWARENESS_TRUNCATED)
      {
        ((Location)localObject1).setLatitude(BigDecimal.valueOf(((Location)localObject1).getLatitude()).setScale(i, 5).doubleValue());
        ((Location)localObject1).setLongitude(BigDecimal.valueOf(((Location)localObject1).getLongitude()).setScale(i, 5).doubleValue());
      }
      return (Location)localObject1;
      localObject1 = localIllegalArgumentException1;
      continue;
      label207:
      if (localObject1 == null) {
        localObject1 = localIllegalArgumentException1;
      }
    }
  }
  
  private String getTimeZoneOffsetString()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("Z");
    localSimpleDateFormat.setTimeZone(TimeZone.getDefault());
    return localSimpleDateFormat.format(new Date());
  }
  
  private void handleCustomIntentFromUri(Uri paramUri)
  {
    registerClick();
    String str = paramUri.getQueryParameter("fnc");
    paramUri = paramUri.getQueryParameter("data");
    Intent localIntent = new Intent(str);
    localIntent.addFlags(268435456);
    if (paramUri != null) {
      localIntent.putExtra("com.mopub.intent.extra.AD_CLICK_DATA", paramUri);
    }
    try
    {
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramUri)
    {
      Log.w("MoPub", "Could not handle custom intent: " + str + ". Is your intent spelled correctly?");
    }
  }
  
  private boolean isNetworkAvailable()
  {
    if (getContext().checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return true;
      localNetworkInfo = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
    return false;
  }
  
  private void postHandlerRunnable(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  private void setWebViewScrollingEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnTouchListener(null);
      return;
    }
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return paramAnonymousMotionEvent.getAction() == 2;
      }
    });
  }
  
  private void showBrowserForUrl(String paramString)
  {
    if (isDestroyed()) {
      return;
    }
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = "about:blank";
    }
    Log.d("MoPub", "Final URI to show in browser: " + str);
    Context localContext = getContext();
    paramString = new Intent(localContext, MraidBrowser.class);
    paramString.putExtra("extra_url", str);
    paramString.addFlags(268435456);
    try
    {
      localContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      paramString = paramString.getAction();
      Log.w("MoPub", "Could not handle intent action: " + paramString + ". Perhaps you forgot to declare com.mopub.mobileads.MraidBrowser" + " in your Android manifest file.");
      getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("about:blank")).addFlags(268435456));
    }
  }
  
  protected void adAppeared()
  {
    loadUrl("javascript:webviewDidAppear();");
  }
  
  protected void cancelRefreshTimer()
  {
    this.mRefreshHandler.removeCallbacks(this.mRefreshRunnable);
  }
  
  protected void cleanup()
  {
    if (this.mIsDestroyed) {
      return;
    }
    setAutorefreshEnabled(false);
    cancelRefreshTimer();
    destroy();
    this.mAdFetcher.cleanup();
    this.mAdFetcher = null;
    this.mResponseString = null;
    this.mMoPubView.removeView(this);
    this.mMoPubView = null;
    this.mIsDestroyed = true;
  }
  
  protected void configureAdViewUsingHeadersFromHttpResponse(HttpResponse paramHttpResponse)
  {
    Header localHeader1 = paramHttpResponse.getFirstHeader("X-Networktype");
    if (localHeader1 != null) {
      Log.i("MoPub", "Fetching ad network type: " + localHeader1.getValue());
    }
    localHeader1 = paramHttpResponse.getFirstHeader("X-Launchpage");
    if (localHeader1 != null)
    {
      this.mRedirectUrl = localHeader1.getValue();
      localHeader1 = paramHttpResponse.getFirstHeader("X-Clickthrough");
      if (localHeader1 == null) {
        break label324;
      }
      this.mClickthroughUrl = localHeader1.getValue();
      label93:
      localHeader1 = paramHttpResponse.getFirstHeader("X-Failurl");
      if (localHeader1 == null) {
        break label332;
      }
      this.mFailUrl = localHeader1.getValue();
      label117:
      localHeader1 = paramHttpResponse.getFirstHeader("X-Imptracker");
      if (localHeader1 == null) {
        break label340;
      }
      this.mImpressionUrl = localHeader1.getValue();
      label141:
      localHeader1 = paramHttpResponse.getFirstHeader("X-Scrollable");
      boolean bool = false;
      if (localHeader1 != null) {
        bool = localHeader1.getValue().equals("1");
      }
      setWebViewScrollingEnabled(bool);
      localHeader1 = paramHttpResponse.getFirstHeader("X-Width");
      Header localHeader2 = paramHttpResponse.getFirstHeader("X-Height");
      if ((localHeader1 == null) || (localHeader2 == null)) {
        break label348;
      }
      this.mWidth = Integer.parseInt(localHeader1.getValue().trim());
      this.mHeight = Integer.parseInt(localHeader2.getValue().trim());
      label238:
      localHeader1 = paramHttpResponse.getFirstHeader("X-Refreshtime");
      if (localHeader1 == null) {
        break label361;
      }
      this.mRefreshTimeMilliseconds = (Integer.valueOf(localHeader1.getValue()).intValue() * 1000);
      if (this.mRefreshTimeMilliseconds < 10000) {
        this.mRefreshTimeMilliseconds = 10000;
      }
      label289:
      paramHttpResponse = paramHttpResponse.getFirstHeader("X-Orientation");
      if (paramHttpResponse == null) {
        break label369;
      }
    }
    label324:
    label332:
    label340:
    label348:
    label361:
    label369:
    for (paramHttpResponse = paramHttpResponse.getValue();; paramHttpResponse = null)
    {
      this.mAdOrientation = paramHttpResponse;
      return;
      this.mRedirectUrl = null;
      break;
      this.mClickthroughUrl = null;
      break label93;
      this.mFailUrl = null;
      break label117;
      this.mImpressionUrl = null;
      break label141;
      this.mWidth = 0;
      this.mHeight = 0;
      break label238;
      this.mRefreshTimeMilliseconds = 0;
      break label289;
    }
  }
  
  public void customEventActionWillBegin()
  {
    registerClick();
  }
  
  public void customEventDidFailToLoadAd()
  {
    loadFailUrl();
  }
  
  public void customEventDidLoadAd()
  {
    this.mIsLoading = false;
    trackImpression();
    scheduleRefreshTimerIfEnabled();
  }
  
  public int getAdHeight()
  {
    return this.mHeight;
  }
  
  public String getAdOrientation()
  {
    return this.mAdOrientation;
  }
  
  public String getAdUnitId()
  {
    return this.mAdUnitId;
  }
  
  public int getAdWidth()
  {
    return this.mWidth;
  }
  
  public boolean getAutorefreshEnabled()
  {
    return this.mAutorefreshEnabled;
  }
  
  public String getClickthroughUrl()
  {
    return this.mClickthroughUrl;
  }
  
  public String getKeywords()
  {
    return this.mKeywords;
  }
  
  public Location getLocation()
  {
    return this.mLocation;
  }
  
  public String getRedirectUrl()
  {
    return this.mRedirectUrl;
  }
  
  protected int getRefreshTimeMilliseconds()
  {
    return this.mRefreshTimeMilliseconds;
  }
  
  public String getResponseString()
  {
    return this.mResponseString;
  }
  
  protected String getServerHostname()
  {
    if (this.mTesting) {
      return "testing.ads.mopub.com";
    }
    return "ads.mopub.com";
  }
  
  public boolean getTesting()
  {
    return this.mTesting;
  }
  
  protected boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public void loadAd()
  {
    if (this.mAdUnitId == null)
    {
      Log.d("MoPub", "Can't load an ad in this ad view because the ad unit ID is null. Did you forget to call setAdUnitId()?");
      return;
    }
    if (!isNetworkAvailable())
    {
      Log.d("MoPub", "Can't load an ad because there is no network connectivity.");
      scheduleRefreshTimerIfEnabled();
      return;
    }
    if (this.mLocation == null) {
      this.mLocation = getLastKnownLocation();
    }
    String str = generateAdUrl();
    this.mMoPubView.adWillLoad(str);
    loadUrl(str);
  }
  
  public void loadFailUrl()
  {
    this.mIsLoading = false;
    if (this.mFailUrl != null)
    {
      Log.d("MoPub", "Loading failover url: " + this.mFailUrl);
      loadUrl(this.mFailUrl);
      return;
    }
    adDidFail();
  }
  
  protected void loadResponseString(String paramString)
  {
    loadDataWithBaseURL("http://" + getServerHostname() + "/", paramString, "text/html", "utf-8", null);
  }
  
  public void loadUrl(String paramString)
  {
    if (paramString.startsWith("javascript:")) {
      super.loadUrl(paramString);
    }
    do
    {
      return;
      if (this.mIsLoading)
      {
        Log.i("MoPub", "Already loading an ad for " + this.mAdUnitId + ", wait to finish.");
        return;
      }
      this.mFailUrl = null;
      this.mUrl = paramString;
      this.mIsLoading = true;
    } while (this.mAdFetcher == null);
    this.mAdFetcher.fetchAdForUrl(this.mUrl);
  }
  
  protected void registerClick()
  {
    if (this.mClickthroughUrl == null) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpGet localHttpGet = new HttpGet(AdView.this.mClickthroughUrl);
        localHttpGet.addHeader("User-Agent", AdView.this.mUserAgent);
        try
        {
          localDefaultHttpClient.execute(localHttpGet);
          return;
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          Log.i("MoPub", "Click tracking failed: " + AdView.this.mClickthroughUrl);
          return;
        }
        catch (IOException localIOException)
        {
          Log.i("MoPub", "Click tracking failed: " + AdView.this.mClickthroughUrl);
          return;
        }
        finally
        {
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
    }).start();
  }
  
  public void reload()
  {
    Log.d("MoPub", "Reload ad: " + this.mUrl);
    loadUrl(this.mUrl);
  }
  
  protected void scheduleRefreshTimerIfEnabled()
  {
    cancelRefreshTimer();
    if ((!this.mAutorefreshEnabled) || (this.mRefreshTimeMilliseconds <= 0)) {
      return;
    }
    this.mRefreshHandler.postDelayed(this.mRefreshRunnable, this.mRefreshTimeMilliseconds);
  }
  
  public void setAdContentView(View paramView)
  {
    this.mMoPubView.removeAllViews();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    this.mMoPubView.addView(paramView, localLayoutParams);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.mAdUnitId = paramString;
  }
  
  public void setAutorefreshEnabled(boolean paramBoolean)
  {
    this.mAutorefreshEnabled = paramBoolean;
    Log.d("MoPub", "Automatic refresh for " + this.mAdUnitId + " set to: " + paramBoolean + ".");
    if (!this.mAutorefreshEnabled)
    {
      cancelRefreshTimer();
      return;
    }
    scheduleRefreshTimerIfEnabled();
  }
  
  public void setClickthroughUrl(String paramString)
  {
    this.mClickthroughUrl = paramString;
  }
  
  protected void setIsLoading(boolean paramBoolean)
  {
    this.mIsLoading = paramBoolean;
  }
  
  public void setKeywords(String paramString)
  {
    this.mKeywords = paramString;
  }
  
  public void setLocation(Location paramLocation)
  {
    this.mLocation = paramLocation;
  }
  
  protected void setRefreshTimeMilliseconds(int paramInt)
  {
    this.mRefreshTimeMilliseconds = paramInt;
  }
  
  protected void setResponseString(String paramString)
  {
    this.mResponseString = paramString;
  }
  
  public void setTesting(boolean paramBoolean)
  {
    this.mTesting = paramBoolean;
  }
  
  public void setTimeout(int paramInt)
  {
    if (this.mAdFetcher != null) {
      this.mAdFetcher.setTimeout(paramInt);
    }
  }
  
  protected void trackImpression()
  {
    if (this.mImpressionUrl == null) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        try
        {
          HttpGet localHttpGet = new HttpGet(AdView.this.mImpressionUrl);
          localHttpGet.addHeader("User-Agent", AdView.this.mUserAgent);
          localDefaultHttpClient.execute(localHttpGet);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.d("MoPub", "Impression tracking failed (IllegalArgumentException): " + AdView.this.mImpressionUrl);
          return;
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          Log.d("MoPub", "Impression tracking failed (ClientProtocolException): " + AdView.this.mImpressionUrl);
          return;
        }
        catch (IOException localIOException)
        {
          Log.d("MoPub", "Impression tracking failed (IOException): " + AdView.this.mImpressionUrl);
          return;
        }
        finally
        {
          localDefaultHttpClient.getConnectionManager().shutdown();
        }
      }
    }).start();
  }
  
  private class AdWebViewClient
    extends WebViewClient
  {
    private AdWebViewClient() {}
    
    private String urlWithClickTrackingRedirect(AdView paramAdView, String paramString)
    {
      paramAdView = paramAdView.getClickthroughUrl();
      if (paramAdView == null) {
        return paramString;
      }
      paramString = Uri.encode(paramString);
      return paramAdView + "&r=" + paramString;
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      paramBitmap = (AdView)paramWebView;
      String str = paramBitmap.getRedirectUrl();
      if ((str != null) && (paramString.startsWith(str)))
      {
        paramString = urlWithClickTrackingRedirect(paramBitmap, paramString);
        paramWebView.stopLoading();
        AdView.this.showBrowserForUrl(paramString);
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      int i = 0;
      paramWebView = (AdView)paramWebView;
      Object localObject;
      if (paramString.startsWith("mopub://"))
      {
        paramString = Uri.parse(paramString);
        localObject = paramString.getHost();
        if (((String)localObject).equals("finishLoad")) {
          paramWebView.adDidLoad();
        }
        do
        {
          return true;
          if (((String)localObject).equals("close"))
          {
            paramWebView.adDidClose();
            return true;
          }
          if (((String)localObject).equals("failLoad"))
          {
            paramWebView.loadFailUrl();
            return true;
          }
        } while (!((String)localObject).equals("custom"));
        paramWebView.handleCustomIntentFromUri(paramString);
        return true;
      }
      if ((paramString.startsWith("tel:")) || (paramString.startsWith("voicemail:")) || (paramString.startsWith("sms:")) || (paramString.startsWith("mailto:")) || (paramString.startsWith("geo:")) || (paramString.startsWith("google.streetview:")))
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.addFlags(268435456);
        try
        {
          AdView.this.getContext().startActivity(paramWebView);
          AdView.this.registerClick();
          return true;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          Log.w("MoPub", "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
          return true;
        }
      }
      if (paramString.startsWith("market://"))
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        if (AdView.this.getContext().getPackageManager().queryIntentActivities((Intent)localObject, 0).size() > 0) {
          i = 1;
        }
        if (i == 0)
        {
          Log.w("MoPub", "Could not handle market action: " + paramString + ". Perhaps you're running in the emulator, which does not have " + "the Android Market?");
          return true;
        }
      }
      paramWebView = urlWithClickTrackingRedirect(paramWebView, paramString);
      Log.d("MoPub", "Ad clicked. Click URL: " + paramWebView);
      AdView.this.mMoPubView.adClicked();
      AdView.this.showBrowserForUrl(paramWebView);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */