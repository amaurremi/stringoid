package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class HttpNetworkClient
  implements NetworkClient
{
  private HttpClient mClient;
  
  private void closeWithClient(HttpClient paramHttpClient)
  {
    if ((paramHttpClient != null) && (paramHttpClient.getConnectionManager() != null)) {
      paramHttpClient.getConnectionManager().shutdown();
    }
  }
  
  private InputStream handleServerResponse(HttpClient paramHttpClient, HttpResponse paramHttpResponse)
    throws IOException
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i == 200)
    {
      Log.v("Success response");
      return paramHttpResponse.getEntity().getContent();
    }
    paramHttpClient = "Bad response: " + i;
    if (i == 404) {
      throw new FileNotFoundException(paramHttpClient);
    }
    throw new IOException(paramHttpClient);
  }
  
  public void close()
  {
    closeWithClient(this.mClient);
  }
  
  @VisibleForTesting
  HttpClient createNewHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    return new DefaultHttpClient(localBasicHttpParams);
  }
  
  @VisibleForTesting
  HttpPost createPostRequest(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new HttpPost(paramString);
    paramString.setEntity(new ByteArrayEntity(paramArrayOfByte));
    return paramString;
  }
  
  public InputStream getInputStream(String paramString)
    throws IOException
  {
    this.mClient = createNewHttpClient();
    paramString = this.mClient.execute(new HttpGet(paramString));
    return handleServerResponse(this.mClient, paramString);
  }
  
  public void sendPostRequest(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    HttpClient localHttpClient = createNewHttpClient();
    handleServerResponse(localHttpClient, localHttpClient.execute(createPostRequest(paramString, paramArrayOfByte)));
    closeWithClient(localHttpClient);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/HttpNetworkClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */