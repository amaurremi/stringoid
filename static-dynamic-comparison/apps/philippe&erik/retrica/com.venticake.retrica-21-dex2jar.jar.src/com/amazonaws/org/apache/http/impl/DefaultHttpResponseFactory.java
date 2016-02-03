package com.amazonaws.org.apache.http.impl;

import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseFactory;
import com.amazonaws.org.apache.http.ReasonPhraseCatalog;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.message.BasicHttpResponse;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public class DefaultHttpResponseFactory
  implements HttpResponseFactory
{
  protected final ReasonPhraseCatalog reasonCatalog;
  
  public DefaultHttpResponseFactory()
  {
    this(EnglishReasonPhraseCatalog.INSTANCE);
  }
  
  public DefaultHttpResponseFactory(ReasonPhraseCatalog paramReasonPhraseCatalog)
  {
    if (paramReasonPhraseCatalog == null) {
      throw new IllegalArgumentException("Reason phrase catalog must not be null.");
    }
    this.reasonCatalog = paramReasonPhraseCatalog;
  }
  
  protected Locale determineLocale(HttpContext paramHttpContext)
  {
    return Locale.getDefault();
  }
  
  public HttpResponse newHttpResponse(StatusLine paramStatusLine, HttpContext paramHttpContext)
  {
    if (paramStatusLine == null) {
      throw new IllegalArgumentException("Status line may not be null");
    }
    paramHttpContext = determineLocale(paramHttpContext);
    return new BasicHttpResponse(paramStatusLine, this.reasonCatalog, paramHttpContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/DefaultHttpResponseFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */