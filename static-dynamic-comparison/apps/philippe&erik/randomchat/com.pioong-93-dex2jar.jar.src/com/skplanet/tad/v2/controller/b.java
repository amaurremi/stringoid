package com.skplanet.tad.v2.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.skplanet.tad.common.b.c;
import com.skplanet.tad.controller.d;
import com.skplanet.tad.controller.d.a;
import com.skplanet.tad.v2.content.a.a;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class b
  extends AsyncTask
{
  private Context a;
  private d b;
  private d.a c;
  private com.skplanet.tad.common.b d;
  private boolean e;
  private SharedPreferences f = null;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t = Build.MODEL;
  private String u = Build.MANUFACTURER;
  private String v = "Android";
  private String w = Build.VERSION.RELEASE;
  private String x;
  private Boolean y;
  
  public b(Context paramContext, d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramContext;
    this.b = paramd;
    this.e = paramBoolean1;
    this.y = Boolean.valueOf(paramBoolean2);
    this.d = com.skplanet.tad.common.b.a(paramContext);
    e();
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 96	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: new 99	java/io/BufferedReader
    //   11: dup
    //   12: new 101	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: sipush 512
    //   23: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 111	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +12 -> 45
    //   36: aload_1
    //   37: invokevirtual 114	java/io/BufferedReader:close	()V
    //   40: aload_2
    //   41: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: areturn
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: goto -24 -> 27
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 114	java/io/BufferedReader:close	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	b
    //   0	61	1	paramInputStream	java.io.InputStream
    //   7	39	2	localStringBuilder	StringBuilder
    //   54	6	2	localObject	Object
    //   31	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   27	32	54	finally
    //   45	51	54	finally
  }
  
  private HttpURLConnection a(URL paramURL, int paramInt, boolean paramBoolean)
    throws Exception
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setConnectTimeout(paramInt);
    paramURL.setReadTimeout(paramInt);
    paramURL.setDoInput(true);
    paramURL.setUseCaches(false);
    paramURL.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml");
    paramURL.setRequestProperty("Accept-Charset", "UTF-8");
    if (paramBoolean)
    {
      paramURL.setDoOutput(true);
      paramURL.setRequestMethod("POST");
      return paramURL;
    }
    paramURL.setFixedLengthStreamingMode(0);
    paramURL.setRequestMethod("GET");
    return paramURL;
  }
  
  private void a(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    try
    {
      localOutputStreamWriter = new OutputStreamWriter(paramOutputStream);
      if (paramString == null) {
        break label38;
      }
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        localOutputStreamWriter.flush();
        if (localOutputStreamWriter != null) {
          localOutputStreamWriter.close();
        }
        return;
      }
      finally
      {
        OutputStreamWriter localOutputStreamWriter;
        paramString = localOutputStreamWriter;
      }
      paramOutputStream = finally;
      paramString = null;
    }
    paramString.close();
    label38:
    throw paramOutputStream;
  }
  
  private void a(String paramString)
  {
    Object localObject4 = null;
    String[] arrayOfString = paramString.split(",");
    for (;;)
    {
      try
      {
        if (arrayOfString.length > 0)
        {
          localObject1 = arrayOfString[0];
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = "p";
            localObject3 = localObject1;
          }
        }
      }
      catch (Throwable paramString)
      {
        Object localObject3;
        String str = null;
        paramString = null;
        localObject1 = null;
        continue;
      }
      try
      {
        if (arrayOfString.length > 1)
        {
          paramString = arrayOfString[1];
          localObject3 = localObject1;
          if (TextUtils.isEmpty(paramString))
          {
            localObject3 = localObject1;
            Log.i("test", "!E0089: there is no app category id:" + paramString);
            paramString = null;
          }
        }
      }
      catch (Throwable paramString)
      {
        Object localObject2 = null;
        paramString = null;
        localObject1 = localThrowable2;
        continue;
      }
      try
      {
        if (arrayOfString.length > 2)
        {
          str = arrayOfString[2];
          if (TextUtils.isEmpty(str))
          {
            com.skplanet.tad.common.a.c("!E0090: there is no banner resource id:" + str);
            str = null;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject2 = null;
        continue;
      }
      try
      {
        if (arrayOfString.length <= 3) {
          continue;
        }
        localObject3 = arrayOfString[3];
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        com.skplanet.tad.common.a.c("!E0091: there is no full resource id:" + (String)localObject3);
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      this.m = ((String)localObject1);
      this.n = paramString;
      this.p = str;
      this.q = ((String)localObject4);
      return;
      localObject1 = ((String)localObject1).trim();
      continue;
      localObject1 = "p";
      localObject3 = localObject1;
      com.skplanet.tad.common.a.c("!E0088: there is no any application status response code in message(P):" + paramString);
      continue;
      localObject3 = localObject1;
      paramString = paramString.trim();
      continue;
      localObject3 = localObject1;
      com.skplanet.tad.common.a.c("!E0089: there is no app category id:" + paramString);
      paramString = null;
      continue;
      str = str.trim();
      continue;
      com.skplanet.tad.common.a.c("!E0090: there is no banner resource id");
      str = null;
      continue;
      localObject3 = ((String)localObject3).trim();
      localObject4 = localObject3;
      continue;
      com.skplanet.tad.common.a.c("!E0091: there is no full resource id");
    }
  }
  
  private void e()
  {
    Object localObject = this.a.getResources().getDisplayMetrics();
    this.k = this.d.c;
    this.l = this.d.d;
    this.g = this.d.f();
    this.i = String.valueOf(((DisplayMetrics)localObject).widthPixels);
    this.j = String.valueOf(((DisplayMetrics)localObject).heightPixels);
    this.t = Build.MODEL;
    this.u = Build.MANUFACTURER;
    this.w = Build.VERSION.RELEASE;
    localObject = this.a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("tstore://")), 0);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.x = "Y";
      this.o = "WCDMA";
      if (com.skplanet.tad.common.b.a(this.a).a.c)
      {
        localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
        if (localObject != null)
        {
          localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
          if (localObject != null)
          {
            localObject = ((NetworkInfo)localObject).getTypeName();
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if (!((String)localObject).trim().equalsIgnoreCase("MOBILE")) {
                break label276;
              }
              localObject = "WCDMA";
              label214:
              this.o = ((String)localObject);
            }
          }
        }
      }
      if (!this.e) {
        break label283;
      }
    }
    label276:
    label283:
    for (this.r = "FULL";; this.r = "DOWN")
    {
      localObject = this.a.getSharedPreferences("T_AD", 0);
      if (localObject != null) {
        this.s = ((SharedPreferences)localObject).getString("com.sktelecom.tad.sdk.cookie", "");
      }
      return;
      this.x = "N";
      break;
      localObject = "WIFI";
      break label214;
    }
  }
  
  protected com.skplanet.tad.v2.content.a a(String... paramVarArgs)
  {
    this.h = paramVarArgs[0];
    this.m = paramVarArgs[1];
    this.n = paramVarArgs[2];
    this.p = paramVarArgs[3];
    this.q = paramVarArgs[4];
    if ((this.m == null) || (this.n == null) || (this.p == null) || (this.q == null)) {
      try
      {
        paramVarArgs = a();
        if (paramVarArgs == null) {
          return null;
        }
      }
      catch (MalformedURLException paramVarArgs)
      {
        for (;;)
        {
          this.c = d.a.c;
          paramVarArgs = null;
        }
      }
      catch (IOException paramVarArgs)
      {
        for (;;)
        {
          this.c = d.a.b;
          paramVarArgs = null;
        }
      }
      catch (Throwable paramVarArgs)
      {
        for (;;)
        {
          this.c = d.a.c;
          paramVarArgs = null;
        }
      }
    }
    if ((!this.y.booleanValue()) && ((this.m.equals("E")) || (this.m.equals("P"))))
    {
      this.c = d.a.c;
      return null;
    }
    try
    {
      paramVarArgs = c();
      if ((paramVarArgs == null) || (paramVarArgs.n() == null))
      {
        this.c = d.a.e;
        return null;
      }
    }
    catch (Throwable paramVarArgs)
    {
      this.c = d.a.d;
      return null;
    }
    if ((paramVarArgs.n().toString().equals(a.a.a)) && (paramVarArgs.i().length < 1))
    {
      this.c = d.a.e;
      return null;
    }
    paramVarArgs.b(this.m);
    paramVarArgs.c(this.n);
    paramVarArgs.d(this.p);
    paramVarArgs.e(this.q);
    if (this.f == null) {
      this.f = this.a.getSharedPreferences("T_AD", 0);
    }
    SharedPreferences.Editor localEditor = this.f.edit();
    if (localEditor != null)
    {
      localEditor.putString("com.sktelecom.tad.sdk.cookie", paramVarArgs.o());
      localEditor.commit();
    }
    return paramVarArgs;
  }
  
  public String a()
    throws MalformedURLException, IOException, Throwable
  {
    String str = b();
    Object localObject = "http://app.t-ad.co.kr/appinfo.do";
    if (this.y.booleanValue()) {
      localObject = "http://220.103.245.209:8002/appinfo.do";
    }
    URL localURL = new URL(localObject + str);
    com.skplanet.tad.common.a.b("Send message in AdDownlaoderV2", str + "url:" + (String)localObject);
    localObject = a(localURL, 10000, false);
    if (((HttpURLConnection)localObject).getResponseCode() == 200)
    {
      localObject = a(((HttpURLConnection)localObject).getInputStream());
      com.skplanet.tad.common.a.b("receive message in AdDownlaoderV2", (String)localObject);
      a((String)localObject);
      return (String)localObject;
    }
    return null;
  }
  
  protected void a(com.skplanet.tad.v2.content.a parama)
  {
    if (parama == null)
    {
      this.b.a(this.c);
      return;
    }
    this.b.a(parama);
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("?appid=" + this.h + "&h=" + this.i + "&v=" + this.j + "&sdk_ver=" + this.k + "&carrier=" + this.l);
    if (!TextUtils.isEmpty(this.g)) {
      localStringBuffer.append("&userId=" + this.g);
    }
    return localStringBuffer.toString();
  }
  
  public com.skplanet.tad.v2.content.a c()
    throws MalformedURLException, IOException, Throwable
  {
    String str = d();
    Object localObject1 = "http://ad.t-ad.co.kr:15000/bin/InappRequest";
    if (this.y.booleanValue()) {
      localObject1 = "http://220.103.245.209:16000/bin/InappRequest";
    }
    Object localObject2 = a(new URL((String)localObject1), 10000, true);
    com.skplanet.tad.common.a.b("Send message in AdDownlaoderV2", str + "url:" + (String)localObject1);
    a(((HttpURLConnection)localObject2).getOutputStream(), str);
    if (((HttpURLConnection)localObject2).getResponseCode() == 200)
    {
      str = a(((HttpURLConnection)localObject2).getInputStream());
      com.skplanet.tad.common.a.b("Receive message in AdDownlaoderV2", str);
      localObject1 = new com.skplanet.tad.v2.content.a();
      localObject2 = new f();
      if (str.length() > 0) {
        localObject1 = ((f)localObject2).a(str);
      }
      return (com.skplanet.tad.v2.content.a)localObject1;
    }
    com.skplanet.tad.common.a.c("AdDownloader.requestAdInfo(), conn.getResponseCode()" + ((HttpURLConnection)localObject2).getResponseCode());
    return null;
  }
  
  public String d()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2;
    if (this.y.booleanValue())
    {
      localStringBuffer1.append("MODE=").append("C").append('&');
      localStringBuffer1.append("AppID=").append(this.h).append('&');
      localStringBuffer1.append("AppCategoryID=").append(this.n).append('&');
      localStringBuffer1.append("SDK=").append(this.k).append('&');
      localStringBuffer1.append("DevName=").append(this.t).append('&');
      localStringBuffer1.append("Vendor=").append(this.u).append('&');
      localStringBuffer1.append("OsName=").append(this.v).append('&');
      localStringBuffer1.append("OsVer=").append(this.w).append('&');
      localStringBuffer1.append("Tstore=").append(this.x).append('&');
      localStringBuffer1.append("Carrier=").append(this.l).append('&');
      localStringBuffer1.append("Network=").append(this.o).append('&');
      localStringBuffer1.append("Cookie=").append(this.s).append('&');
      localStringBuffer2 = localStringBuffer1.append("ResourceId=");
      if (!this.e) {
        break label411;
      }
    }
    label411:
    for (String str = this.q;; str = this.p)
    {
      localStringBuffer2.append(str).append('&');
      localStringBuffer1.append("AdPos=").append(this.r).append('&');
      if (!TextUtils.isEmpty(this.g)) {
        localStringBuffer1.append("UserId=" + this.g).append('&');
      }
      localStringBuffer1.append("h=").append(this.i).append('&');
      localStringBuffer1.append("v=").append(this.j);
      return localStringBuffer1.toString();
      localStringBuffer1.append("MODE=").append(this.m).append('&');
      break;
    }
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */