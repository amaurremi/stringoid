package com.gau.go.gostaticsdk;

import android.content.Context;
import android.os.Environment;
import com.gau.go.gostaticsdk.f.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static String a = Environment.getExternalStorageDirectory().getPath() + "/.goproduct/";
  private String b = "_sourcerecord";
  private com.gau.go.gostaticsdk.f.b c;
  private com.gau.go.gostaticsdk.a.b d;
  private Context e;
  private int f = -1;
  
  protected b(Context paramContext)
  {
    this.e = paramContext;
    this.c = new com.gau.go.gostaticsdk.f.b();
  }
  
  /* Error */
  private ArrayList a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +234 -> 235
    //   4: aload_1
    //   5: ldc 72
    //   7: invokevirtual 78	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10: astore 10
    //   12: aload 10
    //   14: ifnull +221 -> 235
    //   17: aload 10
    //   19: invokevirtual 84	org/json/JSONArray:length	()I
    //   22: ifle +213 -> 235
    //   25: aload 10
    //   27: invokevirtual 84	org/json/JSONArray:length	()I
    //   30: istore_3
    //   31: new 86	java/util/ArrayList
    //   34: dup
    //   35: iload_3
    //   36: invokespecial 89	java/util/ArrayList:<init>	(I)V
    //   39: astore 9
    //   41: iconst_0
    //   42: istore_2
    //   43: aload 9
    //   45: astore_1
    //   46: iload_2
    //   47: iload_3
    //   48: if_icmpge +189 -> 237
    //   51: aload 10
    //   53: iload_2
    //   54: invokevirtual 93	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   57: astore 14
    //   59: aload 14
    //   61: ldc 95
    //   63: ldc 97
    //   65: invokevirtual 101	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: astore_1
    //   69: aload 14
    //   71: ldc 103
    //   73: ldc 97
    //   75: invokevirtual 101	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 11
    //   80: aload 14
    //   82: ldc 105
    //   84: ldc 97
    //   86: invokevirtual 101	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 12
    //   91: aload 14
    //   93: ldc 107
    //   95: ldc 97
    //   97: invokevirtual 101	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 13
    //   102: aload 14
    //   104: ldc 109
    //   106: invokevirtual 113	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   109: istore 4
    //   111: aload 14
    //   113: ldc 115
    //   115: invokevirtual 119	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   118: lstore 5
    //   120: aload 14
    //   122: ldc 121
    //   124: invokevirtual 119	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   127: lstore 7
    //   129: aload_1
    //   130: ldc 97
    //   132: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifne +88 -> 223
    //   138: aload 11
    //   140: ldc 97
    //   142: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifne +78 -> 223
    //   148: aload 12
    //   150: ldc 97
    //   152: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifne +68 -> 223
    //   158: new 129	com/gau/go/gostaticsdk/a/b
    //   161: dup
    //   162: invokespecial 130	com/gau/go/gostaticsdk/a/b:<init>	()V
    //   165: astore 14
    //   167: aload 14
    //   169: aload 12
    //   171: putfield 132	com/gau/go/gostaticsdk/a/b:d	Ljava/lang/String;
    //   174: aload 14
    //   176: aload_1
    //   177: putfield 133	com/gau/go/gostaticsdk/a/b:a	Ljava/lang/String;
    //   180: aload 14
    //   182: iload 4
    //   184: putfield 135	com/gau/go/gostaticsdk/a/b:c	I
    //   187: aload 14
    //   189: aload 11
    //   191: putfield 136	com/gau/go/gostaticsdk/a/b:b	Ljava/lang/String;
    //   194: aload 14
    //   196: lload 5
    //   198: putfield 139	com/gau/go/gostaticsdk/a/b:e	J
    //   201: aload 14
    //   203: lload 7
    //   205: putfield 141	com/gau/go/gostaticsdk/a/b:f	J
    //   208: aload 14
    //   210: aload 13
    //   212: putfield 144	com/gau/go/gostaticsdk/a/b:g	Ljava/lang/String;
    //   215: aload 9
    //   217: aload 14
    //   219: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   222: pop
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -184 -> 43
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 150	org/json/JSONException:printStackTrace	()V
    //   235: aconst_null
    //   236: astore_1
    //   237: aload_1
    //   238: areturn
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   244: goto -9 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	b
    //   0	247	1	paramJSONObject	JSONObject
    //   42	185	2	i	int
    //   30	19	3	j	int
    //   109	74	4	k	int
    //   118	79	5	l1	long
    //   127	77	7	l2	long
    //   39	177	9	localArrayList	ArrayList
    //   10	42	10	localJSONArray	JSONArray
    //   78	112	11	str1	String
    //   89	81	12	str2	String
    //   100	111	13	str3	String
    //   57	161	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	12	230	org/json/JSONException
    //   17	41	230	org/json/JSONException
    //   51	223	230	org/json/JSONException
    //   4	12	239	java/lang/Exception
    //   17	41	239	java/lang/Exception
    //   51	223	239	java/lang/Exception
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject1.put("sources", localJSONArray);
      paramArrayList = paramArrayList.iterator();
      if (paramArrayList.hasNext())
      {
        localb = (com.gau.go.gostaticsdk.a.b)paramArrayList.next();
        localJSONObject2 = new JSONObject();
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          com.gau.go.gostaticsdk.a.b localb;
          JSONObject localJSONObject2;
          localJSONObject2.put("dest_pkg", localb.d);
          localJSONObject2.put("pkg", localb.a);
          localJSONObject2.put("pid", localb.b);
          localJSONObject2.put("download_stamp", localb.e);
          localJSONObject2.put("install_stamp", localb.f);
          localJSONObject2.put("source_vercode", localb.c);
          localJSONObject2.put("google_analytics", localb.g);
          localJSONArray.put(localJSONObject2);
        }
        localJSONException1 = localJSONException1;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
      try
      {
        this.c.a(paramString, localJSONObject1.toString().getBytes("utf-8"));
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private JSONObject b(String paramString)
  {
    return d.b(this.c.a(paramString));
  }
  
  private com.gau.go.gostaticsdk.a.b d()
  {
    Object localObject1 = null;
    try
    {
      if (this.d != null) {
        localObject1 = this.d;
      }
      Object localObject3;
      String[] arrayOfString;
      do
      {
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = new com.gau.go.gostaticsdk.a.b();
          ((com.gau.go.gostaticsdk.a.b)localObject3).d = this.e.getPackageName();
          ((com.gau.go.gostaticsdk.a.b)localObject3).b = "-1";
          ((com.gau.go.gostaticsdk.a.b)localObject3).a = "-1";
          ((com.gau.go.gostaticsdk.a.b)localObject3).c = 0;
        }
        return (com.gau.go.gostaticsdk.a.b)localObject3;
        arrayOfString = new File(a).list();
      } while (arrayOfString == null);
      int i = 0;
      int j = 0;
      for (localObject1 = null;; localObject1 = localObject3)
      {
        try
        {
          if (i >= arrayOfString.length) {
            break label280;
          }
          localObject3 = arrayOfString[i];
          localObject3 = d.b(this.c.a(a + (String)localObject3));
          if (localObject3 == null) {
            break label273;
          }
          localObject3 = a((JSONObject)localObject3);
          if (localObject3 == null) {
            break label273;
          }
          Iterator localIterator = ((ArrayList)localObject3).iterator();
          long l1;
          long l2;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (com.gau.go.gostaticsdk.a.b)localIterator.next();
            } while ((((com.gau.go.gostaticsdk.a.b)localObject3).d == null) || (!((com.gau.go.gostaticsdk.a.b)localObject3).d.equals(this.e.getPackageName())));
            l1 = ((com.gau.go.gostaticsdk.a.b)localObject3).f;
            l2 = ((com.gau.go.gostaticsdk.a.b)localObject3).e;
          } while (l1 - l2 > 3600000L);
          j = 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            continue;
            Object localObject4 = localObject2;
          }
        }
        localObject1 = localObject3;
        if (j != 0) {
          break;
        }
        i += 1;
      }
    }
    catch (Exception localException1)
    {
      label273:
      label280:
      for (;;)
      {
        localObject2 = null;
      }
    }
  }
  
  protected String a()
  {
    if (this.d == null) {
      this.d = d();
    }
    return this.d.b;
  }
  
  protected void a(String paramString)
  {
    new c(this, "static_handle_soft_install", paramString).start();
  }
  
  protected String b()
  {
    if (this.d == null) {
      this.d = d();
    }
    return this.d.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */