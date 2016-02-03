package com.skplanet.tad.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b.c;
import com.skplanet.tad.common.e;
import com.skplanet.tad.protocol.AdTermsResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  implements Runnable
{
  private Context a;
  private b b;
  private int c;
  private boolean d = false;
  
  public c(Context paramContext, int paramInt, b paramb)
  {
    this.a = paramContext;
    this.c = paramInt;
    this.b = paramb;
    this.d = paramb.d;
  }
  
  private String a()
    throws JSONException
  {
    if (this.b == null) {
      return null;
    }
    String str3 = this.b.a;
    String str4 = this.b.b;
    String str5 = this.b.c;
    String str6 = Build.MODEL;
    String str7 = Build.MANUFACTURER;
    String str8 = Build.VERSION.RELEASE;
    String str9 = com.skplanet.tad.common.b.a(this.a).f;
    String str10 = com.skplanet.tad.common.b.a(this.a).c;
    String str11 = com.skplanet.tad.common.b.a(this.a).d;
    Object localObject;
    if (com.skplanet.tad.common.b.a(this.a).a.c)
    {
      localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject == null) {}
      }
    }
    switch (((NetworkInfo)localObject).getType())
    {
    default: 
      localObject = "0";
    }
    String str2;
    String str1;
    for (;;)
    {
      str2 = null;
      str1 = null;
      if (!TextUtils.isEmpty(com.skplanet.tad.common.b.a(this.a).f()))
      {
        str2 = com.skplanet.tad.common.b.a(this.a).f();
        str1 = com.skplanet.tad.common.b.a(this.a).a();
      }
      if ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(str9)) || (!TextUtils.isEmpty(str10)) || (!TextUtils.isEmpty(this.c)) || (!TextUtils.isEmpty(str6)) || (!TextUtils.isEmpty(str7)) || (!TextUtils.isEmpty(str8)) || (!TextUtils.isEmpty(str5))) {
        break;
      }
      return null;
      localObject = "2";
      continue;
      localObject = "1";
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("m_client_id", str3);
    localJSONObject.put("m_slot", str4);
    localJSONObject.put("d_uid", str9);
    localJSONObject.put("m_sdk_ver", str10);
    localJSONObject.put("d_network", localObject);
    localJSONObject.put("d_model", str6);
    localJSONObject.put("d_vendor", str7);
    localJSONObject.put("d_os_name", "1");
    localJSONObject.put("d_os_ver", str8);
    localJSONObject.put("u_network_operator", str11);
    localJSONObject.put("x_bypass", str5);
    localJSONObject.put("k_event", this.c);
    if (str2 != null)
    {
      localJSONObject.put("u_terms", str1);
      localJSONObject.put("u_phone_number", str2);
    }
    localJSONObject.put("k_pilot", "N");
    return localJSONObject.toString();
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 104	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: new 164	java/io/BufferedReader
    //   11: dup
    //   12: new 166	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 169	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 172	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 175	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +12 -> 42
    //   33: aload_1
    //   34: invokevirtual 178	java/io/BufferedReader:close	()V
    //   37: aload_2
    //   38: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: areturn
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: goto -24 -> 24
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 178	java/io/BufferedReader:close	()V
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	c
    //   0	58	1	paramInputStream	java.io.InputStream
    //   7	36	2	localStringBuilder	StringBuilder
    //   51	6	2	localObject	Object
    //   28	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	51	finally
    //   42	48	51	finally
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
  
  public void run()
  {
    label358:
    for (;;)
    {
      try
      {
        String str2 = a();
        if ((str2 == null) || (TextUtils.isEmpty(str2)))
        {
          a.d("AdEventSender.run(), CheckEssensial field");
          return;
        }
        String str1 = com.skplanet.tad.common.b.a(this.a).j;
        if (!this.d) {
          break label358;
        }
        str1 = "http://event-dev.adotsolution.com:16000/logger";
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setRequestMethod("POST");
        a(localHttpURLConnection.getOutputStream(), str2);
        a.b("Send message in AdEventSenderV3", str2 + "url:" + str1);
        i = localHttpURLConnection.getResponseCode();
        a.d("AdEventSender.run(), responseCode:" + i);
        if ((i != 200) || (this.c != 0)) {
          break;
        }
        new AdTermsResponse();
        str1 = a(localHttpURLConnection.getInputStream());
        a.b("Receive message in AdEventSenderV3", str1);
        if ((str1 == null) || (str1.length() <= 0))
        {
          a.d("Receive message is null");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a.d("AdEventSenderV3.run(), Exception" + localThrowable);
        return;
      }
      AdTermsResponse localAdTermsResponse = (AdTermsResponse)com.skplanet.tad.common.b.a(this.a).a(new JSONObject(localThrowable), AdTermsResponse.class);
      if (localAdTermsResponse == null)
      {
        a.d("AdEventSender.run(), bi == null");
        return;
      }
      int i = -1;
      try
      {
        int j = Integer.parseInt(localAdTermsResponse.ret_code);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a.d("AdEventSender.run(), parseInt.ret_code, NumberFormatException");
        }
      }
      switch (i)
      {
      default: 
        return;
      case 201: 
        if (!e.a().a(localAdTermsResponse.u_terms)) {
          return;
        }
        com.skplanet.tad.common.b.a(this.a).a(localAdTermsResponse.u_terms);
        com.skplanet.tad.common.b.a(this.a).e();
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */