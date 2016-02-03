package com.skplanet.tad.v2.controller;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b;
import com.skplanet.tad.common.d;
import com.skplanet.tad.common.d.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class e
  extends Thread
{
  private final String a = "http://app.t-ad.co.kr/appinfo.do";
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private boolean i;
  private String j;
  private String k;
  private Date l;
  
  public e(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.g = paramString;
    this.b = paramContext;
    this.i = paramBoolean;
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 41	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: new 44	java/io/BufferedReader
    //   11: dup
    //   12: new 46	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 49	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: sipush 512
    //   23: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +12 -> 45
    //   36: aload_1
    //   37: invokevirtual 59	java/io/BufferedReader:close	()V
    //   40: aload_2
    //   41: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: areturn
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: goto -24 -> 27
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 59	java/io/BufferedReader:close	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	e
    //   0	61	1	paramInputStream	java.io.InputStream
    //   7	39	2	localStringBuilder	StringBuilder
    //   54	6	2	localObject	Object
    //   31	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   27	32	54	finally
    //   45	51	54	finally
  }
  
  private String a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = paramString.split(",");
    paramString = (String)localObject1;
    try
    {
      if (localObject2.length > 4)
      {
        localObject2 = localObject2[4];
        paramString = (String)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramString = "E";
          a.c("!E0144: there is the IsPrivate:" + (String)localObject2);
          return "E";
        }
        paramString = (String)localObject1;
        return ((String)localObject2).trim();
      }
      paramString = (String)localObject1;
      a.c("!E0144: there is the IsPrivate.");
      return "E";
    }
    catch (Throwable localThrowable) {}
    return paramString;
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
  
  private void a()
  {
    Object localObject = this.b.getResources().getDisplayMetrics();
    this.c = String.valueOf(((DisplayMetrics)localObject).widthPixels);
    this.d = String.valueOf(((DisplayMetrics)localObject).heightPixels);
    this.e = b.a(this.b).c;
    this.f = b.a(this.b).d;
    this.h = b.a(this.b).g();
    localObject = new SimpleDateFormat("yyyyMMddHHmmss");
    this.l = Calendar.getInstance().getTime();
    this.j = ((SimpleDateFormat)localObject).format(this.l);
    if (this.i)
    {
      this.k = "Y";
      return;
    }
    this.k = "N";
  }
  
  private String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = null;
    if (!TextUtils.isEmpty(this.h)) {}
    try
    {
      str1 = URLEncoder.encode(this.h, "utf-8");
      localStringBuffer.append("?appid=" + this.g + "&h=" + this.c + "&v=" + this.d + "&sdk_ver=" + this.e + "&carrier=" + this.f + "&userId=" + str1 + "&policyVer=1.0&procTime=" + this.j + "&status=" + this.k + "&mode=I");
      return localStringBuffer.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2 = "";
      }
    }
  }
  
  public void run()
  {
    a.c("AdTermsSender.run(), isAgree : " + this.i);
    if (this.i) {
      if (!b.a(this.b).b(15)) {
        a.c("AdTermsSender.run(),미동의자 => 동의합니다.");
      }
    }
    for (;;)
    {
      a();
      if (this.h != null) {
        break;
      }
      a.c("E201 : MDN IS NULL");
      return;
      a.c("AdTermsSender.run(),기동의자 => 기동의합니다.");
      return;
      if ((b.a(this.b).a() == 0) || (b.a(this.b).a() < 0))
      {
        a.c("AdTermsSender.run(),미동의자 => 미동의합니다.");
        return;
      }
      a.c("AdTermsSender.run(),기동의자 => 미동의합니다.");
    }
    Object localObject = b();
    a.b("Send message in AdTermSenderV2", localObject + "url:" + "http://app.t-ad.co.kr/appinfo.do");
    try
    {
      localObject = a(new URL("http://app.t-ad.co.kr/appinfo.do" + (String)localObject), 10000, false);
      if (((HttpURLConnection)localObject).getResponseCode() == 200)
      {
        localObject = a(((HttpURLConnection)localObject).getInputStream());
        a.b("Receive message in AdTermSenderV2", (String)localObject);
        localObject = a((String)localObject);
        if (localObject != null) {
          break label245;
        }
        a.d("authResult is null");
      }
    }
    catch (Exception localException)
    {
      a.c("Error");
      localException.printStackTrace();
    }
    for (;;)
    {
      super.run();
      return;
      label245:
      if (localException.equals("E")) {
        break;
      }
      Hashtable localHashtable1;
      if ((localException.equals("S")) && (b.a(this.b).b(15)))
      {
        localHashtable1 = new Hashtable();
        localHashtable1.put(d.a.a.toString(), "");
        localHashtable1.put(d.a.b.toString(), "");
        localHashtable1.put(d.a.c.toString(), "");
        localHashtable1.put(d.a.e.toString(), "");
        localHashtable1.put(d.a.d.toString(), "");
        d.a().a(this.b, localHashtable1);
        b.a(this.b).a(0);
      }
      else if ((localHashtable1.length() > 0) && (!b.a(this.b).b(15)))
      {
        Hashtable localHashtable2 = new Hashtable();
        localHashtable2.put(d.a.a.toString(), localHashtable1);
        localHashtable2.put(d.a.b.toString(), "http://220.103.245.39:80/getLatestPolicyInfo.do");
        localHashtable2.put(d.a.c.toString(), this.l.getTime());
        localHashtable2.put(d.a.e.toString(), "M");
        localHashtable2.put(d.a.d.toString(), "");
        d.a().a(this.b, localHashtable2);
        b.a(this.b).a(15);
      }
      else
      {
        a.c("Error");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/controller/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */