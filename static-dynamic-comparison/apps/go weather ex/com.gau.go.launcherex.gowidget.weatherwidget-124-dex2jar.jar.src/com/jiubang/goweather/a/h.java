package com.jiubang.goweather.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.billing.v;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  private ArrayList a;
  
  public h(ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  private boolean a(String paramString)
  {
    return paramString.startsWith("[");
  }
  
  private void b(JSONObject paramJSONObject, a parama)
  {
    Object localObject = paramJSONObject.optJSONObject("head");
    if (localObject != null) {
      parama.h(((JSONObject)localObject).optInt("result", -1));
    }
    if (parama.w() == 1)
    {
      long l = paramJSONObject.optLong("updateTimeLong", -10000L);
      if (l == -10000L) {
        break label156;
      }
      parama.a(l);
    }
    for (;;)
    {
      parama.b(paramJSONObject.optLong("timestamp", 0L));
      localObject = paramJSONObject.optJSONObject("weather");
      if (localObject != null)
      {
        parama.d(paramJSONObject.toString());
        parama.c(((JSONObject)localObject).optLong("updateTime"));
        d((JSONObject)localObject, parama);
        e((JSONObject)localObject, parama);
        f((JSONObject)localObject, parama);
        g((JSONObject)localObject, parama);
        h((JSONObject)localObject, parama);
        i((JSONObject)localObject, parama);
        a((JSONObject)localObject, parama);
        c((JSONObject)localObject, parama);
      }
      return;
      label156:
      String str = paramJSONObject.optString("updateTime");
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "--";
      }
      parama.c((String)localObject);
    }
  }
  
  private void c(JSONObject paramJSONObject, a parama)
  {
    paramJSONObject = paramJSONObject.optJSONArray("pollenIndex");
    if (paramJSONObject != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.optJSONObject(i);
        long l = ((JSONObject)localObject).optLong("dateTime", -10000L);
        float f = (float)((JSONObject)localObject).optDouble("pollenLevel", -10000.0D);
        localObject = ((JSONObject)localObject).optJSONArray("pollenValues");
        ArrayList localArrayList2 = new ArrayList();
        if (localObject != null)
        {
          int j = 0;
          while (j < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(j);
            localArrayList2.add(new g(localJSONObject.optString("value", "--"), localJSONObject.optInt("type", 55536), localJSONObject.optString("url", "--")));
            j += 1;
          }
        }
        localArrayList1.add(new f(l, f, localArrayList2));
        i += 1;
      }
      parama.m = localArrayList1;
    }
  }
  
  /* Error */
  private void d(JSONObject paramJSONObject, a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -77
    //   3: invokevirtual 32	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +441 -> 451
    //   13: aload 5
    //   15: ldc -75
    //   17: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: aload 4
    //   24: astore_1
    //   25: aload 4
    //   27: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +8 -> 38
    //   33: aload_2
    //   34: invokevirtual 183	com/jiubang/goweather/a/a:d	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_2
    //   39: aload_1
    //   40: putfield 186	com/jiubang/goweather/a/a:c	Ljava/lang/String;
    //   43: aload 5
    //   45: ldc -77
    //   47: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: astore_1
    //   55: aload 4
    //   57: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +8 -> 68
    //   63: aload_2
    //   64: getfield 188	com/jiubang/goweather/a/a:b	Ljava/lang/String;
    //   67: astore_1
    //   68: aload_2
    //   69: aload_1
    //   70: putfield 188	com/jiubang/goweather/a/a:b	Ljava/lang/String;
    //   73: aload 5
    //   75: ldc -66
    //   77: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 4
    //   82: aload 4
    //   84: astore_1
    //   85: aload 4
    //   87: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +6 -> 96
    //   93: ldc 113
    //   95: astore_1
    //   96: aload_2
    //   97: aload_1
    //   98: invokevirtual 192	com/jiubang/goweather/a/a:a	(Ljava/lang/String;)V
    //   101: aload 5
    //   103: ldc -62
    //   105: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 4
    //   110: aload 4
    //   112: astore_1
    //   113: aload 4
    //   115: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifeq +6 -> 124
    //   121: ldc 113
    //   123: astore_1
    //   124: aload_2
    //   125: aload_1
    //   126: invokevirtual 196	com/jiubang/goweather/a/a:b	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: aload 5
    //   132: ldc -58
    //   134: ldc2_w 51
    //   137: invokevirtual 56	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   140: l2i
    //   141: invokevirtual 200	com/jiubang/goweather/a/a:f	(I)V
    //   144: aload 5
    //   146: ldc -54
    //   148: invokevirtual 105	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore_1
    //   152: aload_2
    //   153: ldc -53
    //   155: invokevirtual 206	com/jiubang/goweather/a/a:a	(F)V
    //   158: aload_2
    //   159: ldc -53
    //   161: invokevirtual 208	com/jiubang/goweather/a/a:b	(F)V
    //   164: aload_1
    //   165: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifne +42 -> 210
    //   171: aload_1
    //   172: ldc -46
    //   174: invokevirtual 214	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   177: astore_1
    //   178: aload_1
    //   179: arraylength
    //   180: iconst_2
    //   181: if_icmpne +29 -> 210
    //   184: aload_2
    //   185: aload_1
    //   186: iconst_0
    //   187: aaload
    //   188: invokestatic 220	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   191: invokevirtual 224	java/lang/Float:floatValue	()F
    //   194: invokevirtual 206	com/jiubang/goweather/a/a:a	(F)V
    //   197: aload_2
    //   198: aload_1
    //   199: iconst_1
    //   200: aaload
    //   201: invokestatic 220	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   204: invokevirtual 224	java/lang/Float:floatValue	()F
    //   207: invokevirtual 208	com/jiubang/goweather/a/a:b	(F)V
    //   210: aload 5
    //   212: ldc -30
    //   214: iconst_0
    //   215: invokevirtual 230	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   218: ifeq +242 -> 460
    //   221: iconst_1
    //   222: istore_3
    //   223: aload_2
    //   224: iload_3
    //   225: invokevirtual 232	com/jiubang/goweather/a/a:a	(I)V
    //   228: aload 5
    //   230: ldc -22
    //   232: iconst_0
    //   233: invokevirtual 230	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   236: ifeq +229 -> 465
    //   239: iconst_1
    //   240: istore_3
    //   241: aload_2
    //   242: iload_3
    //   243: invokevirtual 236	com/jiubang/goweather/a/a:b	(I)V
    //   246: iconst_2
    //   247: newarray <illegal type>
    //   249: astore_1
    //   250: aload_1
    //   251: dup
    //   252: iconst_0
    //   253: ldc2_w 137
    //   256: dastore
    //   257: dup
    //   258: iconst_1
    //   259: ldc2_w 137
    //   262: dastore
    //   263: pop
    //   264: aload 5
    //   266: ldc -18
    //   268: invokevirtual 121	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   271: astore 4
    //   273: aload 4
    //   275: ifnull +73 -> 348
    //   278: aload 4
    //   280: invokevirtual 129	org/json/JSONArray:length	()I
    //   283: iconst_2
    //   284: if_icmpne +64 -> 348
    //   287: aload_1
    //   288: iconst_0
    //   289: aload 4
    //   291: iconst_0
    //   292: invokevirtual 242	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   295: invokestatic 245	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   298: invokestatic 250	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   301: invokevirtual 254	java/lang/Double:doubleValue	()D
    //   304: dastore
    //   305: aload_1
    //   306: iconst_1
    //   307: aload 4
    //   309: iconst_1
    //   310: invokevirtual 242	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   313: invokestatic 245	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   316: invokestatic 250	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   319: invokevirtual 254	java/lang/Double:doubleValue	()D
    //   322: dastore
    //   323: aload_1
    //   324: iconst_0
    //   325: daload
    //   326: ldc2_w 137
    //   329: dcmpl
    //   330: ifeq +18 -> 348
    //   333: aload_1
    //   334: iconst_1
    //   335: daload
    //   336: ldc2_w 137
    //   339: dcmpl
    //   340: ifeq +8 -> 348
    //   343: aload_2
    //   344: aload_1
    //   345: invokevirtual 257	com/jiubang/goweather/a/a:a	([D)V
    //   348: iconst_2
    //   349: newarray <illegal type>
    //   351: astore_1
    //   352: aload_1
    //   353: dup
    //   354: iconst_0
    //   355: ldc2_w 137
    //   358: dastore
    //   359: dup
    //   360: iconst_1
    //   361: ldc2_w 137
    //   364: dastore
    //   365: pop
    //   366: aload 5
    //   368: ldc_w 259
    //   371: invokevirtual 121	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   374: astore 4
    //   376: aload 4
    //   378: ifnull +73 -> 451
    //   381: aload 4
    //   383: invokevirtual 129	org/json/JSONArray:length	()I
    //   386: iconst_2
    //   387: if_icmpne +64 -> 451
    //   390: aload_1
    //   391: iconst_0
    //   392: aload 4
    //   394: iconst_0
    //   395: invokevirtual 242	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   398: invokestatic 245	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   401: invokestatic 250	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   404: invokevirtual 254	java/lang/Double:doubleValue	()D
    //   407: dastore
    //   408: aload_1
    //   409: iconst_1
    //   410: aload 4
    //   412: iconst_1
    //   413: invokevirtual 242	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   416: invokestatic 245	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   419: invokestatic 250	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   422: invokevirtual 254	java/lang/Double:doubleValue	()D
    //   425: dastore
    //   426: aload_1
    //   427: iconst_0
    //   428: daload
    //   429: ldc2_w 137
    //   432: dcmpl
    //   433: ifeq +18 -> 451
    //   436: aload_1
    //   437: iconst_1
    //   438: daload
    //   439: ldc2_w 137
    //   442: dcmpl
    //   443: ifeq +8 -> 451
    //   446: aload_2
    //   447: aload_1
    //   448: invokevirtual 261	com/jiubang/goweather/a/a:b	([D)V
    //   451: return
    //   452: astore_1
    //   453: aload_1
    //   454: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   457: goto -247 -> 210
    //   460: iconst_0
    //   461: istore_3
    //   462: goto -239 -> 223
    //   465: iconst_0
    //   466: istore_3
    //   467: goto -226 -> 241
    //   470: astore 4
    //   472: aload 4
    //   474: invokevirtual 265	java/lang/NumberFormatException:printStackTrace	()V
    //   477: goto -154 -> 323
    //   480: astore 4
    //   482: aload 4
    //   484: invokevirtual 266	org/json/JSONException:printStackTrace	()V
    //   487: goto -164 -> 323
    //   490: astore 4
    //   492: aload 4
    //   494: invokevirtual 265	java/lang/NumberFormatException:printStackTrace	()V
    //   497: goto -71 -> 426
    //   500: astore 4
    //   502: aload 4
    //   504: invokevirtual 266	org/json/JSONException:printStackTrace	()V
    //   507: goto -81 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	h
    //   0	510	1	paramJSONObject	JSONObject
    //   0	510	2	parama	a
    //   222	245	3	i	int
    //   20	391	4	localObject	Object
    //   470	3	4	localNumberFormatException1	NumberFormatException
    //   480	3	4	localJSONException1	JSONException
    //   490	3	4	localNumberFormatException2	NumberFormatException
    //   500	3	4	localJSONException2	JSONException
    //   6	361	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   171	210	452	java/lang/Exception
    //   287	323	470	java/lang/NumberFormatException
    //   287	323	480	org/json/JSONException
    //   390	426	490	java/lang/NumberFormatException
    //   390	426	500	org/json/JSONException
  }
  
  private void e(JSONObject paramJSONObject, a parama)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("currentWeather");
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
  
  private void f(JSONObject paramJSONObject, a parama)
  {
    if (parama.g != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("aqi");
      if (paramJSONObject != null)
      {
        parama.g.j(paramJSONObject.optInt("aqi", 55536));
        parama.g.a(paramJSONObject.optInt("qualityType", 55536));
        parama.g.b(paramJSONObject.optInt("pm25", 55536));
        parama.g.c(paramJSONObject.optInt("pm10", 55536));
        parama.g.d(paramJSONObject.optInt("so2", 55536));
        parama.g.e(paramJSONObject.optInt("no2", 55536));
      }
    }
  }
  
  private void g(JSONObject paramJSONObject, a parama)
  {
    paramJSONObject = paramJSONObject.optJSONObject("zhishu");
    if (paramJSONObject != null)
    {
      parama = new i();
      parama.a(paramJSONObject.optString("shushi", "--"));
      parama.b(paramJSONObject.optString("chuanyi", "--"));
      parama.c(paramJSONObject.optString("liangshai", "--"));
      parama.d(paramJSONObject.optString("chenlian", "--"));
      parama.e(paramJSONObject.optString("ziwaixian", "--"));
      parama.f(paramJSONObject.optString("lvyou", "--"));
      parama.g(paramJSONObject.optString("guomin", "--"));
      parama.h(paramJSONObject.optString("xiche", "--"));
    }
  }
  
  private void h(JSONObject paramJSONObject, a parama)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("forecasts");
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          c localc = new c();
          String str = localJSONObject.optString("weekDate");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          localc.b(paramJSONObject);
          str = localJSONObject.optString("status");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          localc.c(paramJSONObject);
          localc.b(localJSONObject.optInt("statusType", 1));
          localc.b((float)localJSONObject.optDouble("high", -10000.0D));
          localc.c((float)localJSONObject.optDouble("low", -10000.0D));
          str = localJSONObject.optString("windDir");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          localc.a(paramJSONObject);
          localc.a(localJSONObject.optInt("windDirType", 1));
          localc.a((float)localJSONObject.optDouble("windForceInt", -10000.0D));
          localc.c(localJSONObject.optInt("pop", 55536));
          str = localJSONObject.optString("statusDay");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          localc.d(paramJSONObject);
          str = localJSONObject.optString("statusNight");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          localc.e(paramJSONObject);
          str = localJSONObject.optString("date");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          localc.f(paramJSONObject);
          parama.h.add(localc);
        }
        i += 1;
      }
    }
  }
  
  private void i(JSONObject paramJSONObject, a parama)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("hourlies");
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          d locald = new d();
          String str = localJSONObject.optString("date");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          locald.a(paramJSONObject);
          locald.b(localJSONObject.optInt("hour", 55536));
          locald.b((float)localJSONObject.optDouble("temp", -10000.0D));
          locald.e(localJSONObject.optInt("pop", 55536));
          locald.c(localJSONObject.optInt("humidity", 55536));
          str = localJSONObject.optString("windDir");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          locald.b(paramJSONObject);
          locald.a(localJSONObject.optInt("windDirType", 1));
          locald.a((float)localJSONObject.optDouble("windForeInt", -10000.0D));
          str = localJSONObject.optString("status");
          paramJSONObject = str;
          if (TextUtils.isEmpty(str)) {
            paramJSONObject = "--";
          }
          locald.c(paramJSONObject);
          locald.d(localJSONObject.optInt("statusType", 1));
          parama.i.add(locald);
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString1, com.jiubang.goweather.b.f paramf, String paramString2, Context paramContext)
  {
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(paramString1)) {
      if (a(paramString1)) {
        for (;;)
        {
          try
          {
            paramString1 = new JSONArray(paramString1);
          }
          catch (JSONException paramString2)
          {
            paramString1 = null;
          }
          for (;;)
          {
            try
            {
              paramf.b(1);
              j = this.a.size();
              i = 0;
              if (i >= j) {
                continue;
              }
              localObject = (a)this.a.get(i);
              paramString2 = null;
            }
            catch (JSONException paramString2)
            {
              continue;
              j = 0;
              continue;
            }
            try
            {
              paramContext = paramString1.getJSONObject(i);
              paramString2 = paramContext;
            }
            catch (Exception paramContext)
            {
              paramf.a(paramContext);
              break;
            }
          }
          if (paramString2 != null)
          {
            paramContext = paramString2.optJSONObject("head");
            if (paramContext != null) {
              paramf.e(paramContext.optInt("costTime", 0));
            }
            b(paramString2, (a)localObject);
          }
          i += 1;
          continue;
          if (v.a(paramContext).equalsIgnoreCase("de"))
          {
            localObject = new Intent(paramContext, NotifyService.class);
            ((Intent)localObject).putExtra("notify_request", 38);
            ((Intent)localObject).putExtra("request_extra_runtime_crash_title", "天气接口Json解析错误");
            ((Intent)localObject).putExtra("request_extra_runtime_crash_text", y.a(paramString2, "#"));
            paramContext.startService((Intent)localObject);
          }
          paramf.a(paramString2);
          paramf.b(11);
          paramf.c(10);
        }
      }
    }
    do
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        int k;
        if (paramf.c() != -1) {
          continue;
        }
      }
      catch (JSONException paramString2)
      {
        do
        {
          for (;;)
          {
            try
            {
              paramf.b(1);
              if (paramString1 != null)
              {
                paramString2 = paramString1.optJSONObject("head");
                if (paramString2 != null) {
                  paramf.e(paramString2.optInt("costTime", 0));
                }
                b(paramString1, (a)this.a.get(0));
                paramf.b(((a)this.a.get(0)).w());
              }
              if (paramf.c() != 1) {
                continue;
              }
              paramString1 = this.a.iterator();
              i = 1;
              if (!paramString1.hasNext()) {
                break label557;
              }
              paramString2 = (a)paramString1.next();
              if (paramString2.w() == 2) {
                continue;
              }
              i = 0;
              j = 0;
              if (paramString2.w() != 1) {
                continue;
              }
              paramf.b(1);
              k = 1;
              i = j;
              j = k;
              if (i == 0) {
                continue;
              }
              paramf.b(2);
              return;
            }
            catch (JSONException paramString2)
            {
              continue;
            }
            paramString2 = paramString2;
            paramString1 = null;
            if (v.a(paramContext).equalsIgnoreCase("de"))
            {
              localObject = new Intent(paramContext, NotifyService.class);
              ((Intent)localObject).putExtra("notify_request", 38);
              ((Intent)localObject).putExtra("request_extra_runtime_crash_title", "天气接口Json解析错误");
              ((Intent)localObject).putExtra("request_extra_runtime_crash_text", y.a(paramString2, "#"));
              paramContext.startService((Intent)localObject);
            }
            paramf.a(paramString2);
            paramf.b(11);
            paramf.c(10);
          }
        } while (j != 0);
        paramf.b(11);
        paramf.c(0);
        return;
      }
      paramf.b(11);
      paramf.c(-1);
      return;
    } while (paramf.c() != 0);
    paramf.b(11);
    paramf.c(0);
  }
  
  public void a(JSONObject paramJSONObject, a parama)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("alarms");
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      int i = 0;
      if (i < j)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        b localb;
        if (localJSONObject != null)
        {
          localb = new b();
          localb.b(localJSONObject.optInt("alert_id", 55536));
          if (localb.i() != 55536) {
            break label85;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label85:
          localb.g(parama.d());
          paramJSONObject = localJSONObject.optString("publish_time");
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            localb.a(paramJSONObject);
            String str = localJSONObject.optString("exp_time");
            if (!TextUtils.isEmpty(str))
            {
              paramJSONObject = str;
              if (TextUtils.isEmpty(str)) {
                paramJSONObject = "--";
              }
              localb.b(paramJSONObject);
              str = localJSONObject.optString("type");
              paramJSONObject = str;
              if (TextUtils.isEmpty(str)) {
                paramJSONObject = "--";
              }
              localb.c(paramJSONObject);
              str = localJSONObject.optString("description");
              paramJSONObject = str;
              if (TextUtils.isEmpty(str)) {
                paramJSONObject = "--";
              }
              localb.d(paramJSONObject);
              str = localJSONObject.optString("phenomena");
              paramJSONObject = str;
              if (TextUtils.isEmpty(str)) {
                paramJSONObject = "--";
              }
              localb.e(paramJSONObject);
              localb.a(localJSONObject.optInt("level", 55536));
              str = localJSONObject.optString("level_str");
              paramJSONObject = str;
              if (TextUtils.isEmpty(str)) {
                paramJSONObject = "--";
              }
              localb.h(paramJSONObject);
              str = localJSONObject.optString("message");
              boolean bool = localJSONObject.optBoolean("isNotify");
              localb.a(bool);
              com.gtp.a.a.b.c.a("extreme_weather", "RemoteInfoParser isNotify: " + bool);
              if (!TextUtils.isEmpty(str))
              {
                paramJSONObject = str;
                if (TextUtils.isEmpty(str)) {
                  paramJSONObject = "--";
                }
                localb.f(paramJSONObject);
                localb.c(parama.t());
                parama.k.add(localb);
                com.gtp.a.a.a.a.a().a("刷新天气获取预警： " + localb.toString(), "gcm_extreme_log.txt");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */