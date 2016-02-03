package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.SparseArray;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.f.a;
import com.chartboost.sdk.Libraries.f.c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class i
{
  public static f.a a = f.a(new f.a[] { f.a(), new f.c()
  {
    public String a()
    {
      return "Must be a valid status code (>=200 && <300)";
    }
    
    public boolean a(Object paramAnonymousObject)
    {
      int i = ((Number)paramAnonymousObject).intValue();
      return (i >= 200) && (i < 300);
    }
  } });
  private static int b = 0;
  private static List<Runnable> h = new ArrayList();
  private String c;
  private String d;
  private SparseArray<a> e;
  private int f;
  private Handler g = new Handler();
  
  public i(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = new SparseArray();
    this.f = 1;
  }
  
  public static void a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(h);
      h.clear();
      int i = 0;
      while (i < localArrayList.size())
      {
        k.a().execute((Runnable)localArrayList.get(i));
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void a(j paramj)
  {
    a(paramj, null);
  }
  
  public void a(j paramj, b paramb)
  {
    int i = this.f;
    this.f = (i + 1);
    paramj = new a(i, paramj, paramb);
    if (!l.a())
    {
      paramj.a(new CBError(CBError.a.b, null));
      return;
    }
    this.e.put(i, paramj);
    a(new d(paramj));
  }
  
  /* Error */
  public void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 78
    //   4: monitorenter
    //   5: invokestatic 147	com/chartboost/sdk/Libraries/c:c	()Lcom/chartboost/sdk/Libraries/c$a;
    //   8: astore_3
    //   9: aload_3
    //   10: getstatic 152	com/chartboost/sdk/Libraries/c$a:a	Lcom/chartboost/sdk/Libraries/c$a;
    //   13: if_acmpeq +10 -> 23
    //   16: aload_3
    //   17: getstatic 154	com/chartboost/sdk/Libraries/c$a:b	Lcom/chartboost/sdk/Libraries/c$a;
    //   20: if_acmpne +30 -> 50
    //   23: getstatic 56	com/chartboost/sdk/impl/i:h	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 158 2 0
    //   32: pop
    //   33: ldc 78
    //   35: monitorexit
    //   36: iload_2
    //   37: ifeq +12 -> 49
    //   40: invokestatic 96	com/chartboost/sdk/impl/k:a	()Ljava/util/concurrent/ExecutorService;
    //   43: aload_1
    //   44: invokeinterface 108 2 0
    //   49: return
    //   50: iconst_1
    //   51: istore_2
    //   52: goto -19 -> 33
    //   55: astore_1
    //   56: ldc 78
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	i
    //   0	61	1	paramRunnable	Runnable
    //   1	51	2	i	int
    //   8	9	3	locala	com.chartboost.sdk.Libraries.c.a
    // Exception table:
    //   from	to	target	type
    //   5	23	55	finally
    //   23	33	55	finally
    //   33	36	55	finally
    //   56	59	55	finally
  }
  
  public void b()
  {
    if (!l.a()) {}
    for (;;)
    {
      return;
      Object localObject3 = CBUtility.a();
      Object localObject1 = "CBQueuedRequests-" + this.d;
      Object localObject2 = ((SharedPreferences)localObject3).getString((String)localObject1, null);
      if (localObject2 == null) {
        continue;
      }
      localObject3 = ((SharedPreferences)localObject3).edit();
      ((SharedPreferences.Editor)localObject3).putString((String)localObject1, null);
      ((SharedPreferences.Editor)localObject3).commit();
      try
      {
        localObject1 = new JSONArray(new JSONTokener((String)localObject2));
        int i = 0;
        for (;;)
        {
          int j = ((JSONArray)localObject1).length();
          if (i >= j) {
            break;
          }
          try
          {
            localObject2 = j.a(((JSONArray)localObject1).getJSONObject(i));
            if (localObject2 != null) {
              a((j)localObject2);
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              CBLogging.d("CBAPIConnection", "Retrying request failed", localException2);
            }
          }
          i += 1;
        }
        return;
      }
      catch (Exception localException1)
      {
        CBLogging.d("CBAPIConnection", "Retrying request list failed", localException1);
      }
    }
  }
  
  private class a
    implements Serializable
  {
    private j b;
    private JSONObject c;
    private Integer d;
    private i.b e;
    
    public a(int paramInt, j paramj, i.b paramb)
    {
      this.d = Integer.valueOf(paramInt);
      this.b = paramj;
      this.e = paramb;
      this.c = null;
    }
    
    public void a(CBError paramCBError)
    {
      if ((this.b.f()) && (i.a(i.this) != null))
      {
        Object localObject = CBUtility.a();
        String str = "CBQueuedRequests-" + i.a(i.this);
        for (;;)
        {
          try
          {
            JSONObject localJSONObject = this.b.h();
            if (localJSONObject == null) {
              break;
            }
            paramCBError = ((SharedPreferences)localObject).getString(str, null);
            if (paramCBError != null) {
              try
              {
                paramCBError = new JSONArray(new JSONTokener(paramCBError));
                paramCBError.put(localJSONObject);
                localObject = ((SharedPreferences)localObject).edit();
                ((SharedPreferences.Editor)localObject).putString(str, paramCBError.toString());
                ((SharedPreferences.Editor)localObject).commit();
                return;
              }
              catch (Exception paramCBError)
              {
                CBLogging.d("CBAPIConnection", "Failure reading saved request list", paramCBError);
                paramCBError = new JSONArray();
                continue;
              }
            }
            paramCBError = new JSONArray();
          }
          catch (Exception paramCBError)
          {
            CBLogging.d("CBAPIConnection", "Unable to save failed request", paramCBError);
            return;
          }
        }
      }
      if (this.e != null) {
        this.e.a(this.b, paramCBError);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(j paramj, CBError paramCBError);
    
    public abstract void a(JSONObject paramJSONObject, j paramj);
  }
  
  public static abstract class c
    implements i.b
  {
    public void a(j paramj, CBError paramCBError) {}
  }
  
  private class d
    implements Runnable
  {
    private i.a b;
    
    public d(i.a parama)
    {
      this.b = parama;
    }
    
    private void a(final boolean paramBoolean, final CBError paramCBError)
    {
      i.d(i.this).post(new Runnable()
      {
        public void run()
        {
          i.a locala = i.d.a(i.d.this);
          if ((paramBoolean) && (i.a.c(locala) != null))
          {
            if (i.a.d(locala) != null) {
              i.a.d(locala).a(i.a.c(locala), i.a.a(locala));
            }
            return;
          }
          locala.a(paramCBError);
        }
      });
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore 6
      //   6: invokestatic 48	com/chartboost/sdk/CBPreferences:getInstance	()Lcom/chartboost/sdk/CBPreferences;
      //   9: astore 8
      //   11: aload_0
      //   12: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   15: invokestatic 53	com/chartboost/sdk/impl/i$a:a	(Lcom/chartboost/sdk/impl/i$a;)Lcom/chartboost/sdk/impl/j;
      //   18: astore 5
      //   20: aload 5
      //   22: invokevirtual 57	com/chartboost/sdk/impl/j:a	()V
      //   25: aload 5
      //   27: aload 8
      //   29: invokevirtual 61	com/chartboost/sdk/CBPreferences:getAppID	()Ljava/lang/String;
      //   32: aload 8
      //   34: invokevirtual 64	com/chartboost/sdk/CBPreferences:getAppSignature	()Ljava/lang/String;
      //   37: invokevirtual 67	com/chartboost/sdk/impl/j:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   40: aload_0
      //   41: getfield 19	com/chartboost/sdk/impl/i$d:a	Lcom/chartboost/sdk/impl/i;
      //   44: invokestatic 70	com/chartboost/sdk/impl/i:b	(Lcom/chartboost/sdk/impl/i;)Ljava/lang/String;
      //   47: ifnonnull +173 -> 220
      //   50: ldc 72
      //   52: astore_3
      //   53: new 74	org/apache/http/client/methods/HttpPost
      //   56: dup
      //   57: new 76	java/lang/StringBuilder
      //   60: dup
      //   61: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   64: aload_3
      //   65: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   68: aload 5
      //   70: invokevirtual 83	com/chartboost/sdk/impl/j:b	()Ljava/lang/String;
      //   73: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   79: invokespecial 89	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
      //   82: astore 7
      //   84: aload 7
      //   86: ldc 91
      //   88: ldc 93
      //   90: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   93: aload 7
      //   95: ldc 98
      //   97: ldc 93
      //   99: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   102: aload 7
      //   104: ldc 100
      //   106: aload 8
      //   108: invokestatic 105	com/chartboost/sdk/Libraries/a:a	(Lcom/chartboost/sdk/CBPreferences;)Ljava/lang/String;
      //   111: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   114: aload 7
      //   116: ldc 107
      //   118: ldc 109
      //   120: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   123: aload 7
      //   125: ldc 100
      //   127: aload 8
      //   129: invokestatic 105	com/chartboost/sdk/Libraries/a:a	(Lcom/chartboost/sdk/CBPreferences;)Ljava/lang/String;
      //   132: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   135: aload 5
      //   137: invokevirtual 113	com/chartboost/sdk/impl/j:e	()Ljava/util/Map;
      //   140: astore_3
      //   141: aload_3
      //   142: ifnull +94 -> 236
      //   145: aload_3
      //   146: invokeinterface 119 1 0
      //   151: invokeinterface 125 1 0
      //   156: astore 8
      //   158: aload 8
      //   160: invokeinterface 131 1 0
      //   165: ifeq +71 -> 236
      //   168: aload 8
      //   170: invokeinterface 135 1 0
      //   175: checkcast 137	java/util/Map$Entry
      //   178: astore_3
      //   179: aload_3
      //   180: invokeinterface 140 1 0
      //   185: checkcast 142	java/lang/String
      //   188: astore 9
      //   190: aload_3
      //   191: invokeinterface 145 1 0
      //   196: ifnull +35 -> 231
      //   199: aload_3
      //   200: invokeinterface 145 1 0
      //   205: invokevirtual 146	java/lang/Object:toString	()Ljava/lang/String;
      //   208: astore_3
      //   209: aload 7
      //   211: aload 9
      //   213: aload_3
      //   214: invokevirtual 96	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   217: goto -59 -> 158
      //   220: aload_0
      //   221: getfield 19	com/chartboost/sdk/impl/i$d:a	Lcom/chartboost/sdk/impl/i;
      //   224: invokestatic 70	com/chartboost/sdk/impl/i:b	(Lcom/chartboost/sdk/impl/i;)Ljava/lang/String;
      //   227: astore_3
      //   228: goto -175 -> 53
      //   231: aconst_null
      //   232: astore_3
      //   233: goto -24 -> 209
      //   236: aload_0
      //   237: getfield 19	com/chartboost/sdk/impl/i$d:a	Lcom/chartboost/sdk/impl/i;
      //   240: astore_3
      //   241: aload_3
      //   242: monitorenter
      //   243: invokestatic 150	com/chartboost/sdk/impl/i:c	()I
      //   246: pop
      //   247: aload_3
      //   248: monitorexit
      //   249: aload 5
      //   251: invokevirtual 153	com/chartboost/sdk/impl/j:d	()Lorg/json/JSONObject;
      //   254: ifnull +40 -> 294
      //   257: new 155	org/apache/http/entity/StringEntity
      //   260: dup
      //   261: aload 5
      //   263: invokevirtual 153	com/chartboost/sdk/impl/j:d	()Lorg/json/JSONObject;
      //   266: invokevirtual 158	org/json/JSONObject:toString	()Ljava/lang/String;
      //   269: invokespecial 159	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
      //   272: astore_3
      //   273: aload_3
      //   274: new 161	org/apache/http/message/BasicHeader
      //   277: dup
      //   278: ldc 91
      //   280: ldc -93
      //   282: invokespecial 165	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   285: invokevirtual 169	org/apache/http/entity/StringEntity:setContentType	(Lorg/apache/http/Header;)V
      //   288: aload 7
      //   290: aload_3
      //   291: invokevirtual 173	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
      //   294: invokestatic 178	com/chartboost/sdk/impl/k:b	()Lorg/apache/http/client/HttpClient;
      //   297: aload 7
      //   299: invokeinterface 184 2 0
      //   304: astore 5
      //   306: aload 5
      //   308: invokeinterface 190 1 0
      //   313: invokeinterface 195 1 0
      //   318: istore_1
      //   319: aload 5
      //   321: invokeinterface 199 1 0
      //   326: astore 6
      //   328: aload 6
      //   330: invokeinterface 205 1 0
      //   335: astore 7
      //   337: new 207	java/io/BufferedReader
      //   340: dup
      //   341: new 209	java/io/InputStreamReader
      //   344: dup
      //   345: aload 7
      //   347: ldc -45
      //   349: invokespecial 214	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
      //   352: sipush 2048
      //   355: invokespecial 217	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
      //   358: astore_3
      //   359: new 76	java/lang/StringBuilder
      //   362: dup
      //   363: aload 7
      //   365: invokevirtual 222	java/io/InputStream:available	()I
      //   368: invokespecial 225	java/lang/StringBuilder:<init>	(I)V
      //   371: astore 7
      //   373: aload_3
      //   374: invokevirtual 228	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   377: astore 8
      //   379: aload 8
      //   381: ifnull +185 -> 566
      //   384: aload 7
      //   386: aload 8
      //   388: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: ldc -26
      //   393: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   396: pop
      //   397: goto -24 -> 373
      //   400: astore_3
      //   401: aload 5
      //   403: invokevirtual 146	java/lang/Object:toString	()Ljava/lang/String;
      //   406: astore_3
      //   407: iload_1
      //   408: sipush 300
      //   411: if_icmpge +306 -> 717
      //   414: iload_1
      //   415: sipush 200
      //   418: if_icmplt +299 -> 717
      //   421: aload_3
      //   422: ifnull +255 -> 677
      //   425: new 157	org/json/JSONObject
      //   428: dup
      //   429: new 232	org/json/JSONTokener
      //   432: dup
      //   433: aload_3
      //   434: invokespecial 233	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
      //   437: invokespecial 236	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
      //   440: astore_3
      //   441: aload_0
      //   442: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   445: invokestatic 53	com/chartboost/sdk/impl/i$a:a	(Lcom/chartboost/sdk/impl/i$a;)Lcom/chartboost/sdk/impl/j;
      //   448: invokevirtual 240	com/chartboost/sdk/impl/j:g	()Lcom/chartboost/sdk/Libraries/f$a;
      //   451: astore 7
      //   453: new 76	java/lang/StringBuilder
      //   456: dup
      //   457: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   460: astore 8
      //   462: aload 7
      //   464: ifnull +115 -> 579
      //   467: aload 7
      //   469: aload_3
      //   470: aload 8
      //   472: invokevirtual 245	com/chartboost/sdk/Libraries/f$a:a	(Ljava/lang/Object;Ljava/lang/StringBuilder;)Z
      //   475: ifne +104 -> 579
      //   478: new 247	com/chartboost/sdk/Model/CBError
      //   481: dup
      //   482: getstatic 252	com/chartboost/sdk/Model/CBError$a:d	Lcom/chartboost/sdk/Model/CBError$a;
      //   485: new 76	java/lang/StringBuilder
      //   488: dup
      //   489: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   492: ldc -2
      //   494: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   497: aload 8
      //   499: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   502: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   505: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   508: invokespecial 257	com/chartboost/sdk/Model/CBError:<init>	(Lcom/chartboost/sdk/Model/CBError$a;Ljava/lang/String;)V
      //   511: astore_3
      //   512: goto +263 -> 775
      //   515: aload 6
      //   517: invokestatic 261	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpEntity;)V
      //   520: aload_0
      //   521: getfield 19	com/chartboost/sdk/impl/i$d:a	Lcom/chartboost/sdk/impl/i;
      //   524: invokestatic 264	com/chartboost/sdk/impl/i:c	(Lcom/chartboost/sdk/impl/i;)Landroid/util/SparseArray;
      //   527: aload_0
      //   528: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   531: invokestatic 267	com/chartboost/sdk/impl/i$a:b	(Lcom/chartboost/sdk/impl/i$a;)Ljava/lang/Integer;
      //   534: invokevirtual 272	java/lang/Integer:intValue	()I
      //   537: invokevirtual 277	android/util/SparseArray:remove	(I)V
      //   540: aload_0
      //   541: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   544: invokestatic 280	com/chartboost/sdk/impl/i$a:c	(Lcom/chartboost/sdk/impl/i$a;)Lorg/json/JSONObject;
      //   547: ifnull +215 -> 762
      //   550: iconst_1
      //   551: istore_2
      //   552: aload_0
      //   553: iload_2
      //   554: aload_3
      //   555: invokespecial 282	com/chartboost/sdk/impl/i$d:a	(ZLcom/chartboost/sdk/Model/CBError;)V
      //   558: return
      //   559: astore 4
      //   561: aload_3
      //   562: monitorexit
      //   563: aload 4
      //   565: athrow
      //   566: aload_3
      //   567: invokevirtual 285	java/io/BufferedReader:close	()V
      //   570: aload 7
      //   572: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   575: astore_3
      //   576: goto -169 -> 407
      //   579: aload_0
      //   580: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   583: aload_3
      //   584: invokestatic 288	com/chartboost/sdk/impl/i$a:a	(Lcom/chartboost/sdk/impl/i$a;Lorg/json/JSONObject;)Lorg/json/JSONObject;
      //   587: pop
      //   588: aload 4
      //   590: astore_3
      //   591: goto +184 -> 775
      //   594: astore_3
      //   595: aload 5
      //   597: astore 4
      //   599: new 247	com/chartboost/sdk/Model/CBError
      //   602: dup
      //   603: getstatic 290	com/chartboost/sdk/Model/CBError$a:a	Lcom/chartboost/sdk/Model/CBError$a;
      //   606: new 76	java/lang/StringBuilder
      //   609: dup
      //   610: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   613: ldc_w 292
      //   616: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   619: aload_3
      //   620: invokevirtual 295	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
      //   623: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   626: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   629: invokespecial 257	com/chartboost/sdk/Model/CBError:<init>	(Lcom/chartboost/sdk/Model/CBError$a;Ljava/lang/String;)V
      //   632: astore 5
      //   634: ldc_w 297
      //   637: aload 5
      //   639: invokevirtual 299	com/chartboost/sdk/Model/CBError:a	()Ljava/lang/String;
      //   642: aload_3
      //   643: invokestatic 304	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   646: aload 4
      //   648: invokestatic 307	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpResponse;)V
      //   651: aload_0
      //   652: getfield 19	com/chartboost/sdk/impl/i$d:a	Lcom/chartboost/sdk/impl/i;
      //   655: invokestatic 264	com/chartboost/sdk/impl/i:c	(Lcom/chartboost/sdk/impl/i;)Landroid/util/SparseArray;
      //   658: aload_0
      //   659: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   662: invokestatic 267	com/chartboost/sdk/impl/i$a:b	(Lcom/chartboost/sdk/impl/i$a;)Ljava/lang/Integer;
      //   665: invokevirtual 272	java/lang/Integer:intValue	()I
      //   668: invokevirtual 277	android/util/SparseArray:remove	(I)V
      //   671: aload 5
      //   673: astore_3
      //   674: goto -134 -> 540
      //   677: new 247	com/chartboost/sdk/Model/CBError
      //   680: dup
      //   681: getstatic 309	com/chartboost/sdk/Model/CBError$a:c	Lcom/chartboost/sdk/Model/CBError$a;
      //   684: ldc_w 311
      //   687: invokespecial 257	com/chartboost/sdk/Model/CBError:<init>	(Lcom/chartboost/sdk/Model/CBError$a;Ljava/lang/String;)V
      //   690: astore_3
      //   691: goto -176 -> 515
      //   694: astore_3
      //   695: aload_0
      //   696: getfield 19	com/chartboost/sdk/impl/i$d:a	Lcom/chartboost/sdk/impl/i;
      //   699: invokestatic 264	com/chartboost/sdk/impl/i:c	(Lcom/chartboost/sdk/impl/i;)Landroid/util/SparseArray;
      //   702: aload_0
      //   703: getfield 24	com/chartboost/sdk/impl/i$d:b	Lcom/chartboost/sdk/impl/i$a;
      //   706: invokestatic 267	com/chartboost/sdk/impl/i$a:b	(Lcom/chartboost/sdk/impl/i$a;)Ljava/lang/Integer;
      //   709: invokevirtual 272	java/lang/Integer:intValue	()I
      //   712: invokevirtual 277	android/util/SparseArray:remove	(I)V
      //   715: aload_3
      //   716: athrow
      //   717: aload 6
      //   719: invokestatic 261	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpEntity;)V
      //   722: new 247	com/chartboost/sdk/Model/CBError
      //   725: dup
      //   726: getstatic 313	com/chartboost/sdk/Model/CBError$a:e	Lcom/chartboost/sdk/Model/CBError$a;
      //   729: new 76	java/lang/StringBuilder
      //   732: dup
      //   733: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   736: ldc_w 315
      //   739: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   742: iload_1
      //   743: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   746: ldc_w 320
      //   749: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   752: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   755: invokespecial 257	com/chartboost/sdk/Model/CBError:<init>	(Lcom/chartboost/sdk/Model/CBError$a;Ljava/lang/String;)V
      //   758: astore_3
      //   759: goto -239 -> 520
      //   762: iconst_0
      //   763: istore_2
      //   764: goto -212 -> 552
      //   767: astore_3
      //   768: aload 6
      //   770: astore 4
      //   772: goto -173 -> 599
      //   775: goto -260 -> 515
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	778	0	this	d
      //   318	425	1	i	int
      //   551	213	2	bool	boolean
      //   52	322	3	localObject1	Object
      //   400	1	3	localException1	Exception
      //   406	185	3	localObject2	Object
      //   594	49	3	localException2	Exception
      //   673	18	3	localObject3	Object
      //   694	22	3	localObject4	Object
      //   758	1	3	localCBError	CBError
      //   767	1	3	localException3	Exception
      //   1	1	4	localObject5	Object
      //   559	30	4	localObject6	Object
      //   597	174	4	localObject7	Object
      //   18	654	5	localObject8	Object
      //   4	765	6	localHttpEntity	org.apache.http.HttpEntity
      //   82	489	7	localObject9	Object
      //   9	489	8	localObject10	Object
      //   188	24	9	str	String
      // Exception table:
      //   from	to	target	type
      //   328	373	400	java/lang/Exception
      //   373	379	400	java/lang/Exception
      //   384	397	400	java/lang/Exception
      //   566	576	400	java/lang/Exception
      //   243	249	559	finally
      //   561	563	559	finally
      //   306	328	594	java/lang/Exception
      //   401	407	594	java/lang/Exception
      //   425	462	594	java/lang/Exception
      //   467	512	594	java/lang/Exception
      //   515	520	594	java/lang/Exception
      //   579	588	594	java/lang/Exception
      //   677	691	594	java/lang/Exception
      //   717	759	594	java/lang/Exception
      //   249	294	694	finally
      //   294	306	694	finally
      //   306	328	694	finally
      //   328	373	694	finally
      //   373	379	694	finally
      //   384	397	694	finally
      //   401	407	694	finally
      //   425	462	694	finally
      //   467	512	694	finally
      //   515	520	694	finally
      //   566	576	694	finally
      //   579	588	694	finally
      //   599	651	694	finally
      //   677	691	694	finally
      //   717	759	694	finally
      //   249	294	767	java/lang/Exception
      //   294	306	767	java/lang/Exception
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */