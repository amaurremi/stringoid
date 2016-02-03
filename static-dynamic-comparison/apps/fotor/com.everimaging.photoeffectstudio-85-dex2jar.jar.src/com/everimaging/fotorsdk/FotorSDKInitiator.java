package com.everimaging.fotorsdk;

import android.content.Context;
import android.support.v8.renderscript.RenderScript;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.services.b;
import com.everimaging.fotorsdk.utils.CountlyUtils;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

import java.io.Serializable;

public class FotorSDKInitiator {
    private static final String a = FotorSDKInitiator.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static boolean c = false;
    private static RenderScript d;
    private static d e;

    static {
        b.c(new Object[]{"static initial :" + c});
        try {
            System.loadLibrary("ie");
            System.loadLibrary("crypto");
            System.loadLibrary("fotor_sdk");
            return;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
            b.e(new Object[]{"load fotor_sdk error:" + localUnsatisfiedLinkError.getMessage()});
        }
    }

    public static RenderScript a() {
        c();
        return d;
    }

    public static void a(Context paramContext) {
        a(paramContext, null);
    }

    public static void a(Context paramContext, String paramString) {
        b.c(new Object[]{"initial :" + c});
        if (!c) {
            FotorCommonDirUtils.init(paramContext);
            String str = PackageManagerUtils.getApikey(paramContext);
            nativeInit(paramContext, str, b(paramContext, paramString));
            CountlyUtils.initCountly(paramContext, str);
            DeviceUtils.init(paramContext);
            b.a().a(paramContext);
        }
        try {
            d = RenderScript.create(paramContext);
            b.c(new Object[]{"create renderscript completion"});
            e = new d(d);
            c = true;
            return;
        } catch (Throwable paramContext) {
            for (; ; ) {
                d = null;
                b.e(new Object[]{"create rs error:" + paramContext.getMessage()});
                a.b("CREATE_RS_ERROR", paramContext.getMessage());
            }
        }
    }

    /* Error */
    private static FotorSDKSecrets b(Context paramContext, String paramString) {
        // Byte code:
        //   0: aload_1
        //   1: astore_2
        //   2: aload_1
        //   3: ifnonnull +26 -> 29
        //   6: new 46	java/lang/StringBuilder
        //   9: dup
        //   10: invokespecial 49	java/lang/StringBuilder:<init>	()V
        //   13: aload_0
        //   14: invokevirtual 165	android/content/Context:getPackageName	()Ljava/lang/String;
        //   17: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   20: ldc -89
        //   22: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   25: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   28: astore_2
        //   29: aload_0
        //   30: invokevirtual 171	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
        //   33: aload_2
        //   34: invokevirtual 177	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   37: astore_1
        //   38: new 179	com/google/gson/GsonBuilder
        //   41: dup
        //   42: invokespecial 180	com/google/gson/GsonBuilder:<init>	()V
        //   45: invokevirtual 183	com/google/gson/GsonBuilder:create	()Lcom/google/gson/Gson;
        //   48: new 185	java/io/InputStreamReader
        //   51: dup
        //   52: aload_1
        //   53: invokespecial 188	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   56: ldc 6
        //   58: invokevirtual 194	com/google/gson/Gson:fromJson	(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
        //   61: checkcast 6	com/everimaging/fotorsdk/FotorSDKInitiator$FotorSDKSecrets
        //   64: astore_0
        //   65: aload_1
        //   66: invokestatic 200	com/everimaging/fotorsdk/utils/FotorIOUtils:closeSilently	(Ljava/io/Closeable;)V
        //   69: aload_0
        //   70: areturn
        //   71: astore_1
        //   72: aconst_null
        //   73: astore_0
        //   74: getstatic 42	com/everimaging/fotorsdk/FotorSDKInitiator:b	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   77: iconst_1
        //   78: anewarray 4	java/lang/Object
        //   81: dup
        //   82: iconst_0
        //   83: new 46	java/lang/StringBuilder
        //   86: dup
        //   87: invokespecial 49	java/lang/StringBuilder:<init>	()V
        //   90: ldc -54
        //   92: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   95: aload_1
        //   96: invokevirtual 203	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   99: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   105: aastore
        //   106: invokeinterface 85 2 0
        //   111: aload_0
        //   112: areturn
        //   113: astore_1
        //   114: goto -40 -> 74
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	paramContext	Context
        //   0	117	1	paramString	String
        //   1	33	2	str	String
        // Exception table:
        //   from	to	target	type
        //   6	29	71	java/lang/Exception
        //   29	65	71	java/lang/Exception
        //   65	69	113	java/lang/Exception
    }

    public static d b() {
        c();
        return e;
    }

    private static void c() {
        if (!c) {
            throw new IllegalStateException("You must initial FotorSDK first");
        }
    }

    private static native boolean nativeInit(Context paramContext, String paramString, FotorSDKSecrets paramFotorSDKSecrets);

    static class FotorSDKSecrets
            implements Serializable {
        private static final long serialVersionUID = 7825759903009318105L;
        private String content;
        private String key;
        private String version;

        public static long getSerialversionuid() {
            return 7825759903009318105L;
        }

        public String getContent() {
            return this.content;
        }

        public String getKey() {
            return this.key;
        }

        public String getVersion() {
            return this.version;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void setKey(String paramString) {
            this.key = paramString;
        }

        public void setVersion(String paramString) {
            this.version = paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/FotorSDKInitiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */