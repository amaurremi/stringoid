package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpUrlConnectionNetworkClient
  implements NetworkClient
{
  private HttpURLConnection mConnection;
  
  private void closeURLConnection(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
  
  private InputStream handleServerResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200) {
      return paramHttpURLConnection.getInputStream();
    }
    paramHttpURLConnection = "Bad response: " + i;
    if (i == 404) {
      throw new FileNotFoundException(paramHttpURLConnection);
    }
    throw new IOException(paramHttpURLConnection);
  }
  
  public void close()
  {
    closeURLConnection(this.mConnection);
  }
  
  public InputStream getInputStream(String paramString)
    throws IOException
  {
    this.mConnection = getUrlConnection(paramString);
    return handleServerResponse(this.mConnection);
  }
  
  @VisibleForTesting
  HttpURLConnection getUrlConnection(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setReadTimeout(20000);
    paramString.setConnectTimeout(20000);
    return paramString;
  }
  
  /* Error */
  public void sendPostRequest(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 65	com/google/tagmanager/HttpUrlConnectionNetworkClient:getUrlConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   5: astore_1
    //   6: aload_1
    //   7: ldc 87
    //   9: aload_2
    //   10: arraylength
    //   11: invokestatic 92	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   14: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_1
    //   18: ldc 98
    //   20: invokevirtual 101	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: iconst_1
    //   25: invokevirtual 105	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   28: aload_1
    //   29: invokevirtual 108	java/net/HttpURLConnection:connect	()V
    //   32: aload_1
    //   33: invokevirtual 112	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   36: astore_3
    //   37: aload_3
    //   38: aload_2
    //   39: invokevirtual 118	java/io/OutputStream:write	([B)V
    //   42: aload_3
    //   43: invokevirtual 121	java/io/OutputStream:flush	()V
    //   46: aload_3
    //   47: invokevirtual 123	java/io/OutputStream:close	()V
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 67	com/google/tagmanager/HttpUrlConnectionNetworkClient:handleServerResponse	(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   55: pop
    //   56: aload_0
    //   57: aload_1
    //   58: invokespecial 60	com/google/tagmanager/HttpUrlConnectionNetworkClient:closeURLConnection	(Ljava/net/HttpURLConnection;)V
    //   61: return
    //   62: astore_2
    //   63: aload_3
    //   64: invokevirtual 123	java/io/OutputStream:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: astore_2
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 60	com/google/tagmanager/HttpUrlConnectionNetworkClient:closeURLConnection	(Ljava/net/HttpURLConnection;)V
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	HttpUrlConnectionNetworkClient
    //   0	77	1	paramString	String
    //   0	77	2	paramArrayOfByte	byte[]
    //   36	28	3	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   37	46	62	finally
    //   6	37	69	finally
    //   46	56	69	finally
    //   63	69	69	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/HttpUrlConnectionNetworkClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */