package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class av
  implements bl
{
  private HttpClient Yg;
  
  private InputStream a(HttpClient paramHttpClient, HttpResponse paramHttpResponse)
    throws IOException
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i == 200)
    {
      bh.y("Success response");
      return paramHttpResponse.getEntity().getContent();
    }
    paramHttpClient = "Bad response: " + i;
    if (i == 404) {
      throw new FileNotFoundException(paramHttpClient);
    }
    throw new IOException(paramHttpClient);
  }
  
  private void a(HttpClient paramHttpClient)
  {
    if ((paramHttpClient != null) && (paramHttpClient.getConnectionManager() != null)) {
      paramHttpClient.getConnectionManager().shutdown();
    }
  }
  
  public InputStream bD(String paramString)
    throws IOException
  {
    this.Yg = kF();
    paramString = this.Yg.execute(new HttpGet(paramString));
    return a(this.Yg, paramString);
  }
  
  public void close()
  {
    a(this.Yg);
  }
  
  HttpClient kF()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    return new DefaultHttpClient(localBasicHttpParams);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */