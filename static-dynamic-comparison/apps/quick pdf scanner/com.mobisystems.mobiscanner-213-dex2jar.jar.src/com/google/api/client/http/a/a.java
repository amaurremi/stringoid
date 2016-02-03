package com.google.api.client.http.a;

import com.google.api.client.http.aa;
import com.google.api.client.http.z;
import com.google.api.client.util.x;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

final class a
  extends z
{
  private final HttpRequestBase acf;
  private final HttpClient lq;
  
  a(HttpClient paramHttpClient, HttpRequestBase paramHttpRequestBase)
  {
    this.lq = paramHttpClient;
    this.acf = paramHttpRequestBase;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.acf.addHeader(paramString1, paramString2);
  }
  
  public void v(int paramInt1, int paramInt2)
  {
    HttpParams localHttpParams = this.acf.getParams();
    ConnManagerParams.setTimeout(localHttpParams, paramInt1);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, paramInt1);
    HttpConnectionParams.setSoTimeout(localHttpParams, paramInt2);
  }
  
  public aa xu()
  {
    if (xU() != null)
    {
      x.b(this.acf instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", new Object[] { this.acf.getRequestLine().getMethod() });
      d locald = new d(getContentLength(), xU());
      locald.setContentEncoding(getContentEncoding());
      locald.setContentType(getContentType());
      ((HttpEntityEnclosingRequest)this.acf).setEntity(locald);
    }
    return new b(this.acf, this.lq.execute(this.acf));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */