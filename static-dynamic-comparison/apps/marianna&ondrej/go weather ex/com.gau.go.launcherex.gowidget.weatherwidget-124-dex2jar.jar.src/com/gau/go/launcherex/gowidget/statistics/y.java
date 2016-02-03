package com.gau.go.launcherex.gowidget.statistics;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.gau.go.launcherex.gowidget.billing.v;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays42Provider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class y
{
  private static String a;
  private static String b;
  
  public static String a(Context paramContext)
  {
    Object localObject = new StringBuffer();
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    a((StringBuffer)localObject, paramContext, localSharedPreferences);
    b((StringBuffer)localObject, paramContext, localSharedPreferences);
    paramContext = ((StringBuffer)localObject).toString();
    com.gtp.a.a.b.c.a("CYN", paramContext);
    com.gtp.a.a.a.a.a().a("组装数据： \r\n" + paramContext, "statistics_log.txt");
    try
    {
      localObject = URLEncoder.encode(paramContext, "UTF-8");
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject = paramContext;
    if (paramContext != null) {
      localObject = c.a(paramContext, "lvsiqiaoil611230");
    }
    return (String)localObject;
  }
  
  private static String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(5).append("||");
    a(localStringBuffer, Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    a(localStringBuffer, a(paramSharedPreferences));
    return localStringBuffer.toString();
  }
  
  public static String a(SharedPreferences paramSharedPreferences)
  {
    Object localObject1 = "";
    if (paramSharedPreferences != null) {
      localObject1 = paramSharedPreferences.getString("statistics_timestamp", "");
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new Time();
      ((Time)localObject1).setToNow();
      localObject1 = ((Time)localObject1).format("%Y-%m-%d %H:%M:%S");
      localObject2 = localObject1;
      if (paramSharedPreferences != null)
      {
        paramSharedPreferences = paramSharedPreferences.edit();
        paramSharedPreferences.putString("statistics_timestamp", (String)localObject1);
        paramSharedPreferences.commit();
        localObject2 = localObject1;
      }
    }
    return (String)localObject2;
  }
  
  /* Error */
  public static String a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +8 -> 11
    //   6: ldc 114
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: ldc 114
    //   13: astore 4
    //   15: new 155	java/io/StringWriter
    //   18: dup
    //   19: invokespecial 156	java/io/StringWriter:<init>	()V
    //   22: astore_2
    //   23: new 158	java/io/PrintWriter
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 161	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 166	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   37: aload_2
    //   38: invokevirtual 167	java/io/StringWriter:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 170	java/io/StringWriter:close	()V
    //   50: aload_0
    //   51: astore_1
    //   52: aload_3
    //   53: ifnull -44 -> 9
    //   56: aload_3
    //   57: invokevirtual 171	java/io/PrintWriter:close	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   68: ifeq -59 -> 9
    //   71: aload_2
    //   72: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   81: ifeq -31 -> 50
    //   84: aload_1
    //   85: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   88: goto -38 -> 50
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_0
    //   94: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   97: ifeq +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 170	java/io/StringWriter:close	()V
    //   112: aload 4
    //   114: astore_1
    //   115: aload_0
    //   116: ifnull -107 -> 9
    //   119: aload_0
    //   120: invokevirtual 171	java/io/PrintWriter:close	()V
    //   123: ldc 114
    //   125: areturn
    //   126: astore_0
    //   127: aload 4
    //   129: astore_1
    //   130: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   133: ifeq -124 -> 9
    //   136: aload_0
    //   137: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   140: ldc 114
    //   142: areturn
    //   143: astore_1
    //   144: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   147: ifeq -35 -> 112
    //   150: aload_1
    //   151: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   154: goto -42 -> 112
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 170	java/io/StringWriter:close	()V
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 171	java/io/PrintWriter:close	()V
    //   178: aload_1
    //   179: athrow
    //   180: astore_2
    //   181: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   184: ifeq -14 -> 170
    //   187: aload_2
    //   188: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   191: goto -21 -> 170
    //   194: astore_0
    //   195: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   198: ifeq -20 -> 178
    //   201: aload_0
    //   202: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   205: goto -27 -> 178
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: goto -49 -> 162
    //   214: astore_1
    //   215: aload_3
    //   216: astore_0
    //   217: goto -55 -> 162
    //   220: astore_3
    //   221: aload_1
    //   222: astore_2
    //   223: aload_3
    //   224: astore_1
    //   225: goto -63 -> 162
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_0
    //   231: aload_2
    //   232: astore_1
    //   233: aload_3
    //   234: astore_2
    //   235: goto -141 -> 94
    //   238: astore_0
    //   239: aload_2
    //   240: astore_1
    //   241: aload_0
    //   242: astore_2
    //   243: aload_3
    //   244: astore_0
    //   245: goto -151 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramThrowable	Throwable
    //   1	64	1	localObject1	Object
    //   77	32	1	localException1	Exception
    //   114	16	1	localObject2	Object
    //   143	8	1	localException2	Exception
    //   157	22	1	localObject3	Object
    //   208	1	1	localObject4	Object
    //   214	8	1	localObject5	Object
    //   224	17	1	localObject6	Object
    //   22	25	2	localStringWriter	java.io.StringWriter
    //   62	10	2	localException3	Exception
    //   91	10	2	localException4	Exception
    //   161	6	2	localObject7	Object
    //   180	8	2	localException5	Exception
    //   222	21	2	localObject8	Object
    //   31	185	3	localPrintWriter	java.io.PrintWriter
    //   220	4	3	localObject9	Object
    //   228	16	3	localException6	Exception
    //   13	115	4	str	String
    // Exception table:
    //   from	to	target	type
    //   56	60	62	java/lang/Exception
    //   46	50	77	java/lang/Exception
    //   15	23	91	java/lang/Exception
    //   119	123	126	java/lang/Exception
    //   108	112	143	java/lang/Exception
    //   15	23	157	finally
    //   166	170	180	java/lang/Exception
    //   174	178	194	java/lang/Exception
    //   23	32	208	finally
    //   32	42	214	finally
    //   94	104	220	finally
    //   23	32	228	java/lang/Exception
    //   32	42	238	java/lang/Exception
  }
  
  /* Error */
  public static String a(Throwable paramThrowable, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +8 -> 11
    //   6: ldc 114
    //   8: astore_2
    //   9: aload_2
    //   10: areturn
    //   11: ldc 114
    //   13: astore 5
    //   15: new 155	java/io/StringWriter
    //   18: dup
    //   19: invokespecial 156	java/io/StringWriter:<init>	()V
    //   22: astore_3
    //   23: new 158	java/io/PrintWriter
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 161	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   31: astore 4
    //   33: aload 5
    //   35: astore_2
    //   36: aload_0
    //   37: aload 4
    //   39: invokevirtual 166	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   42: aload 5
    //   44: astore_2
    //   45: aload_3
    //   46: invokevirtual 167	java/io/StringWriter:toString	()Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: astore_2
    //   52: aload_0
    //   53: ldc -80
    //   55: aload_1
    //   56: invokevirtual 182	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   59: astore_0
    //   60: aload_0
    //   61: astore_2
    //   62: aload_0
    //   63: ldc -72
    //   65: aload_1
    //   66: invokevirtual 182	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   69: astore_0
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 170	java/io/StringWriter:close	()V
    //   78: aload_0
    //   79: astore_2
    //   80: aload 4
    //   82: ifnull -73 -> 9
    //   85: aload 4
    //   87: invokevirtual 171	java/io/PrintWriter:close	()V
    //   90: aload_0
    //   91: areturn
    //   92: astore_1
    //   93: aload_0
    //   94: astore_2
    //   95: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   98: ifeq -89 -> 9
    //   101: aload_1
    //   102: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   105: aload_0
    //   106: areturn
    //   107: astore_1
    //   108: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   111: ifeq -33 -> 78
    //   114: aload_1
    //   115: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   118: goto -40 -> 78
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_1
    //   124: ldc 114
    //   126: astore_0
    //   127: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   130: ifeq +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 170	java/io/StringWriter:close	()V
    //   145: aload_0
    //   146: astore_2
    //   147: aload_1
    //   148: ifnull -139 -> 9
    //   151: aload_1
    //   152: invokevirtual 171	java/io/PrintWriter:close	()V
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: aload_0
    //   159: astore_2
    //   160: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   163: ifeq -154 -> 9
    //   166: aload_1
    //   167: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   170: aload_0
    //   171: areturn
    //   172: astore_2
    //   173: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   176: ifeq -31 -> 145
    //   179: aload_2
    //   180: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   183: goto -38 -> 145
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 170	java/io/StringWriter:close	()V
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 171	java/io/PrintWriter:close	()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_2
    //   210: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   213: ifeq -14 -> 199
    //   216: aload_2
    //   217: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   220: goto -21 -> 199
    //   223: astore_1
    //   224: invokestatic 173	com/gtp/a/a/b/c:a	()Z
    //   227: ifeq -20 -> 207
    //   230: aload_1
    //   231: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   234: goto -27 -> 207
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_1
    //   240: goto -49 -> 191
    //   243: astore_0
    //   244: aload 4
    //   246: astore_1
    //   247: goto -56 -> 191
    //   250: astore_0
    //   251: aload_2
    //   252: astore_3
    //   253: goto -62 -> 191
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_1
    //   259: aload_3
    //   260: astore_2
    //   261: ldc 114
    //   263: astore 4
    //   265: aload_0
    //   266: astore_3
    //   267: aload 4
    //   269: astore_0
    //   270: goto -143 -> 127
    //   273: astore_0
    //   274: aload_3
    //   275: astore 5
    //   277: aload_0
    //   278: astore_3
    //   279: aload_2
    //   280: astore_0
    //   281: aload 4
    //   283: astore_1
    //   284: aload 5
    //   286: astore_2
    //   287: goto -160 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramThrowable	Throwable
    //   0	290	1	paramString	String
    //   1	159	2	localObject1	Object
    //   172	8	2	localException1	Exception
    //   209	43	2	localException2	Exception
    //   260	27	2	localObject2	Object
    //   22	53	3	localStringWriter	java.io.StringWriter
    //   121	13	3	localException3	Exception
    //   190	89	3	localObject3	Object
    //   31	251	4	localObject4	Object
    //   13	272	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   85	90	92	java/lang/Exception
    //   74	78	107	java/lang/Exception
    //   15	23	121	java/lang/Exception
    //   151	155	157	java/lang/Exception
    //   141	145	172	java/lang/Exception
    //   15	23	186	finally
    //   195	199	209	java/lang/Exception
    //   203	207	223	java/lang/Exception
    //   23	33	237	finally
    //   36	42	243	finally
    //   45	50	243	finally
    //   52	60	243	finally
    //   62	70	243	finally
    //   127	137	250	finally
    //   23	33	256	java/lang/Exception
    //   36	42	273	java/lang/Exception
    //   45	50	273	java/lang/Exception
    //   52	60	273	java/lang/Exception
    //   62	70	273	java/lang/Exception
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    paramContext.getSharedPreferences("randomdeviceid", 0).edit().putString("random_device_id", String.valueOf(paramLong)).commit();
  }
  
  private static void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.putInt("go_in_detail", 0);
    paramEditor.putString("statistics_timestamp", "");
  }
  
  public static void a(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, String paramString)
  {
    paramEditor.putInt(paramString, paramSharedPreferences.getInt(paramString, 0) + 1);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    if (paramInt1 != 0) {
      paramStringBuffer.append(paramString).append(paramInt2).append("||").append(paramInt1).append("\r\n");
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    SharedPreferences.Editor localEditor = paramContext.edit();
    a(paramContext, localEditor, paramString);
    localEditor.commit();
  }
  
  private static void a(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, int paramInt, StringBuffer paramStringBuffer)
  {
    if (paramSharedPreferences.getInt(paramString2, 0) != 0) {
      paramStringBuffer.append(paramString1).append(paramInt).append("||").append(1).append("\r\n");
    }
  }
  
  private static void a(StringBuffer paramStringBuffer, Context paramContext, SharedPreferences paramSharedPreferences)
  {
    paramStringBuffer.append("4").append("||");
    a(paramStringBuffer, Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    a(paramStringBuffer, a(paramSharedPreferences));
    a(paramStringBuffer, n(paramContext));
    a(paramStringBuffer, f(paramContext));
    a(paramStringBuffer, c(paramContext));
    Object localObject = GoWidgetApplication.b(paramContext);
    if (((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(32))
    {
      paramStringBuffer.append(4);
      paramStringBuffer.append("||");
      if (paramSharedPreferences.getInt("go_in_detail", 0) <= 0) {
        break label308;
      }
    }
    label308:
    for (paramSharedPreferences = "1";; paramSharedPreferences = "0")
    {
      a(paramStringBuffer, paramSharedPreferences);
      localObject = d(paramContext);
      paramSharedPreferences = (SharedPreferences)localObject;
      if (localObject == null) {
        paramSharedPreferences = "0000000000000000";
      }
      a(paramStringBuffer, paramSharedPreferences);
      paramContext = e(paramContext) + "";
      if (!TextUtils.isEmpty(paramContext)) {
        paramStringBuffer.append(paramContext.replace("|", " ").replace("\r", " ").replace("\n", " "));
      }
      paramStringBuffer.append("\r\n");
      return;
      if (((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(1))
      {
        paramStringBuffer.append(1);
        break;
      }
      if ((((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(2)) && (((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(64)))
      {
        paramStringBuffer.append(2).append(",").append(3);
        break;
      }
      if ((((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(2)) && (!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(64)))
      {
        paramStringBuffer.append(2);
        break;
      }
      if ((!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(2)) && (((com.gau.go.launcherex.gowidget.weather.d.f)localObject).a(64)))
      {
        paramStringBuffer.append(3);
        break;
      }
      if (!((com.gau.go.launcherex.gowidget.weather.d.f)localObject).e()) {
        break;
      }
      paramStringBuffer.append(0);
      break;
    }
  }
  
  public static void a(StringBuffer paramStringBuffer, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramStringBuffer.append(paramString.replace("|", " ").replace("\r", " ").replace("\n", " "));
    }
    paramStringBuffer.append("||");
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramString == null) {}
    }
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 1024);
      bool1 = true;
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = true;
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 1).versionCode;
      if (i < paramInt) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (RuntimeException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int b()
  {
    return 2;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static void b(Context paramContext)
  {
    paramContext = GoWidgetApplication.c(paramContext).a().edit();
    a(paramContext);
    b(paramContext);
    paramContext.commit();
  }
  
  private static void b(SharedPreferences.Editor paramEditor)
  {
    paramEditor.putInt("widget42_to_detail", 0);
    paramEditor.putInt("widget41_to_detail", 0);
    paramEditor.putInt("widget21_to_detail", 0);
    paramEditor.putInt("widget11_to_detail", 0);
    paramEditor.putInt("appwidget42_to_detail", 0);
    paramEditor.putInt("appwidget41_to_detail", 0);
    paramEditor.putInt("appwidget21_to_detail", 0);
    paramEditor.putInt("count_share_screenshot", 0);
    paramEditor.putInt("count_share_camera", 0);
    paramEditor.putInt("user_behavior_houly", 0);
    paramEditor.putInt("user_behavior_houly_graph", 0);
    paramEditor.putInt("user_behavior_daily", 0);
    paramEditor.putInt("user_behavior_daily_graph", 0);
    paramEditor.putInt("user_behavior_wind", 0);
    paramEditor.putInt("user_behavior_wind_graph", 0);
    paramEditor.putInt("user_behavior_rain", 0);
    paramEditor.putInt("user_behavior_rain_graph", 0);
    paramEditor.putInt("user_behavior_maps", 0);
    paramEditor.putInt("user_behavior_theme", 0);
    paramEditor.putInt("user_behavior_edit_city", 0);
    paramEditor.putInt("user_behavior_setting", 0);
    paramEditor.putInt("user_behavior_feedback", 0);
    paramEditor.putInt("user_behavior_msg_center", 0);
    paramEditor.putInt("user_behavior_apps_recommend", 0);
    paramEditor.putInt("user_behavior_widget_theme", 0);
    paramEditor.putInt("count_send_feedback", 0);
    paramEditor.putInt("maps_tab_radar", 0);
    paramEditor.putInt("map_tab_satellite", 0);
    paramEditor.putInt("maps_tab_map_detail", 0);
    paramEditor.putInt("maps_tab_map_detail", 0);
    paramEditor.putInt("key_gowidget_theme_switcher_click", 0);
    paramEditor.putInt("key_home_open_sidebar", 0);
    paramEditor.putInt("weather_warning_list_show", 0);
    paramEditor.putInt("weather_warning_detail_show", 0);
    paramEditor.putInt("weather_warning_notify_click", 0);
    paramEditor.putInt("weather_warning_application_click", 0);
  }
  
  private static void b(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, int paramInt, StringBuffer paramStringBuffer)
  {
    int i = paramSharedPreferences.getInt(paramString2, 0);
    if (i != 0) {
      paramStringBuffer.append(paramString1).append(paramInt).append("||").append(i).append("\r\n");
    }
  }
  
  private static void b(StringBuffer paramStringBuffer, Context paramContext, SharedPreferences paramSharedPreferences)
  {
    int j = 1;
    String str = a(paramContext, paramSharedPreferences);
    a(str, paramSharedPreferences.getInt("widget42_to_detail", 0) + 0 + paramSharedPreferences.getInt("widget41_to_detail", 0) + paramSharedPreferences.getInt("widget21_to_detail", 0) + paramSharedPreferences.getInt("widget11_to_detail", 0), 1, paramStringBuffer);
    a(str, paramSharedPreferences.getInt("appwidget42_to_detail", 0) + 0 + paramSharedPreferences.getInt("appwidget41_to_detail", 0) + paramSharedPreferences.getInt("appwidget21_to_detail", 0), 2, paramStringBuffer);
    b(str, paramSharedPreferences, "count_share_screenshot", 3, paramStringBuffer);
    b(str, paramSharedPreferences, "count_share_camera", 4, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_houly", 5, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_houly_graph", 6, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_daily", 7, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_daily_graph", 8, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_wind", 9, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_wind_graph", 10, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_rain", 11, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_rain_graph", 12, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_theme", 13, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_edit_city", 14, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_setting", 15, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_feedback", 16, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_msg_center", 17, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_apps_recommend", 18, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_widget_theme", 19, paramStringBuffer);
    b(str, paramSharedPreferences, "count_send_feedback", 20, paramStringBuffer);
    b(str, paramSharedPreferences, "weather_warning_notify_click", 21, paramStringBuffer);
    b(str, paramSharedPreferences, "weather_warning_application_click", 22, paramStringBuffer);
    b(str, paramSharedPreferences, "weather_warning_list_show", 23, paramStringBuffer);
    b(str, paramSharedPreferences, "weather_warning_detail_show", 24, paramStringBuffer);
    b(str, paramSharedPreferences, "user_behavior_maps", 25, paramStringBuffer);
    b(str, paramSharedPreferences, "maps_tab_radar", 26, paramStringBuffer);
    b(str, paramSharedPreferences, "map_tab_satellite", 27, paramStringBuffer);
    b(str, paramSharedPreferences, "maps_tab_map_detail", 29, paramStringBuffer);
    b(str, paramSharedPreferences, "maps_tab_map_detail", 30, paramStringBuffer);
    b(str, paramSharedPreferences, "key_gowidget_theme_switcher_click", 31, paramStringBuffer);
    b(str, paramSharedPreferences, "key_home_open_sidebar", 32, paramStringBuffer);
    Object localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext.getApplicationContext());
    int i = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).h().c().size();
    if (i < 1)
    {
      localObject = ((com.gau.go.launcherex.gowidget.weather.c.c)localObject).f().a();
      a(str, ((q)localObject).l, 211, paramStringBuffer);
      a(str, ((q)localObject).s, 212, paramStringBuffer);
      a(str, ((q)localObject).m, 213, paramStringBuffer);
      a(str, ((q)localObject).b, 214, paramStringBuffer);
      a(str, paramSharedPreferences, "count_gowidget_11", 215, paramStringBuffer);
      a(str, paramSharedPreferences, "count_gowidget_21", 216, paramStringBuffer);
      a(str, paramSharedPreferences, "count_gowidget_41", 217, paramStringBuffer);
      a(str, paramSharedPreferences, "count_gowidget_42", 218, paramStringBuffer);
      if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget21Provider.class)).length <= 0) {
        break label847;
      }
      i = 1;
      label618:
      a(str, i, 219, paramStringBuffer);
      if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget41Provider.class)).length <= 0) {
        break label852;
      }
      i = 1;
      label652:
      a(str, i, 220, paramStringBuffer);
      if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget42Provider.class)).length <= 0) {
        break label857;
      }
      i = 1;
      label686:
      a(str, i, 221, paramStringBuffer);
      if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetDays41Provider.class)).length <= 0) {
        break label862;
      }
      i = 1;
      label720:
      a(str, i, 222, paramStringBuffer);
      if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetDays42Provider.class)).length <= 0) {
        break label867;
      }
    }
    label847:
    label852:
    label857:
    label862:
    label867:
    for (i = j;; i = 0)
    {
      a(str, i, 223, paramStringBuffer);
      a(str, paramSharedPreferences, "count_gowidget_days_41", 224, paramStringBuffer);
      a(str, paramSharedPreferences, "count_gowidget_days_42", 225, paramStringBuffer);
      return;
      if (i == 1)
      {
        a(str, 1, 200, paramStringBuffer);
        break;
      }
      if (i <= 4)
      {
        a(str, 1, 201, paramStringBuffer);
        break;
      }
      if (i > 9) {
        break;
      }
      a(str, 1, 202, paramStringBuffer);
      break;
      i = 0;
      break label618;
      i = 0;
      break label652;
      i = 0;
      break label686;
      i = 0;
      break label720;
    }
  }
  
  public static String c()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if (localObject != null)
      {
        paramContext = (Context)localObject;
        if (((String)localObject).length() >= 0) {}
      }
      else
      {
        paramContext = "";
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 474	com/gau/go/launcherex/gowidget/statistics/y:z	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload 6
    //   12: ifnull +50 -> 62
    //   15: aload 6
    //   17: astore 5
    //   19: aload 6
    //   21: ldc -15
    //   23: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +36 -> 62
    //   29: invokestatic 480	android/os/SystemClock:elapsedRealtime	()J
    //   32: lstore_1
    //   33: new 482	java/util/Random
    //   36: dup
    //   37: invokespecial 483	java/util/Random:<init>	()V
    //   40: invokevirtual 486	java/util/Random:nextLong	()J
    //   43: invokestatic 492	java/lang/Math:abs	(J)J
    //   46: lstore_3
    //   47: lload_1
    //   48: lload_3
    //   49: ladd
    //   50: lstore_1
    //   51: aload_0
    //   52: lload_1
    //   53: invokestatic 494	com/gau/go/launcherex/gowidget/statistics/y:a	(Landroid/content/Context;J)V
    //   56: lload_1
    //   57: invokestatic 197	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   70: goto -14 -> 56
    //   73: astore_0
    //   74: goto -8 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   32	25	1	l1	long
    //   46	3	3	l2	long
    //   8	55	5	str1	String
    //   4	16	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   33	47	65	java/lang/Exception
    //   51	56	73	java/lang/Exception
  }
  
  public static int e(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  /* Error */
  public static String f(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 500	com/gau/go/launcherex/gowidget/statistics/y:a	Ljava/lang/String;
    //   3: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +61 -> 67
    //   9: aload_0
    //   10: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   13: ldc_w 505
    //   16: invokevirtual 511	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   19: astore_3
    //   20: aconst_null
    //   21: astore_1
    //   22: aconst_null
    //   23: astore_2
    //   24: new 513	java/io/BufferedReader
    //   27: dup
    //   28: new 515	java/io/InputStreamReader
    //   31: dup
    //   32: aload_3
    //   33: ldc 69
    //   35: invokespecial 518	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 521	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_0
    //   42: aload_0
    //   43: astore_1
    //   44: aload_0
    //   45: invokevirtual 524	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: putstatic 500	com/gau/go/launcherex/gowidget/statistics/y:a	Ljava/lang/String;
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 525	java/io/BufferedReader:close	()V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 528	java/io/InputStream:close	()V
    //   67: getstatic 500	com/gau/go/launcherex/gowidget/statistics/y:a	Ljava/lang/String;
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   76: goto -9 -> 67
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: invokevirtual 530	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 525	java/io/BufferedReader:close	()V
    //   96: aload_3
    //   97: ifnull -30 -> 67
    //   100: aload_3
    //   101: invokevirtual 528	java/io/InputStream:close	()V
    //   104: goto -37 -> 67
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   112: goto -45 -> 67
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: astore_2
    //   120: aload_0
    //   121: astore_1
    //   122: aload_2
    //   123: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 525	java/io/BufferedReader:close	()V
    //   134: aload_3
    //   135: ifnull -68 -> 67
    //   138: aload_3
    //   139: invokevirtual 528	java/io/InputStream:close	()V
    //   142: goto -75 -> 67
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   150: goto -83 -> 67
    //   153: astore_0
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 525	java/io/BufferedReader:close	()V
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 528	java/io/InputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   177: goto -7 -> 170
    //   180: astore_0
    //   181: goto -27 -> 154
    //   184: astore_2
    //   185: goto -65 -> 120
    //   188: astore_2
    //   189: goto -107 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   21	63	1	localContext1	Context
    //   115	4	1	localIOException1	IOException
    //   121	38	1	localContext2	Context
    //   172	2	1	localIOException2	IOException
    //   23	1	2	localObject	Object
    //   79	38	2	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   119	4	2	localIOException3	IOException
    //   184	1	2	localIOException4	IOException
    //   188	1	2	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   19	148	3	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   55	59	71	java/io/IOException
    //   63	67	71	java/io/IOException
    //   24	42	79	java/io/UnsupportedEncodingException
    //   92	96	107	java/io/IOException
    //   100	104	107	java/io/IOException
    //   24	42	115	java/io/IOException
    //   130	134	145	java/io/IOException
    //   138	142	145	java/io/IOException
    //   24	42	153	finally
    //   122	126	153	finally
    //   158	162	172	java/io/IOException
    //   166	170	172	java/io/IOException
    //   44	51	180	finally
    //   84	88	180	finally
    //   44	51	184	java/io/IOException
    //   44	51	188	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  public static String g(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 533	com/gau/go/launcherex/gowidget/statistics/y:b	Ljava/lang/String;
    //   3: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +61 -> 67
    //   9: aload_0
    //   10: invokevirtual 504	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   13: ldc_w 534
    //   16: invokevirtual 511	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   19: astore_3
    //   20: aconst_null
    //   21: astore_1
    //   22: aconst_null
    //   23: astore_2
    //   24: new 513	java/io/BufferedReader
    //   27: dup
    //   28: new 515	java/io/InputStreamReader
    //   31: dup
    //   32: aload_3
    //   33: ldc 69
    //   35: invokespecial 518	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 521	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_0
    //   42: aload_0
    //   43: astore_1
    //   44: aload_0
    //   45: invokevirtual 524	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: putstatic 533	com/gau/go/launcherex/gowidget/statistics/y:b	Ljava/lang/String;
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 525	java/io/BufferedReader:close	()V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 528	java/io/InputStream:close	()V
    //   67: getstatic 533	com/gau/go/launcherex/gowidget/statistics/y:b	Ljava/lang/String;
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   76: goto -9 -> 67
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: invokevirtual 530	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 525	java/io/BufferedReader:close	()V
    //   96: aload_3
    //   97: ifnull -30 -> 67
    //   100: aload_3
    //   101: invokevirtual 528	java/io/InputStream:close	()V
    //   104: goto -37 -> 67
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   112: goto -45 -> 67
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: astore_2
    //   120: aload_0
    //   121: astore_1
    //   122: aload_2
    //   123: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 525	java/io/BufferedReader:close	()V
    //   134: aload_3
    //   135: ifnull -68 -> 67
    //   138: aload_3
    //   139: invokevirtual 528	java/io/InputStream:close	()V
    //   142: goto -75 -> 67
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   150: goto -83 -> 67
    //   153: astore_0
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 525	java/io/BufferedReader:close	()V
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 528	java/io/InputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   177: goto -7 -> 170
    //   180: astore_0
    //   181: goto -27 -> 154
    //   184: astore_2
    //   185: goto -65 -> 120
    //   188: astore_2
    //   189: goto -107 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   21	63	1	localContext1	Context
    //   115	4	1	localIOException1	IOException
    //   121	38	1	localContext2	Context
    //   172	2	1	localIOException2	IOException
    //   23	1	2	localObject	Object
    //   79	38	2	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   119	4	2	localIOException3	IOException
    //   184	1	2	localIOException4	IOException
    //   188	1	2	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   19	148	3	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   55	59	71	java/io/IOException
    //   63	67	71	java/io/IOException
    //   24	42	79	java/io/UnsupportedEncodingException
    //   92	96	107	java/io/IOException
    //   100	104	107	java/io/IOException
    //   24	42	115	java/io/IOException
    //   130	134	145	java/io/IOException
    //   138	142	145	java/io/IOException
    //   24	42	153	finally
    //   122	126	153	finally
    //   158	162	172	java/io/IOException
    //   166	170	172	java/io/IOException
    //   44	51	180	finally
    //   84	88	180	finally
    //   44	51	184	java/io/IOException
    //   44	51	188	java/io/UnsupportedEncodingException
  }
  
  public static boolean h(Context paramContext)
  {
    return f(paramContext).equals("200");
  }
  
  public static boolean i(Context paramContext)
  {
    String str = f(paramContext);
    String[] arrayOfString = paramContext.getResources().getStringArray(2131558401);
    int i = 0;
    if (i < arrayOfString.length) {
      if (!str.equals(arrayOfString[i])) {}
    }
    for (;;)
    {
      return false;
      i += 1;
      break;
      paramContext = paramContext.getResources().getStringArray(2131558400);
      i = 0;
      while (i < paramContext.length)
      {
        if (str.equals(paramContext[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static String j(Context paramContext)
  {
    return String.format("%s_%s", new Object[] { paramContext.getResources().getConfiguration().locale.getLanguage(), n(paramContext) }).toLowerCase(Locale.US);
  }
  
  public static String k(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getLanguage();
  }
  
  public static String l(Context paramContext)
  {
    d locald = d.a(paramContext);
    if (locald != null) {}
    for (paramContext = locald.b();; paramContext = paramContext.getApplicationContext().getResources().getConfiguration().locale.getLanguage()) {
      return paramContext.toLowerCase(Locale.US);
    }
  }
  
  public static String m(Context paramContext)
  {
    d locald = d.a(paramContext);
    if (locald != null) {}
    for (paramContext = locald.e();; paramContext = paramContext.getApplicationContext().getResources().getConfiguration().locale.getCountry()) {
      return paramContext.toLowerCase(Locale.US);
    }
  }
  
  public static String n(Context paramContext)
  {
    return v.a(paramContext);
  }
  
  public static boolean o(Context paramContext)
  {
    if (i(paramContext)) {}
    Object localObject;
    label65:
    do
    {
      do
      {
        return false;
      } while (paramContext == null);
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (((TelephonyManager)localObject).getSimState() != 5) {}
      for (int i = 1;; i = 0)
      {
        localObject = ((TelephonyManager)localObject).getSimOperator();
        if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          break label65;
        }
        if (r.a(paramContext) != 1) {
          break;
        }
        return true;
      }
    } while (!((String)localObject).startsWith("460"));
    return true;
  }
  
  public static boolean p(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = v.a(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.equalsIgnoreCase("CN")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String q(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    return i + "_" + j;
  }
  
  public static String r(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext.getSimState() != 5) {}
    for (int i = 1;; i = 0)
    {
      String str = paramContext.getSimOperator();
      if (i == 0)
      {
        paramContext = str;
        if (!TextUtils.isEmpty(str)) {}
      }
      else
      {
        paramContext = "";
      }
      return paramContext;
    }
  }
  
  public static boolean s(Context paramContext)
  {
    return a(paramContext, "com.android.vending");
  }
  
  public static boolean t(Context paramContext)
  {
    return (!o(paramContext)) && (s(paramContext));
  }
  
  public static int u(Context paramContext)
  {
    if (g.a(paramContext))
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        if (paramContext.getType() == 1) {
          return 1;
        }
        if (paramContext.getType() == 0) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  public static String v(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String w(Context paramContext)
  {
    try
    {
      paramContext = AdvertisingIdClient.getAdvertisingIdInfo(paramContext).getId();
      return paramContext;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String x(Context paramContext)
  {
    paramContext = new StringBuilder();
    Time localTime = new Time("Asia/Shanghai");
    localTime.setToNow();
    paramContext.append(localTime.year);
    paramContext.append('-');
    paramContext.append(localTime.month + 1);
    paramContext.append('-');
    paramContext.append(localTime.monthDay);
    paramContext.append(' ');
    paramContext.append(localTime.hour);
    paramContext.append(':');
    paramContext.append(localTime.minute);
    paramContext.append(':');
    paramContext.append(localTime.second);
    paramContext.append(' ');
    paramContext.append(localTime.gmtoff);
    return paramContext.toString();
  }
  
  public static String y(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramContext = paramContext.getResources().getDisplayMetrics();
    localStringBuffer.append(Math.min(paramContext.widthPixels, paramContext.heightPixels));
    localStringBuffer.append("*");
    localStringBuffer.append(Math.max(paramContext.widthPixels, paramContext.heightPixels));
    return localStringBuffer.toString();
  }
  
  private static String z(Context paramContext)
  {
    return paramContext.getSharedPreferences("randomdeviceid", 0).getString("random_device_id", "0000000000000000");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */