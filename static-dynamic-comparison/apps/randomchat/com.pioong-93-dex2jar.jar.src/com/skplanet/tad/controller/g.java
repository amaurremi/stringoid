package com.skplanet.tad.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.b;
import com.skplanet.tad.common.e;
import com.skplanet.tad.protocol.AdTermsResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends AsyncTask
{
  private Context a;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private String a(int paramInt)
    throws JSONException
  {
    String str1 = b.a(this.a).f;
    String str2 = b.a(this.a).c;
    String str3 = b.a(this.a).g();
    String str4 = b.a(this.a).d;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(paramInt))) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("d_uid", str1);
    localJSONObject.put("m_sdk_ver", str2);
    localJSONObject.put("u_terms", paramInt);
    localJSONObject.put("u_phone_number", str3);
    localJSONObject.put("u_network_operator", str4);
    return localJSONObject.toString();
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 44	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: new 76	java/io/BufferedReader
    //   11: dup
    //   12: new 78	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 81	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 84	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 87	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +12 -> 42
    //   33: aload_1
    //   34: invokevirtual 90	java/io/BufferedReader:close	()V
    //   37: aload_2
    //   38: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: areturn
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: goto -24 -> 24
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 90	java/io/BufferedReader:close	()V
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	g
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
  
  protected Boolean a(Integer... paramVarArgs)
  {
    AdTermsResponse localAdTermsResponse = new AdTermsResponse();
    int i = paramVarArgs[0].intValue();
    do
    {
      try
      {
        paramVarArgs = a(i);
        if ((paramVarArgs == null) || (TextUtils.isEmpty(paramVarArgs)))
        {
          a.d("AdTermSender.run(), CheckEssensial field");
          return null;
        }
        a.b("Send message in AdTermsSenderV3", paramVarArgs + "url:" + "http://www.adotsolution.com/pinfo/terms/update");
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://www.adotsolution.com/pinfo/terms/update").openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/json");
        localHttpURLConnection.setRequestMethod("POST");
        a(localHttpURLConnection.getOutputStream(), paramVarArgs);
        i = localHttpURLConnection.getResponseCode();
        if (i != 200) {
          a.d("AdTermsSender.run(), responseCode" + i);
        }
        for (paramVarArgs = localAdTermsResponse; paramVarArgs == null; paramVarArgs = (AdTermsResponse)b.a(this.a).a(new JSONObject(paramVarArgs), AdTermsResponse.class))
        {
          a.d("AdTermsSender.run(), bi == null");
          return Boolean.valueOf(false);
          paramVarArgs = a(localHttpURLConnection.getInputStream());
          a.b("receive message in AdTermsSenderV3", paramVarArgs);
        }
        i = -1;
        try
        {
          int j = Integer.parseInt(paramVarArgs.ret_code);
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a.d("AdTermsSender.run(), parseInt.ret_code, NumberFormatException");
          }
        }
        if (i != 200)
        {
          a.d("AdTermsSender.run(), not RET_CODE_NORMAL, ret_code" + i);
          return Boolean.valueOf(false);
        }
      }
      catch (Exception paramVarArgs)
      {
        a.d("AdTermSenderV3.run(), Exception" + paramVarArgs);
        return Boolean.valueOf(false);
      }
    } while (!e.a().a(paramVarArgs.u_terms));
    b.a(this.a).a(paramVarArgs.u_terms);
    b.a(this.a).e();
    return Boolean.valueOf(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/controller/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */