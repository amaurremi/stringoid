package cmn;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.util.Log;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

@TargetApi(4)
public final class z
  implements Serializable
{
  public static final boolean g;
  private static z h = null;
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public String e = "";
  public Set f = new HashSet();
  private int i = -1;
  private String j = null;
  private String k = "";
  private String l = "";
  private final int m;
  private final long n;
  private final String o;
  private final int p;
  private final String q;
  private final String r;
  private final String s;
  private final String t;
  private final String u;
  private int v;
  private String w;
  private String x;
  private String y;
  private Context z;
  
  static
  {
    if (("google_sdk".equals(Build.PRODUCT)) || ("sdk".equals(Build.PRODUCT))) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      return;
    }
  }
  
  private z(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2)
  {
    this.m = paramInt1;
    this.p = paramInt2;
    this.q = paramString1;
    this.n = paramLong;
    this.o = paramString2;
    this.r = (Build.BRAND + " " + Build.DEVICE);
    this.s = Build.MODEL;
    paramString1 = "";
    Field[] arrayOfField = Build.class.getFields();
    paramInt2 = arrayOfField.length;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      paramString2 = arrayOfField[paramInt1];
      if (paramString2.getName().equals("MANUFACTURER")) {}
      for (;;)
      {
        try
        {
          paramString2 = (String)paramString2.get(null);
          paramString1 = paramString2;
          paramInt1 += 1;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
        }
      }
    }
    this.t = paramString1;
    this.u = Build.PRODUCT;
  }
  
  public static long a(String paramString)
  {
    int i1 = 0;
    long l1 = 0L;
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      long l2;
      int i2;
      for (i1 = 0;; i1 = i2)
      {
        l2 = l1;
        if (i1 >= 8) {
          break;
        }
        i2 = arrayOfByte[i1];
        l2 = i2;
        i2 = i1 + 1;
        l1 = (l2 & 0xFF) << i1 * 8 | l1;
      }
      return l2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Log.e("scm", "MD5 not found!");
      for (;;)
      {
        l2 = l1;
        if (i1 >= paramString.length()) {
          break;
        }
        l1 = l1 * 7265812761L + (paramString.charAt(i1) + '{') * 41;
        i1 += 1;
      }
    }
  }
  
  /* Error */
  public static z a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 46	cmn/z:h	Lcmn/z;
    //   10: ifnull +12 -> 22
    //   13: getstatic 46	cmn/z:h	Lcmn/z;
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: invokevirtual 204	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   26: astore 12
    //   28: aload 12
    //   30: invokevirtual 208	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 9
    //   35: aload 12
    //   37: invokestatic 214	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   40: astore 13
    //   42: new 216	java/util/Date
    //   45: dup
    //   46: invokespecial 217	java/util/Date:<init>	()V
    //   49: invokevirtual 221	java/util/Date:getTime	()J
    //   52: ldc2_w 222
    //   55: ldiv
    //   56: lstore 5
    //   58: lload 5
    //   60: l2i
    //   61: istore 4
    //   63: aload 13
    //   65: ldc -31
    //   67: iload 4
    //   69: invokeinterface 231 3 0
    //   74: istore_1
    //   75: iload_3
    //   76: istore_2
    //   77: aload 13
    //   79: ldc -23
    //   81: iconst_0
    //   82: invokeinterface 231 3 0
    //   87: istore_3
    //   88: iload_3
    //   89: istore_2
    //   90: aload 13
    //   92: ldc -21
    //   94: lconst_0
    //   95: invokeinterface 239 4 0
    //   100: lstore 5
    //   102: iload_1
    //   103: istore_2
    //   104: iload_3
    //   105: istore_1
    //   106: iload 4
    //   108: iload_2
    //   109: if_icmpeq +26 -> 135
    //   112: iload_1
    //   113: istore_3
    //   114: lload 5
    //   116: lstore 7
    //   118: iload_1
    //   119: ifne +87 -> 206
    //   122: iload_1
    //   123: istore_3
    //   124: lload 5
    //   126: lstore 7
    //   128: lload 5
    //   130: lconst_0
    //   131: lcmp
    //   132: ifne +74 -> 206
    //   135: aload 13
    //   137: invokeinterface 243 1 0
    //   142: astore 10
    //   144: aload 9
    //   146: invokestatic 246	cmn/z:a	(Landroid/content/ContentResolver;)Ljava/lang/String;
    //   149: astore 9
    //   151: aload 9
    //   153: invokevirtual 249	java/lang/String:hashCode	()I
    //   156: istore_3
    //   157: aload 9
    //   159: invokestatic 251	cmn/z:a	(Ljava/lang/String;)J
    //   162: lstore 7
    //   164: aload 10
    //   166: ldc -31
    //   168: iload_2
    //   169: invokeinterface 257 3 0
    //   174: pop
    //   175: aload 10
    //   177: ldc -23
    //   179: iload_3
    //   180: invokeinterface 257 3 0
    //   185: pop
    //   186: aload 10
    //   188: ldc -21
    //   190: lload 7
    //   192: invokeinterface 261 4 0
    //   197: pop
    //   198: invokestatic 266	cmn/a:a	()Lcmn/a;
    //   201: aload 10
    //   203: invokevirtual 269	cmn/a:a	(Landroid/content/SharedPreferences$Editor;)V
    //   206: aload 12
    //   208: invokevirtual 208	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   211: ldc_w 271
    //   214: invokestatic 277	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 10
    //   219: aload 10
    //   221: astore 9
    //   223: aload 10
    //   225: ifnonnull +7 -> 232
    //   228: ldc 76
    //   230: astore 9
    //   232: new 2	cmn/z
    //   235: dup
    //   236: iload_3
    //   237: iload_2
    //   238: getstatic 282	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   241: lload 7
    //   243: aload 9
    //   245: invokespecial 284	cmn/z:<init>	(IILjava/lang/String;JLjava/lang/String;)V
    //   248: astore 10
    //   250: aload 10
    //   252: aload 12
    //   254: putfield 286	cmn/z:z	Landroid/content/Context;
    //   257: aload 10
    //   259: aload 12
    //   261: invokespecial 289	cmn/z:b	(Landroid/content/Context;)V
    //   264: aload 12
    //   266: invokevirtual 292	android/content/Context:getPackageName	()Ljava/lang/String;
    //   269: astore 11
    //   271: aload 11
    //   273: astore 9
    //   275: aload 11
    //   277: invokestatic 295	cmn/z:b	(Ljava/lang/String;)Z
    //   280: ifeq +19 -> 299
    //   283: aload 11
    //   285: aload 11
    //   287: bipush 46
    //   289: invokevirtual 299	java/lang/String:lastIndexOf	(I)I
    //   292: iconst_1
    //   293: iadd
    //   294: invokevirtual 303	java/lang/String:substring	(I)Ljava/lang/String;
    //   297: astore 9
    //   299: aload 10
    //   301: aload 9
    //   303: putfield 305	cmn/z:x	Ljava/lang/String;
    //   306: aload 10
    //   308: aload 12
    //   310: invokevirtual 292	android/content/Context:getPackageName	()Ljava/lang/String;
    //   313: putfield 307	cmn/z:y	Ljava/lang/String;
    //   316: aload 10
    //   318: aload 13
    //   320: invokestatic 312	cmn/ad:a	(Landroid/content/SharedPreferences;)Ljava/lang/String;
    //   323: putfield 74	cmn/z:j	Ljava/lang/String;
    //   326: aload 12
    //   328: ldc_w 314
    //   331: invokevirtual 318	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   334: checkcast 320	android/telephony/TelephonyManager
    //   337: astore 9
    //   339: aload 10
    //   341: aload 9
    //   343: invokevirtual 323	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   346: putfield 78	cmn/z:k	Ljava/lang/String;
    //   349: aload 10
    //   351: getfield 78	cmn/z:k	Ljava/lang/String;
    //   354: ifnonnull +10 -> 364
    //   357: aload 10
    //   359: ldc 76
    //   361: putfield 78	cmn/z:k	Ljava/lang/String;
    //   364: aload 10
    //   366: aload 9
    //   368: invokevirtual 326	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   371: putfield 80	cmn/z:l	Ljava/lang/String;
    //   374: aload 10
    //   376: getfield 80	cmn/z:l	Ljava/lang/String;
    //   379: ifnonnull +10 -> 389
    //   382: aload 10
    //   384: ldc 76
    //   386: putfield 80	cmn/z:l	Ljava/lang/String;
    //   389: aload 10
    //   391: aload 9
    //   393: invokevirtual 329	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   396: putfield 90	cmn/z:e	Ljava/lang/String;
    //   399: aload 10
    //   401: getfield 90	cmn/z:e	Ljava/lang/String;
    //   404: ifnonnull +10 -> 414
    //   407: aload 10
    //   409: ldc 76
    //   411: putfield 90	cmn/z:e	Ljava/lang/String;
    //   414: aload 10
    //   416: putstatic 46	cmn/z:h	Lcmn/z;
    //   419: new 331	android/util/DisplayMetrics
    //   422: dup
    //   423: invokespecial 332	android/util/DisplayMetrics:<init>	()V
    //   426: astore 9
    //   428: aload_0
    //   429: ldc_w 334
    //   432: invokevirtual 318	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   435: checkcast 336	android/view/WindowManager
    //   438: invokeinterface 340 1 0
    //   443: aload 9
    //   445: invokevirtual 346	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   448: aload 10
    //   450: aload 9
    //   452: getfield 349	android/util/DisplayMetrics:densityDpi	I
    //   455: putfield 88	cmn/z:d	I
    //   458: aload 10
    //   460: aload 9
    //   462: getfield 352	android/util/DisplayMetrics:heightPixels	I
    //   465: aload 9
    //   467: getfield 355	android/util/DisplayMetrics:widthPixels	I
    //   470: invokestatic 361	java/lang/Math:min	(II)I
    //   473: i2f
    //   474: aload 9
    //   476: getfield 365	android/util/DisplayMetrics:density	F
    //   479: fdiv
    //   480: f2i
    //   481: putfield 82	cmn/z:a	I
    //   484: aload 10
    //   486: astore_0
    //   487: goto -470 -> 17
    //   490: astore_0
    //   491: aload 10
    //   493: astore_0
    //   494: goto -477 -> 17
    //   497: astore 10
    //   499: iload 4
    //   501: istore_1
    //   502: lconst_0
    //   503: lstore 5
    //   505: iload_1
    //   506: istore_3
    //   507: iload_2
    //   508: istore_1
    //   509: iload_3
    //   510: istore_2
    //   511: goto -405 -> 106
    //   514: astore_0
    //   515: ldc 2
    //   517: monitorexit
    //   518: aload_0
    //   519: athrow
    //   520: astore 9
    //   522: goto -108 -> 414
    //   525: astore 10
    //   527: goto -25 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramContext	Context
    //   74	435	1	i1	int
    //   3	508	2	i2	int
    //   1	509	3	i3	int
    //   61	439	4	i4	int
    //   56	448	5	l1	long
    //   116	126	7	l2	long
    //   33	442	9	localObject1	Object
    //   520	1	9	localThrowable	Throwable
    //   142	350	10	localObject2	Object
    //   497	1	10	localException1	Exception
    //   525	1	10	localException2	Exception
    //   269	17	11	str	String
    //   26	301	12	localContext	Context
    //   40	279	13	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   419	484	490	java/lang/Throwable
    //   63	75	497	java/lang/Exception
    //   7	17	514	finally
    //   22	58	514	finally
    //   63	75	514	finally
    //   77	88	514	finally
    //   90	102	514	finally
    //   135	206	514	finally
    //   206	219	514	finally
    //   232	271	514	finally
    //   275	299	514	finally
    //   299	326	514	finally
    //   326	364	514	finally
    //   364	389	514	finally
    //   389	414	514	finally
    //   414	419	514	finally
    //   419	484	514	finally
    //   326	364	520	java/lang/Throwable
    //   364	389	520	java/lang/Throwable
    //   389	414	520	java/lang/Throwable
    //   77	88	525	java/lang/Exception
    //   90	102	525	java/lang/Exception
  }
  
  private static String a(ContentResolver paramContentResolver)
  {
    Object localObject = Settings.Secure.getString(paramContentResolver, "android_id");
    if ((localObject != null) && (!((String)localObject).equals("9774d56d682e549c")))
    {
      paramContentResolver = (ContentResolver)localObject;
      if (!((String)localObject).equals("67ef2b122f51423f")) {}
    }
    else
    {
      paramContentResolver = "";
    }
    localObject = paramContentResolver;
    if (paramContentResolver.length() == 0)
    {
      paramContentResolver = new Random();
      localObject = new StringBuffer();
      int i1 = 0;
      while (i1 < 16)
      {
        ((StringBuffer)localObject).append(paramContentResolver.nextInt(16) + 97);
        i1 += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return (String)localObject;
  }
  
  private void b(Context paramContext)
  {
    if (this.w != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    this.f.clear();
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(0).iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equals(paramContext.getPackageName())) {
        this.i = localPackageInfo.versionCode;
      }
      if (localPackageInfo.packageName.equals("com.android.vending")) {
        this.b = localPackageInfo.versionCode;
      }
      if (b(localPackageInfo.packageName))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        int i2 = localPackageInfo.packageName.lastIndexOf('.');
        localStringBuilder.append(localPackageInfo.packageName.substring(i2 + 1));
      }
      this.f.add(localPackageInfo.packageName);
      i1 += 1;
    }
    this.w = localStringBuilder.toString();
    this.v = i1;
    try
    {
      paramContext = new StatFs("/data/app");
      this.c = ((int)(paramContext.getAvailableBlocks() * paramContext.getBlockSize() / 1024L));
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static boolean b(String paramString)
  {
    return (paramString.startsWith("com.appspot.swisscodemonkeys.")) || (paramString.startsWith("com.apptornado.")) || (paramString.startsWith("com.appbrain."));
  }
  
  public final String a()
  {
    return this.k;
  }
  
  public final String b()
  {
    return this.l;
  }
  
  public final String c()
  {
    return this.r;
  }
  
  public final String d()
  {
    return this.z.getResources().getConfiguration().locale.getLanguage();
  }
  
  public final int e()
  {
    return this.v;
  }
  
  public final int f()
  {
    return this.i;
  }
  
  public final String g()
  {
    return this.q;
  }
  
  public final String h()
  {
    return this.o;
  }
  
  public final String i()
  {
    return aa.b(new byte[] { (byte)(this.m >> 24 & 0xFF), (byte)(this.m >> 16 & 0xFF), (byte)(this.m >> 8 & 0xFF), (byte)(this.m & 0xFF) });
  }
  
  public final String j()
  {
    byte[] arrayOfByte = new byte[8];
    int i1 = 0;
    while (i1 < 8)
    {
      arrayOfByte[i1] = ((byte)(int)(this.n >> i1 * 8 & 0xFF));
      i1 += 1;
    }
    return aa.b(arrayOfByte);
  }
  
  public final int k()
  {
    return this.p;
  }
  
  public final String l()
  {
    return this.y;
  }
  
  public final String m()
  {
    return this.s;
  }
  
  public final String n()
  {
    return this.t;
  }
  
  public final String o()
  {
    return this.u;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */