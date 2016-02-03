package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  private static String a = "http://launchermsg.3g.cn/golaunchermsg/msgservice.do?";
  private static volatile l e;
  private Context b;
  private ai c;
  private int d;
  
  private l(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static l a(Context paramContext)
  {
    if (e == null) {
      e = new l(paramContext);
    }
    return e;
  }
  
  private boolean a(JSONObject paramJSONObject, com.gau.go.launcherex.gowidget.messagecenter.a.c paramc)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      long l = paramJSONObject.getLong("lts");
      paramJSONObject = paramJSONObject.getJSONArray("msgs");
      a(l);
      paramc.a(paramJSONObject);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
  
  private float b()
  {
    return this.b.getResources().getDisplayMetrics().density;
  }
  
  private void b(JSONObject paramJSONObject, int paramInt)
  {
    JSONObject localJSONObject;
    if (this.b != null)
    {
      localJSONObject = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject = new JSONObject();
      }
    }
    for (paramJSONObject = y.d(this.b);; paramJSONObject = "0") {
      try
      {
        localJSONObject.put("vps", a(paramJSONObject));
        localJSONObject.put("launcherid", paramJSONObject);
        localJSONObject.put("channel", y.f(this.b));
        localJSONObject.put("lang", y.j(this.b));
        localJSONObject.put("local", y.n(this.b));
        localJSONObject.put("pversion", "3.3");
        if (GoWidgetApplication.b(this.b).b())
        {
          paramJSONObject = "1";
          localJSONObject.put("isfee", paramJSONObject);
          String str = y.c(this.b);
          int i = str.indexOf("beta");
          if (i > 0)
          {
            paramJSONObject = str.substring(0, i);
            localJSONObject.put("cversion", paramJSONObject);
            localJSONObject.put("vcode", y.e(this.b));
            localJSONObject.put("Isauto", paramInt);
            localJSONObject.put("pid", "bc56547273dcc3af623dc00de6e6f832");
            localJSONObject.put("spappcenter", 1);
            localJSONObject.put("density", b());
            localJSONObject.put("androidid", y.v(this.b));
            localJSONObject.put("isfirst", i.d(this.b));
            if (!GoWidgetApplication.b(this.b).b()) {
              break label324;
            }
          }
          label324:
          for (paramJSONObject = "1";; paramJSONObject = "2")
          {
            localJSONObject.put("ispay", paramJSONObject);
            localJSONObject.put("gadid", y.w(this.b));
            return;
            i = str.indexOf("Beta");
            paramJSONObject = str;
            if (i <= 0) {
              break;
            }
            paramJSONObject = str.substring(0, i);
            break;
          }
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private JSONObject d(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.getJSONObject("result").getInt("status");
        if (i == 1) {
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public long a()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("msg_time_stamp", 0L);
    }
    return l;
  }
  
  public String a(int paramInt, String paramString)
  {
    paramString = new StringBuffer(paramString);
    Random localRandom = new Random(new Date().getTime());
    if (1 == paramInt) {
      paramString.append("funid=1&rd=" + localRandom.nextLong());
    }
    for (;;)
    {
      return paramString.toString();
      if (2 == paramInt) {
        paramString.append("funid=2&rd=" + localRandom.nextLong());
      } else if (3 == paramInt) {
        paramString.append("funid=5&rd=" + localRandom.nextLong());
      } else if (4 == paramInt) {
        paramString.append("funid=7&rd=" + localRandom.nextLong());
      }
    }
  }
  
  public String a(String paramString)
  {
    Object localObject = this.b.getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    localObject = new StringBuilder(64);
    ((StringBuilder)localObject).append("1#");
    ((StringBuilder)localObject).append("Android#");
    ((StringBuilder)localObject).append(Build.MODEL + "#");
    ((StringBuilder)localObject).append(paramString + "#");
    ((StringBuilder)localObject).append("166#");
    ((StringBuilder)localObject).append(i + "_" + j + "#");
    ((StringBuilder)localObject).append("01.01.01");
    paramString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = URLEncoder.encode(paramString, "UTF-8");
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramString;
  }
  
  public JSONObject a(JSONObject paramJSONObject, int paramInt)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    b(localJSONObject, paramInt);
    return localJSONObject;
  }
  
  public void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("msg_time_stamp", paramLong).commit();
    }
  }
  
  public void a(ai paramai)
  {
    this.c = paramai;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    com.gau.go.launcherex.gowidget.messagecenter.a.c localc = null;
    for (;;)
    {
      try
      {
        if ((this.b != null) && (this.d == 0))
        {
          Object localObject3 = a(null, paramInt);
          localObject2 = a(1, a);
          e locale = new e((String)localObject2, "POST");
          locale.a(a((JSONObject)localObject3, 1, null));
          localObject3 = new com.jiubang.goweather.b.f();
          com.jiubang.goweather.b.c localc1 = d.a();
          if (localc1.a((com.jiubang.goweather.b.f)localObject3, this.b))
          {
            localObject2 = localc1.b((String)localObject2, locale, (com.jiubang.goweather.b.f)localObject3);
            if (localObject2 != null)
            {
              localObject2 = d((String)localObject2);
              localc = new com.gau.go.launcherex.gowidget.messagecenter.a.c();
              if ((a((JSONObject)localObject2, localc)) && (this.c != null))
              {
                this.c.a(true, localc);
                return bool;
              }
              this.c.a(false, null);
              bool = false;
              continue;
            }
          }
        }
        else
        {
          bool = false;
          continue;
        }
        Object localObject2 = null;
      }
      finally {}
    }
  }
  
  public byte[] a(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    b(localJSONObject, 0);
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("phead", localJSONObject);
      if (paramInt == 2) {
        paramJSONObject.put("id", paramString);
      }
      for (;;)
      {
        return paramJSONObject.toString().getBytes("UTF-8");
        paramJSONObject.put("lts", a());
      }
      return null;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: iload 5
    //   10: istore_3
    //   11: aload_0
    //   12: getfield 27	com/gau/go/launcherex/gowidget/messagecenter/util/l:b	Landroid/content/Context;
    //   15: invokestatic 394	com/gau/go/launcherex/gowidget/weather/util/r:c	(Landroid/content/Context;)Z
    //   18: ifeq +15 -> 33
    //   21: aload_1
    //   22: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifeq +10 -> 37
    //   30: iload 5
    //   32: istore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_3
    //   36: ireturn
    //   37: aload_0
    //   38: aconst_null
    //   39: iconst_0
    //   40: invokevirtual 327	com/gau/go/launcherex/gowidget/messagecenter/util/l:a	(Lorg/json/JSONObject;I)Lorg/json/JSONObject;
    //   43: astore 7
    //   45: new 39	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 81	org/json/JSONObject:<init>	()V
    //   52: astore 6
    //   54: aload 6
    //   56: ldc_w 370
    //   59: aload 7
    //   61: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload 6
    //   67: ldc_w 402
    //   70: aload_1
    //   71: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: new 404	org/apache/http/client/methods/HttpPost
    //   78: dup
    //   79: aload_0
    //   80: iconst_3
    //   81: getstatic 20	com/gau/go/launcherex/gowidget/messagecenter/util/l:a	Ljava/lang/String;
    //   84: invokevirtual 329	com/gau/go/launcherex/gowidget/messagecenter/util/l:a	(ILjava/lang/String;)Ljava/lang/String;
    //   87: invokespecial 405	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: ldc_w 407
    //   94: aload 6
    //   96: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   99: invokestatic 411	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_1
    //   103: new 413	org/apache/http/entity/StringEntity
    //   106: dup
    //   107: aload 6
    //   109: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   112: invokespecial 414	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 418	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   118: new 420	org/apache/http/params/BasicHttpParams
    //   121: dup
    //   122: invokespecial 421	org/apache/http/params/BasicHttpParams:<init>	()V
    //   125: astore 6
    //   127: aload 6
    //   129: sipush 7000
    //   132: invokestatic 427	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   135: aload 6
    //   137: sipush 7000
    //   140: invokestatic 430	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   143: new 39	org/json/JSONObject
    //   146: dup
    //   147: new 432	java/io/BufferedReader
    //   150: dup
    //   151: new 434	java/io/InputStreamReader
    //   154: dup
    //   155: new 436	org/apache/http/impl/client/DefaultHttpClient
    //   158: dup
    //   159: aload 6
    //   161: invokespecial 439	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   164: aload_1
    //   165: invokevirtual 443	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   168: invokeinterface 449 1 0
    //   173: invokeinterface 455 1 0
    //   178: invokespecial 458	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   181: invokespecial 461	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   184: invokevirtual 464	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   187: invokespecial 196	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   190: ldc_w 466
    //   193: invokevirtual 469	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 475	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   199: invokevirtual 479	java/lang/Integer:intValue	()I
    //   202: istore_2
    //   203: iload_2
    //   204: iconst_1
    //   205: if_icmpne +58 -> 263
    //   208: iload 4
    //   210: istore_3
    //   211: goto -178 -> 33
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 303	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   219: iload 5
    //   221: istore_3
    //   222: goto -189 -> 33
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 480	java/lang/IllegalStateException:printStackTrace	()V
    //   235: iload 5
    //   237: istore_3
    //   238: goto -205 -> 33
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 481	java/io/IOException:printStackTrace	()V
    //   246: iload 5
    //   248: istore_3
    //   249: goto -216 -> 33
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 482	java/lang/Exception:printStackTrace	()V
    //   257: iload 5
    //   259: istore_3
    //   260: goto -227 -> 33
    //   263: iconst_0
    //   264: istore_3
    //   265: goto -54 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	l
    //   0	268	1	paramString	String
    //   202	4	2	i	int
    //   10	255	3	bool1	boolean
    //   1	208	4	bool2	boolean
    //   4	254	5	bool3	boolean
    //   52	108	6	localObject	Object
    //   43	17	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   37	203	214	java/io/UnsupportedEncodingException
    //   11	26	225	finally
    //   37	203	225	finally
    //   215	219	225	finally
    //   231	235	225	finally
    //   242	246	225	finally
    //   253	257	225	finally
    //   37	203	230	java/lang/IllegalStateException
    //   37	203	241	java/io/IOException
    //   37	203	252	java/lang/Exception
  }
  
  /* Error */
  public boolean c(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: iload 5
    //   10: istore_3
    //   11: aload_0
    //   12: getfield 27	com/gau/go/launcherex/gowidget/messagecenter/util/l:b	Landroid/content/Context;
    //   15: invokestatic 394	com/gau/go/launcherex/gowidget/weather/util/r:c	(Landroid/content/Context;)Z
    //   18: ifeq +15 -> 33
    //   21: aload_1
    //   22: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifeq +10 -> 37
    //   30: iload 5
    //   32: istore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_3
    //   36: ireturn
    //   37: aload_0
    //   38: aconst_null
    //   39: iconst_0
    //   40: invokevirtual 327	com/gau/go/launcherex/gowidget/messagecenter/util/l:a	(Lorg/json/JSONObject;I)Lorg/json/JSONObject;
    //   43: astore 7
    //   45: new 39	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 81	org/json/JSONObject:<init>	()V
    //   52: astore 6
    //   54: aload 6
    //   56: ldc_w 370
    //   59: aload 7
    //   61: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload 6
    //   67: ldc_w 402
    //   70: aload_1
    //   71: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: new 404	org/apache/http/client/methods/HttpPost
    //   78: dup
    //   79: aload_0
    //   80: iconst_4
    //   81: getstatic 20	com/gau/go/launcherex/gowidget/messagecenter/util/l:a	Ljava/lang/String;
    //   84: invokevirtual 329	com/gau/go/launcherex/gowidget/messagecenter/util/l:a	(ILjava/lang/String;)Ljava/lang/String;
    //   87: invokespecial 405	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: aload_1
    //   92: new 413	org/apache/http/entity/StringEntity
    //   95: dup
    //   96: aload 6
    //   98: invokevirtual 373	org/json/JSONObject:toString	()Ljava/lang/String;
    //   101: invokespecial 414	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 418	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   107: new 420	org/apache/http/params/BasicHttpParams
    //   110: dup
    //   111: invokespecial 421	org/apache/http/params/BasicHttpParams:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: sipush 7000
    //   121: invokestatic 427	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   124: aload 6
    //   126: sipush 7000
    //   129: invokestatic 430	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   132: new 39	org/json/JSONObject
    //   135: dup
    //   136: new 432	java/io/BufferedReader
    //   139: dup
    //   140: new 434	java/io/InputStreamReader
    //   143: dup
    //   144: new 436	org/apache/http/impl/client/DefaultHttpClient
    //   147: dup
    //   148: aload 6
    //   150: invokespecial 439	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   153: aload_1
    //   154: invokevirtual 443	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   157: invokeinterface 449 1 0
    //   162: invokeinterface 455 1 0
    //   167: invokespecial 458	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   170: invokespecial 461	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   173: invokevirtual 464	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   176: invokespecial 196	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   179: ldc_w 466
    //   182: invokevirtual 469	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic 475	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   188: invokevirtual 479	java/lang/Integer:intValue	()I
    //   191: istore_2
    //   192: iload_2
    //   193: iconst_1
    //   194: if_icmpne +58 -> 252
    //   197: iload 4
    //   199: istore_3
    //   200: goto -167 -> 33
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 303	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   208: iload 5
    //   210: istore_3
    //   211: goto -178 -> 33
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 480	java/lang/IllegalStateException:printStackTrace	()V
    //   224: iload 5
    //   226: istore_3
    //   227: goto -194 -> 33
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 481	java/io/IOException:printStackTrace	()V
    //   235: iload 5
    //   237: istore_3
    //   238: goto -205 -> 33
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 482	java/lang/Exception:printStackTrace	()V
    //   246: iload 5
    //   248: istore_3
    //   249: goto -216 -> 33
    //   252: iconst_0
    //   253: istore_3
    //   254: goto -54 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	l
    //   0	257	1	paramString	String
    //   191	4	2	i	int
    //   10	244	3	bool1	boolean
    //   1	197	4	bool2	boolean
    //   4	243	5	bool3	boolean
    //   52	97	6	localObject	Object
    //   43	17	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   37	192	203	java/io/UnsupportedEncodingException
    //   11	26	214	finally
    //   37	192	214	finally
    //   204	208	214	finally
    //   220	224	214	finally
    //   231	235	214	finally
    //   242	246	214	finally
    //   37	192	219	java/lang/IllegalStateException
    //   37	192	230	java/io/IOException
    //   37	192	241	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */