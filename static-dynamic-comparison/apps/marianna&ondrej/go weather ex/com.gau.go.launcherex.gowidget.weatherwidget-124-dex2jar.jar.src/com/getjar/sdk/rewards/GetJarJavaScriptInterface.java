package com.getjar.sdk.rewards;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.getjar.sdk.comm.CallbackInterface;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.Operation;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.comm.TransactionManager;
import com.getjar.sdk.comm.UserAgentValuesManager;
import com.getjar.sdk.comm.auth.ApplicationTokenDatabase;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.data.DeviceMetadata;
import com.getjar.sdk.data.cache.AdManager.AdType;
import com.getjar.sdk.data.usage.AnalyticsManager;
import com.getjar.sdk.data.usage.AnalyticsManager.TrackingType;
import com.getjar.sdk.data.usage.UsageManager;
import com.getjar.sdk.internal.LicensableProduct;
import com.getjar.sdk.internal.Product;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.Constants.AppState;
import com.getjar.sdk.utilities.Constants.RequestInstallSubState;
import com.getjar.sdk.utilities.Constants.RequestInstallType;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.ScreenUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.SystemUtility;
import com.getjar.sdk.utilities.Utility;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetJarJavaScriptInterface
  extends JavaScriptAPI
{
  private Bundle _failBundle;
  private boolean _isExist = false;
  private long _lastReload = 0L;
  private final ResultReceiver _messenger;
  private Map<String, GetJarWebViewSubActivity.ProductWithClientTransactionID> _productIdToProduct;
  private Handler _purchaseResultHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        GetJarJavaScriptInterface.this.purchaseSuccess(GetJarJavaScriptInterface.this._successBundle);
        return;
      }
      GetJarJavaScriptInterface.this.purchaseFail(GetJarJavaScriptInterface.this._failBundle);
    }
  };
  private Bundle _successBundle;
  
  public GetJarJavaScriptInterface(CommContext paramCommContext, GetJarWebViewSubActivity paramGetJarWebViewSubActivity, ResultReceiver paramResultReceiver, List<GetJarWebViewSubActivity.ProductWithClientTransactionID> paramList)
  {
    super(paramCommContext, paramGetJarWebViewSubActivity);
    if (paramCommContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    if (paramGetJarWebViewSubActivity == null) {
      throw new IllegalArgumentException("Must have a valid parent Activity.");
    }
    this._productIdToProduct = new HashMap();
    if (paramList != null)
    {
      paramCommContext = paramList.iterator();
      while (paramCommContext.hasNext())
      {
        paramGetJarWebViewSubActivity = (GetJarWebViewSubActivity.ProductWithClientTransactionID)paramCommContext.next();
        this._productIdToProduct.put(paramGetJarWebViewSubActivity.getProduct().getProductId(), paramGetJarWebViewSubActivity);
      }
    }
    this._isExist = false;
    this._messenger = paramResultReceiver;
  }
  
  private void _requestInstall(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Constants.RequestInstallType paramRequestInstallType)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'thePackageName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'theFriendlyName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'theDownloadUrl' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString4)) {
      throw new IllegalArgumentException("'theAppMetadata' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString5)) {
      throw new IllegalArgumentException("'theTrackingMetadata' cannot be NULL or empty");
    }
    if (paramRequestInstallType == null) {
      throw new IllegalArgumentException("'theRequestType' cannot be NULL");
    }
    try
    {
      RewardUtility.requestInstall(paramString1, paramString2, paramString3, paramString4, paramString5, paramRequestInstallType, this._interstitialAdPlacementTag, this._parentActivity.getCurrencyKey(), AdManager.AdType.INTERSTITIAL, this._commContext.getApplicationContext());
      return;
    }
    catch (Exception paramString1)
    {
      Logger.e(Area.JS_API.value() | Area.EARN.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramString1, "JavaScriptAPI: _requestInstall() failed", new Object[0]);
    }
  }
  
  private void configureWebViewOnUIThread(Boolean paramBoolean1, Boolean paramBoolean2, String paramString)
  {
    if (Utility.isCurrentThreadTheUIThread())
    {
      Object localObject = findWebViewInUILayout((ViewGroup)this._parentActivity.getParentActivity().getWindow().getDecorView());
      if (localObject == null) {
        throw new IllegalStateException("Unable to find the WebView in the UI layout!");
      }
      localObject = ((WebView)localObject).getSettings();
      if (paramString != null) {
        WebSettingsEx.setDefaultZoom((WebSettings)localObject, getZoomDensity(paramString));
      }
      if (paramBoolean1 != null) {
        ((WebSettings)localObject).setBuiltInZoomControls(paramBoolean1.booleanValue());
      }
      if (paramBoolean2 != null) {
        ((WebSettings)localObject).setSupportZoom(paramBoolean2.booleanValue());
      }
      return;
    }
    throw new IllegalStateException("configureWebViewOnUIThread -- Not called from a UI thread.");
  }
  
  private WebView findWebViewInUILayout(ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      View localView;
      if (i < paramViewGroup.getChildCount())
      {
        localView = paramViewGroup.getChildAt(i);
        localObject2 = localObject1;
        if (localView == null) {
          break label89;
        }
        if (!WebView.class.isAssignableFrom(localView.getClass())) {
          break label53;
        }
        localObject2 = (WebView)localView;
      }
      label53:
      do
      {
        return (WebView)localObject2;
        localObject2 = localObject1;
        if (!ViewGroup.class.isAssignableFrom(localView.getClass())) {
          break;
        }
        localObject1 = findWebViewInUILayout((ViewGroup)localView);
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
      label89:
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  /* Error */
  public static String getUsageSessionRecords(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 168	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   6: getstatic 306	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   9: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   12: lor
    //   13: ldc_w 308
    //   16: iconst_0
    //   17: anewarray 185	java/lang/Object
    //   20: invokestatic 312	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   23: new 314	org/json/JSONObject
    //   26: dup
    //   27: invokespecial 315	org/json/JSONObject:<init>	()V
    //   30: astore_1
    //   31: aload_0
    //   32: invokestatic 321	com/getjar/sdk/data/usage/UsageManager:getInstance	(Landroid/content/Context;)Lcom/getjar/sdk/data/usage/UsageManager;
    //   35: invokevirtual 325	com/getjar/sdk/data/usage/UsageManager:getAggregateSessionsForReporting	()Lcom/getjar/sdk/data/usage/AggregateUsageReport;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +245 -> 285
    //   43: aload_1
    //   44: ldc_w 327
    //   47: aload_2
    //   48: invokevirtual 332	com/getjar/sdk/data/usage/AggregateUsageReport:getTimestampStart	()J
    //   51: invokevirtual 335	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload_1
    //   56: ldc_w 337
    //   59: aload_2
    //   60: invokevirtual 340	com/getjar/sdk/data/usage/AggregateUsageReport:getTimestampStop	()J
    //   63: invokevirtual 335	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload_1
    //   68: ldc_w 342
    //   71: ldc_w 344
    //   74: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   77: pop
    //   78: new 349	org/json/JSONArray
    //   81: dup
    //   82: invokespecial 350	org/json/JSONArray:<init>	()V
    //   85: astore_0
    //   86: aload_2
    //   87: invokevirtual 354	com/getjar/sdk/data/usage/AggregateUsageReport:getRecords	()Ljava/util/List;
    //   90: invokeinterface 357 1 0
    //   95: ifle +181 -> 276
    //   98: getstatic 168	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
    //   101: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   104: getstatic 306	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   107: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   110: lor
    //   111: ldc_w 359
    //   114: iconst_1
    //   115: anewarray 185	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_2
    //   121: invokevirtual 354	com/getjar/sdk/data/usage/AggregateUsageReport:getRecords	()Ljava/util/List;
    //   124: invokeinterface 357 1 0
    //   129: invokestatic 365	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 312	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_2
    //   137: invokevirtual 354	com/getjar/sdk/data/usage/AggregateUsageReport:getRecords	()Ljava/util/List;
    //   140: invokeinterface 72 1 0
    //   145: astore_2
    //   146: aload_2
    //   147: invokeinterface 78 1 0
    //   152: ifeq +124 -> 276
    //   155: aload_2
    //   156: invokeinterface 82 1 0
    //   161: checkcast 367	com/getjar/sdk/data/usage/AggregateUsageRecord
    //   164: astore_3
    //   165: new 314	org/json/JSONObject
    //   168: dup
    //   169: invokespecial 315	org/json/JSONObject:<init>	()V
    //   172: astore 4
    //   174: aload 4
    //   176: ldc_w 369
    //   179: aload_3
    //   180: invokevirtual 372	com/getjar/sdk/data/usage/AggregateUsageRecord:getPackageName	()Ljava/lang/String;
    //   183: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload 4
    //   189: ldc_w 374
    //   192: aload_3
    //   193: invokevirtual 377	com/getjar/sdk/data/usage/AggregateUsageRecord:getTotalUseDuration	()I
    //   196: invokevirtual 380	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   199: pop
    //   200: aload 4
    //   202: ldc_w 382
    //   205: aload_3
    //   206: invokevirtual 385	com/getjar/sdk/data/usage/AggregateUsageRecord:getTotalSessionsCount	()I
    //   209: invokevirtual 380	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_0
    //   214: aload 4
    //   216: invokevirtual 388	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   219: pop
    //   220: goto -74 -> 146
    //   223: astore_0
    //   224: getstatic 168	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
    //   227: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   230: getstatic 306	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   233: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   236: lor
    //   237: aload_0
    //   238: ldc_w 390
    //   241: iconst_0
    //   242: anewarray 185	java/lang/Object
    //   245: invokestatic 191	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: getstatic 168	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
    //   251: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   254: getstatic 306	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   257: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   260: lor
    //   261: ldc_w 392
    //   264: iconst_0
    //   265: anewarray 185	java/lang/Object
    //   268: invokestatic 312	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   271: aload_1
    //   272: invokevirtual 395	org/json/JSONObject:toString	()Ljava/lang/String;
    //   275: areturn
    //   276: aload_1
    //   277: ldc_w 397
    //   280: aload_0
    //   281: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   284: pop
    //   285: getstatic 168	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
    //   288: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   291: getstatic 306	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   294: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   297: lor
    //   298: ldc_w 392
    //   301: iconst_0
    //   302: anewarray 185	java/lang/Object
    //   305: invokestatic 312	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -37 -> 271
    //   311: astore_0
    //   312: getstatic 168	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
    //   315: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   318: getstatic 306	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   321: invokevirtual 172	com/getjar/sdk/logging/Area:value	()J
    //   324: lor
    //   325: ldc_w 392
    //   328: iconst_0
    //   329: anewarray 185	java/lang/Object
    //   332: invokestatic 312	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   335: aload_0
    //   336: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramContext	Context
    //   30	247	1	localJSONObject1	JSONObject
    //   38	118	2	localObject	Object
    //   164	42	3	localAggregateUsageRecord	com.getjar.sdk.data.usage.AggregateUsageRecord
    //   172	43	4	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   31	39	223	java/lang/Exception
    //   43	146	223	java/lang/Exception
    //   146	220	223	java/lang/Exception
    //   276	285	223	java/lang/Exception
    //   31	39	311	finally
    //   43	146	311	finally
    //   146	220	311	finally
    //   224	248	311	finally
    //   276	285	311	finally
  }
  
  private Object getZoomDensity(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("zoomDensityString cannot be empty or null");
    }
    if (paramString.equals("FAR")) {
      return WebSettingsEx.ZoomDensity.FAR;
    }
    if (paramString.equals("MEDIUM")) {
      return WebSettingsEx.ZoomDensity.MEDIUM;
    }
    if (paramString.equals("CLOSE")) {
      return WebSettingsEx.ZoomDensity.CLOSE;
    }
    throw new IllegalArgumentException("Invalid value for zoomDensity");
  }
  
  private void purchaseFail(Bundle paramBundle)
  {
    this._messenger.send(6, paramBundle);
  }
  
  private void purchaseSuccess(Bundle paramBundle)
  {
    this._messenger.send(5, paramBundle);
  }
  
  private void reloadViewInternal(boolean paramBoolean1, boolean paramBoolean2)
  {
    this._parentActivity.waitDialogShow();
    Logger.d(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: reloadView called from thread.id:%1$d thread.name:%2$s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() });
    if (!this._isExist)
    {
      Logger.d(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: reloadView past isExist", new Object[0]);
      if (!paramBoolean1) {
        break label224;
      }
      long l = System.currentTimeMillis() - this._lastReload;
      this._lastReload = System.currentTimeMillis();
      if ((paramBoolean2) && (l < 60000L))
      {
        Logger.w(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: A re-authorization/reload attempt was made %1$d milliseconds ago, skipping this attempt request", new Object[] { Long.valueOf(l) });
        this._messenger.send(3, null);
      }
    }
    else
    {
      return;
    }
    Logger.d(Area.JS_API.value() | Area.AUTH.value(), "JavaScriptAPI: reloadView is re-authorizing", new Object[0]);
    try
    {
      new Thread(new ReauthThread(null)).start();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.AUTH.value(), localException, "JavaScriptAPI: reloadViewInternal() failed", new Object[0]);
      return;
    }
    label224:
    this._messenger.send(10, null);
  }
  
  @JavascriptInterface
  public void buyGold(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'platformItemId' cannot be null or empty");
    }
    try
    {
      paramString2 = Utility.jsonArrayStringToMap(paramString2);
      AuthManager.initialize(this._commContext.getApplicationContext());
      paramString2.put("client_app.token", ApplicationTokenDatabase.getInstance(this._commContext.getApplicationContext()).getApplicationToken());
      paramString2.put("user.user_access_id", AuthManager.getInstance().getUserAccessId());
      paramString2.put("legacy.device.user_agent", UserAgentValuesManager.getInstance().getWebKitUserAgent(this._commContext.getApplicationContext()));
      InAppPurchaseManager.getInstance(this._commContext.getApplicationContext()).buyGoldOffer(paramString1, paramString2, this._parentActivity.getParentActivity());
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        Logger.w(Area.JS_API.value() | Area.TRANSACTION.value() | Area.BUY_GOLD.value(), "JavaScriptAPI: ERROR: Invalid tracking data.", new Object[0]);
        paramString2 = new HashMap(3);
      }
    }
  }
  
  @JavascriptInterface
  public boolean canBuy()
  {
    try
    {
      boolean bool = AuthManager.getInstance().getClaimsManager(this._commContext.getApplicationContext()).canBuy();
      return bool;
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.TRANSACTION.value() | Area.CONFIG.value() | Area.BUY_GOLD.value(), localException, "ClaimsManager.canBuy() failed", new Object[0]);
    }
    return false;
  }
  
  @JavascriptInterface
  public boolean canEarn()
  {
    try
    {
      boolean bool = AuthManager.getInstance().getClaimsManager(this._commContext.getApplicationContext()).canEarn();
      return bool;
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.EARN.value() | Area.TRANSACTION.value() | Area.CONFIG.value(), localException, "ClaimsManager.canEarn() failed", new Object[0]);
    }
    return false;
  }
  
  @JavascriptInterface
  public boolean canPurchaseUnmanagedProducts()
  {
    try
    {
      boolean bool = AuthManager.getInstance().getClaimsManager(this._commContext.getApplicationContext()).canPurchaseUnmanagedProducts();
      return bool;
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.CONFIG.value() | Area.TRANSACTION.value(), localException, "ClaimsManager.canPurchaseUnmanagedProducts() failed", new Object[0]);
    }
    return false;
  }
  
  @JavascriptInterface
  public void closeView()
  {
    Logger.d(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: closeView is called", new Object[0]);
    this._isExist = true;
    this._messenger.send(0, null);
  }
  
  @JavascriptInterface
  public void configureWebView(final Boolean paramBoolean1, final Boolean paramBoolean2, final String paramString)
  {
    if (this._parentActivity == null)
    {
      Logger.i(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: getDisplayMetrics() -- _parentActivity cannot be null.", new Object[0]);
      return;
    }
    if (Utility.isCurrentThreadTheUIThread())
    {
      configureWebViewOnUIThread(paramBoolean1, paramBoolean2, paramString);
      return;
    }
    this._parentActivity.getParentActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        try
        {
          GetJarJavaScriptInterface.this.configureWebViewOnUIThread(paramBoolean1, paramBoolean2, paramString);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(Area.JS_API.value() | Area.UI.value(), localException, "JavaScriptAPI: configureWebView() failed", new Object[0]);
        }
      }
    });
  }
  
  @JavascriptInterface
  public String getAppState(String paramString)
  {
    Constants.AppState localAppState = Constants.AppState.UNINSTALLED;
    try
    {
      this._commContext.getApplicationContext().getPackageManager().getApplicationInfo(paramString, 0);
      paramString = Constants.AppState.INSTALLED;
      switch (paramString)
      {
      default: 
        return "UNINSTALLED";
      }
      return "INSTALLED";
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString = localAppState;
      }
    }
  }
  
  @JavascriptInterface
  public String getAuthToken()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      AuthManager.initialize(this._commContext.getApplicationContext());
      str1 = str2;
      str2 = AuthManager.getInstance().getAuthToken();
      str1 = str2;
      Logger.d(Area.JS_API.value() | Area.AUTH.value(), "JavaScriptAPI: getAuthToken() returning: '%1$s'", new Object[] { str2 });
      return str2;
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.AUTH.value(), localException, "JavaScriptAPI: getAuthToken() failed", new Object[0]);
    }
    return str1;
  }
  
  @JavascriptInterface
  public String getCapabilities()
  {
    Object localObject1 = new HashMap();
    try
    {
      localObject2 = AuthManager.getInstance().getClaimsManager(this._commContext.getApplicationContext()).getCapabilities();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Logger.e(Area.JS_API.value() | Area.AUTH.value(), localException, "ClaimsManager.getCapabilities() failed", new Object[0]);
      }
      return localException.toString();
    }
    localObject2 = new JSONObject();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      try
      {
        ((JSONObject)localObject2).put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        Logger.e(Area.JS_API.value() | Area.AUTH.value(), localJSONException, "JavaScriptAPI: getCapabilities() failed", new Object[0]);
      }
    }
  }
  
  @JavascriptInterface
  public String getDeviceDetails()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject2 = this._commContext.getWebKitUserAgent();
      Object localObject3 = this._commContext.getDeviceMetadata().getMetadataValue(DeviceMetadata.KEY_ANDROID_DEVICE_DEVICE_ID);
      Object localObject4 = this._commContext.getDeviceMetadata().getMetadataValue(DeviceMetadata.KEY_ANDROID_DEVICE_ANDROID_ID);
      String str = this._commContext.getDeviceMetadata().getMetadataValue(DeviceMetadata.KEY_ANDROID_DEVICE_SERIAL_NUMBER);
      Object localObject1 = localObject2;
      if (StringUtility.isNullOrEmpty((String)localObject2)) {
        localObject1 = "";
      }
      localObject2 = localObject3;
      if (StringUtility.isNullOrEmpty((String)localObject3)) {
        localObject2 = "";
      }
      localObject3 = localObject4;
      if (StringUtility.isNullOrEmpty((String)localObject4)) {
        localObject3 = "";
      }
      localObject4 = str;
      if (StringUtility.isNullOrEmpty(str)) {
        localObject4 = "";
      }
      boolean bool1 = RewardUtility.checkPermission(this._commContext.getApplicationContext(), "android.permission.READ_PHONE_STATE");
      boolean bool2 = RewardUtility.checkPermission(this._commContext.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE");
      localJSONObject.put("device_filter", localObject1);
      localJSONObject.put("android.device.device_id", localObject2);
      localJSONObject.put("android.device.serial_number", localObject4);
      localJSONObject.put("android.device.android_id", localObject3);
      localJSONObject.put("android.package.permission.read_phone_state", bool1);
      localJSONObject.put("android.package.permission.access_wifi_state", bool2);
      localObject1 = AdvertisingIdHelper.getInstance(this._commContext.getApplicationContext());
      localJSONObject.put("android.device.google_play.ads.advertising_id", ((AdvertisingIdHelper)localObject1).getId());
      localJSONObject.put("android.device.google_play.ads.limit_tracking_enabled", ((AdvertisingIdHelper)localObject1).isLimitAdTrackingEnabled());
      localJSONObject.put("android.device.google_play.ads.retrieve_error", ((AdvertisingIdHelper)localObject1).hasError());
      Logger.d(Area.JS_API.value() | Area.CONFIG.value(), "JavaScriptAPI: getDeviceDetails() returning:\r\n%1$s", new Object[] { localJSONObject.toString(4) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(Area.JS_API.value() | Area.CONFIG.value(), localException, "JavaScriptAPI: getDeviceDetails() failed", new Object[0]);
      }
    }
    return localJSONObject.toString();
  }
  
  @JavascriptInterface
  public String getDisplayLanguageTag()
  {
    Object localObject = "en-us";
    try
    {
      String str = this._parentActivity.getDisplayLanguageTag();
      localObject = str;
      Logger.d(Area.JS_API.value() | Area.UI.value() | Area.LOCALIZATION.value(), "JavaScriptAPI: getDisplayLanguageTag() returning: '%1$s'", new Object[] { str });
      return str;
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.UI.value() | Area.LOCALIZATION.value(), localException, "JavaScriptAPI: getDisplayLanguageTag() failed", new Object[0]);
    }
    return (String)localObject;
  }
  
  @JavascriptInterface
  public String getDisplayMetrics()
  {
    if (this._parentActivity == null)
    {
      Logger.i(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: getDisplayMetrics() -- _parentActivity cannot be null.", new Object[0]);
      return new JSONObject().toString();
    }
    return ScreenUtility.getDisplayMetrics(this._parentActivity.getParentActivity()).toString();
  }
  
  @JavascriptInterface
  public long getLastReloadTime()
  {
    return this._lastReload;
  }
  
  @JavascriptInterface
  public String getRecentlyUsedApps()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      if (UsageManager.getInstance(this._commContext.getApplicationContext()).isRequestSendEnabled())
      {
        Object localObject = SystemUtility.getRecentlyRunAppsFromOS(this._commContext.getApplicationContext());
        Logger.d(Area.JS_API.value() | Area.USAGE.value(), "JavaScriptAPI: getRecentlyUsedApps() %d recent apps", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localJSONArray.put((String)((Iterator)localObject).next());
          continue;
          return localJSONArray.toString();
        }
      }
    }
    catch (Exception localException)
    {
      Logger.e(Area.JS_API.value() | Area.USAGE.value(), localException, "JavaScriptAPI: getRecentlyUsedApps() failed", new Object[0]);
    }
    for (;;)
    {
      Logger.d(Area.JS_API.value() | Area.USAGE.value(), "JavaScriptAPI: getRecentlyUsedApps() returning:\r\n%1$s", new Object[] { localJSONArray.toString(4) });
    }
  }
  
  @JavascriptInterface
  public String getUnmanagedOffer(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("Must provide a non-null, non-empty product ID.");
    }
    JSONObject localJSONObject3 = new JSONObject();
    Product localProduct = ((GetJarWebViewSubActivity.ProductWithClientTransactionID)this._productIdToProduct.get(paramString)).getProduct();
    JSONObject localJSONObject1 = localJSONObject3;
    if (localProduct != null) {}
    try
    {
      localJSONObject1 = localProduct.toJSONObject();
      return localJSONObject1.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), localJSONException, "JavaScriptAPI: productId=" + paramString, new Object[0]);
        JSONObject localJSONObject2 = localJSONObject3;
      }
    }
  }
  
  @JavascriptInterface
  public String getUnmanagedOffers()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this._productIdToProduct.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        localJSONArray.put(((GetJarWebViewSubActivity.ProductWithClientTransactionID)localEntry.getValue()).getProduct().toJSONObject());
      }
      catch (JSONException localJSONException)
      {
        Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), localJSONException, "JavaScriptAPI: productId=" + ((GetJarWebViewSubActivity.ProductWithClientTransactionID)localEntry.getValue()).getProduct().getProductId(), new Object[0]);
      }
    }
    return localJSONArray.toString();
  }
  
  @JavascriptInterface
  public String getUsageSessionRecords()
  {
    return getUsageSessionRecords(this._commContext.getApplicationContext());
  }
  
  @JavascriptInterface
  public String getUserAccessId()
  {
    AuthManager.initialize(this._commContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    return AuthManager.getInstance().getUserAccessId();
  }
  
  @JavascriptInterface
  public String getUserDeviceId()
  {
    AuthManager.initialize(this._commContext.getApplicationContext());
    AuthManager.getInstance().waitOnAuth();
    return AuthManager.getInstance().getUserDeviceId();
  }
  
  @JavascriptInterface
  public void launchGetJarRewardsApp()
  {
    if (!this._isExist) {
      launchRewardsApp();
    }
  }
  
  @JavascriptInterface
  public void log(String paramString1, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1))
    {
      Logger.d(Area.JS_API.value() | Area.UI.value(), "No message provided to log by javascript", new Object[0]);
      return;
    }
    String str = String.format("JavaScript: %s", new Object[] { paramString1 });
    paramString1 = paramString2;
    if (StringUtility.isNullOrEmpty(paramString2)) {
      paramString1 = "DEBUG";
    }
    if (paramString1.equalsIgnoreCase("VERBOSE"))
    {
      Logger.v(Area.JS_API.value() | Area.UI.value(), str, new Object[0]);
      return;
    }
    if (paramString1.equalsIgnoreCase("DEBUG"))
    {
      Logger.d(Area.JS_API.value() | Area.UI.value(), str, new Object[0]);
      return;
    }
    if (paramString1.equalsIgnoreCase("INFO"))
    {
      Logger.i(Area.JS_API.value() | Area.UI.value(), str, new Object[0]);
      return;
    }
    if (paramString1.equalsIgnoreCase("WARN"))
    {
      Logger.w(Area.JS_API.value() | Area.UI.value(), str, new Object[0]);
      return;
    }
    if (paramString1.equalsIgnoreCase("ERROR"))
    {
      Logger.e(Area.JS_API.value() | Area.UI.value(), str, new Object[0]);
      return;
    }
    Logger.d(Area.JS_API.value() | Area.UI.value(), str, new Object[0]);
  }
  
  @JavascriptInterface
  public void purchaseUnmanagedOffer(String paramString1, String paramString2)
  {
    Object localObject;
    if (!this._isExist)
    {
      Logger.d(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value() | Area.UI.value(), "JavaScriptAPI: purchaseUnmanagedOffer() -- theProductId=" + paramString1, new Object[0]);
      localObject = (GetJarWebViewSubActivity.ProductWithClientTransactionID)this._productIdToProduct.get(paramString1);
      if (localObject != null) {
        this._parentActivity.waitDialogShow();
      }
    }
    for (;;)
    {
      try
      {
        final PurchaseCallback localPurchaseCallback = new PurchaseCallback((GetJarWebViewSubActivity.ProductWithClientTransactionID)localObject);
        AuthManager.initialize(this._commContext.getApplicationContext());
        paramString2 = Utility.jsonArrayStringToMap(paramString2);
        paramString2.put("client_app.token", ApplicationTokenDatabase.getInstance(this._commContext.getApplicationContext()).getApplicationToken());
        paramString2.put("user.user_access_id", AuthManager.getInstance().getUserAccessId());
        paramString2.put("legacy.device.user_agent", UserAgentValuesManager.getInstance().getWebKitUserAgent(this._commContext.getApplicationContext()));
        if (paramString2.size() > 0)
        {
          Logger.v(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value() | Area.AUTH.value(), "JavaScriptAPI: Making a purchase with client transaction ID: '%1$s' [thread:%2$d]", new Object[] { ((GetJarWebViewSubActivity.ProductWithClientTransactionID)localObject).getClientTransactionId(), Long.valueOf(Thread.currentThread().getId()) });
          TransactionManager localTransactionManager = new TransactionManager(this._commContext.getApplicationContext());
          this._parentActivity.setCurrentPurchaseClientTransactionId(((GetJarWebViewSubActivity.ProductWithClientTransactionID)localObject).getClientTransactionId());
          paramString1 = ((GetJarWebViewSubActivity.ProductWithClientTransactionID)localObject).getProduct();
          localObject = ((GetJarWebViewSubActivity.ProductWithClientTransactionID)localObject).getClientTransactionId();
          CommContext localCommContext = this._commContext;
          String str1 = paramString1.getProductId();
          String str2 = paramString1.getProductName();
          String str3 = paramString1.getProductDescription();
          int i = (int)paramString1.getAmount();
          if (!LicensableProduct.class.isAssignableFrom(paramString1.getClass())) {
            break label504;
          }
          paramString1 = ((LicensableProduct)paramString1).getLicenseScope();
          new Thread(new Runnable()
          {
            public void run()
            {
              int j = 0;
              try
              {
                Logger.v(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), "JavaScriptAPI: Waiting on purchase reserve future", new Object[0]);
                int i = j;
                if (this.val$confirmFuture != null)
                {
                  i = j;
                  if (this.val$confirmFuture.get() != null)
                  {
                    ((Operation)this.val$confirmFuture.get()).mapResultToCallbacks(localPurchaseCallback);
                    i = 1;
                  }
                }
                Logger.v(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), "JavaScriptAPI: Done waiting on purchase reserve future", new Object[0]);
                GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
                if (i == 0) {
                  localPurchaseCallback.serviceRequestFailed(null, null, "unknown", GetJarJavaScriptInterface.this._commContext);
                }
                return;
              }
              catch (Exception localException)
              {
                Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), localException, "JavaScriptAPI: Purchase call-back thread failed", new Object[0]);
                return;
              }
              finally
              {
                Logger.v(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), "JavaScriptAPI: Done waiting on purchase reserve future", new Object[0]);
                GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
                if (0 == 0) {
                  localPurchaseCallback.serviceRequestFailed(null, null, "unknown", GetJarJavaScriptInterface.this._commContext);
                }
              }
            }
          }, "Purchase call-back thread").start();
          return;
        }
        Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), "JavaScriptAPI: ERROR: unable to send purchaseOffer transaction, empty tracking data.", new Object[0]);
        this._parentActivity.waitDialogHide();
        return;
      }
      catch (Exception paramString1)
      {
        Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramString1, "JavaScriptAPI: purchaseUnmanagedOffer() failed", new Object[0]);
        this._parentActivity.waitDialogHide();
        return;
      }
      Logger.d(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), "JavaScriptAPI: purchaseUnmanagedOffer() -- offer with theProductId=" + paramString1 + " was not found..", new Object[0]);
      return;
      label504:
      paramString1 = null;
    }
  }
  
  @JavascriptInterface
  public void reloadView(boolean paramBoolean)
  {
    Logger.d(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: reloadView(%1$s)", new Object[] { Boolean.toString(paramBoolean) });
    reloadViewInternal(paramBoolean, true);
  }
  
  @JavascriptInterface
  public void reloadViewNoSafety(boolean paramBoolean)
  {
    Logger.d(Area.JS_API.value() | Area.UI.value(), "JavaScriptAPI: reloadViewNoSafety(%1$s)", new Object[] { Boolean.toString(paramBoolean) });
    reloadViewInternal(paramBoolean, false);
  }
  
  @JavascriptInterface
  public void requestEarnInstall(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AnalyticsManager.getInstance(this._commContext.getApplicationContext()).trackEvent("user_requested_install", new Object[] { "package_name", paramString1, "type", AnalyticsManager.TrackingType.EARN_CURRENCY.value() });
    if (!this._isExist) {}
    try
    {
      _requestInstall(paramString1, paramString2, paramString3, paramString4, paramString5, Constants.RequestInstallType.EARN);
      return;
    }
    catch (Exception paramString1)
    {
      try
      {
        Logger.e(Area.JS_API.value() | Area.EARN.value() | Area.TRANSACTION.value(), paramString1, "JavaScriptAPI: requestEarnInstall() failed [thread:%1$d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        this._parentActivity.unableToDownloadDialogShow();
        return;
      }
      catch (Exception paramString1)
      {
        Logger.e(Area.JS_API.value() | Area.EARN.value() | Area.TRANSACTION.value(), paramString1, "JavaScriptAPI: failure", new Object[0]);
      }
    }
  }
  
  @JavascriptInterface
  public void requestGoldOffers()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          final String str = InAppPurchaseManager.getInstance(GetJarJavaScriptInterface.this._commContext.getApplicationContext()).getGoldOffers();
          GetJarJavaScriptInterface.this._parentActivity.getParentActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                ((WebView)((FrameLayout)GetJarJavaScriptInterface.this._parentActivity.getParentActivity().findViewById(16908290)).getChildAt(0)).loadUrl(String.format(Locale.US, "javascript:GJ.receivedGoldOffers(%s)", new Object[] { str }));
                return;
              }
              catch (Exception localException)
              {
                Logger.e(Area.JS_API.value() | Area.TRANSACTION.value() | Area.BUY_GOLD.value(), localException, "JavaScriptAPI: requestGoldOffers() failed", new Object[0]);
              }
            }
          });
          return;
        }
        catch (Exception localException)
        {
          Logger.e(Area.JS_API.value() | Area.TRANSACTION.value() | Area.BUY_GOLD.value(), localException, "JavaScriptAPI: requestGoldOffers() failed", new Object[0]);
        }
      }
    }).start();
  }
  
  @JavascriptInterface
  public void requestPurchaseInstall(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this._isExist) {}
    try
    {
      _requestInstall(paramString1, paramString2, paramString3, paramString4, paramString5, Constants.RequestInstallType.PURCHASE);
      return;
    }
    catch (Exception paramString1)
    {
      try
      {
        Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramString1, "JavaScriptAPI: requestPurchaseInstall() failed [thread:%1$d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        this._parentActivity.unableToDownloadDialogShow();
        return;
      }
      catch (Exception paramString1)
      {
        Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramString1, "JavaScriptAPI: failure", new Object[0]);
      }
    }
  }
  
  protected void setInterstitialAdPlacementTag(String paramString)
  {
    this._interstitialAdPlacementTag = paramString;
  }
  
  @JavascriptInterface
  public void setLastReloadTime()
  {
    this._lastReload = (System.currentTimeMillis() / 1000L);
  }
  
  private class PurchaseCallback
    implements CallbackInterface
  {
    private GetJarWebViewSubActivity.ProductWithClientTransactionID _offer = null;
    
    protected PurchaseCallback(GetJarWebViewSubActivity.ProductWithClientTransactionID paramProductWithClientTransactionID)
    {
      this._offer = paramProductWithClientTransactionID;
    }
    
    public void serviceRequestFailed(Result paramResult, Exception paramException, String paramString, CommContext paramCommContext)
    {
      for (;;)
      {
        try
        {
          GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
          localBundle = new Bundle();
          localBundle.putString("id", this._offer.getProduct().getProductId());
          localBundle.putString("transactionId", this._offer.getClientTransactionId());
          localBundle.putLong("price", this._offer.getProduct().getAmount());
          localBundle.putString("name", this._offer.getProduct().getProductName());
          paramResult = Utility.getResponseSubstate(paramException, Constants.RequestInstallSubState.NONE.toString());
          localBundle.putString(Constants.RequestInstallSubState.KEY(), paramResult);
          l1 = Area.JS_API.value();
          l2 = Area.PURCHASE.value();
          l3 = Area.TRANSACTION.value();
          if (paramCommContext != null) {
            continue;
          }
          paramResult = "";
        }
        catch (Exception paramResult)
        {
          Bundle localBundle;
          long l1;
          long l2;
          long l3;
          Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramResult, "JavaScriptAPI: failure", new Object[0]);
          paramCommContext.addException(paramResult);
          try
          {
            GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
            return;
          }
          catch (Exception paramResult)
          {
            Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramResult, "JavaScriptAPI: failure", new Object[0]);
            paramCommContext.addException(paramResult);
            return;
          }
        }
        finally
        {
          try
          {
            GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
            throw paramResult;
          }
          catch (Exception paramException)
          {
            Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramException, "JavaScriptAPI: failure", new Object[0]);
            paramCommContext.addException(paramException);
            continue;
          }
          if (paramException != null) {
            continue;
          }
          String str = "";
          continue;
        }
        Logger.d(l1 | l2 | l3, "JavaScriptAPI: PurchaseCallback: Request %1$s on CommContext %2$s resulted in a call to serviceRequestFailed(). %3$s", new Object[] { paramString, paramResult, str });
        if (paramException != null) {
          Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramException, "JavaScriptAPI: purchase failed", new Object[0]);
        }
        GetJarJavaScriptInterface.access$402(GetJarJavaScriptInterface.this, localBundle);
        paramResult = new Message();
        paramResult.what = 1;
        GetJarJavaScriptInterface.this._purchaseResultHandler.sendMessage(paramResult);
        try
        {
          GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
          return;
        }
        catch (Exception paramResult)
        {
          Logger.e(Area.JS_API.value() | Area.PURCHASE.value() | Area.TRANSACTION.value(), paramResult, "JavaScriptAPI: failure", new Object[0]);
          paramCommContext.addException(paramResult);
          return;
        }
        paramResult = paramCommContext.getCommContextId();
        continue;
        str = paramException.getMessage();
      }
    }
    
    public void serviceRequestRetry(Exception paramException, String paramString, CommContext paramCommContext, int paramInt) {}
    
    /* Error */
    public void serviceRequestSucceeded(Result paramResult, String paramString, CommContext paramCommContext)
    {
      // Byte code:
      //   0: aload_1
      //   1: getstatic 83	com/getjar/sdk/utilities/Constants$RequestInstallSubState:NONE	Lcom/getjar/sdk/utilities/Constants$RequestInstallSubState;
      //   4: invokevirtual 86	com/getjar/sdk/utilities/Constants$RequestInstallSubState:toString	()Ljava/lang/String;
      //   7: invokestatic 173	com/getjar/sdk/comm/TransactionManager:getTransactionSubstate	(Lcom/getjar/sdk/comm/Result;Ljava/lang/String;)Ljava/lang/String;
      //   10: astore 14
      //   12: aload 14
      //   14: getstatic 176	com/getjar/sdk/utilities/Constants$RequestInstallSubState:FUNDS_INSUFFICIENT_FAILURE	Lcom/getjar/sdk/utilities/Constants$RequestInstallSubState;
      //   17: invokevirtual 178	com/getjar/sdk/utilities/Constants$RequestInstallSubState:name	()Ljava/lang/String;
      //   20: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   23: istore 5
      //   25: iload 5
      //   27: ifne +382 -> 409
      //   30: aconst_null
      //   31: astore 13
      //   33: aload_1
      //   34: invokevirtual 190	com/getjar/sdk/comm/Result:getResponseJson	()Lorg/json/JSONObject;
      //   37: ldc -64
      //   39: invokevirtual 198	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   42: ldc -56
      //   44: invokevirtual 204	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   47: iconst_0
      //   48: invokevirtual 209	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
      //   51: ldc -45
      //   53: invokevirtual 204	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   56: astore 15
      //   58: iconst_0
      //   59: istore 4
      //   61: aload 13
      //   63: astore 12
      //   65: iload 4
      //   67: aload 15
      //   69: invokevirtual 215	org/json/JSONArray:length	()I
      //   72: if_icmpge +36 -> 108
      //   75: aload 15
      //   77: iload 4
      //   79: invokevirtual 209	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
      //   82: astore 12
      //   84: aload 12
      //   86: ldc -39
      //   88: invokevirtual 221	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   91: ldc -33
      //   93: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   96: ifeq +48 -> 144
      //   99: aload 12
      //   101: ldc -32
      //   103: invokevirtual 221	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   106: astore 12
      //   108: aload 12
      //   110: invokestatic 230	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
      //   113: ifeq +157 -> 270
      //   116: aload_0
      //   117: aload_1
      //   118: new 232	com/getjar/sdk/exceptions/ServiceException
      //   121: dup
      //   122: aload 14
      //   124: aload_1
      //   125: invokespecial 235	com/getjar/sdk/exceptions/ServiceException:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/Result;)V
      //   128: aload_2
      //   129: aload_3
      //   130: invokevirtual 237	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:serviceRequestFailed	(Lcom/getjar/sdk/comm/Result;Ljava/lang/Exception;Ljava/lang/String;Lcom/getjar/sdk/comm/CommContext;)V
      //   133: aload_0
      //   134: getfield 17	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:this$0	Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;
      //   137: getfield 31	com/getjar/sdk/rewards/GetJarJavaScriptInterface:_parentActivity	Lcom/getjar/sdk/rewards/GetJarWebViewSubActivity;
      //   140: invokevirtual 36	com/getjar/sdk/rewards/GetJarWebViewSubActivity:waitDialogHide	()V
      //   143: return
      //   144: iload 4
      //   146: iconst_1
      //   147: iadd
      //   148: istore 4
      //   150: goto -89 -> 61
      //   153: astore 12
      //   155: getstatic 240	com/getjar/sdk/logging/Area:REDEEM	Lcom/getjar/sdk/logging/Area;
      //   158: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   161: getstatic 107	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
      //   164: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   167: lor
      //   168: aload 12
      //   170: ldc -14
      //   172: iconst_0
      //   173: anewarray 4	java/lang/Object
      //   176: invokestatic 244	com/getjar/sdk/logging/Logger:d	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   179: aload 13
      //   181: astore 12
      //   183: goto -75 -> 108
      //   186: astore_1
      //   187: getstatic 101	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
      //   190: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   193: getstatic 107	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
      //   196: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   199: lor
      //   200: getstatic 110	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   203: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   206: lor
      //   207: aload_1
      //   208: ldc -99
      //   210: iconst_0
      //   211: anewarray 4	java/lang/Object
      //   214: invokestatic 126	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   217: aload_3
      //   218: aload_1
      //   219: invokevirtual 161	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
      //   222: aload_0
      //   223: getfield 17	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:this$0	Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;
      //   226: getfield 31	com/getjar/sdk/rewards/GetJarJavaScriptInterface:_parentActivity	Lcom/getjar/sdk/rewards/GetJarWebViewSubActivity;
      //   229: invokevirtual 36	com/getjar/sdk/rewards/GetJarWebViewSubActivity:waitDialogHide	()V
      //   232: return
      //   233: astore_1
      //   234: getstatic 101	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
      //   237: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   240: getstatic 107	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
      //   243: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   246: lor
      //   247: getstatic 110	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   250: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   253: lor
      //   254: aload_1
      //   255: ldc -99
      //   257: iconst_0
      //   258: anewarray 4	java/lang/Object
      //   261: invokestatic 126	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   264: aload_3
      //   265: aload_1
      //   266: invokevirtual 161	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
      //   269: return
      //   270: aload_0
      //   271: getfield 17	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:this$0	Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;
      //   274: getfield 31	com/getjar/sdk/rewards/GetJarJavaScriptInterface:_parentActivity	Lcom/getjar/sdk/rewards/GetJarWebViewSubActivity;
      //   277: invokevirtual 248	com/getjar/sdk/rewards/GetJarWebViewSubActivity:getParentActivity	()Landroid/app/Activity;
      //   280: invokevirtual 254	android/app/Activity:getApplicationContext	()Landroid/content/Context;
      //   283: aload 12
      //   285: invokestatic 260	com/getjar/sdk/utilities/IntentsUtility:getRedeemVoucherIntent	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
      //   288: astore 12
      //   290: getstatic 101	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
      //   293: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   296: lstore 6
      //   298: getstatic 107	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
      //   301: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   304: lstore 8
      //   306: getstatic 110	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   309: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   312: lstore 10
      //   314: aload_3
      //   315: ifnonnull +86 -> 401
      //   318: ldc 112
      //   320: astore_1
      //   321: lload 6
      //   323: lload 8
      //   325: lor
      //   326: lload 10
      //   328: lor
      //   329: ldc_w 262
      //   332: iconst_2
      //   333: anewarray 4	java/lang/Object
      //   336: dup
      //   337: iconst_0
      //   338: aload_2
      //   339: aastore
      //   340: dup
      //   341: iconst_1
      //   342: aload_1
      //   343: aastore
      //   344: invokestatic 120	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
      //   347: aload_0
      //   348: getfield 17	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:this$0	Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;
      //   351: aload 12
      //   353: invokevirtual 268	android/content/Intent:getExtras	()Landroid/os/Bundle;
      //   356: invokestatic 271	com/getjar/sdk/rewards/GetJarJavaScriptInterface:access$202	(Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;Landroid/os/Bundle;)Landroid/os/Bundle;
      //   359: pop
      //   360: new 132	android/os/Message
      //   363: dup
      //   364: invokespecial 133	android/os/Message:<init>	()V
      //   367: astore_1
      //   368: aload_1
      //   369: iconst_0
      //   370: putfield 137	android/os/Message:what	I
      //   373: aload_0
      //   374: getfield 17	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:this$0	Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;
      //   377: invokestatic 141	com/getjar/sdk/rewards/GetJarJavaScriptInterface:access$600	(Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;)Landroid/os/Handler;
      //   380: aload_1
      //   381: invokevirtual 147	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   384: pop
      //   385: goto -252 -> 133
      //   388: astore_1
      //   389: aload_0
      //   390: getfield 17	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:this$0	Lcom/getjar/sdk/rewards/GetJarJavaScriptInterface;
      //   393: getfield 31	com/getjar/sdk/rewards/GetJarJavaScriptInterface:_parentActivity	Lcom/getjar/sdk/rewards/GetJarWebViewSubActivity;
      //   396: invokevirtual 36	com/getjar/sdk/rewards/GetJarWebViewSubActivity:waitDialogHide	()V
      //   399: aload_1
      //   400: athrow
      //   401: aload_3
      //   402: invokevirtual 152	com/getjar/sdk/comm/CommContext:getCommContextId	()Ljava/lang/String;
      //   405: astore_1
      //   406: goto -85 -> 321
      //   409: aload_0
      //   410: aload_1
      //   411: new 232	com/getjar/sdk/exceptions/ServiceException
      //   414: dup
      //   415: aload 14
      //   417: aload_1
      //   418: invokespecial 235	com/getjar/sdk/exceptions/ServiceException:<init>	(Ljava/lang/String;Lcom/getjar/sdk/comm/Result;)V
      //   421: aload_2
      //   422: aload_3
      //   423: invokevirtual 237	com/getjar/sdk/rewards/GetJarJavaScriptInterface$PurchaseCallback:serviceRequestFailed	(Lcom/getjar/sdk/comm/Result;Ljava/lang/Exception;Ljava/lang/String;Lcom/getjar/sdk/comm/CommContext;)V
      //   426: goto -293 -> 133
      //   429: astore_1
      //   430: getstatic 101	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
      //   433: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   436: getstatic 107	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
      //   439: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   442: lor
      //   443: getstatic 110	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   446: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   449: lor
      //   450: aload_1
      //   451: ldc -99
      //   453: iconst_0
      //   454: anewarray 4	java/lang/Object
      //   457: invokestatic 126	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   460: aload_3
      //   461: aload_1
      //   462: invokevirtual 161	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
      //   465: return
      //   466: astore_2
      //   467: getstatic 101	com/getjar/sdk/logging/Area:JS_API	Lcom/getjar/sdk/logging/Area;
      //   470: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   473: getstatic 107	com/getjar/sdk/logging/Area:PURCHASE	Lcom/getjar/sdk/logging/Area;
      //   476: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   479: lor
      //   480: getstatic 110	com/getjar/sdk/logging/Area:TRANSACTION	Lcom/getjar/sdk/logging/Area;
      //   483: invokevirtual 104	com/getjar/sdk/logging/Area:value	()J
      //   486: lor
      //   487: aload_2
      //   488: ldc -99
      //   490: iconst_0
      //   491: anewarray 4	java/lang/Object
      //   494: invokestatic 126	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   497: aload_3
      //   498: aload_2
      //   499: invokevirtual 161	com/getjar/sdk/comm/CommContext:addException	(Ljava/lang/Throwable;)V
      //   502: goto -103 -> 399
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	505	0	this	PurchaseCallback
      //   0	505	1	paramResult	Result
      //   0	505	2	paramString	String
      //   0	505	3	paramCommContext	CommContext
      //   59	90	4	i	int
      //   23	3	5	bool	boolean
      //   296	26	6	l1	long
      //   304	20	8	l2	long
      //   312	15	10	l3	long
      //   63	46	12	localObject1	Object
      //   153	16	12	localJSONException	JSONException
      //   181	171	12	localObject2	Object
      //   31	149	13	localObject3	Object
      //   10	406	14	str	String
      //   56	20	15	localJSONArray	JSONArray
      // Exception table:
      //   from	to	target	type
      //   33	58	153	org/json/JSONException
      //   65	108	153	org/json/JSONException
      //   0	25	186	java/lang/Exception
      //   33	58	186	java/lang/Exception
      //   65	108	186	java/lang/Exception
      //   108	133	186	java/lang/Exception
      //   155	179	186	java/lang/Exception
      //   270	314	186	java/lang/Exception
      //   321	385	186	java/lang/Exception
      //   401	406	186	java/lang/Exception
      //   409	426	186	java/lang/Exception
      //   222	232	233	java/lang/Exception
      //   0	25	388	finally
      //   33	58	388	finally
      //   65	108	388	finally
      //   108	133	388	finally
      //   155	179	388	finally
      //   187	222	388	finally
      //   270	314	388	finally
      //   321	385	388	finally
      //   401	406	388	finally
      //   409	426	388	finally
      //   133	143	429	java/lang/Exception
      //   389	399	466	java/lang/Exception
    }
  }
  
  private class ReauthThread
    implements Runnable
  {
    private ReauthThread() {}
    
    public void run()
    {
      try
      {
        AuthManager.initialize(GetJarJavaScriptInterface.this._commContext.getApplicationContext());
        AuthManager.getInstance().reAuthWithUI(GetJarJavaScriptInterface.this._parentActivity);
        GetJarJavaScriptInterface.this._parentActivity.waitForAuthorization();
        return;
      }
      catch (Exception localException)
      {
        Logger.e(Area.JS_API.value() | Area.AUTH.value(), localException, "JavaScriptAPI: ReauthThread.run() failed", new Object[0]);
        return;
      }
      finally
      {
        GetJarJavaScriptInterface.this._parentActivity.waitDialogHide();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarJavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */