package com.skplanet.tad.v2.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.skplanet.tad.common.b;
import com.skplanet.tad.common.b.c;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class c
  extends Thread
{
  Context a;
  com.skplanet.tad.v2.content.a b;
  boolean c;
  String d;
  b e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l = "Android";
  String m;
  String n;
  String o;
  private SharedPreferences p = null;
  
  public c(Context paramContext, com.skplanet.tad.v2.content.a parama, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a = paramContext;
    this.b = parama;
    this.i = paramString1;
    this.c = paramBoolean;
    this.d = paramString2;
    this.e = b.a(paramContext);
    c();
  }
  
  private String a()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append(b()).append('&');
    localStringBuffer1.append("MODE=").append(this.b.b()).append('&');
    localStringBuffer1.append("Cookie=").append(this.n).append('&');
    localStringBuffer1.append("Carrier=").append(this.g).append('&');
    localStringBuffer1.append("Network=").append(this.h).append('&');
    localStringBuffer1.append("SDK=").append(this.f).append('&');
    localStringBuffer1.append("AppID=").append(this.i).append('&');
    localStringBuffer1.append("EventType=").append(this.d).append('&');
    localStringBuffer1.append("LandType=").append(this.b.r().toString()).append('&');
    localStringBuffer1.append("DevName=").append(this.j).append('&');
    localStringBuffer1.append("Vendor=").append(this.k).append('&');
    localStringBuffer1.append("OsName=").append(this.l).append('&');
    localStringBuffer1.append("OsVer=").append(this.m).append('&');
    StringBuffer localStringBuffer2 = localStringBuffer1.append("ResourceId=");
    if (this.c) {}
    for (String str = this.b.e();; str = this.b.d())
    {
      localStringBuffer2.append(str).append('&');
      if (!TextUtils.isEmpty(this.o)) {
        localStringBuffer1.append("UserId=" + this.o).append('&');
      }
      localStringBuffer1.append("AppCategoryID=").append(this.b.c());
      return localStringBuffer1.toString();
    }
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 134	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: new 156	java/io/BufferedReader
    //   11: dup
    //   12: new 158	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 161	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: sipush 512
    //   23: invokespecial 164	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +12 -> 45
    //   36: aload_1
    //   37: invokevirtual 170	java/io/BufferedReader:close	()V
    //   40: aload_2
    //   41: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: areturn
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: goto -24 -> 27
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 170	java/io/BufferedReader:close	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	c
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
    if (this.p == null) {
      this.p = this.a.getSharedPreferences("T_AD", 0);
    }
    SharedPreferences.Editor localEditor = this.p.edit();
    if (localEditor != null)
    {
      localEditor.putString("com.sktelecom.tad.sdk.cookie", paramString);
      localEditor.commit();
    }
  }
  
  private String b()
  {
    String str2 = this.b.a();
    String str1 = null;
    int i1 = str2.indexOf('?');
    if (i1 > 0) {
      str1 = str2.substring(i1 + 1);
    }
    return str1;
  }
  
  private void c()
  {
    this.f = this.e.c;
    this.g = this.e.d;
    this.o = this.e.f();
    this.j = Build.MODEL;
    this.k = Build.MANUFACTURER;
    this.m = Build.VERSION.RELEASE;
    this.h = "WCDMA";
    if (b.a(this.a).a.c)
    {
      localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null)
        {
          localObject = ((NetworkInfo)localObject).getTypeName();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            if (!((String)localObject).trim().equalsIgnoreCase("MOBILE")) {
              break label169;
            }
          }
        }
      }
    }
    label169:
    for (Object localObject = "WCDMA";; localObject = "WIFI")
    {
      this.h = ((String)localObject);
      localObject = this.a.getSharedPreferences("T_AD", 0);
      if (localObject != null) {
        this.n = ((SharedPreferences)localObject).getString("com.sktelecom.tad.sdk.cookie", "");
      }
      return;
    }
  }
  
  public void run()
  {
    String str = a();
    com.skplanet.tad.common.a.b("Send message in AdEventSenderV2", str + "url:" + this.b.a());
    try
    {
      HttpURLConnection localHttpURLConnection = a(new URL(this.b.a()), 10000, true);
      a(localHttpURLConnection.getOutputStream(), str);
      if (localHttpURLConnection.getResponseCode() == 200)
      {
        str = a(localHttpURLConnection.getInputStream());
        com.skplanet.tad.common.a.b("receive message in AdEventSenderV2", str);
        if ((str != null) && (str.length() > 0))
        {
          g.b().a(str, null);
          a(g.b().a());
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */