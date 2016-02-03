package com.a.a;

import a.a;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static final String a = f.class.getSimpleName();
  private c b;
  private h c;
  private String d = null;
  private String e = null;
  private Map<String, String> f = null;
  private Object g = null;
  private Date h = null;
  private boolean i = false;
  
  public f(c paramc, h paramh)
  {
    this.b = paramc;
    this.c = paramh;
  }
  
  public static f a(c paramc, h paramh)
  {
    return new f(paramc, paramh);
  }
  
  private void a(Object paramObject)
  {
    if (this.c != null) {
      this.c.a(this, paramObject);
    }
  }
  
  private void a(String paramString, Map<String, String> paramMap, Object paramObject)
  {
    this.d = b(paramString);
    this.e = paramString;
    if (paramMap != null) {}
    for (paramString = new HashMap(paramMap);; paramString = new HashMap())
    {
      this.f = paramString;
      this.g = paramObject;
      this.f.put("method", this.e);
      this.f.put("api_key", this.b.e());
      this.f.put("v", "1.0");
      this.f.put("format", "JSON");
      if (!f())
      {
        this.f.put("session_key", this.b.i());
        this.f.put("call_id", h());
        if (this.b.j() != null) {
          this.f.put("ss", "1");
        }
      }
      this.f.put("sig", i());
      this.b.a(this);
      return;
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if (this.c != null) {
      this.c.a(this, paramThrowable);
    }
  }
  
  private String b(String paramString)
  {
    return this.b.b();
  }
  
  private void c(String paramString)
  {
    try
    {
      Object localObject2 = a(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = d(paramString);
      }
      if ((localObject1 instanceof JSONObject))
      {
        localObject2 = (JSONObject)localObject1;
        if (((JSONObject)localObject2).has("error_code"))
        {
          int k = ((JSONObject)localObject2).getInt("error_code");
          paramString = ((JSONObject)localObject2).getString("error_msg");
          localObject1 = ((JSONObject)localObject2).getJSONArray("request_args");
          localObject2 = new HashMap();
          int j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(j);
            ((Map)localObject2).put(localJSONObject.getString("key"), localJSONObject.getString("value"));
            j += 1;
          }
          a(new i(k, paramString, (Map)localObject2));
          return;
        }
      }
      a(localObject1);
      return;
    }
    catch (JSONException paramString)
    {
      a(paramString);
    }
  }
  
  private Object d(String paramString)
    throws JSONException
  {
    if (paramString.startsWith("[")) {
      return new JSONArray(paramString);
    }
    return new JSONObject(paramString);
  }
  
  private boolean f()
  {
    return (this.e.equals("facebook.auth.getSession")) || (this.e.equals("facebook.auth.createToken"));
  }
  
  private String g()
  {
    for (;;)
    {
      try
      {
        if (new URL(this.d).getPath().contains("?"))
        {
          String str1 = "&";
          localObject = new ArrayList();
          Iterator localIterator = this.f.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ((List)localObject).add((String)localEntry.getKey() + "=" + (String)localEntry.getValue());
          continue;
        }
        str2 = "?";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Logger.a(a, "Invalid URL");
        return null;
      }
    }
    Object localObject = a.a((List)localObject, "&");
    String str2 = this.d + str2 + (String)localObject;
    return str2;
  }
  
  private String h()
  {
    return String.format(Long.toString(System.currentTimeMillis()), new Object[0]);
  }
  
  private String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new ArrayList(this.f.keySet());
    Collections.sort((List)localObject1, a.a);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("=");
      localObject2 = this.f.get(localObject2);
      if ((localObject2 instanceof String)) {
        localStringBuilder.append(localObject2);
      }
    }
    if (f()) {
      if (this.b.f() != null) {
        localStringBuilder.append(this.b.f());
      }
    }
    for (;;)
    {
      return a.a(localStringBuilder.toString());
      if (this.b.j() != null) {
        localStringBuilder.append(this.b.j());
      } else if (this.b.f() != null) {
        localStringBuilder.append(this.b.f());
      }
    }
  }
  
  private byte[] j()
    throws UnsupportedEncodingException, IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localByteArrayOutputStream.write("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes("UTF-8"));
    Object localObject1 = this.f.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      localByteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes("UTF-8"));
      localByteArrayOutputStream.write(((String)localObject2).getBytes("UTF-8"));
      localByteArrayOutputStream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes("UTF-8"));
    }
    if (this.g != null)
    {
      if (!(this.g instanceof Bitmap)) {
        break label222;
      }
      localObject1 = (Bitmap)this.g;
      localByteArrayOutputStream.write("Content-Disposition: form-data; filename=\"photo\"\r\n".getBytes("UTF-8"));
      localByteArrayOutputStream.write("Content-Type: image/png\r\n\r\n".getBytes("UTF-8"));
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
      localByteArrayOutputStream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes("UTF-8"));
    }
    for (;;)
    {
      return localByteArrayOutputStream.toByteArray();
      label222:
      if ((this.g instanceof byte[]))
      {
        localObject1 = (byte[])this.g;
        localByteArrayOutputStream.write("Content-Disposition: form-data; filename=\"data\"\r\n".getBytes("UTF-8"));
        localByteArrayOutputStream.write("Content-Type: content/unknown\r\n\r\n".getBytes("UTF-8"));
        localByteArrayOutputStream.write((byte[])localObject1);
        localByteArrayOutputStream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes("UTF-8"));
      }
    }
  }
  
  protected Object a(String paramString)
  {
    return null;
  }
  
  public Date a()
  {
    return this.h;
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    a(paramString, paramMap, null);
  }
  
  /* Error */
  public void b()
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: iconst_1
    //   5: putfield 48	com/a/a/f:i	Z
    //   8: aload_0
    //   9: getfield 52	com/a/a/f:c	Lcom/a/a/h;
    //   12: ifnull +13 -> 25
    //   15: aload_0
    //   16: getfield 52	com/a/a/f:c	Lcom/a/a/h;
    //   19: aload_0
    //   20: invokeinterface 371 2 0
    //   25: aload_0
    //   26: getfield 40	com/a/a/f:e	Ljava/lang/String;
    //   29: ifnull +167 -> 196
    //   32: aload_0
    //   33: getfield 38	com/a/a/f:d	Ljava/lang/String;
    //   36: astore_1
    //   37: new 202	java/net/URL
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 203	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 375	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: checkcast 377	java/net/HttpURLConnection
    //   53: astore_2
    //   54: aload_2
    //   55: ldc_w 379
    //   58: ldc_w 381
    //   61: invokevirtual 384	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 40	com/a/a/f:e	Ljava/lang/String;
    //   68: ifnull +217 -> 285
    //   71: aload_2
    //   72: ldc_w 386
    //   75: invokevirtual 389	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: ldc_w 391
    //   82: ldc_w 393
    //   85: invokevirtual 384	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokespecial 395	com/a/a/f:j	()[B
    //   92: astore 4
    //   94: aload_2
    //   95: iconst_1
    //   96: invokevirtual 399	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   99: aload_0
    //   100: invokevirtual 401	com/a/a/f:c	()Z
    //   103: ifeq +19 -> 122
    //   106: aload_2
    //   107: ldc_w 403
    //   110: invokestatic 409	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   113: ldc_w 411
    //   116: invokevirtual 414	android/webkit/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokevirtual 417	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_2
    //   123: invokevirtual 420	java/net/HttpURLConnection:connect	()V
    //   126: aload 4
    //   128: ifnull +152 -> 280
    //   131: aload_2
    //   132: invokevirtual 424	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   135: astore_1
    //   136: aload_1
    //   137: astore_3
    //   138: aload_1
    //   139: aload 4
    //   141: invokevirtual 427	java/io/OutputStream:write	([B)V
    //   144: aload_1
    //   145: astore_3
    //   146: aload_2
    //   147: invokevirtual 431	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   150: astore 4
    //   152: aload 4
    //   154: invokestatic 434	a/a:a	(Ljava/io/InputStream;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore_3
    //   161: aload 4
    //   163: invokestatic 437	a/a:a	(Ljava/io/Closeable;)V
    //   166: aload_1
    //   167: invokestatic 437	a/a:a	(Ljava/io/Closeable;)V
    //   170: aload_2
    //   171: invokestatic 440	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   174: aload_0
    //   175: new 442	java/util/Date
    //   178: dup
    //   179: invokespecial 443	java/util/Date:<init>	()V
    //   182: putfield 46	com/a/a/f:h	Ljava/util/Date;
    //   185: aload_0
    //   186: aload_3
    //   187: invokespecial 445	com/a/a/f:c	(Ljava/lang/String;)V
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 48	com/a/a/f:i	Z
    //   195: return
    //   196: aload_0
    //   197: invokespecial 447	com/a/a/f:g	()Ljava/lang/String;
    //   200: astore_1
    //   201: goto -164 -> 37
    //   204: aload_2
    //   205: invokestatic 437	a/a:a	(Ljava/io/Closeable;)V
    //   208: aload 4
    //   210: invokestatic 437	a/a:a	(Ljava/io/Closeable;)V
    //   213: aload_3
    //   214: invokestatic 440	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: aload_0
    //   221: iconst_0
    //   222: putfield 48	com/a/a/f:i	Z
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: aload_2
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_2
    //   232: aload 5
    //   234: astore 4
    //   236: goto -32 -> 204
    //   239: astore_1
    //   240: aconst_null
    //   241: astore 4
    //   243: aload_2
    //   244: astore 5
    //   246: aload 4
    //   248: astore_2
    //   249: aload_3
    //   250: astore 4
    //   252: aload 5
    //   254: astore_3
    //   255: goto -51 -> 204
    //   258: astore 6
    //   260: aload 4
    //   262: astore_3
    //   263: aload_1
    //   264: astore 4
    //   266: aload_2
    //   267: astore 5
    //   269: aload 6
    //   271: astore_1
    //   272: aload_3
    //   273: astore_2
    //   274: aload 5
    //   276: astore_3
    //   277: goto -73 -> 204
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -138 -> 144
    //   285: aconst_null
    //   286: astore 4
    //   288: goto -194 -> 94
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_3
    //   296: aload 5
    //   298: astore 4
    //   300: goto -96 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	f
    //   36	182	1	localObject1	Object
    //   219	7	1	localObject2	Object
    //   227	1	1	localObject3	Object
    //   239	25	1	localObject4	Object
    //   271	11	1	localObject5	Object
    //   291	1	1	localObject6	Object
    //   53	241	2	localObject7	Object
    //   137	159	3	localObject8	Object
    //   92	207	4	localObject9	Object
    //   1	296	5	localObject10	Object
    //   258	12	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   8	25	219	finally
    //   25	37	219	finally
    //   37	46	219	finally
    //   161	190	219	finally
    //   196	201	219	finally
    //   204	219	219	finally
    //   54	94	227	finally
    //   94	122	227	finally
    //   122	126	227	finally
    //   131	136	227	finally
    //   138	144	239	finally
    //   146	152	239	finally
    //   152	161	258	finally
    //   46	54	291	finally
  }
  
  public void b(String paramString, Map<String, String> paramMap)
  {
    this.d = paramString;
    if (paramMap != null) {}
    for (paramString = new HashMap(paramMap);; paramString = new HashMap())
    {
      this.f = paramString;
      this.b.a(this);
      return;
    }
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public void e()
  {
    if ((d()) && (this.c != null)) {
      this.c.b(this);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("<FBRequest ");
    if (this.e != null) {}
    for (String str = this.e;; str = this.d) {
      return str + ">";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */