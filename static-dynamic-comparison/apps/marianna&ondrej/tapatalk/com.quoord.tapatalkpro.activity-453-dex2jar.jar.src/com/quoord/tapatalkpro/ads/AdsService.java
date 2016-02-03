package com.quoord.tapatalkpro.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import com.amazon.device.ads.AdRegistration;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdsService {
    public static String AMAZON_KEY;
    public static int SHOWADMODE;
    public static int SHOWNATIVE;
    public static boolean adLeavel;
    public static HashMap<Integer, ArrayList<AdBean>> adsLatestList;
    public static HashMap<Integer, ArrayList<AdBean>> adsList = new HashMap();
    public static HashMap<Integer, ArrayList<FlurryAdbean>> banersList;
    private static HttpClient httpClient;
    private static HttpParams httpParams;
    public static boolean isAddon;
    private static boolean isInitAmazonKey = false;
    private static int numPt;
    public static int perAds;
    public static String visitor;

    static {
        adsLatestList = new HashMap();
        banersList = new HashMap();
        visitor = null;
        isAddon = true;
        perAds = 20;
        SHOWNATIVE = 0;
        SHOWADMODE = 1;
        AMAZON_KEY = "4658325054474e4b4c4541394c4a5533";
        adLeavel = false;
        numPt = 0;
    }

    public static String GetIpAddress() {
        try {
            localObject1 = NetworkInterface.getNetworkInterfaces();
            boolean bool = ((Enumeration) localObject1).hasMoreElements();
            if (bool) {
                break label18;
            }
        } catch (Exception localException) {
            for (; ; ) {
                Object localObject1;
                label18:
                Object localObject2;
                InetAddress localInetAddress;
                localException.printStackTrace();
            }
        }
        return "";
        localObject2 = (NetworkInterface) ((Enumeration) localObject1).nextElement();
        System.out.println("DisplayName:" + ((NetworkInterface) localObject2).getDisplayName());
        System.out.println("Name:" + ((NetworkInterface) localObject2).getName());
        localObject2 = ((NetworkInterface) localObject2).getInetAddresses();
        do {
            if (!((Enumeration) localObject2).hasMoreElements()) {
                break;
            }
            localInetAddress = (InetAddress) ((Enumeration) localObject2).nextElement();
        } while (localInetAddress.isLoopbackAddress());
        localObject1 = localInetAddress.getHostAddress();
        return (String) localObject1;
    }

    public static void addAdsByPt(Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ForumStatus paramForumStatus) {
        if (isAddon) {
        }
        switch (paramInt1) {
            case 3:
            default:
                return;
            case 2:
                doTaskPT(paramActivity, 1, paramString, paramBoolean, Integer.valueOf(paramInt2), false, paramForumStatus);
                return;
        }
        doTaskPT(paramActivity, 1, paramString, paramBoolean, Integer.valueOf(paramInt2), true, paramForumStatus);
    }

    private static boolean checkAdList(HashMap<Integer, ArrayList<AdBean>> paramHashMap) {
        return (paramHashMap != null) && (paramHashMap.size() > 0);
    }

    public static void doGetBanner(final Activity paramActivity, int paramInt1, int paramInt2, final ForumStatus paramForumStatus) {
        int i;
        if (paramInt2 != 0) {
            i = 0;
        }
        for (; ; ) {
            if (i >= paramInt1) {
                return;
            }
            new Thread() {
                /* Error */
                public void run() {
                    // Byte code:
                    //   0: ldc 34
                    //   2: aload_0
                    //   3: getfield 19	com/quoord/tapatalkpro/ads/AdsService$2:val$fId	I
                    //   6: aload_0
                    //   7: getfield 21	com/quoord/tapatalkpro/ads/AdsService$2:val$context	Landroid/app/Activity;
                    //   10: aload_0
                    //   11: getfield 23	com/quoord/tapatalkpro/ads/AdsService$2:val$forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
                    //   14: invokestatic 38	com/quoord/tapatalkpro/ads/AdsService:getBannerAds	(Ljava/lang/String;ILandroid/app/Activity;Lcom/quoord/tapatalkpro/bean/ForumStatus;)Ljava/lang/String;
                    //   17: astore 5
                    //   19: new 40	com/quoord/tapatalkpro/ads/FlurryAdbean
                    //   22: dup
                    //   23: invokespecial 41	com/quoord/tapatalkpro/ads/FlurryAdbean:<init>	()V
                    //   26: astore 6
                    //   28: new 43	org/json/JSONObject
                    //   31: dup
                    //   32: aload 5
                    //   34: invokespecial 46	org/json/JSONObject:<init>	(Ljava/lang/String;)V
                    //   37: astore 7
                    //   39: aload 7
                    //   41: ldc 48
                    //   43: invokevirtual 52	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
                    //   46: ldc 54
                    //   48: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   51: astore 5
                    //   53: aload_0
                    //   54: getfield 21	com/quoord/tapatalkpro/ads/AdsService$2:val$context	Landroid/app/Activity;
                    //   57: invokestatic 64	com/quoord/tapatalkpro/ics/slidingMenu/SettingsFragment:getVisitorStoredTime	(Landroid/content/Context;)J
                    //   60: lstore_1
                    //   61: invokestatic 70	java/lang/System:currentTimeMillis	()J
                    //   64: lstore_3
                    //   65: lload_3
                    //   66: lload_1
                    //   67: lsub
                    //   68: ldc2_w 71
                    //   71: ldiv
                    //   72: ldc2_w 73
                    //   75: lcmp
                    //   76: iflt +899 -> 975
                    //   79: aload_0
                    //   80: getfield 21	com/quoord/tapatalkpro/ads/AdsService$2:val$context	Landroid/app/Activity;
                    //   83: invokestatic 80	com/quoord/tapatalkpro/util/Prefs:get	(Landroid/content/Context;)Landroid/content/SharedPreferences;
                    //   86: invokeinterface 86 1 0
                    //   91: astore 8
                    //   93: aload 8
                    //   95: ldc 88
                    //   97: aload 5
                    //   99: invokeinterface 94 3 0
                    //   104: pop
                    //   105: aload 8
                    //   107: ldc 96
                    //   109: lload_3
                    //   110: invokeinterface 100 4 0
                    //   115: pop
                    //   116: aload 8
                    //   118: invokeinterface 104 1 0
                    //   123: pop
                    //   124: aload 5
                    //   126: putstatic 108	com/quoord/tapatalkpro/ads/AdsService:visitor	Ljava/lang/String;
                    //   129: aload 7
                    //   131: ldc 110
                    //   133: invokevirtual 52	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
                    //   136: astore 5
                    //   138: new 112	com/quoord/tools/net/JSONUtil
                    //   141: dup
                    //   142: aload 5
                    //   144: invokespecial 115	com/quoord/tools/net/JSONUtil:<init>	(Lorg/json/JSONObject;)V
                    //   147: astore 8
                    //   149: aload 6
                    //   151: aload 8
                    //   153: ldc 117
                    //   155: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   158: invokevirtual 123	com/quoord/tapatalkpro/ads/FlurryAdbean:setTitle	(Ljava/lang/String;)V
                    //   161: aload 6
                    //   163: iconst_0
                    //   164: invokevirtual 127	com/quoord/tapatalkpro/ads/FlurryAdbean:setPostRelease	(Z)V
                    //   167: aload 6
                    //   169: aload 8
                    //   171: ldc -127
                    //   173: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   176: invokevirtual 132	com/quoord/tapatalkpro/ads/FlurryAdbean:setAuthor	(Ljava/lang/String;)V
                    //   179: aload 6
                    //   181: aload 8
                    //   183: ldc -122
                    //   185: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   188: invokevirtual 137	com/quoord/tapatalkpro/ads/FlurryAdbean:setAuthorUrl	(Ljava/lang/String;)V
                    //   191: aload 6
                    //   193: aload 8
                    //   195: ldc -117
                    //   197: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   200: invokevirtual 142	com/quoord/tapatalkpro/ads/FlurryAdbean:setAuthorImg	(Ljava/lang/String;)V
                    //   203: aload 6
                    //   205: aload 8
                    //   207: ldc -112
                    //   209: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   212: invokevirtual 147	com/quoord/tapatalkpro/ads/FlurryAdbean:setViews	(Ljava/lang/String;)V
                    //   215: aload 6
                    //   217: aload 8
                    //   219: ldc -107
                    //   221: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   224: invokevirtual 152	com/quoord/tapatalkpro/ads/FlurryAdbean:setPrimaryImpressionPixelUrl	(Ljava/lang/String;)V
                    //   227: aload 6
                    //   229: aload 8
                    //   231: ldc -102
                    //   233: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   236: invokevirtual 157	com/quoord/tapatalkpro/ads/FlurryAdbean:setSecondaryImpressionPixelUrl	(Ljava/lang/String;)V
                    //   239: aload 6
                    //   241: aload 8
                    //   243: ldc -97
                    //   245: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   248: invokevirtual 162	com/quoord/tapatalkpro/ads/FlurryAdbean:setThirdPartyTrackingPixelUrl	(Ljava/lang/String;)V
                    //   251: aload 6
                    //   253: aload 8
                    //   255: ldc -92
                    //   257: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   260: invokevirtual 167	com/quoord/tapatalkpro/ads/FlurryAdbean:setPermanentLink	(Ljava/lang/String;)V
                    //   263: aload 6
                    //   265: aload 8
                    //   267: ldc -87
                    //   269: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   272: invokevirtual 172	com/quoord/tapatalkpro/ads/FlurryAdbean:setTrackShareLink	(Ljava/lang/String;)V
                    //   275: aload 6
                    //   277: aload 8
                    //   279: ldc -82
                    //   281: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   284: invokevirtual 177	com/quoord/tapatalkpro/ads/FlurryAdbean:setSecondaryImpThirdPartyTrackingPixelUrl	(Ljava/lang/String;)V
                    //   287: aload 6
                    //   289: aload 8
                    //   291: ldc -77
                    //   293: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   296: invokevirtual 182	com/quoord/tapatalkpro/ads/FlurryAdbean:setVideoTrackingPixelUrl	(Ljava/lang/String;)V
                    //   299: aload 6
                    //   301: aload 8
                    //   303: ldc -72
                    //   305: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   308: invokevirtual 187	com/quoord/tapatalkpro/ads/FlurryAdbean:setTargetUrl	(Ljava/lang/String;)V
                    //   311: aload 6
                    //   313: aload 8
                    //   315: ldc -67
                    //   317: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   320: invokevirtual 192	com/quoord/tapatalkpro/ads/FlurryAdbean:setViewInApp	(Ljava/lang/String;)V
                    //   323: aload 6
                    //   325: aload 8
                    //   327: ldc -62
                    //   329: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   332: invokevirtual 197	com/quoord/tapatalkpro/ads/FlurryAdbean:setBannerURL	(Ljava/lang/String;)V
                    //   335: aload 6
                    //   337: aload 8
                    //   339: ldc -57
                    //   341: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   344: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   347: invokevirtual 211	com/quoord/tapatalkpro/ads/FlurryAdbean:setFlurry	(Z)V
                    //   350: aload 6
                    //   352: aload 8
                    //   354: ldc -43
                    //   356: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   359: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   362: invokevirtual 216	com/quoord/tapatalkpro/ads/FlurryAdbean:setAmazon	(Z)V
                    //   365: aload 6
                    //   367: aload 8
                    //   369: ldc -38
                    //   371: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   374: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   377: invokevirtual 221	com/quoord/tapatalkpro/ads/FlurryAdbean:setMM	(Z)V
                    //   380: aload 6
                    //   382: aload 8
                    //   384: ldc -33
                    //   386: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   389: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   392: invokevirtual 226	com/quoord/tapatalkpro/ads/FlurryAdbean:setDfp	(Z)V
                    //   395: aload 6
                    //   397: aload 8
                    //   399: ldc -28
                    //   401: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   404: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   407: invokevirtual 231	com/quoord/tapatalkpro/ads/FlurryAdbean:setAdmobe	(Z)V
                    //   410: aload 6
                    //   412: aload 8
                    //   414: ldc -23
                    //   416: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   419: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   422: invokevirtual 236	com/quoord/tapatalkpro/ads/FlurryAdbean:setOpenX	(Z)V
                    //   425: aload 5
                    //   427: ldc -18
                    //   429: invokevirtual 242	org/json/JSONObject:has	(Ljava/lang/String;)Z
                    //   432: ifeq +32 -> 464
                    //   435: aload 5
                    //   437: ldc -18
                    //   439: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   442: ifnull +22 -> 464
                    //   445: aload 5
                    //   447: ldc -18
                    //   449: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   452: ldc -12
                    //   454: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
                    //   457: ifeq +7 -> 464
                    //   460: iconst_1
                    //   461: putstatic 253	com/quoord/tapatalkpro/ads/AdsService:adLeavel	Z
                    //   464: aload 6
                    //   466: new 246	java/lang/String
                    //   469: dup
                    //   470: aload 5
                    //   472: ldc -1
                    //   474: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   477: ldc_w 257
                    //   480: invokevirtual 261	java/lang/String:getBytes	(Ljava/lang/String;)[B
                    //   483: ldc_w 257
                    //   486: invokespecial 264	java/lang/String:<init>	([BLjava/lang/String;)V
                    //   489: invokevirtual 267	com/quoord/tapatalkpro/ads/FlurryAdbean:setBody	(Ljava/lang/String;)V
                    //   492: aload 5
                    //   494: ldc_w 269
                    //   497: invokevirtual 242	org/json/JSONObject:has	(Ljava/lang/String;)Z
                    //   500: ifeq +16 -> 516
                    //   503: aload 6
                    //   505: aload 8
                    //   507: ldc_w 269
                    //   510: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   513: invokevirtual 272	com/quoord/tapatalkpro/ads/FlurryAdbean:setMediation	(Ljava/lang/String;)V
                    //   516: aload 7
                    //   518: ldc_w 274
                    //   521: invokevirtual 242	org/json/JSONObject:has	(Ljava/lang/String;)Z
                    //   524: ifeq +383 -> 907
                    //   527: aload 7
                    //   529: ldc_w 274
                    //   532: invokevirtual 52	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
                    //   535: astore 8
                    //   537: new 112	com/quoord/tools/net/JSONUtil
                    //   540: dup
                    //   541: aload 8
                    //   543: invokespecial 115	com/quoord/tools/net/JSONUtil:<init>	(Lorg/json/JSONObject;)V
                    //   546: astore 9
                    //   548: new 40	com/quoord/tapatalkpro/ads/FlurryAdbean
                    //   551: dup
                    //   552: invokespecial 41	com/quoord/tapatalkpro/ads/FlurryAdbean:<init>	()V
                    //   555: astore 7
                    //   557: aload 7
                    //   559: aload 9
                    //   561: ldc 117
                    //   563: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   566: invokevirtual 123	com/quoord/tapatalkpro/ads/FlurryAdbean:setTitle	(Ljava/lang/String;)V
                    //   569: aload 7
                    //   571: iconst_0
                    //   572: invokevirtual 127	com/quoord/tapatalkpro/ads/FlurryAdbean:setPostRelease	(Z)V
                    //   575: aload 7
                    //   577: aload 9
                    //   579: ldc -127
                    //   581: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   584: invokevirtual 132	com/quoord/tapatalkpro/ads/FlurryAdbean:setAuthor	(Ljava/lang/String;)V
                    //   587: aload 7
                    //   589: aload 9
                    //   591: ldc -122
                    //   593: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   596: invokevirtual 137	com/quoord/tapatalkpro/ads/FlurryAdbean:setAuthorUrl	(Ljava/lang/String;)V
                    //   599: aload 7
                    //   601: aload 9
                    //   603: ldc -117
                    //   605: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   608: invokevirtual 142	com/quoord/tapatalkpro/ads/FlurryAdbean:setAuthorImg	(Ljava/lang/String;)V
                    //   611: aload 7
                    //   613: aload 9
                    //   615: ldc -112
                    //   617: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   620: invokevirtual 147	com/quoord/tapatalkpro/ads/FlurryAdbean:setViews	(Ljava/lang/String;)V
                    //   623: aload 7
                    //   625: aload 9
                    //   627: ldc -107
                    //   629: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   632: invokevirtual 152	com/quoord/tapatalkpro/ads/FlurryAdbean:setPrimaryImpressionPixelUrl	(Ljava/lang/String;)V
                    //   635: aload 7
                    //   637: aload 9
                    //   639: ldc -102
                    //   641: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   644: invokevirtual 157	com/quoord/tapatalkpro/ads/FlurryAdbean:setSecondaryImpressionPixelUrl	(Ljava/lang/String;)V
                    //   647: aload 7
                    //   649: aload 9
                    //   651: ldc -97
                    //   653: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   656: invokevirtual 162	com/quoord/tapatalkpro/ads/FlurryAdbean:setThirdPartyTrackingPixelUrl	(Ljava/lang/String;)V
                    //   659: aload 7
                    //   661: aload 9
                    //   663: ldc -92
                    //   665: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   668: invokevirtual 167	com/quoord/tapatalkpro/ads/FlurryAdbean:setPermanentLink	(Ljava/lang/String;)V
                    //   671: aload 7
                    //   673: aload 9
                    //   675: ldc -87
                    //   677: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   680: invokevirtual 172	com/quoord/tapatalkpro/ads/FlurryAdbean:setTrackShareLink	(Ljava/lang/String;)V
                    //   683: aload 7
                    //   685: aload 9
                    //   687: ldc -82
                    //   689: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   692: invokevirtual 177	com/quoord/tapatalkpro/ads/FlurryAdbean:setSecondaryImpThirdPartyTrackingPixelUrl	(Ljava/lang/String;)V
                    //   695: aload 7
                    //   697: aload 9
                    //   699: ldc -77
                    //   701: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   704: invokevirtual 182	com/quoord/tapatalkpro/ads/FlurryAdbean:setVideoTrackingPixelUrl	(Ljava/lang/String;)V
                    //   707: aload 7
                    //   709: aload 9
                    //   711: ldc -72
                    //   713: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   716: invokevirtual 187	com/quoord/tapatalkpro/ads/FlurryAdbean:setTargetUrl	(Ljava/lang/String;)V
                    //   719: aload 7
                    //   721: aload 9
                    //   723: ldc -67
                    //   725: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   728: invokevirtual 192	com/quoord/tapatalkpro/ads/FlurryAdbean:setViewInApp	(Ljava/lang/String;)V
                    //   731: aload 7
                    //   733: aload 9
                    //   735: ldc -62
                    //   737: invokevirtual 120	com/quoord/tools/net/JSONUtil:optString	(Ljava/lang/String;)Ljava/lang/String;
                    //   740: invokevirtual 197	com/quoord/tapatalkpro/ads/FlurryAdbean:setBannerURL	(Ljava/lang/String;)V
                    //   743: aload 7
                    //   745: aload 9
                    //   747: ldc -57
                    //   749: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   752: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   755: invokevirtual 211	com/quoord/tapatalkpro/ads/FlurryAdbean:setFlurry	(Z)V
                    //   758: aload 7
                    //   760: aload 9
                    //   762: ldc -43
                    //   764: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   767: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   770: invokevirtual 216	com/quoord/tapatalkpro/ads/FlurryAdbean:setAmazon	(Z)V
                    //   773: aload 7
                    //   775: aload 9
                    //   777: ldc -38
                    //   779: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   782: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   785: invokevirtual 221	com/quoord/tapatalkpro/ads/FlurryAdbean:setMM	(Z)V
                    //   788: aload 7
                    //   790: aload 9
                    //   792: ldc -33
                    //   794: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   797: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   800: invokevirtual 226	com/quoord/tapatalkpro/ads/FlurryAdbean:setDfp	(Z)V
                    //   803: aload 7
                    //   805: aload 9
                    //   807: ldc -28
                    //   809: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   812: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   815: invokevirtual 231	com/quoord/tapatalkpro/ads/FlurryAdbean:setAdmobe	(Z)V
                    //   818: aload 7
                    //   820: aload 9
                    //   822: ldc -23
                    //   824: invokevirtual 203	com/quoord/tools/net/JSONUtil:optBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
                    //   827: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
                    //   830: invokevirtual 236	com/quoord/tapatalkpro/ads/FlurryAdbean:setOpenX	(Z)V
                    //   833: aload 8
                    //   835: ldc -18
                    //   837: invokevirtual 242	org/json/JSONObject:has	(Ljava/lang/String;)Z
                    //   840: ifeq +32 -> 872
                    //   843: aload 8
                    //   845: ldc -18
                    //   847: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   850: ifnull +22 -> 872
                    //   853: aload 8
                    //   855: ldc -18
                    //   857: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   860: ldc -12
                    //   862: invokevirtual 249	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
                    //   865: ifeq +7 -> 872
                    //   868: iconst_1
                    //   869: putstatic 253	com/quoord/tapatalkpro/ads/AdsService:adLeavel	Z
                    //   872: aload 7
                    //   874: new 246	java/lang/String
                    //   877: dup
                    //   878: aload 5
                    //   880: ldc -1
                    //   882: invokevirtual 58	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
                    //   885: ldc_w 257
                    //   888: invokevirtual 261	java/lang/String:getBytes	(Ljava/lang/String;)[B
                    //   891: ldc_w 257
                    //   894: invokespecial 264	java/lang/String:<init>	([BLjava/lang/String;)V
                    //   897: invokevirtual 267	com/quoord/tapatalkpro/ads/FlurryAdbean:setBody	(Ljava/lang/String;)V
                    //   900: aload 6
                    //   902: aload 7
                    //   904: invokevirtual 278	com/quoord/tapatalkpro/ads/FlurryAdbean:setChildAdbean	(Lcom/quoord/tapatalkpro/ads/FlurryAdbean;)V
                    //   907: new 280	java/util/ArrayList
                    //   910: dup
                    //   911: invokespecial 281	java/util/ArrayList:<init>	()V
                    //   914: astore 5
                    //   916: getstatic 285	com/quoord/tapatalkpro/ads/AdsService:banersList	Ljava/util/HashMap;
                    //   919: aload_0
                    //   920: getfield 19	com/quoord/tapatalkpro/ads/AdsService$2:val$fId	I
                    //   923: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   926: invokevirtual 297	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
                    //   929: ifeq +21 -> 950
                    //   932: getstatic 285	com/quoord/tapatalkpro/ads/AdsService:banersList	Ljava/util/HashMap;
                    //   935: aload_0
                    //   936: getfield 19	com/quoord/tapatalkpro/ads/AdsService$2:val$fId	I
                    //   939: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   942: invokevirtual 300	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
                    //   945: checkcast 280	java/util/ArrayList
                    //   948: astore 5
                    //   950: aload 5
                    //   952: aload 6
                    //   954: invokevirtual 303	java/util/ArrayList:add	(Ljava/lang/Object;)Z
                    //   957: pop
                    //   958: getstatic 285	com/quoord/tapatalkpro/ads/AdsService:banersList	Ljava/util/HashMap;
                    //   961: aload_0
                    //   962: getfield 19	com/quoord/tapatalkpro/ads/AdsService$2:val$fId	I
                    //   965: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   968: aload 5
                    //   970: invokevirtual 307	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   973: pop
                    //   974: return
                    //   975: aload_0
                    //   976: getfield 21	com/quoord/tapatalkpro/ads/AdsService$2:val$context	Landroid/app/Activity;
                    //   979: invokestatic 311	com/quoord/tapatalkpro/ics/slidingMenu/SettingsFragment:getVisitor	(Landroid/content/Context;)Ljava/lang/String;
                    //   982: putstatic 108	com/quoord/tapatalkpro/ads/AdsService:visitor	Ljava/lang/String;
                    //   985: goto -856 -> 129
                    //   988: astore 5
                    //   990: iconst_0
                    //   991: putstatic 253	com/quoord/tapatalkpro/ads/AdsService:adLeavel	Z
                    //   994: ldc_w 313
                    //   997: ldc_w 315
                    //   1000: invokestatic 321	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
                    //   1003: pop
                    //   1004: return
                    //   1005: astore 9
                    //   1007: aload 9
                    //   1009: invokevirtual 324	java/io/UnsupportedEncodingException:printStackTrace	()V
                    //   1012: goto -520 -> 492
                    //   1015: astore 5
                    //   1017: aload 5
                    //   1019: invokevirtual 324	java/io/UnsupportedEncodingException:printStackTrace	()V
                    //   1022: goto -122 -> 900
                    //   1025: astore 5
                    //   1027: goto -37 -> 990
                    // Local variable table:
                    //   start	length	slot	name	signature
                    //   0	1030	0	this	2
                    //   60	7	1	l1	long
                    //   64	46	3	l2	long
                    //   17	952	5	localObject1	Object
                    //   988	1	5	localJSONException1	JSONException
                    //   1015	3	5	localUnsupportedEncodingException1	UnsupportedEncodingException
                    //   1025	1	5	localJSONException2	JSONException
                    //   26	927	6	localFlurryAdbean	FlurryAdbean
                    //   37	866	7	localObject2	Object
                    //   91	763	8	localObject3	Object
                    //   546	275	9	localJSONUtil	com.quoord.tools.net.JSONUtil
                    //   1005	3	9	localUnsupportedEncodingException2	UnsupportedEncodingException
                    // Exception table:
                    //   from	to	target	type
                    //   39	129	988	org/json/JSONException
                    //   129	464	988	org/json/JSONException
                    //   464	492	988	org/json/JSONException
                    //   492	516	988	org/json/JSONException
                    //   516	872	988	org/json/JSONException
                    //   872	900	988	org/json/JSONException
                    //   900	907	988	org/json/JSONException
                    //   907	916	988	org/json/JSONException
                    //   916	950	988	org/json/JSONException
                    //   950	974	988	org/json/JSONException
                    //   975	985	988	org/json/JSONException
                    //   1007	1012	988	org/json/JSONException
                    //   1017	1022	988	org/json/JSONException
                    //   464	492	1005	java/io/UnsupportedEncodingException
                    //   872	900	1015	java/io/UnsupportedEncodingException
                    //   28	39	1025	org/json/JSONException
                }
            }.start();
            i += 1;
        }
    }

    // todo this method would benefit from interproc analysis because the first parameter is an http string
    public static String doGetPT(String paramString1, String paramString2, Activity paramActivity, Integer paramInteger, ForumStatus paramForumStatus) {
        if ((paramString2 == null) || (paramString2.equals(""))) {
            return "";
        }
        paramString2 = new StringBuilder(String.valueOf(paramString1)).append("?fid=").append(URLEncoder.encode(paramString2)).toString() + "&tfid=" + paramInteger;
        paramString1 = paramString2;
        if (visitor != null) {
            paramString1 = paramString2;
            if (!visitor.equals("")) {
                paramString1 = paramString2 + "&prx_visitor=" + visitor;
            }
        }
        if (Util.googleAdsId != null) {
            paramString1 = paramString1 + "&device_id=" + Util.googleAdsId;
        }
        for (; ; ) {
            paramInteger = "android";
            paramString2 = "phone";
            if (Util.getDeviceSize(paramActivity) >= 7.0D) {
                paramInteger = "pad";
                paramString2 = "pad";
            }
            paramInteger = new StringBuilder(String.valueOf(paramString1)).append("&prx_agent=").append(paramInteger).append(Build.VERSION.SDK_INT).toString() + "&" + TapatalkApp.APP_KEY;
            int i = TapatalkIdFactory.getTapatalkId(paramActivity).getAuid();
            paramString1 = paramInteger;
            if (i != -1) {
                paramString1 = paramInteger + "&au_id=" + i;
            }
            paramString2 = paramString1 + "&device_type=" + paramString2;
            paramInteger = Prefs.get(paramActivity).getString("token", "");
            paramString1 = paramString2;
            if (!paramInteger.equals("")) {
                paramString1 = paramString2 + "&token=" + paramInteger;
            }
            paramString2 = paramString1 + "&locale=" + Util.getDeviceLocal(paramActivity);
            paramString1 = paramString2;
            if (paramForumStatus.getAdsDisabledGroup() != null) {
                paramString1 = paramString2;
                if (!paramForumStatus.getAdsDisabledGroup().equals("")) {
                    paramString1 = paramString2 + "&no_ad_usergroup=" + paramForumStatus.getAdsDisabledGroup();
                }
            }
            paramActivity = "";
            if (paramForumStatus.isLogin()) {
                paramString2 = paramActivity;
                if (paramForumStatus.getUserGroupId() != null) {
                    paramString2 = paramActivity;
                    if (paramForumStatus.getUserGroupId().size() > 0) {
                        i = 0;
                        paramString2 = paramActivity;
                        if (i < paramForumStatus.getUserGroupId().size()) {
                            break label605;
                        }
                    }
                }
                label473:
                paramActivity = paramString1;
                if (paramString2 != null) {
                    paramActivity = paramString1;
                    if (!paramString2.equals("")) {
                        paramActivity = paramString1 + "&in_usergroup=" + paramString2;
                    }
                }
                paramString1 = new HttpGet(paramActivity.replaceAll(" ", "%20"));
            }
            try {
                paramString1 = httpClient.execute(paramString1);
                if (paramString1.getStatusLine().getStatusCode() == 200) {
                    paramString1 = EntityUtils.toString(paramString1.getEntity());
                    return paramString1;
                    paramString1 = paramString1 + "&device_id=" + Util.getMD5(Util.getMacAddress(paramActivity));
                    continue;
                    label605:
                    if (i < paramForumStatus.getUserGroupId().size() - 1) {
                    }
                    for (paramString2 = paramString2 + (String) paramForumStatus.getUserGroupId().get(i) + ","; ; paramString2 = paramString2 + (String) paramForumStatus.getUserGroupId().get(i)) {
                        i += 1;
                        break;
                    }
                    paramString2 = paramForumStatus.getGuestGroupId();
                    break label473;
                } else {
                    paramString1 = "Error Response: " + paramString1.getStatusLine().toString();
                    return paramString1;
                }
            } catch (Exception paramString1) {
                return "doGetError";
            } catch (IOException paramString1) {
                return "doGetError";
            } catch (ClientProtocolException paramString1) {
            }
        }
        return "doGetError";
    }

    public static void doTaskPT(final Activity paramActivity, final int paramInt, String paramString, final boolean paramBoolean1, final Integer paramInteger, final boolean paramBoolean2, final ForumStatus paramForumStatus) {
        int i = 0;
        for (; ; ) {
            if (i >= paramInt) {
                return;
            }
            new Thread() {
                public void run() {
                    Object localObject1 = AdsService.doGetPT("https://pt.tapatalk.com/pt_get_ad.php", AdsService.this, paramActivity, paramInteger, paramForumStatus);
                    AdBean localAdBean = new AdBean();
                    for (; ; ) {
                        try {
                            localObject2 = new JSONObject((String) localObject1);
                        } catch (JSONException localJSONException1) {
                            Object localObject2;
                            long l1;
                            long l2;
                            ArrayList localArrayList;
                            continue;
                            continue;
                        }
                        try {
                            localObject1 = ((JSONObject) localObject2).getJSONObject("Ad");
                            localObject2 = ((JSONObject) localObject2).getJSONObject("Sys").getString("VisitorID");
                            l1 = SettingsFragment.getVisitorStoredTime(paramActivity);
                            l2 = System.currentTimeMillis();
                            if ((l2 - l1) / 1000L >= 2592000L) {
                                SharedPreferences.Editor localEditor = Prefs.get(paramActivity).edit();
                                localEditor.putString("prefernece.nativeads_vistorid", (String) localObject2);
                                localEditor.putLong("prefernece.nativeads_vistorid_stored_time", l2);
                                localEditor.commit();
                                AdsService.visitor = (String) localObject2;
                                localAdBean.setTitle(((JSONObject) localObject1).optString("Title"));
                                localAdBean.setPostRelease(false);
                                localAdBean.setAuthor(((JSONObject) localObject1).optString("Author"));
                                localAdBean.setAuthorUrl(((JSONObject) localObject1).optString("AuthorUrl"));
                                localAdBean.setAuthorImg(((JSONObject) localObject1).optString("AuthorImg"));
                                localAdBean.setViews(((JSONObject) localObject1).optString("Views"));
                                localAdBean.setPrimaryImpressionPixelUrl(((JSONObject) localObject1).optString("PrimaryImpressionPixelUrl"));
                                localAdBean.setSecondaryImpressionPixelUrl(((JSONObject) localObject1).optString("SecondaryImpressionPixelUrl"));
                                localAdBean.setThirdPartyTrackingPixelUrl(((JSONObject) localObject1).optString("ThirdPartyTrackingPixelUrl"));
                                localAdBean.setPermanentLink(((JSONObject) localObject1).optString("PermanentLink"));
                                localAdBean.setTrackShareLink(((JSONObject) localObject1).optString("TrackShareLink"));
                                localAdBean.setSecondaryImpThirdPartyTrackingPixelUrl(((JSONObject) localObject1).optString("SecondaryImpThirdPartyTrackingPixelUrl"));
                                localAdBean.setVideoTrackingPixelUrl(((JSONObject) localObject1).optString("VideoTrackingPixelUrl"));
                                localAdBean.setTargetUrl(((JSONObject) localObject1).optString("TargetUrl"));
                                localAdBean.setViewInApp(((JSONObject) localObject1).optString("ViewInApp"));
                            }
                        } catch (JSONException localJSONException2) {
                            continue;
                        }
                        try {
                            localAdBean.setBody(new String(((JSONObject) localObject1).getString("Body").getBytes("UTF-8"), "UTF-8"));
                            if ((AdsService.this != null) && (!AdsService.this.equals(""))) {
                                if (!paramBoolean1) {
                                    localObject1 = new ArrayList();
                                    if (AdsService.adsList.containsKey(paramInteger)) {
                                        localObject1 = (ArrayList) AdsService.adsList.get(paramInteger);
                                    }
                                    ((ArrayList) localObject1).add(localAdBean);
                                    AdsService.adsList.put(paramInteger, localObject1);
                                    AdsService.numPt += 1;
                                    if (AdsService.numPt == paramInt) {
                                        if (paramBoolean2) {
                                            if ((!paramBoolean1) || (AdsService.adsLatestList.size() != 0)) {
                                                continue;
                                            }
                                            AdsService.doTaskPT(paramActivity, paramInt, AdsService.this, paramBoolean1, paramInteger, false, paramForumStatus);
                                        }
                                        AdsService.numPt = 0;
                                    }
                                    return;
                                    AdsService.visitor = SettingsFragment.getVisitor(paramActivity);
                                }
                            }
                        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                            localUnsupportedEncodingException.printStackTrace();
                            continue;
                            localArrayList = new ArrayList();
                            if (AdsService.adsLatestList.containsKey(paramInteger)) {
                                localArrayList = (ArrayList) AdsService.adsLatestList.get(paramInteger);
                            }
                            localArrayList.add(localAdBean);
                            AdsService.adsLatestList.put(paramInteger, localArrayList);
                            continue;
                            if ((paramBoolean1) || (AdsService.adsList.size() != 0)) {
                                continue;
                            }
                            AdsService.doTaskPT(paramActivity, paramInt, AdsService.this, paramBoolean1, paramInteger, false, paramForumStatus);
                        }
                    }
                }
            }.start();
            i += 1;
        }
    }

    public static AdBean getAdBean(int paramInt) {
        if ((adsList.size() > 0) && (adsList.get(Integer.valueOf(paramInt)) != null) && (((ArrayList) adsList.get(Integer.valueOf(paramInt))).size() > 0)) {
            AdBean localAdBean = (AdBean) ((ArrayList) adsList.get(Integer.valueOf(paramInt))).get(0);
            ((ArrayList) adsList.get(Integer.valueOf(paramInt))).remove(0);
            adsList.put(Integer.valueOf(paramInt), (ArrayList) adsList.get(Integer.valueOf(paramInt)));
            return localAdBean;
        }
        return null;
    }

    public static FlurryAdbean getBanerBean(Activity paramActivity, int paramInt, ForumStatus paramForumStatus) {
        if (!isInitAmazonKey) {
            initAmazonAdsKey(paramActivity);
        }
        if ((banersList.size() > 0) && (banersList.get(Integer.valueOf(paramInt)) != null) && (((ArrayList) banersList.get(Integer.valueOf(paramInt))).size() > 0)) {
            FlurryAdbean localFlurryAdbean = (FlurryAdbean) ((ArrayList) banersList.get(Integer.valueOf(paramInt))).get(0);
            ((ArrayList) banersList.get(Integer.valueOf(paramInt))).remove(0);
            doGetBanner(paramActivity, 1, paramInt, paramForumStatus);
            return localFlurryAdbean;
        }
        doGetBanner(paramActivity, 2, paramInt, paramForumStatus);
        return null;
    }

    public static String getBannerAds(String paramString, int paramInt, Activity paramActivity, ForumStatus paramForumStatus) {
        String str1 = new StringBuilder(String.valueOf(paramString)).append("?tfid=").append(paramInt).toString() + "&fid=threadbanner";
        paramInt = TapatalkIdFactory.getTapatalkId(paramActivity).getAuid();
        paramString = str1;
        if (paramInt != -1) {
            paramString = str1 + "&au_id=" + paramInt;
        }
        str1 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(paramString)).append("&can_flurry=0").toString())).append("&can_amazon=1").toString())).append("&can_dfp=1").toString())).append("&can_admob=1").toString() + "&isOpenX=0";
        paramString = str1;
        if (visitor != null) {
            paramString = str1;
            if (!visitor.equals("")) {
                paramString = str1 + "&prx_visitor=" + visitor;
            }
        }
        if (Util.googleAdsId != null) {
            paramString = paramString + "&device_id=" + Util.googleAdsId;
        }
        for (; ; ) {
            str1 = "android";
            String str2 = "phone";
            if (Util.getDeviceSize(paramActivity) >= 7.0D) {
                str1 = "pad";
                str2 = "pad";
            }
            str1 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(paramString)).append("&prx_agent=").append(str1).append(Build.VERSION.SDK_INT).toString())).append("&").append(TapatalkApp.APP_KEY).toString() + "&device_type=" + str2;
            str2 = Prefs.get(paramActivity).getString("token", "");
            paramString = str1;
            if (!str2.equals("")) {
                paramString = str1 + "&token=" + str2;
            }
            paramActivity = paramString + "&locale=" + Util.getDeviceLocal(paramActivity);
            paramString = paramActivity;
            if (paramForumStatus.getAdsDisabledGroup() != null) {
                paramString = paramActivity;
                if (!paramForumStatus.getAdsDisabledGroup().equals("")) {
                    paramString = paramActivity + "&no_ad_usergroup=" + paramForumStatus.getAdsDisabledGroup();
                }
            }
            str1 = "";
            if (paramForumStatus.isLogin()) {
                paramActivity = str1;
                if (paramForumStatus.getUserGroupId() != null) {
                    paramActivity = str1;
                    if (paramForumStatus.getUserGroupId().size() > 0) {
                        paramInt = 0;
                        paramActivity = str1;
                        if (paramInt < paramForumStatus.getUserGroupId().size()) {
                            break label690;
                        }
                    }
                }
                label558:
                paramForumStatus = paramString;
                if (paramActivity != null) {
                    paramForumStatus = paramString;
                    if (!paramActivity.equals("")) {
                        paramForumStatus = paramString + "&in_usergroup=" + paramActivity;
                    }
                }
                paramString = new HttpGet(paramForumStatus.replaceAll(" ", "%20"));
            }
            try {
                paramString = httpClient.execute(paramString);
                if (paramString.getStatusLine().getStatusCode() == 200) {
                    paramString = EntityUtils.toString(paramString.getEntity());
                    return paramString;
                    paramString = paramString + "&device_id=" + Util.getMD5(Util.getMacAddress(paramActivity));
                    continue;
                    label690:
                    if (paramInt < paramForumStatus.getUserGroupId().size() - 1) {
                    }
                    for (paramActivity = paramActivity + (String) paramForumStatus.getUserGroupId().get(paramInt) + ","; ; paramActivity = paramActivity + (String) paramForumStatus.getUserGroupId().get(paramInt)) {
                        paramInt += 1;
                        break;
                    }
                    paramActivity = paramForumStatus.getGuestGroupId();
                    break label558;
                } else {
                    paramString = "Error Response: " + paramString.getStatusLine().toString();
                    return paramString;
                }
            } catch (Exception paramString) {
                return "doGetError";
            } catch (IOException paramString) {
                return "doGetError";
            } catch (ClientProtocolException paramString) {
            }
        }
        return "doGetError";
    }

    public static AdBean getLatestAdBean(int paramInt) {
        if ((adsLatestList.size() > 0) && (adsLatestList.get(Integer.valueOf(paramInt)) != null) && (((ArrayList) adsLatestList.get(Integer.valueOf(paramInt))).size() > 0)) {
            AdBean localAdBean = (AdBean) ((ArrayList) adsLatestList.get(Integer.valueOf(paramInt))).get(0);
            ((ArrayList) adsLatestList.get(Integer.valueOf(paramInt))).remove(0);
            adsLatestList.put(Integer.valueOf(paramInt), (ArrayList) adsLatestList.get(Integer.valueOf(paramInt)));
            return localAdBean;
        }
        return null;
    }

    public static DefaultHttpClient getThreadSafeClient() {
        httpParams = new BasicHttpParams();
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        try {
            Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore) localObject).load(null, null);
            localObject = new MySSLSocketFactory((KeyStore) localObject);
            ((SSLSocketFactory) localObject).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            localSchemeRegistry.register(new Scheme("https", (SocketFactory) localObject, 443));
            HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(httpParams, "UTF-8");
            localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            HttpConnectionParams.setConnectionTimeout(httpParams, 20000);
            HttpConnectionParams.setSoTimeout(httpParams, 20000);
            HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
            HttpClientParams.setRedirecting(httpParams, true);
            HttpProtocolParams.setUserAgent(httpParams, "postrelease_api_solution");
            return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, localSchemeRegistry), httpParams);
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
    }

    public static void init(Activity paramActivity) {
        httpClient = getThreadSafeClient();
    }

    public static void initAmazonAdsKey(Context paramContext) {
        try {
            AdRegistration.setAppKey(AMAZON_KEY);
            isInitAmazonKey = true;
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void initBaner(Activity paramActivity, int paramInt1, int paramInt2, ForumStatus paramForumStatus) {
        if (httpClient == null) {
            init(paramActivity);
        }
        initAmazonAdsKey(paramActivity);
        banersList.clear();
        doGetBanner(paramActivity, paramInt1, paramInt2, paramForumStatus);
    }

    public static boolean isConnect(Context paramContext) {
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext != null) {
                paramContext = paramContext.getActiveNetworkInfo();
                if ((paramContext != null) && (paramContext.isConnected())) {
                    paramContext = paramContext.getState();
                    NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
                    if (paramContext == localState) {
                        return true;
                    }
                }
            }
        } catch (Exception paramContext) {
        }
        return false;
    }

    public static int showAdmode(Context paramContext) {
        if ((paramContext != null) && (!paramContext.getResources().getBoolean(2131558401))) {
            return SHOWNATIVE;
        }
        return SHOWADMODE;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/AdsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */