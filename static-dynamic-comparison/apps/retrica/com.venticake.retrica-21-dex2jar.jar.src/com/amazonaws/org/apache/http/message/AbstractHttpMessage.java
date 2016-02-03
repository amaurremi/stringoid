package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderIterator;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.params.BasicHttpParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractHttpMessage
  implements HttpMessage
{
  protected HeaderGroup headergroup = new HeaderGroup();
  protected HttpParams params;
  
  protected AbstractHttpMessage()
  {
    this(null);
  }
  
  protected AbstractHttpMessage(HttpParams paramHttpParams)
  {
    this.params = paramHttpParams;
  }
  
  public void addHeader(Header paramHeader)
  {
    this.headergroup.addHeader(paramHeader);
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Header name may not be null");
    }
    this.headergroup.addHeader(new BasicHeader(paramString1, paramString2));
  }
  
  public boolean containsHeader(String paramString)
  {
    return this.headergroup.containsHeader(paramString);
  }
  
  public Header[] getAllHeaders()
  {
    return this.headergroup.getAllHeaders();
  }
  
  public Header getFirstHeader(String paramString)
  {
    return this.headergroup.getFirstHeader(paramString);
  }
  
  public Header[] getHeaders(String paramString)
  {
    return this.headergroup.getHeaders(paramString);
  }
  
  public HttpParams getParams()
  {
    if (this.params == null) {
      this.params = new BasicHttpParams();
    }
    return this.params;
  }
  
  public HeaderIterator headerIterator()
  {
    return this.headergroup.iterator();
  }
  
  public HeaderIterator headerIterator(String paramString)
  {
    return this.headergroup.iterator(paramString);
  }
  
  public void removeHeaders(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      HeaderIterator localHeaderIterator = this.headergroup.iterator();
      while (localHeaderIterator.hasNext()) {
        if (paramString.equalsIgnoreCase(localHeaderIterator.nextHeader().getName())) {
          localHeaderIterator.remove();
        }
      }
    }
  }
  
  public void setHeader(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Header name may not be null");
    }
    this.headergroup.updateHeader(new BasicHeader(paramString1, paramString2));
  }
  
  public void setHeaders(Header[] paramArrayOfHeader)
  {
    this.headergroup.setHeaders(paramArrayOfHeader);
  }
  
  public void setParams(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    this.params = paramHttpParams;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/AbstractHttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */