package com.facebook.ads.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONTokener;

public class AdRequest {
    private static final String ADS_ENDPOINT = "network_ads";
    private static final String AD_TYPE_PARAM = "ad_type";
    private static final String APP_BUILD_PARAM = "app_build";
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String ATTRIBUTION_ID_PARAM = "attribution_id";
    private static final String CHILD_DIRECTED_PARAM = "child_directed";
    private static final String DEFAULT_ENCODING = "utf-8";
    private static final String DEVICE_ID_PARAM = "device_id";
    private static final String DEVICE_ID_TRACKING_ENABLED_PARAM = "tracking_enabled";
    private static final String GRAPH_URL_BASE = "https://graph.facebook.com";
    private static final String GRAPH_URL_BASE_PREFIX_FORMAT = "http://graph.%s.facebook.com";
    private static final String HEIGHT_PARAM = "height";
    private static final String LOCALE_PARAM = "locale";
    private static final String NATIVE_ADS_ENDPOINT = "network_ads_native";
    private static final String OS = "Android";
    private static final String OS_PARAM = "os";
    private static final String OS_VERSION_PARAM = "os_version";
    private static final String PACKAGE_NAME_PARAM = "package_name";
    private static final String PLACEMENT_ID_PARAM = "placement_id";
    private static final String SCREEN_HEIGHT_PARAM = "screen_height";
    private static final String SCREEN_WIDTH_PARAM = "screen_width";
    private static final String SDK_CAPABILITIES_PARAM = "sdk_capabilities";
    private static final String SDK_VERSION = "sdk_version";
    private static final String TAG = AdRequest.class.getSimpleName();
    private static final String TEST_MODE_PARAM = "test_mode";
    private static final String WIDTH_PARAM = "width";
    private final AdSize adSize;
    private final AdType adType;
    private final AdRequest.Callback callback;
    private final Context context;
    private final String placementId;
    private final boolean testMode;
    private final String userAgentString;

    public AdRequest(Context paramContext, String paramString, AdSize paramAdSize, AdType paramAdType, boolean paramBoolean, AdRequest.Callback paramCallback) {
        if ((paramString == null) || (paramString.length() < 1)) {
            throw new IllegalArgumentException("placementId");
        }
        if (paramAdSize == null) {
            throw new IllegalArgumentException("adSize");
        }
        if (paramCallback == null) {
            throw new IllegalArgumentException("callback");
        }
        this.context = paramContext;
        this.placementId = paramString;
        this.adSize = paramAdSize;
        this.userAgentString = AdWebViewUtils.getUserAgentString(paramContext);
        this.adType = paramAdType;
        this.testMode = paramBoolean;
        this.callback = paramCallback;
    }

    private void addAdvertisingInfoParams(Map<String, Object> paramMap) {
        boolean bool = true;
        AdvertisingIdInfo localAdvertisingIdInfo = AdvertisingIdInfo.getAdvertisingIdInfo(this.context);
        if (localAdvertisingIdInfo == null) {
            paramMap.put("tracking_enabled", Boolean.valueOf(true));
            return;
        }
        if (!localAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
        }
        for (; ; ) {
            paramMap.put("tracking_enabled", Boolean.valueOf(bool));
            if (localAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
                break;
            }
            paramMap.put("device_id", localAdvertisingIdInfo.getId());
            return;
            bool = false;
        }
    }

    private void addAppInfoParams(Map<String, Object> paramMap) {
        paramMap.put("package_name", this.context.getPackageName());
    }

    private void addDeviceInfoParams(Map<String, Object> paramMap) {
        paramMap.put("os", "Android");
        paramMap.put("os_version", Build.VERSION.RELEASE);
        Object localObject = this.context.getResources().getDisplayMetrics();
        int i = (int) (((DisplayMetrics) localObject).widthPixels / ((DisplayMetrics) localObject).density);
        int j = (int) (((DisplayMetrics) localObject).heightPixels / ((DisplayMetrics) localObject).density);
        paramMap.put("screen_width", Integer.valueOf(i));
        paramMap.put("screen_height", Integer.valueOf(j));
        try {
            localObject = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            paramMap.put("app_build", Integer.valueOf(((PackageInfo) localObject).versionCode));
            paramMap.put("app_version", ((PackageInfo) localObject).versionName);
            Locale localLocale = this.context.getResources().getConfiguration().locale;
            localObject = localLocale;
            if (localLocale == null) {
                localObject = Locale.getDefault();
            }
            paramMap.put("locale", ((Locale) localObject).toString());
            return;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            for (; ; ) {
                paramMap.put("app_version", Integer.valueOf(0));
            }
        }
    }

    private AdRequest.AdRequestResponse createResponsesFromStream(InputStream paramInputStream) {
        AdRequest.AdRequestResponse localAdRequestResponse = new AdRequest.AdRequestResponse(null);
        try {
            paramInputStream = new JSONTokener(AdUtilities.readStreamToString(paramInputStream)).nextValue();
            if ((paramInputStream instanceof JSONObject)) {
                paramInputStream = (JSONObject) paramInputStream;
                if (!paramInputStream.has("error")) {
                    break label100;
                }
                paramInputStream = (JSONObject) AdUtilities.getStringPropertyAsJSON(paramInputStream, "error");
            }
            for (localAdRequestResponse.error = new AdError(paramInputStream.optInt("code", -1), paramInputStream.optString("message", null)); (localAdRequestResponse.body == null) && (localAdRequestResponse.error == null); localAdRequestResponse.error = null) {
                return null;
                label100:
                localAdRequestResponse.body = paramInputStream;
            }
        } catch (Exception paramInputStream) {
            for (; ; ) {
                localAdRequestResponse.error = new AdError(-1, paramInputStream.getMessage());
            }
        }
        return localAdRequestResponse;
    }

    private String getAdsEndpoint() {
        switch (AdRequest .2.$SwitchMap$com$facebook$ads$internal$AdType[this.adType.ordinal()])
        {
            default:
                return "network_ads";
        }
        return "network_ads_native";
    }

    private String getQueryString(Map<String, Object> paramMap) {
        StringBuilder localStringBuilder = new StringBuilder(512);
        paramMap = paramMap.entrySet().iterator();
        int i = 1;
        if (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            if (i != 0) {
                i = 0;
            }
            for (; ; ) {
                localStringBuilder.append(URLEncoder.encode((String) localEntry.getKey(), "utf-8")).append("=").append(URLEncoder.encode(String.valueOf(localEntry.getValue()), "utf-8"));
                break;
                localStringBuilder.append("&");
            }
        }
        return localStringBuilder.toString();
    }

    private Map<String, Object> getRequestParameters() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ad_type", Integer.valueOf(this.adType.getValue()));
        localHashMap.put("sdk_capabilities", AdSdkCapability.getSupportedCapabilitiesAsJSONString());
        localHashMap.put("sdk_version", "3.14.1");
        localHashMap.put("placement_id", this.placementId);
        localHashMap.put("attribution_id", AdUtilities.getAttributionId(this.context.getContentResolver()));
        localHashMap.put("width", Integer.valueOf(this.adSize.getWidth()));
        localHashMap.put("height", Integer.valueOf(this.adSize.getHeight()));
        localHashMap.put("test_mode", Boolean.valueOf(this.testMode));
        localHashMap.put("child_directed", Boolean.valueOf(AdSettings.isChildDirected()));
        addDeviceInfoParams(localHashMap);
        addAppInfoParams(localHashMap);
        addAdvertisingInfoParams(localHashMap);
        return localHashMap;
    }

    private URL getUrlForRequest() {
        String str = AdSettings.getUrlPrefix();
        if (StringUtils.isNullOrEmpty(str)) {
        }
        for (str = "https://graph.facebook.com"; ; str = String.format("http://graph.%s.facebook.com", new Object[]{str})) {
            return new URL(String.format("%s/%s", new Object[]{str, getAdsEndpoint()}));
        }
    }

    private HttpURLConnection makeRequest() {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection) getUrlForRequest().openConnection();
        localHttpURLConnection.setRequestProperty("User-Agent", this.userAgentString);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setConnectTimeout(0);
        localHttpURLConnection.setReadTimeout(0);
        String str = getQueryString(getRequestParameters());
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localBufferedOutputStream, "utf-8"));
        localBufferedWriter.write(str);
        localBufferedWriter.flush();
        localBufferedWriter.close();
        localBufferedOutputStream.close();
        localHttpURLConnection.connect();
        return localHttpURLConnection;
    }

    public AsyncTask executeAsync() {
        AdAnalogData.startUpdate(this.context);
        return new AdRequest .1 (this).execute(new Void[0]);
    }

    /* Error */
    public AdRequest.AdRequestResponse executeConnectionAndWait() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore_3
        //   5: aconst_null
        //   6: astore_2
        //   7: aconst_null
        //   8: astore 6
        //   10: aconst_null
        //   11: astore_1
        //   12: aload_0
        //   13: invokespecial 540	com/facebook/ads/internal/AdRequest:makeRequest	()Ljava/net/HttpURLConnection;
        //   16: astore 4
        //   18: aload 4
        //   20: astore_1
        //   21: aload_1
        //   22: astore 4
        //   24: aload_2
        //   25: astore_3
        //   26: aload 6
        //   28: astore 5
        //   30: aload_1
        //   31: invokevirtual 543	java/net/HttpURLConnection:getResponseCode	()I
        //   34: sipush 400
        //   37: if_icmplt +53 -> 90
        //   40: aload_1
        //   41: astore 4
        //   43: aload_2
        //   44: astore_3
        //   45: aload 6
        //   47: astore 5
        //   49: aload_1
        //   50: invokevirtual 547	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
        //   53: astore_2
        //   54: aload_1
        //   55: astore 4
        //   57: aload_2
        //   58: astore_3
        //   59: aload_2
        //   60: astore 5
        //   62: aload_0
        //   63: aload_2
        //   64: invokespecial 549	com/facebook/ads/internal/AdRequest:createResponsesFromStream	(Ljava/io/InputStream;)Lcom/facebook/ads/internal/AdRequest$AdRequestResponse;
        //   67: astore 6
        //   69: aload 6
        //   71: astore_3
        //   72: aload_2
        //   73: invokestatic 553	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   76: aload_3
        //   77: astore_2
        //   78: aload_1
        //   79: ifnull +9 -> 88
        //   82: aload_1
        //   83: invokevirtual 556	java/net/HttpURLConnection:disconnect	()V
        //   86: aload_3
        //   87: astore_2
        //   88: aload_2
        //   89: areturn
        //   90: aload_1
        //   91: astore 4
        //   93: aload_2
        //   94: astore_3
        //   95: aload 6
        //   97: astore 5
        //   99: aload_1
        //   100: invokevirtual 559	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   103: astore_2
        //   104: goto -50 -> 54
        //   107: astore_3
        //   108: aconst_null
        //   109: astore_2
        //   110: new 259	com/facebook/ads/internal/AdRequest$AdRequestResponse
        //   113: dup
        //   114: aconst_null
        //   115: invokespecial 262	com/facebook/ads/internal/AdRequest$AdRequestResponse:<init>	(Lcom/facebook/ads/internal/AdRequest$1;)V
        //   118: astore 4
        //   120: aload 4
        //   122: new 289	com/facebook/ads/AdError
        //   125: dup
        //   126: iconst_m1
        //   127: aload_3
        //   128: invokevirtual 560	java/io/IOException:getMessage	()Ljava/lang/String;
        //   131: invokespecial 304	com/facebook/ads/AdError:<init>	(ILjava/lang/String;)V
        //   134: putfield 307	com/facebook/ads/internal/AdRequest$AdRequestResponse:error	Lcom/facebook/ads/AdError;
        //   137: aload_2
        //   138: invokestatic 553	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   141: aload 4
        //   143: astore_2
        //   144: aload_1
        //   145: ifnull -57 -> 88
        //   148: aload_1
        //   149: invokevirtual 556	java/net/HttpURLConnection:disconnect	()V
        //   152: aload 4
        //   154: areturn
        //   155: astore_2
        //   156: aconst_null
        //   157: astore_1
        //   158: aload_1
        //   159: astore 4
        //   161: aload 5
        //   163: astore_3
        //   164: getstatic 103	com/facebook/ads/internal/AdRequest:TAG	Ljava/lang/String;
        //   167: ldc_w 562
        //   170: aload_2
        //   171: invokestatic 568	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   174: pop
        //   175: aload_1
        //   176: astore 4
        //   178: aload 5
        //   180: astore_3
        //   181: new 259	com/facebook/ads/internal/AdRequest$AdRequestResponse
        //   184: dup
        //   185: aconst_null
        //   186: invokespecial 262	com/facebook/ads/internal/AdRequest$AdRequestResponse:<init>	(Lcom/facebook/ads/internal/AdRequest$1;)V
        //   189: astore 6
        //   191: aload_1
        //   192: astore 4
        //   194: aload 5
        //   196: astore_3
        //   197: aload 6
        //   199: getstatic 571	com/facebook/ads/AdError:INTERNAL_ERROR	Lcom/facebook/ads/AdError;
        //   202: putfield 307	com/facebook/ads/internal/AdRequest$AdRequestResponse:error	Lcom/facebook/ads/AdError;
        //   205: aload 5
        //   207: invokestatic 553	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   210: aload 6
        //   212: astore_2
        //   213: aload_1
        //   214: ifnull -126 -> 88
        //   217: aload_1
        //   218: invokevirtual 556	java/net/HttpURLConnection:disconnect	()V
        //   221: aload 6
        //   223: areturn
        //   224: astore_1
        //   225: aconst_null
        //   226: astore 4
        //   228: aload_3
        //   229: invokestatic 553	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   232: aload 4
        //   234: ifnull +8 -> 242
        //   237: aload 4
        //   239: invokevirtual 556	java/net/HttpURLConnection:disconnect	()V
        //   242: aload_1
        //   243: athrow
        //   244: astore_1
        //   245: goto -17 -> 228
        //   248: astore_3
        //   249: aload_1
        //   250: astore 4
        //   252: aload_3
        //   253: astore_1
        //   254: aload_2
        //   255: astore_3
        //   256: goto -28 -> 228
        //   259: astore_2
        //   260: goto -102 -> 158
        //   263: astore_3
        //   264: aconst_null
        //   265: astore_2
        //   266: goto -156 -> 110
        //   269: astore_3
        //   270: goto -160 -> 110
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	273	0	this	AdRequest
        //   11	207	1	localObject1	Object
        //   224	19	1	localObject2	Object
        //   244	6	1	localObject3	Object
        //   253	1	1	localObject4	Object
        //   6	138	2	localObject5	Object
        //   155	16	2	localException1	Exception
        //   212	43	2	localObject6	Object
        //   259	1	2	localException2	Exception
        //   265	1	2	localObject7	Object
        //   4	91	3	localObject8	Object
        //   107	21	3	localIOException1	java.io.IOException
        //   163	66	3	localObject9	Object
        //   248	5	3	localObject10	Object
        //   255	1	3	localObject11	Object
        //   263	1	3	localIOException2	java.io.IOException
        //   269	1	3	localIOException3	java.io.IOException
        //   16	235	4	localObject12	Object
        //   1	205	5	localObject13	Object
        //   8	214	6	localAdRequestResponse	AdRequest.AdRequestResponse
        // Exception table:
        //   from	to	target	type
        //   12	18	107	java/io/IOException
        //   12	18	155	java/lang/Exception
        //   12	18	224	finally
        //   30	40	244	finally
        //   49	54	244	finally
        //   62	69	244	finally
        //   99	104	244	finally
        //   164	175	244	finally
        //   181	191	244	finally
        //   197	205	244	finally
        //   110	137	248	finally
        //   30	40	259	java/lang/Exception
        //   49	54	259	java/lang/Exception
        //   62	69	259	java/lang/Exception
        //   99	104	259	java/lang/Exception
        //   30	40	263	java/io/IOException
        //   49	54	263	java/io/IOException
        //   99	104	263	java/io/IOException
        //   62	69	269	java/io/IOException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */