package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.ReasonPhraseCatalog;
import com.amazonaws.org.apache.http.StatusLine;
import java.util.Locale;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHttpResponse
  extends AbstractHttpMessage
  implements HttpResponse
{
  private HttpEntity entity;
  private Locale locale;
  private ReasonPhraseCatalog reasonCatalog;
  private StatusLine statusline;
  
  public BasicHttpResponse(StatusLine paramStatusLine, ReasonPhraseCatalog paramReasonPhraseCatalog, Locale paramLocale)
  {
    if (paramStatusLine == null) {
      throw new IllegalArgumentException("Status line may not be null.");
    }
    this.statusline = paramStatusLine;
    this.reasonCatalog = paramReasonPhraseCatalog;
    if (paramLocale != null) {}
    for (;;)
    {
      this.locale = paramLocale;
      return;
      paramLocale = Locale.getDefault();
    }
  }
  
  public HttpEntity getEntity()
  {
    return this.entity;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return this.statusline.getProtocolVersion();
  }
  
  public StatusLine getStatusLine()
  {
    return this.statusline;
  }
  
  public void setEntity(HttpEntity paramHttpEntity)
  {
    this.entity = paramHttpEntity;
  }
  
  public String toString()
  {
    return this.statusline + " " + this.headergroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */