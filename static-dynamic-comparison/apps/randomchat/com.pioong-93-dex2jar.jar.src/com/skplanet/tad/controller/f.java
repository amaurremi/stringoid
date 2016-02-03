package com.skplanet.tad.controller;

import android.os.AsyncTask;
import com.skplanet.tad.common.a;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class f
  extends AsyncTask
{
  d a;
  
  public f(d paramd)
  {
    this.a = paramd;
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
    throws Throwable
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +6 -> 7
    //   4: ldc 19
    //   6: areturn
    //   7: new 21	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   14: astore_2
    //   15: new 24	java/io/BufferedReader
    //   18: dup
    //   19: new 26	java/io/InputStreamReader
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 29	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 512
    //   30: invokespecial 32	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 36	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnonnull +12 -> 52
    //   43: aload_1
    //   44: invokevirtual 39	java/io/BufferedReader:close	()V
    //   47: aload_2
    //   48: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: areturn
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -24 -> 34
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 39	java/io/BufferedReader:close	()V
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	f
    //   0	68	1	paramInputStream	java.io.InputStream
    //   14	39	2	localStringBuilder	StringBuilder
    //   61	6	2	localObject	Object
    //   38	16	3	str	String
    // Exception table:
    //   from	to	target	type
    //   34	39	61	finally
    //   52	58	61	finally
  }
  
  protected Integer a(String... paramVarArgs)
  {
    if (paramVarArgs[0] != null) {}
    try
    {
      if ((paramVarArgs[0].length() < 1) || (paramVarArgs[1] == null) || (paramVarArgs[1].length() < 1)) {
        return Integer.valueOf(-1);
      }
      paramVarArgs = "http://gw.adotsolution.com:14000/indicator?m_sdk_ver=" + paramVarArgs[0] + "&" + "m_client_id=" + paramVarArgs[1];
      a.b("Send message in AdServerVersionChecker", paramVarArgs);
      paramVarArgs = (HttpURLConnection)new URL(paramVarArgs).openConnection();
      paramVarArgs.setConnectTimeout(5000);
      paramVarArgs.setReadTimeout(5000);
      paramVarArgs.setDoInput(true);
      paramVarArgs.setUseCaches(false);
      paramVarArgs.setFixedLengthStreamingMode(0);
      paramVarArgs.setRequestMethod("GET");
      int i = paramVarArgs.getResponseCode();
      if (i == 200)
      {
        paramVarArgs = new JSONObject(a(paramVarArgs.getInputStream()));
        a.b("Receive message in AdServerVersionChecker", paramVarArgs.toString());
        return Integer.valueOf(paramVarArgs.getInt("version_info"));
      }
      a.c("in AdServerVersionChecker, ResCode: " + i);
      return Integer.valueOf(-1);
    }
    catch (Throwable paramVarArgs)
    {
      a.d("Exception in AdServerVersionChecker" + paramVarArgs);
    }
    return Integer.valueOf(-1);
  }
  
  protected void a(Integer paramInteger)
  {
    if (this.a != null) {
      this.a.a(paramInteger);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/controller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */