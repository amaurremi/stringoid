package com.gau.go.launcherex.gowidget.weather.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import com.gtp.a.a.a.b;
import com.jiubang.goweather.a.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = Environment.getExternalStorageDirectory() + "/GOLauncherEX/GoWeatherWidget/cache/key_go_weather_data_cache";
  
  public static com.jiubang.goweather.a.a a(Context paramContext)
  {
    Object localObject = null;
    String str = b(paramContext);
    paramContext = (Context)localObject;
    if (!TextUtils.isEmpty(str)) {
      paramContext = a(str);
    }
    return paramContext;
  }
  
  private static com.jiubang.goweather.a.a a(String paramString)
  {
    com.jiubang.goweather.a.a locala2 = null;
    com.jiubang.goweather.a.a locala1 = locala2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      locala1 = locala2;
      if (paramString != null)
      {
        locala2 = a(paramString);
        locala1 = locala2;
        if (locala2 != null)
        {
          a(paramString, locala2);
          locala1 = locala2;
        }
      }
      return locala1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  /* Error */
  private static com.jiubang.goweather.a.a a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ldc 71
    //   5: invokevirtual 75	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   8: astore 4
    //   10: aload_2
    //   11: astore_0
    //   12: aload 4
    //   14: ifnull +407 -> 421
    //   17: aload 4
    //   19: ldc 77
    //   21: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_0
    //   25: aload 4
    //   27: ldc 71
    //   29: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_2
    //   33: aload_0
    //   34: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +386 -> 423
    //   40: aload_2
    //   41: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +379 -> 423
    //   47: new 83	com/jiubang/goweather/a/a
    //   50: dup
    //   51: aload_2
    //   52: aload_0
    //   53: lconst_0
    //   54: invokespecial 86	com/jiubang/goweather/a/a:<init>	(Ljava/lang/String;Ljava/lang/String;J)V
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 88
    //   62: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_3
    //   66: aload_3
    //   67: astore_0
    //   68: aload_3
    //   69: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifeq +6 -> 78
    //   75: ldc 90
    //   77: astore_0
    //   78: aload_2
    //   79: aload_0
    //   80: invokevirtual 92	com/jiubang/goweather/a/a:a	(Ljava/lang/String;)V
    //   83: aload 4
    //   85: ldc 94
    //   87: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_3
    //   91: aload_3
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifeq +6 -> 103
    //   100: ldc 90
    //   102: astore_0
    //   103: aload_2
    //   104: aload_0
    //   105: invokevirtual 96	com/jiubang/goweather/a/a:b	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: aload 4
    //   111: ldc 98
    //   113: ldc2_w 99
    //   116: invokevirtual 104	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   119: l2i
    //   120: invokevirtual 108	com/jiubang/goweather/a/a:f	(I)V
    //   123: aload 4
    //   125: ldc 110
    //   127: invokevirtual 81	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore_0
    //   131: aload_2
    //   132: ldc 111
    //   134: invokevirtual 114	com/jiubang/goweather/a/a:a	(F)V
    //   137: aload_2
    //   138: ldc 111
    //   140: invokevirtual 116	com/jiubang/goweather/a/a:b	(F)V
    //   143: aload_0
    //   144: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +42 -> 189
    //   150: aload_0
    //   151: ldc 118
    //   153: invokevirtual 124	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   156: astore_0
    //   157: aload_0
    //   158: arraylength
    //   159: iconst_2
    //   160: if_icmpne +29 -> 189
    //   163: aload_2
    //   164: aload_0
    //   165: iconst_0
    //   166: aaload
    //   167: invokestatic 130	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   170: invokevirtual 134	java/lang/Float:floatValue	()F
    //   173: invokevirtual 114	com/jiubang/goweather/a/a:a	(F)V
    //   176: aload_2
    //   177: aload_0
    //   178: iconst_1
    //   179: aaload
    //   180: invokestatic 130	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   183: invokevirtual 134	java/lang/Float:floatValue	()F
    //   186: invokevirtual 116	com/jiubang/goweather/a/a:b	(F)V
    //   189: aload 4
    //   191: ldc -120
    //   193: iconst_0
    //   194: invokevirtual 140	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   197: ifeq +236 -> 433
    //   200: iconst_1
    //   201: istore_1
    //   202: aload_2
    //   203: iload_1
    //   204: invokevirtual 142	com/jiubang/goweather/a/a:a	(I)V
    //   207: aload 4
    //   209: ldc -112
    //   211: iconst_0
    //   212: invokevirtual 140	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   215: ifeq +223 -> 438
    //   218: iconst_1
    //   219: istore_1
    //   220: aload_2
    //   221: iload_1
    //   222: invokevirtual 146	com/jiubang/goweather/a/a:b	(I)V
    //   225: iconst_2
    //   226: newarray <illegal type>
    //   228: astore_0
    //   229: aload_0
    //   230: dup
    //   231: iconst_0
    //   232: ldc2_w 147
    //   235: dastore
    //   236: dup
    //   237: iconst_1
    //   238: ldc2_w 147
    //   241: dastore
    //   242: pop
    //   243: aload 4
    //   245: ldc -106
    //   247: invokevirtual 154	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   250: astore_3
    //   251: aload_3
    //   252: ifnull +70 -> 322
    //   255: aload_3
    //   256: invokevirtual 160	org/json/JSONArray:length	()I
    //   259: iconst_2
    //   260: if_icmpne +62 -> 322
    //   263: aload_0
    //   264: iconst_0
    //   265: aload_3
    //   266: iconst_0
    //   267: invokevirtual 164	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   270: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   273: invokestatic 172	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   276: invokevirtual 176	java/lang/Double:doubleValue	()D
    //   279: dastore
    //   280: aload_0
    //   281: iconst_1
    //   282: aload_3
    //   283: iconst_1
    //   284: invokevirtual 164	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   287: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   290: invokestatic 172	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   293: invokevirtual 176	java/lang/Double:doubleValue	()D
    //   296: dastore
    //   297: aload_0
    //   298: iconst_0
    //   299: daload
    //   300: ldc2_w 147
    //   303: dcmpl
    //   304: ifeq +18 -> 322
    //   307: aload_0
    //   308: iconst_1
    //   309: daload
    //   310: ldc2_w 147
    //   313: dcmpl
    //   314: ifeq +8 -> 322
    //   317: aload_2
    //   318: aload_0
    //   319: invokevirtual 179	com/jiubang/goweather/a/a:a	([D)V
    //   322: iconst_2
    //   323: newarray <illegal type>
    //   325: astore_0
    //   326: aload_0
    //   327: dup
    //   328: iconst_0
    //   329: ldc2_w 147
    //   332: dastore
    //   333: dup
    //   334: iconst_1
    //   335: ldc2_w 147
    //   338: dastore
    //   339: pop
    //   340: aload 4
    //   342: ldc -75
    //   344: invokevirtual 154	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   347: astore_3
    //   348: aload_3
    //   349: ifnull +70 -> 419
    //   352: aload_3
    //   353: invokevirtual 160	org/json/JSONArray:length	()I
    //   356: iconst_2
    //   357: if_icmpne +62 -> 419
    //   360: aload_0
    //   361: iconst_0
    //   362: aload_3
    //   363: iconst_0
    //   364: invokevirtual 164	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   367: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   370: invokestatic 172	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   373: invokevirtual 176	java/lang/Double:doubleValue	()D
    //   376: dastore
    //   377: aload_0
    //   378: iconst_1
    //   379: aload_3
    //   380: iconst_1
    //   381: invokevirtual 164	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   384: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   387: invokestatic 172	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   390: invokevirtual 176	java/lang/Double:doubleValue	()D
    //   393: dastore
    //   394: aload_0
    //   395: iconst_0
    //   396: daload
    //   397: ldc2_w 147
    //   400: dcmpl
    //   401: ifeq +18 -> 419
    //   404: aload_0
    //   405: iconst_1
    //   406: daload
    //   407: ldc2_w 147
    //   410: dcmpl
    //   411: ifeq +8 -> 419
    //   414: aload_2
    //   415: aload_0
    //   416: invokevirtual 183	com/jiubang/goweather/a/a:b	([D)V
    //   419: aload_2
    //   420: astore_0
    //   421: aload_0
    //   422: areturn
    //   423: aconst_null
    //   424: areturn
    //   425: astore_0
    //   426: aload_0
    //   427: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   430: goto -241 -> 189
    //   433: iconst_0
    //   434: istore_1
    //   435: goto -233 -> 202
    //   438: iconst_0
    //   439: istore_1
    //   440: goto -220 -> 220
    //   443: astore_3
    //   444: aload_3
    //   445: invokevirtual 185	java/lang/NumberFormatException:printStackTrace	()V
    //   448: goto -151 -> 297
    //   451: astore_3
    //   452: aload_3
    //   453: invokevirtual 65	org/json/JSONException:printStackTrace	()V
    //   456: goto -159 -> 297
    //   459: astore_3
    //   460: aload_3
    //   461: invokevirtual 185	java/lang/NumberFormatException:printStackTrace	()V
    //   464: goto -70 -> 394
    //   467: astore_3
    //   468: aload_3
    //   469: invokevirtual 65	org/json/JSONException:printStackTrace	()V
    //   472: goto -78 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramJSONObject	JSONObject
    //   201	239	1	i	int
    //   1	419	2	localObject1	Object
    //   65	315	3	localObject2	Object
    //   443	2	3	localNumberFormatException1	NumberFormatException
    //   451	2	3	localJSONException1	JSONException
    //   459	2	3	localNumberFormatException2	NumberFormatException
    //   467	2	3	localJSONException2	JSONException
    //   8	333	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   150	189	425	java/lang/Exception
    //   263	297	443	java/lang/NumberFormatException
    //   263	297	451	org/json/JSONException
    //   360	394	459	java/lang/NumberFormatException
    //   360	394	467	org/json/JSONException
  }
  
  private static void a(JSONObject paramJSONObject, com.jiubang.goweather.a.a parama)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("current");
    if (localJSONObject != null)
    {
      e locale = new e();
      parama.g = locale;
      parama = localJSONObject.optString("status");
      paramJSONObject = parama;
      if (TextUtils.isEmpty(parama)) {
        paramJSONObject = "--";
      }
      locale.d(paramJSONObject);
      int j = localJSONObject.optInt("statusType");
      int i = j;
      if (j == 55536) {
        i = 1;
      }
      locale.h(i);
      locale.i((float)localJSONObject.optDouble("realTemp", -10000.0D));
      locale.b((float)localJSONObject.optDouble("feelLike", -10000.0D));
      locale.i(localJSONObject.optInt("humidity", 55536));
      locale.g((float)localJSONObject.optDouble("high", -10000.0D));
      locale.h((float)localJSONObject.optDouble("low", -10000.0D));
      parama = localJSONObject.optString("windDir");
      paramJSONObject = parama;
      if (TextUtils.isEmpty(parama)) {
        paramJSONObject = "--";
      }
      locale.c(paramJSONObject);
      locale.f(localJSONObject.optInt("windDirType", 1));
      locale.a((float)localJSONObject.optDouble("windStrengthInt", -10000.0D));
      locale.c((float)localJSONObject.optDouble("visibility", -10000.0D));
      locale.d((float)localJSONObject.optDouble("barometer", -10000.0D));
      locale.e((float)localJSONObject.optDouble("dewpoint", -10000.0D));
      parama = localJSONObject.optString("sunrise");
      paramJSONObject = parama;
      if (TextUtils.isEmpty(parama)) {
        paramJSONObject = "--";
      }
      locale.a(paramJSONObject);
      parama = localJSONObject.optString("sunset");
      paramJSONObject = parama;
      if (TextUtils.isEmpty(parama)) {
        paramJSONObject = "--";
      }
      locale.b(paramJSONObject);
      locale.f((float)localJSONObject.optDouble("uvIndex", -10000.0D));
      locale.g(localJSONObject.optInt("pop", 55536));
      locale.j((float)localJSONObject.optDouble("rainfall", -10000.0D));
    }
  }
  
  private static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  @SuppressLint({"WorldReadableFiles"})
  public static String b(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1;
    if (a())
    {
      paramContext = (Context)localObject2;
      if (new File(a).exists())
      {
        localObject1 = b.a(a);
        paramContext = (Context)localObject2;
        if (localObject1 != null) {
          paramContext = new String((byte[])localObject1);
        }
      }
    }
    for (;;)
    {
      return paramContext;
      try
      {
        localObject1 = paramContext.createPackageContext("com.gau.go.launcherex", 2);
        paramContext = (Context)localObject2;
        if (localObject1 == null) {
          continue;
        }
        return ((Context)localObject1).getSharedPreferences("name_sharedpreferences_weather_data_cache", 1).getString("key_go_weather_data_cache", null);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          localObject1 = null;
        }
      }
    }
  }
  
  public static int[] c(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -1;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = -1;
    tmp9_5;
    try
    {
      paramContext = paramContext.createPackageContext("com.gau.go.launcherex", 2);
      if (paramContext != null)
      {
        paramContext = paramContext.getSharedPreferences("name_sharedpreferences_weather_data_cache", 1);
        arrayOfInt[0] = paramContext.getInt("key_go_weather_tempunit_value", -1);
        arrayOfInt[1] = paramContext.getInt("key_go_weather_date_format_value", -1);
      }
      return arrayOfInt;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */