package crittercism.android;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class c
{
  private final DefaultHttpClient a;
  private final String b;
  private Context c;
  
  public c()
  {
    this.b = "";
    this.a = a();
  }
  
  public c(String paramString, Context paramContext)
  {
    this.b = paramString;
    this.a = a();
    this.c = paramContext;
  }
  
  private String a(HttpRequestBase paramHttpRequestBase)
  {
    for (;;)
    {
      try
      {
        this.a.getConnectionManager().closeExpiredConnections();
        localObject = this.a.execute(paramHttpRequestBase);
        i = ((HttpResponse)localObject).getStatusLine().getStatusCode();
        switch (i)
        {
        case 200: 
          c.class.getCanonicalName();
          new StringBuilder("executeHttpRequest error=").append(i).append(" - ").append(((HttpResponse)localObject).getStatusLine().toString()).toString();
          ((HttpResponse)localObject).getEntity().consumeContent();
          return "";
        }
      }
      catch (ConnectTimeoutException paramHttpRequestBase)
      {
        Object localObject;
        c.class.getClass().getCanonicalName();
        throw new f(a.a(11), f.a.b);
      }
      catch (IOException localIOException)
      {
        paramHttpRequestBase.abort();
        int i = 0;
        if (i >= paramHttpRequestBase.getAllHeaders().length) {
          continue;
        }
        Header localHeader = paramHttpRequestBase.getAllHeaders()[i];
        new StringBuilder().append(localHeader.getName()).append(": ").append(localHeader.getValue()).toString();
        i += 1;
        continue;
        if ((localIOException.getMessage() == null) || (!localIOException.getMessage().toLowerCase().contains("no route to host"))) {
          continue;
        }
        throw new f(a.a(10), f.a.a);
        if (!localIOException.getStackTrace()[0].toString().contains("java.net.InetAddress.lookupHostByName")) {
          continue;
        }
        c.class.getClass().getCanonicalName();
        throw new f(a.a(10), f.a.a);
        throw localIOException;
      }
      catch (Exception paramHttpRequestBase)
      {
        c.class.getClass().getCanonicalName();
        new StringBuilder("Neither ConnectTimeoutException nor IOException.  Instead: ").append(paramHttpRequestBase.getClass().getName()).toString();
        return "";
      }
      localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity(), "UTF-8");
      return (String)localObject;
    }
  }
  
  private static DefaultHttpClient a()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    Object localObject = SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    localSSLSocketFactory.setHostnameVerifier((X509HostnameVerifier)localObject);
    localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
    localObject = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 20000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 8192);
    HttpClientParams.setRedirecting((HttpParams)localObject, false);
    return new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, localSchemeRegistry), (HttpParams)localObject);
  }
  
  public final String a(String paramString, JSONObject paramJSONObject)
  {
    paramString = new HttpPost(paramString);
    paramString.addHeader("User-Agent", this.b);
    paramString.addHeader("Content-Type", "application/json");
    try
    {
      paramString.setEntity(new ByteArrayEntity(paramJSONObject.toString().getBytes("UTF8")));
      new StringBuilder("JSON Object for request: ").append(paramJSONObject.toString()).toString();
      new StringBuilder("httpPost Entity is: ").append(paramString.getEntity().getContent().toString()).toString();
      return a(paramString);
    }
    catch (Exception paramString)
    {
      throw new IllegalArgumentException("Error encoding http params");
    }
  }
  
  public final String a(String paramString1, JSONObject paramJSONObject, String[] paramArrayOfString, String paramString2)
  {
    int i = 0;
    new String();
    Object localObject1 = new byte[30];
    new Random().nextBytes((byte[])localObject1);
    localObject1 = g.a((byte[])localObject1);
    new StringBuilder("boundary = ").append((String)localObject1).toString();
    paramString1 = new HttpPost(paramString1);
    paramString1.addHeader("User-Agent", this.b);
    paramString1.addHeader("Content-Type", "multipart/form-data; boundary=" + (String)localObject1 + "; charset=\"utf-8\"");
    paramString1.addHeader("Accept", "text/plain, application/json");
    paramString1.addHeader("Content-Disposition", "form-data");
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject2;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("--" + (String)localObject1 + "\n");
      ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=\"" + paramString2 + "json\";\n");
      ((StringBuilder)localObject2).append("Content-type: application/json\n\n");
      ((StringBuilder)localObject2).append(paramJSONObject.toString() + "\n");
      localByteArrayOutputStream.write(((StringBuilder)localObject2).toString().getBytes("UTF-8"));
      if (i < paramArrayOfString.length)
      {
        paramJSONObject = new File(paramArrayOfString[i]);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--" + (String)localObject1 + "\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=\"" + paramString2 + Integer.toString(i) + "\"; filename=\"" + paramJSONObject.getName() + "\";\n");
        ((StringBuilder)localObject2).append("Content-type: application/octet-stream\n\n");
        localByteArrayOutputStream.write(((StringBuilder)localObject2).toString().getBytes("UTF-8"));
        paramJSONObject = new FileInputStream(paramJSONObject);
        localObject2 = new byte[' '];
        for (;;)
        {
          int j = paramJSONObject.read((byte[])localObject2);
          if (j < 0) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject2, 0, j);
        }
        return a(paramString1);
      }
    }
    catch (Exception paramJSONObject) {}
    for (;;)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\n");
      localByteArrayOutputStream.write(((StringBuilder)localObject2).toString().getBytes("UTF-8"));
      paramJSONObject.close();
      localByteArrayOutputStream.close();
      i += 1;
      break;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("--" + (String)localObject1 + "--");
      localByteArrayOutputStream.write(paramJSONObject.toString().getBytes("UTF-8"));
      paramString1.setEntity(new ByteArrayEntity(localByteArrayOutputStream.toByteArray()));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */