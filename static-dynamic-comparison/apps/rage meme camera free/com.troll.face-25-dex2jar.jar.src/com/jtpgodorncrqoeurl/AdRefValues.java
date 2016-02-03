package com.jtpgodorncrqoeurl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class AdRefValues
{
  private static boolean a = true;
  
  private static String a()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (SocketException localSocketException)
    {
      AdLog.printStackTrace("LBAdConroller", localSocketException);
    }
    return null;
  }
  
  /* Error */
  public static String adRefValues(Context paramContext, android.telephony.TelephonyManager paramTelephonyManager, String paramString, List paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 63
    //   2: astore 12
    //   4: aload_2
    //   5: ifnull +29 -> 34
    //   8: new 65	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   15: ldc 63
    //   17: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 72
    //   22: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 12
    //   34: aload 12
    //   36: astore_2
    //   37: aload_3
    //   38: ifnull +162 -> 200
    //   41: ldc 63
    //   43: astore 13
    //   45: iconst_0
    //   46: istore 11
    //   48: aload 12
    //   50: astore_2
    //   51: iload 11
    //   53: aload_3
    //   54: invokeinterface 79 1 0
    //   59: if_icmpge +86 -> 145
    //   62: aload 12
    //   64: astore_2
    //   65: aload_3
    //   66: iload 11
    //   68: invokeinterface 83 2 0
    //   73: checkcast 85	org/apache/http/message/BasicNameValuePair
    //   76: astore 14
    //   78: aload 12
    //   80: astore_2
    //   81: new 65	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   88: aload 13
    //   90: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 14
    //   95: invokevirtual 88	org/apache/http/message/BasicNameValuePair:getName	()Ljava/lang/String;
    //   98: invokevirtual 92	java/lang/String:getBytes	()[B
    //   101: invokestatic 98	com/jtpgodorncrqoeurl/AdEncryption:base64encode	([B)Ljava/lang/String;
    //   104: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 100
    //   109: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 14
    //   114: invokevirtual 103	org/apache/http/message/BasicNameValuePair:getValue	()Ljava/lang/String;
    //   117: invokevirtual 92	java/lang/String:getBytes	()[B
    //   120: invokestatic 98	com/jtpgodorncrqoeurl/AdEncryption:base64encode	([B)Ljava/lang/String;
    //   123: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 105
    //   128: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore 13
    //   136: iload 11
    //   138: iconst_1
    //   139: iadd
    //   140: istore 11
    //   142: goto -94 -> 48
    //   145: aload 12
    //   147: astore_2
    //   148: new 65	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   155: aload 12
    //   157: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 107
    //   162: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 13
    //   167: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore_3
    //   174: aload_3
    //   175: astore_2
    //   176: ldc 51
    //   178: new 65	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 109
    //   184: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload 13
    //   189: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 116	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_3
    //   199: astore_2
    //   200: aload_0
    //   201: invokevirtual 122	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   204: ldc 124
    //   206: invokestatic 130	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   209: astore_3
    //   210: invokestatic 136	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   213: astore 12
    //   215: new 65	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   222: aload_2
    //   223: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc -118
    //   228: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_3
    //   232: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc -116
    //   237: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: getstatic 146	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   243: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc -108
    //   248: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokestatic 150	com/jtpgodorncrqoeurl/AdRefValues:a	()Ljava/lang/String;
    //   254: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc -104
    //   259: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 12
    //   264: bipush 15
    //   266: invokevirtual 155	java/util/Calendar:get	(I)I
    //   269: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc -96
    //   274: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 12
    //   279: invokevirtual 164	java/util/Calendar:getTimeInMillis	()J
    //   282: ldc2_w 165
    //   285: ldiv
    //   286: l2i
    //   287: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: astore_2
    //   294: new 65	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   301: aload_2
    //   302: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc -88
    //   307: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 5
    //   312: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: ldc -86
    //   317: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: iload 6
    //   322: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore_2
    //   329: iload 4
    //   331: ifeq +555 -> 886
    //   334: aload_0
    //   335: ldc -84
    //   337: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   340: checkcast 178	android/location/LocationManager
    //   343: ldc -76
    //   345: invokevirtual 184	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
    //   348: astore_3
    //   349: aload_3
    //   350: invokevirtual 190	android/location/Location:getLongitude	()D
    //   353: dstore 7
    //   355: aload_3
    //   356: invokevirtual 193	android/location/Location:getLatitude	()D
    //   359: dstore 9
    //   361: new 65	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   368: aload_2
    //   369: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc -61
    //   374: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: dload 9
    //   379: invokestatic 199	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   382: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc -55
    //   387: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: dload 7
    //   392: invokestatic 199	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   395: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: astore_3
    //   402: aload_3
    //   403: astore_2
    //   404: getstatic 10	com/jtpgodorncrqoeurl/AdRefValues:a	Z
    //   407: istore 4
    //   409: iload 4
    //   411: ifeq +479 -> 890
    //   414: new 65	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   421: aload_2
    //   422: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc -53
    //   427: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: invokevirtual 208	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   434: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc -46
    //   439: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_1
    //   443: invokevirtual 213	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   446: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: ldc -41
    //   451: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_1
    //   455: invokevirtual 218	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   458: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: astore_3
    //   465: aload_3
    //   466: astore_2
    //   467: aload_1
    //   468: invokevirtual 221	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   471: ifnull +422 -> 893
    //   474: aload_1
    //   475: invokevirtual 221	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   478: astore_3
    //   479: new 65	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   486: aload_2
    //   487: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: ldc -33
    //   492: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_3
    //   496: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc -31
    //   501: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: getstatic 230	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   507: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: ldc -24
    //   512: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: getstatic 235	android/os/Build:MODEL	Ljava/lang/String;
    //   518: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: astore 12
    //   526: aload_0
    //   527: ldc -19
    //   529: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   532: checkcast 239	android/net/ConnectivityManager
    //   535: astore_3
    //   536: aload_3
    //   537: iconst_0
    //   538: invokevirtual 243	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   541: astore_2
    //   542: aload_3
    //   543: iconst_1
    //   544: invokevirtual 243	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   547: astore_3
    //   548: aload_2
    //   549: ifnull +409 -> 958
    //   552: aload_2
    //   553: invokevirtual 249	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   556: astore_2
    //   557: aload_3
    //   558: ifnull +405 -> 963
    //   561: aload_3
    //   562: invokevirtual 249	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   565: astore_3
    //   566: aload_3
    //   567: getstatic 255	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   570: if_acmpeq +375 -> 945
    //   573: aload_3
    //   574: getstatic 258	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   577: if_acmpne +323 -> 900
    //   580: goto +365 -> 945
    //   583: new 65	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   590: aload 12
    //   592: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 260
    //   598: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_2
    //   602: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: astore_3
    //   609: aload_1
    //   610: invokevirtual 263	android/telephony/TelephonyManager:getSimState	()I
    //   613: tableswitch	default:+339->952, 0:+397->1010, 1:+362->975, 2:+376->989, 3:+383->996, 4:+369->982, 5:+390->1003
    //   652: new 65	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   659: aload_3
    //   660: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: ldc_w 265
    //   666: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload_1
    //   670: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: astore_3
    //   677: new 65	java/lang/StringBuilder
    //   680: dup
    //   681: ldc_w 267
    //   684: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   687: astore 12
    //   689: aload_2
    //   690: ldc_w 269
    //   693: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: ifeq +221 -> 917
    //   699: ldc_w 275
    //   702: astore_2
    //   703: ldc 51
    //   705: aload 12
    //   707: aload_2
    //   708: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: ldc_w 277
    //   714: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload_1
    //   718: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 280	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload_0
    //   728: ldc_w 282
    //   731: invokevirtual 286	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   734: ifne +200 -> 934
    //   737: aload_0
    //   738: ldc_w 269
    //   741: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   744: checkcast 288	android/net/wifi/WifiManager
    //   747: invokevirtual 292	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   750: astore_1
    //   751: new 65	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   758: aload_3
    //   759: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: ldc_w 294
    //   765: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_1
    //   769: invokevirtual 299	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   772: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: astore_1
    //   779: new 65	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   786: aload_1
    //   787: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 301
    //   793: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokestatic 307	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   799: invokevirtual 308	java/util/Locale:toString	()Ljava/lang/String;
    //   802: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: astore_1
    //   809: new 65	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   816: aload_1
    //   817: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_0
    //   821: invokestatic 312	com/jtpgodorncrqoeurl/AdRefValues:generateContexts	(Landroid/content/Context;)Ljava/lang/String;
    //   824: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: astore_1
    //   831: aload_1
    //   832: astore_0
    //   833: aload_1
    //   834: ldc_w 314
    //   837: invokevirtual 318	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   840: ifeq +9 -> 849
    //   843: aload_1
    //   844: iconst_1
    //   845: invokevirtual 322	java/lang/String:substring	(I)Ljava/lang/String;
    //   848: astore_0
    //   849: aload_0
    //   850: invokestatic 326	com/jtpgodorncrqoeurl/AdEncryption:encrypt	(Ljava/lang/String;)Ljava/lang/String;
    //   853: astore_0
    //   854: aload_0
    //   855: areturn
    //   856: astore_3
    //   857: ldc 51
    //   859: new 65	java/lang/StringBuilder
    //   862: dup
    //   863: ldc_w 328
    //   866: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   869: aload_3
    //   870: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   873: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 334	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: goto -682 -> 200
    //   885: astore_3
    //   886: goto -482 -> 404
    //   889: astore_3
    //   890: goto -423 -> 467
    //   893: ldc_w 336
    //   896: astore_3
    //   897: goto -418 -> 479
    //   900: aload_2
    //   901: getstatic 255	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   904: if_acmpeq +64 -> 968
    //   907: aload_2
    //   908: getstatic 258	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   911: if_acmpne +28 -> 939
    //   914: goto +54 -> 968
    //   917: ldc_w 338
    //   920: astore_2
    //   921: goto -218 -> 703
    //   924: astore_0
    //   925: ldc 51
    //   927: aload_0
    //   928: invokestatic 57	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   931: ldc 63
    //   933: areturn
    //   934: aload_3
    //   935: astore_1
    //   936: goto -157 -> 779
    //   939: ldc 63
    //   941: astore_2
    //   942: goto -359 -> 583
    //   945: ldc_w 269
    //   948: astore_2
    //   949: goto -366 -> 583
    //   952: ldc 63
    //   954: astore_1
    //   955: goto -303 -> 652
    //   958: aconst_null
    //   959: astore_2
    //   960: goto -403 -> 557
    //   963: aconst_null
    //   964: astore_3
    //   965: goto -399 -> 566
    //   968: ldc_w 340
    //   971: astore_2
    //   972: goto -389 -> 583
    //   975: ldc_w 342
    //   978: astore_1
    //   979: goto -327 -> 652
    //   982: ldc_w 344
    //   985: astore_1
    //   986: goto -334 -> 652
    //   989: ldc_w 346
    //   992: astore_1
    //   993: goto -341 -> 652
    //   996: ldc_w 348
    //   999: astore_1
    //   1000: goto -348 -> 652
    //   1003: ldc_w 350
    //   1006: astore_1
    //   1007: goto -355 -> 652
    //   1010: ldc_w 352
    //   1013: astore_1
    //   1014: goto -362 -> 652
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1017	0	paramContext	Context
    //   0	1017	1	paramTelephonyManager	android.telephony.TelephonyManager
    //   0	1017	2	paramString	String
    //   0	1017	3	paramList	List
    //   0	1017	4	paramBoolean	boolean
    //   0	1017	5	paramInt1	int
    //   0	1017	6	paramInt2	int
    //   353	38	7	d1	double
    //   359	19	9	d2	double
    //   46	95	11	i	int
    //   2	704	12	localObject	Object
    //   43	145	13	str	String
    //   76	37	14	localBasicNameValuePair	org.apache.http.message.BasicNameValuePair
    // Exception table:
    //   from	to	target	type
    //   51	62	856	java/lang/Exception
    //   65	78	856	java/lang/Exception
    //   81	136	856	java/lang/Exception
    //   148	174	856	java/lang/Exception
    //   176	198	856	java/lang/Exception
    //   334	402	885	java/lang/Exception
    //   414	465	889	java/lang/Exception
    //   200	329	924	java/lang/Exception
    //   404	409	924	java/lang/Exception
    //   467	479	924	java/lang/Exception
    //   479	548	924	java/lang/Exception
    //   552	557	924	java/lang/Exception
    //   561	566	924	java/lang/Exception
    //   566	580	924	java/lang/Exception
    //   583	652	924	java/lang/Exception
    //   652	699	924	java/lang/Exception
    //   703	779	924	java/lang/Exception
    //   779	831	924	java/lang/Exception
    //   833	849	924	java/lang/Exception
    //   849	854	924	java/lang/Exception
    //   900	914	924	java/lang/Exception
  }
  
  public static String generateContexts(Context paramContext)
  {
    Object localObject1 = "";
    PackageManager localPackageManager = paramContext.getPackageManager();
    long l3 = System.currentTimeMillis();
    Object localObject3 = localPackageManager.getInstalledPackages(128);
    Object localObject2 = paramContext.getSharedPreferences("Preference", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    localObject2 = ((SharedPreferences)localObject2).getString("SD_CONTEXTS", null);
    int i;
    if (localObject2 != null)
    {
      i = 1;
      if (i == 0) {
        break label547;
      }
    }
    label81:
    label547:
    for (long l1 = 80L;; l1 = 200L)
    {
      Iterator localIterator = ((List)localObject3).iterator();
      Object localObject4;
      String str;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject3 = (PackageInfo)localIterator.next();
          if (System.currentTimeMillis() - l3 <= l1)
          {
            localObject4 = ((PackageInfo)localObject3).applicationInfo;
            if ((((ApplicationInfo)localObject4).flags & 0x1) != 0) {
              continue;
            }
            str = ((ApplicationInfo)localObject4).loadLabel(localPackageManager).toString();
            if (Build.VERSION.SDK_INT < 9) {
              break;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        for (;;)
        {
          try
          {
            localObject4 = new StringBuilder("title=").append(str).append("&package=").append(((ApplicationInfo)localObject4).packageName).append("&install=");
            if (i != 0)
            {
              l2 = ((PackageInfo)localObject3).firstInstallTime / 1000L;
              localObject4 = ((StringBuilder)localObject4).append(l2).append("&update=");
              if (i == 0) {
                continue;
              }
              l2 = ((PackageInfo)localObject3).lastUpdateTime / 1000L;
              localObject3 = l2 + "&vcode=" + ((PackageInfo)localObject3).versionCode + "&vname=" + ((PackageInfo)localObject3).versionName;
              localObject3 = (String)localObject1 + "&cnt1[]=" + URLEncoder.encode((String)localObject3, "UTF-8");
              localObject1 = localObject3;
              break label81;
              i = 0;
              break;
              i = 0;
              continue;
            }
            long l2 = 0L;
            continue;
            l2 = 0L;
            continue;
            i = 1;
            if (i == 0)
            {
              localEditor.putString("SD_CONTEXTS", (String)localObject1);
              localEditor.commit();
              localObject3 = (ActivityManager)paramContext.getSystemService("activity");
              localObject2 = localObject1;
              if (paramContext.checkCallingOrSelfPermission("android.permission.GET_TASKS") != 0) {
                continue;
              }
              localObject3 = ((ActivityManager)localObject3).getRunningTasks(Integer.MAX_VALUE).iterator();
              localObject2 = localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                continue;
              }
              paramContext = (ActivityManager.RunningTaskInfo)((Iterator)localObject3).next();
            }
            try
            {
              paramContext = paramContext.baseActivity.getPackageName();
              localObject2 = localPackageManager.getApplicationInfo(paramContext, 0).loadLabel(localPackageManager).toString();
              paramContext = "name=" + (String)localObject2 + "&package=" + paramContext;
              paramContext = (String)localObject1 + "&cnt2[]=" + URLEncoder.encode(paramContext, "UTF-8");
              localObject1 = paramContext;
            }
            catch (Exception paramContext) {}
            localObject1 = localObject2;
            continue;
            return (String)localObject2;
          }
          catch (Exception localException) {}
        }
        break label81;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdRefValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */