package com.amazon.device.ads;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;

class DebugProperties {
    public static final String DEBUG_AAX_AD_HOSTNAME = "debug.aaxHostname";
    public static final String DEBUG_AAX_AD_PARAMS = "debug.aaxAdParams";
    public static final String DEBUG_AAX_CONFIG_HOSTNAME = "debug.aaxConfigHostname";
    public static final String DEBUG_AAX_CONFIG_PARAMS = "debug.aaxConfigParams";
    public static final String DEBUG_AAX_CONFIG_USE_SECURE = "debug.aaxConfigUseSecure";
    public static final String DEBUG_ADID = "debug.adid";
    public static final String DEBUG_AD_PREF_URL = "debug.adPrefURL";
    public static final String DEBUG_APPID = "debug.appid";
    public static final String DEBUG_CHANNEL = "debug.channel";
    public static final String DEBUG_CONFIG_FEATURE_USE_GPS_ADVERTISING_ID = "debug.fUseGPSAID";
    public static final String DEBUG_DINFO = "debug.dinfo";
    public static final String DEBUG_ECPM = "debug.ec";
    public static final String DEBUG_GEOLOC = "debug.geoloc";
    public static final String DEBUG_IDFA = "debug.idfa";
    public static final String DEBUG_LOGGING = "debug.logging";
    public static final String DEBUG_MADS_HOSTNAME = "debug.madsHostname";
    public static final String DEBUG_MADS_USE_SECURE = "debug.madsUseSecure";
    public static final String DEBUG_MD5UDID = "debug.md5udid";
    public static final String DEBUG_MXSZ = "debug.mxsz";
    public static final String DEBUG_NORETRYTTL = "debug.noRetryTTL";
    public static final String DEBUG_NORETRYTTL_MAX = "debug.noRetryTTLMax";
    public static final String DEBUG_ON = "debug.mode";
    public static final String DEBUG_OPT_OUT = "debug.optOut";
    public static final String DEBUG_PA = "debug.pa";
    public static final String DEBUG_PK = "debug.pk";
    public static final String DEBUG_PKG = "debug.pkg";
    public static final String DEBUG_PT = "debug.pt";
    public static final String DEBUG_SEND_GEO = "debug.sendGeo";
    public static final String DEBUG_SHA1UDID = "debug.sha1udid";
    public static final String DEBUG_SHOULD_FETCH_CONFIG = "debug.shouldFetchConfig";
    public static final String DEBUG_SHOULD_IDENTIFY_USER = "debug.shouldIdentifyUser";
    public static final String DEBUG_SHOULD_REGISTER_SIS = "debug.shouldRegisterSIS";
    public static final String DEBUG_SIS_DOMAIN = "debug.sisDomain";
    public static final String DEBUG_SIS_URL = "debug.sisURL";
    public static final String DEBUG_SIZE = "debug.size";
    public static final String DEBUG_SLOT = "debug.slot";
    public static final String DEBUG_SLOTS = "debug.slots";
    public static final String DEBUG_SLOT_ID = "debug.slotId";
    public static final String DEBUG_SP = "debug.sp";
    public static final String DEBUG_TEST = "debug.test";
    public static final String DEBUG_TLS_ENABLED = "debug.tlsEnabled";
    public static final String DEBUG_UA = "debug.ua";
    public static final String DEBUG_UI = "debug.ui";
    public static final String DEBUG_VER = "debug.ver";
    private static final String FILE_PREFIX = "/com.amazon.device.ads.debug";
    private static final String LOG_TAG = DebugProperties.class.getSimpleName();
    private static boolean debugModeOn = false;
    private static Properties debugProperties;
    private static final BigInteger privExponent;
    private static final BigInteger privModulus = new BigInteger("22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097");

    static {
        privExponent = new BigInteger("5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777");
        debugProperties = new Properties();
    }

    public static boolean containsDebugProperty(String paramString) {
        if (!debugModeOn) {
            return false;
        }
        return debugProperties.containsKey(paramString);
    }

    protected static byte[] decrypt(byte[] paramArrayOfByte) {
        try {
            Object localObject = new RSAPrivateKeySpec(privModulus, privExponent);
            localObject = KeyFactory.getInstance("RSA").generatePrivate((KeySpec) localObject);
            Cipher localCipher = Cipher.getInstance("RSA");
            localCipher.init(2, (Key) localObject);
            paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
            return paramArrayOfByte;
        } catch (Exception paramArrayOfByte) {
            Log.d(LOG_TAG, "Exception " + paramArrayOfByte + " trying to decrypt debug file");
        }
        return null;
    }

    static void disableDebugging() {
        debugModeOn = false;
    }

    static void enableDebugging() {
        debugModeOn = true;
    }

    public static Boolean getDebugPropertyAsBoolean(String paramString, Boolean paramBoolean) {
        if (!debugModeOn) {
        }
        String str;
        do {
            return paramBoolean;
            str = debugProperties.getProperty(paramString);
        } while (str == null);
        try {
            boolean bool = Boolean.parseBoolean(str);
            return Boolean.valueOf(bool);
        } catch (NumberFormatException localNumberFormatException) {
            Log.e(LOG_TAG, "Unable to parse boolean debug property - property: %s, value: %s", new Object[]{paramString, str});
        }
        return paramBoolean;
    }

    public static boolean getDebugPropertyAsBoolean(String paramString, boolean paramBoolean) {
        return getDebugPropertyAsBoolean(paramString, Boolean.valueOf(paramBoolean)).booleanValue();
    }

    public static int getDebugPropertyAsInteger(String paramString, int paramInt) {
        return getDebugPropertyAsInteger(paramString, Integer.valueOf(paramInt)).intValue();
    }

    public static Integer getDebugPropertyAsInteger(String paramString, Integer paramInteger) {
        if (!debugModeOn) {
        }
        String str;
        do {
            return paramInteger;
            str = debugProperties.getProperty(paramString);
        } while (str == null);
        try {
            int i = Integer.parseInt(str);
            return Integer.valueOf(i);
        } catch (NumberFormatException localNumberFormatException) {
            Log.e(LOG_TAG, "Unable to parse integer debug property - property: %s, value: %s", new Object[]{paramString, str});
        }
        return paramInteger;
    }

    public static long getDebugPropertyAsLong(String paramString, long paramLong) {
        return getDebugPropertyAsLong(paramString, Long.valueOf(paramLong)).longValue();
    }

    public static Long getDebugPropertyAsLong(String paramString, Long paramLong) {
        if (!debugModeOn) {
        }
        String str;
        do {
            return paramLong;
            str = debugProperties.getProperty(paramString);
        } while (str == null);
        try {
            long l = Long.parseLong(str);
            return Long.valueOf(l);
        } catch (NumberFormatException localNumberFormatException) {
            Log.e(LOG_TAG, "Unable to parse long debug property - property: %s, value: %s", new Object[]{paramString, str});
        }
        return paramLong;
    }

    public static String getDebugPropertyAsString(String paramString1, String paramString2) {
        if (!debugModeOn) {
            return paramString2;
        }
        return debugProperties.getProperty(paramString1, paramString2);
    }

    public static boolean isDebugModeOn() {
        return debugModeOn;
    }

    /* Error */
    public static void readDebugProperties() {
        // Byte code:
        //   0: ldc_w 324
        //   3: invokestatic 329	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
        //   6: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   9: ifeq +50 -> 59
        //   12: new 336	java/io/File
        //   15: dup
        //   16: new 223	java/lang/StringBuilder
        //   19: dup
        //   20: invokespecial 224	java/lang/StringBuilder:<init>	()V
        //   23: invokestatic 340	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   26: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   29: ldc -116
        //   31: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   34: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   37: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;)V
        //   40: astore_3
        //   41: aload_3
        //   42: invokevirtual 344	java/io/File:exists	()Z
        //   45: ifeq +14 -> 59
        //   48: aload_3
        //   49: invokevirtual 347	java/io/File:length	()J
        //   52: ldc2_w 348
        //   55: lcmp
        //   56: ifle +4 -> 60
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: iconst_0
        //   64: istore_0
        //   65: new 351	java/io/BufferedInputStream
        //   68: dup
        //   69: new 353	java/io/FileInputStream
        //   72: dup
        //   73: aload_3
        //   74: invokespecial 356	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   77: invokespecial 359	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   80: astore_2
        //   81: aload_3
        //   82: invokevirtual 347	java/io/File:length	()J
        //   85: l2i
        //   86: newarray <illegal type>
        //   88: astore_3
        //   89: iload_0
        //   90: aload_3
        //   91: arraylength
        //   92: if_icmpge +25 -> 117
        //   95: aload_2
        //   96: aload_3
        //   97: iload_0
        //   98: aload_3
        //   99: arraylength
        //   100: iload_0
        //   101: isub
        //   102: invokevirtual 365	java/io/InputStream:read	([BII)I
        //   105: istore_1
        //   106: iload_1
        //   107: ifle -18 -> 89
        //   110: iload_0
        //   111: iload_1
        //   112: iadd
        //   113: istore_0
        //   114: goto -25 -> 89
        //   117: aload_3
        //   118: invokestatic 367	com/amazon/device/ads/DebugProperties:decrypt	([B)[B
        //   121: astore_3
        //   122: aload_3
        //   123: ifnull +49 -> 172
        //   126: new 369	java/io/ByteArrayInputStream
        //   129: dup
        //   130: aload_3
        //   131: invokespecial 372	java/io/ByteArrayInputStream:<init>	([B)V
        //   134: astore_3
        //   135: getstatic 178	com/amazon/device/ads/DebugProperties:debugProperties	Ljava/util/Properties;
        //   138: invokevirtual 375	java/util/Properties:clear	()V
        //   141: getstatic 178	com/amazon/device/ads/DebugProperties:debugProperties	Ljava/util/Properties;
        //   144: aload_3
        //   145: invokevirtual 378	java/util/Properties:load	(Ljava/io/InputStream;)V
        //   148: getstatic 178	com/amazon/device/ads/DebugProperties:debugProperties	Ljava/util/Properties;
        //   151: ldc 71
        //   153: ldc_w 380
        //   156: invokevirtual 320	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   159: ldc_w 382
        //   162: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   165: ifeq +7 -> 172
        //   168: iconst_1
        //   169: putstatic 180	com/amazon/device/ads/DebugProperties:debugModeOn	Z
        //   172: aload_2
        //   173: ifnull -114 -> 59
        //   176: aload_2
        //   177: invokevirtual 385	java/io/InputStream:close	()V
        //   180: return
        //   181: astore_2
        //   182: return
        //   183: astore_3
        //   184: aload 4
        //   186: astore_2
        //   187: aload_2
        //   188: ifnull +7 -> 195
        //   191: aload_2
        //   192: invokevirtual 385	java/io/InputStream:close	()V
        //   195: aload_3
        //   196: athrow
        //   197: astore_2
        //   198: return
        //   199: astore_3
        //   200: goto -13 -> 187
        // Local variable table:
        //   start	length	slot	name	signature
        //   64	50	0	i	int
        //   105	8	1	j	int
        //   80	97	2	localBufferedInputStream	java.io.BufferedInputStream
        //   181	1	2	localException1	Exception
        //   186	6	2	localObject1	Object
        //   197	1	2	localException2	Exception
        //   40	105	3	localObject2	Object
        //   183	13	3	localObject3	Object
        //   199	1	3	localObject4	Object
        //   61	124	4	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   176	180	181	java/lang/Exception
        //   65	81	183	finally
        //   191	195	197	java/lang/Exception
        //   195	197	197	java/lang/Exception
        //   81	89	199	finally
        //   89	106	199	finally
        //   117	122	199	finally
        //   126	172	199	finally
    }

    static void setDebugProperty(String paramString1, String paramString2) {
        debugProperties.put(paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/DebugProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */