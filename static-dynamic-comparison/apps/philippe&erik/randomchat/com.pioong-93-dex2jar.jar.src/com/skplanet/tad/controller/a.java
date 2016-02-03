package com.skplanet.tad.controller;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.skplanet.tad.common.b;
import com.skplanet.tad.common.b.c;
import com.skplanet.tad.protocol.AdInAppResponse;
import com.skplanet.tad.protocol.AdInAppResponseRich;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends AsyncTask
{
  private d a;
  private d.a b = d.a.a;
  private Context c;
  private String d;
  private String e;
  private String f;
  private boolean g;
  
  public a(Context paramContext, d paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.c = paramContext;
    this.a = paramd;
    this.d = paramString1;
    this.e = paramString2;
    this.g = paramBoolean;
  }
  
  private AdInAppResponse a()
  {
    new AdInAppResponse();
    try
    {
      Object localObject2 = b();
      if (localObject2 == null)
      {
        com.skplanet.tad.common.a.a("AdDownloader error > essensial field is null.");
        return null;
      }
      Object localObject1 = b.a(this.c).i;
      if ((localObject1 == null) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        com.skplanet.tad.common.a.a("AdDownloader error > request url is null.");
        return null;
      }
      if (this.g) {
        localObject1 = "http://ad-dev.adotsolution.com:15000/inapp/ad_request";
      }
      com.skplanet.tad.common.a.b("Send message in AdDownloaderV3", localObject2 + "url : " + (String)localObject1);
      localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
      ((HttpURLConnection)localObject1).setConnectTimeout(5000);
      ((HttpURLConnection)localObject1).setReadTimeout(5000);
      ((HttpURLConnection)localObject1).setDoInput(true);
      ((HttpURLConnection)localObject1).setDoOutput(true);
      ((HttpURLConnection)localObject1).setUseCaches(false);
      ((HttpURLConnection)localObject1).setRequestMethod("POST");
      a(((HttpURLConnection)localObject1).getOutputStream(), (String)localObject2);
      int i = ((HttpURLConnection)localObject1).getResponseCode();
      if (i != 200)
      {
        com.skplanet.tad.common.a.a("AdDownloader error > network error : " + i);
        this.b = d.a.b;
        return null;
      }
      localObject1 = a(((HttpURLConnection)localObject1).getInputStream());
      com.skplanet.tad.common.a.b("receive message in AdDownloader", (String)localObject1);
      localObject2 = (AdInAppResponse)b.a(this.c).a(new JSONObject((String)localObject1), AdInAppResponse.class);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (((AdInAppResponse)localObject2).c_url != null) {
          ((AdInAppResponse)localObject2).c_url.replace("\\", "");
        }
        if ((((AdInAppResponse)localObject2).c_data != null) && (((AdInAppResponse)localObject2).c_data.base_url != null)) {
          ((AdInAppResponse)localObject2).c_data.base_url.replace("\\", "");
        }
        localObject1 = localObject2;
        if (((AdInAppResponse)localObject2).c_data != null)
        {
          localObject1 = localObject2;
          if (((AdInAppResponse)localObject2).c_data.backfill_image != null)
          {
            ((AdInAppResponse)localObject2).c_data.backfill_image.replace("\\", "");
            return (AdInAppResponse)localObject2;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      com.skplanet.tad.common.a.a("AdDownloader exception");
      com.skplanet.tad.common.a.d(localThrowable.toString());
      this.b = d.a.b;
      AdInAppResponse localAdInAppResponse = null;
      return localAdInAppResponse;
    }
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 76	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: new 192	java/io/BufferedReader
    //   11: dup
    //   12: new 194	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 197	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +12 -> 42
    //   33: aload_1
    //   34: invokevirtual 206	java/io/BufferedReader:close	()V
    //   37: aload_2
    //   38: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: areturn
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: goto -24 -> 24
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 206	java/io/BufferedReader:close	()V
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	a
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
  
  private String b()
    throws JSONException
  {
    if (this.c == null) {
      com.skplanet.tad.common.a.d("AdDownloader.makeSendMsg(), context is null");
    }
    String str2 = b.a(this.c).f;
    String str3 = b.a(this.c).c;
    String str4 = b.a(this.c).d;
    String str1 = "0";
    Object localObject1 = str1;
    String str5;
    String str6;
    String str7;
    if (b.a(this.c).a.c)
    {
      localObject1 = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject1 == null) {}
    }
    else
    {
      switch (((NetworkInfo)localObject1).getType())
      {
      default: 
        localObject1 = "0";
        str5 = Build.MODEL;
        str6 = Build.MANUFACTURER;
        str7 = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(b.a(this.c).f())) {
          break;
        }
      }
    }
    for (str1 = b.a(this.c).f();; str1 = null)
    {
      label258:
      String str8;
      if (this.c != null)
      {
        localObject2 = this.c.getResources().getDisplayMetrics();
        int i = ((DisplayMetrics)localObject2).heightPixels;
        int j = ((DisplayMetrics)localObject2).widthPixels;
        float f1 = ((DisplayMetrics)localObject2).density;
        this.f = (j + "x" + i + "x" + f1);
        str8 = b.a(this.c).g;
        localObject2 = b.a(this.c).h;
        if (localObject2 == null) {
          break label648;
        }
      }
      label648:
      for (Object localObject2 = ((Location)localObject2).getLatitude() + "x" + ((Location)localObject2).getLongitude() + "x" + ((Location)localObject2).getAccuracy();; localObject2 = null)
      {
        if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str6)) || (TextUtils.isEmpty(str7)) || (TextUtils.isEmpty(this.f)))
        {
          return null;
          localObject1 = "2";
          break;
          localObject1 = "1";
          break;
          com.skplanet.tad.common.a.d("AdDownloader.makeSendMsg(), networkInfo is null");
          localObject1 = str1;
          break;
          com.skplanet.tad.common.a.d("AdDownloader.makeSendMsg() null check in orientation");
          break label258;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("m_client_id", this.d);
        localJSONObject.put("m_slot", this.e);
        localJSONObject.put("m_sdk_ver", str3);
        localJSONObject.put("d_uid", str2);
        localJSONObject.put("d_model", str5);
        localJSONObject.put("d_vendor", str6);
        localJSONObject.put("d_os_name", "1");
        localJSONObject.put("d_os_ver", str7);
        localJSONObject.put("d_resolution", this.f);
        localJSONObject.put("d_network", localObject1);
        localJSONObject.put("d_locale", str8);
        localJSONObject.put("u_network_operator", str4);
        if (str1 != null) {
          localJSONObject.put("u_phone_number", str1);
        }
        if ((str1 != null) && (localObject2 != null)) {
          localJSONObject.put("u_geolocation", localObject2);
        }
        localJSONObject.put("k_pilot", "N");
        return localJSONObject.toString();
      }
    }
  }
  
  protected AdInAppResponse a(String... paramVarArgs)
  {
    com.skplanet.tad.common.a.a("AdDownloader is executed. clientId : " + this.d + ", slotNo : " + this.e + ", testMode : " + this.g);
    if (this.c == null)
    {
      com.skplanet.tad.common.a.a("AdDownloader error > context is null.");
      return null;
    }
    if (this.c != null)
    {
      paramVarArgs = this.c.getResources().getDisplayMetrics();
      int i = paramVarArgs.heightPixels;
      int j = paramVarArgs.widthPixels;
      float f1 = paramVarArgs.density;
      this.f = (j + "x" + i + "x" + f1);
    }
    for (;;)
    {
      return a();
      com.skplanet.tad.common.a.d("AdDownloader.doInbackground() null check in orientation");
    }
  }
  
  protected void a(AdInAppResponse paramAdInAppResponse)
  {
    if (this.a == null)
    {
      com.skplanet.tad.common.a.d("AdDownloader.onPostExecute(), mListener is null");
      return;
    }
    if (paramAdInAppResponse == null)
    {
      this.a.a(this.b);
      return;
    }
    this.a.a(paramAdInAppResponse);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/controller/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */