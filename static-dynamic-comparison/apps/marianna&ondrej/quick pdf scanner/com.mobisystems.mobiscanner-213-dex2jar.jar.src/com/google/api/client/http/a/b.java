package com.google.api.client.http.a;

import com.google.api.client.http.aa;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

final class b
  extends aa
{
  private final HttpRequestBase acf;
  private final HttpResponse acg;
  private final Header[] allHeaders;
  
  b(HttpRequestBase paramHttpRequestBase, HttpResponse paramHttpResponse)
  {
    this.acf = paramHttpRequestBase;
    this.acg = paramHttpResponse;
    this.allHeaders = paramHttpResponse.getAllHeaders();
  }
  
  public void disconnect()
  {
    this.acf.abort();
  }
  
  public String eI(int paramInt)
  {
    return this.allHeaders[paramInt].getName();
  }
  
  public String eJ(int paramInt)
  {
    return this.allHeaders[paramInt].getValue();
  }
  
  public InputStream getContent()
  {
    HttpEntity localHttpEntity = this.acg.getEntity();
    if (localHttpEntity == null) {
      return null;
    }
    return localHttpEntity.getContent();
  }
  
  public String getContentEncoding()
  {
    Object localObject = this.acg.getEntity();
    if (localObject != null)
    {
      localObject = ((HttpEntity)localObject).getContentEncoding();
      if (localObject != null) {
        return ((Header)localObject).getValue();
      }
    }
    return null;
  }
  
  public String getContentType()
  {
    Object localObject = this.acg.getEntity();
    if (localObject != null)
    {
      localObject = ((HttpEntity)localObject).getContentType();
      if (localObject != null) {
        return ((Header)localObject).getValue();
      }
    }
    return null;
  }
  
  public String getReasonPhrase()
  {
    StatusLine localStatusLine = this.acg.getStatusLine();
    if (localStatusLine == null) {
      return null;
    }
    return localStatusLine.getReasonPhrase();
  }
  
  public int getStatusCode()
  {
    StatusLine localStatusLine = this.acg.getStatusLine();
    if (localStatusLine == null) {
      return 0;
    }
    return localStatusLine.getStatusCode();
  }
  
  public String xV()
  {
    StatusLine localStatusLine = this.acg.getStatusLine();
    if (localStatusLine == null) {
      return null;
    }
    return localStatusLine.toString();
  }
  
  public int xW()
  {
    return this.allHeaders.length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */