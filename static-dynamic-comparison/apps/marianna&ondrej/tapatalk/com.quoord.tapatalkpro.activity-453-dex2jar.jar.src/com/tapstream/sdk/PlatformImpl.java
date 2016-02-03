package com.tapstream.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadFactory;

class PlatformImpl
        implements Platform {
    private static final String FIRED_EVENTS_KEY = "TapstreamSDKFiredEvents";
    private static final String UUID_KEY = "TapstreamSDKUUID";
    private Context context;

    public PlatformImpl(Context paramContext) {
        this.context = paramContext;
    }

    public String getAdvertisingId() {
        return this.context.getApplicationContext().getSharedPreferences("TapstreamSDKUUID", 0).getString("advertisingId", null);
    }

    public String getAndroidId() {
        return Settings.Secure.getString(this.context.getContentResolver(), "android_id");
    }

    public String getAppName() {
        Object localObject = this.context.getPackageManager();
        try {
            localObject = ((PackageManager) localObject).getApplicationLabel(((PackageManager) localObject).getApplicationInfo(this.context.getPackageName(), 0)).toString();
            return (String) localObject;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return this.context.getPackageName();
    }

    public String getAppVersion() {
        Object localObject = this.context.getPackageManager();
        try {
            localObject = ((PackageManager) localObject).getPackageInfo(this.context.getPackageName(), 0).versionName;
            return (String) localObject;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return "";
    }

    public String getDeviceId() {
        try {
            String str = ((TelephonyManager) this.context.getSystemService("phone")).getDeviceId();
            return str;
        } catch (SecurityException localSecurityException) {
            Logging.log(6, "Tapstream Error: Failed to get device id - you need to add the READ_PHONE_STATE permission to your manifest.", new Object[0]);
        }
        return null;
    }

    public Boolean getLimitAdTracking() {
        SharedPreferences localSharedPreferences = this.context.getApplicationContext().getSharedPreferences("TapstreamSDKUUID", 0);
        if (localSharedPreferences.contains("limitAdTracking")) {
            return Boolean.valueOf(localSharedPreferences.getBoolean("limitAdTracking", false));
        }
        return null;
    }

    public String getLocale() {
        return Locale.getDefault().toString();
    }

    public String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            return str;
        } catch (Exception localException) {
        }
        return null;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getOs() {
        return String.format(Locale.US, "Android %s", new Object[]{Build.VERSION.RELEASE});
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public Set<String> getProcessSet() {
        Object localObject = ((ActivityManager) this.context.getSystemService("activity")).getRunningAppProcesses();
        HashSet localHashSet = new HashSet();
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            localHashSet.add(((ActivityManager.RunningAppProcessInfo) ((Iterator) localObject).next()).processName);
        }
        return localHashSet;
    }

    public String getReferrer() {
        return this.context.getApplicationContext().getSharedPreferences("TapstreamSDKUUID", 0).getString("referrer", null);
    }

    public String getResolution() {
        Display localDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics);
        return String.format(Locale.US, "%dx%d", new Object[]{Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels)});
    }

    public String getWifiMac() {
        try {
            String str = ((WifiManager) this.context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return str;
        } catch (SecurityException localSecurityException) {
            Logging.log(6, "Tapstream Error: Failed to get wifi mac address - you need to add the ACCESS_WIFI_STATE permission to your manifest.", new Object[0]);
        }
        return null;
    }

    public Set<String> loadFiredEvents() {
        return new HashSet(this.context.getApplicationContext().getSharedPreferences("TapstreamSDKFiredEvents", 0).getAll().keySet());
    }

    public String loadUuid() {
        SharedPreferences localSharedPreferences = this.context.getApplicationContext().getSharedPreferences("TapstreamSDKUUID", 0);
        Object localObject2 = localSharedPreferences.getString("uuid", null);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = UUID.randomUUID().toString();
            localObject2 = localSharedPreferences.edit();
            ((SharedPreferences.Editor) localObject2).putString("uuid", (String) localObject1);
            ((SharedPreferences.Editor) localObject2).commit();
        }
        return (String) localObject1;
    }

    public ThreadFactory makeWorkerThreadFactory() {
        return new WorkerThread.Factory();
    }

    /* Error */
    public Response request(String paramString1, String paramString2, String paramString3) {
        // Byte code:
        //   0: invokestatic 313	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   3: checkcast 315	com/tapstream/sdk/WorkerThread
        //   6: astore 4
        //   8: aload_3
        //   9: ldc_w 317
        //   12: if_acmpne +171 -> 183
        //   15: new 319	org/apache/http/client/methods/HttpPost
        //   18: dup
        //   19: aload_1
        //   20: invokespecial 322	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
        //   23: astore_3
        //   24: aload_3
        //   25: astore_1
        //   26: aload_2
        //   27: ifnull +29 -> 56
        //   30: new 324	org/apache/http/entity/StringEntity
        //   33: dup
        //   34: aload_2
        //   35: invokespecial 325	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
        //   38: astore_1
        //   39: aload_1
        //   40: ldc_w 327
        //   43: invokevirtual 330	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
        //   46: aload_3
        //   47: checkcast 319	org/apache/http/client/methods/HttpPost
        //   50: aload_1
        //   51: invokevirtual 334	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
        //   54: aload_3
        //   55: astore_1
        //   56: aload_1
        //   57: invokevirtual 340	org/apache/http/client/methods/HttpRequestBase:getParams	()Lorg/apache/http/params/HttpParams;
        //   60: ldc_w 342
        //   63: iconst_0
        //   64: invokeinterface 348 3 0
        //   69: pop
        //   70: aload 4
        //   72: getfield 352	com/tapstream/sdk/WorkerThread:client	Lorg/apache/http/impl/client/DefaultHttpClient;
        //   75: aload_1
        //   76: invokevirtual 358	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   79: astore_2
        //   80: aload_2
        //   81: invokeinterface 364 1 0
        //   86: astore_1
        //   87: aload_2
        //   88: invokeinterface 368 1 0
        //   93: invokeinterface 374 1 0
        //   98: astore_2
        //   99: new 376	java/io/BufferedReader
        //   102: dup
        //   103: new 378	java/io/InputStreamReader
        //   106: dup
        //   107: aload_2
        //   108: invokespecial 381	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   111: invokespecial 384	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   114: astore_3
        //   115: new 386	java/lang/StringBuilder
        //   118: dup
        //   119: invokespecial 387	java/lang/StringBuilder:<init>	()V
        //   122: astore 4
        //   124: aload_3
        //   125: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   128: astore 5
        //   130: aload 5
        //   132: ifnull +78 -> 210
        //   135: aload 4
        //   137: aload 5
        //   139: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: pop
        //   143: goto -19 -> 124
        //   146: astore_1
        //   147: aload_2
        //   148: invokevirtual 399	java/io/InputStream:close	()V
        //   151: aload_1
        //   152: athrow
        //   153: astore_1
        //   154: new 401	com/tapstream/sdk/Response
        //   157: dup
        //   158: iconst_m1
        //   159: aload_1
        //   160: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
        //   163: aconst_null
        //   164: invokespecial 405	com/tapstream/sdk/Response:<init>	(ILjava/lang/String;Ljava/lang/String;)V
        //   167: areturn
        //   168: astore_1
        //   169: new 401	com/tapstream/sdk/Response
        //   172: dup
        //   173: iconst_m1
        //   174: aload_1
        //   175: invokevirtual 406	java/io/UnsupportedEncodingException:toString	()Ljava/lang/String;
        //   178: aconst_null
        //   179: invokespecial 405	com/tapstream/sdk/Response:<init>	(ILjava/lang/String;Ljava/lang/String;)V
        //   182: areturn
        //   183: new 408	org/apache/http/client/methods/HttpGet
        //   186: dup
        //   187: aload_1
        //   188: invokespecial 409	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
        //   191: astore_1
        //   192: goto -136 -> 56
        //   195: astore_1
        //   196: new 401	com/tapstream/sdk/Response
        //   199: dup
        //   200: iconst_m1
        //   201: aload_1
        //   202: invokevirtual 402	java/lang/Exception:toString	()Ljava/lang/String;
        //   205: aconst_null
        //   206: invokespecial 405	com/tapstream/sdk/Response:<init>	(ILjava/lang/String;Ljava/lang/String;)V
        //   209: areturn
        //   210: aload 4
        //   212: invokevirtual 410	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   215: astore_3
        //   216: aload_2
        //   217: invokevirtual 399	java/io/InputStream:close	()V
        //   220: aload_1
        //   221: invokeinterface 416 1 0
        //   226: sipush 200
        //   229: if_icmpne +16 -> 245
        //   232: new 401	com/tapstream/sdk/Response
        //   235: dup
        //   236: sipush 200
        //   239: aconst_null
        //   240: aload_3
        //   241: invokespecial 405	com/tapstream/sdk/Response:<init>	(ILjava/lang/String;Ljava/lang/String;)V
        //   244: areturn
        //   245: new 401	com/tapstream/sdk/Response
        //   248: dup
        //   249: aload_1
        //   250: invokeinterface 416 1 0
        //   255: aload_1
        //   256: invokeinterface 419 1 0
        //   261: aconst_null
        //   262: invokespecial 405	com/tapstream/sdk/Response:<init>	(ILjava/lang/String;Ljava/lang/String;)V
        //   265: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	266	0	this	PlatformImpl
        //   0	266	1	paramString1	String
        //   0	266	2	paramString2	String
        //   0	266	3	paramString3	String
        //   6	205	4	localObject	Object
        //   128	10	5	str	String
        // Exception table:
        //   from	to	target	type
        //   99	124	146	finally
        //   124	130	146	finally
        //   135	143	146	finally
        //   210	216	146	finally
        //   87	99	153	java/lang/Exception
        //   147	153	153	java/lang/Exception
        //   216	220	153	java/lang/Exception
        //   30	39	168	java/io/UnsupportedEncodingException
        //   70	80	195	java/lang/Exception
    }

    public void saveFiredEvents(Set<String> paramSet) {
        SharedPreferences.Editor localEditor = this.context.getApplicationContext().getSharedPreferences("TapstreamSDKFiredEvents", 0).edit();
        localEditor.clear();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
            localEditor.putString((String) paramSet.next(), "");
        }
        localEditor.commit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/PlatformImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */