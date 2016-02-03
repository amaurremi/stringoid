package com.skplanet.tad.controller;

import android.os.AsyncTask;
import com.skplanet.tad.common.a;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class e
  extends AsyncTask
{
  private d a;
  private d.a b = d.a.a;
  private String c;
  
  public e(d paramd, String paramString)
  {
    this.a = paramd;
    this.c = paramString;
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = new StringBuffer(paramString1);
    int i = paramString1.indexOf("mraid.js");
    if (i > -1) {
      paramString1.replace(i, "mraid.js".length() + i, "file:///android_asset/tad_mraid.js");
    }
    i = paramString1.indexOf("tad.js");
    if (i > -1) {
      paramString1.replace(i, "tad.js".length() + i, "file:///android_asset/tad.js");
    }
    return paramString1.toString();
  }
  
  private String b(String paramString)
    throws ClientProtocolException, IllegalArgumentException, IOException, Throwable
  {
    System.setProperty("http.keepAlive", "false");
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    paramString = new HttpGet(paramString);
    paramString.addHeader("Connection", "close");
    HttpConnectionParams.setConnectionTimeout(paramString.getParams(), 10000);
    HttpConnectionParams.setSoTimeout(paramString.getParams(), 10000);
    paramString = localDefaultHttpClient.execute(paramString);
    if (paramString == null)
    {
      a.d("AdLoader.download, response is null");
      return null;
    }
    if (paramString.getStatusLine().getStatusCode() != 200)
    {
      a.d("AdLoader.download(), response.getStatusLine().getStatusCode() != 200");
      return null;
    }
    return a(EntityUtils.toString(paramString.getEntity(), "utf-8"), this.c);
  }
  
  protected String a(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = b(paramVarArgs[0]);
      return paramVarArgs;
    }
    catch (ClientProtocolException paramVarArgs)
    {
      a.d("AdLoader.ClientProtocolException");
      this.b = d.a.b;
      return null;
    }
    catch (IllegalArgumentException paramVarArgs)
    {
      a.d("AdLoader.IllegalArgumentException");
      this.b = d.a.b;
      return null;
    }
    catch (IOException paramVarArgs)
    {
      a.d("AdLoader.IOException");
      this.b = d.a.b;
      return null;
    }
    catch (Throwable paramVarArgs)
    {
      a.d("AdLoader.Throwable");
      this.b = d.a.b;
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    if (this.a == null)
    {
      a.d("AdLoader.onPsetExecute, mListener is null");
      return;
    }
    if (paramString == null)
    {
      this.a.a(this.b);
      return;
    }
    this.a.a(paramString);
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/controller/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */