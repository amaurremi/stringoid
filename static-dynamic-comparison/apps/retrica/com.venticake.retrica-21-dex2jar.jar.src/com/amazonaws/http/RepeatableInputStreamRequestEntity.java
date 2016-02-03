package com.amazonaws.http;

import com.amazonaws.Request;
import com.amazonaws.metrics.MetricInputStreamEntity;
import com.amazonaws.metrics.ThroughputMetricType;
import com.amazonaws.metrics.internal.ServiceMetricTypeGuesser;
import com.amazonaws.org.apache.http.entity.BasicHttpEntity;
import com.amazonaws.org.apache.http.entity.InputStreamEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class RepeatableInputStreamRequestEntity
  extends BasicHttpEntity
{
  private static final Log log = LogFactory.getLog(AmazonHttpClient.class);
  private InputStream content;
  private boolean firstAttempt = true;
  private InputStreamEntity inputStreamRequestEntity;
  private IOException originalException;
  
  RepeatableInputStreamRequestEntity(Request<?> paramRequest)
  {
    setChunked(false);
    l1 = -1L;
    try
    {
      str = (String)paramRequest.getHeaders().get("Content-Length");
      if (str == null) {
        break label179;
      }
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str;
        ThroughputMetricType localThroughputMetricType;
        log.warn("Unable to parse content length from request.  Buffering contents in memory.");
        continue;
        this.inputStreamRequestEntity = new MetricInputStreamEntity(localThroughputMetricType, paramRequest.getContent(), l1);
        continue;
        l1 = -1L;
      }
    }
    str = (String)paramRequest.getHeaders().get("Content-Type");
    localThroughputMetricType = ServiceMetricTypeGuesser.guessThroughputMetricType(paramRequest, "UploadThroughput", "UploadByteCount");
    if (localThroughputMetricType == null)
    {
      this.inputStreamRequestEntity = new InputStreamEntity(paramRequest.getContent(), l1);
      this.inputStreamRequestEntity.setContentType(str);
      this.content = paramRequest.getContent();
      setContent(this.content);
      setContentType(str);
      setContentLength(l1);
      return;
    }
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return (this.content.markSupported()) || (this.inputStreamRequestEntity.isRepeatable());
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    try
    {
      if ((!this.firstAttempt) && (isRepeatable())) {
        this.content.reset();
      }
      this.firstAttempt = false;
      this.inputStreamRequestEntity.writeTo(paramOutputStream);
      return;
    }
    catch (IOException paramOutputStream)
    {
      if (this.originalException == null) {
        this.originalException = paramOutputStream;
      }
      throw this.originalException;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/RepeatableInputStreamRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */